package vecmatlib.color

import vecmatlib.Float4

case class Color(r: Float, g: Float, b: Float, a: Float = 1.0f) extends Float4 {

  def +(r: Float, g: Float, b: Float, a: Float = 0.0f): Color = Color(this.r + r, this.g + g, this.b + b, this.a + a)

  def +(c: Color): Color = this + (c.r, c.g, c.b, c.a)

  def add(r: Float, g: Float, b: Float, a: Float = 0.0f): Color = this + (r, g, b, a)

  def add(c: Color): Color = this + c

  def -(r: Float, g: Float, b: Float, a: Float = 0.0f): Color = Color(this.r - r, this.g - g, this.b - b, this.a - a)

  def -(c: Color): Color = this - (c.r, c.g, c.b, c.a)

  def subtract(r: Float, g: Float, b: Float, a: Float = 0.0f): Color = this - (r, g, b, a)

  def subtract(c: Color): Color = this - c

  def *(r: Float, g: Float, b: Float, a: Float = 1.0f): Color = Color(this.r * r, this.g * g, this.b * b, this.a * a)

  def *(c: Color): Color = this * (c.r, c.g, c.g, c.a)

  def multiply(r: Float, g: Float, b: Float, a: Float = 1.0f): Color = this * (r, g, b, a)

  def multiply(c: Color): Color = this * c

  def *(k: Float): Color = this * (k, k, k, k)

  def multiply(k: Float): Color = this * k

  def blend(r: Float, g: Float, b: Float): Color = this * (r, g, b, 1.0f)

  def blend(c: Color): Color = this.blend(c.r, c.g, c.b)

  def invert: Color = Color(1.0f - this.r, 1.0f - this.g, 1.0f - this.b, this.a)

  def darker(k: Float): Color = this * (1.0f - k)

  def lighter(k: Float): Color = this * (this.invert * k)

  def lerp(to: Color, weight: Float): Color = (this * (1.0f - weight)) + (to * weight)

  override def x: Float = this.r

  override def y: Float = this.g

  override def z: Float = this.b

  override def w: Float = this.a
}
