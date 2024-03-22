package io.github.scalamath.vecmatlib

import io.github.scalamath.{FloatEqualsApprox, clamp}

/**
 * Trait used to represent a color.
 * Different implementations may represent the color differently.
 */
trait Color {

  /**
   * Returns the red component of this color as a float in the `[0.0, 1.0]` range.
   *
   * Values outside the range are allowed.
   *
   * @return Returns the red component of this color as a float in the `[0.0, 1.0]` range.
   */
  def r: Float

  /**
   * Returns the red component of this color as an integer in the `[0, 255]` range.
   *
   * Values outside of the range are clamped.
   *
   * @return The red component of this color as an integer in the `[0, 255]` range.
   */
  def r8: Int = (clamp(this.r, 0.0f, 1.0f) * 255.0f).round

  /**
   * Returns the green component of this color as a float in the `[0.0, 1.0]` range.
   *
   * Values outside the range are allowed.
   *
   * @return Returns the green component of this color as a float in the `[0.0, 1.0]` range.
   */
  def g: Float

  /**
   * Returns the green component of this color as an integer in the `[0, 255]` range.
   *
   * Values outside of the range are clamped.
   *
   * @return The green component of this color as an integer in the `[0, 255]` range.
   */
  def g8: Int = (clamp(this.g, 0.0f, 1.0f) * 255.0f).round

  /**
   * Returns the blue component of this color as a float in the `[0.0, 1.0]` range.
   *
   * Values outside the range are allowed.
   *
   * @return Returns the blue component of this color as a float in the `[0.0, 1.0]` range.
   */
  def b: Float

  /**
   * Returns the blue component of this color as an integer in the `[0, 255]` range.
   *
   * Values outside of the range are clamped.
   *
   * @return The blue component of this color as an integer in the `[0, 255]` range.
   */
  def b8: Int = (clamp(this.b, 0.0f, 1.0f) * 255.0f).round

  /**
   * Returns the alpha component of this color as a float in the `[0.0, 1.0]` range.
   *
   * A value of 0 means that the color is fully transparent. A value of 1 means that the color is fully opaque.
   *
   * @return Returns the alpha component of this color as a float in the `[0.0, 1.0]` range.
   */
  def a: Float

  /**
   * Returns the alpha component of this color as an integer in the `[0, 255]` range.
   *
   * A value of 0 means that the color is fully transparent. A value of 255 means that the color is fully opaque.
   *
   * Values outside of the range are clamped.
   *
   * @return The alpha component of this color as an integer in the `[0, 255]` range.
   */
  def a8: Int = (clamp(this.a, 0.0f, 1.0f) * 255.0f).round

  /**
   * Returns an integer representing this color in the RGBA format.
   *
   * Values outside the `[0, 255]` range are clamped.
   *
   * @return An integer representing this color in the RGBA format.
   */
  def rgba: Int = (this.r8 << 24) | (this.g8 << 16) | (this.b8 << 8) | this.a8

  /**
   * Returns an integer representing this color in the ARGB format.
   *
   * Values outside the `[0, 255]` range are clamped.
   *
   * @return An integer representing this color in the ARGB format.
   */
  def argb: Int = (this.a8 << 24) | (this.r8 << 16) | (this.g8 << 8) | this.b8

  /**
   * Returns the HSV hue of this color in the `[0.0, 1.0]` range.
   *
   * @return The HSV hue of this color in the `[0.0, 1.0]` range.
   */
  def h: Float = {
    val (r, g, b) = (this.r, this.g, this.b)
    val min = math.min(math.min(r, g), b)
    val max = math.max(math.max(r, g), b)
    val delta = max - min
    if (delta != 0.0f) {
      var h = 0.0f
      if (r == max) {
        h = (g - b) / delta
      } else if (g == max) {
        h = 2.0f + (b - r) / delta
      } else {
        h = 4.0f + (r - g) / delta
      }
      if (h < 0.0f) {
        h / 6.0f + 1.0f
      } else {
        h / 6.0f
      }
    } else {
      0.0f
    }
  }

  /**
   * Returns the HSV saturation of this color in the `[0.0, 1.0]` range.
   *
   * @return The HSV saturation of this color in the `[0.0, 1.0]` range.
   */
  def s: Float = {
    val (r, g, b) = (this.r, this.g, this.b)
    val min = math.min(math.min(r, g), b)
    val max = math.max(math.max(r, g), b)
    if (max != 0.0f) {
      (max - min) / max
    } else {
      0.0f
    }
  }

  /**
   * Returns the HSV value (brightness) of this color in the `[0.0, 1.0]` range.
   *
   * @return The HSV value (brightness) of this color in the `[0.0, 1.0]` range.
   */
  def v: Float = math.max(math.max(this.r, this.g), this.b)

  /**
   * Adds the given values to each component of this color and returns the result.
   *
   * @param r The red component to add in the `[0.0, 1.0]` range.
   * @param g The green component to add in the `[0.0, 1.0]` range.
   * @param b The blue component to add in the `[0.0, 1.0]` range.
   * @param a The alpha component to add in the `[0.0, 1.0]` range.
   * @return The sum between this color and the given components.
   */
  def +(r: Float, g: Float, b: Float, a: Float): Color

  /**
   * Adds the given values to each component of this color and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param r The red component to add in the `[0.0, 1.0]` range.
   * @param g The green component to add in the `[0.0, 1.0]` range.
   * @param b The blue component to add in the `[0.0, 1.0]` range.
   * @param a The alpha component to add in the `[0.0, 1.0]` range.
   * @return The sum between this color and the given components.
   */
  def add(r: Float, g: Float, b: Float, a: Float): Color = this + (r, g, b, a)

  /**
   * Adds each component of this color with the components of the given color and returns the result.
   *
   * @param c The color to add.
   * @return The sum between this color and the given one.
   */
  def +(c: Color): Color = this + (c.r, c.g, c.b, c.a)

  /**
   * Adds each component of this color with the components of the given color and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param c The color to add.
   * @return The sum between this color and the given one.
   */
  def add(c: Color): Color = this + c

  /**
   * Adds the given values to each component of this color and returns the result.
   *
   * @param r The red component to add in the `[0.0, 1.0]` range.
   * @param g The green component to add in the `[0.0, 1.0]` range.
   * @param b The blue component to add in the `[0.0, 1.0]` range.
   * @return The sum between this color and the given components.
   */
  def +(r: Float, g: Float, b: Float): Color = this + (r, g, b, 0.0f)

  /**
   * Adds the given values to each component of this color and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param r The red component to add in the `[0.0, 1.0]` range.
   * @param g The green component to add in the `[0.0, 1.0]` range.
   * @param b The blue component to add in the `[0.0, 1.0]` range.
   * @return The sum between this color and the given components.
   */
  def add(r: Float, g: Float, b: Float): Color = this + (r, g, b)

  /**
   * Adds the given values to each component of this color and returns the result.
   *
   * @param r The red component to add in the `[0, 255]` range.
   * @param g The green component to add in the `[0, 255]` range.
   * @param b The blue component to add in the `[0, 255]` range.
   * @param a The alpha component to add in the `[0, 255]` range.
   * @return The sum between this color and the given components.
   */
  def +(r: Int, g: Int, b: Int, a: Int): Color = this + (r / 255.0f, g / 255.0f, b / 255.0f, a / 255.0f)

  /**
   * Adds the given values to each component of this color and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param r The red component to add in the `[0, 255]` range.
   * @param g The green component to add in the `[0, 255]` range.
   * @param b The blue component to add in the `[0, 255]` range.
   * @param a The alpha component to add in the `[0, 255]` range.
   * @return The sum between this color and the given components.
   */
  def add(r: Int, g: Int, b: Int, a: Int): Color = this + (r, g, b, a)

  /**
   * Adds the given values to each component of this color and returns the result.
   *
   * @param r The red component to add in the `[0, 255]` range.
   * @param g The green component to add in the `[0, 255]` range.
   * @param b The blue component to add in the `[0, 255]` range.
   * @return The sum between this color and the given components.
   */
  def +(r: Int, g: Int, b: Int): Color = this + (r, g, b, 0)

  /**
   * Adds the given values to each component of this color and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param r The red component to add in the `[0, 255]` range.
   * @param g The green component to add in the `[0, 255]` range.
   * @param b The blue component to add in the `[0, 255]` range.
   * @return The sum between this color and the given components.
   */
  def add(r: Int, g: Int, b: Int): Color = this + (r, g, b)

  /**
   * Subtracts the given values from each component of this color and returns the result.
   *
   * @param r The red component to subtract in the `[0.0, 1.0]` range.
   * @param g The green component to subtract in the `[0.0, 1.0]` range.
   * @param b The blue component to subtract in the `[0.0, 1.0]` range.
   * @param a The alpha component to subtract in the `[0.0, 1.0]` range.
   * @return The subtraction between this color and the given components.
   */
  def -(r: Float, g: Float, b: Float, a: Float): Color

  /**
   * Subtracts the given values from each component of this color and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param r The red component to subtract in the `[0.0, 1.0]` range.
   * @param g The green component to subtract in the `[0.0, 1.0]` range.
   * @param b The blue component to subtract in the `[0.0, 1.0]` range.
   * @param a The alpha component to subtract in the `[0.0, 1.0]` range.
   * @return The subtraction between this color and the given components.
   */
  def subtract(r: Float, g: Float, b: Float, a: Float): Color = this - (r, g, b, a)

  /**
   * Subtracts each component of the given color from the components of this color and returns the result.
   *
   * @param c The color to subtract.
   * @return The subtraction between this color and the given one.
   */
  def -(c: Color): Color = this - (c.r, c.g, c.b, c.a)

  /**
   * Subtracts each component of the given color from the components of this color and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param c The color to subtract.
   * @return The subtraction between this color and the given one.
   */
  def subtract(c: Color): Color = this - c

  /**
   * Subtracts the given values from each component of this color and returns the result.
   *
   * @param r The red component to subtract in the `[0.0, 1.0]` range.
   * @param g The green component to subtract in the `[0.0, 1.0]` range.
   * @param b The blue component to subtract in the `[0.0, 1.0]` range.
   * @return The subtraction between this color and the given components.
   */
  def -(r: Float, g: Float, b: Float): Color = this - (r, g, b, 0.0f)

  /**
   * Subtracts the given values from each component of this color and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param r The red component to subtract in the `[0.0, 1.0]` range.
   * @param g The green component to subtract in the `[0.0, 1.0]` range.
   * @param b The blue component to subtract in the `[0.0, 1.0]` range.
   * @return The subtraction between this color and the given components.
   */
  def subtract(r: Float, g: Float, b: Float): Color = this - (r, g, b)

  /**
   * Subtracts the given values from each component of this color and returns the result.
   *
   * @param r The red component to subtract in the `[0, 255]` range.
   * @param g The green component to subtract in the `[0, 255]` range.
   * @param b The blue component to subtract in the `[0, 255]` range.
   * @param a The alpha component to subtract in the `[0, 255]` range.
   * @return The subtraction between this color and the given components.
   */
  def -(r: Int, g: Int, b: Int, a: Int): Color = this - (r / 255.0f, g / 255.0f, b / 255.0f, a / 255.0f)

  /**
   * Subtracts the given values from each component of this color and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param r The red component to subtract in the `[0, 255]` range.
   * @param g The green component to subtract in the `[0, 255]` range.
   * @param b The blue component to subtract in the `[0, 255]` range.
   * @param a The alpha component to subtract in the `[0, 255]` range.
   * @return The subtraction between this color and the given components.
   */
  def subtract(r: Int, g: Int, b: Int, a: Int): Color = this - (r, g, b, a)

  /**
   * Subtracts the given values from each component of this color and returns the result.
   *
   * @param r The red component to subtract in the `[0, 255]` range.
   * @param g The green component to subtract in the `[0, 255]` range.
   * @param b The blue component to subtract in the `[0, 255]` range.
   * @return The subtraction between this color and the given components.
   */
  def -(r: Int, g: Int, b: Int): Color = this - (r, g, b, 0)

  /**
   * Subtracts the given values from each component of this color and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param r The red component to subtract in the `[0, 255]` range.
   * @param g The green component to subtract in the `[0, 255]` range.
   * @param b The blue component to subtract in the `[0, 255]` range.
   * @return The subtraction between this color and the given components.
   */
  def subtract(r: Int, g: Int, b: Int): Color = this - (r, g, b)

  /**
   * Multiplies each component of this color with the given values and returns the result.
   *
   * @param r The red component to multiply in the `[0.0, 1.0]` range.
   * @param g The green component to multiply in the `[0.0, 1.0]` range.
   * @param b The blue component to multiply in the `[0.0, 1.0]` range.
   * @param a The alpha component to multiply in the `[0.0, 1.0]` range.
   * @return The component-wise product between this color and the given values.
   */
  def *(r: Float, g: Float, b: Float, a: Float): Color

  /**
   * Multiplies each component of this color with the given values and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param r The red component to multiply in the `[0.0, 1.0]` range.
   * @param g The green component to multiply in the `[0.0, 1.0]` range.
   * @param b The blue component to multiply in the `[0.0, 1.0]` range.
   * @param a The alpha component to multiply in the `[0.0, 1.0]` range.
   * @return The component-wise product between this color and the given values.
   */
  def multiply(r: Float, g: Float, b: Float, a: Float): Color = this * (r, g, b, a)

  /**
   * Multiplies each component of this color with each component of the given one and returns the result.
   *
   * @param c The color to multiply this one by.
   * @return The component-wise product between this color and the given one.
   */
  def *(c: Color): Color = this * (c.r, c.g, c.b, c.a)

  /**
   * Multiplies each component of this color with each component of the given one and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param c The color to multiply this one by.
   * @return The component-wise product between this color and the given one.
   */
  def multiply(c: Color): Color = this * c

  /**
   * Multiplies each component of this color with the given values and returns the result.
   *
   * @param r The red component to multiply in the `[0.0, 1.0]` range.
   * @param g The green component to multiply in the `[0.0, 1.0]` range.
   * @param b The blue component to multiply in the `[0.0, 1.0]` range.
   * @return The component-wise product between this color and the given values.
   */
  def *(r: Float, g: Float, b: Float): Color = this * (r, g, b, 1.0f)

  /**
   * Multiplies each component of this color with the given values and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param r The red component to multiply in the `[0.0, 1.0]` range.
   * @param g The green component to multiply in the `[0.0, 1.0]` range.
   * @param b The blue component to multiply in the `[0.0, 1.0]` range.
   * @return The component-wise product between this color and the given values.
   */
  def multiply(r: Float, g: Float, b: Float): Color = this * (r, g, b)

  /**
   * Multiplies each component of this color with the given value and returns the result.
   *
   * @param f The value to multiply this color by.
   * @return The product between this color and the given value.
   */
  def *(f: Float): Color = this * (f, f, f, f)

  /**
   * Multiplies each component of this color with the given value and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param f The value to multiply this color by.
   * @return The product between this color and the given value.
   */
  def multiply(f: Float): Color = this * f

  /**
   * Divides each component of this color by the given values and returns the result.
   *
   * @param r The divisor of the red component in the `[0.0, 1.0]` range.
   * @param g The divisor of the green component in the `[0.0, 1.0]` range.
   * @param b The divisor of the blue component in the `[0.0, 1.0]` range.
   * @param a The divisor of the alpha component in the `[0.0, 1.0]` range.
   * @return The component-wise division between this color and the given values.
   */
  def /(r: Float, g: Float, b: Float, a: Float): Color = this * (1.0f / r, 1.0f / g, 1.0f / b, 1.0f / a)

  /**
   * Divides each component of this color by the given values and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param r The divisor of the red component in the `[0.0, 1.0]` range.
   * @param g The divisor of the green component in the `[0.0, 1.0]` range.
   * @param b The divisor of the blue component in the `[0.0, 1.0]` range.
   * @param a The divisor of the alpha component in the `[0.0, 1.0]` range.
   * @return The component-wise division between this color and the given values.
   */
  def divide(r: Float, g: Float, b: Float, a: Float): Color = this / (r, g, b, a)

  /**
   * Divides each component of this color by each component of the given one and returns the result.
   *
   * @param c The color to divide this one by.
   * @return The component-wise division between this color and the given one.
   */
  def /(c: Color): Color = this / (c.r, c.g, c.b, c.a)

  /**
   * Divides each component of this color by each component of the given one and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param c The color to divide this one by.
   * @return The component-wise division between this color and the given one.
   */
  def divide(c: Color): Color = this / c

  /**
   * Divides each component of this color by the given values and returns the result.
   *
   * @param r The divisor of the red component in the `[0.0, 1.0]` range.
   * @param g The divisor of the green component in the `[0.0, 1.0]` range.
   * @param b The divisor of the blue component in the `[0.0, 1.0]` range.
   * @return The component-wise division between this color and the given values.
   */
  def /(r: Float, g: Float, b: Float): Color = this * (1.0f / r, 1.0f / g, 1.0f / b)

  /**
   * Divides each component of this color by the given values and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param r The divisor of the red component in the `[0.0, 1.0]` range.
   * @param g The divisor of the green component in the `[0.0, 1.0]` range.
   * @param b The divisor of the blue component in the `[0.0, 1.0]` range.
   * @return The component-wise division between this color and the given values.
   */
  def divide(r: Float, g: Float, b: Float): Color = this / (r, g, b)

  /**
   * Blends this color and the given one and returns the result.
   *
   * @param c The color to blend this one with.
   * @return The color resulting from overlaying this color over the given one.
   */
  def blend(c: Color): Color

  /**
   * Returns this color with its `r`, `g`, and `b` components inverted.
   *
   * This is the equivalent of `(1 - r, 1 - b, 1 - g)`.
   *
   * @return The inverse of this color.
   */
  def inverted: Color

  /**
   * Makes this color darker by the given amount and returns the result.
   *
   * @param k The ratio from `0.0` to `1.0`.
   * @return A color resulting from making this color darker by the given amount.
   * @see [[lighter]]
   */
  def darker(k: Float): Color

  /**
   * Makes this color lighter by the given amount and returns the result.
   *
   * @param k The ratio from `0.0` to `1.0`.
   * @return A color resulting from making this color lighter by the given amount.
   * @see [[darker]]
   */
  def lighter(k: Float): Color

  /**
   * Computes the linear interpolation between this color and the given one by the given weight and returns the result.
   *
   * The given weight must be in the `[0.0, 1.0]` range, representing the amount of interpolation.
   *
   * @param to The color to interpolate to.
   * @param weight The weight of the interpolation between `0.0` and `1.0`.
   * @return The result of linearly interpolating between this color and the given one.
   */
  def lerp(to: Color, weight: Float): Color = (this * (1.0f - weight)) + (to * weight)

  /**
   * Returns the perceived brightness of this color using the RGB to Luma conversion formula.
   *
   * Colors with a luminance smaller than `0.5` can be generally considered dark.
   *
   * @return The luminance of this color.
   */
  def luminance: Float = 0.2126f * this.r + 0.7152f * this.g + 0.0722f * this.b

  /**
   * Checks if the components of this color are approximately equal to the given ones using an internal epsilon.
   *
   * @param r The red component of the color in the `[0.0, 1.0]` range.
   * @param g The green component of the color in the `[0.0, 1.0]` range.
   * @param b The blue component of the color in the `[0.0, 1.0]` range.
   * @return True if the components of this color are approximately equal to the given ones, otherwise false.
   * @see [[FloatEqualsApprox]]
   */
  def ~=(r: Float, g: Float, b: Float): Boolean = (this.r ~= r) && (this.g ~= g) && (this.b ~= b)

  /**
   * Checks if the components of this color are approximately equal to the given ones using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator for better interoperability with Java.
   *
   * @param r The red component of the color in the `[0.0, 1.0]` range.
   * @param g The green component of the color in the `[0.0, 1.0]` range.
   * @param b The blue component of the color in the `[0.0, 1.0]` range.
   * @return True if the components of this color are approximately equal to the given ones, otherwise false.
   * @see [[FloatEqualsApprox]]
   */
  def equalsApprox(r: Float, g: Float, b: Float): Boolean = this ~= (r, g, b)

  /**
   * Checks if the components of this color are approximately equal to the given ones using an internal epsilon.
   *
   * @param r The red component of the color in the `[0.0, 1.0]` range.
   * @param g The green component of the color in the `[0.0, 1.0]` range.
   * @param b The blue component of the color in the `[0.0, 1.0]` range.
   * @param a The alpha component of the color in the `[0.0, 1.0]` range.
   * @return True if the components of this color are approximately equal to the given ones, otherwise false.
   * @see [[FloatEqualsApprox]]
   */
  def ~=(r: Float, g: Float, b: Float, a: Float): Boolean = (this ~= (r, g, b)) && (this.a ~= a)

  /**
   * Checks if the components of this color are approximately equal to the given ones using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator for better interoperability with Java.
   *
   * @param r The red component of the color in the `[0.0, 1.0]` range.
   * @param g The green component of the color in the `[0.0, 1.0]` range.
   * @param b The blue component of the color in the `[0.0, 1.0]` range.
   * @param a The alpha component of the color in the `[0.0, 1.0]` range.
   * @return True if the components of this color are approximately equal to the given ones, otherwise false.
   * @see [[FloatEqualsApprox]]
   */
  def equalsApprox(r: Float, g: Float, b: Float, a: Float): Boolean = this ~= (r, g, b, a)

  /**
   * Checks if the components of this color are approximately equal to the components of the given one using an internal epsilon.
   *
   * @param c The second color.
   * @return True if the components of this color are approximately equal to the components of the given one, otherwise false.
   * @see [[FloatEqualsApprox]]
   */
  def ~=(c: Color): Boolean = this ~= (c.r, c.g, c.b, c.a)

  /**
   * Checks if the components of this color are approximately equal to the components of the given one using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator for better interoperability with Java.
   *
   * @param c The second color.
   * @return True if the components of this color are approximately equal to the components of the given one, otherwise false.
   * @see [[FloatEqualsApprox]]
   */
  def equalsApprox(c: Color): Boolean = this ~= c

  /**
   * Checks if the components of this color are equal to the given ones.
   *
   * @param r The red component of the color in the `[0, 255]` range.
   * @param g The green component of the color in the `[0, 255]` range.
   * @param b The blue component of the color in the `[0, 255]` range.
   * @return True if the components of this color are equal to the given ones, otherwise false.
   * @see [[r8]], [[g8]], [[b8]]
   */
  def ==(r: Int, g: Int, b: Int): Boolean = this.r8 == r && this.g8 == g && this.b8 == b

  /**
   * Checks if the components of this color are equal to the given ones.
   *
   * This method can be used in place of the `==` operator for better interoperability with Java.
   *
   * @param r The red component of the color in the `[0, 255]` range.
   * @param g The green component of the color in the `[0, 255]` range.
   * @param b The blue component of the color in the `[0, 255]` range.
   * @return True if the components of this color are equal to the given ones, otherwise false.
   * @see [[r8]], [[g8]], [[b8]]
   */
  def equals(r: Int, g: Int, b: Int): Boolean = this == (r, g, b)

  /**
   * Checks if the components of this color are equal to the given ones.
   *
   * @param r The red component of the color in the `[0, 255]` range.
   * @param g The green component of the color in the `[0, 255]` range.
   * @param b The blue component of the color in the `[0, 255]` range.
   * @param a The alpha component of the color in the `[0, 255]` range.
   * @return True if the components of this color are equal to the given ones, otherwise false.
   * @see [[r8]], [[g8]], [[b8]], [[a8]]
   */
  def ==(r: Int, g: Int, b: Int, a: Int): Boolean = this.r8 == r && this.g8 == g && this.b8 == b && this.a8 == a

  /**
   * Checks if the components of this color are equal to the given ones.
   *
   * This method can be used in place of the `==` operator for better interoperability with Java.
   *
   * @param r The red component of the color in the `[0, 255]` range.
   * @param g The green component of the color in the `[0, 255]` range.
   * @param b The blue component of the color in the `[0, 255]` range.
   * @param a The alpha component of the color in the `[0, 255]` range.
   * @return True if the components of this color are equal to the given ones, otherwise false.
   * @see [[r8]], [[g8]], [[b8]], [[a8]]
   */
  def equals(r: Int, g: Int, b: Int, a: Int): Boolean = this == (r, g, b, a)
}

/**
 * Implicits for colors.
 */
object Color {

  /**
   * Allows to use commutativity for the `*` operator.
   *
   * @param self The number to which the color is multiplied.
   */
  implicit class MultiplicationExtender(val self: Float) extends AnyVal {

    /**
     * Multiplies this value with the given color and returns the result.
     *
     * @param c The color to multiply this value by.
     * @return The product between this value and the given color.
     */
    def *(c: Color): Color = c * self
  }
}