package lectures.part1basics

object ValuesVariablesTypes extends App {
  //val x: Int = 42 is same as:
  val x = 42
  //COMPILER can infer types.
  println(x)
  // x = 32
  // code above is fobidden because: VALS ARE IMMUTABLE

  val aString: String = "hola"
  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 467568756865747L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // Variables

  var aVariable: Int = 4
  aVariable = 5 // Variables are MUTABLE
}
