package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qiodevice.html]]
 */
@Qt
@include("<QIODevice>")
class QIODevice extends QObject {
  def bytesAvailable(): qint64 = extern
  def bytesToWrite(): qint64 = extern
  def canReadLine(): Boolean = extern
  def close(): Unit = extern
  def commitTransaction(): Unit = extern
  def currentReadChannel(): Int = extern
  def currentWriteChannel(): Int = extern
//  @returnsConst
//  def errorString(): QString = extern
  @cxxBody("return __p->errorString().toLatin1().data_ptr()->data();")
  def errorCString(): CString = extern

  def errorMessage: String = fromCString(errorCString())

  def isOpen: Boolean = extern
  def isReadable: Boolean = extern
  def isSequential: Boolean = extern
  def isTextModeEnabled: Boolean = extern
  def isTransactionStarted: Boolean = extern
  def isWritable: Boolean = extern

  def open(mode: OpenMode.Value): Boolean = extern
  def openMode: OpenMode.Value = extern

  def pos: qint64 = extern
  def read(data: Ptr[Byte], maxSize: qint64): qint64 = extern
}

object QIODevice {
}