package qt.core.test

import qt.core.QDir
import utest._

import scala.scalanative.cobj.ResultValue
import scalanative._
import unsafe._

object QDirTest extends TestSuite {
  val tests = Tests {
    'basic-{
      val dir = QDir(c"./core/src/test/resources")
      dir.exists ==> true
      dir.absolutePath.endsWith("resources") ==> true
      dir.canonicalPath.endsWith("resources") ==> true
      dir.dirName ==> "resources"
      dir.isRelative ==> true
      dir.path ==> "resources"
      dir.count ==> 3

      dir.cdUp() ==> true
      dir.dirName ==> "test"

      dir.makeAbsolute() ==> true
      dir.isAbsolute ==> true

      dir.free()
    }
//    'current-{
//      val dir = QDir()
//      QDir.current()(ResultValue(dir))
//      println( dir.path )
//    }
    'currentPath-{
      QDir.currentPath.endsWith("qt5") ==> true
    }
    'entryList-{
      val dir = QDir(c"./core/src/test/resources")
      dir.withEntryList{entries =>
        entries.size ==> 3
        entries(2) ==> "test.txt"
      }
      dir.free()
    }
  }
}
