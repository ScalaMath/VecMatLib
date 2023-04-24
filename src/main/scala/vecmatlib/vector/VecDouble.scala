package vecmatlib.vector

/**
 * Abstract class with operation for double vectors.
 *
 * @tparam V The vector class extending this one
 */
abstract class VecDouble[V <: VecDouble[V]] extends VecAbstract[V] {

  /**
   * Returns the product between this vector and the given scalar.
   *
   * @param k The scalar to which the vector is multiplied.
   * @return The result of the product between this vector and the given scalar.
   */
  def *(k: Double): V

  /**
   * Returns the product between this vector and the given scalar.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param k The scalar to which the vector is multiplied.
   * @return The result of the product between this vector and the given scalar.
   */
  def multipliedBy(k: Double): V = this * k

  /**
   * Returns the division of this vector by the given scalar.
   *
   * @param k The scalar by which the vector is divided.
   * @return The result of the division of this vector by the given scalar.
   */
  def /(k: Double): V = this * (1.0f / k)

  /**
   * Returns the division of this vector by the given scalar.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param k The scalar by which the vector is divided.
   * @return The result of the division of this vector by the given scalar.
   */
  def dividedBy(k: Double): V = this / k

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied.
   * @return The result of the dot product between this vector and the given one.
   */
  def dot(v: V): Double

  /**
   * Returns the squared length (or squared magnitude) of this vector.
   *
   * @return The squared length of this vector.
   */
  def lengthSquared: Double

  /**
   * Returns the length (or magnitude) of this vector.
   *
   * @return The length (or magnitude) of this vector.
   */
  def length: Double = Math.sqrt(this.lengthSquared)

  /**
   * Returns a normalized vector that has the same direction as this one.
   *
   * @return A vector with the same direction as this one and length 1.
   */
  def normalized: V = this / this.length

  /**
   * Returns the angle in radians between this vector and the given one.
   *
   * @param v The second vector
   * @return The angle in radians between this vector and the given one
   */
  override def angle(v: V): Double = math.acos((this dot v) / (this.length * v.length))

  /**
   * Returns the normalized vector pointing from this vector to the given one.
   *
   * Using `a.directionTo(b)` is equivalent to using `(b - a).normalized`.
   *
   * @param v The vector to which the direction is pointing
   * @return The normalized vector pointing from this vector to the given one
   */
  def directionTo(v: V): V = -(this - v).normalized

  /**
   * Returns the squared distance between this vector and the given one.
   *
   * Using `a.distanceSquaredTo(b)` is equivalent to using `(b - a).lengthSquared`.
   *
   * @param v The second vector.
   * @return The squared distance between this vector and the given one
   */
  def distanceSquaredTo(v: V): Double = (-(this - v)).lengthSquared

  /**
   * Returns the distance between this vector and the given one.
   *
   * Using `a.distanceTo(b)` is equivalent to using `(b - a).length`.
   *
   * @param v The second vector.
   * @return The distance between this vector and the given one
   */
  def distanceTo(v: V): Double = (-(this - v)).length

  /**
   * Returns this vector reflected from a plane defined by the given normal.
   *
   * @param n The normal of the plane (must be normalized)
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(n: V): V = this - (n * (this dot n) * 2.0)

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal.
   *
   * @param n The normal of the plane (must be normalized)
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(n: V): V = -this.reflect(n)

  /**
   * Returns this vector projected onto the given one.
   *
   * @param v The vector to project onto
   * @return This vector projected onto the given one
   */
  def project(v: V): V = v * ((this dot v) / v.lengthSquared)

  /**
   * Returns this vector slid along a plane defined by the given normal.
   *
   * @param n The normal of the plane
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(n: V): V = this - (n * (this dot n))

  /**
   * Returns the linear interpolation between this vector and the given one by the given weight.
   *
   * @param to     Vector to interpolate towards
   * @param weight Weight of the interpolation
   * @return The linear interpolation between this vector and the given one by the given weight
   */
  def lerp(to: V, weight: Double): V = (this * (1.0 - weight)) + (to * weight)

  /**
   * Returns an array containing all the elements of this vector.
   *
   * @return An array containing all the elements of this vector
   */
  def toArray: Array[Double]
}
