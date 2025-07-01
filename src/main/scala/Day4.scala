import scala.io.Source
import scala.util.Using
import scala.collection.mutable.ListBuffer

object Day4 {
  private def absorbFile(): List[List[String]] = {
    val bufferList = ListBuffer[List[String]]()
    Using(Source.fromFile("input/inputDay4.txt")) { source =>
      for {
        line <- source.getLines()
        ls = line.trim.map(_.toString).toList
      } bufferList += ls
    }.recover {
      case e => println(s"Error: Could not process the file: ${e.getMessage}")
    }
    bufferList.toList
  }
  def main(args: Array[String]): Unit = {
    val word = "XMAS"
    val list = absorbFile()

    def rows(ls: List[List[String]]) = ls.map(_.mkString)

    def cols(ls: List[List[String]]) = ls.transpose.map(_.mkString)

    def mainDiagonals(ls: List[List[String]]) = {
      val n = ls.length
      (0 until n).flatMap(i =>
        Some((0 until n - i).map(k => ls(i + k)(k)).mkString) ++
                (if (i > 0) Some((0 until n - i).map(k => ls(k)(i + k)).mkString) else None)
      ).toList
    }

    def antiDiagonals(ls: List[List[String]]) = {
      val n = ls.length
      (0 until n).flatMap(i =>
        Some((0 until n - i).map(k => ls(i + k)(n - 1 - k)).mkString) ++
                (if (i > 0) Some((0 until n - i).map(k => ls(k)(n - 1 - i - k)).mkString) else None)
      ).toList
    }

    def countWord(word: String, lines: List[String]): Int =
      lines.flatMap { s =>
        List(s, s.reverse)
      }.map(line => word.r.findAllMatchIn(line).length).sum

    val linesToSearch =
      rows(list) ++
              cols(list) ++
              mainDiagonals(list) ++
              antiDiagonals(list)

    val totalXmas = countWord(word, linesToSearch)

    println(totalXmas)
  }
}
