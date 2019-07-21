package qt.core

import de.surfice.smacrotools.debug
import qt.macros.Qt

import scalanative._
import unsafe._
import cxx._

/**
 * @see [[]]
 */
@Cxx
@include("<QByteArray>")
class QByteArray extends {

  def count: Int = extern
  def data(): CString = extern
}

object QByteArray {
  @constructor
  def apply(): QByteArray = extern
}