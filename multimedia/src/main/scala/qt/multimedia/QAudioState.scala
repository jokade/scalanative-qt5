package qt.multimedia

import scala.scalanative.cobj.CEnum
import scala.scalanative.cxx.CxxEnum

@CxxEnum("QAudio::State")
object QAudioState extends CEnum {
  val ActiveState      = Value(0)
  val SuspendedState   = Value(1)
  val StoppedState     = Value(2)
  val IdleState        = Value(3)
  val InterruptedState = Value(4)
}
