package qt.widgets

import scala.scalanative.cobj.CEnum
import scala.scalanative.cxx.CxxEnum

@CxxEnum("QMdiArea::WindowOrder")
object WindowOrder extends CEnum {
  val CreationOrder          = Value(0)
  val StackingOrder          = Value(1)
  val ActivationHistoryOrder = Value(2)
}
