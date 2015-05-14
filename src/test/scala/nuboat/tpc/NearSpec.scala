package nuboat.tpc

import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by nuboat
 */
class NearSpec extends FlatSpec with Matchers {

  val land = 10
  val availables = List(2,4,5,6,9)
  val gaps = List(2,3)

  "Size 10, Available 2,4,5,6,9, Gap 2" should "List((2,4), (4,6))" in {
    val near = Near(land, availables, gaps)
//    val result = near.point(2)
//    result should be(List((2,4), (4,6)))
  }

  "Size 10, Available 2,4,5,6,9, Gap 3" should "List((2,5), (6,9))" in {
    val near = Near(land, availables, gaps)
//    val result = near.point(3)
//    result should be(List((2,5), (6,9)))
  }
}

