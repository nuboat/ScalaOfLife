package nuboat.poker

case class RankPattern(sortCards: List[Card]) {

  val group = sortCards.groupBy(_.value)
  val suitSet = sortCards.map(_.suit).toSet
  val isStraight = verifyStraight()

  def getRank(): Rank.Value = {
    if (isStraightFlus) {
      return Rank.StraightFlush
    } else if (isFour) {
      return Rank.FourKind
    } else if (isFullHouse) {
      return Rank.FullHouse
    } else if (isFlush) {
      return Rank.Flush
    } else if (isStraight) {
      return Rank.Straight
    } else if (isThree) {
      return Rank.ThreeKind
    } else if (isTwoPair) {
      return Rank.TwoPairs
    } else if (isPair) {
      return Rank.Pair
    } else {
      return Rank.HighCard
    }
  }

  private def isStraightFlus(): Boolean = {
    return isFlush && isStraight
  }

  private def isFour(): Boolean = {
    return if (group.find(k => k._2.size == 4) != None) true else false
  }

  private def isFullHouse(): Boolean = {
    return if ((group.find(k => k._2.size == 3) != None) && (group.find(k => k._2.size == 2) != None)) true else false
  }

  private def isFlush(): Boolean = {
    return suitSet.size == 1
  }

  private def verifyStraight(): Boolean = {
    for (i <- 0 to 3) {
      if ((sortCards(i).value - sortCards(i + 1).value) != 1) {
        return false
      }
    }
    return true
  }

  private def isThree(): Boolean = {
    return if ((group.find(k => k._2.size == 3) != None) && (group.size == 3)) true else false
  }

  private def isTwoPair(): Boolean = {
    return if ((group.find(k => k._2.size == 2) != None) && (group.size == 3)) true else false
  }

  private def isPair(): Boolean = {
    return if ((group.find(k => k._2.size == 2) != None) && (group.size == 4)) true else false
  }

}
