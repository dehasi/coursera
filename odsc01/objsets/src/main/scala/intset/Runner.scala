package intset

/** Created by Ravil on 10/03/2018. */
object Runner {
  def main(args: Array[String]): Unit = {
    val t1 = new NonEmpty(3, new Empty, new Empty)
    val t2 = t1 incl 4
    println(t1)
    println(t2)
  }
}
