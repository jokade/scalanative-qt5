import qt.widgets.{QApplication, QMainWindow, QPushButton}

import scala.scalanative.runtime.{Intrinsics, RawPtr}
import scalanative._
import unsafe._

object Main {
  def main(args: Array[String]): Unit = {
    val app = QApplication(args)
    val win = QMainWindow()

    val btn = QPushButton(c"Hello!")
    win.setCentralWidget(btn)

    btn.onReleased(() => println("FOO"))
    win.show()
    QApplication.exec()
  }
}
