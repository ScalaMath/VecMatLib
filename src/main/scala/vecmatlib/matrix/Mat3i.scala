package vecmatlib.matrix

import vecmatlib.vector.{Vec3d, Vec3f, Vec3i}

case class Mat3i(
                  m00: Int, m01: Int, m02: Int,
                  m10: Int, m11: Int, m12: Int,
                  m20: Int, m21: Int, m22: Int
                ) extends MatInt[Mat3i, Vec3i] with MatAsFloat[Mat3f, Vec3f] with MatAsDouble[Mat3d, Vec3d] {

  override def +(m: Mat3i): Mat3i = Mat3i(
    this.m00 + m.m00, this.m01 + m.m01, this.m02 + m.m02,
    this.m10 + m.m10, this.m11 + m.m11, this.m12 + m.m12,
    this.m20 + m.m20, this.m21 + m.m21, this.m22 + m.m22
  )

  override def unary_- : Mat3i = Mat3i(
    -this.m00, -this.m01, -this.m02,
    -this.m10, -this.m11, -this.m12,
    -this.m20, -this.m21, -this.m22
  )

  override def *(k: Int): Mat3i = Mat3i(
    this.m00 * k, this.m01 * k, this.m02 * k,
    this.m10 * k, this.m11 * k, this.m12 * k,
    this.m20 * k, this.m21 * k, this.m22 * k
  )

  def row0: Vec3i = Vec3i(this.m00, this.m01, this.m02)

  def row1: Vec3i = Vec3i(this.m10, this.m11, this.m12)

  def row2: Vec3i = Vec3i(this.m20, this.m21, this.m22)

  def col0: Vec3i = Vec3i(this.m00, this.m10, this.m20)

  def col1: Vec3i = Vec3i(this.m01, this.m11, this.m21)

  def col2: Vec3i = Vec3i(this.m02, this.m12, this.m22)

  override def *(v: Vec3i): Vec3i = Vec3i(this.row0 dot v, this.row1 dot v, this.row2 dot v)

  def *(x: Int, y: Int, z: Int): Vec3i = this * Vec3i(x, y, z)

  def multiply(x: Int, y: Int, z: Int): Vec3i = this * Vec3i(x, y, z)

  def *(x: Float, y: Float, z: Float): Vec3f = this * Vec3f(x, y, z)

  def multiply(x: Float, y: Float, z: Float): Vec3f = this * Vec3f(x, y, z)

  def *(x: Double, y: Double, z: Double): Vec3d = this * Vec3d(x, y, z)

  def multiply(x: Double, y: Double, z: Double): Vec3d = this * Vec3d(x, y, z)

  override def transposed: Mat3i = Mat3i(
    this.m00, this.m10, this.m20,
    this.m01, this.m11, this.m21,
    this.m02, this.m12, this.m22
  )

  override def *(m: Mat3i): Mat3i = Mat3i(
    this.row0 dot m.col0, this.row0 dot m.col1, this.row0 dot m.col2,
    this.row1 dot m.col0, this.row1 dot m.col1, this.row1 dot m.col2,
    this.row2 dot m.col0, this.row2 dot m.col1, this.row2 dot m.col2
  )

  override def power(exp: Int): Mat3i = {
    if (exp < 0) {
      this.transposed.power(-exp)
    } else if (exp == 0) {
      Mat3i.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  override def toFloat: Mat3f = Mat3f(
    this.m00.toFloat, this.m01.toFloat, this.m02.toFloat,
    this.m10.toFloat, this.m11.toFloat, this.m12.toFloat,
    this.m20.toFloat, this.m21.toFloat, this.m22.toFloat
  )

  override def toDouble: Mat3d = Mat3d(
    this.m00.toDouble, this.m01.toDouble, this.m02.toDouble,
    this.m10.toDouble, this.m11.toDouble, this.m12.toDouble,
    this.m20.toDouble, this.m21.toDouble, this.m22.toDouble
  )
}

object Mat3i {
  val Identity: Mat3i = Mat3i(1, 0, 0, 0, 1, 0, 0, 0, 1)
  val Zero: Mat3i = Mat3i(0, 0, 0, 0, 0, 0, 0, 0, 0)
}
