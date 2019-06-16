package qt.core

import qt.macros.Qt

import scalanative._
import unsafe._
import cxx._
import qt5.macros._

/**
 * @see [[https://doc.qt.io/qt-5/qstring.html]]
 */
@Qt
@include("<QString>")
class QString extends {

//  def toUtf8(): QByteArray = extern
//  def toLatin1(): QByteArray = extern
//  def toLocal8Bit(): QByteArray = extern
}

object QString {
}