package qt.widgets

import de.surfice.smacrotools.debug
import qt.core.{QString, QZone}
import qt.macros._

import scala.scalanative._
import scala.scalanative.cobj.ResultValue
import scala.scalanative.cxx._
import scala.scalanative.unsafe._

/**
 * @see [[https://doc.qt.io/qt-5/qfiledialog.html]]
 */
@Qt
@include("<QFileDialog>")
class QFileDialog extends QDialog {
}

object QFileDialog {
  // dummy definition to ensure that this object (and the @InlineSource annotation it carries) are reachable during linking
  val __dummy:QFileDialog = null

  @returnsValue
  def getOpenFileName(parent: QWidget, @ref caption: QString)(v: ResultValue[QString]): Unit = extern
  def getOpenFileName(parent: QWidget, caption: String = "")(v: ResultValue[QString]): Unit = QZone{ implicit z =>
    val s = QString.value
    if(caption!="")
      s.set(caption)
    getOpenFileName(parent,s)(v)
  }

//  @returnsValue
//  def getSaveFileName(parent: QWidget)(v: ResultValue[QString]): Unit = extern
  @returnsValue
  def getSaveFileName(parent: QWidget, @ref caption: QString, @ref dir: QString, @ref filter: QString)(v: ResultValue[QString]): Unit = extern
  def getSaveFileName(parent: QWidget, caption: String = "", dir: String = "", filter: String = "")(v: ResultValue[QString]): Unit = QZone{ implicit z =>
    val _caption = QString.value
    if(caption!="")
      _caption.set(caption)
    val _dir = QString.value
    if(dir!="")
      _dir.set(dir)
    val _filter = QString.value
    if(filter!="")
      _filter.set(filter)
    getSaveFileName(parent,_caption,_dir,_filter)(v)
  }
}



