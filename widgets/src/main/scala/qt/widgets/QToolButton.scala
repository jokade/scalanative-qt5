package qt.widgets

import qt.core.QString

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qtoolbutton.html]]
 */
@Qt
@include("<QToolButton>")
class QToolButton extends QAbstractButton {
}

object QToolButton {
  @constructor
  def apply(): QToolButton = extern
}