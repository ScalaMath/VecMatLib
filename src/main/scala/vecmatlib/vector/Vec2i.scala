package vecmatlib.vector

import vecmatlib.Int2

case class Vec2i(x: Int, y: Int) extends Int2 with VecInt[Vec2i, Vec2f, Vec2d] {

  def +(x: Int, y: Int): Vec2i = Vec2i(this.x + x, this.y + y)

  def plus(x: Int, y: Int): Vec2i = this + (x, y)

  def +(x: Float, y: Float): Vec2f = Vec2f(this.x + x, this.y + y)

  def plus(x: Float, y: Float): Vec2f = this + (x, y)

  def +(x: Double, y: Double): Vec2d = Vec2d(this.x + x, this.y + y)

  def plus(x: Double, y: Double): Vec2d = this + (x, y)

  override def +(v: Vec2i): Vec2i = this + (v.x, v.y)

  override def +(v: Vec2f): Vec2f = this + (v.x, v.y)

  override def +(v: Vec2d): Vec2d = this + (v.x, v.y)

  override def unary_- : Vec2i = Vec2i(-this.x, -this.y)

  def -(x: Int, y: Int): Vec2i = this + (-x, -y)

  def minus(x: Int, y: Int): Vec2i = this - (x, y)

  def -(x: Float, y: Float): Vec2f = this + (-x, -y)

  def minus(x: Float, y: Float): Vec2f = this - (x, y)

  def -(x: Double, y: Double): Vec2d = this + (-x, -y)

  def minus(x: Double, y: Double): Vec2d = this - (x, y)

  override def *(k: Int): Vec2i = Vec2i(this.x * k, this.y * k)

  override def *(k: Float): Vec2f = Vec2f(this.x * k, this.y * k)

  override def *(k: Double): Vec2d = Vec2d(this.x * k, this.y * k)

  override def /(k: Int): Vec2i = Vec2i(this.x / k, this.y / k)

  def *(x: Int, y: Int): Vec2i = Vec2i(this.x * x, this.y * y)

  def multiply(x: Int, y: Int): Vec2i = this * (x, y)

  def *(x: Float, y: Float): Vec2f = Vec2f(this.x * x, this.y * y)

  def multiply(x: Float, y: Float): Vec2f = this * (x, y)

  def *(x: Double, y: Double): Vec2d = Vec2d(this.x * x, this.y * y)

  def multiply(x: Double, y: Double): Vec2d = this * (x, y)

  override def *(v: Vec2i): Vec2i = this * (v.x, v.y)

  override def *(v: Vec2f): Vec2f = this * (v.x, v.y)

  override def *(v: Vec2d): Vec2d = this * (v.x, v.y)

  def dot(x: Int, y: Int): Int = this.x * x + this.y * y

  override def dot(v: Vec2i): Int = this dot (v.x, v.y)

  def dot(x: Float, y: Float): Float = this.x * x + this.y * y

  override def dot(v: Vec2f): Float = this dot (v.x, v.y)

  def dot(x: Double, y: Double): Double = this.x * x + this.y * y

  override def dot(v: Vec2d): Double = this dot (v.x, v.y)

  override def lengthSquared: Int = this dot this

  def ==(x: Int, y: Int): Boolean = this.x == x && this.y == y

  def equals(x: Int, y: Int): Boolean = this == (x, y)
}
