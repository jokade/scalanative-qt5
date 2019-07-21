package qt.core

import scala.scalanative.cobj.CObject
import scala.scalanative.interop.AutoReleasable

/**
 * Marker trait for all Qt classes that use implicitly shared data
 */
trait ImplicitlyShared extends CObject with AutoReleasable {

}
