package qt.core

import de.surfice.smacrotools.debug

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qcoreapplication.html]]
 */
@Qt
@include("<QCoreApplication>")
@debug
class QCoreApplication extends CxxObject {

}

object QCoreApplication {
  private var _app: QCoreApplication = _

  def apply(args: Array[String]): QCoreApplication =
    if(_app != null)
      throw new RuntimeException("QCoreApplication already initialized")
    else {
      _app = create(0,null)
      _app
    }

  @constructor
  private def create(argc: Int, argv: Ptr[CString]): QCoreApplication = extern

  // we're using @noinline here to ensure that the we get the @InlineSource annotation with the C++ wrapper code
  // for this object. Otherwise, the function mayber inlined, and we'll never see it during linking
  @noinline
  def exec(): Int = extern

  // see remark for exec()
  @noinline
  def quit(): Unit = extern
}