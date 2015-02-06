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

/**
 * Created by nuboat on 8/23/14.
 */
class Rules {

  def nextState(s: String, i: Int):String = {
    return s match {
      case "L" => if(i >= 2 && i <= 3) "L" else "D"
      case "D" => if(i == 3) "L" else "D"
    }
  }

}
