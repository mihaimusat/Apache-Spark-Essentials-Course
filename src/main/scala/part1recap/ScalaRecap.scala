package part1recap

import scala.concurrent.Future
import scala.util.{Failure, Success}

object ScalaRecap extends App {

  //values and variables
  val aBoolean = false

  //expressions
  val anIfExpression = if(2 > 3) "bigger" else "smaller"

  //instructions vs expressions
  val theUnit = println("Hello, Scala") // Unit = void in other languages

  //functions
  def myFunction(x: Int) = 42

  //OOP
  class Animal
  class Dog extends Animal
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override def eat(animal: Animal): Unit = println("Crunch!")
  }

  //singleton pattern
  object MySingleton

  //companions
  object Carnivore

  //generics
  trait MyList[+A]

  //method notation
  val x = 1 + 2
  val y = 1.+(2)

  //FP
  val incrementer: Int => Int = x => x + 1
  val incremented = incrementer(42)

  //map, flatMap, filter
  val processedList = List(1,2,3).map(incrementer)

  //pattern matching
  val unknown: Any = 45
  val ordinal = unknown match {
    case 1 => "first"
    case 2 => "second"
    case _ => "unknown"
  }

  //
  try {
    throw new NullPointerException
  }
  catch {
    case _: NullPointerException => "some returned value"
    case _ => "something else"
  }

  //future
  import scala.concurrent.ExecutionContext.Implicits.global
  val aFuture = Future {
    // some expensive computation, runs on another thread
    42
  }

  aFuture.onComplete {
    case Success(value) => println(s"I have received the $value")
    case Failure(ex) => println(s"I have failed: $ex")
  }

  //partial functions
  val aPartialFunction: PartialFunction[Int, Int] = {
    case 1 => 43
    case 8 => 56
    case _ => 999
  }

  //implicits

  //auto-injection by the compiler
  def methodWithImplicitArgument(implicit x: Int) = x + 43
  implicit val implicitInt = 67
  val implicitCall = methodWithImplicitArgument

  //implicit conversions - implicit defs
  case class Person(name: String) {
    def greet = println(s"Hi, my name is $name")
  }
  implicit def fromStringToPerson(name: String) = Person(name)
  "Bob".greet //fromStringToPerson("Bob").greet

  //implicit conversions - implicit classes
  implicit class Cat(name: String) {
    def meow = println("Meow!")
  }
  "Tom".meow

  /*
  - local scope
  - imported scope
  - companion objects of the types involved in the method call
   */



}
