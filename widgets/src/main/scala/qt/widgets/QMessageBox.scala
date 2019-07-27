package qt.widgets

import qt.core.{QString, QZone}

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qmessagebox.html]]
 */
@Qt
@include("<QMessageBox>")
class QMessageBox extends QDialog {

}

object QMessageBox {
  val __dummy: QMessageBox = null

  def warning(parent: QWidget, @ref title: QString, @ref text: QString): StandardButton.Value = extern
  def warning(parent: QWidget, title: String, text: String): StandardButton.Value = QZone{ implicit z =>
    val _title = QString.value
    val _text = QString.value
    _title.set(title)
    _text.set(text)
    warning(parent,_title,_text)
  }
}