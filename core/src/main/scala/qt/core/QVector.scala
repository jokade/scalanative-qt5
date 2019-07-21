package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.{CObject, CObjectWrapper}

/**
 * @see [[https://doc.qt.io/qt-5/qvector.html]]
 */
@Cxx
@include("<QVector>")
final class QVector[T<:CObject] extends QListLike[T] {
  def size: CInt = extern
  def append(value: T): Unit = extern
  def at(idx: CInt)(implicit wrapper: CObjectWrapper[T]): T = extern
  def first()(implicit wrapper: CObjectWrapper[T]): T = extern
  def last()(implicit wrapper: CObjectWrapper[T]): T = extern
  def insert(idx: CInt, value: T): Unit = extern
  def removeAt(idx: CInt): Unit = extern
  def replace(idx: CInt, value: T): Unit = extern
  def free(): Unit = extern
}

object QVector {
  @constructor
  def apply[T<:CObject](): QVector[T] = extern
}