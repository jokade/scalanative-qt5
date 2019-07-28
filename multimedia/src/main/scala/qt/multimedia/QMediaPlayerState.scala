package qt.multimedia

import scala.scalanative.cobj.CEnum
import scala.scalanative.cxx.CxxEnum

@CxxEnum("QMediaPlayer::State")
object QMediaPlayerState extends CEnum {
  val StoppedState = Value(0)
  val PlayingState = Value(1)
  val PausedState  = Value(2)
}
