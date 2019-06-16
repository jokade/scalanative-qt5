package qt.gui

import de.surfice.smacrotools.debug
import qt.core.QObject

import scalanative._
import unsafe._
import cxx._

/**
 * @see [[https://doc.qt.io/qt-5/qwindow.html]]
 */
@Cxx
@include("<QWindow>")
class QWindow extends QObject {
  def show(): Unit = extern
}

object QWindow {
  @constructor
  def apply(): QWindow = extern
}
