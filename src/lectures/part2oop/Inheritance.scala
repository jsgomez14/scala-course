package lectures.part2oop

object Inheritance extends App {
  //Single class inheritance
  sealed class Animal{
    val creatureType = "wild"
    def eat() = println("ñom ñom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  //constructors
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  //Overriding
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType = "domestic"
    override def eat(): Unit = {
      super.eat
      println("crunch, crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat()
  println(dog.creatureType)

  // Type substitution (broad: polymorphism)
  val unkownAnimal: Animal = new Dog("K9")
  unkownAnimal.eat() //Will uses Dog overriden method instead super method

  // OverRIDING vs OverLOADING

  //super

  //preventing overrides
  //1. use final on member
  //2. use final on the entire class
  //3. seal the class = extend classes IN THIS FILE, but prevent extension in other files. (sealed classes)

}
