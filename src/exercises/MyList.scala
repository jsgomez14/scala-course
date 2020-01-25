package exercises

abstract class MyList {
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(n : Int): MyList
  def printElements: String
  // Polimorphic call
  override def toString: String = "["+ printElements +"]"
}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(n: Int): MyList = new Cons(n, Empty)
  def printElements: String = ""
}

class Cons(f: Int, t: MyList) extends MyList {
  def head: Int = head

  def tail: MyList = t

  def isEmpty: Boolean = false

  def add(n: Int): MyList = new Cons(n, this)

  override def printElements: String =
    if(tail.isEmpty) "" + f
    else f + " " + t.printElements
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  list.add(4)

  println(list.toString)
}
