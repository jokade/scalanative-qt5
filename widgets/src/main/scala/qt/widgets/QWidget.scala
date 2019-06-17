package qt.widgets

import de.surfice.smacrotools.debug
import qt.macros.Qt
import qt.core.{QObject, QString, QZone}
import qt.gui.QFont

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qwidget.html]]
 */
@Qt
@include("<QWidget>")
class QWidget extends QObject {

  def layout: QLayout = extern
  def setLayout(layout: QLayout): Unit = extern

  def setSizePolicy(horizontal: QSizePolicy.Policy.Value, vertical: QSizePolicy.Policy.Value): Unit = extern

  def setWindowTitle(@ref title: QString): Unit = extern
  def setWindowTitle(title: String): Unit = QZone{ implicit z =>
    val s = QString(title)
    setWindowTitle(s)
    s.free()
  }

  @returnsRef
  def font: QFont = extern
  def setFont(@ref font: QFont): Unit = extern

  def show(): Unit = extern

}

object QWidget {
  @constructor
  def apply(): QWidget = extern
}
