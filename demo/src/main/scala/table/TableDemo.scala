package table

import de.surfice.smacrotools.debug
import qt.core.{QAbstractItemModel, QAbstractTableModel, QModelIndex, QVariant}
import qt.macros._
import qt.widgets.{QTableView, QVBoxLayout, QWidget}

import scala.scalanative.cobj.ResultValue
import scala.scalanative.cxx._
import scalanative._
import unsafe._

@Qt(cxxType = "QWidget")
class TableDemo extends QWidget {

  setWindowTitle("Table Demo")

  val tableView = QTableView()
  val model = TableModel()
  tableView.setModel(model)
  val _layout = QVBoxLayout()
  setLayout(_layout)
  _layout.addWidget(tableView)
}
object TableDemo {
  @constructor("QWidget")
  def apply(): TableDemo = extern
}

@ScalaCxx
@include("<QAbstractTableModel>")
@debug
class TableModel extends QAbstractTableModel {
  override def columnCount(parent: QAbstractItemModel): CInt = ???
  override def rowCount(parent: QAbstractItemModel): CInt = ???
}
object TableModel {
  @constructor
  def apply(): TableModel = extern
}