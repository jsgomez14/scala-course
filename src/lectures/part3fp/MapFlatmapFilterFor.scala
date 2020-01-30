package lectures.part3fp

object MapFlatmapFilterFor extends App {

  var list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatmap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  //
  val numbers = List(1, 2, 3, 4)
  val characters = List("a", "b", "c", "d")
  val colors = List("Black", "White")

  // Iterating
  //Producto cruz 2 conjuntos
  val combinations = numbers.flatMap(n => characters.map(c => ""+ c + n))
  //Producto cruz 3 conjuntos
  val combinationsX3 = numbers.flatMap(n => characters.flatMap(c => colors.map( col => ""+ c + n + col )))

  println(combinations)
  println(combinationsX3)

  // For each
  list.foreach(println)

  // For-comprehension
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- characters
    col <- colors
  } yield ""+ c + n + col
  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  //  Syntax overload
  list.map{ x =>
    x*2
  }

  // Exercises

}
