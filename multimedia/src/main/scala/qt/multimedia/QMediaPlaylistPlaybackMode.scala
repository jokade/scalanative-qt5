package qt.multimedia

import scala.scalanative.cobj.CEnum
import scala.scalanative.cxx.CxxEnum

@CxxEnum("QMediaPlaylist::PlaybackMode")
object QMediaPlaylistPlaybackMode extends CEnum {
  val CurrentItemOnce	  = Value(0)
  val CurrentItemInLoop	= Value(1)
  val Sequential	      = Value(2)
  val Loop	            = Value(3)
  val Random	          = Value(4)
}
