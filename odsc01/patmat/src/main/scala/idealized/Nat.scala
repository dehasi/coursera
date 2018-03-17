package idealized

abstract class Nat {
  def isZero: Boolean

  def predecessor: Nat

  def successor: Nat

  def +(that: Nat): Nat

  def -(that: Nat): Nat
}

object Zero extends Nat {
  override def isZero = true

  override def predecessor = throw new NoSuchElementException

  override def successor = new Succ(Zero)

  override def +(that: Nat) = that

  override def -(that: Nat) = throw new NoSuchElementException
}

class Succ(n: Nat) extends Nat {
  override def isZero = false

  override def predecessor = this - new Succ(Zero)

  override def successor = new Succ(this)

  override def +(that: Nat) =
    if (that.isZero) this
    else this.successor + that.predecessor

  override def -(that: Nat) =
    if (that.isZero) this
    else this.predecessor - that.predecessor
}