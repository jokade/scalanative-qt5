package qt.multimedia

import qt.core.{QObject, SignalCallback0, SignalCallback1, SignalCallback2}

import scalanative._
import unsafe._
import cxx._
import qt.macros._
import qt.core.SignalCallback._

import scala.scalanative.runtime.RawPtr

/**
 * @see [[https://doc.qt.io/qt-5/qmediaplaylist.html]]
 */
@Qt
@include("<QMediaPlaylist>")
class QMediaPlaylist extends QObject {

  def onCurrentIndexChanged(cb: SignalCallback1[Int], ctx: RawPtr): Unit = signal
  def onCurrentIndexChanged(cb: Int=>Unit): Unit = onCurrentIndexChanged( fromFunction1(cb), cb.toCtx )

  def onCurrentMediaChanged(cb: SignalCallback1[QMediaContent], ctx: RawPtr): Unit = signal
  def onCurrentMediaChanged(cb: QMediaContent=>Unit): Unit = onCurrentMediaChanged( fromFunction1(cb), cb.toCtx )

  def onLoadFailed(cb: SignalCallback0, ctx: RawPtr): Unit = signal
  def onLoadFailed(cb: ()=>Unit): Unit = onLoadFailed( fromFunction0(cb), cb.toCtx )

  def onLoaded(cb: SignalCallback0, ctx: RawPtr): Unit = signal
  def onLoaded(cb: ()=>Unit): Unit = onLoaded( fromFunction0(cb), cb.toCtx )

  def onMediaAboutToBeInserted(cb: SignalCallback2[CInt,CInt], ctx: RawPtr): Unit = signal
  def onMediaAboutToBeInserted(cb: (CInt,CInt)=>Unit): Unit = onMediaAboutToBeInserted( fromFunction2(cb), cb.toCtx )
  
  def onMediaAboutToBeRemoved(cb: SignalCallback2[CInt,CInt], ctx: RawPtr): Unit = signal
  def onMediaAboutToBeRemoved(cb: (CInt,CInt)=>Unit): Unit = onMediaAboutToBeRemoved( fromFunction2(cb), cb.toCtx )

  def onMediaChanged(cb: SignalCallback2[CInt,CInt], ctx: RawPtr): Unit = signal
  def onMediaChanged(cb: (CInt,CInt)=>Unit): Unit = onMediaChanged( fromFunction2(cb), cb.toCtx )

  def onMediaInserted(cb: SignalCallback2[CInt,CInt], ctx: RawPtr): Unit = signal
  def onMediaInserted(cb: (CInt,CInt)=>Unit): Unit = onMediaInserted( fromFunction2(cb), cb.toCtx )

  def onMediaRemoved(cb: SignalCallback2[CInt,CInt], ctx: RawPtr): Unit = signal
  def onMediaRemoved(cb: (CInt,CInt)=>Unit): Unit = onMediaRemoved( fromFunction2(cb), cb.toCtx )

  def onPlaybackModeChanged(cb: SignalCallback1[QMediaPlaylistPlaybackMode.Value], ctx: RawPtr): Unit = signal
  def onPlaybackModeChanged(cb: QMediaPlaylistPlaybackMode.Value=>Unit): Unit = onPlaybackModeChanged( fromFunction1(cb), cb.toCtx )
}

object QMediaPlaylist {
  @constructor
  def apply(): QMediaPlaylist = extern
}