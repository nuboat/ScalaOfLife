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
    val board = BoardBuilder(x=5, y=5)
      .addLifePoint(1,2)
      .addLifePoint(2,2)
      .addLifePoint(3,2)
      .build()

    val result = board.next()

    val expected =
      "     \n" +
      "  X  \n" +
      "  X  \n" +
      "  X  \n" +
      "     \n"

    result.render() should be(expected)
  }
}
