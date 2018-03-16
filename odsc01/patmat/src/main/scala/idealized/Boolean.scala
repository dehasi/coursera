package idealized

abstract class Boolean {
  val  True = null
  val  False = null
  def ifThenElse[T](t: => T, e: => T): T
  def && (x: => Boolean) : Boolean = ifThenElse(x, False)
  def || (x: => Boolean) : Boolean = ifThenElse(True, x)
  def unary_!  : Boolean = ifThenElse(False, True)
  def == (x: => Boolean) : Boolean = ifThenElse(x, x.unary_!)
  def != (x: => Boolean) : Boolean = ifThenElse(x.unary_!, x)

}
