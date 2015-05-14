package nuboat.poker



object Main extends App {

  val cards1 = List(Card('4', Suit.C), Card('9', Suit.D), Card('A', Suit.H), Card('T', Suit.S), Card('2', Suit.S))
  val player1 = Player(Player.B, cards1)

  val cards2 = List(Card('J', Suit.C), Card('8', Suit.D), Card('7', Suit.H), Card('6', Suit.S), Card('5', Suit.S))
  val player2 = Player(Player.B, cards2)

  println( player1 vs player2 )

}