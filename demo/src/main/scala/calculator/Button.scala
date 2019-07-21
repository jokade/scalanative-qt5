package calculator

import qt.macros.Qt
import qt.widgets.{QSizePolicy, QToolButton}

import scalanative._
import unsafe._
import cxx._

@Qt(cxxType = "QToolButton")
class Button extends QToolButton {
  setSizePolicy(QSizePolicy.Policy.Expanding,QSizePolicy.Policy.Preferred)
}
object Button {
  @constructor("QToolButton")
  def apply(): Button = extern

  def apply(text: CString, onClick: Function0[Unit]): Button = {
    val b = Button()
    b.setText(text)
    b.onClicked(_ => onClick())
    b
  }
}
