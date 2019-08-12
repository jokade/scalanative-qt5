package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.ResultValue
import scala.scalanative.interop.AutoReleasable
import scala.util.{Failure, Success, Try}

/**
 * @see [[https://doc.qt.io/qt-5/qjsondocument.html]]
 */
@Cxx
@include("<QJsonDocument>")
@include("<QJsonObject>")
class QJsonDocument extends Value with AutoReleasable {
  def isEmpty: Boolean = extern
  def isNull: Boolean = extern
  def isArray: Boolean = extern
  def isObject: Boolean = extern

  @returnsValue
  @cxxName("object")
  def rootObject()(obj: ResultValue[QJsonObject]): Unit = extern

  def rootObject(implicit z: Zone): QJsonObject = {
    val obj = QJsonObject.value
    obj := rootObject()
    obj
  }

  @delete
  override def free(): Unit = extern

  override protected[qt] def initValue(): Unit = {}
}

object QJsonDocument extends ValueProvider[QJsonDocument] {
  override def value(implicit zone: Zone): QJsonDocumentValue = {
    val ptr = unsafe.alloc[Byte](__sizeof)
    val doc = new QJsonDocumentValue(ptr)
    doc._isAllocated = false
    doc.initValue()
    doc
  }

  @cxxBody("*(QJsonDocument*)res = QJsonDocument::fromJson(*json);")
  private def fromJson(@ref json: QByteArray, res: Ptr[Byte]): Unit = extern

  @cxxBody("*(QJsonDocument*)res = QJsonDocument::fromJson(*json,err);")
  private def fromJson(@ref json: QByteArray, res: Ptr[Byte], err: QJsonParseError): Unit = extern

  def fromJson(json: QByteArray)(doc: ResultValue[QJsonDocument]): Unit = fromJson(json,doc.__ptr)

  def fromJson(json: QByteArray)(implicit zone: Zone): Try[QJsonDocument] = {
    val doc = QJsonDocument.value
//    val err = QJsonParseError.value
    fromJson(json,doc.__ptr)
    if(doc.isNull)
      Failure(new RuntimeException("Could not parse JSON"))
    else
      Success(doc)
  }
}

@Cxx(cxxType = "QJsonDocument")
@include("<QJsonDocument>")
class QJsonDocumentValue extends QJsonDocument with ResultValue[QJsonDocument] {
  protected[core] var _isAllocated = true
  override def free(): Unit = if(_isAllocated) super.free()
}
object QJsonDocumentValue {
  @constructor("QJsonDocument")
  protected def newInstance(): QJsonDocumentValue = extern
}