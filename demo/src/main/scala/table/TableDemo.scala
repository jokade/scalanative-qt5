package table

import de.surfice.smacrotools.debug
import qt.core.{QAbstractTableModel, QModelIndex, QStringList, QVariant, QtItemDataRole, QtOrientation}
import qt.macros._
import qt.widgets.{QTableView, QVBoxLayout, QWidget}

import scala.scalanative._
import scala.scalanative.cxx._
import scala.scalanative.unsafe._

@Qt(cxxType = "QWidget")
@include("<QWidget>")
class TableDemo extends QWidget {

  setWindowTitle("Table Demo")

  val villains = Seq(
    SuperVillain("Lex Luthor", "Superman"),
    SuperVillain("The Joker", "Batman"),
    SuperVillain("Green Goblin", "Spider-Man"),
    SuperVillain("Ernst Stavro Blofeld", "James Bond")
  )

  val tableView = QTableView()
  val model = SuperVillainsModel()(villains)
  tableView.setModel(model)

  val _layout = QVBoxLayout()
  setLayout(_layout)
  _layout.addWidget(tableView)
}
object TableDemo {
  @constructor("QWidget")
  def apply(): TableDemo = extern
}

case class SuperVillain(name: String, enemy: String)

@ScalaCxx
@include("<QAbstractTableModel>")
@debug
class SuperVillainsModel()(implicit villains: Seq[SuperVillain]) extends QAbstractTableModel with ScalaCxxObject {
  private val _qvar = QVariant()
  override def columnCount(parent: QModelIndex): CInt = 2
  override def rowCount(parent: QModelIndex): CInt = villains.size
  override def data(index: QModelIndex, role: Int): QVariant = {
    if(role == QtItemDataRole.DisplayRole.value)
      index.column match {
        case 0 =>
          _qvar.setValue(villains(index.row).name)
        case 1 =>
          _qvar.setValue(villains(index.row).enemy)
      }
    else
      _qvar.clear()
    _qvar
  }

  override def headerData(section: CInt, orientation: CInt, role: CInt): QVariant = {
    if(role == QtItemDataRole.DisplayRole.value)
      // column header
      if(orientation==QtOrientation.Horizontal.value)
        _qvar.setValue(section match {
          case 0 => "Villain"
          case 1 => "Enemy"
        })
      // row label
      else
      _qvar.setValue(section+1)
    else
      _qvar.clear()
    _qvar
  }
}
object SuperVillainsModel {
  @constructor
  def apply()(implicit villains: Seq[SuperVillain]): SuperVillainsModel = extern
}