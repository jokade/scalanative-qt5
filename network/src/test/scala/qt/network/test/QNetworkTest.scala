package qt.network.test

import qt.core.QUrl
import qt.network.{QNetworkAccessManager, QNetworkRequest}
import utest._
import scalanative._
import unsafe._

object QNetworkTest extends TestSuite {
  val tests = Tests{
    'get-{
      val mgr = QNetworkAccessManager()
//      val url = QUrl(c"http://www.google.de")
//      val req = QNetworkRequest(url)
//      val resp = mgr.get(req)
//      println(resp)
//      mgr.free()
//      url.free()
    }
  }
}
