package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.interop.AutoReleasable

/**
 * @see [[https://doc.qt.io/qt-5/qurl.html]]
 */
@Qt
@include("<QUrl>")
class QUrl extends CxxObject with AutoReleasable {
  @delete
  override def free(): Unit = extern
}

object QUrl {
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