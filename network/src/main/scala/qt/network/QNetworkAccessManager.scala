package qt.network

import de.surfice.smacrotools.debug
import qt.core.{QObject, QUrl, SignalCallback1}
import qt.core.SignalCallback._

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.interop.{AutoreleasePool, PoolZone}
import scala.scalanative.runtime.RawPtr

/**
 * @see [[https://doc.qt.io/qt-5/qnetworkaccessmanager.html]]
 */
@Qt
@include("<QNetworkAccessManager>")
@include("<QNetworkRequest>")
@debug
class QNetworkAccessManager extends QObject {
  // TODO: using the actual Qt signature get(QNetworkRequest) results in a runtime access error -> why?
  @cxxBody("return __p->get(QNetworkRequest(*url));")
  def get(@ref url: QUrl): QNetworkReply = extern

  def get(url: String): QNetworkReply = {
    val _url = QUrl(url)
    val res = get(_url)
    _url.free()
    res
  }
//  def onFinished(cb: SignalCallback1[QNetworkReply], ctx: RawPtr): Unit = signal
//  def onFinished(cb: Function1[QNetworkReply,Unit]): Unit = onFinished( fromFunction1(cb), cb.toCtx )
}

object QNetworkAccessManager {
  @constructor
  def apply(): QNetworkAccessManager = extern
}