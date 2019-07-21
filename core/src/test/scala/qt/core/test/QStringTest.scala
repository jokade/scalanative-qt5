package qt.core.test

import qt.core.QString
import utest._

import scalanative._
import unsafe._

object QStringTest extends TestSuite {
  val tests = Tests {
    'createFromCString-{
      val s = QString(c"Hello")
      s.size ==> 5
    }
    'latin1String-{
      val s = QString(c"Hello")
      s.latin1String ==> "Hello"
    }
  }
}
