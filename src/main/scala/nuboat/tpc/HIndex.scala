package nuboat.tpc

import scala.io.Source

/**
 * Created by norbor on 3/28/15.
 */
case class HIndex(publishs: List[Int]) {

  private val checklist = 0.to(publishs.max).sortWith(_ > _)

  def calc(): Int = checklist.find(c => rule1(c) && rule2(c)).get

  private def refer(c: Int): List[Int] = publishs.filter(_ >= c).toList

  private def rule1(c: Int): Boolean = refer(c).size >= c

  private def rule2(c: Int): Boolean = refer(c + 1).size <= c

}

object MainHIndex {

  private def calinoneline(publishs: List[Int]): String = 0.to(publishs.max).sortWith(_ > _).find(c => (publishs.filter(_ >= c).toList.size >= c) && (publishs.filter(_ >= c + 1).toList.size <= c)).get.toString

  def main(args: Array[String]): Unit = {
    Source.fromFile("Thailandoi Programming Contest/mar_hindex-verifying-input.txt").getLines
      .filter(l => l.size > 5)
      .foreach(l => println(HIndex(l.substring(5).split(" ").toList.map(_.toInt)).calc))
    println("===================")
    Source.fromFile("Thailandoi Programming Contest/mar_hindex-input.txt").getLines
      .filter(l => l.size > 5)
      .foreach(l => println(HIndex(l.substring(5).split(" ").toList.map(_.toInt)).calc))
    println("===================")
//    Source.fromFile("Thailandoi Programming Contest/mar_hindex-verifying-input.txt").getLines
//      .filter(l => l.size > 5)
//      .foreach(l => println(calinoneline(l.substring(5).split(" ").toList.map(_.toInt))))
//    println("===================")
//    Source.fromFile("Thailandoi Programming Contest/mar_hindex-input.txt").getLines
//      .filter(l => l.size > 5)
//      .foreach(l => println(calinoneline(l.substring(5).split(" ").toList.map(_.toInt))))
  }

}