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
   * The inverse of the `lerp` function.
   * Determines where a value lies between two points.
   *
   * @param from The first value.
   * @param to The second value.
   * @param value A value within the `[from, to]` range.
   * @return A value in the `[0.0, 1.0]` range that describes where the given value lies in the `[from, to]` range.
   */
  def inverseLerp(from: Float, to: Float, value: Float): Float = scalamath.inverseLerp(from, to, value)

  /**
   * The inverse of the `lerp` function.
   * Determines where a value lies between two points.
   *
   * @param from The first value.
   * @param to The second value.
   * @param value A value within the `[from, to]` range.
   * @return A value in the `[0.0, 1.0]` range that describes where the given value lies in the `[from, to]` range.
   */
  def inverseLerp(from: Double, to: Double, value: Double): Double = scalamath.inverseLerp(from, to, value)

  /**
   * Moves the first value toward the second value by the given delta without going past the final value.
   *
   * @param from The first value.
   * @param to The second value.
   * @param delta Delta amount.
   * @return The first value moved towards the second value by the given amount.
   */
  def moveToward(from: Int, to: Int, delta: Int): Int = scalamath.moveToward(from, to, delta)

  /**
   * Moves the first value toward the second value by the given delta without going past the final value.
   *
   * @param from The first value.
   * @param to The second value.
   * @param delta Delta amount.
   * @return The first value moved towards the second value by the given amount.
   */
  def moveToward(from: Long, to: Long, delta: Long): Long = scalamath.moveToward(from, to, delta)

  /**
   * Moves the first value toward the second value by the given delta without going past the final value.
   *
   * @param from The first value.
   * @param to The second value.
   * @param delta Delta amount.
   * @return The first value moved towards the second value by the given amount.
   */
  def moveToward(from: Float, to: Float, delta: Float): Float = scalamath.moveToward(from, to, delta)

  /**
   * Moves the first value toward the second value by the given delta without going past the final value.
   *
   * @param from The first value.
   * @param to The second value.
   * @param delta Delta amount.
   * @return The first value moved towards the second value by the given amount.
   */
  def moveToward(from: Double, to: Double, delta: Double): Double = scalamath.moveToward(from, to, delta)

  /**
   * Maps the given value from the first range to the second range.
   *
   * If the given value is outside of the first range, the resulting value will be outside of the second range.
   *
   * @param value The value to remap.
   * @param min1 The minimum of the first range.
   * @param max1 The maximum of the first range.
   * @param min2 The minimum of the second range.
   * @param max2 The maximum of the second range.
   * @return The remapped value.
   */
  def map(value: Int, min1: Int, max1: Int, min2: Int, max2: Int): Int = scalamath.map(value, min1, max1, min2, max2)

  /**
   * Maps the given value from the first range to the second range.
   *
   * If the given value is outside of the first range, the resulting value will be outside of the second range.
   *
   * @param value The value to remap.
   * @param min1 The minimum of the first range.
   * @param max1 The maximum of the first range.
   * @param min2 The minimum of the second range.
   * @param max2 The maximum of the second range.
   * @return The remapped value.
   */
  def map(value: Long, min1: Long, max1: Long, min2: Long, max2: Long): Long = scalamath.map(value, min1, max1, min2, max2)

  /**
   * Maps the given value from the first range to the second range.
   *
   * If the given value is outside of the first range, the resulting value will be outside of the second range.
   *
   * @param value The value to remap.
   * @param min1 The minimum of the first range.
   * @param max1 The maximum of the first range.
   * @param min2 The minimum of the second range.
   * @param max2 The maximum of the second range.
   * @return The remapped value.
   */
  def map(value: Float, min1: Float, max1: Float, min2: Float, max2: Float): Float = scalamath.map(value, min1, max1, min2, max2)

  /**
   * Maps the given value from the first range to the second range.
   *
   * If the given value is outside of the first range, the resulting value will be outside of the second range.
   *
   * @param value The value to remap.
   * @param min1 The minimum of the first range.
   * @param max1 The maximum of the first range.
   * @param min2 The minimum of the second range.
   * @param max2 The maximum of the second range.
   * @return The remapped value.
   */
  def map(value: Double, min1: Double, max1: Double, min2: Double, max2: Double): Double = scalamath.map(value, min1, max1, min2, max2)

  /**
   * Returns a sigmoid-like interpolation of the given value between zero and one, based on where it lies with respect to the given edges.
   *
   * The return value is `0.0` if the given value is less than the minimum, `1.0` if the given value is greater than the maximum.
   *
   * @param from The lower bound of the range.
   * @param to The upper bound of the range.
   * @param value The given value.
   * @return A sigmoid-like interpolation of the given value between zero and one.
   */
  def smoothstep(from: Float, to: Float, value: Float): Float = scalamath.smoothstep(from, to, value)

  /**
   * Returns a sigmoid-like interpolation of the given value between zero and one, based on where it lies with respect to the given edges.
   *
   * The return value is `0.0` if the given value is less than the minimum, `1.0` if the given value is greater than the maximum.
   *
   * @param from The lower bound of the range.
   * @param to The upper bound of the range.
   * @param value The given value.
   * @return A sigmoid-like interpolation of the given value between zero and one.
   */
  def smoothstep(from: Double, to: Double, value: Double): Double = scalamath.smoothstep(from, to, value)

  /**
   * Returns the point at the given `t` on the quadratic Bézier curve defined by the given points.
   *
   * @param from The starting point of the Bézier curve.
   * @param to The end point of the Bézier curve.
   * @param control The control point of the Bézier curve.
   * @param t The interpolation weight. Must be in the [0.0, 1.0] range.
   * @return The point at the given `t` on the quadratic Bézier curve defined by the given points.
   */
  def bezierInterpolate(from: Float, to: Float, control: Float, t: Float): Float = scalamath.bezierInterpolate(from, to, control, t)

  /**
   * Returns the point at the given `t` on the quadratic Bézier curve defined by the given points.
   *
   * @param from The starting point of the Bézier curve.
   * @param to The end point of the Bézier curve.
   * @param control The control point of the Bézier curve.
   * @param t The interpolation weight. Must be in the [0.0, 1.0] range.
   * @return The point at the given `t` on the quadratic Bézier curve defined by the given points.
   */
  def bezierInterpolate(from: Double, to: Double, control: Double, t: Double): Double = scalamath.bezierInterpolate(from, to, control, t)

  /**
   * Returns the derivative at the given `t` on the quadratic Bézier curve defined by the given points.
   *
   * @param from The starting point of the Bézier curve.
   * @param to The end point of the Bézier curve.
   * @param control The control point of the Bézier curve.
   * @param t The interpolation weight. Must be in the [0.0, 1.0] range.
   * @return The derivative at the given `t` on the quadratic Bézier curve defined by the given points.
   */
  def bezierDerivative(from: Float, to: Float, control: Float, t: Float): Float = scalamath.bezierDerivative(from, to, control, t)

  /**
   * Returns the derivative at the given `t` on the quadratic Bézier curve defined by the given points.
   *
   * @param from The starting point of the Bézier curve.
   * @param to The end point of the Bézier curve.
   * @param control The control point of the Bézier curve.
   * @param t The interpolation weight. Must be in the [0.0, 1.0] range.
   * @return The derivative at the given `t` on the quadratic Bézier curve defined by the given points.
   */
  def bezierDerivative(from: Double, to: Double, control: Double, t: Double): Double = scalamath.bezierDerivative(from, to, control, t)

  /**
   * Returns the point at the given `t` on the cubic Bézier curve defined by the given points.
   *
   * @param from The starting point of the Bézier curve.
   * @param to The end point of the Bézier curve.
   * @param control1 The first control point of the Bézier curve.
   * @param control2 The second control point of the Bézier curve.
   * @param t The interpolation weight. Must be in the [0.0, 1.0] range.
   * @return The point at the given `t` on the cubic Bézier curve defined by the given points.
   */
  def bezierInterpolate(from: Float, to: Float, control1: Float, control2: Float, t: Float): Float = scalamath.bezierInterpolate(from, to, control1, control2, t)

  /**
   * Returns the point at the given `t` on the cubic Bézier curve defined by the given points.
   *
   * @param from The starting point of the Bézier curve.
   * @param to The end point of the Bézier curve.
   * @param control1 The first control point of the Bézier curve.
   * @param control2 The second control point of the Bézier curve.
   * @param t The interpolation weight. Must be in the [0.0, 1.0] range.
   * @return The point at the given `t` on the cubic Bézier curve defined by the given points.
   */
  def bezierInterpolate(from: Double, to: Double, control1: Double, control2: Double, t: Double): Double = scalamath.bezierInterpolate(from, to, control1, control2, t)

  /**
   * Returns the derivative at the given `t` on the cubic Bézier curve defined by the given points.
   *
   * @param from The starting point of the Bézier curve.
   * @param to The end point of the Bézier curve.
   * @param control1 The first control point of the Bézier curve.
   * @param control2 The second control point of the Bézier curve.
   * @param t The interpolation weight. Must be in the [0.0, 1.0] range.
   * @return The derivative at the given `t` on the cubic Bézier curve defined by the given points.
   */
  def bezierDerivative(from: Float, to: Float, control1: Float, control2: Float, t: Float): Float = scalamath.bezierDerivative(from, to, control1, control2, t)

  /**
   * Returns the derivative at the given `t` on the cubic Bézier curve defined by the given points.
   *
   * @param from The starting point of the Bézier curve.
   * @param to The end point of the Bézier curve.
   * @param control1 The first control point of the Bézier curve.
   * @param control2 The second control point of the Bézier curve.
   * @param t The interpolation weight. Must be in the [0.0, 1.0] range.
   * @return The derivative at the given `t` on the cubic Bézier curve defined by the given points.
   */
  def bezierDerivative(from: Double, to: Double, control1: Double, control2: Double, t: Double): Double = scalamath.bezierDerivative(from, to, control1, control2, t)

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
