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

  lazy val AliceBlue: Color = Color(0.941176f, 0.972549f, 1.0f)

  lazy val AntiqueWhite: Color = Color(0.980392f, 0.921569f, 0.843137f)

  lazy val Aqua: Color = Color(0.0f, 1.0f, 1.0f)

  lazy val Aquamarine: Color = Color(0.498039f, 1.0f, 0.831373f)

  lazy val Azure: Color = Color(0.941176f, 1.0f, 1.0f)

  lazy val Beige: Color = Color(0.960784f, 0.960784f, 0.862745f)

  lazy val Bisque: Color = Color(1.0f, 0.894118f, 0.768627f)

  lazy val Black: Color = Color(0.0f, 0.0f, 0.0f)

  lazy val BlanchedAlmond: Color = Color(1.0f, 0.921569f, 0.803922f)

  lazy val Blue: Color = Color(0.0f, 0.0f, 1.0f)

  lazy val BlueViolet: Color = Color(0.541176f, 0.168627f, 0.886275f)

  lazy val Brown: Color = Color(0.647059f, 0.164706f, 0.164706f)

  lazy val BurlyWood: Color = Color(0.870588f, 0.721569f, 0.529412f)

  lazy val CadetBlue: Color = Color(0.372549f, 0.619608f, 0.627451f)

  lazy val Chartreuse: Color = Color(0.498039f, 1.0f, 0.0f)

  lazy val Chocolate: Color = Color(0.823529f, 0.411765f, 0.117647f)

  lazy val Coral: Color = Color(1.0f, 0.498039f, 0.313726f)

  lazy val Cornflower: Color = Color(0.392157f, 0.584314f, 0.929412f)

  lazy val Cornsilk: Color = Color(1.0f, 0.972549f, 0.862745f)

  lazy val Crimson: Color = Color(0.862745f, 0.0784314f, 0.235294f)

  lazy val Cyan: Color = Color(0.0f, 1.0f, 1.0f)

  lazy val DarkBlue: Color = Color(0.0f, 0.0f, 0.545098f)

  lazy val DarkCyan: Color = Color(0.0f, 0.545098f, 0.545098f)

  lazy val DarkGoldenRod: Color = Color(0.721569f, 0.52549f, 0.0431373f)

  lazy val DarkGray: Color = Color(0.662745f, 0.662745f, 0.662745f)

  lazy val DarkGreen: Color = Color(0.0f, 0.392157f, 0.0f)

  lazy val DarkKhaki: Color = Color(0.741176f, 0.717647f, 0.419608f)

  lazy val DarkMagenta: Color = Color(0.545098f, 0.0f, 0.545098f)

  lazy val DarkOliveGreen: Color = Color(0.333333f, 0.419608f, 0.184314f)

  lazy val DarkOrange: Color = Color(1.0f, 0.54902f, 0.0f)

  lazy val DarkOrchid: Color = Color(0.6f, 0.196078f, 0.8f)

  lazy val DarkRed: Color = Color(0.545098f, 0.0f, 0.0f)

  lazy val DarkSalmon: Color = Color(0.913725f, 0.588235f, 0.478431f)

  lazy val DarkSeaGreen: Color = Color(0.560784f, 0.737255f, 0.560784f)

  lazy val DarkSlateBlue: Color = Color(0.282353f, 0.239216f, 0.545098f)

  lazy val DarkSlateGray: Color = Color(0.184314f, 0.309804f, 0.309804f)

  lazy val DarkTurquoise: Color = Color(0.0f, 0.807843f, 0.819608f)

  lazy val DarkViolet: Color = Color(0.580392f, 0.0f, 0.827451f)

  lazy val DeepPink: Color = Color(1.0f, 0.0784314f, 0.576471f)

  lazy val DeepSkyBlue: Color = Color(0.0f, 0.74902f, 1.0f)

  lazy val DimGray: Color = Color(0.411765f, 0.411765f, 0.411765f)

  lazy val DodgerBlue: Color = Color(0.117647f, 0.564706f, 1.0f)

  lazy val DireBrick: Color = Color(0.698039f, 0.133333f, 0.133333f)

  lazy val FloralWhite: Color = Color(1.0f, 0.980392f, 0.941176f)

  lazy val ForestGreen: Color = Color(0.133333f, 0.545098f, 0.133333f)

  lazy val Fuchsia: Color = Color(1.0f, 0.0f, 1.0f)

  lazy val Gainsboro: Color = Color(0.862745f, 0.862745f, 0.862745f)

  lazy val GhostWhite: Color = Color(0.972549f, 0.972549f, 1.0f)

  lazy val Gold: Color = Color(1.0f, 0.843137f, 0.0f)

  lazy val GoldenRod: Color = Color(0.854902f, 0.647059f, 0.12549f)

  lazy val Gray: Color = Color(0.745098f, 0.745098f, 0.745098f)

  lazy val Green: Color = Color(0.0f, 1.0f, 0.0f)

  lazy val GreenYellow: Color = Color(0.678431f, 1.0f, 0.184314f)

  lazy val HoneyDew: Color = Color(0.941176f, 1.0f, 0.941176f)

  lazy val HotPink: Color = Color(1.0f, 0.411765f, 0.705882f)

  lazy val IndianRed: Color = Color(0.803922f, 0.360784f, 0.360784f)

  lazy val Indigo: Color = Color(0.294118f, 0.0f, 0.509804f)

  lazy val Ivory: Color = Color(1.0f, 1.0f, 0.941176f)

  lazy val Khaki: Color = Color(0.941176f, 0.901961f, 0.54902f)

  lazy val Lavender: Color = Color(0.901961f, 0.901961f, 0.980392f)

  lazy val LavenderBlush: Color = Color(1.0f, 0.941176f, 0.960784f)

  lazy val LawnGreen: Color = Color(0.486275f, 0.988235f, 0.0f)

  lazy val LemonChiffon: Color = Color(1.0f, 0.980392f, 0.803922f)

  lazy val LightBlue: Color = Color(0.678431f, 0.847059f, 0.901961f)

  lazy val LightCoral: Color = Color(0.941176f, 0.501961f, 0.501961f)

  lazy val LightCyan: Color = Color(0.878431f, 1.0f, 1.0f)

  lazy val LightGoldenRod: Color = Color(0.980392f, 0.980392f, 0.823529f)

  lazy val LightGray: Color = Color(0.827451f, 0.827451f, 0.827451f)

  lazy val LightGreen: Color = Color(0.564706f, 0.933333f, 0.564706f)

  lazy val LightPink: Color = Color(1.0f, 0.713726f, 0.756863f)

  lazy val LightSalmon: Color = Color(1.0f, 0.627451f, 0.478431f)

  lazy val LightSeaGreen: Color = Color(0.12549f, 0.698039f, 0.666667f)

  lazy val LightSkyBlue: Color = Color(0.529412f, 0.807843f, 0.980392f)

  lazy val LightSlateGray: Color = Color(0.466667f, 0.533333f, 0.6f)

  lazy val LightSteelBlue: Color = Color(0.690196f, 0.768627f, 0.870588f)

  lazy val LightYellow: Color = Color(1.0f, 1.0f, 0.878431f)

  lazy val Lime: Color = Color(0.0f, 1.0f, 0.0f)

  lazy val LimeGreen: Color = Color(0.196078f, 0.803922f, 0.196078f)

  lazy val Linen: Color = Color(0.980392f, 0.941176f, 0.901961f)

  lazy val Magenta: Color = Color(1.0f, 0.0f, 1.0f)

  lazy val Maroon: Color = Color(0.690196f, 0.188235f, 0.376471f)

  lazy val MediumAquamarine: Color = Color(0.4f, 0.803922f, 0.666667f)

  lazy val MediumBlue: Color = Color(0.0f, 0.0f, 0.803922f)

  lazy val MediumOrchid: Color = Color(0.729412f, 0.333333f, 0.827451f)

  lazy val MediumPurple: Color = Color(0.576471f, 0.439216f, 0.858824f)

  lazy val MediumSeaGreen: Color = Color(0.235294f, 0.701961f, 0.443137f)

  lazy val MediumSlateBlue: Color = Color(0.482353f, 0.407843f, 0.933333f)

  lazy val MediumSpringGreen: Color = Color(0.0f, 0.980392f, 0.603922f)

  lazy val MediumTurquoise: Color = Color(0.282353f, 0.819608f, 0.8f)

  lazy val MediumVioletRed: Color = Color(0.780392f, 0.0823529f, 0.521569f)

  lazy val MidnightBlue: Color = Color(0.0980392f, 0.0980392f, 0.439216f)

  lazy val MintCream: Color = Color(0.960784f, 1.0f, 0.980392f)

  lazy val MistyRose: Color = Color(1.0f, 0.894118f, 0.882353f)

  lazy val Moccasin: Color = Color(1.0f, 0.894118f, 0.709804f)

  lazy val NavajoWhite: Color = Color(1.0f, 0.870588f, 0.678431f)

  lazy val NavyBlue: Color = Color(0.0f, 0.0f, 0.501961f)

  lazy val OldLace: Color = Color(0.992157f, 0.960784f, 0.901961f)

  lazy val Olive: Color = Color(0.501961f, 0.501961f, 0.0f)

  lazy val OliveDrab: Color = Color(0.419608f, 0.556863f, 0.137255f)

  lazy val Orange: Color = Color(1.0f, 0.647059f, 0.0f)

  lazy val OrangeRed: Color = Color(1.0f, 0.270588f, 0.0f)

  lazy val Orchid: Color = Color(0.854902f, 0.439216f, 0.839216f)

  lazy val PaleGoldenRod: Color = Color(0.933333f, 0.909804f, 0.666667f)

  lazy val PaleGreen: Color = Color(0.596078f, 0.984314f, 0.596078f)

  lazy val PaleTurquoise: Color = Color(0.686275f, 0.933333f, 0.933333f)

  lazy val PaleVioletRed: Color = Color(0.858824f, 0.439216f, 0.576471f)

  lazy val PapayaWhip: Color = Color(1.0f, 0.937255f, 0.835294f)

  lazy val PeachPuff: Color = Color(1.0f, 0.854902f, 0.72549f)

  lazy val Peru: Color = Color(0.803922f, 0.521569f, 0.247059f)

  lazy val Pink: Color = Color(1.0f, 0.752941f, 0.796078f)

  lazy val Plum: Color = Color(0.866667f, 0.627451f, 0.866667f)

  lazy val PowderBlue: Color = Color(0.690196f, 0.878431f, 0.901961f)

  lazy val Purple: Color = Color(0.627451f, 0.12549f, 0.941176f)

  lazy val RebeccaPurple: Color = Color(0.4f, 0.2f, 0.6f)

  lazy val Red: Color = Color(1.0f, 0.0f, 0.0f)

  lazy val RosyBrown: Color = Color(0.737255f, 0.560784f, 0.560784f)

  lazy val RoyalBlue: Color = Color(0.254902f, 0.411765f, 0.882353f)

  lazy val SaddleBrown: Color = Color(0.545098f, 0.270588f, 0.0745098f)

  lazy val Salmon: Color = Color(0.980392f, 0.501961f, 0.447059f)

  lazy val SandyBrown: Color = Color(0.956863f, 0.643137f, 0.376471f)

  lazy val SeaGreen: Color = Color(0.180392f, 0.545098f, 0.341176f)

  lazy val Seashell: Color = Color(1.0f, 0.960784f, 0.933333f)

  lazy val Sienna: Color = Color(0.627451f, 0.321569f, 0.176471f)

  lazy val Silver: Color = Color(0.752941f, 0.752941f, 0.752941f)

  lazy val SkyBlue: Color = Color(0.529412f, 0.807843f, 0.921569f)

  lazy val SlateBlue: Color = Color(0.415686f, 0.352941f, 0.803922f)

  lazy val SlateGray: Color = Color(0.439216f, 0.501961f, 0.564706f)

  lazy val Snow: Color = Color(1.0f, 0.980392f, 0.980392f)

  lazy val SpringGreen: Color = Color(0.0f, 1.0f, 0.498039f)

  lazy val SteelBlue: Color = Color(0.27451f, 0.509804f, 0.705882f)

  lazy val Tan: Color = Color(0.823529f, 0.705882f, 0.54902f)

  lazy val Teal: Color = Color(0.0f, 0.501961f, 0.501961f)

  lazy val Thistle: Color = Color(0.847059f, 0.74902f, 0.847059f)

  lazy val Tomato: Color = Color(1.0f, 0.388235f, 0.278431f)

  lazy val Transparent: Color = Color(1.0f, 1.0f, 1.0f, 0.0f)

  lazy val Turquoise: Color = Color(0.25098f, 0.878431f, 0.815686f)

  lazy val Violet: Color = Color(0.933333f, 0.509804f, 0.933333f)

  lazy val WebGray: Color = Color(0.501961f, 0.501961f, 0.501961f)

  lazy val WebGreen: Color = Color(0.0f, 0.501961f, 0.0f)

  lazy val WebMaroon: Color = Color(0.501961f, 0.0f, 0.0f)

  lazy val WebPurple: Color = Color(0.501961f, 0.0f, 0.501961f)

  lazy val Wheat: Color = Color(0.960784f, 0.870588f, 0.701961f)

  lazy val White: Color = Color(1.0f, 1.0f, 1.0f)

  lazy val WhiteSmoke: Color = Color(0.960784f, 0.960784f, 0.960784f)

  lazy val Yellow: Color = Color(1.0f, 1.0f, 0.0f)

  lazy val YellowGreen: Color = Color(0.603922f, 0.803922f, 0.196078f)
}