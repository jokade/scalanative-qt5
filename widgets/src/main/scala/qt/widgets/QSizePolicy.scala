package qt.widgets

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.CEnum

/**
 * @see [[https://doc.qt.io/qt-5/qsizepolicy.html]]
 */
@Qt
class QSizePolicy {

}

object QSizePolicy {
  @CxxEnum("QSizePolicy::Policy")
  object Policy extends CEnum {
    val Fixed            = Value(0)
    val Minimum          = Value(PolicyFlag.GrowFlag)
    val Maximum          = Value(PolicyFlag.ShrinkFlag)
    val Preferred        = Value(PolicyFlag.GrowFlag | PolicyFlag.ShrinkFlag)
    val Expanding        = Value(PolicyFlag.GrowFlag | PolicyFlag.ShrinkFlag | PolicyFlag.ExpandFlag)
    val MinimumExpanding = Value(PolicyFlag.GrowFlag | PolicyFlag.ExpandFlag)
    val Ingored          = Value(PolicyFlag.ShrinkFlag | PolicyFlag.GrowFlag | PolicyFlag.IngoreFlag)
  }

  object PolicyFlag {
    val GrowFlag   = 1
    val ExpandFlag = 2
    val ShrinkFlag = 4
    val IngoreFlag = 8
  }
}
