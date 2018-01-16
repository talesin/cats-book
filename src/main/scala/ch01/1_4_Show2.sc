import cats._
import cats.implicits._
import java.util.Date

implicit val dateShow: Show[Date] = (date: Date) => s"${date.getTime}ms since epoch"

val date = new Date()

date.show