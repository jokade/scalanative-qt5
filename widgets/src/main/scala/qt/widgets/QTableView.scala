package qt.widgets

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qtableview.html]]
 */
@Qt
@include("<QTableView>")
class QTableView extends QAbstractItemView {
  def horizontalHeader: QHeaderView = extern
  def verticalHeader: QHeaderView = extern
}

object QTableView {
  @constructor
  def apply(): QTableView = extern
}