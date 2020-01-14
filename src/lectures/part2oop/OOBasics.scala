package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John",26)
  println(person.x)
  person.greet("Yanse")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(author.fullName())
  println(novel.authorAge())
  println(novel.isWrittenBy(author))

  val counter = new Counter
  counter.increment.increment.print
  counter.increment(12).print
}

// Constructor, add "val" to convert paramaters to "fields" (attributes)
// Class parameters are NOT FIELDS
class Person(name: String, val age: Int) {
  //body
  val x = 2
  //method
  def greet(name: String): Unit =  println(s"${this.name} says: Hi, $name")

  //Overloading: many method different parameters.
  def greet(): Unit = println(s"Hi, I am $name")

  //multiple constrctors
  def this(name: String) = this(name, 0)
}

  /*
  Novel and a Writer

  Writer: first name, surname, year
    - method fullname

  Novel: name, year of release, author
    - authorAge
    - isWrittenBy(author)
    - copy (new year of release) = new instance of Novel
  */
  class Writer(fName: String, sName: String, val year: Int){
    def fullName(): String = s"$fName $sName"
  }

  class Novel(name: String, yearOfRelease: Int,  author: Writer){
    def authorAge(): Int = yearOfRelease - author.year

    def isWrittenBy(author: Writer): Boolean = author == this.author

    def copy(newYear: Int): Novel = new Novel(name, newYear, author)
  }

  /*
    Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new counter
    - overload inc/dec to receive an amount
   */
  class Counter(val count: Int = 0){

    def increment = new Counter(count + 1) //Immutability
    def decrement = new Counter(count - 1)

    def increment(amount: Int): Counter = {
      if(amount <= 0) this
      else increment.increment(amount-1)
    }

    def  decrement(amount: Int): Counter = {
      if(amount <= 0) this
      else decrement.decrement(amount-1)
    }

    def print = println(count)
  }
