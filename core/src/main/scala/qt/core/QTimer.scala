package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.runtime.RawPtr
import SignalCallback._

/**
 * @see [[https://doc.qt.io/qt-5/qtimer.html]]
 */
@Qt
@include("<QTimer>")
class QTimer extends QObject {

  def isActive: Boolean = extern
  def interval: Int = extern
  def isSingleShot: Boolean = extern
  def remainingTime: Int = extern

  def onTimeout(cb: SignalCallback0, ctx: RawPtr): Unit = signal
  def onTimeout(cb: ()=>Unit): Unit = onTimeout( fromFunction0(cb), cb.toCtx )

  def start(): Unit = extern
  def stop(): Unit = extern
}

object QTimer {
  @constructor
  def apply(): QTimer = extern
}