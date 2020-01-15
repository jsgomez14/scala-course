package lectures.part2oop

object Objects{
  //SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  // Define object and class on the same file to separate instance-level functionality and "static/class"-level fuctionality
  object Person {
    //1. Static/class-level
    val N_EYES = 2
    def canFly: Boolean = false

    //Factory method: build persons given parameters
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person (val name: String){
    //2. instance-level
  }


  // Scala Applications = Scala Object with
  def main(args: Array[String]): Unit = {
    //Pattern COMPANIONS: Object and class are in the same scope and name
    println(Person.N_EYES)
    // Scala Object = SINGLETON INSTANCE
    val per = Person
    // Scala Instances
    val mary = new Person("Mary")
    val john = new Person("John")

    val bobbie = Person(mary, john)
  }



}
