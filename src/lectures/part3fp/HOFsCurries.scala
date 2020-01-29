package lectures.part3fp

object HOFsCurries extends App {

  // Function receive: 1. Int, 2. Function(String, Fun(Int => Bool) => Int)
  // Function returns: function(int): int
  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null

  // Higher Order Functions (HOF)
  // map, flatmap, filter are HOF cause receive a function as parameter
  // function that applies a function n times over a value X
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x)))
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if(n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x+1
  println(nTimes(plusOne, 10, 1))


  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if(n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  // Curried functions
  val superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // lambda: y => 3 + y
  println(add3(22))

  //functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: Double => String = curriedFormatter("%4.2f")
  val preciseFormat: Double => String = curriedFormatter("%10.8f")
  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))
}
