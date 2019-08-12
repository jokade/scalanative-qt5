package qt.core

import qt.core.QJsonArray.QJsonSeq

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.collection.{AbstractSeq, mutable}
import scala.scalanative.cobj.ResultValue
import scala.scalanative.interop.AutoReleasable

/**
 * @see [[https://doc.qt.io/qt-5/qjsonarray.html]]
 */
@Qt
@include("<QJsonArray>")
class QJsonArray extends Value with AutoReleasable {

  def size: Int = extern

  @returnsValue
  def at(idx: Int)(value: ResultValue[QJsonValue]): Unit = extern

  def apply(idx: Int)(implicit z: Zone): QJsonValue = {
    val v = QJsonValue.value
    v := at(idx)
    v
  }

  def getString(idx: Int)(implicit z: Zone): Option[String] = {
    val obj = apply(idx)
    if(obj.isString)
      Some(obj.toString)
    else
      None
  }

  def getInt(idx: Int)(implicit z: Zone): Option[Int] = {
    val obj = apply(idx)
    if(obj.isDouble) Some(obj.toInt())
    else None
  }

  def getBoolean(idx: Int)(implicit z: Zone): Option[Boolean] = {
    val obj = apply(idx)
    if(obj.isBool) Some(obj.toBool())
    else None
  }

  def getDouble(idx: Int)(implicit z: Zone): Option[Double] = {
    val obj = apply(idx)
    if(obj.isDouble) Some(obj.toDouble())
    else None
  }

  def getArray(idx: Int)(implicit z: Zone): Option[QJsonArray] = {
    val obj = apply(idx)
    if(obj.isArray) {
      val array = QJsonArray.value
      array := obj.toArray()
      Some(array)
    }
    else None
  }

  def getObject(idx: Int)(implicit z: Zone): Option[QJsonObject] = {
    val obj = apply(idx)
    if(obj.isObject) {
      val o = QJsonObject.value
      o := obj.toObject()
      Some(o)
    }
    else None
  }

  override protected[qt] def initValue(): Unit = {}

  def foreach(f: QJsonValue=>Any): Unit = QZone{ implicit z =>
    val v = QJsonValue.value
    for(i <- 0 until size) {
      v := at(i)
      f(v)
    }
  }

  def map[T](f: QJsonValue=>T): Seq[T] = {
    val _size = size
    val s = new mutable.ArrayBuffer[Any](_size)
    foreach(value => s += f(value)  )
    s.asInstanceOf[Seq[T]]
  }

  def toValueSeq(implicit z: Zone): QJsonSeq = new QJsonSeq(this,QJsonValue.value)

  @delete
  override def free(): Unit = extern
}

object QJsonArray extends ValueProvider[QJsonArray] {
  override def value(implicit zone: Zone): QJsonArrayValue = {
    val ptr = unsafe.alloc[Byte](__sizeof)
    val a = new QJsonArrayValue(ptr)
    a._isAllocated = false
    a.initValue()
    a
  }

  class QJsonSeq(array: QJsonArray, value: QJsonValueValue) extends AbstractSeq[QJsonValue] with IndexedSeq[QJsonValue] {
    override def length: CInt = array.size
    override def apply(idx: CInt): QJsonValue = {
      value := array.at(idx)
      value
    }
  }
}

@Cxx(cxxType = "QJsonArray")
@include("<QJsonArray>")
class QJsonArrayValue extends QJsonArray with ResultValue[QJsonArray] {
  protected[core] var _isAllocated = true
  override def free(): Unit = if(_isAllocated) super.free()
}