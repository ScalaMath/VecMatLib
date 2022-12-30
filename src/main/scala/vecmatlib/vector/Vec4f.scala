package vecmatlib.vector

import vecmatlib.Float4

case class Vec4f(x: Float, y: Float, z: Float, w: Float) extends Float4 with VecFloat[Vec4i, Vec4f, Vec4d] {

  def +(x: Float, y: Float, z: Float, w: Float): Vec4f = Vec4f(this.x + x, this.y + y, this.z + z, this.w + w)

  def plus(x: Float, y: Float, z: Float, w: Float): Vec4f = this + (x, y, z, w)

  def +(x: Double, y: Double, z: Double, w: Double): Vec4d = Vec4d(this.x + x, this.y + y, this.z + z, this.w + w)

  def plus(x: Double, y: Double, z: Double, w: Double): Vec4d = this + (x, y, z, w)

  override def +(v: Vec4i): Vec4f = this + (v.x.toFloat, v.y.toFloat, v.z.toFloat, v.w.toFloat)

  override def +(v: Vec4f): Vec4f = this + (v.x, v.y, v.z, v.w)

  override def +(v: Vec4d): Vec4d = this + (v.x, v.y, v.z, v.w)

  override def unary_- : Vec4f = Vec4f(-this.x, -this.y, -this.z, -this.w)

  def -(x: Float, y: Float, z: Float, w: Float): Vec4f = this + (-x, -y, -z, -w)

  def minus(x: Float, y: Float, z: Float, w: Float): Vec4f = this - (x, y, z, w)

  def -(x: Double, y: Double, z: Double, w: Double): Vec4d = this + (-x, -y, -z, -w)

  def minus(x: Double, y: Double, z: Double, w: Double): Vec4d = this - (x, y, z, w)

  override def *(k: Float): Vec4f = Vec4f(this.x * k, this.y * k, this.z * k, this.w * k)

  override def *(k: Double): Vec4d = Vec4d(this.x * k, this.y * k, this.z * k, this.w * k)

  def *(x: Float, y: Float, z: Float, w: Float): Vec4f = Vec4f(this.x * x, this.y * y, this.z * z, this.w * w)

  def multiply(x: Float, y: Float, z: Float, w: Float): Vec4f = this * (x, y, z, w)

  def *(x: Double, y: Double, z: Double, w: Double): Vec4d = Vec4d(this.x * x, this.y * y, this.z * z, this.w * w)

  def multiply(x: Double, y: Double, z: Double, w: Double): Vec4d = this * (x, y, z, w)

  override def *(v: Vec4i): Vec4f = this * (v.x.toFloat, v.y.toFloat, v.z.toFloat, v.w.toFloat)

  override def *(v: Vec4f): Vec4f = this * (v.x, v.y, v.z, v.w)

  override def *(v: Vec4d): Vec4d = this * (v.x, v.y, v.z, v.w)

  def dot(x: Float, y: Float, z: Float, w: Float): Float = this.x * x + this.y * y + this.z * z + this.w * w

  override def dot(v: Vec4i): Float = this dot(v.x.toFloat, v.y.toFloat, v.z.toFloat, v.w.toFloat)

  override def dot(v: Vec4f): Float = this dot(v.x, v.y, v.z, v.w)

  def dot(x: Double, y: Double, z: Double, w: Double): Double = this.x * x + this.y * y + this.z * z + this.w * w

  override def dot(v: Vec4d): Double = this dot(v.x, v.y, v.z, v.w)

  override def lengthSquared: Float = this dot this

  def ==(x: Float, y: Float, z: Float, w: Float): Boolean = this.x == x && this.y == y && this.z == z && this.w == w

  def equals(x: Float, y: Float, z: Float, w: Float): Boolean = this == (x, y, z, w)
}
