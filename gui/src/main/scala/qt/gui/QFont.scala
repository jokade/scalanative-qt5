package qt.gui

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qfont.html]]
 */
@Qt
@include("<QFont>")
class QFont {

  def pointSize: Int = extern
  def setPointSize(ps: Int): Unit = extern
}
