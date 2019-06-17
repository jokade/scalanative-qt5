package qt.widgets

import de.surfice.smacrotools.debug
import qt.core.{QString, QZone, QtAlignment}

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qlineedit.html]]
 */
@Qt
@include("<QLineEdit>")
class QLineEdit extends QWidget {

  def alignment: QtAlignment.Value = extern
  def setAlignment(f: QtAlignment.Value): Unit = extern

  def maxLength: Int = extern
  def setMaxLength(maxLength: Int): Unit = extern

  def isReadOnly: Boolean = extern
  def setReadOnly(f: Boolean): Unit = extern

  def clear(): Unit = extern

  def setText(@ref text: QString): Unit = extern
  def setText(text: String): Unit = QZone{ implicit z =>
    val s = QString(text)
    setText(s)
    s.free()
  }
}

object QLineEdit {
  @constructor
  def apply(contents: CString): QLineEdit = extern
}