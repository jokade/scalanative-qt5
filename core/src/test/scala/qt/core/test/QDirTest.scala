package qt.core.test

import qt.core.{QDir, QDirValue, QString, QStringList, QStringListValue, QStringValue}
import utest._

import scala.scalanative.cobj.ResultValue
import scalanative._
import unsafe._

object QDirTest extends TestSuite {
  val tests = Tests {
    'basic-{
      val dir = QDir(c"./core/src/test/resources")
      val s = QStringValue()
      dir.exists ==> true

      dir.absolutePath.endsWith("resources") ==> true
      s := dir.absolutePath()
      s.toString.endsWith("resources") ==> true

      dir.canonicalPath.endsWith("resources") ==> true
      s := dir.canonicalPath()
      s.toString.endsWith("resources") ==> true

      dir.dirName ==> "resources"
      s := dir.dirName()
      s.toString.endsWith("resources") ==> true

      dir.isRelative ==> true

      dir.path.endsWith("resources") ==> true
      s := dir.path()
      s.toString.endsWith("resources") ==> true

      dir.count ==> 3

      dir.cdUp() ==> true
      dir.dirName ==> "test"

      dir.makeAbsolute() ==> true
      dir.isAbsolute ==> true

      dir.free()
      s.free()
    }
    'current-{
      val dir = QDirValue()
      QDir.currentPath.endsWith("qt5") ==> true
      dir := QDir.current()
      dir.path.endsWith("qt5") ==> true
      dir.free()
    }
    'entryList-{ Zone{ implicit z =>
      val dir = QDir(c"./core/src/test/resources")
      val entries = QStringList.value
      entries := dir.entryList()
      entries.size ==> 3

      val entry = QString.value
      entry := entries.at(0)
      entry.toString ==> "."

      entry := entries.at(1)
      entry.toString ==> ".."

      entry := entries.at(2)
      entry.toString ==> "test.txt"

      dir.free()
    }}
  }
}
