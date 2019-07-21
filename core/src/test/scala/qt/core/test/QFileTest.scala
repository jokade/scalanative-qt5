package qt.core.test

import qt.core.QFile
import utest._
import scalanative._
import unsafe._

object QFileTest extends TestSuite {
  val tests = Tests {
    'NotExistent-{
      val file = QFile(c"foo")
      file.exists ==> false
      file.errorMessage ==> "Unknown error"
    }
    'Read-{
      val file = QFile(c"./core/src/test/resources/test.txt")
      file.exists ==> true
//      file.isReadable ==> true
    }
  }
}
