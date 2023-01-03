package vecmatlib.matrix

import vecmatlib.vector.Vec2i

/**
 * 2x2 int matrix.
 *
 * @param m00 Element 0 0
 * @param m01 Element 0 1
 * @param m10 Element 1 0
 * @param m11 Element 1 1
 */
case class Mat2i(m00: Int, m01: Int, m10: Int, m11: Int) extends MatInt[Mat2i, Vec2i] {

  /**
   * Returns the sum between this matrix and the given one.
   *
   * @param m The matrix to add
   * @return The sum between this matrix and the given one
   */
  override def +(m: Mat2i): Mat2i = Mat2i(
    this.m00 + m.m00, this.m01 + m.m01,
    this.m10 + m.m10, this.m11 + m.m11
  )

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix
   */
  override def unary_- : Mat2i = Mat2i(
    -this.m00, -this.m01,
    -this.m10, -this.m11
  )

  /**
   * Returns the product of this matrix by the given scalar.
   *
   * @param k The scalar by which this matrix is multiplied
   * @return The product of this matrix by the given scalar
   */
  override def *(k: Int): Mat2i = Mat2i(
    this.m00 * k, this.m01 * k,
    this.m10 * k, this.m11 * k
  )

  /**
   * Returns the first row of this matrix as a 2d vector.
   *
   * @return The first row of this matrix as a 2d vector
   */
  def row0: Vec2i = Vec2i(this.m00, this.m01)

  /**
   * Returns the second row of this matrix as a 2d vector.
   *
   * @return The second row of this matrix as a 2d vector
   */
  def row1: Vec2i = Vec2i(this.m10, this.m11)

  /**
   * Returns the first column of this matrix as a 2d vector.
   *
   * @return The first column of this matrix as a 2d vector
   */
  def col0: Vec2i = Vec2i(this.m00, this.m10)

  /**
   * Returns the second column of this matrix as a 2d vector.
   *
   * @return The second column of this matrix as a 2d vector
   */
  def col1: Vec2i = Vec2i(this.m01, this.m11)

  /**
   * Returns the product of this matrix by the given vector.
   *
   * @param v The vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  override def *(v: Vec2i): Vec2i = Vec2i(this.row0 dot v, this.row1 dot v)

  /**
   * Returns the product of this matrix by the vector with the given components.
   *
   * @param x X component of the vector by which this matrix is multiplied
   * @param y Y component of the vector by which this matrix is multiplied
   * @return The product between this matrix and the vector with the given components
   */
  def *(x: Int, y: Int): Vec2i = this * Vec2i(x, y)

  /**
   * Returns the product of this matrix by the vector with the given components.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param x X component of the vector by which this matrix is multiplied
   * @param y Y component of the vector by which this matrix is multiplied
   * @return The product between this matrix and the vector with the given components
   */
  def multiply(x: Int, y: Int): Vec2i = this * Vec2i(x, y)

  /**
   * Returns the product between this matrix and the given one.
   *
   * @param m The matrix by which this one is multiplied
   * @return The product between this matrix and the given one
   */
  override def *(m: Mat2i): Mat2i = Mat2i(
    this.row0 dot m.col0, this.row0 dot m.col1,
    this.row1 dot m.col0, this.row1 dot m.col1
  )

  /**
   * Returns the transposed of this matrix.
   *
   * @return The transposed of this matrix
   */
  override def transposed: Mat2i = Mat2i(
    this.m00, this.m10,
    this.m01, this.m11
  )

  /**
   * Returns this matrix to the power of the given exponent.
   *
   * @param exp The exponent
   * @return This matrix raised to the power of the given exponent
   */
  override def power(exp: Int): Mat2i = {
    if (exp < 0) {
      this.transposed.power(-exp)
    } else if (exp == 0) {
      Mat2i.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  /**
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix
   */
  override def determinant: Int = this.m00 * this.m11 - this.m01 * this.m10
}

object Mat2i {
  /** Shorthand for `new Mat2i(1, 0, 0, 1)` */
  val Identity: Mat2i = Mat2i(1, 0, 0, 1)
  /** Shorthand for `new Mat2i(0, 0, 0, 0)` */
  val Zero: Mat2i = Mat2i(0, 0, 0, 0)
}
