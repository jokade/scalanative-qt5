package calculator

import de.surfice.smacrotools.debug
import qt.core.{QString, QtAlignment}

import scalanative._
import unsafe._
import cxx._
import qt.macros._
import qt.widgets.{QGridLayout, QLayout, QLineEdit, QMainWindow, QToolButton, QWidget, SizeConstraint}

@Qt(cxxType = "QWidget")
@include("<QWidget>")
class Calculator extends QWidget {
  private var _displayText = "0"
  private var _waitingForOperand = true

  setWindowTitle("Calcluator")

  val display = {
    val display = QLineEdit(c"")

    display.setReadOnly(true)
    display.setAlignment(QtAlignment.Right)
    display.setMaxLength(15)

    val font = display.font
    font.setPointSize(font.pointSize + 8)
    display.setFont(font)
    display
  }

  val digitButtons = Zone { implicit z =>
    (0 to 9).map(i => Button(toCString(i.toString),digitClicked(i)))
  }

  val pointButton = Button(c".",nop)
  val changeSignButton = Button(c"\302\261",changeSign)

  val backspaceButton = Button(c"Backspace",nop)
  val clearButton = Button(c"Clear",clear)
  val clearAllButton = Button(c"Clear All",nop)

  val clearMemoryButton = Button(c"MC",nop)
  val readMemoryButton = Button(c"MR",nop)
  val setMemoryButton = Button(c"MS",nop)
  val addToMemoryButton = Button(c"M+",nop)

  val divisionButton = Button(c"\303\267",nop)
  val timesButton = Button(c"\303\227",nop)
  val minusButton = Button(c"-",nop)
  val plusButton = Button(c"+",nop)

  val squareRootButton = Button(c"Sqrt",unaryOp(Sqrt))
  val powerButton = Button(c"x\302\262",nop)
  val reciprocalButton = Button(c"1/x",nop)
  val equalButton = Button(c"=",nop)
  
  val grid = QGridLayout()
  grid.setSizeConstraint(SizeConstraint.SetFixedSize)

  grid.addWidget(display,0,0,1,6)

  grid.addWidget(backspaceButton, 1, 0, 1, 2)
  grid.addWidget(clearButton, 1, 2, 1, 2)
  grid.addWidget(clearAllButton, 1, 4, 1, 2)

  grid.addWidget(clearMemoryButton, 2, 0)
  grid.addWidget(readMemoryButton, 3, 0)
  grid.addWidget(setMemoryButton, 4, 0)
  grid.addWidget(addToMemoryButton, 5, 0)

  digitButtons.zipWithIndex.tail.foreach{ p =>
    val row = ((9 - p._2) / 3) + 2
    val col = ((p._2 - 1) % 3) + 1
    grid.addWidget(p._1,row,col)
  }

  grid.addWidget(digitButtons(0), 5, 1)
  grid.addWidget(pointButton, 5, 2)
  grid.addWidget(changeSignButton, 5, 3)

  grid.addWidget(divisionButton, 2, 4)
  grid.addWidget(timesButton, 3, 4)
  grid.addWidget(minusButton, 4, 4)
  grid.addWidget(plusButton, 5, 4)

  grid.addWidget(squareRootButton, 2, 5)
  grid.addWidget(powerButton, 3, 5)
  grid.addWidget(reciprocalButton, 4, 5)
  grid.addWidget(equalButton, 5, 5)

  setLayout(grid)
  updateDisplay()

  private def nop(): Unit = {

  }

  private def digitClicked(digit: Int)() =
    if(_displayText == "0" && digit == 0) {}
    else {
      if(_waitingForOperand) {
        _displayText = ""
        _waitingForOperand = false
      }
      _displayText += digit
      updateDisplay()
    }

  private def unaryOp(op: UnaryOp)(): Unit = op match {
    case _ =>
  }

  private def updateDisplay(): Unit = {
    display.setText(_displayText)
  }

  private def clear(): Unit =
    if(_waitingForOperand) {}
    else {
      _displayText = "0"
      updateDisplay()
      _waitingForOperand = true
    }

  private def changeSign(): Unit = {
    val v = _displayText.toDouble
    _displayText = if(v > 0) "-"+_displayText else _displayText.tail
    updateDisplay()
  }

  sealed trait UnaryOp
  case object Sqrt extends UnaryOp
}

object Calculator {
  @constructor("QWidget")
  def apply(): Calculator = extern
}
