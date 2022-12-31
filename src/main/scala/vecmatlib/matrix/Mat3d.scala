package vecmatlib.matrix

import vecmatlib.vector.Vec3d

case class Mat3d(
                  m00: Double, m01: Double, m02: Double,
                  m10: Double, m11: Double, m12: Double,
                  m20: Double, m21: Double, m22: Double
                ) extends MatDouble[Mat3d, Vec3d] {

  override def +(m: Mat3d): Mat3d = Mat3d(
    this.m00 + m.m00, this.m01 + m.m01, this.m02 + m.m02,
    this.m10 + m.m10, this.m11 + m.m11, this.m12 + m.m12,
    this.m20 + m.m20, this.m21 + m.m21, this.m22 + m.m22
  )

  override def unary_- : Mat3d = Mat3d(
    -this.m00, -this.m01, -this.m02,
    -this.m10, -this.m11, -this.m12,
    -this.m20, -this.m21, -this.m22
  )

  override def *(k: Double): Mat3d = Mat3d(
    this.m00 * k, this.m01 * k, this.m02 * k,
    this.m10 * k, this.m11 * k, this.m12 * k,
    this.m20 * k, this.m21 * k, this.m22 * k
  )

  def row0: Vec3d = Vec3d(this.m00, this.m01, this.m02)

  def row1: Vec3d = Vec3d(this.m10, this.m11, this.m12)

  def row2: Vec3d = Vec3d(this.m20, this.m21, this.m22)

  def col0: Vec3d = Vec3d(this.m00, this.m10, this.m20)

  def col1: Vec3d = Vec3d(this.m01, this.m11, this.m21)

  def col2: Vec3d = Vec3d(this.m02, this.m12, this.m22)

  override def *(v: Vec3d): Vec3d = Vec3d(this.row0 dot v, this.row1 dot v, this.row2 dot v)

  def *(x: Double, y: Double, z: Double): Vec3d = this * Vec3d(x, y, z)

  def multiply(x: Double, y: Double, z: Double): Vec3d = this * Vec3d(x, y, z)

  override def transposed: Mat3d = Mat3d(
    this.m00, this.m10, this.m20,
    this.m01, this.m11, this.m21,
    this.m02, this.m12, this.m22
  )

  override def *(m: Mat3d): Mat3d = Mat3d(
    this.row0 dot m.col0, this.row0 dot m.col1, this.row0 dot m.col2,
    this.row1 dot m.col0, this.row1 dot m.col1, this.row1 dot m.col2,
    this.row2 dot m.col0, this.row2 dot m.col1, this.row2 dot m.col2
  )

  override def power(exp: Int): Mat3d = {
    if (exp < 0) {
      this.transposed.power(-exp)
    } else if (exp == 0) {
      Mat3d.Identity
    } else {
      this * this.power(exp - 1)
    }
  }
}

object Mat3d {
  val Identity: Mat3d = Mat3d(1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0)
  val Zero: Mat3d = Mat3d(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
}
