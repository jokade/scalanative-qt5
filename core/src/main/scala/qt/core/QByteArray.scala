package qt.core

import de.surfice.smacrotools.debug
import qt.macros.Qt

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.cobj.ResultValue
import scala.scalanative.interop.AutoReleasable

/**
 * @see [[]]
 */
@Cxx
@include("<QByteArray>")
class QByteArray extends Value with AutoReleasable {

  def count: Int = extern
  def data(): CString = extern

  @delete
  def free(): Unit = extern

  @cxxBody("*(size_t*)__p = (size_t)QArrayData::shared_null;")
  protected[qt] def initValue(): Unit = extern
}

object QByteArray extends ValueProvider[QByteArray] {
  @constructor
  def apply(): QByteArray = extern

  def value(implicit zone: Zone): QByteArrayValue = {
    val ptr = unsafe.alloc[Byte](__sizeof)
    val b = new QByteArrayValue(ptr)
    b._isAllocated = false
    b.initValue()
    b
  }
}

@Cxx(cxxType = "QByteArray")
@include("<QByteArray>")
class QByteArrayValue extends QByteArray with ResultValue[QByteArray] {
  protected[core] var _isAllocated = true
  override def free(): Unit = if(_isAllocated) super.free()
}

object QByteArrayValue {
  @constructor("QByteArray")
  protected def newInstance(): QByteArrayValue = extern

  def apply(): QByteArrayValue = {
    val b = newInstance()
    b.initValue()
    b
  }
}