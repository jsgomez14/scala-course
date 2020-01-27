package lectures.part2oop

object Generics extends App {
  // Generic class
  class MyList[+A] {
    // Uses type A
    def add[B >: A](element: B): MyList[B] = ???

    /*
     * A = Cat
     * B = Animal
     */
  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // Generic methods

  object MyList{
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // Variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]

  val animal:Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION => we return a list of Animals

  //2. NO = Invariance
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  //3. Hell, No! = CONTRAVARIANCE
  class Trainer[-A]
  val contravariantList: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  // A <: Animal => Just accepts A's which are subtypes of Animal
  // A >: Animal => Just accepts A's which are supertypes of Animal

  class Cage[A <: Animal](animal: A)

  val cage = new Cage(new Dog)

}
