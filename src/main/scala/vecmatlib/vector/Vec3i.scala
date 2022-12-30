package vecmatlib.vector

import vecmatlib.Int3

case class Vec3i(x: Int, y: Int, z: Int) extends Int3 with VecInt[Vec3i] with VecAsFloat[Vec3f] with VecAsDouble[Vec3d] {

  def +(x: Int, y: Int, z: Int): Vec3i = Vec3i(this.x + x, this.y + y, this.z + z)

  def plus(x: Int, y: Int, z: Int): Vec3i = this + (x, y, z)

  override def +(v: Vec3i): Vec3i = this + (v.x, v.y, v.z)

  def +(x: Float, y: Float, z: Float): Vec3f = Vec3f(this.x + x, this.y + y, this.z + z)

  def plus(x: Float, y: Float, z: Float): Vec3f = this + (x, y, z)

  def +(x: Double, y: Double, z: Double): Vec3d = Vec3d(this.x + x, this.y + y, this.z + z)

  def plus(x: Double, y: Double, z: Double): Vec3d = this + (x, y, z)

  override def unary_- : Vec3i = Vec3i(-this.x, -this.y, -this.z)

  def -(x: Int, y: Int, z: Int): Vec3i = this + (-x, -y, -z)

  def minus(x: Int, y: Int, z: Int): Vec3i = this - (x, y, z)

  def -(x: Float, y: Float, z: Float): Vec3f = this + (-x, -y, -z)

  def minus(x: Float, y: Float, z: Float): Vec3f = this - (x, y, z)

  def -(x: Double, y: Double, z: Double): Vec3d = this + (-x, -y, -z)

  def minus(x: Double, y: Double, z: Double): Vec3d = this - (x, y, z)

  override def *(k: Int): Vec3i = Vec3i(this.x * k, this.y * k, this.z * k)

  override def /(k: Int): Vec3i = Vec3i(this.x / k, this.y / k, this.z / k)

  def *(x: Int, y: Int, z: Int): Vec3i = Vec3i(this.x * x, this.y * y, this.z * z)

  def multiply(x: Int, y: Int, z: Int): Vec3i = this * (x, y, z)

  override def *(v: Vec3i): Vec3i = this * (v.x, v.y, v.z)

  def *(x: Float, y: Float, z: Float): Vec3f = Vec3f(this.x * x, this.y * y, this.z * z)

  def multiply(x: Float, y: Float, z: Float): Vec3f = this * (x, y, z)

  def *(x: Double, y: Double, z: Double): Vec3d = Vec3d(this.x * x, this.y * y, this.z * z)

  def multiply(x: Double, y: Double, z: Double): Vec3d = this * (x, y, z)

  def dot(x: Int, y: Int, z: Int): Int = this.x * x + this.y * y + this.z * z

  override def dot(v: Vec3i): Int = this.dot(v.x, v.y, v.z)

  def dot(x: Float, y: Float, z: Float): Float = this.x * x + this.y * y + this.z * z

  def dot(x: Double, y: Double, z: Double): Double = this.x * x + this.y * y + this.z * z

  def cross(x: Int, y: Int, z: Int): Vec3i = Vec3i(this.y * z - this.z * y, x * this.z - z * this.x, this.x * y - this.y * x)

  def cross(v: Vec3i): Vec3i = this.cross(v.x, v.y, v.z)

  def cross(x: Float, y: Float, z: Float): Vec3f = Vec3f(this.y * z - this.z * y, x * this.z - z * this.x, this.x * y - this.y * x)

  def cross(x: Double, y: Double, z: Double): Vec3d = Vec3d(this.y * z - this.z * y, x * this.z - z * this.x, this.x * y - this.y * x)

  def cross(v: Vec3f): Vec3f = this.cross(v.x, v.y, v.z)

  def cross(v: Vec3d): Vec3d = this.cross(v.x, v.y, v.z)

  override def lengthSquared: Int = this dot this

  override def toFloat: Vec3f = Vec3f(this.x.toFloat, this.y.toFloat, this.z.toFloat)

  override def toDouble: Vec3d = Vec3d(this.x.toDouble, this.y.toDouble, this.z.toDouble)

  def ==(x: Int, y: Int, z: Int): Boolean = this.x == x && this.y == y && this.z == z

  def equals(x: Int, y: Int, z: Int): Boolean = this == (x, y, z)
}
