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

import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by nuboat on 8/30/14.
 */
class BoardTest extends FlatSpec with Matchers {
  "toString" should "return empty board" in {
    val board = new Board(x=3, y=2)
    val expected =
      "...\n" +
      "...\n"

    assert( board.toString() == expected )
  }

  "toString" should "return one life point" in {
    val board = new Board(x=3, y=4)
    board.addLifePoint(2,1)

    val expected =
      "...\n" +
      "..X\n" +
      "...\n" +
      "...\n"

    assert( board.toString() == expected )
  }
}
