package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.interop.AutoReleasable

/**
 * @see [[https://doc.qt.io/qt-5/qvariant.html]]
 */
@Qt
@include("<QVariant>")
class QVariant extends Value with AutoReleasable {
  override protected[qt] def initValue(): Unit = {}

  def clear(): Unit = extern

  def setValue(i: Int): Unit = extern
  def setValue(l: Long): Unit = extern
  def setValue(b: Boolean): Unit = extern
  def setValue(f: Float): Unit = extern
  def setValue(d: Double): Unit = extern
  def setValue(@ref s: QString): Unit = extern

  def setValue(s: String): Unit = QString.withValue(s)(setValue)

  @delete
  override def free(): Unit = extern
}

object QVariant {

  @constructor
  def apply(): QVariant = extern
}