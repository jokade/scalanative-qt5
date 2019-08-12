package qt.core

import scala.scalanative._
import scala.scalanative.annotation.InlineSource
import scala.scalanative.cobj.{ResultValue, returnsThis}
import scala.scalanative.cxx._
import scala.scalanative.interop.AutoReleasable
import scala.scalanative.runtime.Intrinsics
import scala.scalanative.unsafe._


/**
 * @see [[https://doc.qt.io/qt-5/qstring.html]]
 */
@Cxx
@include("<QString>")
class QString extends Value {
  def size: Int = extern
  def clear(): Unit = extern

  def isEmpty: Boolean = extern

  @returnsValue
  def toLatin1()(implicit value: ResultValue[QByteArray]): Unit = extern
  @returnsValue
  def toUtf8()(implicit value: ResultValue[QByteArray]): Unit = extern

  @cxxBody("return __p->toLatin1().data_ptr()->data();")
  protected def toLatin1CString(): CString = extern
  @cxxBody("return __p->toUtf8().data_ptr()->data();")
  protected def toUtf8CString(): CString = extern

  def latin1String: String = fromCString(toLatin1CString())
  def utf8String: String = fromCString(toUtf8CString())

  override def toString: String = latin1String

  @delete
  def free(): Unit = extern

  @cxxBody("*(size_t*)__p = (size_t)QStringData::shared_null;")
  protected[qt] def initValue(): Unit = extern

  @cxxBody("*__p = cstr;")
  def set(cstr: CString): Unit = extern

  def set(s: String)(implicit z: Zone): Unit = set(toCString(s))
}

object QString extends ValueProvider[QString] {

  @constructor
  def apply(): QString = extern
  @constructor
  def apply(s: CString): QString = extern

  def apply(s: String)(implicit z: Zone): QString = apply(toCString(s))

  def withValue[T](f: QStringValue=>T): T = {
    val ptr = unsafe.stackalloc[Byte](__sizeof)
    val s = new QStringValue(ptr)
    s._isAllocated = false
    f(s)
  }

  def value(implicit z: Zone): QStringValue = {
    val ptr = unsafe.alloc[Byte](__sizeof)
    val s = new QStringValue(ptr)
    s._isAllocated = false
    s.initValue()
    s
  }

  def value(f: Function1[ResultValue[QString],_])(implicit z: Zone): QStringValue = {
    val s = value
    s := f
    s
  }
}

@Cxx(cxxType = "QString")
class QStringValue extends QString with ResultValue[QString] {
  protected[core] var _isAllocated = true
  override def free(): Unit = if(_isAllocated) super.free()

//  @inline final def :=(value: String)(implicit zone: Zone): Unit = this.set(value)
//  @inline final def :=(value: CString): Unit = this.set(value)
}
object QStringValue {
  @constructor("QString")
  protected def newInstance(): QStringValue = extern

  def apply(): QStringValue = {
    val s = newInstance()
    s.initValue()
    s
  }
}

