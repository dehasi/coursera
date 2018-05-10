package week04.frp

/** Created by Ravil on 10/05/2018. */
object NoSignal extends Signal[Nothing](???) {

}

object Signal{
   val caller = new StackableVariable[Signal[_]](NoSignal)

  def apply[T](expr: => T) = new Signal(expr)
}