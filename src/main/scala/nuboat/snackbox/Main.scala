package nuboat.snackbox

import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
 * Created by pasoktummarungsri on 2/10/15.
 */
case class Box(val size: Int)

object Main {

  private val boxList = List(Box(6), Box(9), Box(15))

  private val result = ListBuffer[Box]()

  def main(args: Array[String]): Unit = {
    val snack = 30

    println(fill(snack, 0))
  }

  def fill(snack: Int, pointer: Int): ListBuffer[Box] = {
    val box = getBox(snack, pointer)
    if (box != null) {
      result += box
    }

    val diff = snack - total(result)
    if (diff == 0 ) {
      return result
    }

    if (diff > 0) {
      fill(diff, pointer)
    }

    return result

  }

  def getBox(snack: Int, pointer: Int): Box = {
    for (i <- 0 until boxList.size) {
      val ind = boxList.size - 1 - i

      if (snack >= boxList(ind).size) {
        return boxList(ind)
      }
    }
    return null
  }

  private def total(list: ListBuffer[Box]): Int = {
    var total = 0
    list.foreach(b => total += b.size)

    return total
  }
}
