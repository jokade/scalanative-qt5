package qt.multimedia

import scala.scalanative.cobj.CEnum
import scala.scalanative.cxx.CxxEnum

@CxxEnum("QAudio::Role")
object QAudioRole extends CEnum {
  val UnknownRole	           = Value(0)
  val MusicRole	             = Value(1)
  val VideoRole	             = Value(2)
  val VoiceCommunicationRole = Value(3)
  val AlarmRole	             = Value(4)
  val NotificationRole	     = Value(5)
  val RingtoneRole	         = Value(6)
  val AccessibilityRole	     = Value(7)
  val SonificationRole	     = Value(8)
  val GameRole	             = Value(9)
  val CustomRole	           = Value(10)
}
