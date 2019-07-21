package qt.widgets

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qmdisubwindow.html]]
 */
@Qt
@include("<QMdiSubWindow>")
class QMdiSubWindow extends QWidget {

}

object QMdiSubWindow {
  @constructor
  def apply(): QMdiSubWindow = extern
}