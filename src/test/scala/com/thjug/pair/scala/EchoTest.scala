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
 * Created by nuboat on 8/22/14.
 */
class EchoTest extends FlatSpec with Matchers {

  val echo:Echo = new Echo

  "An empty message" should "return {{{  }}}" in {
    echo.getMessage("") should be ("{{{  }}}")
  }

  "A hi message" should "return {{{ hi }}}" in {
    echo.getMessage("hi") should be ("{{{ hi }}}")
  }

}
