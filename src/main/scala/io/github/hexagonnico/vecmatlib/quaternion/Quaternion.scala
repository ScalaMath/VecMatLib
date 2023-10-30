package io.github.hexagonnico.vecmatlib.quaternion

import io.github.hexagonnico.vecmatlib.vector.Vec3d

/**
 * Abstract class with quaternion operations.
 *
 * @tparam Q The quaternion class extending this one
 */
abstract class Quaternion[Q <: Quaternion[Q]] {

  /**
   * Returns the sum between this quaternion and the given one.
   *
   * @param q The quaternion to add
   * @return The sum of this quaternion and the given one
   */
  def +(q: Q): Q

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
   * Returns the subtraction between the given quaternion and this one.
   *
   * @param q The quaternion to subtract
   * @return The subtraction of the given quaternion from this one
   */
  def -(q: Q): Q = this + (-q)

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
   * Returns the product between this quaternion and the given one as defined by the Hamilton product.
   *
   * @param q The second operand of the multiplication
   * @return The product between this quaternion and the given one
   */
  def *(q: Q): Q

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
   * Returns the conjugate of this quaternion.
   * The conjugate of a quaternion `w + xi + yj + zk` is the quaternion `w - xi - yj - zk`.
   *
   * @return The conjugate of this quaternion
   */
  def conjugate: Q

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
  def reciprocal: Q

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
  def euler: Vec3d

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
  def axis: Vec3d

  /**
   * Returns that is, this quaternion divided by its norm or [[length]].
   *
   * @return A unit quaternion
   */
  def slerp(to: Q, weight: Double): Q
}
