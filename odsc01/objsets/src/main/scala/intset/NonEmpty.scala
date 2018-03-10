package intset

/** Created by Ravil on 10/03/2018. */
class NonEmpty(elem:Int, left:IntSet, right:IntSet) extends IntSet {
  override def incl(x: Int): IntSet = ???

  override def contains(x: Int): Boolean = ???
}
