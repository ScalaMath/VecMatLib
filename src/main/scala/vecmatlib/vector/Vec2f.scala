package vecmatlib.vector

import vecmatlib.Float2

case class Vec2f(x: Float, y: Float) extends Float2 with VecFloat[Vec2i, Vec2f, Vec2d] {

  def +(x: Float, y: Float): Vec2f = Vec2f(this.x + x, this.y + y)

  def plus(x: Float, y: Float): Vec2f = this + (x, y)

  def +(x: Double, y: Double): Vec2d = Vec2d(this.x + x, this.y + y)

  def plus(x: Double, y: Double): Vec2d = this + (x, y)

  override def +(v: Vec2i): Vec2f = this + (v.x.toFloat, v.y.toFloat)

  override def +(v: Vec2f): Vec2f = this + (v.x, v.y)

  override def +(v: Vec2d): Vec2d = this + (v.x, v.y)

  override def unary_- : Vec2f = Vec2f(-this.x, -this.y)

  def -(x: Float, y: Float): Vec2f = this + (-x, -y)

  def minus(x: Float, y: Float): Vec2f = this - (x, y)

  def -(x: Double, y: Double): Vec2d = this + (-x, -y)

  def minus(x: Double, y: Double): Vec2d = this - (x, y)

  override def *(k: Float): Vec2f = Vec2f(this.x * k, this.y * k)

  override def *(k: Double): Vec2d = Vec2d(this.x * k, this.y * k)

  def *(x: Float, y: Float): Vec2f = Vec2f(this.x * x, this.y * y)

  def multiply(x: Float, y: Float): Vec2f = this * (x, y)

  def *(x: Double, y: Double): Vec2d = Vec2d(this.x * x, this.y * y)

  def multiply(x: Double, y: Double): Vec2d = this * (x, y)

  override def *(v: Vec2i): Vec2f = this * (v.x.toFloat, v.y.toFloat)

  override def *(v: Vec2f): Vec2f = this * (v.x, v.y)

  override def *(v: Vec2d): Vec2d = this * (v.x, v.y)

  def dot(x: Float, y: Float): Float = this.x * x + this.y * y

  override def dot(v: Vec2i): Float = this dot(v.x.toFloat, v.y.toFloat)

  override def dot(v: Vec2f): Float = this dot(v.x, v.y)

  def dot(x: Double, y: Double): Double = this.x * x + this.y * y

  override def dot(v: Vec2d): Double = this dot(v.x, v.y)

  override def lengthSquared: Float = this dot this

  def ==(x: Float, y: Float): Boolean = this.x == x && this.y == y

  def equals(x: Float, y: Float): Boolean = this == (x, y)
}
