package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.{CObject, ResultValue}
import scala.scalanative.interop.AutoReleasable

/**
 * @see [[https://doc.qt.io/qt-5/qdir.html]]
 */
@Qt
@include("<QDir>")
final class QDir extends ImplicitlyShared {
  def exists: Boolean = extern
  def isRelative: Boolean = extern
  def isAbsolute: Boolean = extern
  def count: Int = extern

  @cxxBody("return __p->absolutePath().toLatin1().data_ptr()->data();")
  def absolutePathCString(): CString = extern
  def absolutePath: String = fromCString(absolutePathCString())

  @cxxBody("return __p->canonicalPath().toLatin1().data_ptr()->data();")
  def canonicalPathCString(): CString = extern
  def canonicalPath: String = fromCString(canonicalPathCString())

  @cxxBody("return __p->dirName().toLatin1().data_ptr()->data();")
  def dirNameCString(): CString = extern
  def dirName: String = fromCString(dirNameCString())

  @cxxBody("return __p->path().toLatin1().data_ptr()->data();")
  def pathCString(): CString = extern
  def path: String = fromCString(dirNameCString())

  def cdUp(): Boolean = extern
  def makeAbsolute(): Boolean = extern

  @returnsValue
  def entryList()(implicit v: ResultValue[QStringList]): Unit = extern

  def withEntryList[T](f: QStringList=>T): T = {
    val list = QStringList()
    entryList()(ResultValue(list))
    val res = f(list)
    list.free()
    res
  }

  @delete
  override def free(): Unit = extern
}

object QDir {
  @constructor
  def apply(): QDir = extern
  @constructor
  def apply(@ref path: QString): QDir = extern
  def apply(path: CString): QDir = withQString(path)(apply)

//  @returnsValue
//  def current()(implicit v: ResultValue[QDir]): QDir = extern

  @cxxBody("return QDir::currentPath().toLatin1().data_ptr()->data();")
  def currentPathCString(): CString = extern
  def currentPath: String = fromCString(currentPathCString())
}