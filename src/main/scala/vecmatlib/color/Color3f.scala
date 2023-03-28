package vecmatlib.color

import vecmatlib.Float3

case class Color3f(r: Float, g: Float, b: Float) extends Float3 {
  
  def +(r: Float, g: Float, b: Float): Color3f = Color3f(this.r + r, this.g + g, this.b + b)
  
  def +(r: Float, g: Float, b: Float, a: Float): Color4f = Color4f(this.r + r, this.g + g, this.b + b, a)
  
  def +(c: Color3f): Color3f = this + (c.r, c.g, c.b)
  
  def +(c: Color4f): Color4f = this + (c.r, c.g, c.b, c.a)
  
  def add(r: Float, g: Float, b: Float): Color3f = this + (r, g, b)
  
  def add(r: Float, g: Float, b: Float, a: Float): Color4f = this + (r, g, b, a)
  
  def add(c: Color3f): Color3f = this + c
  
  def add(c: Color4f): Color4f = this + c

  def -(r: Float, g: Float, b: Float): Color3f = Color3f(this.r - r, this.g - g, this.b - b)

  def -(r: Float, g: Float, b: Float, a: Float): Color4f = Color4f(this.r - r, this.g - g, this.b - b, 1.0f - a)

  def -(c: Color3f): Color3f = this - (c.r, c.g, c.b)

  def -(c: Color4f): Color4f = this - (c.r, c.g, c.b, c.a)

  def subtract(r: Float, g: Float, b: Float): Color3f = this - (r, g, b)

  def subtract(r: Float, g: Float, b: Float, a: Float): Color4f = this - (r, g, b, a)

  def subtract(c: Color3f): Color3f = this - c

  def subtract(c: Color4f): Color4f = this - c
  
  def *(r: Float, g: Float, b: Float): Color3f = Color3f(this.r * r, this.g * g, this.b * b)
  
  def *(r: Float, g: Float, b: Float, a: Float): Color4f = Color4f(this.r * r, this.g * g, this.b * b, a)
  
  def *(c: Color3f): Color3f = this * (c.r, c.g, c.b)
  
  def *(c: Color4f): Color4f = this * (c.r, c.g, c.b, c.a)
  
  def blend(r: Float, g: Float, b: Float): Color3f = this * (r, g, b)
  
  def blend(r: Float, g: Float, b: Float, a: Float): Color4f = this * (r, g, b, a)
  
  def blend(c: Color3f): Color3f = this * c
  
  def blend(c: Color4f): Color4f = this * c
  
  def *(k: Float): Color3f = this * (k, k, k)
  
  def multiply(k: Float): Color3f = this * k
  
  def invert: Color3f = Color3f(1.0f - this.r, 1.0f - this.g, 1.0f - this.b)
  
  def darker(k: Float): Color3f = Color3f(this.r * (1.0f - k), this.g * (1.0f - k), this.b * (1.0f - k))
  
  def lighter(k: Float): Color3f = Color3f(this.r + (1.0f - this.r) * k, this.g + (1.0f - this.g) * k, this.b + (1.0f - this.b) * k)

  def lerp(to: Color3f, weight: Float): Color3f = (this * (1.0f - weight)) + (to * weight)
  
  /**
   * X component.
   *
   * @return The X component of this tuple
   */
  override def x: Float = this.r

  /**
   * Y component.
   *
   * @return The Y component of this tuple
   */
  override def y: Float = this.g

  /**
   * Z component.
   *
   * @return The Z component of this tuple
   */
  override def z: Float = this.b
}

object Color3f {

  lazy val AliceBlue: Color3f = Color3f(0.941176f, 0.972549f, 1.0f)

  lazy val AntiqueWhite: Color3f = Color3f(0.980392f, 0.921569f, 0.843137f)

  lazy val Aqua: Color3f = Color3f(0.0f, 1.0f, 1.0f)

  lazy val Aquamarine: Color3f = Color3f(0.498039f, 1.0f, 0.831373f)

  lazy val Azure: Color3f = Color3f(0.941176f, 1.0f, 1.0f)

  lazy val Beige: Color3f = Color3f(0.960784f, 0.960784f, 0.862745f)

  lazy val Bisque: Color3f = Color3f(1.0f, 0.894118f, 0.768627f)

  lazy val Black: Color3f = Color3f(0.0f, 0.0f, 0.0f)

  lazy val BlanchedAlmond: Color3f = Color3f(1.0f, 0.921569f, 0.803922f)

  lazy val Blue: Color3f = Color3f(0.0f, 0.0f, 1.0f)

  lazy val BlueViolet: Color3f = Color3f(0.541176f, 0.168627f, 0.886275f)

  lazy val Brown: Color3f = Color3f(0.647059f, 0.164706f, 0.164706f)

  lazy val BurlyWood: Color3f = Color3f(0.870588f, 0.721569f, 0.529412f)

  lazy val CadetBlue: Color3f = Color3f(0.372549f, 0.619608f, 0.627451f)

  lazy val Chartreuse: Color3f = Color3f(0.498039f, 1.0f, 0.0f)

  lazy val Chocolate: Color3f = Color3f(0.823529f, 0.411765f, 0.117647f)

  lazy val Coral: Color3f = Color3f(1.0f, 0.498039f, 0.313726f)

  lazy val Cornflower: Color3f = Color3f(0.392157f, 0.584314f, 0.929412f)

  lazy val Cornsilk: Color3f = Color3f(1.0f, 0.972549f, 0.862745f)

  lazy val Crimson: Color3f = Color3f(0.862745f, 0.0784314f, 0.235294f)

  lazy val Cyan: Color3f = Color3f(0.0f, 1.0f, 1.0f)

  lazy val DarkBlue: Color3f = Color3f(0.0f, 0.0f, 0.545098f)

  lazy val DarkCyan: Color3f = Color3f(0.0f, 0.545098f, 0.545098f)

  lazy val DarkGoldenRod: Color3f = Color3f(0.721569f, 0.52549f, 0.0431373f)

  lazy val DarkGray: Color3f = Color3f(0.662745f, 0.662745f, 0.662745f)

  lazy val DarkGreen: Color3f = Color3f(0.0f, 0.392157f, 0.0f)

  lazy val DarkKhaki: Color3f = Color3f(0.741176f, 0.717647f, 0.419608f)

  lazy val DarkMagenta: Color3f = Color3f(0.545098f, 0.0f, 0.545098f)

  lazy val DarkOliveGreen: Color3f = Color3f(0.333333f, 0.419608f, 0.184314f)

  lazy val DarkOrange: Color3f = Color3f(1.0f, 0.54902f, 0.0f)

  lazy val DarkOrchid: Color3f = Color3f(0.6f, 0.196078f, 0.8f)

  lazy val DarkRed: Color3f = Color3f(0.545098f, 0.0f, 0.0f)

  lazy val DarkSalmon: Color3f = Color3f(0.913725f, 0.588235f, 0.478431f)

  lazy val DarkSeaGreen: Color3f = Color3f(0.560784f, 0.737255f, 0.560784f)

  lazy val DarkSlateBlue: Color3f = Color3f(0.282353f, 0.239216f, 0.545098f)

  lazy val DarkSlateGray: Color3f = Color3f(0.184314f, 0.309804f, 0.309804f)

  lazy val DarkTurquoise: Color3f = Color3f(0.0f, 0.807843f, 0.819608f)

  lazy val DarkViolet: Color3f = Color3f(0.580392f, 0.0f, 0.827451f)

  lazy val DeepPink: Color3f = Color3f(1.0f, 0.0784314f, 0.576471f)

  lazy val DeepSkyBlue: Color3f = Color3f(0.0f, 0.74902f, 1.0f)

  lazy val DimGray: Color3f = Color3f(0.411765f, 0.411765f, 0.411765f)

  lazy val DodgerBlue: Color3f = Color3f(0.117647f, 0.564706f, 1.0f)

  lazy val DireBrick: Color3f = Color3f(0.698039f, 0.133333f, 0.133333f)

  lazy val FloralWhite: Color3f = Color3f(1.0f, 0.980392f, 0.941176f)

  lazy val ForestGreen: Color3f = Color3f(0.133333f, 0.545098f, 0.133333f)

  lazy val Fuchsia: Color3f = Color3f(1.0f, 0.0f, 1.0f)

  lazy val Gainsboro: Color3f = Color3f(0.862745f, 0.862745f, 0.862745f)

  lazy val GhostWhite: Color3f = Color3f(0.972549f, 0.972549f, 1.0f)

  lazy val Gold: Color3f = Color3f(1.0f, 0.843137f, 0.0f)

  lazy val GoldenRod: Color3f = Color3f(0.854902f, 0.647059f, 0.12549f)

  lazy val Gray: Color3f = Color3f(0.745098f, 0.745098f, 0.745098f)

  lazy val Green: Color3f = Color3f(0.0f, 1.0f, 0.0f)

  lazy val GreenYellow: Color3f = Color3f(0.678431f, 1.0f, 0.184314f)

  lazy val HoneyDew: Color3f = Color3f(0.941176f, 1.0f, 0.941176f)

  lazy val HotPink: Color3f = Color3f(1.0f, 0.411765f, 0.705882f)

  lazy val IndianRed: Color3f = Color3f(0.803922f, 0.360784f, 0.360784f)

  lazy val Indigo: Color3f = Color3f(0.294118f, 0.0f, 0.509804f)

  lazy val Ivory: Color3f = Color3f(1.0f, 1.0f, 0.941176f)

  lazy val Khaki: Color3f = Color3f(0.941176f, 0.901961f, 0.54902f)

  lazy val Lavender: Color3f = Color3f(0.901961f, 0.901961f, 0.980392f)

  lazy val LavenderBlush: Color3f = Color3f(1.0f, 0.941176f, 0.960784f)

  lazy val LawnGreen: Color3f = Color3f(0.486275f, 0.988235f, 0.0f)

  lazy val LemonChiffon: Color3f = Color3f(1.0f, 0.980392f, 0.803922f)

  lazy val LightBlue: Color3f = Color3f(0.678431f, 0.847059f, 0.901961f)

  lazy val LightCoral: Color3f = Color3f(0.941176f, 0.501961f, 0.501961f)

  lazy val LightCyan: Color3f = Color3f(0.878431f, 1.0f, 1.0f)

  lazy val LightGoldenRod: Color3f = Color3f(0.980392f, 0.980392f, 0.823529f)

  lazy val LightGray: Color3f = Color3f(0.827451f, 0.827451f, 0.827451f)

  lazy val LightGreen: Color3f = Color3f(0.564706f, 0.933333f, 0.564706f)

  lazy val LightPink: Color3f = Color3f(1.0f, 0.713726f, 0.756863f)

  lazy val LightSalmon: Color3f = Color3f(1.0f, 0.627451f, 0.478431f)

  lazy val LightSeaGreen: Color3f = Color3f(0.12549f, 0.698039f, 0.666667f)

  lazy val LightSkyBlue: Color3f = Color3f(0.529412f, 0.807843f, 0.980392f)

  lazy val LightSlateGray: Color3f = Color3f(0.466667f, 0.533333f, 0.6f)

  lazy val LightSteelBlue: Color3f = Color3f(0.690196f, 0.768627f, 0.870588f)

  lazy val LightYellow: Color3f = Color3f(1.0f, 1.0f, 0.878431f)

  lazy val Lime: Color3f = Color3f(0.0f, 1.0f, 0.0f)

  lazy val LimeGreen: Color3f = Color3f(0.196078f, 0.803922f, 0.196078f)

  lazy val Linen: Color3f = Color3f(0.980392f, 0.941176f, 0.901961f)

  lazy val Magenta: Color3f = Color3f(1.0f, 0.0f, 1.0f)

  lazy val Maroon: Color3f = Color3f(0.690196f, 0.188235f, 0.376471f)

  lazy val MediumAquamarine: Color3f = Color3f(0.4f, 0.803922f, 0.666667f)

  lazy val MediumBlue: Color3f = Color3f(0.0f, 0.0f, 0.803922f)

  lazy val MediumOrchid: Color3f = Color3f(0.729412f, 0.333333f, 0.827451f)

  lazy val MediumPurple: Color3f = Color3f(0.576471f, 0.439216f, 0.858824f)

  lazy val MediumSeaGreen: Color3f = Color3f(0.235294f, 0.701961f, 0.443137f)

  lazy val MediumSlateBlue: Color3f = Color3f(0.482353f, 0.407843f, 0.933333f)

  lazy val MediumSpringGreen: Color3f = Color3f(0.0f, 0.980392f, 0.603922f)

  lazy val MediumTurquoise: Color3f = Color3f(0.282353f, 0.819608f, 0.8f)

  lazy val MediumVioletRed: Color3f = Color3f(0.780392f, 0.0823529f, 0.521569f)

  lazy val MidnightBlue: Color3f = Color3f(0.0980392f, 0.0980392f, 0.439216f)

  lazy val MintCream: Color3f = Color3f(0.960784f, 1.0f, 0.980392f)

  lazy val MistyRose: Color3f = Color3f(1.0f, 0.894118f, 0.882353f)

  lazy val Moccasin: Color3f = Color3f(1.0f, 0.894118f, 0.709804f)

  lazy val NavajoWhite: Color3f = Color3f(1.0f, 0.870588f, 0.678431f)

  lazy val NavyBlue: Color3f = Color3f(0.0f, 0.0f, 0.501961f)

  lazy val OldLace: Color3f = Color3f(0.992157f, 0.960784f, 0.901961f)

  lazy val Olive: Color3f = Color3f(0.501961f, 0.501961f, 0.0f)

  lazy val OliveDrab: Color3f = Color3f(0.419608f, 0.556863f, 0.137255f)

  lazy val Orange: Color3f = Color3f(1.0f, 0.647059f, 0.0f)

  lazy val OrangeRed: Color3f = Color3f(1.0f, 0.270588f, 0.0f)

  lazy val Orchid: Color3f = Color3f(0.854902f, 0.439216f, 0.839216f)

  lazy val PaleGoldenRod: Color3f = Color3f(0.933333f, 0.909804f, 0.666667f)

  lazy val PaleGreen: Color3f = Color3f(0.596078f, 0.984314f, 0.596078f)

  lazy val PaleTurquoise: Color3f = Color3f(0.686275f, 0.933333f, 0.933333f)

  lazy val PaleVioletRed: Color3f = Color3f(0.858824f, 0.439216f, 0.576471f)

  lazy val PapayaWhip: Color3f = Color3f(1.0f, 0.937255f, 0.835294f)

  lazy val PeachPuff: Color3f = Color3f(1.0f, 0.854902f, 0.72549f)

  lazy val Peru: Color3f = Color3f(0.803922f, 0.521569f, 0.247059f)

  lazy val Pink: Color3f = Color3f(1.0f, 0.752941f, 0.796078f)

  lazy val Plum: Color3f = Color3f(0.866667f, 0.627451f, 0.866667f)

  lazy val PowderBlue: Color3f = Color3f(0.690196f, 0.878431f, 0.901961f)

  lazy val Purple: Color3f = Color3f(0.627451f, 0.12549f, 0.941176f)

  lazy val RebeccaPurple: Color3f = Color3f(0.4f, 0.2f, 0.6f)

  lazy val Red: Color3f = Color3f(1.0f, 0.0f, 0.0f)

  lazy val RosyBrown: Color3f = Color3f(0.737255f, 0.560784f, 0.560784f)

  lazy val RoyalBlue: Color3f = Color3f(0.254902f, 0.411765f, 0.882353f)

  lazy val SaddleBrown: Color3f = Color3f(0.545098f, 0.270588f, 0.0745098f)

  lazy val Salmon: Color3f = Color3f(0.980392f, 0.501961f, 0.447059f)

  lazy val SandyBrown: Color3f = Color3f(0.956863f, 0.643137f, 0.376471f)

  lazy val SeaGreen: Color3f = Color3f(0.180392f, 0.545098f, 0.341176f)

  lazy val Seashell: Color3f = Color3f(1.0f, 0.960784f, 0.933333f)

  lazy val Sienna: Color3f = Color3f(0.627451f, 0.321569f, 0.176471f)

  lazy val Silver: Color3f = Color3f(0.752941f, 0.752941f, 0.752941f)

  lazy val SkyBlue: Color3f = Color3f(0.529412f, 0.807843f, 0.921569f)

  lazy val SlateBlue: Color3f = Color3f(0.415686f, 0.352941f, 0.803922f)

  lazy val SlateGray: Color3f = Color3f(0.439216f, 0.501961f, 0.564706f)

  lazy val Snow: Color3f = Color3f(1.0f, 0.980392f, 0.980392f)

  lazy val SpringGreen: Color3f = Color3f(0.0f, 1.0f, 0.498039f)

  lazy val SteelBlue: Color3f = Color3f(0.27451f, 0.509804f, 0.705882f)

  lazy val Tan: Color3f = Color3f(0.823529f, 0.705882f, 0.54902f)

  lazy val Teal: Color3f = Color3f(0.0f, 0.501961f, 0.501961f)

  lazy val Thistle: Color3f = Color3f(0.847059f, 0.74902f, 0.847059f)

  lazy val Tomato: Color3f = Color3f(1.0f, 0.388235f, 0.278431f)

  lazy val Turquoise: Color3f = Color3f(0.25098f, 0.878431f, 0.815686f)

  lazy val Violet: Color3f = Color3f(0.933333f, 0.509804f, 0.933333f)

  lazy val WebGray: Color3f = Color3f(0.501961f, 0.501961f, 0.501961f)

  lazy val WebGreen: Color3f = Color3f(0.0f, 0.501961f, 0.0f)

  lazy val WebMaroon: Color3f = Color3f(0.501961f, 0.0f, 0.0f)

  lazy val WebPurple: Color3f = Color3f(0.501961f, 0.0f, 0.501961f)

  lazy val Wheat: Color3f = Color3f(0.960784f, 0.870588f, 0.701961f)

  lazy val White: Color3f = Color3f(1.0f, 1.0f, 1.0f)

  lazy val WhiteSmoke: Color3f = Color3f(0.960784f, 0.960784f, 0.960784f)

  lazy val Yellow: Color3f = Color3f(1.0f, 1.0f, 0.0f)

  lazy val YellowGreen: Color3f = Color3f(0.603922f, 0.803922f, 0.196078f)
}