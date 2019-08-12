package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.collection.{AbstractMap, mutable}
import scala.scalanative.cobj.ResultValue
import scala.scalanative.interop.AutoReleasable

/**
 * @see [[https://doc.qt.io/qt-5/qjsonobject.html]]
 */
@Cxx
@include("<QJsonObject>")
@include("<QStringList>")
class QJsonObject extends Value with AutoReleasable {
  def size: Int = extern
  @returnsValue
  def keys()(list: ResultValue[QStringList]): Unit = extern

  def keys: Iterable[String] = QZone{ implicit z =>
    val keylist = QStringList.value
    keylist := keys()
    val _keys = mutable.UnrolledBuffer.empty[String]
    for(i <- 0 until keylist.size)
      _keys += keylist(i)
    _keys
  }

  @returnsValue
  def value(@ref key: QString)(value: ResultValue[QJsonValue]): Unit = extern

  def apply(key: String)(implicit z: Zone): QJsonValue = {
    val k = QString.value
    val v = QJsonValue.value
    k.set(key)
    v := value(k)
    v
  }

  def getString(key: String)(implicit z: Zone): Option[String] = {
    val obj = apply(key)
    if(obj.isString)
      Some(obj.toString)
    else
      None
  }

  def getInt(key: String)(implicit z: Zone): Option[Int] = {
    val obj = apply(key)
    if(obj.isDouble) Some(obj.toInt())
    else None
  }

  def getBoolean(key: String)(implicit z: Zone): Option[Boolean] = {
    val obj = apply(key)
    if(obj.isBool) Some(obj.toBool())
    else None
  }

  def getDouble(key: String)(implicit z: Zone): Option[Double] = {
    val obj = apply(key)
    if(obj.isDouble) Some(obj.toDouble())
    else None
  }

  def getArray(key: String)(implicit z: Zone): Option[QJsonArray] = {
    val obj = apply(key)
    if(obj.isArray) {
      val array = QJsonArray.value
      array := obj.toArray()
      Some(array)
    }
    else None
  }

  def getObject(key: String)(implicit z: Zone): Option[QJsonObject] = {
    val obj = apply(key)
    if(obj.isObject) {
      val o = QJsonObject.value
      o := obj.toObject()
      Some(o)
    }
    else None
  }

  def foreach(f: Function1[(String,QJsonValue),Any]): Unit = QZone{ implicit z =>
    val keyList = QStringList.value
    keyList := keys()
    val k = QString.value
    val v = QJsonValue.value
    for(i <- 0 until keyList.size) {
      k := keyList.at(i)
      v := value(k)
      f((k.toString,v))
    }
  }

  def map[T](f: Function1[(String,QJsonValue),T]): Iterable[T] = {
    val buf = mutable.UnrolledBuffer.empty[Any]
    foreach(p => buf += f(p))
    buf.asInstanceOf[Iterable[T]]
  }

  def collect[T](f: PartialFunction[(String,QJsonValue),T]): Iterable[T] = {
    val buf = mutable.UnrolledBuffer.empty[Any]
    foreach(p => if(f.isDefinedAt(p)) buf += f(p))
    buf.asInstanceOf[Iterable[T]]
  }
    /*
  def mapValues[T](f: QJsonObject=>T): Iterable[T] = QZone{ implicit z =>
    val keyList = QStringList.value
    keyList := keys()
    val key = QString.value
    val buf = mutable.UnrolledBuffer.empty[T]
    keyList.size
  }

     */
  @delete
  override def free(): Unit = extern

  override protected[qt] def initValue(): Unit = {}
}

object QJsonObject extends ValueProvider[QJsonObject] {
  override def value(implicit zone: Zone): QJsonObjectValue = {
    val ptr = unsafe.alloc[Byte](__sizeof)
    val obj = new QJsonObjectValue(ptr)
    obj._isAllocated = false
    obj.initValue()
    obj
  }
}

@Cxx(cxxType = "QJsonObject")
@include("<QJsonObject>")
class QJsonObjectValue extends QJsonObject with ResultValue[QJsonObject] {
  protected[core] var _isAllocated = true
  override def free(): Unit = if(_isAllocated) super.free()
}
object QJsonObjectValue {

}