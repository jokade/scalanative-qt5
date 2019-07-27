package qt.widgets

import scala.scalanative.cobj.CEnum
import scala.scalanative.cxx.CxxEnum

@CxxEnum("QMessageBox::StandardButton")
object StandardButton extends CEnum {
  val Ok              = Value(0x400)
  val Open            = Value(0x2000)
  val Save            = Value(0x800)
  val Cancel          = Value(0x400000)
  val Close           = Value(0x00200000)
  val Discard         = Value(0x00800000)
  val Apply           = Value(0x02000000)
  val Reset           = Value(0x04000000)
  val RestoreDefaults = Value(0x08000000)
  val Help            = Value(0x01000000)
  val SaveAll         = Value(0x00001000)
  val Yes             = Value(0x00004000)
  val YesToAll        = Value(0x00008000)
  val No              = Value(0x00010000)
  val NoToAll         = Value(0x00020000)
  val Abort           = Value(0x00040000)
  val Retry           = Value(0x00080000)
  val Ignore          = Value(0x00100000)
  val NoButton        = Value(0)
}
