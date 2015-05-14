package nuboat.joda

import org.joda.time.{DateTimeZone, DateTime}

/**
 * --epochFrom=1427975820&epochTo=1427976120
 * Created by pasoktummarungsri on 4/3/15.
 */
object Epoch {

  val epoch = 1428062100
  val tz = DateTimeZone.getDefault()

  def main(args: Array[String]): Unit = {

    val e = new DateTime(epoch * 1000L)
    val eTimes = e.getMillis
    val eUTC = tz.convertLocalToUTC(eTimes, false)
    // println(s"Example Local ${eTimes}, UTC: ${eUTC}")

    val now = new DateTime()
    val nowUTC = new DateTime(now.getMillis, DateTimeZone.UTC)

    println(s"Now Local ${now.getMillis}")
    println(s"Now   UTC ${nowUTC.getMillis}")
    println(s"Now Local in String $now")
    println(s"Now   UTC in String $nowUTC")

  }


}

