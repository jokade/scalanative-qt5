package qt.widgets

import de.surfice.smacrotools.debug
import qt.core.QObject
import qt.macros.Qt

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.CEnum



/**
 * @see [[https://doc.qt.io/qt-5/qlayout.html]]
 */
@Qt
@include("<QLayout>")
class QLayout extends QObject {
  def sizeConstraint: SizeConstraint.Value = extern
  def setSizeConstraint(c: SizeConstraint.Value): Unit = extern

  def addWidget(w: QWidget): Unit = extern
}


