package qt.multimediawidgets

import qt.core.SignalCallback._
import qt.core.SignalCallback1
import qt.macros._
import qt.multimedia.QVideoWidgetLike
import qt.widgets.QWidget

import scala.scalanative._
import scala.scalanative.cxx._
import scala.scalanative.runtime.RawPtr
import scala.scalanative.unsafe._

/**
 * @see [[https://doc.qt.io/qt-5/qvideowidget.html]]
 */
@Qt
@include("<QVideoWidget>")
class QVideoWidget extends QWidget with QVideoWidgetLike {

  def brightness: Int = extern
  def setBrightness(b: Int): Unit = extern

  def contrast: Int = extern
  def setContrast(c: Int): Unit = extern

  def hue: Int = extern
  def setHue(h: Int): Unit = extern

  def saturation: Int = extern
  def setSaturation(s: Int): Unit = extern
  
  def isFullScreen: Boolean = extern
  def setFullScreen(f: Boolean): Unit = extern
  
  def onFullScreenChanged(cb: SignalCallback1[CBool], ctx: RawPtr): Unit = signal
  def onFullScreenChanged(cb: CBool=>Unit): Unit = onFullScreenChanged( fromFunction1(cb), cb.toCtx )
}

object QVideoWidget {
  @constructor
  def apply(): QVideoWidget = extern
  @constructor
  def apply(parent: QWidget): QVideoWidget = extern
}