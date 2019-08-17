package qt.widgets

import qt.core.QtAlignment

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qheaderview.html]]
 */
@Qt
@include("<QHeaderView>")
class QHeaderView extends QAbstractItemView {
  def count: Int = extern

  def defaultAlignment: QtAlignment.Value = extern

  def defaultSectionSize: Int = extern

  def hiddenSectionCount: Int = extern

  def hideSection(idx: Int): Unit = extern
  def isSectionHidden(idx: Int): Boolean = extern

  def highlightSections: Boolean = extern

  def length: Int = extern

  def maximumSectionSize: Int = extern
  def setMaximumSectionSize(size: Int): Unit = extern

  def minimumSectionSize: Int = extern
  def setMinimumSectionSize(size: Int): Unit = extern

  def sectionsClickable: Boolean = extern
  def setSectionsClickable(enable: Boolean): Unit = extern

  def sectionsHidden: Boolean = extern

  def sectionsMovable: Boolean = extern
  def setSectionsMovable(enable: Boolean): Unit = extern
}

object QHeaderView {
}