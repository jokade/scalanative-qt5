package qt.core

import de.surfice.smacrotools.debug
import qt.macros.Qt

import scalanative._
import unsafe._
import cxx._
import qt5.macros._


@Qt
@include("<QObject>")
class QObject {
}

object QObject {
  implicit final class Implicit(val o: QObject) extends AnyVal {
    def rawPtr: Ptr[Byte] = o.__ptr
  }
}
