package qt.widgets

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qdockwidget.html]]
 */
@Qt
@include("<QDockWidget>")
class QDockWidget extends QWidget {
  def isFloating: Boolean = extern
  def setFloating(floating: Boolean): Unit = extern

  def features: DockWidgetFeatures.Value = extern
  def setFeatures(features: DockWidgetFeatures.Value): Unit = extern
}

object QDockWidget {
  @constructor
  def apply(): QDockWidget = extern
  @constructor
  def apply(title: CString): QDockWidget = extern
}