package vecmatlib.vector

import vecmatlib.Double3

case class Vec3d(x: Double, y: Double, z: Double) extends Double3 with VecDouble[Vec3i, Vec3f, Vec3d] {

  def +(x: Double, y: Double, z: Double): Vec3d = Vec3d(this.x + x, this.y + y, this.z + z)

  def plus(x: Double, y: Double, z: Double): Vec3d = this + (x, y, z)

  override def +(v: Vec3i): Vec3d = this + (v.x, v.y, v.z)

  override def +(v: Vec3f): Vec3d = this + (v.x, v.y, v.z)

  override def +(v: Vec3d): Vec3d = this + (v.x, v.y, v.z)

  override def unary_- : Vec3d = Vec3d(-this.x, -this.y, -this.z)

  def -(x: Double, y: Double, z: Double): Vec3d = this + (-x, -y, -z)

  def minus(x: Double, y: Double, z: Double): Vec3d = this - (x, y, z)

  override def *(k: Double): Vec3d = Vec3d(this.x * k, this.y * k, this.z * k)

  def *(x: Double, y: Double, z: Double): Vec3d = Vec3d(this.x * x, this.y * y, this.z * z)

  def multiply(x: Double, y: Double, z: Double): Vec3d = this * (x, y, z)

  override def *(v: Vec3i): Vec3d = this * (v.x, v.y, v.z)

  override def *(v: Vec3f): Vec3d = this * (v.x, v.y, v.z)

  override def *(v: Vec3d): Vec3d = this * (v.x, v.y, v.z)

  override def dot(v: Vec3i): Double = this dot(v.x, v.y, v.z)

  override def dot(v: Vec3f): Double = this dot(v.x, v.y, v.z)

  def dot(x: Double, y: Double, z: Double): Double = this.x * x + this.y * y + this.z * z

  override def dot(v: Vec3d): Double = this dot(v.x, v.y, v.z)

  def cross(x: Double, y: Double, z: Double): Vec3d = Vec3d(this.y * z - this.z * y, x * this.z - z * this.x, this.x * y - this.y * x)

  def cross(v: Vec3i): Vec3d = this cross(v.x, v.y, v.z)

  def cross(v: Vec3f): Vec3d = this cross(v.x, v.y, v.z)

  def cross(v: Vec3d): Vec3d = this cross(v.x, v.y, v.z)

  override def lengthSquared: Double = this dot this

  def ==(x: Double, y: Double, z: Double): Boolean = this.x == x && this.y == y && this.z == z
}
