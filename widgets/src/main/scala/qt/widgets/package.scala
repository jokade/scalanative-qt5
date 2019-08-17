package qt

import scala.scalanative.cobj.CEnum
import scala.scalanative.cxx.CxxEnum

package object widgets {
  @CxxEnum("QLineEdit::ActionPosition")
  object QLineEditActionPosition extends CEnum {
    val LeadingPosition = Value(0)
    val TrailingPosition = Value(1)
  }

  @CxxEnum("QAbstractItemView::ScrollMode")
  object QAbstractItemViewScrollMode extends CEnum {
    val ScrollPerItem = Value(0)
    val ScrollPerPixel = Value(1)
  }

  @CxxEnum("QAbstractItemView::SelectionBehavior")
  object QAbstractItemViewSelectionBehavior extends CEnum {
    val SelectItems = Value(0)
    val SelectRows  = Value(1)
    val SelectColumns = Value(2)
  }
}
