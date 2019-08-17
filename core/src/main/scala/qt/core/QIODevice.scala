package qt.core

import de.surfice.smacrotools.debug

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.ResultValue
import scala.scalanative.runtime.RawPtr
import qt.core.SignalCallback._

/**
 * @see [[https://doc.qt.io/qt-5/qiodevice.html]]
 */
@Qt
@include("<QIODevice>")
class QIODevice extends QObject {
  def bytesAvailable: qint64 = extern
  def bytesToWrite: qint64 = extern
  def canReadLine: Boolean = extern
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
  @returnsValue
  def read(maxSize: qint64)(arr: ResultValue[QByteArray]): Unit = extern
  @returnsValue
  def readAll()(arr: ResultValue[QByteArray]): Unit = extern

  def reset(): Boolean = extern
  def rollbackTransaction(): Unit = extern
  def seek(pos: qint64): Boolean = extern

  def size: qint64 = extern
  def skip(maxSize: qint64): qint64 = extern

  def onReadyRead(cb: SignalCallback0, ctx: RawPtr): Unit = signal
  def onReadyRead(cb: ()=>Unit): Unit = onReadyRead( fromFunction0(cb), cb.toCtx )
}

object QIODevice {
}