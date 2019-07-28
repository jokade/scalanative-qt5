package qt.multimedia

import scala.scalanative.cobj.CEnum
import scala.scalanative.cxx.CxxEnum

@CxxEnum("QMediaPlayer::Error")
object QMediaPlayerError extends CEnum {
  val NoError	            = Value(0)
  val ResourceError	      = Value(1)
  val FormatError	        = Value(2)
  val NetworkError	      = Value(3)
  val AccessDeniedError	  = Value(4)
  val ServiceMissingError	= Value(5)
}
