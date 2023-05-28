package io.github.hexagonnico.vecmatlib.matrix

import io.github.hexagonnico.vecmatlib.vector.Vec4i

/**
 * 4x4 int matrix.
 *
 * @param m00 Element 0 0
 * @param m01 Element 0 1
 * @param m02 Element 0 2
 * @param m03 Element 0 3
 * @param m10 Element 1 0
 * @param m11 Element 1 1
 * @param m12 Element 1 2
 * @param m13 Element 1 3
 * @param m20 Element 2 0
 * @param m21 Element 2 1
 * @param m22 Element 2 2
 * @param m23 Element 2 3
 * @param m30 Element 3 0
 * @param m31 Element 3 1
 * @param m32 Element 3 2
 * @param m33 Element 3 3
 */
case class Mat4i(
                  m00: Int, m01: Int, m02: Int, m03: Int,
                  m10: Int, m11: Int, m12: Int, m13: Int,
                  m20: Int, m21: Int, m22: Int, m23: Int,
                  m30: Int, m31: Int, m32: Int, m33: Int
                ) extends MatInt[Mat4i, Vec4i] {

  /**
   * Returns the sum between this matrix and the given one.
   *
   * @param m The matrix to add
   * @return The sum between this matrix and the given one
   */
  override def +(m: Mat4i): Mat4i = Mat4i(
    this.m00 + m.m00, this.m01 + m.m01, this.m02 + m.m02, this.m03 + m.m03,
    this.m10 + m.m10, this.m11 + m.m11, this.m12 + m.m12, this.m13 + m.m13,
    this.m20 + m.m20, this.m21 + m.m21, this.m22 + m.m22, this.m23 + m.m23,
    this.m30 + m.m30, this.m31 + m.m31, this.m32 + m.m32, this.m33 + m.m33
  )

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix
   */
  override def unary_- : Mat4i = Mat4i(
    -this.m00, -this.m01, -this.m02, -this.m03,
    -this.m10, -this.m11, -this.m12, -this.m13,
    -this.m20, -this.m21, -this.m22, -this.m23,
    -this.m30, -this.m31, -this.m32, -this.m33
  )

  /**
   * Returns the product of this matrix by the given scalar.
   *
   * @param k The scalar by which this matrix is multiplied
   * @return The product of this matrix by the given scalar
   */
  override def *(k: Int): Mat4i = Mat4i(
    this.m00 * k, this.m01 * k, this.m02 * k, this.m03 * k,
    this.m10 * k, this.m11 * k, this.m12 * k, this.m13 * k,
    this.m20 * k, this.m21 * k, this.m22 * k, this.m23 * k,
    this.m30 * k, this.m31 * k, this.m32 * k, this.m33 * k
  )

  /**
   * Returns the first row of this matrix as a 3d vector.
   *
   * @return The first row of this matrix as a 3d vector
   */
  def row0: Vec4i = Vec4i(this.m00, this.m01, this.m02, this.m03)

  /**
   * Returns the second row of this matrix as a 3d vector.
   *
   * @return The second row of this matrix as a 3d vector
   */
  def row1: Vec4i = Vec4i(this.m10, this.m11, this.m12, this.m13)

  /**
   * Returns the third row of this matrix as a 3d vector.
   *
   * @return The third row of this matrix as a 3d vector
   */
  def row2: Vec4i = Vec4i(this.m20, this.m21, this.m22, this.m23)

  /**
   * Returns the fourth row of this matrix as a 3d vector.
   *
   * @return The fourth row of this matrix as a 3d vector
   */
  def row3: Vec4i = Vec4i(this.m30, this.m31, this.m32, this.m33)

  /**
   * Returns the first column of this matrix as a 3d vector.
   *
   * @return The first column of this matrix as a 3d vector
   */
  def col0: Vec4i = Vec4i(this.m00, this.m10, this.m20, this.m30)

  /**
   * Returns the second column of this matrix as a 3d vector.
   *
   * @return The second column of this matrix as a 3d vector
   */
  def col1: Vec4i = Vec4i(this.m01, this.m11, this.m21, this.m31)

  /**
   * Returns the third column of this matrix as a 3d vector.
   *
   * @return The third column of this matrix as a 3d vector
   */
  def col2: Vec4i = Vec4i(this.m02, this.m12, this.m22, this.m32)

  /**
   * Returns the fourth column of this matrix as a 3d vector.
   *
   * @return The fourth column of this matrix as a 3d vector
   */
  def col3: Vec4i = Vec4i(this.m03, this.m13, this.m23, this.m33)

  /**
   * Returns the product of this matrix by the given vector.
   *
   * @param v The vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  override def *(v: Vec4i): Vec4i = Vec4i(this.row0 dot v, this.row1 dot v, this.row2 dot v, this.row3 dot v)

  /**
   * Returns the product of this matrix by the vector with the given components.
   *
   * @param x X component of the vector by which this matrix is multiplied
   * @param y Y component of the vector by which this matrix is multiplied
   * @param z Z component of the vector by which this matrix is multiplied
   * @return The product between this matrix and the vector with the given components
   */
  def *(x: Int, y: Int, z: Int, w: Int): Vec4i = this * Vec4i(x, y, z, w)

  /**
   * Returns the product of this matrix by the vector with the given components.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param x X component of the vector by which this matrix is multiplied
   * @param y Y component of the vector by which this matrix is multiplied
   * @param z Z component of the vector by which this matrix is multiplied
   * @return The product between this matrix and the vector with the given components
   */
  def multiply(x: Int, y: Int, z: Int, w: Int): Vec4i = this * Vec4i(x, y, z, w)

  /**
   * Returns the product between this matrix and the given one.
   *
   * @param m The matrix by which this one is multiplied
   * @return The product between this matrix and the given one
   */
  override def *(m: Mat4i): Mat4i = Mat4i(
    this.row0 dot m.col0, this.row0 dot m.col1, this.row0 dot m.col2, this.row0 dot m.col3,
    this.row1 dot m.col0, this.row1 dot m.col1, this.row1 dot m.col2, this.row1 dot m.col3,
    this.row2 dot m.col0, this.row2 dot m.col1, this.row2 dot m.col2, this.row2 dot m.col3,
    this.row3 dot m.col0, this.row3 dot m.col1, this.row3 dot m.col2, this.row3 dot m.col3
  )

  /**
   * Returns the transposed of this matrix.
   *
   * @return The transposed of this matrix
   */
  override def transposed: Mat4i = Mat4i(
    this.m00, this.m10, this.m20, this.m30,
    this.m01, this.m11, this.m21, this.m31,
    this.m02, this.m12, this.m22, this.m32,
    this.m03, this.m13, this.m23, this.m33
  )

  /**
   * Returns this matrix to the power of the given exponent.
   *
   * @param exp The exponent
   * @return This matrix raised to the power of the given exponent
   */
  override def power(exp: Int): Mat4i = {
    if (exp < 0) {
      this.transposed.power(-exp)
    } else if (exp == 0) {
      Mat4i.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  /**
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix
   */
  override def determinant: Int = this.m00 * Mat3i(
    this.m11, this.m12, this.m13,
    this.m21, this.m22, this.m23,
    this.m31, this.m32, this.m33
  ).determinant - this.m01 * Mat3i(
    this.m10, this.m12, this.m13,
    this.m20, this.m22, this.m23,
    this.m30, this.m32, this.m33
  ).determinant + this.m02 * Mat3i(
    this.m10, this.m11, this.m13,
    this.m20, this.m21, this.m23,
    this.m30, this.m31, this.m33
  ).determinant - this.m03 * Mat3i(
    this.m10, this.m11, this.m12,
    this.m20, this.m21, this.m22,
    this.m30, this.m31, this.m32
  ).determinant
}

object Mat4i {
  /** Shorthand for an identity matrix */
  val Identity: Mat4i = Mat4i(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1)
  /** Shorthand for the zero matrix */
  val Zero: Mat4i = Mat4i(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
}
