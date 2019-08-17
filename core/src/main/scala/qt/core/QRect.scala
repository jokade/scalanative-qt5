package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qrect.html]]
 */
@Qt
@include("<QRect>")
class QRect extends Value {
  override protected[qt] def initValue(): Unit = ???
}

object QRect {
}