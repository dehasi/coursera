package idealized

abstract class Nat {
  def isZero:Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat) : Nat
  def - (that: Nat) : Nat
}
object Zero extends Nat {
  override def isZero = true

  override def predecessor = ???

  override def successor = new Succ(Zero)

  override def +(that: Nat) = ???

  override def -(that: Nat) = ???
}

class Succ(n:Nat) extends Nat{
  override def isZero = false

  override def predecessor = ???

  override def successor = new Succ(this)

  override def +(that: Nat) = ???

  override def -(that: Nat) = ???
}