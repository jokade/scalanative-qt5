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
class QUrl extends Value with AutoReleasable {
  @cxxBody("return __p->toString().toUtf8().data();")
  def toCString: CString = extern

  def setQuery(@ref query: QString): Unit = extern
  def setQuery(@ref query: QUrlQuery): Unit = extern

  @delete
  override def free(): Unit = extern

//  @cxxBody("*(size_t*)__p = (size_t)QUrl::shared_null;")
  override protected[qt] def initValue(): Unit = {}
}

object QUrl extends ValueProvider[QUrl] {
  @constructor
  def apply(): QUrl = extern
  @constructor
  def apply(@ref url: QString): QUrl = extern

  def apply(url: CString): QUrl = QZone{ implicit z =>
    val _url = QString.value
    _url.set(url)
    apply(_url)
  }
  def apply(url: String, queryItems: (String,String)*): QUrl = QZone{ implicit z =>
    val _url = QString.value
    _url.set(url)
    val res = apply(_url)
    if(queryItems.nonEmpty){
      val query = QUrlQuery(queryItems)
      res.setQuery(query)
      query.free()
    }
    res
  }

  override def value(implicit zone: Zone): QUrlValue = {
    val ptr = unsafe.alloc[Byte](__sizeof)
    val url = new QUrlValue(ptr)
    url._isAllocated = false
    url.initValue()
    url
  }
}

@Cxx(cxxType = "QUrl")
@include("<QUrl>")
class QUrlValue extends QUrl with ResultValue[QUrl] {
  protected[core] var _isAllocated = true
  override def free(): Unit = if(_isAllocated) super.free()
}