/**
 *
 * Attribution
 * CC BY
 * This license lets others distribute, remix, tweak,
 * and build upon your work, even commercially,
 * as long as they credit you for the original creation.
 * This is the most accommodating of licenses offered.
 * Recommended for maximum dissemination and use of licensed materials.
 *
 * http://creativecommons.org/licenses/by/3.0/
 * http://creativecommons.org/licenses/by/3.0/legalcode
 *
 */
package nuboat.gameoflife

import scala.util.Random

/**
 * Created by nuboat on 8/20/14.
 */
object Main {

  private val x = 60
  private val y = 20

  def main(args: Array[String]) {
    val builder = BoardBuilder(x, y)
    var board = builder.random.build()

    do {
      println("==================================================================================================")
      println(board.render())
      println("==================================================================================================")
      board = board.next()
      Thread.sleep(1000)
    } while (true)

  }

}
