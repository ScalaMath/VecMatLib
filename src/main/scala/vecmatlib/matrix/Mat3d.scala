package vecmatlib.matrix

import vecmatlib.vector.Vec3d

/**
 * 3x3 double matrix.
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

  /**
   * Returns the first row of this matrix as a 3d vector.
   *
   * @return The first row of this matrix as a 3d vector
   */
  def row0: Vec3d = Vec3d(this.m00, this.m01, this.m02)

  /**
   * Returns the second row of this matrix as a 3d vector.
   *
   * @return The second row of this matrix as a 3d vector
   */
  def row1: Vec3d = Vec3d(this.m10, this.m11, this.m12)

  /**
   * Returns the third row of this matrix as a 3d vector.
   *
   * @return The third row of this matrix as a 3d vector
   */
  def row2: Vec3d = Vec3d(this.m20, this.m21, this.m22)

  /**
   * Returns the first column of this matrix as a 3d vector.
   *
   * @return The first column of this matrix as a 3d vector
   */
  def col0: Vec3d = Vec3d(this.m00, this.m10, this.m20)

  /**
   * Returns the second column of this matrix as a 3d vector.
   *
   * @return The second column of this matrix as a 3d vector
   */
  def col1: Vec3d = Vec3d(this.m01, this.m11, this.m21)

  /**
   * Returns the third column of this matrix as a 3d vector.
   *
   * @return The third column of this matrix as a 3d vector
   */
  def col2: Vec3d = Vec3d(this.m02, this.m12, this.m22)

  override def *(v: Vec3d): Vec3d = Vec3d(this.row0 dot v, this.row1 dot v, this.row2 dot v)

  /**
   * Returns the product of this matrix by the vector with the given components.
   *
   * @param x X component of the vector by which this matrix is multiplied
   * @param y Y component of the vector by which this matrix is multiplied
   * @param z Z component of the vector by which this matrix is multiplied
   * @return The product between this matrix and the vector with the given components
   */
  def *(x: Double, y: Double, z: Double): Vec3d = this * Vec3d(x, y, z)

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

  /**
   * Casts this matrix to an int matrix.
   *
   * @return A matrix same as this one cast to int
   */
  def toInt: Mat3i = Mat3i(
    this.m00.toInt, this.m01.toInt, this.m02.toInt,
    this.m10.toInt, this.m11.toInt, this.m12.toInt,
    this.m20.toInt, this.m21.toInt, this.m22.toInt
  )

  /**
   * Casts this matrix to a float matrix.
   *
   * @return A matrix same as this one cast to float
   */
  def toFloat: Mat3f = Mat3f(
    this.m00.toFloat, this.m01.toFloat, this.m02.toFloat,
    this.m10.toFloat, this.m11.toFloat, this.m12.toFloat,
    this.m20.toFloat, this.m21.toFloat, this.m22.toFloat
  )
}

object Mat3d {
  /** Shorthand for an identity matrix */
  val Identity: Mat3d = Mat3d(1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0)
  /** Shorthand for the zero matrix */
  val Zero: Mat3d = Mat3d(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
}
