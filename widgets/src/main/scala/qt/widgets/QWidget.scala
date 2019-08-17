package qt.widgets

import de.surfice.smacrotools.debug
import qt.macros.Qt
import qt.core.{QList, QObject, QSize, QString, QZone}
import qt.gui.QFont

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.{CObjectWrapper, ResultValue}

/**
 * @see [[https://doc.qt.io/qt-5/qwidget.html]]
 */
@Qt
@include("<QWidget>")
class QWidget extends QObject {

  def activateWindow(): Unit = extern

  def addAction(action: QAction): Unit = extern

  def adjustSize(): Unit = extern

  def clearFocus(): Unit = extern

  def clearMask(): Unit = extern

  def focusWidget: QWidget = extern

  @returnsRef
  def font: QFont = extern
  def setFont(@ref font: QFont): Unit = extern

  def frameSize(size: ResultValue[QSize]): Unit = extern
  def frameSize: (Int,Int) = QZone{ implicit z =>
    val s = QSize.value
    s := frameSize
    (s.width,s.height)
  }

  def isFullScreen: Boolean = extern

  def grabKeyboard(): Unit = extern

  def grabMouse(): Unit = extern

  def hasFocus: Boolean = extern

  def height: Int = extern

  def layout: QLayout = extern
  def setLayout(layout: QLayout): Unit = extern

  def maximumHeight: Int = extern
  def setMaximumHeight(h: Int): Unit = extern

  def maximumWidth: Int = extern
  def setMaximumWidth(w: Int): Unit = extern

  def minimumHeight: Int = extern
  def setMinimumHeight(h: Int): Unit = extern

  def minimumWidth: Int = extern
  def setMinimumWidth(w: Int): Unit = extern

  def move(x: Int, y: Int): Unit = extern

  def releaseKeyboard(): Unit = extern
  def releaseMouse(): Unit = extern

  def setSizePolicy(horizontal: QSizePolicy.Policy.Value, vertical: QSizePolicy.Policy.Value): Unit = extern

  def setWindowTitle(@ref title: QString): Unit = extern
  def setWindowTitle(title: String): Unit = QZone{ implicit z =>
    val s = QString(title)
    setWindowTitle(s)
    s.free()
  }

  def showMaximized(): Unit = extern
  def showMinimized(): Unit = extern
  def showFullScreen(): Unit = extern

  @returnsValue
  @cxxBody("*((QList<QAction*>*)__res) =  __p->actions();")
  def actions()(implicit v: ResultValue[QList[QAction]]): Unit = extern

  def resize(width: Int, height: Int): Unit = extern

  def scroll(dx: Int, dy: Int): Unit = extern

  def show(): Unit = extern

}

object QWidget {
  @constructor
  def apply(): QWidget = extern
}
