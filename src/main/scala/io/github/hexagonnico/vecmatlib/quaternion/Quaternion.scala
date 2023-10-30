package io.github.hexagonnico.vecmatlib.quaternion

import io.github.hexagonnico.vecmatlib.vector.VecAbstract

/**
 * Abstract class with quaternion operations.
 *
 * @tparam S The type of scalar to use for this quaternion (Float or Double)
 * @tparam V The 3d vector of the same datatype as this quaternion
 * @tparam Q The quaternion class extending this one
 */
abstract class Quaternion[S <: AnyVal, V <: VecAbstract[V], Q <: Quaternion[S, V, Q]] {

  /**
   * Returns the real/scalar part of the quaternion.
   *
   * @return The real/scalar part of the quaternion
   */
  def w: S

  /**
   * Returns the first component of the vector part of the quaternion (imaginary 'i' axis).
   *
   * @return The first component of the vector part of the quaternion
   */
  def x: S

  /**
   * Returns the second component of the vector part of the quaternion (imaginary 'j' axis).
   *
   * @return The second component of the vector part of the quaternion
   */
  def y: S

  /**
   * Returns the third component of the vector part of the quaternion (imaginary 'k' axis).
   *
   * @return The third component of the vector part of the quaternion
   */
  def z: S

  /**
   * Returns the sum between this quaternion and the quaternion `w + xi + yj + zk`.
   *
   * @param w The real/scalar part of the quaternion to add
   * @param x The first component of the vector part of the quaternion to add
   * @param y The second component of the vector part of the quaternion to add
   * @param z The third component of the vector part of the quaternion to add
   * @return The sum of this quaternion and the one with the quaternion `w + xi + yj + zk`
   */
  def +(w: S, x: S, y: S, z: S): Q

  /**
   * Returns the sum between this quaternion and the quaternion `w + xi + yj + zk`.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param w The real/scalar part of the quaternion to add
   * @param x The first component of the vector part of the quaternion to add
   * @param y The second component of the vector part of the quaternion to add
   * @param z The third component of the vector part of the quaternion to add
   * @return The sum of this quaternion and the one with the quaternion `w + xi + yj + zk`
   */
  def plus(w: S, x: S, y: S, z: S): Q = this + (w, x, y, z)

  /**
   * Returns the sum between this quaternion and the given one.
   *
   * @param q The quaternion to add
   * @return The sum of this quaternion and the given one
   */
  def +(q: Q): Q = this + (q.w, q.x, q.y, q.z)

  /**
   * Returns the sum between this quaternion and the given one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param q The quaternion to add
   * @return The sum of this quaternion and the given one
   */
  def plus(q: Q): Q = this + q

  /**
   * Returns the additive inverse of this quaternion.
   *
   * @return The additive inverse of this quaternion
   */
  def unary_-(): Q

  /**
   * Returns the additive inverse of this quaternion.
   *
   * This method can be used in place of the unary '-' operator for better interoperability with Java.
   *
   * @return The additive inverse of this quaternion
   */
  def negated: Q = -this

  /**
   * Returns the subtraction between this quaternion and the quaternion `w + xi + yj + zk`.
   *
   * @param w The real/scalar part of the quaternion to subtract
   * @param x The first component of the vector part of the quaternion to subtract
   * @param y The second component of the vector part of the quaternion to subtract
   * @param z The third component of the vector part of the quaternion to subtract
   * @return The subtract of the quaternion `w + xi + yj + zk` from this one
   */
  def -(w: S, x: S, y: S, z: S): Q

  /**
   * Returns the subtraction between this quaternion and the quaternion `w + xi + yj + zk`.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param w The real/scalar part of the quaternion to subtract
   * @param x The first component of the vector part of the quaternion to subtract
   * @param y The second component of the vector part of the quaternion to subtract
   * @param z The third component of the vector part of the quaternion to subtract
   * @return The subtract of the quaternion `w + xi + yj + zk` from this one
   */
  def minus(w: S, x: S, y: S, z: S): Q = this - (w, x, y, z)

  /**
   * Returns the subtraction between the given quaternion and this one.
   *
   * @param q The quaternion to subtract
   * @return The subtraction of the given quaternion from this one
   */
  def -(q: Q): Q = this - (q.w, q.x, q.y, q.z)

  /**
   * Returns the subtraction between the given quaternion and this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param q The quaternion to subtract
   * @return The subtraction of the given quaternion from this one
   */
  def minus(q: Q): Q = this - q

  /**
   * Returns the product between this quaternion and the given scalar.
   *
   * @param l The scalar to which the quaternion is multiplied
   * @return The result of the product between this quaternion and the given scalar
   */
  def *(l: S): Q

  /**
   * Returns the product between this quaternion and the given scalar.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param l The scalar to which the quaternion is multiplied
   * @return The result of the product between this quaternion and the given scalar
   */
  def multipliedBy(l: S): Q = this * l

  /**
   * Returns the product between this quaternion and the quaternion `w + xi + yj + zk` as defined by the Hamilton product.
   *
   * @param w The real/scalar part of the second operand of the multiplication
   * @param x The first component of the vector part of the second operand of the multiplication
   * @param y The second component of the vector part of the second operand of the multiplication
   * @param z The third component of the vector part of the second operand of the multiplication
   * @return The product between this quaternion and the quaternion `w + xi + yj + zk`
   */
  def *(w: S, x: S, y: S, z: S): Q

  /**
   * Returns the product between this quaternion and the quaternion `w + xi + yj + zk` as defined by the Hamilton product.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param w The real/scalar part of the second operand of the multiplication
   * @param x The first component of the vector part of the second operand of the multiplication
   * @param y The second component of the vector part of the second operand of the multiplication
   * @param z The third component of the vector part of the second operand of the multiplication
   * @return The product between this quaternion and the quaternion `w + xi + yj + zk`
   */
  def multiply(w: S, x: S, y: S, z: S): Q = this * (w, x, y, z)

  /**
   * Returns the product between this quaternion and the given one as defined by the Hamilton product.
   *
   * @param q The second operand of the multiplication
   * @return The product between this quaternion and the given one
   */
  def *(q: Q): Q = this * (q.w, q.x, q.y, q.z)

  /**
   * Returns the product between this quaternion and the given one as defined by the Hamilton product.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param q The second operand of the multiplication
   * @return The product between this quaternion and the given one
   */
  def multiply(q: Q): Q = this * q

  /**
   * Returns the result of dividing this quaternion by the given scalar.
   *
   * @param l The scalar by which this quaternion is divided
   * @return The result of the division of this quaternion by the given scalar
   */
  def /(l: S): Q

  /**
   * Returns the result of dividing this quaternion by the given scalar.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param l The scalar by which this quaternion is divided
   * @return The result of the division of this quaternion by the given scalar
   */
  def dividedBy(l: S): Q = this / l

  /**
   * Returns the conjugate of this quaternion.
   * The conjugate of a quaternion `w + xi + yj + zk` is the quaternion `w - xi - yj - zk`.
   *
   * @return The conjugate of this quaternion
   */
  def conjugate: Q

  /**
   * Returns the result of the dot product (or scalar product) between this quaternion and the quaternion `w + xi + yj + zk`.
   *
   * @param w The real/scalar part of the second operand of the product
   * @param x The first component of the vector part of the second operand of the product
   * @param y The second component of the vector part of the second operand of the product
   * @param z The third component of the vector part of the second operand of the product
   * @return The result of the dot product between this quaternion and the quaternion `w + xi + yj + zk`
   */
  def dot(w: S, x: S, y: S, z: S): S

  /**
   * Returns the result of the dot product (or scalar product) between this quaternion and the given one.
   *
   * @param q The second operand of the product
   * @return The result of the dot product between this quaternion and the given one
   */
  def dot(q: Q): S = this dot (q.w, q.x, q.y, q.z)

  /**
   * Returns the squared length (or squared norm) of this quaternion.
   *
   * @return The squared norm of this quaternion
   */
  def lengthSquared: S

  /**
   * Returns the length (or norm) of this quaternion.
   *
   * @return The norm of this quaternion
   */
  def length: Double

  /**
   * Returns this quaternion as a unit quaternion.
   * That is, this quaternion divided by its norm or [[length]].
   *
   * @return This quaternion as a unit quaternion
   */
  def normalized: Q

  /**
   * Returns the multiplicative inverse (or the reciprocal) of this quaternion.
   *
   * The same quaternion can be obtained with `1.0 / q`.
   *
   * @return The reciprocal of this quaternion
   */
  def reciprocal: Q = this.conjugate / this.lengthSquared

  /**
   * Returns the product of this quaternion by the [[reciprocal]] of the quaternion `w + xi + yj + zk`.
   *
   * @param w The real/scalar part of the second operand of the division
   * @param x The first component of the vector part of the second operand of the division
   * @param y The second component of the vector part of the second operand of the division
   * @param z The third component of the vector part of the second operand of the division
   * @return The product of this quaternion by the reciprocal of the quaternion `w + xi + yj + zk`
   */
  def /(w: S, x: S, y: S, z: S): Q

  /**
   * Returns the product of this quaternion by the [[reciprocal]] of the quaternion `w + xi + yj + zk`.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param w The real/scalar part of the second operand of the division
   * @param x The first component of the vector part of the second operand of the division
   * @param y The second component of the vector part of the second operand of the division
   * @param z The third component of the vector part of the second operand of the division
   * @return The product of this quaternion by the reciprocal of the quaternion `w + xi + yj + zk`
   */
  def divide(w: S, x: S, y: S, z: S): Q = this / (w, x, y, z)

  /**
   * Returns the product of this quaternion by the [[reciprocal]] of the given one.
   *
   * @param q The second operand of the division
   * @return The product of this quaternion by the reciprocal of the given one
   */
  def /(q: Q): Q = this * q.reciprocal

  /**
   * Returns the product of this quaternion by the [[reciprocal]] of the given one.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param q The second operand of the division
   * @return The product of this quaternion by the reciprocal of the given one
   */
  def divide(q: Q): Q = this / q

  /**
   * Returns the exponential of this quaternion.
   *
   * @return The exponential of this quaternion
   */
  def exp: Q

  /**
   * Returns the logarithm of this quaternion.
   *
   * @return The logarithm of this quaternion
   */
  def log: Q

  /**
   * Returns this quaternion's rotation in the form of euler angles.
   *
   * The result is undefined if this quaternion is not [[normalized]].
   *
   * @return This quaternion's rotation in the form of euler angles
   */
  def euler: V

  /**
   * Returns the angle of the rotation represented by this unit quaternion.
   *
   * The result is undefined if this quaternion is not [[normalized]].
   *
   * @return The angle of the rotation represented by this unit quaternion
   */
  def angle: Double

  /**
   * Returns the axis this quaternion is rotating around.
   *
   * @return The axis this quaternion is rotating around
   */
  def axis: V

  /**
   * Returns that is, this quaternion divided by its norm or [[length]].
   *
   * @return A unit quaternion
   */
  def slerp(to: Q, weight: S): Q

  /**
   * Checks if the components of this quaternion are equal to the given ones.
   *
   * @param w The real/scalar part of the quaternion
   * @param x The first component of the vector part of the quaternion
   * @param y The second component of the vector part of the quaternion
   * @param z The third component of the vector part of the quaternion
   * @return True if the components of this quaternion equal the given ones, otherwise false
   */
  def ==(w: S, x: S, y: S, z: S): Boolean = this.w == w && this.x == x && this.y == y && this.z == z

  /**
   * Checks if the components of this quaternion are equal to the given ones.
   *
   * This method can be used in place of the '==' operator for better interoperability with Java.
   *
   * @param w The real/scalar part of the quaternion
   * @param x The first component of the vector part of the quaternion
   * @param y The second component of the vector part of the quaternion
   * @param z The third component of the vector part of the quaternion
   * @return True if the components of this quaternion equal the given ones, otherwise false
   */
  def equals(w: S, x: S, y: S, z: S): Boolean = this == (w, x, y, z)
}
