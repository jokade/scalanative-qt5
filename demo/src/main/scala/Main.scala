import calculator.Calculator
import qt.core.{QByteArray, QList, QObject, QString}
import qt.widgets.{QApplication, QMainWindow, QPushButton}

import scala.scalanative.cobj.ResultValue
import scala.scalanative.runtime.{Intrinsics, RawPtr}
import scalanative._
import unsafe._

object Main {
  def main(args: Array[String]): Unit = Zone{ implicit z =>
    val app = QApplication(args)
    val win = QMainWindow()

    val calc = Calculator()
    win.setCentralWidget(calc)
    win.setWindowTitle("Calculator")

//    val list = QList[QString]()
//    println(QByteArray.__sizeof)
    val s = QString(c"Hello")
    println( s.latin1String)

    win.show()
    QApplication.exec()
  }
}
