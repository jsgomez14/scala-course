package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // EXPRESSION
  println(x)
  println(2 + 3 * 4) // + - * / & | ^ << >> >>> (right shift with zero extension)
  println(1 == x) // == != > >= < <= (For numbers)
  println(!(1==x)) // ! || &&
  var aVariable = 2
  aVariable += 3 // Also works with -= *= /= ..... side effects
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF Expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)

  var i = 0
  var aWhile = while(i<10) {
    println(i)
    i+=1
  }

  //NEVER WRITE THIS AGAIN.
  //BECAUSE => EVERYTHING IN SCALA IS AN EXPRESSION

  val aWeirdValue = (aVariable = 3)
  println(aWeirdValue)
  // side effects: println(), while, reassigning

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if(z>2) "hello" else "goodbye"
  }

  //1. String vs Unit
  //2. Int
}
