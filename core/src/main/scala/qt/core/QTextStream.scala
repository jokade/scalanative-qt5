package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.ResultValue
import scala.scalanative.interop.AutoReleasable

/**
 * @see [[https://doc.qt.io/qt-5/qtextstream.html]]
 */
@Cxx
@include("<QTextStream>")
class QTextStream extends CxxObject with AutoReleasable {
  @returnsValue
  def readAll()(s: ResultValue[QString]): Unit = extern

  @inline final def >>(s: ResultValue[QString]): Unit = readAll()(s)

  @cxxBody("*__p << *s;")
  def writeAll(s: QString): Unit = extern

  @inline final def <<(s: QString): Unit = writeAll(s)

  @delete
  def free(): Unit = extern
}

object QTextStream {
  @constructor
  def apply(iodevice: QIODevice): QTextStream = extern
}