package qt.multimedia

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.interop.AutoReleasable

/**
 * @see [[https://doc.qt.io/qt-5/qmediacontent.html]]
 */
@Qt
@include("<QMediaContent>")
class QMediaContent extends CxxObject with AutoReleasable {
  @delete
  override def free(): Unit = extern
}

object QMediaContent {
}