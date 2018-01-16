import cats.Eq
import cats.instances.int._

val eqInt = Eq[Int]

eqInt.eqv(123, 123)
eqInt.eqv(123, 234)

import cats.syntax.eq._

123 === 123
123 =!= 234

import cats.instances.int._
import cats.instances.option._

Option(1) === Option.empty[Int]

import cats.syntax.option._

1.some === none[Int]
1.some =!= none[Int]

import java.util.Date
import cats.instances.long._

implicit val dateEq: Eq[Date] = Eq.instance[Date] { (date1, date2) => date1.getTime === date2.getTime }

val x = new Date()
val y = new Date()

x === x
x === y