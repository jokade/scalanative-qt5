import calculator.Calculator
import notepad.Notepad
import qt.widgets.QApplication

import scala.scalanative.interop.AutoreleasePool

object Main {
  def main(args: Array[String]): Unit = AutoreleasePool{ implicit pool =>
    val app = QApplication(args)

    val calc = Calculator().autorelease
    calc.show()

    val notepad = Notepad().autorelease
    notepad.show()

    QApplication.exec()
  }
}
