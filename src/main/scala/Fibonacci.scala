object Fibonacci {
  //LazyList Implementation
  private lazy val fib: LazyList[Long] =
    0L #:: 1L #:: fib.zip(fib.tail).map {
      case (a, b) => a + b
    }

  //Recursion Implementation
  private def fibRecursion(n: Int): List[Int] =
    n match {
      case 0 => List(0)
      case 1 => List(0, 1)
      case _ =>
        val prev = fibRecursion(n - 1)
        prev :+ prev.takeRight(2).sum
    }

  def main(args: Array[String]): Unit =
    println(fib.take(10).toList)
}
