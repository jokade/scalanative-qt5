package qt.core

import scala.scalanative.cobj.CEnum
import scala.scalanative.cxx.CxxEnum

@CxxEnum("Qt::Alignment")
object QtAlignment extends CEnum {
  val Left     = Value(0x0001)
  val Right    = Value(0x0002)
  val HCenter  = Value(0x0004)
  val Justify  = Value(0x0008)

  val Top      = Value(0x0020)
  val Bottom   = Value(0x0040)
  val VCenter  = Value(0x0080)
  val Baseline = Value(0x0100)

  val Center   = VCenter | HCenter
}
