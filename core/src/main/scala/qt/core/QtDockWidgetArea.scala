package qt.core

import scala.scalanative.cobj.CEnum
import scala.scalanative.cxx.CxxEnum

@CxxEnum("Qt::DockWidgetArea")
object QtDockWidgetArea extends CEnum {
  val Left   = Value(0x01)
  val Right  = Value(0x02)
  val Top    = Value(0x04)
  val Bottom = Value(0x08)
  val AllDockWidgetAreas = Left | Right | Top | Bottom
  val NoDockWidgetArea = Value(0x00)
}
