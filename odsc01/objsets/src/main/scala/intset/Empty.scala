package intset

/** Created by Ravil on 10/03/2018. */
class Empty extends IntSet {
  override def contains(x: Int): Boolean = false
  override def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty);

  override def toString: String = "."
}
