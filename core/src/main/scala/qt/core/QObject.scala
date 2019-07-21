package qt.core

import de.surfice.smacrotools.debug
import qt.macros.Qt

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.interop.AutoReleasable


@Qt
@include("<QObject>")
class QObject extends CxxObject with AutoReleasable {
  def blockSignals(block: Boolean): Boolean = extern
  def signalsBlocked: Boolean = extern

  @returnsConst
  def parent: QObject = extern

  def deleteLater(): Unit = extern
  def free(): Unit = deleteLater()
}

object QObject {
  implicit final class Implicit(val o: QObject) extends AnyVal {
    def rawPtr: Ptr[Byte] = o.__ptr
  }
}
