package qt.multimedia

import de.surfice.smacrotools.debug
import qt.core.QObject

import scala.scalanative.cxx.Cxx

/**
 * Dummy trait to avoid a dependency cycle between this module and 'multimediawidgets'.
 * QVideoWidget in 'multimediawidgets' inherits this and thus can be passed to functions in QMediaPlayer.
 */
@Cxx(classname = "QVideoWidget")
trait QVideoWidgetLike extends QObject
