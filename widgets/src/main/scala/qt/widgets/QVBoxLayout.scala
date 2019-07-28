package qt.widgets

import qt.macros.Qt

import scalanative._
import unsafe._
import cxx._

/**
 * @see [[https://doc.qt.io/qt-5/qvboxlayout.html]]
 */
@Qt
@include("<QVBoxLayout>")
class QVBoxLayout extends QBoxLayout {

}

object QVBoxLayout {
  @constructor
  def apply(): QVBoxLayout = extern
}
