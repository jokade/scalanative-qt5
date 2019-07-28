package qt.multimedia

import scala.scalanative.cobj.CEnum
import scala.scalanative.cxx.CxxEnum

@CxxEnum("QAudio:VolumeScale")
object QVolumeScale extends CEnum {
  val LinearVolumeScale = Value(0)
  val CubicVolumeScale  = Value(1)
  val LogarithmicVolumeScale = Value(2)
  val DecibelVolumeScale = Value(3)
}
