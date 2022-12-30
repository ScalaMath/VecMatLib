package vecmatlib.vector

import vecmatlib.Double4

case class Vec4d(x: Double, y: Double, z: Double, w: Double) extends Double4 with VecDouble[Vec4i, Vec4f, Vec4d] {

  def +(x: Double, y: Double, z: Double, w: Double): Vec4d = Vec4d(this.x + x, this.y + y, this.z + z, this.w + w)

  def plus(x: Double, y: Double, z: Double, w: Double): Vec4d = this + (x, y, z, w)

  override def +(v: Vec4i): Vec4d = this + (v.x, v.y, v.z, v.w)

  override def +(v: Vec4f): Vec4d = this + (v.x, v.y, v.z, v.w)

  override def +(v: Vec4d): Vec4d = this + (v.x, v.y, v.z, v.w)

  override def unary_- : Vec4d = Vec4d(-this.x, -this.y, -this.z, -this.w)

  def -(x: Double, y: Double, z: Double, w: Double): Vec4d = this + (-x, -y, -z, -w)

  def minus(x: Double, y: Double, z: Double, w: Double): Vec4d = this - (x, y, z, w)

  override def *(k: Double): Vec4d = Vec4d(this.x * k, this.y * k, this.z * k, this.w * k)

  def *(x: Double, y: Double, z: Double, w: Double): Vec4d = Vec4d(this.x * x, this.y * y, this.z * z, this.w * w)

  def multiply(x: Double, y: Double, z: Double, w: Double): Vec4d = this * (x, y, z, w)

  override def *(v: Vec4i): Vec4d = this * (v.x, v.y, v.z, v.w)

  override def *(v: Vec4f): Vec4d = this * (v.x, v.y, v.z, v.w)

  override def *(v: Vec4d): Vec4d = this * (v.x, v.y, v.z, v.w)

  override def dot(v: Vec4i): Double = this dot(v.x, v.y, v.z, v.w)

  override def dot(v: Vec4f): Double = this dot(v.x, v.y, v.z, v.w)

  def dot(x: Double, y: Double, z: Double, w: Double): Double = this.x * x + this.y * y + this.z * z + this.w * w

  override def dot(v: Vec4d): Double = this dot(v.x, v.y, v.z, v.w)

  override def lengthSquared: Double = this dot this

  def ==(x: Double, y: Double, z: Double, w: Double): Boolean = this.x == x && this.y == y && this.z == z && this.w == w

  def equals(x: Double, y: Double, z: Double, w: Double): Boolean = this == (x, y, z, w)
}
