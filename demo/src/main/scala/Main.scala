import calculator.Calculator
import qt.core.QString
import qt.widgets.{QApplication, QMainWindow, QPushButton}

import scala.scalanative.runtime.{Intrinsics, RawPtr}
import scalanative._
import unsafe._

object Main {
  def main(args: Array[String]): Unit = {
    val app = QApplication(args)
    val win = QMainWindow()

    val calc = Calculator()
    win.setCentralWidget(calc)
    win.setWindowTitle("Calculator")

    win.show()
    QApplication.exec()
  }
}
