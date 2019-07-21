package qt.widgets

import scala.scalanative.cobj.CEnum
import scala.scalanative.cxx.CxxEnum

@CxxEnum("QDockWidget::DockWidgetFeature")
object DockWidgetFeatures extends CEnum {
  val Closable         = Value(0x01)
  val Movable          = Value(0x02)
  val Floatable        = Value(0x04)
  val VerticalTitleBar = Value(0x08)
  val AllDockWidgetFeatures = Closable | Movable | Floatable | VerticalTitleBar
  val NoDockWidgetFeatures = Value(0x00)
}
