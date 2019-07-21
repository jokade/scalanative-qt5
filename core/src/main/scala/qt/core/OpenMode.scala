package qt.core

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.cobj.CEnum

@CxxEnum("QIODevice::OpenModeFlag")
object OpenMode extends CEnum {
  val NotOpen	      = Value(0x0000)
  val ReadOnly	    = Value(0x0001)
  val WriteOnly	    = Value(0x0002)
  val ReadWrite     =	ReadOnly | WriteOnly
  val Append	      = Value(0x0004)
  val Truncate	    = Value(0x0008)
  val Text	        = Value(0x0010)
  val Unbuffered	  = Value(0x0020)
  val NewOnly	      = Value(0x0040)
  val ExistingOnly	= Value(0x0080)
}
