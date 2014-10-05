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
package com.thjug.pair.scala

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by nuboat on 9/14/14.
 */
class ScalaOfLife extends FlatSpec with Matchers {
  "Board update from pattern xxx" should "change to expected" in {
    val board = new Board(x=5, y=5)
    board.addLifePoint(1,2)
    board.addLifePoint(2,2)
    board.addLifePoint(3,2)

    board.update()

    val expected =
      ".....\n" +
      "..X..\n" +
      "..X..\n" +
      "..X..\n" +
      ".....\n"

    assert( board.toString() == expected )
  }
}
