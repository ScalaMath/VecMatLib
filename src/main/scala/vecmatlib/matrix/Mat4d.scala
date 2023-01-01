package vecmatlib.matrix

import vecmatlib.vector.{Vec3d, Vec4d}

/**
 * 4x4 double matrix.
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

  /**
   * Returns the first row of this matrix as a 3d vector.
   *
   * @return The first row of this matrix as a 3d vector
   */
  def row0: Vec4d = Vec4d(this.m00, this.m01, this.m02, this.m03)

  /**
   * Returns the second row of this matrix as a 3d vector.
   *
   * @return The second row of this matrix as a 3d vector
   */
  def row1: Vec4d = Vec4d(this.m10, this.m11, this.m12, this.m13)

  /**
   * Returns the third row of this matrix as a 3d vector.
   *
   * @return The third row of this matrix as a 3d vector
   */
  def row2: Vec4d = Vec4d(this.m20, this.m21, this.m22, this.m23)

  /**
   * Returns the fourth row of this matrix as a 3d vector.
   *
   * @return The fourth row of this matrix as a 3d vector
   */
  def row3: Vec4d = Vec4d(this.m30, this.m31, this.m32, this.m33)

  /**
   * Returns the first column of this matrix as a 3d vector.
   *
   * @return The first column of this matrix as a 3d vector
   */
  def col0: Vec4d = Vec4d(this.m00, this.m10, this.m20, this.m30)

  /**
   * Returns the second column of this matrix as a 3d vector.
   *
   * @return The second column of this matrix as a 3d vector
   */
  def col1: Vec4d = Vec4d(this.m01, this.m11, this.m21, this.m31)

  /**
   * Returns the third column of this matrix as a 3d vector.
   *
   * @return The third column of this matrix as a 3d vector
   */
  def col2: Vec4d = Vec4d(this.m02, this.m12, this.m22, this.m32)

  /**
   * Returns the fourth column of this matrix as a 3d vector.
   *
   * @return The fourth column of this matrix as a 3d vector
   */
  def col3: Vec4d = Vec4d(this.m03, this.m13, this.m23, this.m33)

  override def *(v: Vec4d): Vec4d = Vec4d(this.row0 dot v, this.row1 dot v, this.row2 dot v, this.row3 dot v)

  /**
   * Returns the product of this matrix by the vector with the given components.
   *
   * @param x X component of the vector by which this matrix is multiplied
   * @param y Y component of the vector by which this matrix is multiplied
   * @param z Z component of the vector by which this matrix is multiplied
   * @return The product between this matrix and the vector with the given components
   */
  def *(x: Double, y: Double, z: Double, w: Double): Vec4d = this * Vec4d(x, y, z, w)

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
      Mat4d.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  /**
   * Casts this matrix to an int matrix.
   *
   * @return A matrix same as this one cast to int
   */
  def toInt: Mat4i = Mat4i(
    this.m00.toInt, this.m01.toInt, this.m02.toInt, this.m03.toInt,
    this.m10.toInt, this.m11.toInt, this.m12.toInt, this.m13.toInt,
    this.m20.toInt, this.m21.toInt, this.m22.toInt, this.m23.toInt,
    this.m30.toInt, this.m31.toInt, this.m32.toInt, this.m33.toInt
  )

  /**
   * Casts this matrix to a float matrix.
   *
   * @return A matrix same as this one cast to float
   */
  def toFloat: Mat4f = Mat4f(
    this.m00.toFloat, this.m01.toFloat, this.m02.toFloat, this.m03.toFloat,
    this.m10.toFloat, this.m11.toFloat, this.m12.toFloat, this.m13.toFloat,
    this.m20.toFloat, this.m21.toFloat, this.m22.toFloat, this.m23.toFloat,
    this.m30.toFloat, this.m31.toFloat, this.m32.toFloat, this.m33.toFloat
  )
}

object Mat4d {
  /** Shorthand for an identity matrix */
  val Identity: Mat4d = Mat4d(1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0)
  /** Shorthand for the zero matrix */
  val Zero: Mat4d = Mat4d(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)

  /**
   * Returns a 4x4 translation matrix with the given translation.
   *
   * @param x X component of the translation
   * @param y Y component of the translation
   * @param z Z component of the translation
   * @return A 4x4 translation matrix
   */
  def translation(x: Double, y: Double, z: Double): Mat4d = Mat4d(
    1.0, 0.0, 0.0, x,
    0.0, 1.0, 0.0, y,
    0.0, 0.0, 1.0, z,
    0.0, 0.0, 0.0, 1.0
  )

  /**
   * Returns a 4x4 translation matrix with the given translation.
   *
   * @param v The translation vector
   * @return A 4x4 translation matrix
   */
  def translation(v: Vec3d): Mat4d = translation(v.x, v.y, v.z)

  /**
   * Returns a 4x4 rotation matrix with the given rotation on the x axis.
   *
   * @param x Rotation angle in radians
   * @return A 4x4 rotation matrix
   */
  def rotationX(x: Double): Mat4d = Mat4d(
    1.0, 0.0, 0.0, 0.0,
    0.0, math.cos(-x), -math.sin(-x), 0.0,
    0.0, math.sin(-x), math.cos(-x), 0.0,
    0.0, 0.0, 0.0, 1.0
  )

  /**
   * Returns a 4x4 rotation matrix with the given rotation on the y axis.
   *
   * @param y Rotation angle in radians
   * @return A 4x4 rotation matrix
   */
  def rotationY(y: Double): Mat4d = Mat4d(
    math.cos(-y), 0.0, math.sin(-y), 0.0,
    0.0, 1.0, 0.0, 0.0,
    -math.sin(-y), 0.0, math.cos(-y), 0.0,
    0.0, 0.0, 0.0, 1.0
  )

  /**
   * Returns a 4x4 rotation matrix with the given rotation on the z axis.
   *
   * @param z Rotation angle in radians
   * @return A 4x4 rotation matrix
   */
  def rotationZ(z: Double): Mat4d = Mat4d(
    math.cos(-z), -math.sin(-z), 0.0, 0.0,
    math.sin(-z), math.cos(-z), 0.0, 0.0,
    0.0, 0.0, 1.0, 0.0,
    0.0, 0.0, 0.0, 1.0
  )

  /**
   * Returns a 4x4 rotation matrix with the given rotation.
   *
   * @param x Rotation angle in radians on the x axis
   * @param y Rotation angle in radians on the y axis
   * @param z Rotation angle in radians on the z axis
   * @return A 4x4 rotation matrix
   */
  def rotation(x: Double, y: Double, z: Double): Mat4d = rotationX(x) * rotationY(y) * rotationZ(z)

  /**
   * Returns a 4x4 rotation matrix with the given rotation.
   *
   * @param v Vector representing the rotation in radians
   * @return A 4x4 rotation matrix
   */
  def rotation(v: Vec3d): Mat4d = rotation(v.x, v.y, v.z)

  /**
   * Returns a 4x4 scaling matrix with the given scale.
   *
   * @param x Scale on the x axis
   * @param y Scale on the y axis
   * @param z Scale on the z axis
   * @return A 4x4 scaling matrix
   */
  def scaling(x: Double, y: Double, z: Double): Mat4d = Mat4d(
    x, 0.0, 0.0, 0.0,
    0.0, y, 0.0, 0.0,
    0.0, 0.0, z, 0.0,
    0.0, 0.0, 0.0, 1.0
  )

  /**
   * Returns a 4x4 scaling matrix with the given scale.
   *
   * @param v The scale vector
   * @return A 4x4 scaling matrix
   */
  def scaling(v: Vec3d): Mat4d = scaling(v.x, v.y, v.z)
}
