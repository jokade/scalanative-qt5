package qt.widgets

import de.surfice.smacrotools.debug
import qt.core.{QPoint, QRect, QString, QZone, QtAlignment}

import scalanative._
import unsafe._
import cxx._
import qt.macros._

import scala.scalanative.cobj.{ResultPtr, ResultValue}

/**
 * @see [[https://doc.qt.io/qt-5/qlineedit.html]]
 */
@Qt
@include("<QLineEdit>")
@debug
class QLineEdit extends QWidget {

  def addAction(action: QAction, position: QLineEditActionPosition.Value): Unit = extern

  def alignment: QtAlignment.Value = extern
  def setAlignment(f: QtAlignment.Value): Unit = extern

  def backspace(): Unit = extern

  def completer: QCompleter = extern
  def setCompleter(c: QCompleter): Unit = extern

  def createStandardContextMenu(): QMenu = extern

  def cursorBackward(mark: Boolean, steps: Int): Unit = extern
  def cursorForward(mark: Boolean, steps: Int): Unit = extern

//  def cursorPositionAt(@ref point: QPoint): Int = extern

//  @returnsValue
//  def cursorRect(rect: ResultValue[QRect]): Unit = extern

  def cursorWordBackward(mark: Boolean): Unit = extern
  def cursorWordForward(mark: Boolean): Unit = extern

  def del(): Unit = extern

  def deselect(): Unit = extern

  @returnsValue
  def displayText(text: ResultValue[QString]): Unit = extern
  def displayText: String = QString.withValue{ s =>
    s := displayText
    s.utf8String
  }

  def end(mark: Boolean): Unit = extern

  def home(mark: Boolean): Unit = extern

  @returnsValue
  def inputMask(text: ResultValue[QString]): Unit = extern
  def inputMask: String = QString.withValue{ s =>
    s := inputMask
    s.utf8String
  }

  def setInputMask(@ref mask: QString): Unit = extern
  def setInputMask(mask: String): Unit = QString.withValue(mask)(setInputMask)

  def insert(@ref newText: QString): Unit = extern
  def insert(newText: String): Unit = QString.withValue(newText)(insert)

  def maxLength: Int = extern
  def setMaxLength(maxLength: Int): Unit = extern

  def isReadOnly: Boolean = extern
  def setReadOnly(f: Boolean): Unit = extern

  def clear(): Unit = extern

  @returnsValue
  def placeholderText(s: ResultValue[QString]): Unit = extern
  def placeholderText: String = QString.withValue{ s =>
    s := placeholderText
    s.utf8String
  }

  def setPlaceholderText(@ref text: QString): Unit = extern
  def setPlaceholderText(text: String): Unit = QString.withValue(text)(setPlaceholderText)

  def selectionEnd: Int = extern

  def selectionLength: Int = extern

  def selectionStart: Int = extern

  def setSelection(start: Int, length: Int): Unit = extern

  @returnsValue
  def text(s: ResultValue[QString]): Unit = extern
  def text: String = QString.withValue{ s =>
    text(s)
    s.utf8String
  }
  def setText(@ref text: QString): Unit = extern
  def setText(text: String): Unit = QString.withValue(text)(setText)

  def getTextMargins(left: ResultPtr[Int], top: ResultPtr[Int], right: ResultPtr[Int], bottom: ResultPtr[Int]): Unit = extern
  def textMargins: (Int,Int,Int,Int) = {
    val left = ResultPtr.stackalloc[Int]
    val top = ResultPtr.stackalloc[Int]
    val right = ResultPtr.stackalloc[Int]
    val bottom = ResultPtr.stackalloc[Int]
    getTextMargins(left,top,right,bottom)
    (!left.ptr,!top.ptr,!right.ptr,!bottom.ptr)
  }

  def setTextMargins(left: Int, top: Int, right: Int, bottom: Int): Unit = extern

}

object QLineEdit {
  @constructor
  def apply(contents: CString): QLineEdit = extern

  def apply(): QLineEdit = apply(c"")
}