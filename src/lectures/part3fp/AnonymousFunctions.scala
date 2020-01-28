package lectures.part3fp

object AnonymousFunctions extends App {
  //Anonymous function (LAMBDA)
  val doubler = (a:Int) => a*2

  //Multiple parameters in lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  //No Params
  val justDoSomthing: () => Int = () => 3

  println(justDoSomthing)
  println(justDoSomthing())

  // Curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR Syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b

  /*
  Exercises
   */
  val superAdder: ((Int) => (Int => Int)) = (a: Int) => ((b: Int) => a+b)
  println(superAdder(2)(3))



}
