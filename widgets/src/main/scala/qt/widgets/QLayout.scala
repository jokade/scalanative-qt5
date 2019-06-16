package qt.widgets

import qt.core.QObject
import qt.macros.Qt

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qlayout.html]]
 */
@Qt
@include("<QLayout>")
class QLayout extends QObject {

  def addWidget(w: QWidget): Unit = extern
}

