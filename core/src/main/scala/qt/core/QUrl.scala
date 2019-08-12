package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.ResultValue
import scala.scalanative.interop.AutoReleasable

/**
 * @see [[https://doc.qt.io/qt-5/qurl.html]]
 */
@Qt
@include("<QUrl>")
class QUrl extends CxxObject with AutoReleasable {
  @cxxBody("return __p->toString().toUtf8().data();")
  def toCString: CString = extern

  @delete
  override def free(): Unit = extern
}

object QUrl {
  @constructor
  def apply(): QUrl = extern
  @constructor
  def apply(@ref url: QString): QUrl = extern

  def apply(url: CString): QUrl = QZone{ implicit z =>
    val _url = QString.value
    _url.set(url)
    apply(_url)
  }
  def apply(url: String): QUrl = QZone{ implicit z =>
    val _url = QString.value
    _url.set(url)
    apply(_url)
  }
}