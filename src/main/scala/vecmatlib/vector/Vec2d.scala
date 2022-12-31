package vecmatlib.vector

import vecmatlib.Double2

case class Vec2d(x: Double, y: Double) extends Double2 with VecDouble[Vec2d] {

  def +(x: Double, y: Double): Vec2d = Vec2d(this.x + x, this.y + y)

  def plus(x: Double, y: Double): Vec2d = this + (x, y)

  override def +(v: Vec2d): Vec2d = this + (v.x, v.y)

  override def unary_- : Vec2d = Vec2d(-this.x, -this.y)

  def -(x: Double, y: Double): Vec2d = this + (-x, -y)

  def minus(x: Double, y: Double): Vec2d = this - (x, y)

  override def *(k: Double): Vec2d = Vec2d(this.x * k, this.y * k)

  def *(x: Double, y: Double): Vec2d = Vec2d(this.x * x, this.y * y)

  def multiply(x: Double, y: Double): Vec2d = this * (x, y)

  override def *(v: Vec2d): Vec2d = this * (v.x, v.y)

  def dot(x: Double, y: Double): Double = this.x * x + this.y * y

  override def dot(v: Vec2d): Double = this.dot(v.x, v.y)

  override def lengthSquared: Double = this dot this

  def toInt: Vec2i = Vec2i(this.x.toInt, this.y.toInt)

  def toFloat: Vec2f = Vec2f(this.x.toFloat, this.y.toFloat)

  def ==(x: Double, y: Double): Boolean = this.x == x && this.y == y

  def equals(x: Double, y: Double): Boolean = this == (x, y)
}

object Vec2d {
  val Zero: Vec2d = Vec2d(0.0, 0.0)
  val One: Vec2d = Vec2d(1.0, 1.0)
  val Right: Vec2d = Vec2d(1.0, 0.0)
  val Left: Vec2d = Vec2d(-1.0, 0.0)
  val Up: Vec2d = Vec2d(0.0, 1.0)
  val Down: Vec2d = Vec2d(0.0, -1.0)
}
