package qt.core

import scala.scalanative.cobj.{CObject, ResultValue}
import scala.scalanative.cxx.CxxObject
import scala.scalanative.unsafe.Zone

/**
 * Marker trait for all Qt classes that are used as (shared) values.
 */
trait Value extends CxxObject {

  /**
   * Called to initialize this instance with the default shared value (usually the shared null pointer)
   */
  protected[qt] def initValue(): Unit
}

trait ValueProvider[T <: CObject] { self: Singleton =>
  def value(implicit zone: Zone): ResultValue[T]
}
