package qt.widgets

import de.surfice.smacrotools.debug
import qt.core.{SignalCallback0, SignalCallback1}
import qt.core.SignalCallback._
import qt.macros.Qt

import scalanative._
import cxx._
import qt.macros._

import scala.scalanative.runtime.{Intrinsics, RawPtr}

/**
 * @see [[https://doc.qt.io/qt-5/qabstractbutton.html]]
 */
@Qt
@include("<QAbstractButton>")
class QAbstractButton extends QWidget {

//  def text: QString = extern
//  def setText(text: QString): Unit = extern


  // SIGNALS

  def onPressed(cb: SignalCallback0, ctx: RawPtr): Unit = signal
  def onPressed(cb: Function0[Unit]): Unit = onPressed( fromFunction0(cb), cb.toCtx )

  def onReleased(cb: SignalCallback0, ctx: RawPtr): Unit = signal
  def onReleased(cb: Function0[Unit]): Unit = onReleased( fromFunction0(cb), cb.toCtx )

  def onClicked(cb: SignalCallback1[Boolean], ctx: RawPtr): Unit = signal
  def onClicked(cb: Function1[Boolean,Unit]): Unit = onClicked( fromFunction1(cb), cb.toCtx )

  def onToggled(cb: SignalCallback1[Boolean], ctx: RawPtr): Unit = signal
  def onToggled(cb: Function1[Boolean,Unit]): Unit = onToggled( fromFunction1(cb), cb.toCtx )
}


