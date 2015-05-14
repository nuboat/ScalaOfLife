package nuboat.indeed

import nuboat.tpc.HIndex

import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
 * Created by pasoktummarungsri on 5/9/15.
 */
object Exam1 extends App {

  val list = Source.fromFile("/Users/pasoktummarungsri/Sources/ScalaOfLife/indeed1").getLines.toList

  var word = list(0).toList

  for (i <- 1 until list.length) {
    val in = list(i).split(" ").map( _.toInt ).toList
    for (i <- 0 until in(2)) {
      word = swap(word, in(0), in(1))
    }
  }

  println(word)

  def swap(list: List[Char], start: Int, end :Int): List[Char] = {
    val slice = list.slice(start-1, end)
    val swaplist = ListBuffer[Char]()
    for (i <- 0 to (slice.length - 1)) {
      if (i == 0) {
        swaplist.append(slice(slice.length - 1))
      } else {
        swaplist.append(slice(i-1))
      }
    }

    return list.slice(0, start-1) ++ swaplist ++ list.slice(end, list.length)
  }

}
