package qt.widgets

import de.surfice.smacrotools.debug
import qt.core.QtDockWidgetArea
import qt.macros.Qt

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qmainwindow.html]]
 */
@Qt
@include("<QMainWindow>")
class QMainWindow extends QWidget {

  def centralWidget: QWidget = extern
  def setCentralWidget(w: QWidget): Unit = extern

  def addDockWidget(area: QtDockWidgetArea.Value, dockWidget: QDockWidget): Unit = extern
}

object QMainWindow {
  @constructor
  def apply(): QMainWindow = extern
}
