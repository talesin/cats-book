import cats._
import cats.implicits._

final case class Cat(name: String, age: Int, color: String)

implicit val showCat: Show[Cat] = (cat: Cat) => s"${cat.name.show} is a ${cat.age.show} year old ${cat.color.show} cat"

Cat("Pluto", 1, "black").show