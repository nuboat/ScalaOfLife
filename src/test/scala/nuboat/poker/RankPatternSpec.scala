package nuboat.poker

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class RankPatternSpec extends FlatSpec with Matchers {

  "4C 9C AC TC 2C" should "be Flush" in {
    val cards = List(Card('4', Suit.C), Card('9', Suit.C), Card('A', Suit.C), Card('T', Suit.C), Card('2', Suit.C))
    val sorted = cards.sortBy(-_.value)
    val pattern = RankPattern(sorted)

    pattern.getRank should be(Rank.Flush)
  }

  "4D 5C 6C 7C 8C" should "be Straight" in {
    val cards = List(Card('4', Suit.D), Card('5', Suit.C), Card('6', Suit.C), Card('7', Suit.C), Card('8', Suit.C))
    val sorted = cards.sortBy(-_.value)
    val pattern = RankPattern(sorted)

    pattern.getRank should be(Rank.Straight)
  }

  "4C 5C 6C 7C 8C" should "be StraightFlush" in {
    val cards = List(Card('4', Suit.C), Card('5', Suit.C), Card('6', Suit.C), Card('7', Suit.C), Card('8', Suit.C))
    val sorted = cards.sortBy(-_.value)
    val pattern = RankPattern(sorted)

    pattern.getRank should be(Rank.StraightFlush)
  }

  "3C 3H 3S 3D 8C" should "be Four" in {
    val cards = List(Card('3', Suit.C), Card('3', Suit.H), Card('3', Suit.S), Card('3', Suit.D), Card('8', Suit.C))
    val sorted = cards.sortBy(-_.value)
    val pattern = RankPattern(sorted)

    pattern.getRank should be(Rank.FourKind)
  }

  "3C 3H 3S 8D 8C" should "be FullHouse" in {
    val cards = List(Card('3', Suit.C), Card('3', Suit.H), Card('3', Suit.S), Card('8', Suit.D), Card('8', Suit.C))
    val sorted = cards.sortBy(-_.value)
    val pattern = RankPattern(sorted)

    pattern.getRank should be(Rank.FullHouse)
  }

  "3C 3H 3S 7D 8C" should "be ThreeKind" in {
    val cards = List(Card('3', Suit.C), Card('3', Suit.H), Card('3', Suit.S), Card('7', Suit.D), Card('8', Suit.C))
    val sorted = cards.sortBy(-_.value)
    val pattern = RankPattern(sorted)

    pattern.getRank should be(Rank.ThreeKind)
  }

  "3C 3H 5S 5D 8C" should "be TwoPairs" in {
    val cards = List(Card('3', Suit.C), Card('3', Suit.H), Card('5', Suit.S), Card('5', Suit.D), Card('8', Suit.C))
    val sorted = cards.sortBy(-_.value)
    val pattern = RankPattern(sorted)

    pattern.getRank should be(Rank.TwoPairs)
  }

  "3C 3H 2S 7D 8C" should "be Pair" in {
    val cards = List(Card('3', Suit.C), Card('3', Suit.H), Card('2', Suit.S), Card('7', Suit.D), Card('8', Suit.C))
    val sorted = cards.sortBy(-_.value)
    val pattern = RankPattern(sorted)

    pattern.getRank should be(Rank.Pair)
  }

  "3C 4H 2S 7D 8C" should "be HighCard" in {
    val cards = List(Card('3', Suit.C), Card('4', Suit.H), Card('2', Suit.S), Card('7', Suit.D), Card('8', Suit.C))
    val sorted = cards.sortBy(-_.value)
    val pattern = RankPattern(sorted)

    pattern.getRank should be(Rank.HighCard)
  }

}
