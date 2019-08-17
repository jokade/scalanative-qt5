package qt.core

import de.surfice.smacrotools.debug

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.{CObject, ResultValue}
import scala.scalanative.interop.AutoReleasable

/**
 * @see [[https://doc.qt.io/qt-5/qdir.html]]
 */
@Cxx
@include("<QDir>")
class QDir {
  def exists: Boolean = extern
  def isRelative: Boolean = extern
  def isAbsolute: Boolean = extern
  def count: Int = extern

  @cxxBody("return __p->absolutePath().toLatin1().data_ptr()->data();")
  def absolutePathCString(): CString = extern
  def absolutePath: String = fromCString(absolutePathCString())
  @returnsValue
  def absolutePath()(s: ResultValue[QString]): Unit = extern

  @cxxBody("return __p->canonicalPath().toLatin1().data_ptr()->data();")
  def canonicalPathCString(): CString = extern
  def canonicalPath: String = fromCString(canonicalPathCString())
  def canonicalPath()(s: ResultValue[QString]): Unit = extern

  @cxxBody("return __p->dirName().toLatin1().data_ptr()->data();")
  def dirNameCString(): CString = extern
  def dirName: String = fromCString(dirNameCString())
  def dirName()(s: ResultValue[QString]): Unit = extern

  @cxxBody("return __p->path().toLatin1().data_ptr()->data();")
  def pathCString(): CString = extern
  def path: String = fromCString(pathCString())
  def path()(s: ResultValue[QString]): Unit = extern

  def cdUp(): Boolean = extern
  def makeAbsolute(): Boolean = extern

  def mkdir(@ref dirName: QString): Boolean = extern
  def mkdir(dirName: String)(implicit zone: Zone): Boolean = {
    val s = QString.value
    s.set(dirName)
    mkdir(s)
  }

  @returnsValue
  def entryList()(list: ResultValue[QStringList]): Unit = extern

//  def withEntryList[T](f: QStringList=>T): T = {
//    val list = QStringList()
//    entryList()(ResultValue(list))
//    val res = f(list)
//    list.free()
//    res
//  }

  @delete
  def free(): Unit = extern

  @cxxBody("__p = nullptr;")
  protected def initValue(): Unit = extern
}

object QDir {
  @constructor
  def apply(): QDir = extern
  @constructor
  def apply(@ref path: QString): QDir = extern
  def apply(path: CString): QDir = withQString(path)(apply)
  def apply(path: String): QDir = QString.withValue(path)(apply)

//  @returnsValue
//  def current()(implicit v: ResultValue[QDir]): QDir = extern

  @cxxBody("return QDir::currentPath().toLatin1().data_ptr()->data();")
  def currentPathCString(): CString = extern
  def currentPath: String = fromCString(currentPathCString())
  @returnsValue
  def current()(d: ResultValue[QDir]): Unit = extern
}

@Cxx(cxxType = "QDir")
class QDirValue extends QDir with ResultValue[QDir] {
}
object QDirValue {
  @constructor("QDir")
  def apply(): QDirValue = extern
}