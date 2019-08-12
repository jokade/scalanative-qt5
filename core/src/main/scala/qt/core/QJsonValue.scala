package qt.core

import qt.core.QJsonArray.QJsonSeq

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.ResultValue
import scala.scalanative.interop.AutoReleasable

/**
 * @see [[https://doc.qt.io/qt-5/qjsonvalue.html]]
 */
@Qt
@include("<QJsonValue>")
@include("<QJsonArray>")
@include("<QJsonObject>")
class QJsonValue extends Value with AutoReleasable {
  def isArray: Boolean = extern
  def isBool: Boolean = extern
  def isDouble: Boolean = extern
  def isNull: Boolean = extern
  def isObject: Boolean = extern
  def isString: Boolean = extern
  def isUndefined: Boolean = extern

  def toBool(): Boolean = extern
  def toDouble(): Double = extern
  def toInt(): Int = extern

  @cxxBody("*(QJsonArray*)arr = __p->toArray();")
  private def getArray(arr: Ptr[Byte]): Unit = extern

  @inline final def toArray()(arr: ResultValue[QJsonArray]): Unit = getArray(arr.__ptr)

  def asArray(implicit z: Zone): Option[QJsonArray] =
    if(isArray) Some{
      val array = QJsonArray.value
      array := toArray()
      array
    }
    else None

  @cxxBody("*(QJsonObject*)obj = __p->toObject();")
  private def getObject(obj: Ptr[Byte]): Unit = extern

  @inline final def toObject()(obj: ResultValue[QJsonObject]): Unit = getObject(obj.__ptr)

  def asObject(implicit z: Zone): Option[QJsonObject] =
    if(isObject) Some{
      val obj = QJsonObject.value
      obj := toObject()
      obj
    }
    else None

  @returnsValue
  @cxxName("toString")
  def toQString()(str: ResultValue[QString]): Unit = extern

  override def toString: String =
    if(isString) QZone{ implicit z =>
      val s = QString.value
      s := toQString()
      s.utf8String
    }
    else super.toString

  override protected[qt] def initValue(): Unit = {}

  @delete
  override def free(): Unit = extern
}

object QJsonValue extends ValueProvider[QJsonValue] {
  override def value(implicit zone: Zone): QJsonValueValue = {
    val ptr = unsafe.alloc[Byte](__sizeof)
    val v = new QJsonValueValue(ptr)
    v._isAllocated = false
    v.initValue()
    v
  }
}

@Cxx(cxxType = "QJsonValue")
@include("<QJsonValue>")
class QJsonValueValue extends QJsonValue with ResultValue[QJsonValue] {
  protected[core] var _isAllocated = true
  override def free(): Unit = if(_isAllocated) super.free()
}
object QJsonValueValue {

}
