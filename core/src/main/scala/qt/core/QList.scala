package qt.core

import de.surfice.smacrotools.debug

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.{CObject, CObjectWrapper}
import scala.scalanative.interop.AutoReleasable

/**
 * @see [[https://doc.qt.io/qt-5/qlist.html]]
 */
@Cxx(classname = "QList<void *>")
@include("<QList>")
final class QList[T<:CObject] extends QListLike[T] {
  def size: Int = extern
  def append(value: T): Unit = extern
  def at(idx: Int)(implicit wrapper: CObjectWrapper[T]): T = extern
  def first()(implicit wrapper: CObjectWrapper[T]): T = extern
  def last()(implicit wrapper: CObjectWrapper[T]): T = extern
  def insert(idx: Int, value: T): Unit = extern
  def removeAt(idx: CInt): Unit = extern
  def replace(idx: Int, value: T): Unit = extern

  @delete
  override def free(): Unit = extern

  @cxxBody("*(size_t*)__p = (size_t)(&QListData::shared_null);")
  protected def initValue(): Unit = extern
}

object QList {
  @constructor
  def apply[T<:CObject](): QList[T] = extern
}