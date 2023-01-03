package vecmatlib.matrix

import vecmatlib.vector.{Vec2f, Vec3f}

/**
 * 3x3 float matrix.
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
case class Mat3f(
                  m00: Float, m01: Float, m02: Float,
                  m10: Float, m11: Float, m12: Float,
                  m20: Float, m21: Float, m22: Float
                ) extends MatFloat[Mat3f, Vec3f] {

  /**
   * Returns the sum between this matrix and the given one.
   *
   * @param m The matrix to add
   * @return The sum between this matrix and the given one
   */
  override def +(m: Mat3f): Mat3f = Mat3f(
    this.m00 + m.m00, this.m01 + m.m01, this.m02 + m.m02,
    this.m10 + m.m10, this.m11 + m.m11, this.m12 + m.m12,
    this.m20 + m.m20, this.m21 + m.m21, this.m22 + m.m22
  )

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix
   */
  override def unary_- : Mat3f = Mat3f(
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
  override def *(k: Float): Mat3f = Mat3f(
    this.m00 * k, this.m01 * k, this.m02 * k,
    this.m10 * k, this.m11 * k, this.m12 * k,
    this.m20 * k, this.m21 * k, this.m22 * k
  )

  /**
   * Returns the first row of this matrix as a 3d vector.
   *
   * @return The first row of this matrix as a 3d vector
   */
  def row0: Vec3f = Vec3f(this.m00, this.m01, this.m02)

  /**
   * Returns the second row of this matrix as a 3d vector.
   *
   * @return The second row of this matrix as a 3d vector
   */
  def row1: Vec3f = Vec3f(this.m10, this.m11, this.m12)

  /**
   * Returns the third row of this matrix as a 3d vector.
   *
   * @return The third row of this matrix as a 3d vector
   */
  def row2: Vec3f = Vec3f(this.m20, this.m21, this.m22)

  /**
   * Returns the first column of this matrix as a 3d vector.
   *
   * @return The first column of this matrix as a 3d vector
   */
  def col0: Vec3f = Vec3f(this.m00, this.m10, this.m20)

  /**
   * Returns the second column of this matrix as a 3d vector.
   *
   * @return The second column of this matrix as a 3d vector
   */
  def col1: Vec3f = Vec3f(this.m01, this.m11, this.m21)

  /**
   * Returns the third column of this matrix as a 3d vector.
   *
   * @return The third column of this matrix as a 3d vector
   */
  def col2: Vec3f = Vec3f(this.m02, this.m12, this.m22)

  /**
   * Returns the product of this matrix by the given vector.
   *
   * @param v The vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  override def *(v: Vec3f): Vec3f = Vec3f(this.row0 dot v, this.row1 dot v, this.row2 dot v)

  /**
   * Returns the product of this matrix by the vector with the given components.
   *
   * @param x X component of the vector by which this matrix is multiplied
   * @param y Y component of the vector by which this matrix is multiplied
   * @param z Z component of the vector by which this matrix is multiplied
   * @return The product between this matrix and the vector with the given components
   */
  def *(x: Float, y: Float, z: Float): Vec3f = this * Vec3f(x, y, z)

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
  def multiply(x: Float, y: Float, z: Float): Vec3f = this * Vec3f(x, y, z)

  /**
   * Returns the product between this matrix and the given one.
   *
   * @param m The matrix by which this one is multiplied
   * @return The product between this matrix and the given one
   */
  override def *(m: Mat3f): Mat3f = Mat3f(
    this.row0 dot m.col0, this.row0 dot m.col1, this.row0 dot m.col2,
    this.row1 dot m.col0, this.row1 dot m.col1, this.row1 dot m.col2,
    this.row2 dot m.col0, this.row2 dot m.col1, this.row2 dot m.col2
  )

  /**
   * Returns the transposed of this matrix.
   *
   * @return The transposed of this matrix
   */
  override def transposed: Mat3f = Mat3f(
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
  override def power(exp: Int): Mat3f = {
    if (exp < 0) {
      this.transposed.power(-exp)
    } else if (exp == 0) {
      Mat3f.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  /**
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix
   */
  override def determinant: Float = m00 * m11 * m22 + m01 * m12 * m20 + m02 * m10 * m21 - m02 * m11 * m20 - m01 * m10 * m22 - m00 * m12 * m21
}

object Mat3f {
  /** Shorthand for an identity matrix */
  val Identity: Mat3f = Mat3f(1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f)
  /** Shorthand for the zero matrix */
  val Zero: Mat3f = Mat3f(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f)

  /**
   * Returns a 3x3 translation matrix with the given translation.
   *
   * @param x X component of the translation
   * @param y Y component of the translation
   * @return A 3x3 translation matrix
   */
  def translation(x: Float, y: Float): Mat3f = Mat3f(
    1.0f, 0.0f, x,
    0.0f, 1.0f, y,
    0.0f, 0.0f, 1.0f
  )

  /**
   * Returns a 3x3 translation matrix with the given translation.
   *
   * @param v The translation vector
   * @return A 3x3 translation matrix
   */
  def translation(v: Vec2f): Mat3f = translation(v.x, v.y)

  /**
   * Returns a 3x3 rotation matrix with the given rotation on the x axis.
   *
   * @param x Rotation angle in radians
   * @return A 3x3 rotation matrix
   */
  def rotationX(x: Float): Mat3f = Mat3f(
    1.0f, 0.0f, 0.0f,
    0.0f, math.cos(-x).toFloat, -math.sin(-x).toFloat,
    0.0f, math.sin(-x).toFloat, math.cos(-x).toFloat
  )

  /**
   * Returns a 3x3 rotation matrix with the given rotation on the y axis.
   *
   * @param y Rotation angle in radians
   * @return A 3x3 rotation matrix
   */
  def rotationY(y: Float): Mat3f = Mat3f(
    math.cos(-y).toFloat, 0.0f, math.sin(-y).toFloat,
    0.0f, 1.0f, 0.0f,
    -math.sin(-y).toFloat, 0.0f, math.cos(-y).toFloat
  )

  /**
   * Returns a 3x3 rotation matrix with the given rotation on the z axis.
   *
   * @param z Rotation angle in radians
   * @return A 3x3 rotation matrix
   */
  def rotationZ(z: Float): Mat3f = Mat3f(
    math.cos(-z).toFloat, -math.sin(-z).toFloat, 0.0f,
    math.sin(-z).toFloat, math.cos(-z).toFloat, 0.0f,
    0.0f, 0.0f, 1.0f
  )

  /**
   * Returns a 3x3 rotation matrix with the given rotation.
   *
   * @param x Rotation angle in radians on the x axis
   * @param y Rotation angle in radians on the y axis
   * @param z Rotation angle in radians on the z axis
   * @return A 3x3 rotation matrix
   */
  def rotation(x: Float, y: Float, z: Float): Mat3f = rotationX(x) * rotationY(y) * rotationZ(z)

  /**
   * Returns a 3x3 scaling matrix with the given scale.
   *
   * @param x Scale on the x axis
   * @param y Scale on the y axis
   * @param z Scale on the z axis
   * @return A 3x3 scaling matrix
   */
  def scaling(x: Float, y: Float, z: Float): Mat3f = Mat3f(
    x, 0.0f, 0.0f,
    0.0f, y, 0.0f,
    0.0f, 0.0f, z
  )

  /**
   * Returns a 3x3 scaling matrix with the given scale.
   *
   * @param x Scale on the x axis
   * @param y Scale on the y axis
   * @return A 3x3 scaling matrix
   */
  def scaling(x: Float, y: Float): Mat3f = scaling(x, y, 1.0f)

  /**
   * Returns a 3x3 scaling matrix with the given scale.
   *
   * @param v The scale vector
   * @return A 3x3 scaling matrix
   */
  def scaling(v: Vec3f): Mat3f = scaling(v.x, v.y, v.z)

  /**
   * Returns a 3x3 scaling matrix with the given scale.
   *
   * @param v The scale vector
   * @return A 3x3 scaling matrix
   */
  def scaling(v: Vec2f): Mat3f = scaling(v.x, v.y, 1.0f)
}
