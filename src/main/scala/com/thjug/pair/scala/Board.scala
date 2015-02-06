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
object BoardBuilder {

  def create(x: Int, y: Int): BoardBuilder = {
    return BoardBuilder(x, y)
  }

}

case class BoardBuilder(val x: Int, val y: Int) {

  private val r = Random
  private val lifePoints = HashSetBuffer[Position]()

  def random: BoardBuilder = {
    (for {x <- (0 to x); y <- (0 to y)} yield (x, y)).filter(t => r.nextInt(10) % 2 == 0).par.foreach(t => addLifePoint(t._1, t._2))
    return this
  }

  def addLifePoint(x: Int, y: Int): BoardBuilder = {
    lifePoints += Position(x, y)
    return this
  }

  def build(): Board = {
    return Board(x, y, lifePoints.toSet)
  }

}

case class Board(val x: Int, val y: Int, val lifePoints: Set[Position]) {

  private val rules: Rules = new Rules

  implicit class Crossable[X](xs: Traversable[X]) {
    def cross[Y](ys: Traversable[Y]) = for {x <- xs; y <- ys} yield (x, y)
  }

  def next(): Board = {
    val builder = BoardBuilder(this.x, this.y)

    for (i <- 0 until y) {
      for (j <- 0 until x) {
        val state = if (lifePoints.contains(Position(j, i))) "L" else "D"
        val next = rules.nextState(state, getLifeNeighbours(j, i))
        if (next == "L") {
          builder.addLifePoint(j, i)
        }
      }
    }

    return builder.build()
  }

  def render(): String = {
    val display = new StringBuilder

    for (i <- 0 until y) {
      for (j <- 0 until x) {
        lifePoints.contains(Position(j, i)) match {
          case true => display.append("X")
          case false => display.append(" ")
        }
      }
      display.append("\n")
    }

    return display.toString
  }

  def getLifeNeighbours(x: Int, y: Int): Int = {
    val offset: Array[Position] = Array(
      new Position(x - 1, y - 1), new Position(x, y - 1), new Position(x + 1, y - 1),
      new Position(x - 1, y), new Position(x + 1, y),
      new Position(x - 1, y + 1), new Position(x, y + 1), new Position(x + 1, y + 1))

    return offset.map(p => lifePoints.contains(p)).filter(b => b == true).size
  }

}
