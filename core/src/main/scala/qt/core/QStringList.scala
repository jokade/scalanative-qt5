package qt.core

import de.surfice.smacrotools.debug

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.{CObject, CObjectWrapper}
import scala.scalanative.interop.AutoReleasable

/**
 * @see [[]]
 */
@Cxx
@include("<QStringList>")
@debug
final class QStringList extends AutoReleasable with CObject {
  def size: CInt = extern
  @cxxBody("return __p->at(idx).toLatin1().data_ptr()->data();")
  def cstring(idx: Int): CString = extern
//  override def append(@ref value: QString): Unit = extern
//  override def at(idx: CInt)(implicit wrapper: CObjectWrapper[QString]): QString = extern
//  override def first()(implicit wrapper: CObjectWrapper[QString]): QString = extern
//  override def last()(implicit wrapper: CObjectWrapper[QString]): QString = extern
//  override def insert(idx: CInt, value: QString): Unit = extern
//  override def removeAt(idx: CInt): Unit = extern
//  override def replace(idx: CInt, value: QString): Unit = extern

  @delete
  override def free(): Unit = extern

  def apply(idx: Int): String = fromCString(cstring(idx))
}

object QStringList {
  @constructor
  def apply(): QStringList = extern
}