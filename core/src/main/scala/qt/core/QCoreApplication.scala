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
  def quit(): Unit = extern
}