package qt.widgets

import qt.core.{QAbstractItemModel, QItemSelectionModel, QModelIndex}

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qabstractitemview.html]]
 */
@Qt
@include("<QAbstractItemView>")
class QAbstractItemView extends QAbstractScrollArea {
  def alternatingRowColors: Boolean = extern
  def setAlternatingRowColors(f: Boolean): Unit = extern

  def hasAutoScroll: Boolean = extern
  def setAutoScroll(enable: Boolean): Unit = extern

  def autoScrollMargin: Int = extern
  def setAutoScrollMargin(margin: Int): Unit = extern

  def clearSelection(): Unit = extern

  def dragEnabled: Boolean = extern
  def setDragEnabled(enable: Boolean): Unit = extern

  def horizontalScrollMode: QAbstractItemViewScrollMode.Value = extern
  def setHorizontalScrollMode(mode: QAbstractItemViewScrollMode.Value): Unit = extern


  def model: QAbstractItemModel = extern
  def setModel(m: QAbstractItemModel): Unit = extern

  def selectionBehavior: QAbstractItemViewSelectionBehavior.Value = extern
  def setSelectionBehavior(m: QAbstractItemViewSelectionBehavior.Value): Unit = extern

  def selectionModel: QItemSelectionModel = extern

  def tabKeyNavigation: Boolean = extern
  def setTabKeyNavigation(enable: Boolean): Unit = extern


  def verticalScrollMode: QAbstractItemViewScrollMode.Value = extern
  def setVerticalScrollMode(mode: QAbstractItemViewScrollMode.Value): Unit = extern

  def update(@ref index: QModelIndex): Unit = extern

  def reset(): Unit = extern
}

object QAbstractItemView {
}