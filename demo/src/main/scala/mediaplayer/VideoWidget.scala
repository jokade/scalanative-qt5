package mediaplayer

import qt.macros.Qt
import qt.multimediawidgets.QVideoWidget
import qt.widgets.QWidget

import scala.scalanative._
import unsafe._
import cxx._

@Qt(cxxType = "QVideoWidget")
@include("<QVideoWidget>")
class VideoWidget extends QVideoWidget {

}
object VideoWidget {
  @constructor("QVideoWidget")
  def apply(parent: QWidget): VideoWidget = extern
}
