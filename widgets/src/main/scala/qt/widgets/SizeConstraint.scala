package qt.widgets

import scala.scalanative.cobj.CEnum
import scala.scalanative.cxx.CxxEnum

@CxxEnum("QLayout::SizeConstraint")
object SizeConstraint extends CEnum {
  val SetDefaultConstraint = Value(0)
  val SetNoConstraint      = Value(1)
  val SetMinimumSize       = Value(2)
  val SetFixedSize         = Value(3)
  val SetMaximumSize       = Value(4)
  val SetMinAndMaxSize     = Value(5)
}
