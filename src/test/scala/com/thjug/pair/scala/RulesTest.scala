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
 * Created by nuboat on 8/23/14.
 */
class RulesTest extends FlatSpec with Matchers {
  val rules:Rules = new Rules

  "Any live cell with less than 2 live neighbours" should "dies" in {
    rules nextState("L", 0) should be("D")
    rules nextState("L", 1) should be("D")
  }

  "Any live cell with 2 or 3 live neighbours" should "lives" in {
    rules nextState("L", 2) should be("L")
    rules nextState("L", 3) should be("L")
  }

  "Any live cell with more than 3 live neighbours" should "dies" in {
    for(i <- 4 to 8) {
      rules nextState("L", i) should be("D")
    }
  }

  "Any dead cell with exactly 3 live neighbours" should "lives" in {
    rules nextState("D", 3) should be("L")

    for(i <- 0 to 8
        if(i != 3)) {
        rules nextState("D", i) should be("D")
    }
  }
}
