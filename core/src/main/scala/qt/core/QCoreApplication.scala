package qt.core

import scalanative._
import unsafe._
import cxx._
import qt.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qcoreapplication.html]]
 */
@Qt
@include("<QCoreApplication>")
class QCoreApplication extends {

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

  def exec(): Int = extern

  def quit(): Unit = extern
}