package notepad

import qt.core.{QDir, QFile, QString}
import qt.macros._
import qt.uitools.QUiLoader
import qt.widgets._

import scala.scalanative.unsafe._

@Qt(cxxType = "QWidget")
class Notepad extends QWidget {

  val Seq(actionNew, actionOpen, actionSave, actionSaveAs, actionPrint, actionExit) =
    findChildren[QAction]("actionNew","actionOpen","actionSave","actionSave_as","actionPrint","actionExit")

  actionNew.onTriggered(onNew)
  actionOpen.onTriggered(onOpen)
  actionSave.onTriggered(onSave)
  actionSaveAs.onTriggered(onSaveAs)
  actionPrint.onTriggered(onPrint)
  actionExit.onTriggered(onExit)

  def onNew(checked: Boolean): Unit = {
    println("NEW")
  }

  def onOpen(checked: Boolean): Unit = {
    println( QFileDialog.getOpenFileName(this,c"Open...") )
  }

  def onSave(checked: Boolean): Unit = {
    println("SAVE")
  }

  def onSaveAs(checked: Boolean): Unit = {
    println("SAVE AS")
  }

  def onPrint(checked: Boolean): Unit = {
    println("PRINT")
  }

  def onExit(checked: Boolean): Unit = {
    println("EXIT")
  }
}
object Notepad {
  def apply(): Notepad = QUiLoader.loadWidget[Notepad](
    QFile(c"demo/src/main/resources/notepad/notepad.ui"),
    Some(QDir(c"demo/src/main/resources/notepad")))
}
