package qt.gui

import qt.core.QAbstractItemModel

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qstandarditemmodel.html]]
 */
@Qt
@include("<QStandardItemModel>")
class QStandardItemModel extends QAbstractItemModel {
}

object QStandardItemModel {
  @constructor
  def apply(rows: Int, columns: Int): QStandardItemModel = extern
}