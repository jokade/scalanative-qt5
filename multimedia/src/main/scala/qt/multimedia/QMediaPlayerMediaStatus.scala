package qt.multimedia

import scala.scalanative.cobj.CEnum
import scala.scalanative.cxx.CxxEnum

@CxxEnum("QMediaPlayer::MediaStatus")
object QMediaPlayerMediaStatus extends CEnum {
  val UnknownMediaStatus = Value(0)
  val NoMedia	           = Value(1)
  val LoadingMedia	     = Value(2)
  val LoadedMedia	       = Value(3)
  val StalledMedia	     = Value(4)
  val BufferingMedia	   = Value(5)
  val BufferedMedia	     = Value(6)
  val EndOfMedia	       = Value(7)
  val InvalidMedia	     = Value(8)
}
