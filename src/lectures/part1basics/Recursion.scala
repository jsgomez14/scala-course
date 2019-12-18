package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int =
    if(n==1) 1
    else {
      println("Compurting factorial of "+ n+ " - I first need factorial of "+(n-1))
      val result = n*factorial(n-1)
      println("Computed factorial of "+n)
      result
    }

  println(factorial(10))

  def anotherFactorial(n: Int): BigInt = {
    def factHelper(x: Int, acc: BigInt): BigInt =
      if(x<=1) acc
      else factHelper(x-1, x*acc) // TAIL RECURSION = use recursive call as the LAST expression.
    factHelper(n, 1)
  }

  println(anotherFactorial(5000))

  //WHEN YOU NEED LOOPS USE _TAIL_ RECURSION

  /*
  1. Concatenate string n times
   */
  def concat(s: String, n: Int): String = {
    def concatHelper(act: String, i: Int): String = {
      if(i <= 1) act
      else concatHelper(act+" "+s, i-1)
    }
    concatHelper(s, n)
  }

  def concatTailrec(s: String, n: Int, acc: String): String =
    if(n <= 0) acc
    else concatTailrec(s, n-1, acc+" "+s)

  println(concat("Jackie HP", 10))

  def isPrime (n:Int): Boolean = {
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean =
      if(!isStillPrime) false
      else if(t<=1) true
      else isPrimeTailRec(t-1, n%t!=0 && isStillPrime)
    isPrimeTailRec(n/2, true)
  }

  def fibonacci (n: Int): Int = {
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailRec(i+1, last+nextToLast, last)

    if(n <= 2) 1
    else fiboTailRec(2, 1, 1)
  }

  println(fibonacci(8))
}
