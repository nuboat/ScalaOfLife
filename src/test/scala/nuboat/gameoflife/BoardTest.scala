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

import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by nuboat on 8/30/14.
 */
class BoardTest extends FlatSpec with Matchers {
  "toString" should "return empty board" in {
    val board = BoardBuilder(x = 3, y = 2).build()
    val expected =
      "   \n" +
      "   \n"

    board.render() should be(expected)
  }

  "toString" should "return one life point" in {
    val board = BoardBuilder(x = 3, y = 4).addLifePoint(2, 1).build()

    val expected =
      "   \n" +
      "  X\n" +
      "   \n" +
      "   \n"

    board.render() should be(expected)
  }

  "getLifeNeighbours 2,2" should "return 0" in {
    val board = BoardBuilder(x = 5, y = 5).addLifePoint(2, 2).build()

    board.getLifeNeighbours(2, 2) should be(0)
  }

  "getLifeNeighbours 2,2" should "return 8" in {
    val board = BoardBuilder(x = 5, y = 5)
      .addLifePoint(1, 1)
      .addLifePoint(2, 1)
      .addLifePoint(3, 1)
      .addLifePoint(1, 2)
      .addLifePoint(2, 2)
      .addLifePoint(3, 2)
      .addLifePoint(1, 3)
      .addLifePoint(2, 3)
      .addLifePoint(3, 3)
      .build()

    board.getLifeNeighbours(2, 2) should be(8)
  }

  "getLifeNeighbours 1,2" should "return 1" in {
    val board = BoardBuilder(x = 5, y = 5)
      .addLifePoint(1, 2)
      .addLifePoint(2, 2)
      .addLifePoint(3, 2)
      .build()

    board.getLifeNeighbours(1, 2) should be(1)
  }

  "getLifeNeighbours 2,2" should "return 2" in {
    val board = BoardBuilder(x = 5, y = 5)
      .addLifePoint(1, 2)
      .addLifePoint(2, 2)
      .addLifePoint(3, 2)
      .build()

    board.getLifeNeighbours(2, 2) should be(2)
  }

  "getLifeNeighbours 3,2" should "return 1" in {
    val board = BoardBuilder(x = 5, y = 5)
      .addLifePoint(1, 2)
      .addLifePoint(2, 2)
      .addLifePoint(3, 2)
      .build()

    board.getLifeNeighbours(3, 2) should be(1)
  }

}
