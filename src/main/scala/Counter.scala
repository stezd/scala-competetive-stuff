class Counter(val initialValue: BigInt = 0) {
  private var counter:BigInt = 0
  def increment(): Unit = {
    counter = counter + 1
  }

  def decrement(): Unit = {
    counter = counter - 1
  }

  def reset(): Unit = {
    counter = 0
  }
  def getVal: BigInt = counter
}
