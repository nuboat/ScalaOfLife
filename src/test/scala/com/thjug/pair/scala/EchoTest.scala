package com.thjug.pair.scala

import org.scalatest.FunSuite

/**
 * Created by nuboat on 8/22/14.
 */
class EchoTest extends FunSuite {

  test("An empty message should return {{{  }}}") {
    val echo:Echo = new Echo
    assert(echo.getMessage("") == "{{{  }}}")
  }

  test("A hi message should return {{{ hi }}}") {
    val echo:Echo = new Echo
    assert(echo.getMessage("hi") == "{{{ hi }}}")
  }

}
