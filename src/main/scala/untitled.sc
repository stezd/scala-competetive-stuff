import scala.annotation.tailrec
import scala.math.abs

val testList = List(1,2,3,4,5)
val testList2 = List(7,4,3,2,1)
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

isIncreasing(testList)
isDecreasing(testList2)