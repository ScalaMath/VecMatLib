package vecmatlib.vector

/**
 * Trait for vectors that can be converted to float.
 *
 * @tparam F The vector class extending this trait.
 */
trait VecAsFloat[F <: VecFloat[F]] {

  /**
   * Converts this vector to a float vector.
   *
   * @return This same vector as a float vector.
   */
  def toFloat: F

  /**
   * Computes the sum between this vector and the given one.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  def +(v: F): F = this.toFloat + v

  /**
   * Computes the sum between this vector and the given one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  def plus(v: F): F = this + v

  /**
   * Computes the subtraction between the given vector and this one.
   *
   * @param v The vector to subtract.
   * @return The subtraction of the given vector from this one.
   */
  def -(v: F): F = this.toFloat - v

  /**
   * Computes the subtraction between the given vector and this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param v The vector to subtract.
   * @return The subtraction of the given vector from this one.
   */
  def minus(v: F): F = this - v

  /**
   * Returns the product between this vector and the given scalar.
   *
   * @param k The scalar to which the vector is multiplied.
   * @return The result of the product between this vector and the given scalar.
   */
  def *(k: Float): F = this.toFloat * k

  /**
   * Returns the product between this vector and the given scalar.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param k The scalar to which the vector is multiplied.
   * @return The result of the product between this vector and the given scalar.
   */
  def multipliedBy(k: Float): F = this * k

  /**
   * Returns the division of this vector by the given scalar.
   *
   * @param k The scalar by which the vector is divided.
   * @return The result of the division of this vector by the given scalar.
   */
  def /(k: Float): F = this.toFloat / k

  /**
   * Returns the division of this vector by the given scalar.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param k The scalar by which the vector is divided.
   * @return The result of the division of this vector by the given scalar.
   */
  def dividedBy(k: Float): F = this / k

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  def *(v: F): F = this.toFloat * v

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  def multiply(v: F): F = this * v

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied.
   * @return The result of the dot product between this vector and the given one.
   */
  def dot(v: F): Float = this.toFloat dot v

  /**
   * Returns the squared distance between this vector and the given one.
   *
   * Using `a.distanceSquaredTo(b)` is equivalent to using `(b - a).lengthSquared`.
   *
   * @param v The second vector.
   * @return The squared distance between this vector and the given one
   */
  def distanceSquaredTo(v: F): Float = this.toFloat.distanceSquaredTo(v)

  /**
   * Returns the distance between this vector and the given one.
   *
   * Using `a.distanceTo(b)` is equivalent to using `(b - a).length`.
   *
   * @param v The second vector.
   * @return The distance between this vector and the given one
   */
  def distanceTo(v: F): Double = this.toFloat.distanceTo(v)

  /**
   * Returns this vector reflected from a plane defined by the given normal.
   *
   * @param n The normal of the plane (must be normalized)
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(n: F): F = this.toFloat.reflect(n)

  /**
   * Returns this vector reflected from a plane defined by the given normal.
   *
   * @param n The normal of the plane (must be normalized)
   * @return This vector reflected from a plane defined by the given normal
   */
  def bounce(n: F): F = this.toFloat.bounce(n)

  /**
   * Returns this vector projected onto the given one.
   *
   * @param v The vector to project onto
   * @return This vector projected onto the given one
   */
  def project(v: F): F = this.toFloat.project(v)

  /**
   * Returns this vector slid along a plane defined by the given normal.
   *
   * @param n The normal of the plane
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(n: F): F = this.toFloat.slide(n)
}
