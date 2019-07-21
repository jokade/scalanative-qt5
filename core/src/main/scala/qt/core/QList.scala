package qt.core

import de.surfice.smacrotools.debug

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.CObject

/**
 * @see [[https://doc.qt.io/qt-5/qlist.html]]
 */
@Cxx(classname = "QList<void *>")
@include("<QList>")
class QList[T<:CObject] {
  def count: Int = extern
  def append(value: T): Unit = extern
}

object QList {
  @constructor
  def apply[T<:CObject](): QList[T] = extern
}