package nuboat.poker

case class Card(char:Char, suit:Suit.Value) {

  val value = toValue(char)

  def toValue(x: Char): Int = x match {
    case '1' => 1
    case '2' => 2
    case '3' => 3
    case '4' => 4
    case '5' => 5
    case '6' => 6
    case '7' => 7
    case '8' => 8
    case '9' => 9
    case 'T' => 10
    case 'J' => 11
    case 'Q' => 12
    case 'K' => 13
    case 'A' => 14
    case _ => throw new IllegalArgumentException("Value Errors")
  }
}

object Suit extends Enumeration {
  val C, D, H, S = Value
}
