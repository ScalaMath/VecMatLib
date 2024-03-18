package io.github.hexagonnico.vecmatlib.color

/**
 * A color represented in the RGBA format by a red, green, blue, and alpha component.
 *
 * Each component is a float in the range from `0.0` to `1.0`.
 * Values outside the range are still allowed.
 *
 * @constructor Constructs a color from the four given components.
 * @param r The red component of the color.
 * @param g The green component of the color.
 * @param b The blue component of the color.
 * @param a The alpha component of the color.
 */
case class Col4f(r: Float, g: Float, b: Float, a: Float) extends Color {

  /**
   * Constructs a color from the three given components and sets the alpha component to `1.0`.
   *
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   */
  def this(r: Float, g: Float, b: Float) = this(r, g, b, 1.0f)

  /**
   * Constructs a color from the four given components in the `[0, 255]` range.
   *
   * Values outside of the range are not clamped.
   *
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   * @param a The alpha component of the color.
   */
  def this(r: Int, g: Int, b: Int, a: Int) = this(r / 255.0f, g / 255.0f, b / 255.0f, a / 255.0f)

  /**
   * Constructs a color from the three given components in the `[0, 255]` range and sets the alpha component to `255`.
   *
   * Values outside of the range are not clamped.
   *
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   */
  def this(r: Int, g: Int, b: Int) = this(r, g, b, 255)

  /**
   * Adds the given values to each component of this color and returns the result.
   *
   * @param r The red component to add in the `[0.0, 1.0]` range.
   * @param g The green component to add in the `[0.0, 1.0]` range.
   * @param b The blue component to add in the `[0.0, 1.0]` range.
   * @param a The alpha component to add in the `[0.0, 1.0]` range.
   * @return The sum between this color and the given components.
   */
  override def +(r: Float, g: Float, b: Float, a: Float): Color = Col4f(this.r + r, this.g + g, this.b + b, this.a + a)

  /**
   * Subtracts the given values from each component of this color and returns the result.
   *
   * @param r The red component to subtract in the `[0.0, 1.0]` range.
   * @param g The green component to subtract in the `[0.0, 1.0]` range.
   * @param b The blue component to subtract in the `[0.0, 1.0]` range.
   * @param a The alpha component to subtract in the `[0.0, 1.0]` range.
   * @return The subtraction between this color and the given components.
   */
  override def -(r: Float, g: Float, b: Float, a: Float): Color = Col4f(this.r - r, this.g - g, this.b - b, this.a - a)

  /**
   * Multiplies each component of this color with the given values and returns the result.
   *
   * @param r The red component to multiply in the `[0.0, 1.0]` range.
   * @param g The green component to multiply in the `[0.0, 1.0]` range.
   * @param b The blue component to multiply in the `[0.0, 1.0]` range.
   * @param a The alpha component to multiply in the `[0.0, 1.0]` range.
   * @return The component-wise product between this color and the given values.
   */
  override def *(r: Float, g: Float, b: Float, a: Float): Color = Col4f(this.r * r, this.g * g, this.b * b, this.a * a)

  /**
   * Returns this color with its `r`, `g`, and `b` components inverted without affecting the alpha component.
   *
   * This is the equivalent of `(1 - r, 1 - b, 1 - g)`.
   *
   * @return The inverse of this color.
   */
  override def inverted: Color = Col4f(1.0f - this.r, 1.0f - this.g, 1.0f - this.b, this.a)

  /**
   * Makes this color darker by the given amount without affecting the alpha component and returns the result.
   *
   * @param k The ratio from `0.0` to `1.0`.
   * @return A color resulting from making this color darker by the given amount.
   * @see [[lighter]]
   */
  override def darker(k: Float): Color = Col4f(this.r * (1.0f - k), this.g * (1.0f - k), this.b * (1.0f - k), this.a)

  /**
   * Makes this color lighter by the given amount without affecting the alpha component and returns the result.
   *
   * @param k The ratio from `0.0` to `1.0`.
   * @return A color resulting from making this color lighter by the given amount.
   * @see [[darker]]
   */
  override def lighter(k: Float): Color = Col4f(this.r + (1.0f - this.r) * k, this.g + (1.0f - this.g) * k, this.b + (1.0f - this.b) * k, this.a)

  /**
   * Overlays this color and the given one including alpha and returns the result.
   *
   * @param c The color to blend this one with.
   * @return The color resulting from overlaying this color over the given one.
   */
  override def blend(c: Color): Color = {
    val sa = 1.0f - c.a
    val a = this.a * sa + c.a
    if(a == 0.0f) {
      Col4f(0.0f, 0.0f, 0.0f, 0.0f)
    } else {
      Col4f(
        (this.r * this.a * sa + c.r * c.a) / a,
        (this.g * this.a * sa + c.g * c.a) / a,
        (this.b * this.a * sa + c.b * c.a) / a, a
      )
    }
  }
}

/**
 * Factory methods for colors.
 */
object Col4f {

  /**
   * Constructs a color from the three given components and sets the alpha component to `1.0`.
   *
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   * @return A new color constructed from the three given components.
   */
  def apply(r: Float, g: Float, b: Float) = new Col4f(r, g, b)

  /**
   * Constructs a color from the four given components in the `[0, 255]` range.
   *
   * Values outside of the range are not clamped.
   *
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   * @param a The alpha component of the color.
   * @return A new color constructed from the four given components.
   */
  def apply(r: Int, g: Int, b: Int, a: Int) = new Col4f(r, g, b, a)

  /**
   * Constructs a color from the three given components in the `[0, 255]` range and sets the alpha component to `255`.
   *
   * Values outside of the range are not clamped.
   *
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   * @return A new color constructed from the three given components.
   */
  def apply(r: Int, g: Int, b: Int) = new Col4f(r, g, b)

  /**
   * Constructs a color from the given integer value in the RGBA format.
   *
   * @param value The color value in RGBA format.
   * @return A new color constructed from the given integer in the RGBA format.
   */
  def rgba(value: Int): Col4f = Col4f((value >> 24) & 0xff, (value >> 16) & 0xff, (value >> 8) & 0xff, value & 0xff)

  /**
   * Constructs a color from the given integer value in the ARGB format.
   *
   * @param value The color value in ARGB format.
   * @return A new color constructed from the given integer in the ARGB format.
   */
  def argb(value: Int): Col4f = Col4f((value >> 16) & 0xff, (value >> 8) & 0xff, value & 0xff, (value >> 24) & 0xff)

  /**
   * Constructs a color from the given components in the HSV format.
   *
   * @param h The hue of the color.
   * @param s The saturation of the color.
   * @param v The lightness (value) of the color.
   * @param a The alpha component of the color.
   * @return A new color constructed from the given components in the HSV format.
   */
  def hsv(h: Float, s: Float, v: Float, a: Float): Col4f = {
    val i = (h * 6.0f).floor
    val f = h * 6.0f - i
    val p = v * (1.0f - s)
    val q = v * (1.0f - f * s)
    val t = v * (1.0f - (1.0f - f) * s)
    i % 6 match {
      case 0 => Col4f(v, t, p, a)
      case 1 => Col4f(q, v, p, a)
      case 2 => Col4f(p, v, t, a)
      case 3 => Col4f(p, q, v, a)
      case 4 => Col4f(t, p, v, a)
      case 5 => Col4f(v, p, q, a)
    }
  }

  /**
   * Constructs a color from the given components in the HSV format and sets the alpha component to `1.0`.
   *
   * @param h The hue of the color.
   * @param s The saturation of the color.
   * @param v The lightness (value) of the color.
   * @return A new color constructed from the given components in the HSV format.
   */
  def hsv(h: Float, s: Float, v: Float): Col4f = this.hsv(h, s, v, 1.0f)
}