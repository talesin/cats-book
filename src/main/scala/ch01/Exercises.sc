final case class Cat(name: String, age: Int, color: String)

trait Printable[A] {
  def format(value: A): String
}

object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {
    def format(implicit p: Printable[A]): String = p.format(value)
    def print(implicit p: Printable[A]): Unit = println(format)
  }
}

object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String = p.format(value)
  def print[A](value: A)(implicit p: Printable[A]): Unit = println(format(value))
}

object PrintableInstances {
  import Printable._
  implicit val stringPrinter: Printable[String] = (value: String) => value
  implicit val intPrinter: Printable[Int] = (value: Int) => value.toString
  implicit val catPrinter: Printable[Cat] = (value: Cat) => s"${format(value.name)} is a ${format(value.age)} year-old ${format(value.color)} cat."
}



val cat = Cat("Pluto", 1, "black")

import PrintableInstances._
import PrintableSyntax._

cat.format

cat.print
