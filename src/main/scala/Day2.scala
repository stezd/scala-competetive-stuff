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

  private def IndicatorOfSafety(ls: List[Int]): Boolean =
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

  def main(args: Array[String]): Unit = {
    val damnListList = absorbFile()
    val dangerMap = damnListList.map(x => IndicatorOfSafety(x)).groupBy(identity)
    println(s"Safe counts: ${dangerMap.getOrElse(true, Seq()).size}")
    println(s"Unsafe counts: ${dangerMap.getOrElse(false, Seq()).size}")
  }
}
