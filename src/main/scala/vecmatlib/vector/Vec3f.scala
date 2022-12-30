package vecmatlib.vector

import vecmatlib.Float3

case class Vec3f(x: Float, y: Float, z: Float) extends Float3 with VecFloat[Vec3i, Vec3f, Vec3d] {

  def +(x: Float, y: Float, z: Float): Vec3f = Vec3f(this.x + x, this.y + y, this.z + z)

  def plus(x: Float, y: Float, z: Float): Vec3f = this + (x, y, z)

  def +(x: Double, y: Double, z: Double): Vec3d = Vec3d(this.x + x, this.y + y, this.z + z)

  def plus(x: Double, y: Double, z: Double): Vec3d = this + (x, y, z)

  override def +(v: Vec3i): Vec3f = this + (v.x.toFloat, v.y.toFloat, v.z.toFloat)

  override def +(v: Vec3f): Vec3f = this + (v.x, v.y, v.z)

  override def +(v: Vec3d): Vec3d = this + (v.x, v.y, v.z)

  override def unary_- : Vec3f = Vec3f(-this.x, -this.y, -this.z)

  def -(x: Float, y: Float, z: Float): Vec3f = this + (-x, -y, -z)

  def minus(x: Float, y: Float, z: Float): Vec3f = this - (x, y, z)

  def -(x: Double, y: Double, z: Double): Vec3d = this + (-x, -y, -z)

  def minus(x: Double, y: Double, z: Double): Vec3d = this - (x, y, z)

  override def *(k: Float): Vec3f = Vec3f(this.x * k, this.y * k, this.z * k)

  override def *(k: Double): Vec3d = Vec3d(this.x * k, this.y * k, this.z * k)

  def *(x: Float, y: Float, z: Float): Vec3f = Vec3f(this.x * x, this.y * y, this.z * z)

  def multiply(x: Float, y: Float, z: Float): Vec3f = this * (x, y, z)

  def *(x: Double, y: Double, z: Double): Vec3d = Vec3d(this.x * x, this.y * y, this.z * z)

  def multiply(x: Double, y: Double, z: Double): Vec3d = this * (x, y, z)

  override def *(v: Vec3i): Vec3f = this * (v.x.toFloat, v.y.toFloat, v.z.toFloat)

  override def *(v: Vec3f): Vec3f = this * (v.x, v.y, v.z)

  override def *(v: Vec3d): Vec3d = this * (v.x, v.y, v.z)

  def dot(x: Float, y: Float, z: Float): Float = this.x * x + this.y * y + this.z * z

  override def dot(v: Vec3i): Float = this dot(v.x.toFloat, v.y.toFloat, v.z.toFloat)

  override def dot(v: Vec3f): Float = this dot(v.x, v.y, v.z)

  def dot(x: Double, y: Double, z: Double): Double = this.x * x + this.y * y + this.z * z

  override def dot(v: Vec3d): Double = this dot(v.x, v.y, v.z)

  def cross(x: Float, y: Float, z: Float): Vec3f = Vec3f(this.y * z - this.z * y, x * this.z - z * this.x, this.x * y - this.y * x)

  def cross(x: Double, y: Double, z: Double): Vec3d = Vec3d(this.y * z - this.z * y, x * this.z - z * this.x, this.x * y - this.y * x)

  def cross(v: Vec3i): Vec3f = this cross(v.x.toFloat, v.y.toFloat, v.z.toFloat)

  def cross(v: Vec3f): Vec3f = this cross(v.x, v.y, v.z)

  def cross(v: Vec3d): Vec3d = this cross(v.x, v.y, v.z)

  override def lengthSquared: Float = this dot this

  def ==(x: Float, y: Float, z: Float): Boolean = this.x == x && this.y == y && this.z == z

  def equals(x: Float, y: Float, z: Float): Boolean = this == (x, y, z)
}
