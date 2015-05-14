package nuboat.poker

case class Score(rank: Rank.Value, highCharValue: Char, highIntValue: Int) {
  override def toString(): String = {
    return if (rank == Rank.HighCard) s"high card: $highCharValue" else s"$rank"
  }
}

object Rank extends Enumeration {
  val HighCard,
  Pair,
  TwoPairs,
  ThreeKind,
  Straight,
  Flush,
  FullHouse,
  FourKind,
  StraightFlush = Value
}
