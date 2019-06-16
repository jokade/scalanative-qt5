package qt.widgets

import qt.macros.Qt
import qt.core.QObject

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qwidget.html]]
 */
@Qt
@include("<QWidget>")
class QWidget extends QObject {

  def show(): Unit = extern
}
