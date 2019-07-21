package qt.widgets

import de.surfice.smacrotools.debug
import qt.core.{QObject, SignalCallback, SignalCallback1}

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.runtime.RawPtr

/**
 * @see [[https://doc.qt.io/qt-5/qaction.html]]
 */
@Qt
@include("<QAction>")
class QAction extends QObject {
  import SignalCallback._

  @cxxBody("return __p->text().toLatin1().data_ptr()->data();")
  def textCString(): CString = extern
  def text: String = fromCString(textCString())

  def onTriggered(cb: SignalCallback1[Boolean], ctx: RawPtr): Unit = signal
  def onTriggered(cb: Function1[Boolean,Unit]): Unit = onTriggered( fromFunction1(cb), cb.toCtx )
}

object QAction {
}