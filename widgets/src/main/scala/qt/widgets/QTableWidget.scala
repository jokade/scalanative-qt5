package qt.widgets

import qt.core.QStringList

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[]]
 */
@Qt
@include("<QTableWidget>")
class QTableWidget extends QTableView {
  def setHorizontalHeaderLabels(@ref labels: QStringList): Unit = extern
}

object QTableWidget {
}