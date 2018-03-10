package intset

/** Created by Ravil on 10/03/2018. */
object Empty extends IntSet {
  override def contains(x: Int): Boolean = false

  override def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty);

  override def toString: String = "."
}
