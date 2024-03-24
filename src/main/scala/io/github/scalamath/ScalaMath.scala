package io.github.scalamath

import io.github.scalamath

/**
 * Scala object containing methods for performing numeric operations that are not in `scala.math` or [[java.lang.Math]].
 *
 * All methods forward to the `scalamath` package object.
 * This object can be used for better interoperability with Java.
 */
object ScalaMath {

  /**
   * Clamps the given value between the given minimum and maximum.
   *
   * Returns the given value if it is between the given maximum and minimum, the minimum if the given value is less than the minimum, or the maximum if the given value is greater than the maximum.
   *
   * @param value The value.
   * @param min The minimum value.
   * @param max The maximum value.
   * @return The given value clamped between the given maximum and minimum.
   */
  def clamp(value: Int, min: Int, max: Int): Int = scalamath.clamp(value, min, max)

  /**
   * Clamps the given value between the given minimum and maximum.
   *
   * Returns the given value if it is between the given maximum and minimum, the minimum if the given value is less than the minimum, or the maximum if the given value is greater than the maximum.
   *
   * @param value The value.
   * @param min The minimum value.
   * @param max The maximum value.
   * @return The given value clamped between the given maximum and minimum.
   */
  def clamp(value: Float, min: Float, max: Float): Float = scalamath.clamp(value, min, max)

  /**
   * Clamps the given value between the given minimum and maximum.
   *
   * Returns the given value if it is between the given maximum and minimum, the minimum if the given value is less than the minimum, or the maximum if the given value is greater than the maximum.
   *
   * @param value The value.
   * @param min The minimum value.
   * @param max The maximum value.
   * @return The given value clamped between the given maximum and minimum.
   */
  def clamp(value: Double, min: Double, max: Double): Double = scalamath.clamp(value, min, max)

  /**
   * Linearly interpolates between the two given values by the given weight and returns the result.
   *
   * The given weight must be in the `[0.0, 1.0]` range, representing the amount of interpolation.
   *
   * @param from The first value.
   * @param to The second value.
   * @param weight The weight of the interpolation between `0.0` and `1.0`.
   * @return The result of linearly interpolating between the two given values.
   */
  def lerp(from: Float, to: Float, weight: Float): Float = scalamath.lerp(from, to, weight)

  /**
   * Linearly interpolates between the two given values by the given weight and returns the result.
   *
   * The given weight must be in the `[0.0, 1.0]` range, representing the amount of interpolation.
   *
   * @param from The first value.
   * @param to The second value.
   * @param weight The weight of the interpolation between `0.0` and `1.0`.
   * @return The result of linearly interpolating between the two given values.
   */
  def lerp(from: Double, to: Double, weight: Double): Double = scalamath.lerp(from, to, weight)

  /**
   * Checks if the given values are approximately equal using an internal epsilon.
   *
   * @param a The first value.
   * @param b The second value.
   * @return True if the two values are approximately equal, otherwise false.
   */
  def equalsApprox(a: Float, b: Float): Boolean = scalamath.equalsApprox(a, b)

  /**
   * Checks if the given values are approximately equal using an internal epsilon.
   *
   * @param a The first value.
   * @param b The second value.
   * @return True if the two values are approximately equal, otherwise false.
   */
  def equalsApprox(a: Double, b: Double): Boolean = scalamath.equalsApprox(a, b)
}
