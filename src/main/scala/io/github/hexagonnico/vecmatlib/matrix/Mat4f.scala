package io.github.hexagonnico.vecmatlib.matrix

import io.github.hexagonnico.vecmatlib.vector.{Vec2f, Vec3f, Vec4f}

/**
 * 4x4 float matrix.
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
case class Mat4f(
                  m00: Float, m01: Float, m02: Float, m03: Float,
                  m10: Float, m11: Float, m12: Float, m13: Float,
                  m20: Float, m21: Float, m22: Float, m23: Float,
                  m30: Float, m31: Float, m32: Float, m33: Float
                ) extends MatFloat[Mat4f, Vec4f] {

  /**
   * Returns the sum between this matrix and the given one.
   *
   * @param m The matrix to add
   * @return The sum between this matrix and the given one
   */
  override def +(m: Mat4f): Mat4f = Mat4f(
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
  override def unary_- : Mat4f = Mat4f(
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
  override def *(k: Float): Mat4f = Mat4f(
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
  def row0: Vec4f = Vec4f(this.m00, this.m01, this.m02, this.m03)

  /**
   * Returns the second row of this matrix as a 3d vector.
   *
   * @return The second row of this matrix as a 3d vector
   */
  def row1: Vec4f = Vec4f(this.m10, this.m11, this.m12, this.m13)

  /**
   * Returns the third row of this matrix as a 3d vector.
   *
   * @return The third row of this matrix as a 3d vector
   */
  def row2: Vec4f = Vec4f(this.m20, this.m21, this.m22, this.m23)

  /**
   * Returns the fourth row of this matrix as a 3d vector.
   *
   * @return The fourth row of this matrix as a 3d vector
   */
  def row3: Vec4f = Vec4f(this.m30, this.m31, this.m32, this.m33)

  /**
   * Returns the first column of this matrix as a 3d vector.
   *
   * @return The first column of this matrix as a 3d vector
   */
  def col0: Vec4f = Vec4f(this.m00, this.m10, this.m20, this.m30)

  /**
   * Returns the second column of this matrix as a 3d vector.
   *
   * @return The second column of this matrix as a 3d vector
   */
  def col1: Vec4f = Vec4f(this.m01, this.m11, this.m21, this.m31)

  /**
   * Returns the third column of this matrix as a 3d vector.
   *
   * @return The third column of this matrix as a 3d vector
   */
  def col2: Vec4f = Vec4f(this.m02, this.m12, this.m22, this.m32)

  /**
   * Returns the fourth column of this matrix as a 3d vector.
   *
   * @return The fourth column of this matrix as a 3d vector
   */
  def col3: Vec4f = Vec4f(this.m03, this.m13, this.m23, this.m33)

  /**
   * Returns the product of this matrix by the given vector.
   *
   * @param v The vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  override def *(v: Vec4f): Vec4f = Vec4f(this.row0 dot v, this.row1 dot v, this.row2 dot v, this.row3 dot v)

  /**
   * Returns the product of this matrix by the given vector.
   * Allows a more convenient way to multiply vectors by transformation matrices.
   *
   * @param v The X, Y, and Z components of the vector by which this matrix is multiplied
   * @param w The W component of the vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  def *(v: Vec3f, w: Float): Vec4f = this * (v.x, v.y, v.z, w)

  /**
   * Returns the product of this matrix by the vector with the given components.
   *
   * @param x X component of the vector by which this matrix is multiplied
   * @param y Y component of the vector by which this matrix is multiplied
   * @param z Z component of the vector by which this matrix is multiplied
   * @return The product between this matrix and the vector with the given components
   */
  def *(x: Float, y: Float, z: Float, w: Float): Vec4f = this * Vec4f(x, y, z, w)

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
  def multiply(x: Float, y: Float, z: Float, w: Float): Vec4f = this * Vec4f(x, y, z, w)

  /**
   * Returns the product of this matrix by the given vector.
   * Allows a more convenient way to multiply vectors by transformation matrices.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param v The X, Y, and Z components of the vector by which this matrix is multiplied
   * @param w The W component of the vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  def multiply(v: Vec3f, w: Float): Vec4f = this * (v, w)

  /**
   * Returns the product between this matrix and the given one.
   *
   * @param m The matrix by which this one is multiplied
   * @return The product between this matrix and the given one
   */
  override def *(m: Mat4f): Mat4f = Mat4f(
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
  override def transposed: Mat4f = Mat4f(
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
  override def power(exp: Int): Mat4f = {
    if (exp < 0) {
      this.transposed.power(-exp)
    } else if (exp == 0) {
      Mat4f.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  /**
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix
   */
  override def determinant: Float = this.m00 * Mat3f(
    this.m11, this.m12, this.m13,
    this.m21, this.m22, this.m23,
    this.m31, this.m32, this.m33
  ).determinant - this.m01 * Mat3f(
    this.m10, this.m12, this.m13,
    this.m20, this.m22, this.m23,
    this.m30, this.m32, this.m33
  ).determinant + this.m02 * Mat3f(
    this.m10, this.m11, this.m13,
    this.m20, this.m21, this.m23,
    this.m30, this.m31, this.m33
  ).determinant - this.m03 * Mat3f(
    this.m10, this.m11, this.m12,
    this.m20, this.m21, this.m22,
    this.m30, this.m31, this.m32
  ).determinant
}

object Mat4f {
  /** Shorthand for an identity matrix */
  val Identity: Mat4f = Mat4f(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f)
  /** Shorthand for the zero matrix */
  val Zero: Mat4f = Mat4f(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f)

  /**
   * Returns a 4x4 translation matrix with the given translation.
   *
   * @param x X component of the translation
   * @param y Y component of the translation
   * @param z Z component of the translation
   * @return A 4x4 translation matrix
   */
  def translation(x: Float, y: Float, z: Float): Mat4f = Mat4f(
    1.0f, 0.0f, 0.0f, x,
    0.0f, 1.0f, 0.0f, y,
    0.0f, 0.0f, 1.0f, z,
    0.0f, 0.0f, 0.0f, 1.0f
  )

  /**
   * Returns a 4x4 translation matrix with the given translation on the x and y axes.
   *
   * @param x X component of the translation
   * @param y Y component of the translation
   * @return A 4x4 translation matrix
   */
  def translation(x: Float, y: Float): Mat4f = translation(x, y, 0.0f)

  /**
   * Returns a 4x4 translation matrix with the given translation.
   *
   * @param v The translation vector
   * @return A 4x4 translation matrix
   */
  def translation(v: Vec3f): Mat4f = translation(v.x, v.y, v.z)

  /**
   * Returns a 4x4 translation matrix with the given translation on the x and y axes.
   *
   * @param v The translation vector
   * @return A 4x4 translation matrix
   */
  def translation(v: Vec2f): Mat4f = translation(v.x, v.y)

  /**
   * Returns a 4x4 rotation matrix with the given rotation on the x axis.
   *
   * @param x Rotation angle in radians
   * @return A 4x4 rotation matrix
   */
  def rotationX(x: Float): Mat4f = Mat4f(
    1.0f, 0.0f, 0.0f, 0.0f,
    0.0f, math.cos(-x).toFloat, -math.sin(-x).toFloat, 0.0f,
    0.0f, math.sin(-x).toFloat, math.cos(-x).toFloat, 0.0f,
    0.0f, 0.0f, 0.0f, 1.0f
  )

  /**
   * Returns a 4x4 rotation matrix with the given rotation on the y axis.
   *
   * @param y Rotation angle in radians
   * @return A 4x4 rotation matrix
   */
  def rotationY(y: Float): Mat4f = Mat4f(
    math.cos(-y).toFloat, 0.0f, math.sin(-y).toFloat, 0.0f,
    0.0f, 1.0f, 0.0f, 0.0f,
    -math.sin(-y).toFloat, 0.0f, math.cos(-y).toFloat, 0.0f,
    0.0f, 0.0f, 0.0f, 1.0f
  )

  /**
   * Returns a 4x4 rotation matrix with the given rotation on the z axis.
   *
   * @param z Rotation angle in radians
   * @return A 4x4 rotation matrix
   */
  def rotationZ(z: Float): Mat4f = Mat4f(
    math.cos(-z).toFloat, -math.sin(-z).toFloat, 0.0f, 0.0f,
    math.sin(-z).toFloat, math.cos(-z).toFloat, 0.0f, 0.0f,
    0.0f, 0.0f, 1.0f, 0.0f,
    0.0f, 0.0f, 0.0f, 1.0f
  )

  /**
   * Returns a 4x4 rotation matrix with the given rotation.
   *
   * @param x Rotation angle in radians on the x axis
   * @param y Rotation angle in radians on the y axis
   * @param z Rotation angle in radians on the z axis
   * @return A 4x4 rotation matrix
   */
  def rotation(x: Float, y: Float, z: Float): Mat4f = rotationX(x) * rotationY(y) * rotationZ(z)

  /**
   * Returns a 4x4 rotation matrix with the given rotation.
   *
   * @param v Vector representing the rotation in radians
   * @return A 4x4 rotation matrix
   */
  def rotation(v: Vec3f): Mat4f = rotation(v.x, v.y, v.z)

  /**
   * Returns a 4x4 scaling matrix with the given scale.
   *
   * @param x Scale on the x axis
   * @param y Scale on the y axis
   * @param z Scale on the z axis
   * @return A 4x4 scaling matrix
   */
  def scaling(x: Float, y: Float, z: Float): Mat4f = Mat4f(
    x, 0.0f, 0.0f, 0.0f,
    0.0f, y, 0.0f, 0.0f,
    0.0f, 0.0f, z, 0.0f,
    0.0f, 0.0f, 0.0f, 1.0f
  )

  /**
   * Returns a 4x4 scaling matrix with the given scale on all three axes.
   *
   * @param scale Scale on all three axes
   * @return A 4x4 scaling matrix
   */
  def scaling(scale: Float): Mat4f = scaling(scale, scale, scale)

  /**
   * Returns a 4x4 scaling matrix with the given scale on the x and y axes and a scale of 1 on the z axis.
   *
   * @param x Scale on the x axis
   * @param y Scale on the y axis
   * @return A 4x4 scaling matrix
   */
  def scaling(x: Float, y: Float): Mat4f = scaling(x, y, 1.0f)

  /**
   * Returns a 4x4 scaling matrix with the given scale.
   *
   * @param v The scale vector
   * @return A 4x4 scaling matrix
   */
  def scaling(v: Vec3f): Mat4f = scaling(v.x, v.y, v.z)

  /**
   * Returns a 4x4 scaling matrix with the given scale on the x and y axes and a scale of 1 on the z axis.
   *
   * @param v The scale vector
   * @return A 4x4 scaling matrix
   */
  def scaling(v: Vec2f): Mat4f = scaling(v.x, v.y)

  /**
   * Allows to use the operator '*' with a scalar as `1.0f * matrix`.
   *
   * @param k The scalar to which the matrix is multiplied
   */
  implicit class MultiplicationExtender(val k: Float) extends AnyVal {

    /**
     * Returns the product between this scalar and the given matrix.
     *
     * @param m The matrix to which the scalar is multiplied
     * @return The result of the product between this scalar and the given matrix
     */
    def *(m: Mat4f): Mat4f = m * k
  }
}
