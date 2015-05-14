package nuboat.poker

object Player {
  val B = "Black"
  val W = "White"
}

case class Result(side: String, score: Score, isTie: Boolean = false) {
  override def toString(): String = {
    return if (isTie) "Tie" else s"$side wins - $score"
  }
}

case class Player(p: String, cards: List[Card]) {

  val sorted = cards.sortBy(-_.value)
  val score = cal()

  def cal(): Score = {
    val pattern = RankPattern(sorted)
    val rank = pattern.getRank
    val highCharValue = sorted(0).char
    val highIntValue = sorted(0).value
    return Score(rank, highCharValue, highIntValue)
  }

  def vs(competitor: Player): Result = {
    if (this.score.rank == competitor.score.rank
      && this.score.highIntValue == competitor.score.highIntValue) {
      return Result(null, null, true)
    }

    val winner = {
      if (this.score.rank == competitor.score.rank) {
        if (this.score.highIntValue > competitor.score.highIntValue) {
          this
        } else {
          competitor
        }
      } else {
        if (this.score.rank > competitor.score.rank) {
          this
        } else {
          competitor
        }
      }
    }


    return Result(winner.p, winner.score)
  }

}
