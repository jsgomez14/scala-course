package exercises

abstract class MyGenericList[+A] {
  def head: A
  def tail: MyGenericList[A]
  def isEmpty: Boolean
  def add[B >: A](n: B): MyGenericList[B]
  def printElements: String
  // Polimorphic call
  override def toString: String = "["+ printElements +"]"
}

object Empty extends MyGenericList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyGenericList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](n: B): MyGenericList[B] = new Cons(n, Empty)
  def printElements: String = ""
}

class Cons[+A](f: A, t: MyGenericList[A]) extends MyGenericList[A] {
  def head: A = head

  def tail: MyGenericList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](n: B): MyGenericList[B] = new Cons(n, this)

  override def printElements: String =
    if(tail.isEmpty) "" + f
    else f + " " + t.printElements
}

//Not working properly
object MyGenericListTest extends App {
  val listOfIntegers: MyGenericList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  //val listOfStrings = new Cons("1", new Cons("2", Empty))

  println(listOfIntegers.toString)
 // println(listOfStrings.toString)
}
