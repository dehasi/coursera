package rationals

/** Created by Ravil on 08/03/2018. */
object Runner {
  def main(args: Array[String]): Unit = {

    val x = new Rational(1, 3)
    val y = new Rational(5, 7)
    val z = new Rational(3, 2)
    println(x.add(y))
    println(x.sub(y).sub(z))
    println(x.less(y))
    println(x.max(y))
  }

}
