package qt.widgets

import de.surfice.smacrotools.debug
import qt.core.QString

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.{CObjectWrapper, ResultValue}

/**
 * @see [[https://doc.qt.io/qt-5/qfiledialog.html]]
 */
@Qt
@include("<QFileDialog>")
class QFileDialog extends QDialog {
}

object QFileDialog {
  val __hook = new QFileDialog(null)
  @returnsValue
  def getOpenFileName(parent: QWidget, @ref caption: QString)(implicit v: ResultValue[QString]): Unit = extern

  def getOpenFileName(parent: QWidget, caption: CString): String = {
    val s = QString(c"")
    getOpenFileName(parent,QString(caption))(ResultValue(s))
    s.toString
  }
}