package vecmatlib.matrix

import vecmatlib.vector.{Vec4d, Vec4f}

case class Mat4f(
                  m00: Float, m01: Float, m02: Float, m03: Float,
                  m10: Float, m11: Float, m12: Float, m13: Float,
                  m20: Float, m21: Float, m22: Float, m23: Float,
                  m30: Float, m31: Float, m32: Float, m33: Float
                ) extends MatFloat[Mat4f, Vec4f] with MatAsDouble[Mat4d, Vec4d] {

  override def +(m: Mat4f): Mat4f = Mat4f(
    this.m00 + m.m00, this.m01 + m.m01, this.m02 + m.m02, this.m03 + m.m03,
    this.m10 + m.m10, this.m11 + m.m11, this.m12 + m.m12, this.m13 + m.m13,
    this.m20 + m.m20, this.m21 + m.m21, this.m22 + m.m22, this.m23 + m.m23,
    this.m30 + m.m30, this.m31 + m.m31, this.m32 + m.m32, this.m33 + m.m33
  )

  override def unary_- : Mat4f = Mat4f(
    -this.m00, -this.m01, -this.m02, -this.m03,
    -this.m10, -this.m11, -this.m12, -this.m13,
    -this.m20, -this.m21, -this.m22, -this.m23,
    -this.m30, -this.m31, -this.m32, -this.m33
  )

  override def *(k: Float): Mat4f = Mat4f(
    this.m00 * k, this.m01 * k, this.m02 * k, this.m03 * k,
    this.m10 * k, this.m11 * k, this.m12 * k, this.m13 * k,
    this.m20 * k, this.m21 * k, this.m22 * k, this.m23 * k,
    this.m30 * k, this.m31 * k, this.m32 * k, this.m33 * k
  )

  def row0: Vec4f = Vec4f(this.m00, this.m01, this.m02, this.m03)

  def row1: Vec4f = Vec4f(this.m10, this.m11, this.m12, this.m13)

  def row2: Vec4f = Vec4f(this.m20, this.m21, this.m22, this.m23)

  def row3: Vec4f = Vec4f(this.m30, this.m31, this.m32, this.m33)

  def col0: Vec4f = Vec4f(this.m00, this.m10, this.m20, this.m30)

  def col1: Vec4f = Vec4f(this.m01, this.m11, this.m21, this.m31)

  def col2: Vec4f = Vec4f(this.m02, this.m12, this.m22, this.m32)

  def col3: Vec4f = Vec4f(this.m03, this.m13, this.m23, this.m33)

  override def *(v: Vec4f): Vec4f = Vec4f(this.row0 dot v, this.row1 dot v, this.row2 dot v, this.row3 dot v)

  def *(x: Float, y: Float, z: Float, w: Float): Vec4f = this * Vec4f(x, y, z, w)

  def multiply(x: Float, y: Float, z: Float, w: Float): Vec4f = this * Vec4f(x, y, z, w)

  def *(x: Double, y: Double, z: Double, w: Double): Vec4d = this * Vec4d(x, y, z, w)

  def multiply(x: Double, y: Double, z: Double, w: Double): Vec4d = this * Vec4d(x, y, z, w)

  override def transposed: Mat4f = Mat4f(
    this.m00, this.m10, this.m20, this.m30,
    this.m01, this.m11, this.m21, this.m31,
    this.m02, this.m12, this.m22, this.m32,
    this.m03, this.m13, this.m23, this.m33
  )

  override def *(m: Mat4f): Mat4f = Mat4f(
    this.row0 dot m.col0, this.row0 dot m.col1, this.row0 dot m.col2, this.row0 dot m.col3,
    this.row1 dot m.col0, this.row1 dot m.col1, this.row1 dot m.col2, this.row1 dot m.col3,
    this.row2 dot m.col0, this.row2 dot m.col1, this.row2 dot m.col2, this.row2 dot m.col3,
    this.row3 dot m.col0, this.row3 dot m.col1, this.row3 dot m.col2, this.row3 dot m.col3
  )

  override def power(exp: Int): Mat4f = {
    if(exp < 0) {
      this.transposed.power(-exp)
    } else if(exp == 0) {
      Mat4f.Identity
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

  override def toDouble: Mat4d = Mat4d(
    this.m00.toDouble, this.m01.toDouble, this.m02.toDouble, this.m03.toDouble,
    this.m10.toDouble, this.m11.toDouble, this.m12.toDouble, this.m13.toDouble,
    this.m20.toDouble, this.m21.toDouble, this.m22.toDouble, this.m23.toDouble,
    this.m30.toDouble, this.m31.toDouble, this.m32.toDouble, this.m33.toDouble
  )
}

object Mat4f {
  val Identity: Mat4f = Mat4f(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f)
  val Zero: Mat4f = Mat4f(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f)
}
