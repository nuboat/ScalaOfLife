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

/**
 * Created by nuboat on 8/23/14.
 */
class Rules {

  def nextState(isLife: Boolean, i: Int):Boolean = {
    return isLife match {
      case true => i >= 2 && i <= 3
      case false => i == 3
    }
  }

}
