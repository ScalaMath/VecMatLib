package vecmatlib.vector

import vecmatlib.Double2

case class Vec2d(x: Double, y: Double) extends Double2 with VecDouble[Vec2i, Vec2f, Vec2d] {

  def +(x: Double, y: Double): Vec2d = Vec2d(this.x + x, this.y + y)

  def plus(x: Double, y: Double): Vec2d = this + (x, y)

  override def +(v: Vec2i): Vec2d = this + (v.x, v.y)

  override def +(v: Vec2f): Vec2d = this + (v.x, v.y)

  override def +(v: Vec2d): Vec2d = this + (v.x, v.y)

  override def unary_- : Vec2d = Vec2d(-this.x, -this.y)

  def -(x: Double, y: Double): Vec2d = this + (-x, -y)

  def minus(x: Double, y: Double): Vec2d = this - (x, y)

  override def *(k: Double): Vec2d = Vec2d(this.x * k, this.y * k)

  def *(x: Double, y: Double): Vec2d = Vec2d(this.x * x, this.y * y)

  def multiply(x: Double, y: Double): Vec2d = this * (x, y)

  override def *(v: Vec2i): Vec2d = this * (v.x, v.y)

  override def *(v: Vec2f): Vec2d = this * (v.x, v.y)

  override def *(v: Vec2d): Vec2d = this * (v.x, v.y)

  override def dot(v: Vec2i): Double = this dot(v.x, v.y)

  override def dot(v: Vec2f): Double = this dot(v.x, v.y)

  def dot(x: Double, y: Double): Double = this.x * x + this.y * y

  override def dot(v: Vec2d): Double = this dot(v.x, v.y)

  override def lengthSquared: Double = this dot this

  def ==(x: Double, y: Double): Boolean = this.x == x && this.y == y

  def equals(x: Double, y: Double): Boolean = this == (x, y)
}
