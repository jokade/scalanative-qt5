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

  def findChild[T<:QObject](name: String)(implicit wrapper: CObjectWrapper[T]): T = QZone{ implicit z =>
    val _name = QString.value
    _name.set(name)
    findChild[T](_name)
  }

  def findChildren[T<:QObject](names: String*)(implicit wrapper: CObjectWrapper[T]): Seq[T] = QZone{ implicit z =>
    val name = QString.value
    names.map{ s =>
      name.set(s)
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
