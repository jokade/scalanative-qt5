package qt.gui

import qt.core.{QAbstractItemModel, QModelIndex, QVariant}

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.ResultValue

/**
 * @see [[https://doc.qt.io/qt-5/qstandarditemmodel.html]]
 */
@Qt
@include("<QStandardItemModel>")
class QStandardItemModel extends QAbstractItemModel {
  override def columnCount(@ref parent: QModelIndex): CInt = extern
  override def rowCount(@ref parent: QModelIndex): CInt = extern
}

object QStandardItemModel {
  @constructor
  def apply(rows: Int, columns: Int): QStandardItemModel = extern
}