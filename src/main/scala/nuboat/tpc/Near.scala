package nuboat.tpc

/**
 * Created by nuboat on 3/29/15.
 */
case class Near(land: Int, available: List[Int], gaps: List[Int]) {

  val setOfa = available.toSet

  def getCounts(): List[Int] = gaps.par.map(gap => count(gap)).toList

  def count(gap: Int): Int = 0.to(land - gap).par.filter(i => verify(i, gap)).size

  private def verify(index: Int, gap: Int): Boolean = setOfa.contains(index) && setOfa.contains(index + gap)

}

object NearMain {

  def main(args: Array[String]): Unit = {
    io.Source.fromFile("/Users/pasoktummarungsri/Sources/ScalaOfLife/example/mar_near-input.txt")
      .getLines.drop(1).toList.grouped(3)
      .foreach(g => {
        Near(g(0).split(" ").map(_.toInt).toList.lift(0).get,
          g(1).split(" ").map(_.toInt).toList,
          g(2).split(" ").map(_.toInt).toList
        ).getCounts.foreach(i => print(s"$i "))

        println("")
      })
    println("====================")

  }

}