package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qmodelindex.html]]
 */
@Qt
@include("<QModelIndex>")
class QModelIndex extends Value {
  def column: Int = extern
  def isValid: Boolean = extern
//  def model: QAbstractItemModel = extern
  def row: Int = extern
  override protected[qt] def initValue(): Unit = {}
}

object QModelIndex {
}