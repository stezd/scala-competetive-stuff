import scala.io.Source
import scala.collection.mutable.ListBuffer
import scala.util.Using
import scala.math.abs

object Santa {
  private val listLeft = ListBuffer[Int]()
  private val listRight = ListBuffer[Int]()

  private def appendPair(left: Int, right: Int): Unit = {
    listLeft += left
    listRight += right
  }

  private def getZipped: List[(Int, Int)] =
    listLeft.sorted.zip(listRight.sorted).toList

  private def getListDelta: List[Int] =
    getZipped.map((x, y) => abs(x - y))

  private def fetchTheDamnSource(): Unit = {
    Using(Source.fromFile("input/inputSanta.txt")) { source =>
      for {
        line <- source.getLines()
        Array(left, right) = line.trim.split("\\s+")
      } appendPair(left.toInt, right.toInt)
    }.recover {
      case e => println(s"Error: Could not process the file: ${e.getMessage}")
    }
  }

  private def Santa1(): Unit = {
    fetchTheDamnSource()
    println("Jawaban Soal Santa Part 1: ")
    print(getListDelta.sum)
    println()
  }

  private def Santa2(): Unit = {
    val listKiriDistinct = listLeft.distinct.sorted.toList
    val listKananSorted = listRight.sorted.toList

    val listKananMap = listKananSorted.groupBy(identity).view.mapValues(_.size).toMap
    val mult = listKiriDistinct.map(x => x * listKananMap.getOrElse(x,0))
    print(mult.sum)
  }
  def main(args: Array[String]): Unit = {
    Santa1()
    Santa2()
  }
}