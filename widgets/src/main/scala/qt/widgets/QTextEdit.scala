package qt.widgets

import qt.core.QString

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.ResultValue

/**
 * @see [[https://doc.qt.io/qt-5/qtextedit.html]]
 */
@Qt
@include("<QTextEdit>")
class QTextEdit extends QAbstractScrollArea {
  def clear(): Unit = extern
  def copy(): Unit = extern
  def cut(): Unit = extern
  def paste(): Unit = extern
  def redo(): Unit = extern
  def undo(): Unit = extern

  def setText(@ref text: QString): Unit = extern

  @returnsValue
  def toHtml()(s: ResultValue[QString]): Unit = extern
  @returnsValue
  def toPlainText()(s: ResultValue[QString]): Unit = extern
}

object QTextEdit {
  @constructor
  def apply(): QTextEdit = extern
}