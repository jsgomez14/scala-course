package lectures.part1basics

object Functions extends App {
  def aFunction (a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("a",3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if(n==1) aString
    else aString +" "+ aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello", 3))
  // WHEN YOU NEED LOOPS, USE RECURSION (Use return type in recursive functions)

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n-1)
  }

  def greeting(name: String, age: Int) = "Hi my name is "+name+" and I am "+age+" years old"
  def factorial(n: Int): Int = {
    if(n<=1) 1
    else n*factorial(n-1)
  }
  println(factorial(10))

  def fibonacci(n: Int): Int =
    if(n<=1) 1
    else fibonacci(n-1) + fibonacci(n - 2)


  def isPrime (n:Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if(t<=1) true
      else n % t != 0 && isPrimeUntil(t-1)
    isPrimeUntil(n/2)
  }

}
