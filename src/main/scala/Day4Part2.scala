import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.util.Using

object Day4Part2 {
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

    private def isMAS(triple: (Char, Char, Char)): Boolean = {
        triple == ('M', 'A', 'S') || triple == ('S', 'A', 'M')
    }

    private def countXMAS(grid: Vector[Vector[Char]]): Int = {
        val rows = grid.length
        val cols = if (rows > 0) grid(0).length else 0

        var count = 0

        for {
            i <- 1 until rows - 1
            j <- 1 until cols - 1
            if grid(i)(j) == 'A'
        } {
            val diag1 = (grid(i - 1)(j - 1), grid(i)(j), grid(i + 1)(j + 1)) // \
            val diag2 = (grid(i - 1)(j + 1), grid(i)(j), grid(i + 1)(j - 1)) // /

            if (isMAS(diag1) && isMAS(diag2)) {
                count += 1
            }
        }
        count
    }

    def main(args: Array[String]): Unit = {
        val list = absorbFile()
        val grid = list.map(_.toVector.flatten).toVector

        val res = countXMAS(grid)
        print(res)
    }
}
