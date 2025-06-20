import scala.io.Source
import scala.util.Using
import scala.collection.mutable.ListBuffer
import scala.util.matching.Regex


object Day3 {
  private val mulRegex: Regex = "mul\\((\\d+),(\\d+)\\)".r
  private val Regex2 = "(mul\\((\\d+),(\\d+)\\))|(do\\(\\))|(don't\\(\\))".r

  private def absorbFile2(): List[(Int, Int)] = {
    val bufferList = ListBuffer[(Int, Int)]()
    Using(Source.fromFile("input/inputDay3.txt")) { source =>
      for (line <- source.getLines()) {
        Regex2.findAllMatchIn(line).foreach { m =>
          if (m.group(2) != null && m.group(3) != null) {
            // mul(x, y)
            val n1 = m.group(2).toInt
            val n2 = m.group(3).toInt
            bufferList += ((n1, n2))
          } else if (m.group(4) != null) {
            // do()
            bufferList += ((0,0))
          } else if (m.group(5) != null) {
            // don't()
            bufferList += ((1,1))
          }
        }
      }
    }.recover {
      case e => println(s"Error: Could not process the file: ${e.getMessage}")
    }
    bufferList.toList
  }

  private def executeThing(ls: List[(Int, Int)], doThing: Boolean = true): Int = ls match {
    case Nil => 0
    case h :: tail =>
      if (h == (0, 0)) executeThing(tail)
      else if (h == (1, 1)) executeThing(tail, false)
      else if (doThing) h._1 * h._2 + executeThing(tail, doThing)
      else executeThing(tail, doThing)
  }

  private def absorbFile(): List[(Int, Int)] = {
    val bufferList = ListBuffer[(Int, Int)]()
    Using(Source.fromFile("input/inputDay3.txt")) { source =>
      for (line <- source.getLines()) {
        mulRegex.findAllMatchIn(line).foreach { m =>
          val n1 = m.group(1).toInt
          val n2 = m.group(2).toInt
          bufferList += ((n1, n2))
        }
      }
    }.recover {
      case e => println(s"Error: Could not process the file: ${e.getMessage}")
    }
    bufferList.toList
  }

  def main(args: Array[String]): Unit = {
    val list = absorbFile()
    val thing = list.map(x => x._1*x._2).sum
    println(thing)
    val list2 = absorbFile2()
    val thing2 = executeThing(list2)
    println(thing2)
  }
}
