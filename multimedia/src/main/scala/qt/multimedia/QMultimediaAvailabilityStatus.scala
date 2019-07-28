package qt.multimedia

import scala.scalanative.cobj.CEnum
import scala.scalanative.cxx.CxxEnum

@CxxEnum("QMultimedia::AvailabilityStatus")
object QMultimediaAvailabilityStatus extends CEnum {
  val Available	     = Value(0)
  val ServiceMissing = Value(1)
  val ResourceError	 = Value(3)
  val Busy	         = Value(2)
}
