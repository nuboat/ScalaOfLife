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

import scala.util.Random
import scala.collection.mutable.{HashSet => HashSetBuffer}

/**
 * Created by nuboat on 2/9/15.
 */
case class BoardBuilder(val x: Int, val y: Int) {

  private val r = Random
  private val lifePoints = HashSetBuffer[Poi]()
  private val tuples = ((0 until x) cross (0 until y))

  implicit class Crossable[X](xs: Traversable[X]) {
    def cross[Y](ys: Traversable[Y]) = for {x <- xs; y <- ys} yield (x, y)
  }

  def random: BoardBuilder = {
    tuples.filter(t => r.nextInt(10) % 2 == 0)
      .par.foreach(t => addLifePoint(t._1, t._2))

    return this
  }

  def addLifePoint(x: Int, y: Int): BoardBuilder = {
    lifePoints += Poi(x, y)

    return this
  }

  def build(): Board = {
    return Board(x, y, lifePoints.toSet, tuples)
  }

}