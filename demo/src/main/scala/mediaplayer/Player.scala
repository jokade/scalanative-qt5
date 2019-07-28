package mediaplayer

import qt.core.{QString, QUrl, qint64}
import qt.macros.Qt
import qt.multimedia.{QAudioRole, QMediaPlayer, QMediaPlayerMediaStatus, QMediaPlayerState, QMediaPlaylist}
import qt.widgets.{QVBoxLayout, QWidget}

import scala.scalanative._
import unsafe._
import cxx._

@Qt(cxxType = "QWidget")
class Player extends QWidget {
  private val player = QMediaPlayer(this)
  player.setAudioRole(QAudioRole.VideoRole)

  private val playlist = QMediaPlaylist()
  player.setPlaylist(playlist)

  private val videoWidget = VideoWidget(this)
  player.setVideoOutput(videoWidget)

//  player.onDurationChanged(durationChanged)
//  player.onPositionChanged(positionChanged)
//  player.onMetaDataChanged(metaDataChanged)
//  player.onMediaStatusChanged(mediaStatusChanged)
//  player.onBufferStatusChanged(bufferStatusChanged)
//  player.onVideoAvailableChanged(videoAvailableChanged)
//  player.onStateChanged(stateChanged)

//  playlist.onCurrentIndexChanged(currentIndexChanged)

  setWindowTitle("MediaPlayer")

  private val _layout = QVBoxLayout()
  _layout.addWidget(videoWidget)

  setLayout(_layout)

  val url = QUrl("https://www.freedesktop.org/software/gstreamer-sdk/data/media/sintel_trailer-480p.webm")
//  val url = QUrl(s)
  player.setMedia(url)
  player.play()

  private def durationChanged(duration: qint64): Unit = {

  }

  private def positionChanged(pos: qint64): Unit = {

  }

  private def metaDataChanged(): Unit = {

  }

  private def currentIndexChanged(idx: Int): Unit = {

  }

  private def mediaStatusChanged(stat: QMediaPlayerMediaStatus.Value): Unit = {

  }

  private def bufferStatusChanged(stat: Int): Unit = {

  }

  private def videoAvailableChanged(available: Boolean): Unit = {

  }

  private def stateChanged(state: QMediaPlayerState.Value): Unit = {

  }
}
object Player {
  @constructor("QWidget")
  def apply(): Player = extern
}
