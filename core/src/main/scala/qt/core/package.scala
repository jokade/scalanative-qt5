package qt

import scala.scalanative.runtime.RawPtr
import scalanative.unsafe._

package object core {

  type SignalCallbackCtx = RawPtr

  type SignalCallback0 = CFuncPtr1[RawPtr,Unit]
  type SignalCallback1[T1] = CFuncPtr2[RawPtr,T1,Unit]
  type SignalCallback2[T1,T2] = CFuncPtr3[RawPtr,T1,T2,Unit]
  type SignalCallback3[T1,T2,T3] = CFuncPtr4[RawPtr,T1,T2,T3,Unit]
  type SignalCallback4[T1,T2,T3,T4] = CFuncPtr5[RawPtr,T1,T2,T3,T4,Unit]
  type SignalCallback5[T1,T2,T3,T4,T5] = CFuncPtr6[RawPtr,T1,T2,T3,T4,T5,Unit]
  type SignalCallback6[T1,T2,T3,T4,T5,T6] = CFuncPtr7[RawPtr,T1,T2,T3,T4,T5,T6,Unit]
  type SignalCallback7[T1,T2,T3,T4,T5,T6,T7] = CFuncPtr8[RawPtr,T1,T2,T3,T4,T5,T6,T7,Unit]
  type SignalCallback8[T1,T2,T3,T4,T5,T6,T7,T8] = CFuncPtr9[RawPtr,T1,T2,T3,T4,T5,T6,T7,T8,Unit]
  type SignalCallback9[T1,T2,T3,T4,T5,T6,T7,T8,T9] = CFuncPtr10[RawPtr,T1,T2,T3,T4,T5,T6,T7,T8,T9,Unit]

  type qint64 = CLongLong
}
