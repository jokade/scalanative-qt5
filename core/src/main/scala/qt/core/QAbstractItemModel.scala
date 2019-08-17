package qt.core

import qt.macros._

import scala.scalanative.cobj.ResultValue
import scalanative.unsafe._
import scala.scalanative.cxx._

/**
 * @see [[https://doc.qt.io/qt-5/qabstractitemmodel.html]]
 */
@Qt
@include("<QAbstractItemModel>")
class QAbstractItemModel extends QObject {

  def columnCount: Int = extern

  def data(@ref idx: QModelIndex)(res: ResultValue[QVariant]): Unit = extern

  def rowCount: Int = extern

  def layoutChanged(): Unit = extern
}

object QAbstractItemModel {
}