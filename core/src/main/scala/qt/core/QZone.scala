package qt.core

import scala.scalanative.unsafe.Zone

object QZone {

  @inline final def apply[T](block: Zone=>T): T = Zone.apply(block)
}
