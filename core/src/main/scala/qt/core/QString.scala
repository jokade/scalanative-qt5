package qt.core

import de.surfice.smacrotools.debug
import qt.macros.Qt

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.cobj.ResultValue
import scala.scalanative.interop.AutoReleasable

/**
 * @see [[https://doc.qt.io/qt-5/qstring.html]]
 */
@Cxx
@include("<QString>")
class QString extends ImplicitlyShared {

  def size: Int = extern

  @returnsValue
  def toLatin1()(implicit value: ResultValue[QByteArray]): Unit = extern

  @cxxBody("return __p->toLatin1().data_ptr()->data();")
  protected def toLatin1CString(): CString = extern
//  @cxxBody("return p->toUtf8().data_ptr()->data();")
//  protected def toUtf8CString(): CString = extern

  def latin1String: String = fromCString(toLatin1CString())
//  def utf8String: String = fromCString(toUtf8CString())

  override def toString: String = latin1String

  @delete
  override def free(): Unit = extern
}

object QString {

  @constructor
  def apply(s: CString): QString = extern

  def apply(s: String)(implicit z: Zone): QString = apply(toCString(s))

  def withValue[T](f: ResultValue[QString]=>T): T = {
    val r = ResultValue.stackalloc[QString]
    f(r)
  }
}