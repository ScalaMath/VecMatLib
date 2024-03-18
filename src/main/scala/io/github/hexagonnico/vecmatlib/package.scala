package io.github.hexagonnico

package object vecmatlib {

  val Epsilon = 1e-6

  implicit class FloatEqualsApprox(val self: Float) extends AnyVal {

    def ~=(x: Float): Boolean = self == x || math.abs(self - x) < math.max(Epsilon, Epsilon * math.abs(self))
  }

  implicit class DoubleEqualsApprox(val self: Double) extends AnyVal {

    def ~=(x: Double): Boolean = self == x || math.abs(self - x) < math.max(Epsilon, Epsilon * math.abs(self))
  }

  def clamp(value: Int, min: Int, max: Int): Int = math.max(min, math.min(value, max))

  def clamp(value: Float, min: Float, max: Float): Float = math.max(min, math.min(value, max))

  def clamp(value: Double, min: Double, max: Double): Double = math.max(min, math.min(value, max))

  def lerp(from: Float, to: Float, weight: Float): Float = from + (to - from) * weight

  def lerp(from: Double, to: Double, weight: Double): Double = from + (to - from) * weight
}
