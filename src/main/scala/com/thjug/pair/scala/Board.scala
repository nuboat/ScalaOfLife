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

import scala.collection.mutable.{HashSet => HashSetBuffer}
import scala.util.Random

/**
 * Created by nuboat on 8/30/14.
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

case class Board(val x: Int, val y: Int, val lifePoints: Set[Poi], val tuples: Traversable[(Int, Int)]) {

  private val rules: Rules = new Rules
  private val obj = Map(true -> "X", false -> " ")

  def next(): Board = {
    val builder = BoardBuilder(this.x, this.y)

    tuples
      .filter(t => rules.nextState(lifePoints.contains(Poi(t._1, t._2)), getLifeNeighbours(t._1, t._2)))
      .par.foreach(t => builder.addLifePoint(t._1, t._2))

    return builder.build()
  }

  def render(): String = {
    return (0 until y).map( i => (0 until x)
            .map( j => obj(lifePoints.contains(Poi(j, i))) ).mkString)
            .mkString("\n")
  }

  def getLifeNeighbours(x: Int, y: Int): Int = {
    val offset: Array[Poi] = Array(
      new Poi(x - 1, y - 1), new Poi(x, y - 1), new Poi(x + 1, y - 1),
      new Poi(x - 1, y),                        new Poi(x + 1, y),
      new Poi(x - 1, y + 1), new Poi(x, y + 1), new Poi(x + 1, y + 1))

    return offset.map(p => lifePoints.contains(p))
            .filter(b => b == true)
            .size
  }

}
