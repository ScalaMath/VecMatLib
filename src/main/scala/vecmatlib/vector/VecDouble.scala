package vecmatlib.vector

/**
 * Trait for all double vectors.
 *
 * @tparam D The vector class extending this trait
 */
trait VecDouble[D <: VecDouble[D]] extends VecBase[D] {

  /**
   * Returns the sum between this vector and the given one.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  def +(v: VecAsDouble[D]): D = this + v.toDouble

  /**
   * Returns the sum between this vector and the given one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  def plus(v: VecAsDouble[D]): D = this + v

  /**
   * Returns the subtraction between the given vector and this one.
   *
   * @param v The vector to subtract.
   * @return The subtraction of the given vector from this one.
   */
  def -(v: VecAsDouble[D]): D = this - v.toDouble

  /**
   * Returns the subtraction between the given vector and this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param v The vector to subtract.
   * @return The subtraction of the given vector from this one.
   */
  def minus(v: VecAsDouble[D]): D = this - v

  /**
   * Returns the product between this vector and the given scalar.
   *
   * @param k The scalar to which the vector is multiplied.
   * @return The result of the product between this vector and the given scalar.
   */
  def *(k: Double): D

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
  def /(k: Double): D = this * (1.0 / k)

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
  def *(v: VecAsDouble[D]): D = this * v.toDouble

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  def multiply(v: VecAsDouble[D]): D = this * v

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied.
   * @return The result of the dot product between this vector and the given one.
   */
  def dot(v: D): Double

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied.
   * @return The result of the dot product between this vector and the given one.
   */
  def dot(v: VecAsDouble[D]): Double = this dot v.toDouble

  /**
   * Returns the squared length (or squared magnitude) of this vector.
   *
   * @return The squared length of this vector.
   */
  def lengthSquared: Double

  override def length: Double = Math.sqrt(this.lengthSquared)

  /**
   * Returns a normalized vector that has the same direction as this one.
   *
   * @return A vector with the same direction as this one and length 1.
   */
  def normalized: D = this / this.length

  /**
   * Returns the angle in radians between this vector and the given one.
   *
   * @param v The second vector
   * @return The angle in radians between this vector and the given one
   */
  def angle(v: D): Double = math.acos((this dot v) / (this.length * v.length))

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
  def directionTo(v: D): D = -(this - v).normalized

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
   * Returns the squared distance between this vector and the given one.
   *
   * Using `a.distanceSquaredTo(b)` is equivalent to using `(b - a).lengthSquared`.
   *
   * @param v The second vector.
   * @return The squared distance between this vector and the given one
   */
  def distanceSquaredTo(v: D): Double = (-(this - v)).lengthSquared

  /**
   * Returns the squared distance between this vector and the given one.
   *
   * Using `a.distanceSquaredTo(b)` is equivalent to using `(b - a).lengthSquared`.
   *
   * @param v The second vector.
   * @return The squared distance between this vector and the given one
   */
  def distanceSquaredTo(v: VecAsDouble[D]): Double = this.distanceSquaredTo(v.toDouble)

  /**
   * Returns the distance between this vector and the given one.
   *
   * Using `a.distanceTo(b)` is equivalent to using `(b - a).length`.
   *
   * @param v The second vector.
   * @return The distance between this vector and the given one
   */
  def distanceTo(v: VecAsDouble[D]): Double = this.distanceTo(v.toDouble)

  /**
   * Returns this vector reflected from a plane defined by the given normal.
   *
   * @param n The normal of the plane (must be normalized)
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(n: D): D = this - (n * (this dot n) * 2)

  /**
   * Returns this vector reflected from a plane defined by the given normal.
   *
   * @param n The normal of the plane (must be normalized)
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(n: VecAsDouble[D]): D = this.reflect(n.toDouble)

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal.
   *
   * @param n The normal of the plane (must be normalized)
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(n: D): D = -this.reflect(n)

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal.
   *
   * @param n The normal of the plane (must be normalized)
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(n: VecAsDouble[D]): D = this.bounce(n.toDouble)

  /**
   * Returns this vector projected onto the given one.
   *
   * @param v The vector to project onto
   * @return This vector projected onto the given one
   */
  def project(v: D): D = v * ((this dot v) / v.lengthSquared)

  /**
   * Returns this vector projected onto the given one.
   *
   * @param v The vector to project onto
   * @return This vector projected onto the given one
   */
  def project(v: VecAsDouble[D]): D = this.project(v.toDouble)

  /**
   * Returns this vector slid along a plane defined by the given normal.
   *
   * @param n The normal of the plane
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(n: D): D = this - (n * (this dot n))

  /**
   * Returns this vector slid along a plane defined by the given normal.
   *
   * @param n The normal of the plane
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(n: VecAsDouble[D]): D = this.slide(n.toDouble)
}
