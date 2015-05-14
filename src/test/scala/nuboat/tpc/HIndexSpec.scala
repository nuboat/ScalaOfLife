package nuboat.tpc

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by pasoktummarungsri on 3/28/15.
 */
class HIndexSpec extends FlatSpec with Matchers {

  "4,2,2,4,3,6,1" should "3" in {
    val hIndex = HIndex(List(4,2,2,4,3,6,1))
    val result = hIndex.calc()

    result should be("3")
  }

  "7 7 5 3 1 6 4 2" should "3" in {
    val hIndex = HIndex(List(7,7,5,3,1,6,4,2))
    val result = hIndex.calc()

    result should be("4")
  }

  "3 4 4 4" should "3" in {
    val hIndex = HIndex(List(3,4,4,4))
    val result = hIndex.calc()

    result should be("3")
  }

  "1 1 1 1 2" should "1" in {
    val hIndex = HIndex(List(1,1,1,1,2))
    val result = hIndex.calc()

    result should be("1")
  }

}

