package qt.core

import de.surfice.smacrotools.debug

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qabstracttablemodel.html]]
 */
@Qt
@include("<QAbstractTableModel>")
abstract class QAbstractTableModel extends QAbstractItemModel {

}

object QAbstractTableModel {
}

