package io.github.scalamath.vecmatlib

import io.github.scalamath.clamp

/**
 * A color represented by a single integer in the RGBA format.
 *
 * This representation only requires 4 bytes, whereas [[Col4f]] requires 16, but does not allow values outside of the `[0, 255]` range.
 *
 * @constructor Constructs a color from the given integer value in the RGBA format.
 * @param rgba The integer value of this color in the RGBA format.
 */
case class Col1i(override val rgba: Int) extends Color {

  /**
   * Constructs a color from the four given components in the `[0, 255]` range.
   *
   * Values outside of the range are clamped.
   *
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   * @param a The alpha component of the color.
   */
  def this(r: Int, g: Int, b: Int, a: Int) = this((clamp(r, 0, 255) << 24) | (clamp(g, 0, 255) << 16) | (clamp(b, 0, 255) << 8) | clamp(a, 0, 255))

  /**
   * Constructs a color from the three given components in the `[0, 255]` range and sets the alpha component to `255`.
   *
   * Values outside of the range are clamped.
   *
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   */
  def this(r: Int, g: Int, b: Int) = this(r, g, b, 255)

  /**
   * Constructs a color from the four given components in the `[0.0, 1.0] range`.
   *
   * Values outside of the range are clamped.
   *
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   * @param a The alpha component of the color.
   */
  def this(r: Float, g: Float, b: Float, a: Float) = this((clamp(r, 0.0f, 1.0f) * 255.0f).round, (clamp(g, 0.0f, 1.0f) * 255.0f).round, (clamp(b, 0.0f, 1.0f) * 255.0f).round, (clamp(a, 0.0f, 1.0f) * 255.0f).round)

  /**
   * Constructs a color from the three given components and sets the alpha component to `1.0`.
   *
   * Values outside of the range are clamped.
   *
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   */
  def this(r: Float, g: Float, b: Float) = this(r, g, b, 1.0f)

  /**
   * Returns the red component of this color as an integer in the `[0, 255]` range.
   *
   * @return The red component of this color as an integer in the `[0, 255]` range.
   */
  override def r8: Int = (this.rgba >> 24) & 0xff

  /**
   * Returns the red component of this color as a float in the `[0.0, 1.0]` range.
   *
   * @return Returns the red component of this color as a float in the `[0.0, 1.0]` range.
   */
  override def r: Float = this.r8 / 255.0f

  /**
   * Returns the green component of this color as an integer in the `[0, 255]` range.
   *
   * @return The green component of this color as an integer in the `[0, 255]` range.
   */
  override def g8: Int = (this.rgba >> 16) & 0xff

  /**
   * Returns the green component of this color as a float in the `[0.0, 1.0]` range.
   *
   * @return Returns the green component of this color as a float in the `[0.0, 1.0]` range.
   */
  override def g: Float = this.g8 / 255.0f

  /**
   * Returns the blue component of this color as an integer in the `[0, 255]` range.
   *
   * @return The blue component of this color as an integer in the `[0, 255]` range.
   */
  override def b8: Int = (this.rgba >>  8) & 0xff

  /**
   * Returns the blue component of this color as a float in the `[0.0, 1.0]` range.
   *
   * @return Returns the blue component of this color as a float in the `[0.0, 1.0]` range.
   */
  override def b: Float = this.b8 / 255.0f

  /**
   * Returns the alpha component of this color as an integer in the `[0, 255]` range.
   *
   * A value of 0 means that the color is fully transparent. A value of 255 means that the color is fully opaque.
   *
   * @return The alpha component of this color as an integer in the `[0, 255]` range.
   */
  override def a8: Int = this.rgba & 0xff

  /**
   * Returns the alpha component of this color as a float in the `[0.0, 1.0]` range.
   *
   * A value of 0 means that the color is fully transparent. A value of 1 means that the color is fully opaque.
   *
   * @return Returns the alpha component of this color as a float in the `[0.0, 1.0]` range.
   */
  override def a: Float = this.a8 / 255.0f

  /**
   * Adds the given values to each component of this color and returns the result.
   *
   * The result is clamped.
   *
   * @param r The red component to add in the `[0.0, 1.0]` range.
   * @param g The green component to add in the `[0.0, 1.0]` range.
   * @param b The blue component to add in the `[0.0, 1.0]` range.
   * @param a The alpha component to add in the `[0.0, 1.0]` range.
   * @return The sum between this color and the given components.
   */
  override def +(r: Float, g: Float, b: Float, a: Float): Color = this + ((r * 255.0f).round, (g * 255.0f).round, (b * 255.0f).round, (a * 255.0f).round)

  /**
   * Adds the given values to each component of this color and returns the result.
   *
   * The result is clamped.
   *
   * @param r The red component to add in the `[0, 255]` range.
   * @param g The green component to add in the `[0, 255]` range.
   * @param b The blue component to add in the `[0, 255]` range.
   * @param a The alpha component to add in the `[0, 255]` range.
   * @return The sum between this color and the given components.
   */
  override def +(r: Int, g: Int, b: Int, a: Int): Color = Col1i(this.r8 + r, this.g8 + g, this.b8 + b, this.a8 + a)

  /**
   * Subtracts the given values from each component of this color and returns the result.
   *
   * The result is clamped.
   *
   * @param r The red component to subtract in the `[0.0, 1.0]` range.
   * @param g The green component to subtract in the `[0.0, 1.0]` range.
   * @param b The blue component to subtract in the `[0.0, 1.0]` range.
   * @param a The alpha component to subtract in the `[0.0, 1.0]` range.
   * @return The subtraction between this color and the given components.
   */
  override def -(r: Float, g: Float, b: Float, a: Float): Color = this - ((r * 255.0f).round, (g * 255.0f).round, (b * 255.0f).round, (a * 255.0f).round)

  /**
   * Subtracts the given values from each component of this color and returns the result.
   *
   * The result is clamped.
   *
   * @param r The red component to subtract in the `[0, 255]` range.
   * @param g The green component to subtract in the `[0, 255]` range.
   * @param b The blue component to subtract in the `[0, 255]` range.
   * @param a The alpha component to subtract in the `[0, 255]` range.
   * @return The subtraction between this color and the given components.
   */
  override def -(r: Int, g: Int, b: Int, a: Int): Color = Col1i(this.r8 - r, this.g8 - g, this.b8 - b, this.a8 - a)

  /**
   * Multiplies each component of this color with the given values and returns the result.
   *
   * The result is clamped.
   *
   * @param r The red component to multiply in the `[0.0, 1.0]` range.
   * @param g The green component to multiply in the `[0.0, 1.0]` range.
   * @param b The blue component to multiply in the `[0.0, 1.0]` range.
   * @param a The alpha component to multiply in the `[0.0, 1.0]` range.
   * @return The component-wise product between this color and the given values.
   */
  override def *(r: Float, g: Float, b: Float, a: Float): Color = Col1i((this.r8 * r).round, (this.g8 * g).round, (this.b8 * b).round, (this.a8 * a).round)

  /**
   * Returns this color with its `r`, `g`, and `b` components inverted.
   *
   * This is the equivalent of `(255 - r, 255 - b, 255 - g)`.
   *
   * @return The inverse of this color.
   */
  override def inverted: Color = Col1i(255 - this.r8, 255 - this.g8, 255 - this.b8, this.a8)

  /**
   * Makes this color darker by the given amount and returns the result.
   *
   * @param k The ratio from `0.0` to `1.0`.
   * @return A color resulting from making this color darker by the given amount.
   * @see [[lighter]]
   */
  override def darker(k: Float): Color = Col1i(this.r * (1.0f - k), this.g * (1.0f - k), this.b * (1.0f - k), this.a)

  /**
   * Makes this color lighter by the given amount and returns the result.
   *
   * @param k The ratio from `0.0` to `1.0`.
   * @return A color resulting from making this color lighter by the given amount.
   * @see [[darker]]
   */
  override def lighter(k: Float): Color = Col1i(this.r + (1.0f - this.r) * k, this.g + (1.0f - this.g) * k, this.b + (1.0f - this.b) * k, this.a)

  /**
   * Blends this color and the given one and returns the result.
   *
   * @param c The color to blend this one with.
   * @return The color resulting from overlaying this color over the given one.
   */
  override def blend(c: Color): Color = {
    val sa = 1.0f - c.a
    val a = this.a * sa + c.a
    if(a == 0.0f) {
      Col1i(0)
    } else {
      Col1i(
        (this.r * this.a * sa + c.r * c.a) / a,
        (this.g * this.a * sa + c.g * c.a) / a,
        (this.b * this.a * sa + c.b * c.a) / a, a
      )
    }
  }

  override def toString: String = s"Col1i(${this.rgba.toHexString})"
}

/**
 * Factory methods for colors.
 */
object Col1i {

  /**
   * Constructs a color from the four given components in the `[0, 255]` range.
   *
   * Values outside of the range are clamped.
   *
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   * @param a The alpha component of the color.
   * @return A new color constructed from the four given components.
   */
  def apply(r: Int, g: Int, b: Int, a: Int) = new Col1i(r, g, b, a)

  /**
   * Constructs a color from the three given components in the `[0, 255]` range and sets the alpha component to `255`.
   *
   * Values outside of the range are clamped.
   *
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   * @return A new color constructed from the three given components.
   */
  def apply(r: Int, g: Int, b: Int) = new Col1i(r, g, b)

  /**
   * Constructs a color from the three given components in the `[0.0, 1.0]` range.
   *
   * Values outside of the range are clamped.
   *
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   * @return A new color constructed from the three given components.
   */
  def apply(r: Float, g: Float, b: Float, a: Float) = new Col1i(r, g, b, a)

  /**
   * Constructs a color from the three given components and sets the alpha component to `1.0`.
   *
   * Values outside of the range are clamped.
   *
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   * @return A new color constructed from the three given components.
   */
  def apply(r: Float, g: Float, b: Float) = new Col1i(r, g, b)
}