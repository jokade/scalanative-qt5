package qt.multimedia

import scala.scalanative.cobj.CEnum
import scala.scalanative.cxx.CxxEnum

@CxxEnum("QMediaPlayer::Flags")
object QMediaPlayerFlags extends CEnum {
  val LowLatency     = Value(0x01)
  val StreamPlayback = Value(0x02)
  val VideoSurface   = Value(0x04)
}
