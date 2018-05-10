package week04.frp

/** Created by Ravil on 10/05/2018. */
class Signal[T](expr: => T) {
  def apply(): T = ???
}

object Signal {
  def apply[T](expr: => T) = new Signal(expr)
}
