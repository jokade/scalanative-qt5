package qt.core

import scala.scalanative.runtime.{Intrinsics, RawPtr}
import scala.scalanative.unsafe._

object SignalCallback {
  implicit final class SCFunction0(val f: Function0[_]) extends AnyVal {
    def toCtx: SignalCallbackCtx = Intrinsics.castObjectToRawPtr(f)
  }
  implicit final class SCFunction1(val f: Function1[_,_]) extends AnyVal {
    def toCtx: SignalCallbackCtx = Intrinsics.castObjectToRawPtr(f)
  }
  implicit final class SCFunction2(val f: Function2[_,_,_]) extends AnyVal {
    def toCtx: SignalCallbackCtx = Intrinsics.castObjectToRawPtr(f)
  }

  def fromFunction0(cb: Function0[Unit]): SignalCallback0 = new CFuncPtr1[RawPtr,Unit] {
    override def apply(ctx: RawPtr): Unit = Intrinsics.castRawPtrToObject(ctx).asInstanceOf[Function0[Unit]].apply()
  }

  def fromFunction1[T1](cb: Function1[T1,Unit]): SignalCallback1[T1] = new CFuncPtr2[RawPtr,T1,Unit] {
    override def apply(ctx: RawPtr, arg1: T1): Unit = Intrinsics.castRawPtrToObject(ctx).asInstanceOf[Function1[T1,Unit]].apply(arg1)
  }

  def fromFunction2[T1,T2](cb: Function2[T1,T2,Unit]): SignalCallback2[T1,T2] = new CFuncPtr3[RawPtr,T1,T2,Unit] {
    override def apply(ctx: RawPtr, arg1: T1, arg2: T2): Unit = Intrinsics.castRawPtrToObject(ctx).asInstanceOf[Function2[T1,T2,Unit]].apply(arg1,arg2)
  }
}
