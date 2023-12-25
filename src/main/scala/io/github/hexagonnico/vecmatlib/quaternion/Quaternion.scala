package io.github.hexagonnico.vecmatlib.quaternion

import io.github.hexagonnico.vecmatlib.vector.VecAbstract

/**
 * Abstract class with quaternion operations.
 *
 * @tparam Q The quaternion class extending this one.
 * @tparam V The 3D vector of the same type as this quaternion.
 */
abstract class Quaternion[Q <: Quaternion[Q, V], V <: VecAbstract[V]] {

  /**
   * Returns the sum between this quaternion and the given one.
   *
   * @param q The quaternion to add.
   * @return The sum of this quaternion and the given one.
   */
  def +(q: Q): Q

  /**
   * Returns the sum between this quaternion and the given one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param q The quaternion to add.
   * @return The sum of this quaternion and the given one.
   */
  def plus(q: Q): Q = this + q

  /**
   * Returns the additive inverse of this quaternion.
   *
   * @return The additive inverse of this quaternion.
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
   * Returns the subtraction between the given quaternion and this one.
   *
   * @param q The quaternion to subtract.
   * @return The subtraction of the given quaternion from this one.
   */
  def -(q: Q): Q = this + (-q)

  /**
   * Returns the subtraction between the given quaternion and this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param q The quaternion to subtract.
   * @return The subtraction of the given quaternion from this one.
   */
  def minus(q: Q): Q = this - q

  /**
   * Returns the product between this quaternion and the given one as defined by the Hamilton product.
   *
   * @param q The second operand of the multiplication.
   * @return The product between this quaternion and the given one.
   */
  def *(q: Q): Q

  /**
   * Returns the product between this quaternion and the given one as defined by the Hamilton product.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param q The second operand of the multiplication.
   * @return The product between this quaternion and the given one.
   */
  def multiply(q: Q): Q = this * q

  /**
   * Returns the conjugate of this quaternion.
   * The conjugate of a quaternion `w + xi + yj + zk` is the quaternion `w - xi - yj - zk`.
   *
   * @return The conjugate of this quaternion.
   */
  def conjugate: Q

  /**
   * Returns the length (or norm) of this quaternion.
   *
   * @return The norm of this quaternion.
   */
  def length: Double

  /**
   * Returns this quaternion as a unit quaternion.
   * That is, a quaternion of norm (or [[length]]) 1.
   * Obtained by dividing this quaternion by its [[length]].
   *
   * @return This quaternion as a unit quaternion
   */
  def normalized: Q

  /**
   * Returns the multiplicative inverse of this quaternion.
   *
   * The same quaternion can be obtained with `1.0 / q`.
   *
   * @return The inverse of this quaternion.
   */
  def inverse: Q

  /**
   * Returns the product of this quaternion by the [[inverse]] of the given one.
   *
   * @param q The second operand of the division.
   * @return The product of this quaternion by the inverse of the given one.
   */
  def /(q: Q): Q = this * q.inverse

  /**
   * Returns the product of this quaternion by the [[inverse]] of the given one.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param q The second operand of the division.
   * @return The product of this quaternion by the inverse of the given one.
   */
  def divide(q: Q): Q = this / q

  /**
   * Raises this quaternion to the power of the given exponent.
   *
   * A quaternion raised to the power of 0 is the identity quaternion.
   * A quaternion raised to a negative power is equal to its inverse raised to the additive inverse of the exponent.
   *
   * @param t The exponent.
   * @return This quaternion raised to the power of the given exponent.
   */
  def pow(t: Int): Q

  /**
   * Returns the exponential of this quaternion.
   *
   * @return The exponential of this quaternion.
   */
  def exp: Q

  /**
   * Returns the logarithm of this quaternion.
   *
   * @return The logarithm of this quaternion.
   */
  def log: Q

  /**
   * Returns this quaternion's rotation in the form of euler angles.
   *
   * The result is undefined if this quaternion is not [[normalized]].
   *
   * TODO: Specify rotation order
   *
   * @return This quaternion's rotation in the form of euler angles.
   */
  def euler: V

  /**
   * Returns the angle of the rotation represented by this unit quaternion.
   *
   * The result is undefined if this quaternion is not [[normalized]].
   *
   * @return The angle of the rotation represented by this unit quaternion.
   */
  def angle: Double

  /**
   * Returns the vector part of this quaternion.
   * The vector part of a quaternion `w + xi + yj + zk` is the vector `(x, y, z)`.
   *
   * @return The vector part of this quaternion.
   */
  def vector: V

  /**
   * Returns the spherical linear interpolation between this quaternion and the given one.
   *
   * @param to The second quaternion.
   * @param weight Interpolation weight.
   * @return The spherical linear interpolation between this quaternion and the given one
   */
  def slerp(to: Q, weight: Double): Q
}
