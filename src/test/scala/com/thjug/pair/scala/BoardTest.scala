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
    val board = new Board(x = 3, y = 2)
    val expected =
      "   \n" +
      "   \n"

    board.render() should be(expected)
  }

  "toString" should "return one life point" in {
    val board = new Board(x = 3, y = 4)
    board.addLifePoint(2, 1)

    val expected =
      "   \n" +
      "  X\n" +
      "   \n" +
      "   \n"

    board.render() should be(expected)
  }

  "getLifeNeighbours 2,2" should "return 0" in {
    val board = new Board(x = 5, y = 5)
    board.addLifePoint(2, 2)

    board.getLifeNeighbours(2, 2) should be(0)
  }

  "getLifeNeighbours 2,2" should "return 8" in {
    val board = new Board(x = 5, y = 5)
    board.addLifePoint(1, 1)
    board.addLifePoint(2, 1)
    board.addLifePoint(3, 1)
    board.addLifePoint(1, 2)
    board.addLifePoint(2, 2)
    board.addLifePoint(3, 2)
    board.addLifePoint(1, 3)
    board.addLifePoint(2, 3)
    board.addLifePoint(3, 3)

    board.getLifeNeighbours(2, 2) should be(8)
  }

  "getLifeNeighbours 1,2" should "return 1" in {
    val board = new Board(x = 5, y = 5)
    board.addLifePoint(1, 2)
    board.addLifePoint(2, 2)
    board.addLifePoint(3, 2)

    board.getLifeNeighbours(1, 2) should be(1)
  }

  "getLifeNeighbours 2,2" should "return 2" in {
    val board = new Board(x = 5, y = 5)
    board.addLifePoint(1, 2)
    board.addLifePoint(2, 2)
    board.addLifePoint(3, 2)

    board.getLifeNeighbours(2, 2) should be(2)
  }

  "getLifeNeighbours 3,2" should "return 1" in {
    val board = new Board(x = 5, y = 5)
    board.addLifePoint(1, 2)
    board.addLifePoint(2, 2)
    board.addLifePoint(3, 2)

    board.getLifeNeighbours(3, 2) should be(1)
  }

}
