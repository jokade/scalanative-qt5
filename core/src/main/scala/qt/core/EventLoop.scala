package qt.core

import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext

object EventLoop extends ExecutionContext {
//  private var _active = true
  private var _onFailure = (cause: Throwable) => println(cause)
  private lazy val (_queue, _timer): (ListBuffer[Runnable],QTimer) = {
    val timer = QTimer()
    timer.onTimeout(callback)
    (new ListBuffer,timer)
  }

  override def execute(runnable: Runnable): Unit = {
    _queue += runnable
  }

//  def queue(f: ()=>Any): Unit = execute(new Task(f))

  def onFailure(f: Function1[Throwable,Unit]): Unit = _onFailure = f

  override def reportFailure(cause: Throwable): Unit = _onFailure

  private def callback(): Unit =
    if(_queue.nonEmpty) {
      val runnable = _queue.remove(0)
      try{
        runnable.run()
      } catch {
        case t: Throwable => reportFailure(t)
      }
    }

  def run(): Int = {
    _timer.start()
    QCoreApplication.exec()
  }

  def quit(): Unit = QCoreApplication.quit()

  private class Task(f: ()=>Any) extends Runnable {
    override def run(): Unit = f()
  }
}

