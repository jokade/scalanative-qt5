package qt.uitools

import qt.core.{QDir, QIODevice, QObject, QStringList}

import scalanative._
import unsafe._
import cxx._
import qt.macros._
import qt.widgets.QWidget

import scala.scalanative.cobj.{CObjectWrapper, ResultValue}

/**
 * @see [[https://doc.qt.io/qt-5/quiloader.html]]
 */
@Qt
@include("<QUiLoader>")
class QUiLoader extends QObject {
  def load(device: QIODevice): QWidget = extern
  def setWorkingDirectory(@ref dir: QDir): Unit = extern
  @returnsValue
  def availableWidgets()(implicit v: ResultValue[QStringList]): Unit = extern
  def withAvailableWidgets[T](f: QStringList=>T): T = {
    val list = QStringList()
    availableWidgets()(ResultValue(list))
    val res = f(list)
    list.free()
    res
  }
}

object QUiLoader {
  @constructor
  def apply(): QUiLoader = extern

  def loadWidget[T<:QWidget](device: QIODevice, workingDirectory: Option[QDir] = None)(implicit wrapper: CObjectWrapper[T]): T = {
    val loader = QUiLoader()
    workingDirectory.foreach(loader.setWorkingDirectory)
    val widget = wrapper.wrap(loader.load(device).__ptr)
    loader.free()
    widget
  }

}