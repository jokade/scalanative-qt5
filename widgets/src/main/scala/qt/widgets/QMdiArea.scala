package qt.widgets

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qmdiarea.html]]
 */
@Qt
@include("<QMdiArea>")
class QMdiArea extends QAbstractScrollArea {
  @returnsConst
  def activationOrder: WindowOrder.Value = extern
  def setActivationOrder(order: WindowOrder.Value): Unit = extern

  @returnsConst
  def documentMode: Boolean = extern
  def setDocumentMode(enabled: Boolean): Unit = extern

  def addSubWindow(widget: QWidget): QMdiSubWindow = extern
}

object QMdiArea {
  @constructor
  def apply(): QMdiArea = extern
}