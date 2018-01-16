
sealed trait Json
final case class JsObject(get: Map[String, Json]) extends Json
final case class JsString(get: String) extends Json
final case class JsNumber(get: Double) extends Json
case object JsNull extends Json

trait JsonWriter[A] {
  def write(value: A): Json
}

final case class Person(name: String, email: String)

object JsonWriterInstances {
  implicit val stringWriter: JsonWriter[String] = (value: String) => JsString(value)

  implicit val personWriter: JsonWriter[Person] = (value: Person) => JsObject(Map(
    "name" -> JsString(value.name),
    "email" -> JsString(value.email)
  ))
}

object Json {
  def toJson[A](value: A)(implicit w: JsonWriter[A]): Json = w.write(value)
}

import JsonWriterInstances._
Json.toJson(Person("Dave", "dave@example.com"))

object JsonSyntax {
  implicit class JsonWriteOps[A](value: A) {
    def toJson(implicit w: JsonWriter[A]): Json = w.write(value)
  }
}

import JsonSyntax._
Person("Dave", "dave@example.com").toJson

implicitly[JsonWriter[String]]

implicit def optionWriter[A](implicit writer: JsonWriter[A]): JsonWriter[Option[A]] = (opt: Option[A]) => opt match {
  case Some(value) => writer.write(value)
  case None => JsNull
}

Json.toJson(Option("a string"))
