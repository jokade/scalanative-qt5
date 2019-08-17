package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.ResultValue

/**
 * @see [[https://doc.qt.io/qt-5/qsize.html]]
 */
@Cxx
@include("<QSize>")
class QSize extends Value {
  def height: Int = extern
  def setHeight(h: Int): Unit = extern

  def width: Int = extern
  def setWidth(w: Int): Unit = extern

  def isNull: Boolean = extern
  def isValid: Boolean = extern

  override protected[qt] def initValue(): Unit = {}
}

object QSize extends ValueProvider[QSize] {
  override def value(implicit zone: Zone): QSizeValue = {
    val ptr = unsafe.alloc[Byte](__sizeof)
    val size = new QSizeValue(ptr)
    size
  }
}

@Cxx(cxxType = "QSize")
@include("<QSize>")
class QSizeValue extends QSize with ResultValue[QSize] {
}