package io.github.hexagonnico.vecmatlib.matrix

import io.github.hexagonnico.vecmatlib.vector.Vec3i

/**
 * 3x3 int matrix.
 *
 * @param m00 Element 0 0
 * @param m01 Element 0 1
 * @param m02 Element 0 2
 * @param m10 Element 1 0
 * @param m11 Element 1 1
 * @param m12 Element 1 2
 * @param m20 Element 2 0
 * @param m21 Element 2 1
 * @param m22 Element 2 2
 */
case class Mat3i(
                  m00: Int, m01: Int, m02: Int,
                  m10: Int, m11: Int, m12: Int,
                  m20: Int, m21: Int, m22: Int
                ) extends MatInt[Mat3i, Vec3i] {

  /**
   * Returns the sum between this matrix and the given one.
   *
   * @param m The matrix to add
   * @return The sum between this matrix and the given one
   */
  override def +(m: Mat3i): Mat3i = Mat3i(
    this.m00 + m.m00, this.m01 + m.m01, this.m02 + m.m02,
    this.m10 + m.m10, this.m11 + m.m11, this.m12 + m.m12,
    this.m20 + m.m20, this.m21 + m.m21, this.m22 + m.m22
  )

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix
   */
  override def unary_- : Mat3i = Mat3i(
    -this.m00, -this.m01, -this.m02,
    -this.m10, -this.m11, -this.m12,
    -this.m20, -this.m21, -this.m22
  )

  /**
   * Returns the product of this matrix by the given scalar.
   *
   * @param k The scalar by which this matrix is multiplied
   * @return The product of this matrix by the given scalar
   */
  override def *(k: Int): Mat3i = Mat3i(
    this.m00 * k, this.m01 * k, this.m02 * k,
    this.m10 * k, this.m11 * k, this.m12 * k,
    this.m20 * k, this.m21 * k, this.m22 * k
  )

  /**
   * Returns the first row of this matrix as a 3d vector.
   *
   * @return The first row of this matrix as a 3d vector
   */
  def row0: Vec3i = Vec3i(this.m00, this.m01, this.m02)

  /**
   * Returns the second row of this matrix as a 3d vector.
   *
   * @return The second row of this matrix as a 3d vector
   */
  def row1: Vec3i = Vec3i(this.m10, this.m11, this.m12)

  /**
   * Returns the third row of this matrix as a 3d vector.
   *
   * @return The third row of this matrix as a 3d vector
   */
  def row2: Vec3i = Vec3i(this.m20, this.m21, this.m22)

  /**
   * Returns the first column of this matrix as a 3d vector.
   *
   * @return The first column of this matrix as a 3d vector
   */
  def col0: Vec3i = Vec3i(this.m00, this.m10, this.m20)

  /**
   * Returns the second column of this matrix as a 3d vector.
   *
   * @return The second column of this matrix as a 3d vector
   */
  def col1: Vec3i = Vec3i(this.m01, this.m11, this.m21)

  /**
   * Returns the third column of this matrix as a 3d vector.
   *
   * @return The third column of this matrix as a 3d vector
   */
  def col2: Vec3i = Vec3i(this.m02, this.m12, this.m22)

  /**
   * Returns the product of this matrix by the given vector.
   *
   * @param v The vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  override def *(v: Vec3i): Vec3i = Vec3i(this.row0 dot v, this.row1 dot v, this.row2 dot v)

  /**
   * Returns the product of this matrix by the vector with the given components.
   *
   * @param x X component of the vector by which this matrix is multiplied
   * @param y Y component of the vector by which this matrix is multiplied
   * @param z Z component of the vector by which this matrix is multiplied
   * @return The product between this matrix and the vector with the given components
   */
  def *(x: Int, y: Int, z: Int): Vec3i = this * Vec3i(x, y, z)

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
  def multiply(x: Int, y: Int, z: Int): Vec3i = this * Vec3i(x, y, z)

  /**
   * Returns the product between this matrix and the given one.
   *
   * @param m The matrix by which this one is multiplied
   * @return The product between this matrix and the given one
   */
  override def *(m: Mat3i): Mat3i = Mat3i(
    this.row0 dot m.col0, this.row0 dot m.col1, this.row0 dot m.col2,
    this.row1 dot m.col0, this.row1 dot m.col1, this.row1 dot m.col2,
    this.row2 dot m.col0, this.row2 dot m.col1, this.row2 dot m.col2
  )

  /**
   * Returns the transposed of this matrix.
   *
   * @return The transposed of this matrix
   */
  override def transposed: Mat3i = Mat3i(
    this.m00, this.m10, this.m20,
    this.m01, this.m11, this.m21,
    this.m02, this.m12, this.m22
  )

  /**
   * Returns this matrix to the power of the given exponent.
   *
   * @param exp The exponent
   * @return This matrix raised to the power of the given exponent
   */
  override def power(exp: Int): Mat3i = {
    if (exp < 0) {
      this.transposed.power(-exp)
    } else if (exp == 0) {
      Mat3i.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  /**
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix
   */
  override def determinant: Int = m00 * m11 * m22 + m01 * m12 * m20 + m02 * m10 * m21 - m02 * m11 * m20 - m01 * m10 * m22 - m00 * m12 * m21
}

object Mat3i {
  /** Shorthand for an identity matrix */
  val Identity: Mat3i = Mat3i(1, 0, 0, 0, 1, 0, 0, 0, 1)
  /** Shorthand for the zero matrix */
  val Zero: Mat3i = Mat3i(0, 0, 0, 0, 0, 0, 0, 0, 0)

  /**
   * Allows to use the operator '*' with a scalar as `1 * matrix`.
   *
   * @param k The scalar to which the matrix is multiplied
   */
  implicit class MultiplicationExtender(val k: Int) extends AnyVal {

    /**
     * Returns the product between this scalar and the given matrix.
     *
     * @param m The matrix to which the scalar is multiplied
     * @return The result of the product between this scalar and the given matrix
     */
    def *(m: Mat3i): Mat3i = m * k
  }
}
