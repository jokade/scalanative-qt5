package qt.core

import de.surfice.smacrotools.debug
import qt.macros.Qt

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.cobj.{CObject, CObjectWrapper}
import scala.scalanative.interop.AutoReleasable


@Qt
@include("<QObject>")
class QObject extends CxxObject with AutoReleasable {
  def blockSignals(block: Boolean): Boolean = extern
  def signalsBlocked: Boolean = extern

  @returnsConst
  def parent: QObject = extern

  @cxxBody("return __p->findChild<QObject *>(*name);")
  def findChild[T<:QObject](@ref name: QString)(implicit wrapper: CObjectWrapper[T]): T = extern

  def findChildren[T<:QObject](names: String*)(implicit wrapper: CObjectWrapper[T]): Seq[T] = QZone{ implicit z =>
    names.map{ s =>
      val name = QString(s)
      findChild[T](name)
    }
  }

  @cxxBody("return __p->objectName().toLatin1().data_ptr()->data();")
  def objectNameCString(): CString = extern
  def objectName: String = fromCString(objectNameCString())

  def deleteLater(): Unit = extern
  def free(): Unit = deleteLater()
}

object QObject {
  implicit final class Implicit(val o: QObject) extends AnyVal {
    def rawPtr: Ptr[Byte] = o.__ptr
  }
}
