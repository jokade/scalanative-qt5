package qt.core.test

import qt.core.{QString, QStringValue}
import utest._

import scalanative._
import unsafe._

object QStringTest extends TestSuite {
  val tests = Tests {
    'createFromCString-{
      val s = QString(c"Hello")
      s.size ==> 5
    }
    'createFromString-{
      val s = Zone{ implicit z =>
        QString("Hello")
      }
      s.size ==> 5
    }
    'setValue-{ Zone { implicit z =>
      val qstr = QString.value
      qstr.set(c"world")
      qstr.toString ==> "world"
      qstr.set("hello")
      qstr.toString ==> "hello"
      qstr.free()
    }}
    'latin1String-{
      val s = QString(c"Hello")
      s.latin1String ==> "Hello"
    }
  }
}
