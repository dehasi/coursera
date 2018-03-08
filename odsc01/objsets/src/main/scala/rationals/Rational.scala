package rationals

/** Created by Ravil on 08/03/2018. */
class Rational(x: Int, y: Int) {
  def numer = x

  def denom = y

  def neg() = new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg)

  def add(that: Rational) =
    new Rational(
      numer * that.denom + denom * that.numer,
      denom * that.denom)

  def mul(that: Rational) = new Rational(numer * that.numer, denom * that.denom)

  override def toString: String = numer + "/" + denom
}
