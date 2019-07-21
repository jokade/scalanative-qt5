package qt.core.test

import qt.core.{QList, QListLike, QString, QStringList, QVector}
import utest._

import scala.scalanative.cobj.CObject
import scalanative._
import unsafe._

trait QListLikeTest extends TestSuite {
  def empty[T<:CObject](): QListLike[T]

  val s1 = QString(c"s1")
  val s2 = QString(c"s2")
  val s3 = QString(c"s3")
  val s2a = QString(c"s2a")
  val foo = QString(c"foo")

  val tests = Tests {
    'ListOfQStrings-{
      val list = QList[QString]()
      list.append(s1)
      list.size ==> 1
      list.at(0).toString ==> "s1"

      list.append(s2)
      list.size ==> 2
      list(0).toString ==> "s1"
      list(1).toString ==> "s2"

      list.append(s3)
      list.first().toString ==> "s1"
      list.last().toString ==> "s3"

      list.insert(3,s2a)
      list(3).toString ==> "s2a"

      list(3) = foo
      list(3).toString ==> "foo"

      list.free()
    }
  }
}

object QListTest extends QListLikeTest {
  override def empty[T<:CObject](): QListLike[T] = QList[T]()
}

object QVectorTest extends QListLikeTest {
  override def empty[T<:CObject](): QListLike[T] = QVector[T]()
}

