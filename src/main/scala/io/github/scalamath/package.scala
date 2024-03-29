package io.github

/**
 * The package object `io.github.scalamath` contains methods for performing numeric operations that are not in `scala.math` or [[java.lang.Math]].
 *
 * All methods in the [[ScalaMath]] object forward here and can be used for better interoperability with Java.
 */
package object scalamath {

  /** Internal constant used to check if two values are approximately equal. */
  val Epsilon = 1e-6

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
  def clamp(value: Int, min: Int, max: Int): Int = math.max(min, math.min(value, max))

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
  def clamp(value: Float, min: Float, max: Float): Float = math.max(min, math.min(value, max))

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
  def clamp(value: Double, min: Double, max: Double): Double = math.max(min, math.min(value, max))

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
  def lerp(from: Float, to: Float, weight: Float): Float = from + (to - from) * weight

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
  def lerp(from: Double, to: Double, weight: Double): Double = from + (to - from) * weight

  /**
   * Moves the first value toward the second value by the given delta without going past the final value.
   *
   * @param from The first value.
   * @param to The second value.
   * @param delta Delta amount.
   * @return The first value moved towards the second value by the given amount.
   */
  def moveToward(from: Int, to: Int, delta: Int): Int = if(math.abs(to - from) <= delta) to else from + (to - from).sign * delta

  /**
   * Moves the first value toward the second value by the given delta without going past the final value.
   *
   * @param from The first value.
   * @param to The second value.
   * @param delta Delta amount.
   * @return The first value moved towards the second value by the given amount.
   */
  def moveToward(from: Long, to: Long, delta: Long): Long = if(math.abs(to - from) <= delta) to else from + (to - from).sign * delta

  /**
   * Moves the first value toward the second value by the given delta without going past the final value.
   *
   * @param from The first value.
   * @param to The second value.
   * @param delta Delta amount.
   * @return The first value moved towards the second value by the given amount.
   */
  def moveToward(from: Float, to: Float, delta: Float): Float = if(math.abs(to - from) <= delta) to else from + (to - from).sign * delta

  /**
   * Moves the first value toward the second value by the given delta without going past the final value.
   *
   * @param from The first value.
   * @param to The second value.
   * @param delta Delta amount.
   * @return The first value moved towards the second value by the given amount.
   */
  def moveToward(from: Double, to: Double, delta: Double): Double = if (math.abs(to - from) <= delta) to else from + (to - from).sign * delta

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
  def map(value: Int, min1: Int, max1: Int, min2: Int, max2: Int): Int = (value - min1) * (max2 - min2) / (max1 - min1) + min2

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
  def map(value: Long, min1: Long, max1: Long, min2: Long, max2: Long): Long = (value - min1) * (max2 - min2) / (max1 - min1) + min2

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
  def map(value: Float, min1: Float, max1: Float, min2: Float, max2: Float): Float = (value - min1) * (max2 - min2) / (max1 - min1) + min2

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
  def map(value: Double, min1: Double, max1: Double, min2: Double, max2: Double): Double = (value - min1) * (max2 - min2) / (max1 - min1) + min2

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
  def smoothstep(from: Float, to: Float, value: Float): Float = {
    val s = clamp((value - from) / (to - from), 0.0f, 1.0f)
    s * s * (3.0f - 2.0f * s)
  }

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
  def smoothstep(from: Double, to: Double, value: Double): Double = {
    val s = clamp((value - from) / (to - from), 0.0, 1.0)
    s * s * (3.0 - 2.0 * s)
  }

  /**
   * Checks if the given values are approximately equal using an internal epsilon.
   *
   * The `~=` operator can be used instead of this method with the [[FloatEqualsApprox]] implicit class.
   *
   * @param a The first value.
   * @param b The second value.
   * @return True if the two values are approximately equal, otherwise false.
   */
  def equalsApprox(a: Float, b: Float): Boolean = a == b || math.abs(a - b) < math.max(Epsilon, Epsilon * math.abs(a))

  /**
   * Checks if the given values are approximately equal using an internal epsilon.
   *
   * The `~=` operator can be used instead of this method with the [[DoubleEqualsApprox]] implicit class.
   *
   * @param a The first value.
   * @param b The second value.
   * @return True if the two values are approximately equal, otherwise false.
   */
  def equalsApprox(a: Double, b: Double): Boolean = a == b || math.abs(a - b) < math.max(Epsilon, Epsilon * math.abs(a))

  /**
   * Implicit class that allows to use the `~=` operator.
   *
   * @param self This value.
   */
  implicit class FloatEqualsApprox(val self: Float) extends AnyVal {

    /**
     * Checks if this value is approximately equal to the given one using an internal epsilon.
     *
     * @param x The second value.
     * @return True if this value is approximately equal to the given one, otherwise false.
     */
    def ~=(x: Float): Boolean = equalsApprox(self, x)
  }

  /**
   * Implicit class that allows to use the `~=` operator.
   *
   * @param self This value.
   */
  implicit class DoubleEqualsApprox(val self: Double) extends AnyVal {

    /**
     * Checks if this value is approximately equal to the given one using an internal epsilon.
     *
     * @param x The second value.
     * @return True if this value is approximately equal to the given one, otherwise false.
     */
    def ~=(x: Double): Boolean = equalsApprox(self, x)
  }
}
