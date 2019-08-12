package qt.network

import qt.core.QUrl

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.ResultValue
import scala.scalanative.interop.AutoReleasable

/**
 * @see [[https://doc.qt.io/qt-5/qnetworkrequest.html]]
 */
@Qt
@include("<QNetworkRequest>")
class QNetworkRequest extends AutoReleasable {
  def setUrl(@ref url: QUrl): Unit = extern
  def url()(url: ResultValue[QUrl]): Unit = extern
  @delete
  override def free(): Unit = extern
}

object QNetworkRequest {
  @constructor
  def apply(): QNetworkRequest = extern
  @constructor
  def apply(@ref url: QUrl): QNetworkRequest = extern
}