package io.github.hexagonnico

package object vecmatlib {

  /**
   * Internal constant used to check if two values are approximately equal.
   */
  val Epsilon = 1e-6

  /**
   * Implicit class used for the `~=` operator.
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
    def ~=(x: Float): Boolean = self == x || math.abs(self - x) < math.max(Epsilon, Epsilon * math.abs(self))
  }

  /**
   * Implicit class used for the `~=` operator.
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
    def ~=(x: Double): Boolean = self == x || math.abs(self - x) < math.max(Epsilon, Epsilon * math.abs(self))
  }

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
}
