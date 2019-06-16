package qt.widgets

import de.surfice.smacrotools.debug
import qt.macros.Qt

import scalanative._
import unsafe._
import cxx._
import qt5.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qpushbutton.html]]
 */
@Qt
@include("<QPushButton>")
class QPushButton extends QAbstractButton {

}

object QPushButton {
  @constructor
  def apply(text: CString): QPushButton = extern
}