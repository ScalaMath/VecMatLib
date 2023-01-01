package vecmatlib.vector

/**
 * Trait for all float vectors.
 *
 * @tparam F The vector class extending this trait
 */
trait VecFloat[F <: VecFloat[F]] extends VecBase[F] {

  /**
   * Computes the sum between this vector and the given one.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  def +(v: VecAsFloat[F]): F = this + v.toFloat

  /**
   * Computes the sum between this vector and the given one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  def plus(v: VecAsFloat[F]): F = this + v

  /**
   * Computes the subtraction between the given vector and this one.
   *
   * @param v The vector to subtract.
   * @return The subtraction of the given vector from this one.
   */
  def -(v: VecAsFloat[F]): F = this - v.toFloat

  /**
   * Computes the subtraction between the given vector and this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param v The vector to subtract.
   * @return The subtraction of the given vector from this one.
   */
  def minus(v: VecAsFloat[F]): F = this - v

  /**
   * Returns the product between this vector and the given scalar.
   *
   * @param k The scalar to which the vector is multiplied.
   * @return The result of the product between this vector and the given scalar.
   */
  def *(k: Float): F

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
  def /(k: Float): F = this * (1.0f / k)

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
  def *(v: VecAsFloat[F]): F = this * v.toFloat

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  def multiply(v: VecAsFloat[F]): F = this * v

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied.
   * @return The result of the dot product between this vector and the given one.
   */
  def dot(v: F): Float

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied.
   * @return The result of the dot product between this vector and the given one.
   */
  def dot(v: VecAsFloat[F]): Float = this dot v.toFloat

  /**
   * Returns the squared length (or squared magnitude) of this vector.
   *
   * @return The squared length of this vector.
   */
  def lengthSquared: Float

  override def length: Double = Math.sqrt(this.lengthSquared)

  /**
   * Returns the squared distance between this vector and the given one.
   *
   * Using `a.distanceSquaredTo(b)` is equivalent to using `(b - a).lengthSquared`.
   *
   * @param v The second vector.
   * @return The squared distance between this vector and the given one
   */
  def distanceSquaredTo(v: F): Float = (-(this - v)).lengthSquared

  /**
   * Returns the squared distance between this vector and the given one.
   *
   * Using `a.distanceSquaredTo(b)` is equivalent to using `(b - a).lengthSquared`.
   *
   * @param v The second vector.
   * @return The squared distance between this vector and the given one
   */
  def distanceSquaredTo(v: VecAsFloat[F]): Float = this.distanceSquaredTo(v.toFloat)

  /**
   * Returns the distance between this vector and the given one.
   *
   * Using `a.distanceTo(b)` is equivalent to using `(b - a).length`.
   *
   * @param v The second vector.
   * @return The distance between this vector and the given one
   */
  def distanceTo(v: VecAsFloat[F]): Double = this.distanceTo(v.toFloat)

  /**
   * Returns this vector reflected from a plane defined by the given normal.
   *
   * @param n The normal of the plane (must be normalized)
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(n: F): F = this - (n * (this dot n) * 2)

  /**
   * Returns this vector reflected from a plane defined by the given normal.
   *
   * @param n The normal of the plane (must be normalized)
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(n: VecAsFloat[F]): F = this.reflect(n.toFloat)

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal.
   *
   * @param n The normal of the plane (must be normalized)
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(n: F): F = -this.reflect(n)

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal.
   *
   * @param n The normal of the plane (must be normalized)
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(n: VecAsFloat[F]): F = this.bounce(n.toFloat)

  /**
   * Returns this vector projected onto the given one.
   *
   * @param v The vector to project onto
   * @return This vector projected onto the given one
   */
  def project(v: F): F = v * ((this dot v) / v.lengthSquared)

  /**
   * Returns this vector projected onto the given one.
   *
   * @param v The vector to project onto
   * @return This vector projected onto the given one
   */
  def project(v: VecAsFloat[F]): F = this.project(v.toFloat)

  /**
   * Returns this vector slid along a plane defined by the given normal.
   *
   * @param n The normal of the plane
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(n: F): F = this - (n * (this dot n))

  /**
   * Returns this vector slid along a plane defined by the given normal.
   *
   * @param n The normal of the plane
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(n: VecAsFloat[F]): F = this.slide(n.toFloat)
}
