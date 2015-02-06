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
    rules nextState(true, 0) should be(false)
    rules nextState(true, 1) should be(false)
  }

  "Any live cell with 2 or 3 live neighbours" should "lives" in {
    rules nextState(true, 2) should be(true)
    rules nextState(true, 3) should be(true)
  }

  "Any live cell with more than 3 live neighbours" should "dies" in {
    for(i <- 4 to 8) {
      rules nextState(true, i) should be(false)
    }
  }

  "Any dead cell with exactly 3 live neighbours" should "lives" in {
    rules nextState(false, 3) should be(true)

    for(i <- 0 to 8
        if(i != 3)) {
        rules nextState(false, i) should be(false)
    }
  }
}
