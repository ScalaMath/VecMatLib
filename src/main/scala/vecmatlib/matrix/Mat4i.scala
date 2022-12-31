package vecmatlib.matrix

import vecmatlib.matrix.Mat4i.Identity
import vecmatlib.vector.{Vec4d, Vec4f, Vec4i}

case class Mat4i(
                  m00: Int, m01: Int, m02: Int, m03: Int,
                  m10: Int, m11: Int, m12: Int, m13: Int,
                  m20: Int, m21: Int, m22: Int, m23: Int,
                  m30: Int, m31: Int, m32: Int, m33: Int
                ) extends MatInt[Mat4i, Vec4i] with MatAsFloat[Mat4f, Vec4f] with MatAsDouble[Mat4d, Vec4d] {

  override def +(m: Mat4i): Mat4i = Mat4i(
    this.m00 + m.m00, this.m01 + m.m01, this.m02 + m.m02, this.m03 + m.m03,
    this.m10 + m.m10, this.m11 + m.m11, this.m12 + m.m12, this.m13 + m.m13,
    this.m20 + m.m20, this.m21 + m.m21, this.m22 + m.m22, this.m23 + m.m23,
    this.m30 + m.m30, this.m31 + m.m31, this.m32 + m.m32, this.m33 + m.m33
  )

  override def unary_- : Mat4i = Mat4i(
    -this.m00, -this.m01, -this.m02, -this.m03,
    -this.m10, -this.m11, -this.m12, -this.m13,
    -this.m20, -this.m21, -this.m22, -this.m23,
    -this.m30, -this.m31, -this.m32, -this.m33
  )

  override def *(k: Int): Mat4i = Mat4i(
    this.m00 * k, this.m01 * k, this.m02 * k, this.m03 * k,
    this.m10 * k, this.m11 * k, this.m12 * k, this.m13 * k,
    this.m20 * k, this.m21 * k, this.m22 * k, this.m23 * k,
    this.m30 * k, this.m31 * k, this.m32 * k, this.m33 * k
  )

  def row0: Vec4i = Vec4i(this.m00, this.m01, this.m02, this.m03)

  def row1: Vec4i = Vec4i(this.m10, this.m11, this.m12, this.m13)

  def row2: Vec4i = Vec4i(this.m20, this.m21, this.m22, this.m23)

  def row3: Vec4i = Vec4i(this.m30, this.m31, this.m32, this.m33)

  def col0: Vec4i = Vec4i(this.m00, this.m10, this.m20, this.m30)

  def col1: Vec4i = Vec4i(this.m01, this.m11, this.m21, this.m31)

  def col2: Vec4i = Vec4i(this.m02, this.m12, this.m22, this.m32)

  def col3: Vec4i = Vec4i(this.m03, this.m13, this.m23, this.m33)

  override def *(v: Vec4i): Vec4i = Vec4i(this.row0 dot v, this.row1 dot v, this.row2 dot v, this.row3 dot v)

  def *(x: Int, y: Int, z: Int, w: Int): Vec4i = this * Vec4i(x, y, z, w)

  def multiply(x: Int, y: Int, z: Int, w: Int): Vec4i = this * Vec4i(x, y, z, w)

  override def transposed: Mat4i = Mat4i(
    this.m00, this.m10, this.m20, this.m30,
    this.m01, this.m11, this.m21, this.m31,
    this.m02, this.m12, this.m22, this.m32,
    this.m03, this.m13, this.m23, this.m33
  )

  override def *(m: Mat4i): Mat4i = Mat4i(
    this.row0 dot m.col0, this.row0 dot m.col1, this.row0 dot m.col2, this.row0 dot m.col3,
    this.row1 dot m.col0, this.row1 dot m.col1, this.row1 dot m.col2, this.row1 dot m.col3,
    this.row2 dot m.col0, this.row2 dot m.col1, this.row2 dot m.col2, this.row2 dot m.col3,
    this.row3 dot m.col0, this.row3 dot m.col1, this.row3 dot m.col2, this.row3 dot m.col3
  )

  override def power(exp: Int): Mat4i = {
    if (exp < 0) {
      this.transposed.power(-exp)
    } else if (exp == 0) {
      Mat4i.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  override def toFloat: Mat4f = Mat4f(
    this.m00.toFloat, this.m01.toFloat, this.m02.toFloat, this.m03.toFloat,
    this.m10.toFloat, this.m11.toFloat, this.m12.toFloat, this.m13.toFloat,
    this.m20.toFloat, this.m21.toFloat, this.m22.toFloat, this.m23.toFloat,
    this.m30.toFloat, this.m31.toFloat, this.m32.toFloat, this.m33.toFloat
  )

  override def toDouble: Mat4d = Mat4d(
    this.m00.toDouble, this.m01.toDouble, this.m02.toDouble, this.m03.toDouble,
    this.m10.toDouble, this.m11.toDouble, this.m12.toDouble, this.m13.toDouble,
    this.m20.toDouble, this.m21.toDouble, this.m22.toDouble, this.m23.toDouble,
    this.m30.toDouble, this.m31.toDouble, this.m32.toDouble, this.m33.toDouble
  )
}

object Mat4i {
  val Identity: Mat4i = Mat4i(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1)
  val Zero: Mat4i = Mat4i(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
}
