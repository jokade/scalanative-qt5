package qt.multimedia

import de.surfice.smacrotools.debug
import javax.tools.ForwardingFileObject
import qt.core.{QObject, QString, QStringList, QVariant, SignalCallback0, SignalCallback1, SignalCallback2}

import scalanative._
import unsafe._
import cxx._
import qt.macros._
import qt.core.SignalCallback._

import scala.scalanative.cobj.ResultValue
import scala.scalanative.runtime.RawPtr

/**
 * @see [[https://doc.qt.io/qt-5/qmediaobject.html]]
 */
@Qt
@include("<QMediaObject>")
class QMediaObject extends QObject {
  @returnsValue
  def availableMetaData()(l: ResultValue[QStringList]): Unit = extern
  def bind(obj: QObject): Boolean = extern
  def unbind(obj: QObject): Unit = extern
  def isMetaDataAvailable: Boolean = extern
//  @returnsValue
//  def metaData(@ref key: QString)(v: ResultValue[QVariant]): Unit = extern

  def notifyInterval: Int = extern
  def setNotifyInterval(i: Int): Unit = extern

  def service: QMediaService = extern

//  def onAvailabilityChanged(cb: SignalCallback1[QMultimediaAvailabilityStatus.Value], ctx: RawPtr): Unit = signal
//  def onAvailabilityChanged(cb: QMultimediaAvailabilityStatus.Value=>Unit): Unit = onAvailabilityChanged( fromFunction1(cb), cb.toCtx )
//  def onMetaDataChanged(cb: SignalCallback2[QString,QVariant], ctx: RawPtr): Unit = signal
//  def onMetaDataChanged(cb: (QString,QVariant)=>Unit): Unit = onMetaDataChanged( fromFunction2(cb), cb.toCtx )

  @cxxBody("QObject::connect(__p,QOverload<>::of(&QMediaObject::metaDataChanged),[cb,ctx](){ cb(ctx); });")
  def onMetaDataChanged(cb: SignalCallback0, ctx: RawPtr): Unit = signal
  def onMetaDataChanged(cb: ()=>Unit): Unit = onMetaDataChanged( fromFunction0(cb), cb.toCtx )
}

object QMediaObject {
}