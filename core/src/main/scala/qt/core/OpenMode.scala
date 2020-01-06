package qt.core

import de.surfice.smacrotools.debug

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.cobj.CEnum

@CxxEnum("QIODevice::OpenModeFlag")
object OpenMode extends CEnum {
  val NotOpen	      :OpenMode.Value = Value(0x0000)
  val ReadOnly	    :OpenMode.Value = Value(0x0001)
  val WriteOnly	    :OpenMode.Value = Value(0x0002)
  val ReadWrite     :OpenMode.Value =	ReadOnly | WriteOnly
  val Append	      :OpenMode.Value = Value(0x0004)
  val Truncate	    :OpenMode.Value = Value(0x0008)
  val Text	        :OpenMode.Value = Value(0x0010)
  val Unbuffered	  :OpenMode.Value = Value(0x0020)
  val NewOnly	      :OpenMode.Value = Value(0x0040)
  val ExistingOnly	:OpenMode.Value = Value(0x0080)
}
