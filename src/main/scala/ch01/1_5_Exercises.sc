import cats._
import cats.implicits._

final case class Cat(name: String, age: Int, color: String)

implicit val catEq: Eq[Cat] = Eq.instance[Cat] { (c1, c2) => c1.name === c2.name && c1.age === c2.age && c1.color === c2.color }

val cat1 = Cat("Garfield",   38, "orange and black")
val cat2 = Cat("Heathcliff", 33, "orange and black")

val optionCat1 = Option(cat1)
val optionCat2 = Option.empty[Cat]

cat1 === cat1
cat1 =!= cat2

optionCat1 === optionCat1
optionCat1 =!= optionCat2