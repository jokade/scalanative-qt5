package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.ResultValue
import scala.scalanative.interop.AutoReleasable

/**
 * @see [[https://doc.qt.io/qt-5/qurlquery.html]]
 */
@Qt
@include("<QUrlQuery>")
class QUrlQuery extends CxxObject with AutoReleasable {

  def addQueryItem(@ref key: QString, @ref value: QString): Unit = extern
  def addQueryItems(items: Iterable[(String,String)]): Unit = QZone{ implicit z =>
    val key = QString.value
    val value = QString.value
    items.foreach{p =>
      key.set(p._1)
      value.set(p._2)
      addQueryItem(key,value)
    }
  }

  @returnsValue
  def query()(query: ResultValue[QString]): Unit = extern

  def query: String = QZone{ implicit z =>
    val str = QString.value
    str := query()
    str.utf8String
  }

  @delete
  override def free(): Unit = extern
}

object QUrlQuery {
  @constructor
  def apply(): QUrlQuery = extern

  def apply(items: Iterable[(String,String)]): QUrlQuery = {
    val q = apply()
    q.addQueryItems(items)
    q
  }
}