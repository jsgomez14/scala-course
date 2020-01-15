package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0){
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"This $name is hanging out with ${person.name}."
    def unary_! : String = s"$name, wtf?!"
    def unary_+ : Person = new Person(name, favoriteMovie, age+1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and my favorite movie is $favoriteMovie."
    def apply(times: Int): String = s"$name watched $favoriteMovie $times times."
    def +(desc: String): Person = new Person(s"$name ($desc)", favoriteMovie)
    def learns(skill: String): String = s"$name learns $skill."
    def learnsScala: String = this learns "Scala"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")
  //Infix notation = operator notation (syntactic sugar)

  //"Operators" in Scala
  val tom = new Person("Tom", "Monster Inc")
  println( mary + tom)
  println( mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  //ALL OPERATORS ARE METHODS
  // Akka actors have ! ?

  // prefix notation
  val x = -1 // Equivalent to 1.uniary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !
  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary())

  println((mary + "La Rockera").name)
  println((+mary).age)
  println(mary learnsScala)
  println(mary(2))
}
