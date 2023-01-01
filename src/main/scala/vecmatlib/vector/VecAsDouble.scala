package vecmatlib.vector

/**
 * Trait for vectors that can be converted to double.
 *
 * @tparam D The corresponding double vector
 */
trait VecAsDouble[D <: VecDouble[D]] {

  /**
   * Converts this vector to a double vector.
   *
   * @return This same vector as a double vector
   */
  def toDouble: D

  /**
   * Computes the sum between this vector and the given one.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  def +(v: D): D = this.toDouble + v

  /**
   * Computes the sum between this vector and the given one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  def plus(v: D): D = this + v

  /**
   * Computes the subtraction between the given vector and this one.
   *
   * @param v The vector to subtract.
   * @return The subtraction of the given vector from this one.
   */
  def -(v: D): D = this.toDouble - v

  /**
   * Computes the subtraction between the given vector and this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param v The vector to subtract.
   * @return The subtraction of the given vector from this one.
   */
  def minus(v: D): D = this - v

  /**
   * Returns the product between this vector and the given scalar.
   *
   * @param k The scalar to which the vector is multiplied.
   * @return The result of the product between this vector and the given scalar.
   */
  def *(k: Double): D = this.toDouble * k

  /**
   * Returns the product between this vector and the given scalar.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param k The scalar to which the vector is multiplied.
   * @return The result of the product between this vector and the given scalar.
   */
  def multipliedBy(k: Double): D = this * k

  /**
   * Returns the division of this vector by the given scalar.
   *
   * @param k The scalar by which the vector is divided.
   * @return The result of the division of this vector by the given scalar.
   */
  def /(k: Double): D = this.toDouble / k

  /**
   * Returns the division of this vector by the given scalar.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param k The scalar by which the vector is divided.
   * @return The result of the division of this vector by the given scalar.
   */
  def dividedBy(k: Double): D = this / k

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  def *(v: D): D = this.toDouble * v

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  def multiply(v: D): D = this * v

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied.
   * @return The result of the dot product between this vector and the given one.
   */
  def dot(v: D): Double = this.toDouble dot v

  /**
   * Returns a normalized vector that has the same direction as this one.
   *
   * @return A vector with the same direction as this one and length 1.
   */
  def normalized: D = this.toDouble.normalized

  /**
   * Returns the angle in radians between this vector and the given one.
   *
   * @param v The second vector
   * @return The angle in radians between this vector and the given one
   */
  def angle(v: D): Double = this.toDouble.angle(v)

  /**
   * Returns the angle in radians between this vector and the given one.
   *
   * @param v The second vector
   * @return The angle in radians between this vector and the given one
   */
  def angle(v: VecAsDouble[D]): Double = this.angle(v.toDouble)

  /**
   * Returns the normalized vector pointing from this vector to the given one.
   *
   * Using `a.directionTo(b)` is equivalent to using `(b - a).normalized`.
   *
   * @param v The vector to which the direction is pointing
   * @return The normalized vector pointing from this vector to the given one
   */
  def directionTo(v: D): D = this.toDouble.directionTo(v)

  /**
   * Returns the squared distance between this vector and the given one.
   *
   * Using `a.distanceSquaredTo(b)` is equivalent to using `(b - a).lengthSquared`.
   *
   * @param v The second vector.
   * @return The squared distance between this vector and the given one
   */
  def distanceSquaredTo(v: D): Double = this.toDouble.distanceSquaredTo(v)

  /**
   * Returns the distance between this vector and the given one.
   *
   * Using `a.distanceTo(b)` is equivalent to using `(b - a).length`.
   *
   * @param v The second vector.
   * @return The distance between this vector and the given one
   */
  def distanceTo(v: D): Double = this.toDouble.distanceTo(v)

  /**
   * Returns the normalized vector pointing from this vector to the given one.
   *
   * Using `a.directionTo(b)` is equivalent to using `(b - a).normalized`.
   *
   * @param v The vector to which the direction is pointing
   * @return The normalized vector pointing from this vector to the given one
   */
  def directionTo(v: VecAsDouble[D]): D = this.directionTo(v.toDouble)

  /**
   * Returns this vector reflected from a plane defined by the given normal.
   *
   * @param n The normal of the plane (must be normalized)
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(n: D): D = this.toDouble.reflect(n)

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal.
   *
   * @param n The normal of the plane (must be normalized)
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(n: D): D = this.toDouble.bounce(n)

  /**
   * Returns this vector projected onto the given one.
   *
   * @param v The vector to project onto
   * @return This vector projected onto the given one
   */
  def project(v: D): D = this.toDouble.project(v)

  /**
   * Returns this vector slid along a plane defined by the given normal.
   *
   * @param n The normal of the plane
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(n: D): D = this.toDouble.slide(n)
}
