package qt.core

import scalanative._
import unsafe._
import cobj._
import scala.scalanative.interop.AutoReleasable

trait QListLike[T<:CObject] extends AutoReleasable with CObject {
  def size: Int
  def append(value: T): Unit
  def at(idx: Int)(implicit wrapper: CObjectWrapper[T]): T
  def first()(implicit wrapper: CObjectWrapper[T]): T
  def last()(implicit wrapper: CObjectWrapper[T]): T
  def insert(idx: Int, value: T): Unit
  def removeAt(idx: Int): Unit
  def replace(idx: Int, value: T): Unit

  @inline final def apply(idx: Int)(implicit wrapper: CObjectWrapper[T]): T = at(idx)
  @inline final def update(idx: Int, value: T): Unit = replace(idx,value)
}
