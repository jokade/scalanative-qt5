package notepad

import qt.core.{OpenMode, QCoreApplication, QDir, QFile, QIODevice, QString, QStringValue, QTextStream}
import qt.gui.QFontValue
import qt.macros._
import qt.uitools.QUiLoader
import qt.widgets._

import scala.scalanative.interop.AutoreleasePool
import scala.scalanative.unsafe._

@Qt(cxxType = "QWidget")
class Notepad extends QWidget {
  private val currentFile = QStringValue()
  private val text = QStringValue()

  override def free(): Unit = {
    // free explicitly allocated instances
    currentFile.free()
    text.free()
    // free Qt object
    super.free()
  }

  // get components defined in UI file
  val textEdit = findChild[QTextEdit]("textEdit")

  // get actions defined in UI file
  val Seq(actionNew, actionOpen, actionSave, actionSaveAs, actionPrint, actionExit,
    actionCopy, actionPaste, actionCut,actionUndo,actionRedo,actionFont) =
    findChildren[QAction]("actionNew","actionOpen","actionSave","actionSave_as","actionPrint","actionExit",
      "actionCopy","actionPaste","actionCut","actionUndo","actionRedo","actionFont")

  // connect actions with callbacks
  actionNew.onTriggered(onNew)
  actionOpen.onTriggered(onOpen)
  actionSave.onTriggered(onSave)
  actionSaveAs.onTriggered(onSaveAs)
  actionPrint.onTriggered(onPrint)
  actionExit.onTriggered(onExit)
  actionCopy.onTriggered(onCopy)
  actionUndo.onTriggered(onUndo)
  actionRedo.onTriggered(onRedo)
  actionFont.onTriggered(onFont)

  def onNew(checked: Boolean): Unit = {
    textEdit.clear()
    currentFile.clear()
    setWindowTitle("")
  }

  def onOpen(checked: Boolean): Unit = AutoreleasePool{ implicit pool =>
    currentFile := QFileDialog.getOpenFileName(this)
    val file = QFile(currentFile).autorelease
    if (file.open(OpenMode.ReadOnly | OpenMode.Text)) {
      setWindowTitle(currentFile)
      val stream = QTextStream(file).autorelease
      stream >> text
      textEdit.setText(text)
      file.close()
    } else {
      QMessageBox.warning(this,"Warning","Cannot open file: "+file.errorMessage)
    }
  }

  private def save(): Unit = AutoreleasePool{ implicit pool =>
    val file = QFile(currentFile).autorelease
    if(file.open(OpenMode.WriteOnly | OpenMode.Text)) {
      setWindowTitle(currentFile)
      val stream = QTextStream(file).autorelease
      text := textEdit.toPlainText()
      stream << text
      file.close()
    }
    else {
      QMessageBox.warning(this,"Warning","Cannot save file: "+file.errorMessage)
    }
  }

  def onSave(checked: Boolean): Unit = AutoreleasePool{ implicit pool =>
    if(currentFile.isEmpty) {
      currentFile := QFileDialog.getSaveFileName(this)
    }
    save()
  }

  def onSaveAs(checked: Boolean): Unit = {
    currentFile := QFileDialog.getSaveFileName(this,"Save As")
    save()
  }

  def onPrint(checked: Boolean): Unit = {
    println("PRINT")
  }

  def onExit(checked: Boolean): Unit = {
    QCoreApplication.quit()
  }

  def onCopy(checked: Boolean): Unit = {
    textEdit.copy()
  }

  def onPaste(checked: Boolean): Unit = {
    textEdit.paste()
  }

  def onCut(checked: Boolean): Unit = {
    textEdit.cut()
  }

  def onUndo(checked: Boolean): Unit = {
    textEdit.undo()
  }

  def onRedo(checked: Boolean): Unit = {
    textEdit.redo()
  }

  def onFont(checked: Boolean): Unit = AutoreleasePool{ implicit z =>
    val font = QFontValue().autorelease
    if( font := QFontDialog.getFont(this) )
      textEdit.setFont(font)
  }
}
object Notepad {
  def apply(): Notepad = AutoreleasePool { implicit pool =>
    QUiLoader.loadWidget[Notepad](
      QFile(c"demo/src/main/resources/notepad/notepad.ui").autorelease,
      Some(QDir(c"demo/src/main/resources/notepad")))
  }
}

