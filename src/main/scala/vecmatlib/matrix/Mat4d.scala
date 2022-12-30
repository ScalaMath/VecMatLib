package vecmatlib.matrix

import vecmatlib.vector.Vec4d

case class Mat4d(
                  m00: Double, m01: Double, m02: Double, m03: Double,
                  m10: Double, m11: Double, m12: Double, m13: Double,
                  m20: Double, m21: Double, m22: Double, m23: Double,
                  m30: Double, m31: Double, m32: Double, m33: Double
                ) extends MatDouble[Mat4d, Vec4d] {

  override def +(m: Mat4d): Mat4d = Mat4d(
    this.m00 + m.m00, this.m01 + m.m01, this.m02 + m.m02, this.m03 + m.m03,
    this.m10 + m.m10, this.m11 + m.m11, this.m12 + m.m12, this.m13 + m.m13,
    this.m20 + m.m20, this.m21 + m.m21, this.m22 + m.m22, this.m23 + m.m23,
    this.m30 + m.m30, this.m31 + m.m31, this.m32 + m.m32, this.m33 + m.m33
  )

  override def unary_- : Mat4d = Mat4d(
    -this.m00, -this.m01, -this.m02, -this.m03,
    -this.m10, -this.m11, -this.m12, -this.m13,
    -this.m20, -this.m21, -this.m22, -this.m23,
    -this.m30, -this.m31, -this.m32, -this.m33
  )

  override def *(k: Double): Mat4d = Mat4d(
    this.m00 * k, this.m01 * k, this.m02 * k, this.m03 * k,
    this.m10 * k, this.m11 * k, this.m12 * k, this.m13 * k,
    this.m20 * k, this.m21 * k, this.m22 * k, this.m23 * k,
    this.m30 * k, this.m31 * k, this.m32 * k, this.m33 * k
  )

  def row0: Vec4d = Vec4d(this.m00, this.m01, this.m02, this.m03)

  def row1: Vec4d = Vec4d(this.m10, this.m11, this.m12, this.m13)

  def row2: Vec4d = Vec4d(this.m20, this.m21, this.m22, this.m23)

  def row3: Vec4d = Vec4d(this.m30, this.m31, this.m32, this.m33)

  def col0: Vec4d = Vec4d(this.m00, this.m10, this.m20, this.m30)

  def col1: Vec4d = Vec4d(this.m01, this.m11, this.m21, this.m31)

  def col2: Vec4d = Vec4d(this.m02, this.m12, this.m22, this.m32)

  def col3: Vec4d = Vec4d(this.m03, this.m13, this.m23, this.m33)

  override def *(v: Vec4d): Vec4d = Vec4d(this.row0 dot v, this.row1 dot v, this.row2 dot v, this.row3 dot v)

  def *(x: Double, y: Double, z: Double, w: Double): Vec4d = this * Vec4d(x, y, z, w)

  def multiply(x: Double, y: Double, z: Double, w: Double): Vec4d = this * Vec4d(x, y, z, w)

  override def transposed: Mat4d = Mat4d(
    this.m00, this.m10, this.m20, this.m30,
    this.m01, this.m11, this.m21, this.m31,
    this.m02, this.m12, this.m22, this.m32,
    this.m03, this.m13, this.m23, this.m33
  )

  override def *(m: Mat4d): Mat4d = Mat4d(
    this.row0 dot m.col0, this.row0 dot m.col1, this.row0 dot m.col2, this.row0 dot m.col3,
    this.row1 dot m.col0, this.row1 dot m.col1, this.row1 dot m.col2, this.row1 dot m.col3,
    this.row2 dot m.col0, this.row2 dot m.col1, this.row2 dot m.col2, this.row2 dot m.col3,
    this.row3 dot m.col0, this.row3 dot m.col1, this.row3 dot m.col2, this.row3 dot m.col3
  )

  override def power(exp: Int): Mat4d = {
    if(exp < 0) {
      this.transposed.power(-exp)
    } else if(exp == 0) {
      Mat4d(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    } else {
      this * this.power(exp - 1)
    }
  }

  def toInt: Mat4i = Mat4i(
    this.m00.toInt, this.m01.toInt, this.m02.toInt, this.m03.toInt,
    this.m10.toInt, this.m11.toInt, this.m12.toInt, this.m13.toInt,
    this.m20.toInt, this.m21.toInt, this.m22.toInt, this.m23.toInt,
    this.m30.toInt, this.m31.toInt, this.m32.toInt, this.m33.toInt
  )

  def toFloat: Mat4f = Mat4f(
    this.m00.toFloat, this.m01.toFloat, this.m02.toFloat, this.m03.toFloat,
    this.m10.toFloat, this.m11.toFloat, this.m12.toFloat, this.m13.toFloat,
    this.m20.toFloat, this.m21.toFloat, this.m22.toFloat, this.m23.toFloat,
    this.m30.toFloat, this.m31.toFloat, this.m32.toFloat, this.m33.toFloat
  )
}
