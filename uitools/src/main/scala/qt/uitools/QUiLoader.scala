package qt.uitools

import qt.core.{QDir, QFile, QIODevice, QObject, QString, QStringList, QZone}

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
  @cxxBody("return (char*)__p->load(device);")
  def loadPtr(device: QIODevice): Ptr[Byte] = extern
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

  def loadWidgetPtr(device: QIODevice, workingDirectory: Option[QDir]): Ptr[Byte] = {
    val loader = QUiLoader()
    workingDirectory.foreach(loader.setWorkingDirectory)
    val ptr = loader.loadPtr(device)
    loader.free()
    ptr
  }

  def loadWidget[T<:QWidget](device: QIODevice, workingDirectory: Option[QDir])(implicit wrapper: CObjectWrapper[T]): T =
    wrapper.wrap(loadWidgetPtr(device,workingDirectory))

  def loadWidgetPtr(file: String, workingDirectory: Option[String]): Ptr[Byte] = QZone{ implicit z =>
    val path = QString.value
    path.set(file)
    val _file = QFile(path)
    val _dir = workingDirectory.map(QDir.apply)
    val ptr = loadWidgetPtr(_file, _dir)
    _file.free()
    _dir.foreach(_.free())
    ptr
  }

  def loadWidget[T<:QWidget](file: String, workingDirectory: Option[String] = None)(implicit wrapper: CObjectWrapper[T]): T =
    wrapper.wrap( loadWidgetPtr(file,workingDirectory) )

}