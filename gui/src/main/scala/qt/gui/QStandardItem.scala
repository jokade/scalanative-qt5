package qt.gui

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.interop.AutoReleasable

/**
 * @see [[]]
 */
@Qt
@include("<QStandardItem>")
class QStandardItem extends CxxObject with AutoReleasable {
  @delete
  override def free(): Unit = extern
}

object QStandardItem {
}