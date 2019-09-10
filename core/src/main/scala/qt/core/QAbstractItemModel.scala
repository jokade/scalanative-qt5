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
abstract class QAbstractItemModel extends QObject {

  def columnCount(@ref parent: QAbstractItemModel): Int

  def rowCount(@ref parent: QAbstractItemModel): Int

//  def data(@ref idx: QModelIndex)(res: ResultValue[QVariant]): Unit


//  def layoutChanged(): Unit = extern
}

object QAbstractItemModel {
}