package qt.core

import de.surfice.smacrotools.debug

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.{CObject, CObjectWrapper, ResultValue}
import scala.scalanative.interop.AutoReleasable

/**
 * @see [[]]
 */
@Cxx
@include("<QStringList>")
class QStringList extends Value with AutoReleasable {
  def size: CInt = extern
  @cxxBody("return __p->at(idx).toLatin1().data_ptr()->data();")
  def cstring(idx: Int): CString = extern

  @returnsValue
  def at(idx: Int)(qstr: ResultValue[QString]): Unit = extern
  @cxxBody("__p->append(*s);")
  def append(s: CString): Unit = extern
//  override def append(@ref value: QString): Unit = extern
//  override def at(idx: CInt)(implicit wrapper: CObjectWrapper[QString]): QString = extern
//  override def first()(implicit wrapper: CObjectWrapper[QString]): QString = extern
//  override def last()(implicit wrapper: CObjectWrapper[QString]): QString = extern
//  override def insert(idx: CInt, value: QString): Unit = extern
//  override def removeAt(idx: CInt): Unit = extern
//  override def replace(idx: CInt, value: QString): Unit = extern

  @delete
  def free(): Unit = extern

  def apply(idx: Int): String = fromCString(cstring(idx))

  @cxxBody("*(size_t*)__p = (size_t)(&QListData::shared_null);")
  protected[qt] def initValue(): Unit = extern
}

object QStringList extends ValueProvider[QStringList] {
  @constructor
  def apply(): QStringList = extern

  def value(implicit z: Zone): QStringListValue = {
    val ptr = unsafe.alloc[Byte](__sizeof)
    val s = new QStringListValue(ptr)
    s._isAllocated = false
    s.initValue()
    s
  }
}

@Cxx(cxxType = "QStringList")
class QStringListValue extends QStringList with ResultValue[QStringList] {
  protected[core] var _isAllocated = true

  override def free(): Unit = if(_isAllocated) super.free()
}
object QStringListValue {
  @constructor("QStringList")
  def apply(): QStringListValue = extern
}