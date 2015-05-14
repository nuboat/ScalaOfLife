package nuboat.tfpe

/**
 * compress [1, 1, 2, 3, 3, 3, 2, 2, 3] => [1, 2, 3, 2, 3]
 * compress [[1, 2], [1, 2], [3, 4], [1, 2]] => [[1, 2], [3, 4], [1, 2]]
 * Created by pasoktummarungsri on 5/13/15.
 */
object FoldRight extends App {

  val l =  List(1, 1, 2, 3, 3, 3, 2, 2, 3)
  val r = l.foldRight(List[Int]())((b, a) => { if (a.isEmpty) b :: a else if (a(0) != b) b :: a else a })

  println(r)
}
