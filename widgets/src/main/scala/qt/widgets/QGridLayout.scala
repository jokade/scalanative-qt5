package qt.widgets

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qgridlayout.html]]
 */
@Qt
@include("<QGridLayout>")
class QGridLayout extends QLayout {
  def addWidget(widget: QWidget, row: Int, column: Int): Unit = extern
  def addWidget(widget: QWidget, row: Int, column: Int, rowSpan: Int, columnSpan: Int): Unit = extern
}

object QGridLayout {
  @constructor
  def apply(): QGridLayout = extern
}