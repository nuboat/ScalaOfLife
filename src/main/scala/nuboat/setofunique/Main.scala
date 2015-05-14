package nuboat.setofunique

import scala.util.Random

/**
 * Created by nuboat on 2/9/15.
 */
object Main {

  private val r = Random
  private val source = random()

  def main(args: Array[String]): Unit = {
    val time1 = System.currentTimeMillis()
    val result1 = source.groupBy(r => r).filter(t => t._2.size == 1).map(t => t._1)
    val time2 = System.currentTimeMillis()
    println(s"""Single Process Execution Time : ${time2 - time1}""")

    val time3 = System.currentTimeMillis()
    val result2 = source.par.groupBy(r => r).par.filter(t => t._2.size == 1).par.map(t => t._1)
    val time4 = System.currentTimeMillis()
    println(s"""Parallel Process Execution Time : ${time4 - time3}""")

    println(s"""${result1.size} == ${result2.size}""")
  }

  def random(): List[Int] = {
    return (0 to 10000000).map( i => r.nextInt(200000)).toList
  }

}
