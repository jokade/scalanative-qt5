package qt.core

import de.surfice.smacrotools.debug
import qt.macros._

import scala.scalanative.cobj.ResultValue
import scalanative.unsafe._
import scala.scalanative.cxx._

/**
 * @see [[https://doc.qt.io/qt-5/qabstractitemmodel.html]]
 */
@Qt
@include("<QAbstractItemModel>")
@debug
class QAbstractItemModel extends QObject {

  @cxxImpl("int columnCount(const QModelIndex &parent = QModelIndex()) const { QModelIndex _parent = parent; return __columnCount(this->___wrapper,&_parent); }")
  def columnCount(@ref parent: QModelIndex): Int = ???

  @cxxImpl("int rowCount(const QModelIndex &parent = QModelIndex()) const { QModelIndex _parent = parent; return __rowCount(this->___wrapper,&_parent); }")
  def rowCount(@ref parent: QModelIndex): Int = ???

  @cxxImpl("QVariant data(const QModelIndex &index, int role = Qt::DisplayRole) const { QModelIndex _index = index; return *__data(this->___wrapper,&_index,role); }")
  def data(@ref index: QModelIndex, role: Int): QVariant = ???

  @cxxImpl(
    """QVariant headerData(int section, Qt::Orientation orientation, int role = Qt::DisplayRole) const {
         return *__headerData(this->___wrapper,section,orientation,role);
       }""")
  def headerData(section: Int, orientation: Int, role: Int): QVariant = ???


//  def layoutChanged(): Unit = extern
}

object QAbstractItemModel {
}