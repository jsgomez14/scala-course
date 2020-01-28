package lectures.part2oop

import java.util.Date
import java.sql.{Date => SqlDate}

import OOBasics.Writer
import playground.{PrinceCharming, Cinderella => Princess}//to import all -> playground._

object PackagingAndImports extends App {

  // Package members are accessible by their simple name
  val writer = new Writer("Daniel", "RocksTheJVM", 2018)

  // Import package
  val princess = new Princess // new playground.Cinderella -> fully qualified name

  // packages are in hierarchy
  // matching folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // Imports
  val prince = new PrinceCharming

  val date = new Date()
  //1. Use Fully Qualified Names or 2. Use aliasing
  val sqlDate= new SqlDate(2018,5,1);

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.predef - println, ???

}
