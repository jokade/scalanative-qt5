package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.ResultValue

/**
 * @see [[https://doc.qt.io/qt-5/qjsonparseerror.html]]
 */
@Cxx
@include("<QJsonParseError>")
class QJsonParseError extends Value {
  override protected[qt] def initValue(): Unit = {}

  def errorString()(str: ResultValue[QString]): Unit = extern

  def errorString: String = QZone{ implicit z =>
    val str = QString.value
    str := errorString()
    str.utf8String
  }
}

object QJsonParseError extends ValueProvider[QJsonParseError] {
  override def value(implicit zone: Zone): QJsonParseErrorValue = {
    val ptr = unsafe.alloc[Byte](__sizeof)
    new QJsonParseErrorValue(ptr)
  }
}

@Cxx(cxxType = "QJsonParseError")
@include("<QJsonParseError>")
class QJsonParseErrorValue extends QJsonParseError with ResultValue[QJsonParseError] {

}