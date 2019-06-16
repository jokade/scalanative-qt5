package qt.widgets

import de.surfice.smacrotools.debug
import qt.macros.Qt
import qt.core.QObject

import scalanative._
import unsafe._
import cxx._
import qt.macros._

@Qt
@include("<QApplication>")
class QApplication extends QObject {

}

object QApplication {
  private var _app: QApplication = _

  def apply(args: Array[String]): QApplication =
    if(_app != null)
      throw new RuntimeException("QApplication already initialized")
    else {
      _app = create(0,null)
      _app
    }

  @constructor
  private def create(argc: Int, argv: Ptr[CString]): QApplication = extern

  def exec(): Int = extern

}
