import cats.Show
import cats.instances.int._
import cats.instances.string._

val showInt: Show[Int] = Show.apply[Int]
val showString: Show[String] = Show.apply[String]

val intAsString = showInt.show(123)
val stringAsString = showString.show("abc")


import cats.syntax.show._


val shownInt = 124.show
val shownString = "abc".show


