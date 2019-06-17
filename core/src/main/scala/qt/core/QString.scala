package qt.core

import qt.macros.Qt

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.interop.AutoReleasable

/**
 * @see [[https://doc.qt.io/qt-5/qstring.html]]
 */
@Qt
@include("<QString>")
class QString extends CxxObject with AutoReleasable {

//  def toUtf8(): QByteArray = extern
//  def toLatin1(): QByteArray = extern
//  def toLocal8Bit(): QByteArray = extern
  @delete
  override def free(): Unit = extern
}

object QString {
  @constructor
  def apply(s: CString): QString = extern

  def apply(s: String)(implicit z: Zone): QString = apply(toCString(s))
}