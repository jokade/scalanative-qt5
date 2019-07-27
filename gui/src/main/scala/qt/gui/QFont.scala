package qt.gui

import qt.core.QString

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.ResultValue
import scala.scalanative.interop.AutoReleasable

/**
 * @see [[https://doc.qt.io/qt-5/qfont.html]]
 */
@Qt
@include("<QFont>")
class QFont extends CxxObject with AutoReleasable {

  def pointSize: Int = extern
  def setPointSize(ps: Int): Unit = extern

  def pixelSize: Int = extern
  def setPixelSize(ps: Int): Unit = extern

  def bold: Boolean = extern
  def setBold(bold: Boolean): Unit = extern

  def italic: Boolean = extern
  def setItalic(italic: Boolean): Unit = extern

  def underline: Boolean = extern
  def setUnderline(underline: Boolean): Unit = extern

  def overline: Boolean = extern
  def setOverline(overline: Boolean): Unit = extern

  def weight: Int = extern
  def setWeight(weight: Int): Unit = extern

  def styleName()(s: ResultValue[QString]): Unit = extern
  def setStyleName(@ref name: QString): Unit = extern

  def family()(s: ResultValue[QString]): Unit = extern
  def setFamily(@ref family: QString): Unit = extern

  def key()(s: ResultValue[QString]): Unit = extern

  @delete
  def free(): Unit = extern
}

object QFont {
}

@Cxx(cxxType = "QFont")
@include("<QFont>")
class QFontValue extends QFont with ResultValue[QFont] {

}
object QFontValue {
  @constructor("QFont")
  def apply(): QFontValue = extern
}