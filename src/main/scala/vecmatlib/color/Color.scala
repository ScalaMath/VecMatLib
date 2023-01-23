package vecmatlib.color

import vecmatlib.Float4

/**
 * Class that represents a color as a four-dimensional float vector whose components are in a range from 0.0 to 1.0.
 * Values outside the (0.0, 1.0) range are allowed.
 *
 * @constructor Constructs a color with the four given RGBA values
 * @param r Red component of the color in a range from 0.0 to 1.0
 * @param g Green component of the color in a range from 0.0 to 1.0
 * @param b Blue component of the color in a range from 0.0 to 1.0
 * @param a Red component of the color in a range from 0.0 to 1.0
 */
case class Color(r: Float, g: Float, b: Float, a: Float) extends Float4 {

  /**
   * Constructs a color with the three given RGB values and an alpha value of 1.0
   *
   * @param r Red component of the color in a range from 0.0 to 1.0
   * @param g Green component of the color in a range from 0.0 to 1.0
   * @param b Blue component of the color in a range from 0.0 to 1.0
   */
  def this(r: Float, g: Float, b: Float) = this(r, g, b, 1.0f)

  /**
   * Returns a new color resulting from adding the given color to this one.
   *
   * @param r Red component of the color to add
   * @param g Green component of the color to add
   * @param b Blue component of the color to add
   * @param a Alpha component of the color to add
   * @return A color resulting from adding the given color to this one
   */
  def +(r: Float, g: Float, b: Float, a: Float): Color = Color(this.r + r, this.g + g, this.b + b, this.a + a)

  /**
   * Returns a new color resulting from adding the given color to this one.
   *
   * @param r Red component of the color to add
   * @param g Green component of the color to add
   * @param b Blue component of the color to add
   * @return A color resulting from adding the given color to this one
   */
  def +(r: Float, g: Float, b: Float): Color = this + (r, g, b, 0.0f)

  /**
   * Returns a new color resulting from adding the given color to this one.
   *
   * @param c The color to add
   * @return A color resulting from adding the given color to this one
   */
  def +(c: Color): Color = this + (c.r, c.g, c.b, c.a)

  /**
   * Returns a new color resulting from adding the given color to this one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param r Red component of the color to add
   * @param g Green component of the color to add
   * @param b Blue component of the color to add
   * @param a Alpha component of the color to add
   * @return A color resulting from adding the given color to this one
   */
  def add(r: Float, g: Float, b: Float, a: Float): Color = this + (r, g, b, a)

  /**
   * Returns a new color resulting from adding the given color to this one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param r Red component of the color to add
   * @param g Green component of the color to add
   * @param b Blue component of the color to add
   * @return A color resulting from adding the given color to this one
   */
  def add(r: Float, g: Float, b: Float): Color = this.add(r, g, b, 0.0f)

  /**
   * Returns a new color resulting from adding the given color to this one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param c The color to add
   * @return A color resulting from adding the given color to this one
   */
  def add(c: Color): Color = this + c

  /**
   * Returns a new color resulting from subtracting the given color from this one.
   *
   * @param r Red component of the color to subtract
   * @param g Green component of the color to subtract
   * @param b Blue component of the color to subtract
   * @param a Alpha component of the color to subtract
   * @return A color resulting from subtracting the given color from this one
   */
  def -(r: Float, g: Float, b: Float, a: Float): Color = Color(this.r - r, this.g - g, this.b - b, this.a - a)

  /**
   * Returns a new color resulting from subtracting the given color from this one.
   *
   * @param r Red component of the color to subtract
   * @param g Green component of the color to subtract
   * @param b Blue component of the color to subtract
   * @return A color resulting from subtracting the given color from this one
   */
  def -(r: Float, g: Float, b: Float): Color = this - (r, g, b, 0.0f)

  /**
   * Returns a new color resulting from subtracting the given color from this one.
   *
   * @param c The color to subtract
   * @return A color resulting from subtracting the given color from this one
   */
  def -(c: Color): Color = this - (c.r, c.g, c.b, c.a)

  /**
   * Returns a new color resulting from subtracting the given color from this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param r Red component of the color to subtract
   * @param g Green component of the color to subtract
   * @param b Blue component of the color to subtract
   * @param a Alpha component of the color to subtract
   * @return A color resulting from subtracting the given color from this one
   */
  def subtract(r: Float, g: Float, b: Float, a: Float): Color = this - (r, g, b, a)

  /**
   * Returns a new color resulting from subtracting the given color from this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param r Red component of the color to subtract
   * @param g Green component of the color to subtract
   * @param b Blue component of the color to subtract
   * @return A color resulting from subtracting the given color from this one
   */
  def subtract(r: Float, g: Float, b: Float): Color = this.subtract(r, g, b, 0.0f)

  /**
   * Returns a new color resulting from subtracting the given color from this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param c The color to subtract
   * @return A color resulting from subtracting the given color from this one
   */
  def subtract(c: Color): Color = this - c

  /**
   * Returns a new color resulting from multiplying every component of this color with the given ones.
   *
   * @param r Red component of the color
   * @param g Green component of the color
   * @param b Blue component of the color
   * @param a Alpha component of the color
   * @return A color resulting from multiplying every component of this color with the given ones
   */
  def *(r: Float, g: Float, b: Float, a: Float): Color = Color(this.r * r, this.g * g, this.b * b, this.a * a)

  /**
   * Returns a new color resulting from multiplying every component of this color with the given ones.
   *
   * @param r Red component of the color
   * @param g Green component of the color
   * @param b Blue component of the color
   * @return A color resulting from multiplying every component of this color with the given ones
   */
  def *(r: Float, g: Float, b: Float): Color = this * (r, g, b, 1.0f)

  /**
   * Returns a new color resulting from the component-wise multiplication of this color with the given one.
   *
   * @param c The given color
   * @return A color resulting from the component-wise multiplication of this color with the given one
   */
  def *(c: Color): Color = this * (c.r, c.g, c.b, c.a)

  /**
   * Returns a new color resulting from multiplying every component of this color with the given ones.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param r Red component of the color
   * @param g Green component of the color
   * @param b Blue component of the color
   * @param a Alpha component of the color
   * @return A color resulting from multiplying every component of this color with the given ones
   */
  def blend(r: Float, g: Float, b: Float, a: Float): Color = this * (r, g, b, a)

  /**
   * Returns a new color resulting from multiplying every component of this color with the given ones.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param r Red component of the color
   * @param g Green component of the color
   * @param b Blue component of the color
   * @return A color resulting from multiplying every component of this color with the given ones
   */
  def blend(r: Float, g: Float, b: Float): Color = this.blend(r, g, b, 1.0f)

  /**
   * Returns a new color resulting from the component-wise multiplication of this color with the given one.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param c The given color
   * @return A color resulting from the component-wise multiplication of this color with the given one
   */
  def blend(c: Color): Color = this * c

  /**
   * Returns a new color resulting from multiplying all the components by the given scalar.
   *
   * @param k The scalar by which this color is multiplied
   * @return
   */
  def *(k: Float): Color = this * (k, k, k, k)

  /**
   * Returns a new color resulting from multiplying all the components by the given scalar.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param k The scalar by which this color is multiplied
   * @return
   */
  def multiply(k: Float): Color = this * k

  /**
   * Returns the inverted color `(1.0 - r, 1.0 - g, 1.0 - b, a)`.
   *
   * @return The inverted color.
   */
  def invert: Color = Color(1.0f - this.r, 1.0f - this.g, 1.0f - this.b, this.a)

  /**
   * Returns a new color resulting from making this color darker by the specified percentage.
   *
   * @param k Ratio from 0.0 to 1.0
   * @return A color resulting from making this color darker by the specified percentage
   */
  def darker(k: Float): Color = Color(this.r * (1.0f - k), this.g * (1.0f - k), this.b * (1.0f - k), this.a)

  /**
   * Returns a new color resulting from making this color lighter by the specified percentage.
   *
   * @param k Ratio from 0.0 to 1.0
   * @return A color resulting from making this color lighter by the specified percentage
   */
  def lighter(k: Float): Color = Color(this.r + (1.0f - this.r) * k, this.g + (1.0f - this.g) * k, this.b + (1.0f - this.b) * k, this.a)

  /**
   * Returns the linear interpolation with another color.
   *
   * @param to The color to interpolate to
   * @param weight Interpolation factor between 0.0 and 1.0
   * @return The linear interpolation between this color and the given one
   */
  def lerp(to: Color, weight: Float): Color = (this * (1.0f - weight)) + (to * weight)

  /**
   * Alias for 'r'.
   *
   * @return The red component of this color
   */
  override def x: Float = this.r

  /**
   * Alias for 'g'.
   *
   * @return The green component of this color
   */
  override def y: Float = this.g

  /**
   * Alias for 'b'.
   *
   * @return The blue component of this color
   */
  override def z: Float = this.b

  /**
   * Alias for 'a'.
   *
   * @return The alpha component of this color
   */
  override def w: Float = this.a
}

/**
 * Color companion object.
 */
object Color {

  /**
   * Constructs a color with the three given RGB values and an alpha value of 1.0.
   *
   * @param r Red component of the color in a range from 0.0 to 1.0
   * @param g Green component of the color in a range from 0.0 to 1.0
   * @param b Blue component of the color in a range from 0.0 to 1.0
   * @return A color with the three given RGB values and an alpha value of 1.0
   */
  def apply(r: Float, g: Float, b: Float): Color = this.apply(r, g, b, 1.0f)
}