package lectures.part2oop

object Exceptions extends App {
  val x: String = null

  //println(x.length)
  //this will crash with NPE
  // 1. throwing and catching exceptions
  //val weirdVal = throw new NullPointerException

  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. How to catch exceptions

  def getInt(withExcteptions: Boolean): Int =
    if(withExcteptions) throw new RuntimeException("No Int for you!")
    else 42

  val potentialFail = try {
    // Code that might throw
    getInt(true)
  } catch {
    case e: RuntimeException => 43
  } finally {
    // Code that will get executed NO MATTER WHAT
    // Optional
    // Do not influence the return type of this expression
    // Use it for logging (side effects)
    println("finally")
  }

  println(potentialFail)

  //3. How to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  //throw exception

  // Crash with Out Of Memory Error => OOM
  //val array = Array.ofDim(Int.MaxValue)
  // Crash with Stack Overflow Error => SO
  /*
  def infinite: Int = 1 + infinite
  val noLimit = infinite
  */

  class OverFlowException extends Exception
  class UnderFlowException extends Exception
  class MathCalculationException extends Exception("Division by zero")

  object PocketCalculator {
    def add(a: Int, b: Int) =
      if(a>0 && b>0 && a+b < 0) throw new OverFlowException
      else if(a<0 && b<0 && a+b > 0) throw new UnderFlowException
      else a+b
    def subtract(a:Int, b:Int) =
      if(a > 0 && b < 0 && a-b < 0) throw new OverFlowException
      else if(a < 0 && b > 0 && a-b > 0) throw new UnderFlowException
      else a-b
    def multiply(a: Int, b: Int) =
      if(a > 0 && b > 0 && a*b < 0) throw new OverFlowException
      else if(a < 0 && b < 0 && a*b < 0) throw new OverFlowException
      else if(a > 0 && b < 0 && a*b > 0) throw new UnderFlowException
      else if(a < 0 && b > 0 && a*b > 0) throw new UnderFlowException
      else a*b
    def divide(a: Int, b: Int) =
      if(b==0) throw new MathCalculationException
      else a/b
  }

  //println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 0))
}



