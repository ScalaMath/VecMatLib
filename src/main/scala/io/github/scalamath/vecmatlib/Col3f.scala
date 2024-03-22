package io.github.scalamath.vecmatlib

/**
 * A color represented in the RGB format by a red, green, and blue component.
 *
 * Each component is a float in the range from `0.0` to `1.0`.
 * Values outside the range are still allowed.
 *
 * @constructor Constructs a color from the three given components.
 * @param r The red component of the color.
 * @param g The green component of the color.
 * @param b The blue component of the color.
 */
case class Col3f(r: Float, g: Float, b: Float) extends Color {

  /**
   * Constructs a color from the three given components in the `[0, 255]` range.
   *
   * Values outside of the range are not clamped.
   *
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   */
  def this(r: Int, g: Int, b: Int) = this(r / 255.0f, g / 255.0f, b / 255.0f)

  /**
   * Constructs a color from the given integer in the RGB format.
   *
   * @param rgb The color value in the RGB format.
   */
  def this(rgb: Int) = this((rgb >> 16) & 0xff, (rgb >> 8) & 0xff, rgb & 0xff)

  /**
   * The alpha component of this color.
   * Always returns `1.0`.
   *
   *  @return Returns `1.0`.
   */
  override def a: Float = 1.0f

  /**
   * Adds the given values to each component of this color and returns the result.
   *
   * The result of this operation will be a [[Col4f]].
   *
   * @param r The red component to add in the `[0.0, 1.0]` range.
   * @param g The green component to add in the `[0.0, 1.0]` range.
   * @param b The blue component to add in the `[0.0, 1.0]` range.
   * @param a The alpha component to add in the `[0.0, 1.0]` range.
   * @return The sum between this color and the given components.
   */
  override def +(r: Float, g: Float, b: Float, a: Float): Color = Col4f(this.r + r, this.g + g, this.b + b, this.a + a)

  /**
   * Adds the given values to each component of this color and returns the result.
   *
   * The result of this operation will be a [[Col3f]].
   *
   * @param r The red component to add in the `[0.0, 1.0]` range.
   * @param g The green component to add in the `[0.0, 1.0]` range.
   * @param b The blue component to add in the `[0.0, 1.0]` range.
   * @return The sum between this color and the given components.
   */
  override def +(r: Float, g: Float, b: Float): Color = Col3f(this.r + r, this.g + g, this.b + b)

  /**
   * Adds each component of this color with the components of the given color and returns the result.
   *
   * The result of this operation will be a [[Col3f]] if the given value is a [[Col3f]], otherwise it will be a [[Col4f]].
   *
   * @param c The color to add.
   * @return The sum between this color and the given one.
   */
  override def +(c: Color): Color = if(c.isInstanceOf[Col3f]) this + (c.r, c.g, c.b) else this + (c.r, c.g, c.b, c.a)

  /**
   * Subtracts the given values from each component of this color and returns the result.
   *
   * The result of this operation will be a [[Col4f]].
   *
   * @param r The red component to subtract in the `[0.0, 1.0]` range.
   * @param g The green component to subtract in the `[0.0, 1.0]` range.
   * @param b The blue component to subtract in the `[0.0, 1.0]` range.
   * @param a The alpha component to subtract in the `[0.0, 1.0]` range.
   * @return The subtraction between this color and the given components.
   */
  override def -(r: Float, g: Float, b: Float, a: Float): Color = Col4f(this.r - r, this.g - g, this.b - b, this.a - a)

  /**
   * Subtracts the given values from each component of this color and returns the result.
   *
   * The result of this operation will be a [[Col3f]].
   *
   * @param r The red component to subtract in the `[0.0, 1.0]` range.
   * @param g The green component to subtract in the `[0.0, 1.0]` range.
   * @param b The blue component to subtract in the `[0.0, 1.0]` range.
   * @return The subtraction between this color and the given components.
   */
  override def -(r: Float, g: Float, b: Float): Color = Col3f(this.r - r, this.g - g, this.b - b)

  /**
   * Subtracts each component of the given color from the components of this color and returns the result.
   *
   * The result of this operation will be a [[Col3f]] if the given value is a [[Col3f]], otherwise it will be a [[Col4f]].
   *
   * @param c The color to subtract.
   * @return The subtraction between this color and the given one.
   */
  override def -(c: Color): Color = if(c.isInstanceOf[Col3f]) this - (c.r, c.g, c.b) else this - (c.r, c.g, c.b, c.a)

  /**
   * Multiplies each component of this color with the given values and returns the result.
   *
   * The result of this operation will be a [[Col4f]].
   *
   * @param r The red component to multiply in the `[0.0, 1.0]` range.
   * @param g The green component to multiply in the `[0.0, 1.0]` range.
   * @param b The blue component to multiply in the `[0.0, 1.0]` range.
   * @param a The alpha component to multiply in the `[0.0, 1.0]` range.
   * @return The component-wise product between this color and the given values.
   */
  override def *(r: Float, g: Float, b: Float, a: Float): Color = Col4f(this.r * r, this.g * g, this.b * b, a)

  /**
   * Multiplies each component of this color with the given values and returns the result.
   *
   * The result of this operation will be a [[Col3f]].
   *
   * @param r The red component to multiply in the `[0.0, 1.0]` range.
   * @param g The green component to multiply in the `[0.0, 1.0]` range.
   * @param b The blue component to multiply in the `[0.0, 1.0]` range.
   * @return The component-wise product between this color and the given values.
   */
  override def *(r: Float, g: Float, b: Float): Color = Col3f(this.r * r, this.g * g, this.b * b)

  /**
   * Multiplies each component of this color with each component of the given one and returns the result.
   *
   * The result of this operation will be a [[Col3f]] if the given value is a [[Col3f]], otherwise it will be a [[Col4f]].
   *
   * @param c The color to multiply this one by.
   * @return The component-wise product between this color and the given one.
   */
  override def *(c: Color): Color = if(c.isInstanceOf[Col3f]) this * (c.r, c.g, c.b) else this * (c.r, c.g, c.b, c.a)

  /**
   * Divides each component of this color by each component of the given one and returns the result.
   *
   * The result of this operation will be a [[Col3f]] if the given value is a [[Col3f]], otherwise it will be a [[Col4f]].
   *
   * @param c The color to divide this one by.
   * @return The component-wise division between this color and the given one.
   */
  override def /(c: Color): Color = if(c.isInstanceOf[Col3f]) this / (c.r, c.g, c.b) else this / (c.r, c.g, c.b, c.a)

  /**
   * Returns this color with its `r`, `g`, and `b` components inverted.
   *
   * This is the equivalent of `(1 - r, 1 - b, 1 - g)`.
   *
   * @return The inverse of this color.
   */
  override def inverted: Color = Col3f(1.0f - this.r, 1.0f - this.g, 1.0f - this.b)

  /**
   * Makes this color darker by the given amount and returns the result.
   *
   * @param k The ratio from `0.0` to `1.0`.
   * @return A color resulting from making this color darker by the given amount.
   * @see [[lighter]]
   */
  override def darker(k: Float): Color = this * (1.0f - k)

  /**
   * Makes this color lighter by the given amount and returns the result.
   *
   * @param k The ratio from `0.0` to `1.0`.
   * @return A color resulting from making this color lighter by the given amount.
   * @see [[darker]]
   */
  override def lighter(k: Float): Color = Col3f(this.r + (1.0f - this.r) * k, this.g + (1.0f - this.g) * k, this.b + (1.0f - this.b) * k)

  /**
   * Blends this color and the given one and returns the result.
   *
   * This is the equivalent of multiplying the colors together if the given color is a [[Col3f]].
   *
   * @param c The color to blend this one with.
   * @return The color resulting from overlaying this color over the given one.
   */
  override def blend(c: Color): Color = {
    if(c.isInstanceOf[Col3f]) {
      this * c
    } else {
      val sa = 1.0f - c.a
      Col4f(this.r * sa + c.r * c.a, this.g * sa + c.g * c.a, this.b * sa + c.b * c.a)
    }
  }
}

/**
 * Factory methods for colors.
 */
object Col3f {

  /**
   * Constructs a color from the three given components in the `[0, 255]` range.
   *
   * Values outside of the range are not clamped.
   *
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   * @return A new color constructed from the three given components.
   */
  def apply(r: Int, g: Int, b: Int) = new Col3f(r, g, b)

  /**
   * Constructs a color from the given integer in the RGB format.
   *
   * @param rgb The color value in the RGB format.
   * @return A new color constructed from the given integer in the RGB format.
   */
  def apply(rgb: Int) = new Col3f(rgb)

  /**
   * Constructs a color from the given components in the HSV format.
   *
   * @param h The hue of the color.
   * @param s The saturation of the color.
   * @param v The lightness (value) of the color.
   * @return A new color constructed from the given components in the HSV format.
   */
  def hsv(h: Float, s: Float, v: Float): Col3f = {
    val i = (h * 6.0f).floor
    val f = h * 6.0f - i
    val p = v * (1.0f - s)
    val q = v * (1.0f - f * s)
    val t = v * (1.0f - (1.0f - f) * s)
    i % 6 match {
      case 0 => Col3f(v, t, p)
      case 1 => Col3f(q, v, p)
      case 2 => Col3f(p, v, t)
      case 3 => Col3f(p, q, v)
      case 4 => Col3f(t, p, v)
      case 5 => Col3f(v, p, q)
    }
  }
}