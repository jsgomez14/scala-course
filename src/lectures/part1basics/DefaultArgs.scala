package lectures.part1basics

object DefaultArgs extends App {
  def trFactorial(n: Int, acc: Int = 1): Int =
    if( n <= 1 ) acc
    else trFactorial(n-1, n*acc)

  val 1 = trFactorial(10)

  def savePicture (format: String = "jpg", w: Int = 1920, h: Int = 1080): Unit = println("saving picture")
  savePicture(w = 800)

}
