package week04.frp

/** Created by Ravil on 10/05/2018. */
class Var[T](expr: => T) extends Signal[T](expr) {
  def update(expr: => T):Unit = ???
}

object Var {
  def apply[T](expr: => T) = new Var(expr)
}