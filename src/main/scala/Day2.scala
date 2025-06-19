import scala.annotation.tailrec
import scala.io.Source
import scala.math.abs
import scala.util.Using
import scala.collection.mutable.ListBuffer

object Day2 {
  @tailrec
  def isIncreasing(ls: List[Int]): Boolean = ls match {
    case Nil | _ :: Nil => true
    case a :: b :: tail => (a < b) && isIncreasing(b :: tail)
  }

  @tailrec
  def isDecreasing(ls: List[Int]): Boolean = ls match {
    case Nil | _ :: Nil => true
    case a :: b :: tail => (a > b) && isDecreasing(b :: tail)
  }

  @tailrec
  def withinThreeDelta(ls: List[Int]): Boolean = ls match {
    case Nil | _ :: Nil => true
    case a :: b :: tail => (abs(a - b) <= 3) && withinThreeDelta(b :: tail)
  }

  private def indicatorOfSafety(ls: List[Int]): Boolean =
    (isIncreasing(ls) || isDecreasing(ls)) && withinThreeDelta(ls)

  private def absorbFile(): List[List[Int]] = {
    val bufferList = ListBuffer[List[Int]]()
    Using(Source.fromFile("input/inputDay2.txt")) { source =>
      for {
        line <- source.getLines()
        ls = line.trim.split("\\s+").map(_.toInt).toList
      } bufferList += ls
    }.recover {
      case e => println(s"Error: Could not process the file: ${e.getMessage}")
    }
    bufferList.toList
  }

  private def removeOneRecursive(ls: List[Int], index: Int = 0): List[List[Int]] = ls match {
    case Nil => Nil
    case _ if index >= ls.length => Nil
    case _ =>
      val removed = ls.patch(index, Nil, 1)
      removed :: removeOneRecursive(ls, index + 1)
  }

  private def problemDampener(ls: List[Int]): (List[Int], Boolean) =
    if indicatorOfSafety(ls) then (ls, true)
    else {
      val res = removeOneRecursive(ls).map(x => indicatorOfSafety(x)).fold(false)(_ || _)
      (ls, res)
    }
  def main(args: Array[String]): Unit = {
    val damnListList = absorbFile()
    val dangerMap = damnListList.map(x => indicatorOfSafety(x)).groupBy(identity)
    println(s"Safe counts: ${dangerMap.getOrElse(true, Seq()).size}")
    println(s"Unsafe counts: ${dangerMap.getOrElse(false, Seq()).size}")
    println("______________________________________________________________________")

    val listForThing2 = damnListList.map(x => problemDampener(x)).groupBy(_._2)
    println(s"Safe counts after tolerances: ${listForThing2.getOrElse(true, Seq()).size}")
    println(s"Unsafe counts after tolerances: ${listForThing2.getOrElse(false, Seq()).size}")

  }
}
