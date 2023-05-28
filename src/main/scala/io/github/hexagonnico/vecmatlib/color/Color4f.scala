package io.github.hexagonnico.vecmatlib.color

import io.github.hexagonnico.vecmatlib.Float4

/**
 * Class that represents a color as a four-dimensional float tuple whose components are in a range from 0.0 to 1.0.
 * Values outside the (0.0, 1.0) range are allowed.
 *
 * @constructor Constructs a color with the four given RGBA values
 * @param r Red component of the color in a range from 0.0 to 1.0
 * @param g Green component of the color in a range from 0.0 to 1.0
 * @param b Blue component of the color in a range from 0.0 to 1.0
 * @param a Alpha component of the color in a range from 0.0 to 1.0
 */
case class Color4f(r: Float, g: Float, b: Float, a: Float) extends Float4 {

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
  def +(r: Float, g: Float, b: Float, a: Float): Color4f = Color4f(this.r + r, this.g + g, this.b + b, this.a + a)

  /**
   * Returns a new color resulting from adding the given color to this one.
   *
   * @param r Red component of the color to add
   * @param g Green component of the color to add
   * @param b Blue component of the color to add
   * @return A color resulting from adding the given color to this one
   */
  def +(r: Float, g: Float, b: Float): Color4f = this + (r, g, b, 0.0f)

  /**
   * Returns a new color resulting from adding the given color to this one.
   *
   * @param c The color to add
   * @return A color resulting from adding the given color to this one
   */
  def +(c: Color4f): Color4f = this + (c.r, c.g, c.b, c.a)

  /**
   * Returns a new color resulting from adding the given color to this one.
   * Leaves the alpha value untouched.
   *
   * @param c The color to add
   * @return A color resulting from adding the given color to this one
   */
  def +(c: Color3f): Color4f = this + (c.r, c.g, c.b, 0.0f)

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
  def add(r: Float, g: Float, b: Float, a: Float): Color4f = this + (r, g, b, a)

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
  def add(r: Float, g: Float, b: Float): Color4f = this.add(r, g, b, 0.0f)

  /**
   * Returns a new color resulting from adding the given color to this one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param c The color to add
   * @return A color resulting from adding the given color to this one
   */
  def add(c: Color4f): Color4f = this + c

  /**
   * Returns a new color resulting from adding the given color to this one.
   * Leaves the alpha value untouched.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param c The color to add
   * @return A color resulting from adding the given color to this one
   */
  def add(c: Color3f): Color4f = this + c

  /**
   * Returns a new color resulting from subtracting the given color from this one.
   *
   * @param r Red component of the color to subtract
   * @param g Green component of the color to subtract
   * @param b Blue component of the color to subtract
   * @param a Alpha component of the color to subtract
   * @return A color resulting from subtracting the given color from this one
   */
  def -(r: Float, g: Float, b: Float, a: Float): Color4f = Color4f(this.r - r, this.g - g, this.b - b, this.a - a)

  /**
   * Returns a new color resulting from subtracting the given color from this one.
   *
   * @param r Red component of the color to subtract
   * @param g Green component of the color to subtract
   * @param b Blue component of the color to subtract
   * @return A color resulting from subtracting the given color from this one
   */
  def -(r: Float, g: Float, b: Float): Color4f = this - (r, g, b, 0.0f)

  /**
   * Returns a new color resulting from subtracting the given color from this one.
   *
   * @param c The color to subtract
   * @return A color resulting from subtracting the given color from this one
   */
  def -(c: Color4f): Color4f = this - (c.r, c.g, c.b, c.a)

  /**
   * Returns a new color resulting from subtracting the given color from this one.
   * Leaves the alpha value untouched.
   *
   * @param c The color to subtract
   * @return A color resulting from subtracting the given color from this one
   */
  def -(c: Color3f): Color4f = this - (c.r, c.g, c.b)

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
  def subtract(r: Float, g: Float, b: Float, a: Float): Color4f = this - (r, g, b, a)

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
  def subtract(r: Float, g: Float, b: Float): Color4f = this.subtract(r, g, b, 0.0f)

  /**
   * Returns a new color resulting from subtracting the given color from this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param c The color to subtract
   * @return A color resulting from subtracting the given color from this one
   */
  def subtract(c: Color4f): Color4f = this - c

  /**
   * Returns a new color resulting from subtracting the given color from this one.
   * Leaves the alpha value untouched.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param c The color to subtract
   * @return A color resulting from subtracting the given color from this one
   */
  def subtract(c: Color3f): Color4f = this - c

  /**
   * Returns a new color resulting from multiplying every component of this color with the given ones.
   *
   * @param r Red component of the color
   * @param g Green component of the color
   * @param b Blue component of the color
   * @param a Alpha component of the color
   * @return A color resulting from multiplying every component of this color with the given ones
   */
  def *(r: Float, g: Float, b: Float, a: Float): Color4f = Color4f(this.r * r, this.g * g, this.b * b, this.a * a)

  /**
   * Returns a new color resulting from multiplying every component of this color with the given ones.
   *
   * @param r Red component of the color
   * @param g Green component of the color
   * @param b Blue component of the color
   * @return A color resulting from multiplying every component of this color with the given ones
   */
  def *(r: Float, g: Float, b: Float): Color4f = this * (r, g, b, 1.0f)

  /**
   * Returns a new color resulting from the component-wise multiplication of this color with the given one.
   *
   * @param c The given color
   * @return A color resulting from the component-wise multiplication of this color with the given one
   */
  def *(c: Color4f): Color4f = this * (c.r, c.g, c.b, c.a)

  /**
   * Returns a new color resulting from the component-wise multiplication of this color with the given one.
   * Leaves the alpha value untouched.
   *
   * @param c The given color
   * @return A color resulting from the component-wise multiplication of this color with the given one
   */
  def *(c: Color3f): Color4f = this * (c.r, c.g, c.b)

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
  def blend(r: Float, g: Float, b: Float, a: Float): Color4f = this * (r, g, b, a)

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
  def blend(r: Float, g: Float, b: Float): Color4f = this.blend(r, g, b, 1.0f)

  /**
   * Returns a new color resulting from the component-wise multiplication of this color with the given one.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param c The given color
   * @return A color resulting from the component-wise multiplication of this color with the given one
   */
  def blend(c: Color4f): Color4f = this * c

  /**
   * Returns a new color resulting from the component-wise multiplication of this color with the given one.
   * Leaves the alpha value untouched.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param c The given color
   * @return A color resulting from the component-wise multiplication of this color with the given one
   */
  def blend(c: Color3f): Color4f = this * c

  /**
   * Returns a new color resulting from multiplying all the components by the given scalar.
   *
   * @param k The scalar by which this color is multiplied
   * @return A new color resulting of multiplying all the components of this color by the given scalar
   */
  def *(k: Float): Color4f = this * (k, k, k, k)

  /**
   * Returns a new color resulting from multiplying all the components by the given scalar.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param k The scalar by which this color is multiplied
   * @return A new color resulting of multiplying all the components of this color by the given scalar
   */
  def multiply(k: Float): Color4f = this * k

  /**
   * Returns the inverted color `(1.0 - r, 1.0 - g, 1.0 - b, a)`.
   *
   * @return The inverted color.
   */
  def invert: Color4f = Color4f(1.0f - this.r, 1.0f - this.g, 1.0f - this.b, this.a)

  /**
   * Returns a new color resulting from making this color darker by the specified percentage.
   *
   * @param k Ratio from 0.0 to 1.0
   * @return A color resulting from making this color darker by the specified percentage
   */
  def darker(k: Float): Color4f = Color4f(this.r * (1.0f - k), this.g * (1.0f - k), this.b * (1.0f - k), this.a)

  /**
   * Returns a new color resulting from making this color lighter by the specified percentage.
   *
   * @param k Ratio from 0.0 to 1.0
   * @return A color resulting from making this color lighter by the specified percentage
   */
  def lighter(k: Float): Color4f = Color4f(this.r + (1.0f - this.r) * k, this.g + (1.0f - this.g) * k, this.b + (1.0f - this.b) * k, this.a)

  /**
   * Returns the linear interpolation with another color.
   *
   * @param to The color to interpolate to
   * @param weight Interpolation factor between 0.0 and 1.0
   * @return The linear interpolation between this color and the given one
   */
  def lerp(to: Color4f, weight: Float): Color4f = (this * (1.0f - weight)) + (to * weight)

  /**
   * Returns a [[Color3f]] with the RGB components of this color.
   *
   * @return A `Color3f` with the RGB components of this color
   */
  def rgb: Color3f = Color3f(this.r, this.g, this.b)

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
 * Color4f companion object.
 */
object Color4f {

  /**
   * Constructs a color with the three given RGB values and an alpha value of 1.0.
   *
   * @param r Red component of the color in a range from 0.0 to 1.0
   * @param g Green component of the color in a range from 0.0 to 1.0
   * @param b Blue component of the color in a range from 0.0 to 1.0
   * @return A color with the three given RGB values and an alpha value of 1.0
   */
  def apply(r: Float, g: Float, b: Float): Color4f = this.apply(r, g, b, 1.0f)

  lazy val AliceBlue: Color4f = Color4f(0.941176f, 0.972549f, 1.0f)

  lazy val AntiqueWhite: Color4f = Color4f(0.980392f, 0.921569f, 0.843137f)

  lazy val Aqua: Color4f = Color4f(0.0f, 1.0f, 1.0f)

  lazy val Aquamarine: Color4f = Color4f(0.498039f, 1.0f, 0.831373f)

  lazy val Azure: Color4f = Color4f(0.941176f, 1.0f, 1.0f)

  lazy val Beige: Color4f = Color4f(0.960784f, 0.960784f, 0.862745f)

  lazy val Bisque: Color4f = Color4f(1.0f, 0.894118f, 0.768627f)

  lazy val Black: Color4f = Color4f(0.0f, 0.0f, 0.0f)

  lazy val BlanchedAlmond: Color4f = Color4f(1.0f, 0.921569f, 0.803922f)

  lazy val Blue: Color4f = Color4f(0.0f, 0.0f, 1.0f)

  lazy val BlueViolet: Color4f = Color4f(0.541176f, 0.168627f, 0.886275f)

  lazy val Brown: Color4f = Color4f(0.647059f, 0.164706f, 0.164706f)

  lazy val BurlyWood: Color4f = Color4f(0.870588f, 0.721569f, 0.529412f)

  lazy val CadetBlue: Color4f = Color4f(0.372549f, 0.619608f, 0.627451f)

  lazy val Chartreuse: Color4f = Color4f(0.498039f, 1.0f, 0.0f)

  lazy val Chocolate: Color4f = Color4f(0.823529f, 0.411765f, 0.117647f)

  lazy val Coral: Color4f = Color4f(1.0f, 0.498039f, 0.313726f)

  lazy val Cornflower: Color4f = Color4f(0.392157f, 0.584314f, 0.929412f)

  lazy val Cornsilk: Color4f = Color4f(1.0f, 0.972549f, 0.862745f)

  lazy val Crimson: Color4f = Color4f(0.862745f, 0.0784314f, 0.235294f)

  lazy val Cyan: Color4f = Color4f(0.0f, 1.0f, 1.0f)

  lazy val DarkBlue: Color4f = Color4f(0.0f, 0.0f, 0.545098f)

  lazy val DarkCyan: Color4f = Color4f(0.0f, 0.545098f, 0.545098f)

  lazy val DarkGoldenRod: Color4f = Color4f(0.721569f, 0.52549f, 0.0431373f)

  lazy val DarkGray: Color4f = Color4f(0.662745f, 0.662745f, 0.662745f)

  lazy val DarkGreen: Color4f = Color4f(0.0f, 0.392157f, 0.0f)

  lazy val DarkKhaki: Color4f = Color4f(0.741176f, 0.717647f, 0.419608f)

  lazy val DarkMagenta: Color4f = Color4f(0.545098f, 0.0f, 0.545098f)

  lazy val DarkOliveGreen: Color4f = Color4f(0.333333f, 0.419608f, 0.184314f)

  lazy val DarkOrange: Color4f = Color4f(1.0f, 0.54902f, 0.0f)

  lazy val DarkOrchid: Color4f = Color4f(0.6f, 0.196078f, 0.8f)

  lazy val DarkRed: Color4f = Color4f(0.545098f, 0.0f, 0.0f)

  lazy val DarkSalmon: Color4f = Color4f(0.913725f, 0.588235f, 0.478431f)

  lazy val DarkSeaGreen: Color4f = Color4f(0.560784f, 0.737255f, 0.560784f)

  lazy val DarkSlateBlue: Color4f = Color4f(0.282353f, 0.239216f, 0.545098f)

  lazy val DarkSlateGray: Color4f = Color4f(0.184314f, 0.309804f, 0.309804f)

  lazy val DarkTurquoise: Color4f = Color4f(0.0f, 0.807843f, 0.819608f)

  lazy val DarkViolet: Color4f = Color4f(0.580392f, 0.0f, 0.827451f)

  lazy val DeepPink: Color4f = Color4f(1.0f, 0.0784314f, 0.576471f)

  lazy val DeepSkyBlue: Color4f = Color4f(0.0f, 0.74902f, 1.0f)

  lazy val DimGray: Color4f = Color4f(0.411765f, 0.411765f, 0.411765f)

  lazy val DodgerBlue: Color4f = Color4f(0.117647f, 0.564706f, 1.0f)

  lazy val DireBrick: Color4f = Color4f(0.698039f, 0.133333f, 0.133333f)

  lazy val FloralWhite: Color4f = Color4f(1.0f, 0.980392f, 0.941176f)

  lazy val ForestGreen: Color4f = Color4f(0.133333f, 0.545098f, 0.133333f)

  lazy val Fuchsia: Color4f = Color4f(1.0f, 0.0f, 1.0f)

  lazy val Gainsboro: Color4f = Color4f(0.862745f, 0.862745f, 0.862745f)

  lazy val GhostWhite: Color4f = Color4f(0.972549f, 0.972549f, 1.0f)

  lazy val Gold: Color4f = Color4f(1.0f, 0.843137f, 0.0f)

  lazy val GoldenRod: Color4f = Color4f(0.854902f, 0.647059f, 0.12549f)

  lazy val Gray: Color4f = Color4f(0.745098f, 0.745098f, 0.745098f)

  lazy val Green: Color4f = Color4f(0.0f, 1.0f, 0.0f)

  lazy val GreenYellow: Color4f = Color4f(0.678431f, 1.0f, 0.184314f)

  lazy val HoneyDew: Color4f = Color4f(0.941176f, 1.0f, 0.941176f)

  lazy val HotPink: Color4f = Color4f(1.0f, 0.411765f, 0.705882f)

  lazy val IndianRed: Color4f = Color4f(0.803922f, 0.360784f, 0.360784f)

  lazy val Indigo: Color4f = Color4f(0.294118f, 0.0f, 0.509804f)

  lazy val Ivory: Color4f = Color4f(1.0f, 1.0f, 0.941176f)

  lazy val Khaki: Color4f = Color4f(0.941176f, 0.901961f, 0.54902f)

  lazy val Lavender: Color4f = Color4f(0.901961f, 0.901961f, 0.980392f)

  lazy val LavenderBlush: Color4f = Color4f(1.0f, 0.941176f, 0.960784f)

  lazy val LawnGreen: Color4f = Color4f(0.486275f, 0.988235f, 0.0f)

  lazy val LemonChiffon: Color4f = Color4f(1.0f, 0.980392f, 0.803922f)

  lazy val LightBlue: Color4f = Color4f(0.678431f, 0.847059f, 0.901961f)

  lazy val LightCoral: Color4f = Color4f(0.941176f, 0.501961f, 0.501961f)

  lazy val LightCyan: Color4f = Color4f(0.878431f, 1.0f, 1.0f)

  lazy val LightGoldenRod: Color4f = Color4f(0.980392f, 0.980392f, 0.823529f)

  lazy val LightGray: Color4f = Color4f(0.827451f, 0.827451f, 0.827451f)

  lazy val LightGreen: Color4f = Color4f(0.564706f, 0.933333f, 0.564706f)

  lazy val LightPink: Color4f = Color4f(1.0f, 0.713726f, 0.756863f)

  lazy val LightSalmon: Color4f = Color4f(1.0f, 0.627451f, 0.478431f)

  lazy val LightSeaGreen: Color4f = Color4f(0.12549f, 0.698039f, 0.666667f)

  lazy val LightSkyBlue: Color4f = Color4f(0.529412f, 0.807843f, 0.980392f)

  lazy val LightSlateGray: Color4f = Color4f(0.466667f, 0.533333f, 0.6f)

  lazy val LightSteelBlue: Color4f = Color4f(0.690196f, 0.768627f, 0.870588f)

  lazy val LightYellow: Color4f = Color4f(1.0f, 1.0f, 0.878431f)

  lazy val Lime: Color4f = Color4f(0.0f, 1.0f, 0.0f)

  lazy val LimeGreen: Color4f = Color4f(0.196078f, 0.803922f, 0.196078f)

  lazy val Linen: Color4f = Color4f(0.980392f, 0.941176f, 0.901961f)

  lazy val Magenta: Color4f = Color4f(1.0f, 0.0f, 1.0f)

  lazy val Maroon: Color4f = Color4f(0.690196f, 0.188235f, 0.376471f)

  lazy val MediumAquamarine: Color4f = Color4f(0.4f, 0.803922f, 0.666667f)

  lazy val MediumBlue: Color4f = Color4f(0.0f, 0.0f, 0.803922f)

  lazy val MediumOrchid: Color4f = Color4f(0.729412f, 0.333333f, 0.827451f)

  lazy val MediumPurple: Color4f = Color4f(0.576471f, 0.439216f, 0.858824f)

  lazy val MediumSeaGreen: Color4f = Color4f(0.235294f, 0.701961f, 0.443137f)

  lazy val MediumSlateBlue: Color4f = Color4f(0.482353f, 0.407843f, 0.933333f)

  lazy val MediumSpringGreen: Color4f = Color4f(0.0f, 0.980392f, 0.603922f)

  lazy val MediumTurquoise: Color4f = Color4f(0.282353f, 0.819608f, 0.8f)

  lazy val MediumVioletRed: Color4f = Color4f(0.780392f, 0.0823529f, 0.521569f)

  lazy val MidnightBlue: Color4f = Color4f(0.0980392f, 0.0980392f, 0.439216f)

  lazy val MintCream: Color4f = Color4f(0.960784f, 1.0f, 0.980392f)

  lazy val MistyRose: Color4f = Color4f(1.0f, 0.894118f, 0.882353f)

  lazy val Moccasin: Color4f = Color4f(1.0f, 0.894118f, 0.709804f)

  lazy val NavajoWhite: Color4f = Color4f(1.0f, 0.870588f, 0.678431f)

  lazy val NavyBlue: Color4f = Color4f(0.0f, 0.0f, 0.501961f)

  lazy val OldLace: Color4f = Color4f(0.992157f, 0.960784f, 0.901961f)

  lazy val Olive: Color4f = Color4f(0.501961f, 0.501961f, 0.0f)

  lazy val OliveDrab: Color4f = Color4f(0.419608f, 0.556863f, 0.137255f)

  lazy val Orange: Color4f = Color4f(1.0f, 0.647059f, 0.0f)

  lazy val OrangeRed: Color4f = Color4f(1.0f, 0.270588f, 0.0f)

  lazy val Orchid: Color4f = Color4f(0.854902f, 0.439216f, 0.839216f)

  lazy val PaleGoldenRod: Color4f = Color4f(0.933333f, 0.909804f, 0.666667f)

  lazy val PaleGreen: Color4f = Color4f(0.596078f, 0.984314f, 0.596078f)

  lazy val PaleTurquoise: Color4f = Color4f(0.686275f, 0.933333f, 0.933333f)

  lazy val PaleVioletRed: Color4f = Color4f(0.858824f, 0.439216f, 0.576471f)

  lazy val PapayaWhip: Color4f = Color4f(1.0f, 0.937255f, 0.835294f)

  lazy val PeachPuff: Color4f = Color4f(1.0f, 0.854902f, 0.72549f)

  lazy val Peru: Color4f = Color4f(0.803922f, 0.521569f, 0.247059f)

  lazy val Pink: Color4f = Color4f(1.0f, 0.752941f, 0.796078f)

  lazy val Plum: Color4f = Color4f(0.866667f, 0.627451f, 0.866667f)

  lazy val PowderBlue: Color4f = Color4f(0.690196f, 0.878431f, 0.901961f)

  lazy val Purple: Color4f = Color4f(0.627451f, 0.12549f, 0.941176f)

  lazy val RebeccaPurple: Color4f = Color4f(0.4f, 0.2f, 0.6f)

  lazy val Red: Color4f = Color4f(1.0f, 0.0f, 0.0f)

  lazy val RosyBrown: Color4f = Color4f(0.737255f, 0.560784f, 0.560784f)

  lazy val RoyalBlue: Color4f = Color4f(0.254902f, 0.411765f, 0.882353f)

  lazy val SaddleBrown: Color4f = Color4f(0.545098f, 0.270588f, 0.0745098f)

  lazy val Salmon: Color4f = Color4f(0.980392f, 0.501961f, 0.447059f)

  lazy val SandyBrown: Color4f = Color4f(0.956863f, 0.643137f, 0.376471f)

  lazy val SeaGreen: Color4f = Color4f(0.180392f, 0.545098f, 0.341176f)

  lazy val Seashell: Color4f = Color4f(1.0f, 0.960784f, 0.933333f)

  lazy val Sienna: Color4f = Color4f(0.627451f, 0.321569f, 0.176471f)

  lazy val Silver: Color4f = Color4f(0.752941f, 0.752941f, 0.752941f)

  lazy val SkyBlue: Color4f = Color4f(0.529412f, 0.807843f, 0.921569f)

  lazy val SlateBlue: Color4f = Color4f(0.415686f, 0.352941f, 0.803922f)

  lazy val SlateGray: Color4f = Color4f(0.439216f, 0.501961f, 0.564706f)

  lazy val Snow: Color4f = Color4f(1.0f, 0.980392f, 0.980392f)

  lazy val SpringGreen: Color4f = Color4f(0.0f, 1.0f, 0.498039f)

  lazy val SteelBlue: Color4f = Color4f(0.27451f, 0.509804f, 0.705882f)

  lazy val Tan: Color4f = Color4f(0.823529f, 0.705882f, 0.54902f)

  lazy val Teal: Color4f = Color4f(0.0f, 0.501961f, 0.501961f)

  lazy val Thistle: Color4f = Color4f(0.847059f, 0.74902f, 0.847059f)

  lazy val Tomato: Color4f = Color4f(1.0f, 0.388235f, 0.278431f)

  lazy val Transparent: Color4f = Color4f(1.0f, 1.0f, 1.0f, 0.0f)

  lazy val Turquoise: Color4f = Color4f(0.25098f, 0.878431f, 0.815686f)

  lazy val Violet: Color4f = Color4f(0.933333f, 0.509804f, 0.933333f)

  lazy val WebGray: Color4f = Color4f(0.501961f, 0.501961f, 0.501961f)

  lazy val WebGreen: Color4f = Color4f(0.0f, 0.501961f, 0.0f)

  lazy val WebMaroon: Color4f = Color4f(0.501961f, 0.0f, 0.0f)

  lazy val WebPurple: Color4f = Color4f(0.501961f, 0.0f, 0.501961f)

  lazy val Wheat: Color4f = Color4f(0.960784f, 0.870588f, 0.701961f)

  lazy val White: Color4f = Color4f(1.0f, 1.0f, 1.0f)

  lazy val WhiteSmoke: Color4f = Color4f(0.960784f, 0.960784f, 0.960784f)

  lazy val Yellow: Color4f = Color4f(1.0f, 1.0f, 0.0f)

  lazy val YellowGreen: Color4f = Color4f(0.603922f, 0.803922f, 0.196078f)
}