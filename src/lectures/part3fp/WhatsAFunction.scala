package lectures.part3fp

object WhatsAFunction extends App {
  // DREAM: use function as first class elements
  // problem: oop
  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element*2
  }

  println(doubler(2))

  //function types = Function1[A, B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(v1: String): Int =  v1.toInt
  }

  println(stringToIntConverter("3")+4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1+v2
  }

  // Function types  Function2[A, B, R] === (A,B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS (Instances of classes diriving from Function1, Function2,...)

  val concatenator: ((String, String) => String) = new Function2[String, String, String]{
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(concatenator("hello", " scala"))

  val superAdder: ((Int) => (Int => Int)) = new Function[Int, Function[Int, Int]] {
    override def apply(x: Int): Function[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) //Curried function
  // Higher order functions, they either receive functions as parameters or return other functions as result

  trait MyFunction[A, B] {
    def apply(element: A): B
  }
}


