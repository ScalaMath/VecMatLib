package vecmatlib.matrix

import vecmatlib.vector.Vec2f

/**
 * 2x2 float matrix.
 *
 * @param m00 Element 0 0
 * @param m01 Element 0 1
 * @param m10 Element 1 0
 * @param m11 Element 1 1
 */
case class Mat2f(m00: Float, m01: Float, m10: Float, m11: Float) extends MatFloat[Mat2f, Vec2f] {

  /**
   * Returns the sum between this matrix and the given one.
   *
   * @param m The matrix to add
   * @return The sum between this matrix and the given one
   */
  override def +(m: Mat2f): Mat2f = Mat2f(
    this.m00 + m.m00, this.m01 + m.m01,
    this.m10 + m.m10, this.m11 + m.m11
  )

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix
   */
  override def unary_- : Mat2f = Mat2f(
    -this.m00, -this.m01,
    -this.m10, -this.m11
  )

  /**
   * Returns the product of this matrix by the given scalar.
   *
   * @param k The scalar by which this matrix is multiplied
   * @return The product of this matrix by the given scalar
   */
  override def *(k: Float): Mat2f = Mat2f(
    this.m00 * k, this.m01 * k,
    this.m10 * k, this.m11 * k
  )

  /**
   * Returns the first row of this matrix as a 2d vector.
   *
   * @return The first row of this matrix as a 2d vector
   */
  def row0: Vec2f = Vec2f(this.m00, this.m01)

  /**
   * Returns the second row of this matrix as a 2d vector.
   *
   * @return The second row of this matrix as a 2d vector
   */
  def row1: Vec2f = Vec2f(this.m10, this.m11)

  /**
   * Returns the first column of this matrix as a 2d vector.
   *
   * @return The first column of this matrix as a 2d vector
   */
  def col0: Vec2f = Vec2f(this.m00, this.m10)

  /**
   * Returns the second column of this matrix as a 2d vector.
   *
   * @return The second column of this matrix as a 2d vector
   */
  def col1: Vec2f = Vec2f(this.m01, this.m11)

  /**
   * Returns the product of this matrix by the given vector.
   *
   * @param v The vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  override def *(v: Vec2f): Vec2f = Vec2f(this.row0 dot v, this.row1 dot v)

  /**
   * Returns the product of this matrix by the vector with the given components.
   *
   * @param x X component of the vector by which this matrix is multiplied
   * @param y Y component of the vector by which this matrix is multiplied
   * @return The product between this matrix and the vector with the given components
   */
  def *(x: Float, y: Float): Vec2f = this * Vec2f(x, y)

  /**
   * Returns the product of this matrix by the vector with the given components.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param x X component of the vector by which this matrix is multiplied
   * @param y Y component of the vector by which this matrix is multiplied
   * @return The product between this matrix and the vector with the given components
   */
  def multiply(x: Float, y: Float): Vec2f = this * Vec2f(x, y)

  /**
   * Returns the product between this matrix and the given one.
   *
   * @param m The matrix by which this one is multiplied
   * @return The product between this matrix and the given one
   */
  override def *(m: Mat2f): Mat2f = Mat2f(
    this.row0 dot m.col0, this.row0 dot m.col1,
    this.row1 dot m.col0, this.row1 dot m.col1
  )

  /**
   * Returns the transposed of this matrix.
   *
   * @return The transposed of this matrix
   */
  override def transposed: Mat2f = Mat2f(
    this.m00, this.m10,
    this.m01, this.m11
  )

  /**
   * Returns this matrix to the power of the given exponent.
   *
   * @param exp The exponent
   * @return This matrix raised to the power of the given exponent
   */
  override def power(exp: Int): Mat2f = {
    if (exp < 0) {
      this.transposed.power(-exp)
    } else if (exp == 0) {
      Mat2f.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  /**
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix
   */
  override def determinant: Float = this.m00 * this.m11 - this.m01 * this.m10
}

object Mat2f {
  /** Shorthand for `new Mat2f(1.0f, 0.0f, 0.0f, 1.0f)` */
  val Identity: Mat2f = Mat2f(1.0f, 0.0f, 0.0f, 1.0f)
  /** Shorthand for `new Mat2f(0.0f, 0.0f, 0.0f, 0.0f)` */
  val Zero: Mat2f = Mat2f(0.0f, 0.0f, 0.0f, 0.0f)
}
