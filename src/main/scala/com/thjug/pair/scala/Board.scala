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

import scala.collection.mutable.HashSet

/**
 * Created by nuboat on 8/30/14.
 */
class Board(val x:Int, val y:Int) {

  val lifePoints = new HashSet[Position]

  def addLifePoint(x: Int, y: Int):Unit = {
    lifePoints += Position(x,y)
  }

  def update():Board = {
    for(i <- 0 until y) {
      for(j <- 0 until x) {

      }
    }

    return null
  }

  def getLifeNeighbours(x:Int, y:Int):Int = {
    val offset:Array[Position] = Array(new Position(x-1,y-1), new Position(x,y-1), new Position(x+1,y-1),
                                       new Position(x-1,  y),                      new Position(x+1,y),
                                       new Position(x-1,y+1), new Position(x,y+1), new Position(x+1,y+1))

    var neighbours:Int = 0
    for(position <- offset) {
      neighbours = neighbours + (if (lifePoints.contains(position)) 1 else 0)
    }
    return neighbours
  }

  override def toString():String = {
    val board = new StringBuilder

    for(i <- 0 until y) {
      for( j <- 0 until x) {
        lifePoints.contains(Position(j,i)) match {
          case true => board.append("X")
          case false => board.append(".")
        }
      }
      board.append("\n")
    }

    return board.toString
  }

}
