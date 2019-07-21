package qt.widgets

import qt.core.QString

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qtabwidget.html]]
 */
@Qt
@include("<QTabWidget>")
class QTabWidget extends QWidget {
  def addTab(page: QWidget, @ref label: QString): Int = extern

  def clear(): Unit = extern
  def count: Int = extern
  def currentIndex: Int = extern
  def currentWidget: QWidget = extern

  def documentMode: Boolean = extern
  def setDocumentMode(set: Boolean): Unit = extern

  def indexOf(widget: QWidget): Int = extern
}

object QTabWidget {
  @constructor
  def apply(): QTabWidget = extern
}