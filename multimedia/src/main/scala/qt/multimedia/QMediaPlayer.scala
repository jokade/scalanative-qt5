package qt.multimedia

import de.surfice.smacrotools.debug
import qt.core.{QIODevice, QList, QObject, QString, QUrl, SignalCallback1, qint64, qreal}

import scalanative._
import unsafe._
import cxx._
import qt.macros._
import qt.core.SignalCallback._

import scala.scalanative.cobj.ResultValue
import scala.scalanative.runtime.RawPtr

/**
 * @see [[https://doc.qt.io/qt-5/qmediaplayer.html]]
 */
@Qt
@include("<QMediaPlayer>")
class QMediaPlayer extends QMediaObject {
  def audioRole: QAudioRole.Value = extern
  def setAudioRole(role: QAudioRole.Value): Unit = extern

  def bufferStatus: Int = extern

  @returnsValue
  def currentMedia()(c: ResultValue[QMediaContent]): Unit = extern

  @returnsValue
  def customAudioRole()(c: ResultValue[QString]): Unit = extern
  def setCustomAudioRole(@ref role: QString): Unit = extern

  def duration: qint64 = extern

  def error: QMediaPlayerError.Value = extern

  @returnsValue
  def errorString()(s: ResultValue[QString]): Unit = extern

  def isAudioAvailable: Boolean = extern

  def isMuted: Boolean = extern
  def setMuted(muted: Boolean): Unit = extern

  def isSeekable: Boolean = extern
  def isVideoAvailable: Boolean = extern

  @returnsValue
  def media()(c: ResultValue[QMediaContent]): Unit = extern
  def setMedia(@ref url: QUrl): Unit = extern

  def mediaStatus: QMediaPlayerMediaStatus.Value = extern

  @returnsConst
  def mediaStream: QIODevice = extern

  def playbackRate: qreal = extern
  def setPlaybackRate(rate: qreal): Unit = extern

  def playlist: QMediaPlaylist = extern
  def setPlaylist(plist: QMediaPlaylist): Unit = extern

  def position: qint64 = extern
  def setPosition(pos: qint64): Unit = extern

  def state: QMediaPlayerState.Value = extern

  def volume: Int = extern
  def setVolume(vol: Int): Unit = extern

  def play(): Unit = extern
  def pause(): Unit = extern
  def stop(): Unit = extern

  def setVideoOutput(widget: QVideoWidgetLike): Unit = extern

//  def supportedAudioRoles()(roles: ResultValue[QList[QAudioRole.Value]]) = extern

  def onAudioAvailableChanged(cb: SignalCallback1[Boolean], ctx: RawPtr): Unit = signal
  def onAudioAvailableChanged(cb: Boolean=>Unit): Unit = onAudioAvailableChanged(fromFunction1(cb), cb.toCtx)

  def onAudioRoleChanged(cb: SignalCallback1[QAudioRole.Value], ctx: RawPtr): Unit = signal
  def onAudioRoleChanged(cb: QAudioRole.Value=>Unit): Unit = onAudioRoleChanged( fromFunction1(cb), cb.toCtx )

  def onBufferStatusChanged(cb: SignalCallback1[Int], ctx: RawPtr): Unit = signal
  def onBufferStatusChanged(cb: Int=>Unit): Unit = onBufferStatusChanged( fromFunction1(cb), cb.toCtx )

  def onCurrentMediaChanged(cb: SignalCallback1[QMediaContent], ctx: RawPtr): Unit = signal
  def onCurrentMediaChanged(cb: QMediaContent=>Unit): Unit = onCurrentMediaChanged( fromFunction1(cb), cb.toCtx )

  def onCustomAudioRoleChanged(cb: SignalCallback1[QString], ctx: RawPtr): Unit = signal
  def onCustomAudioRoleChanged(cb: QString=>Unit): Unit = onCustomAudioRoleChanged( fromFunction1(cb), cb.toCtx )

  def onDurationChanged(cb: SignalCallback1[qint64], ctx: RawPtr): Unit = signal
  def onDurationChanged(cb: qint64=>Unit): Unit = onDurationChanged(fromFunction1(cb), cb.toCtx)

//  def onError(cb: SignalCallback1[QMediaPlayerError.Value], ctx: RawPtr): Unit = signal
//  def onError(cb: QMediaPlayerError.Value=>Unit): Unit = onError( fromFunction1(cb), cb.toCtx )

  def onMediaChanged(cb: SignalCallback1[QMediaContent], ctx: RawPtr): Unit = signal
  def onMediaChanged(cb: QMediaContent=>Unit): Unit = onMediaChanged( fromFunction1(cb), cb.toCtx )

  def onMediaStatusChanged(cb: SignalCallback1[QMediaPlayerMediaStatus.Value], ctx: RawPtr): Unit = signal
  def onMediaStatusChanged(cb: QMediaPlayerMediaStatus.Value=>Unit): Unit = onMediaStatusChanged( fromFunction1(cb), cb.toCtx )

  def onMutedChanged(cb: SignalCallback1[CBool], ctx: RawPtr): Unit = signal
  def onMutedChanged(cb: CBool=>Unit): Unit = onMutedChanged( fromFunction1(cb), cb.toCtx )
  
  def onPlaybackRateChanged(cb: SignalCallback1[qreal], ctx: RawPtr): Unit = signal
  def onPlaybackRateChanged(cb: qreal=>Unit): Unit = onPlaybackRateChanged( fromFunction1(cb), cb.toCtx )
  
  def onPositionChanged(cb: SignalCallback1[qint64], ctx: RawPtr): Unit = signal
  def onPositionChanged(cb: qint64=>Unit): Unit = onPositionChanged( fromFunction1(cb), cb.toCtx )

  def onSeekableChanged(cb: SignalCallback1[Boolean], ctx: RawPtr): Unit = signal
  def onSeekableChanged(cb: Boolean=>Unit): Unit = onSeekableChanged( fromFunction1(cb), cb.toCtx )
  
  def onStateChanged(cb: SignalCallback1[QMediaPlayerState.Value], ctx: RawPtr): Unit = signal
  def onStateChanged(cb: QMediaPlayerState.Value=>Unit): Unit = onStateChanged( fromFunction1(cb), cb.toCtx )
  
  def onVideoAvailableChanged(cb: SignalCallback1[CBool], ctx: RawPtr): Unit = signal
  def onVideoAvailableChanged(cb: CBool=>Unit): Unit = onVideoAvailableChanged( fromFunction1(cb), cb.toCtx )
  
  def onVolumeChanged(cb: SignalCallback1[Int], ctx: RawPtr): Unit = signal
  def onVolumeChanged(cb: Int=>Unit): Unit = onVolumeChanged( fromFunction1(cb), cb.toCtx )
}

object QMediaPlayer {
  @constructor
  def apply(): QMediaPlayer = extern
  @constructor
  def apply(parent: QObject): QMediaPlayer = extern
  @constructor
  def apply(parent: QObject, flags: QMediaPlayerFlags.Value): QMediaPlayer = extern
}


