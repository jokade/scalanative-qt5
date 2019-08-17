package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[]]
 */
@Qt
@include("<QFile>")
class QFile extends QFileDevice {
  def exists: Boolean = extern
  def remove(): Boolean = extern
  def rename(@ref newName: QString): Boolean = extern
  def setFileName(@ref name: QString): Unit = extern
}

object QFile {
  @constructor
  def apply(@ref name: QString): QFile = extern
  def apply(name: CString): QFile = withQString(name)(apply)
  def apply(name: String): QFile = QString.withValue(name)(apply)
}