package qt.widgets

import de.surfice.smacrotools.debug
import qt.gui.QFont
import qt.macros._

import scala.scalanative._
import unsafe._
import scala.scalanative.cobj.{ResultPtr, ResultValue}
import scala.scalanative.cxx._

/**
 * @see [[https://doc.qt.io/qt-5/qfontdialog.html]]
 */
@Qt
@include("<QFontDialog>")
class QFontDialog extends QDialog {

}

object QFontDialog {
  val __dummy: QFontDialog = null

  @returnsValue
  @cxxBody("*__res = QFontDialog::getFont((bool*)ok,parent);")
  def getFont(ok: Ptr[Boolean], parent: QWidget)(font: ResultValue[QFont]): Unit = extern
  def getFont(parent: QWidget)(font: ResultValue[QFont]): Boolean = {
    val ok = stackalloc[Boolean]
    getFont(ok,parent)(font)
    !ok
  }
}