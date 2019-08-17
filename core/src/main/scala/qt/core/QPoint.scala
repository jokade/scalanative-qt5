package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qpoint.html]]
 */
@Qt
@include("<QPoint>")
class QPoint extends Value {
  override protected[qt] def initValue(): Unit = {}
}

object QPoint {
}