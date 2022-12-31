package vecmatlib.vector

/**
 * Base trait for all vectors.
 *
 * @tparam V The vector class extending this trait.
 */
trait VecBase[V <: VecBase[V]] {

  /**
   * Returns the sum between this vector and the given one.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  def +(v: V): V

  /**
   * Returns the sum between this vector and the given one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  def plus(v: V): V = this + v

  /**
   * Returns the additive inverse of this vector.
   *
   * @return The additive inverse of this vector
   */
  def unary_- : V

  /**
   * Returns the additive inverse of this vector.
   *
   * This method can be used in place of the unary '-' operator for better interoperability with Java.
   *
   * @return The additive inverse of this vector
   */
  def negated: V = -this

  /**
   * Returns the subtraction between the given vector and this one.
   *
   * @param v The vector to subtract.
   * @return The subtraction of the given vector from this one.
   */
  def -(v: V): V = this + -v

  /**
   * Returns the subtraction between the given vector and this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param v The vector to subtract.
   * @return The subtraction of the given vector from this one.
   */
  def minus(v: V): V = this - v

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  def *(v: V): V

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  def multiply(v: V): V = this * v

  /**
   * Returns the length of this vector.
   *
   * @return The length of this vector.
   */
  def length: Double
}
