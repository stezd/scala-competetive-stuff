import scala.annotation.tailrec
import scala.io.StdIn.*
import scala.language.postfixOps
import scala.util.{Failure, Success, Try}

object PrimeNumber {
  private val counter1 = Counter()
  private val counter2 = Counter()
  @tailrec
  private def isPrimeRecursive(num: Int, divisor: Int): Boolean = {
    counter1.increment()
    if (divisor * divisor > num) return true
    if (num % divisor eq 0) return false
    isPrimeRecursive(num, divisor + 2)
  }

  private def isPrime(num: Int): Boolean = {
    counter2.increment()
    if (num <= 2 || num % 2 == 0)
      num == 2
    else isPrimeRecursive(num, 3)
  }

  private def InputToList(input: String): List[Int] = {
    input.split(":").map(_.toInt) match {
      case Array(start, end) => Try(start to end).map(_.toList).getOrElse(List())
      case _ => List()
    }
  }

  private def validateInput(input: String): Try[String] = {
    if (input.matches("([0-9]+):([0-9]+)")) Success(input)
    else Failure(new IllegalArgumentException("You're a Dumbfuck.\nInvalid input format! Please use format 'start:end' (e.g., '2:5')"))
  }

  def main(args: Array[String]): Unit = {
    println("Choose start:end number! (example: \"2:5\" which means 2 to 5)")
    val Input = readLine().trim
    validateInput(Input).get // This will throw an exception if validation fails
    val filteredNumList = for {
      x <- InputToList(Input)
      if isPrime(x)
    } yield x

    val StringifiedNumList = filteredNumList.map(x => x.toString).map(y => y + " ").fold("")(_ + _).trim
    println(StringifiedNumList)
    println(s"Function isPrimeRecursive Count = ${counter1.getVal}")
    println(s"Function isPrime Count = ${counter2.getVal}")
    println(s"Total Count = ${counter1.getVal+counter2.getVal}")
  }
}
