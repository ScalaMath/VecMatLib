package io.github.scalamath.vecmatlib

/**
 * A 3x3 int matrix.
 *
 * @constructor Constructs a matrix from the given values.
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
                ) {

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def +(m: Mat3i): Mat3i = Mat3i(
    this.m00 + m.m00, this.m01 + m.m01, this.m02 + m.m02,
    this.m10 + m.m10, this.m11 + m.m11, this.m12 + m.m12,
    this.m20 + m.m20, this.m21 + m.m21, this.m22 + m.m22
  )

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def plus(m: Mat3i): Mat3i = this + m

  /**
   * Returns this same matrix.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This matrix.
   */
  def unary_+(): Mat3i = this

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def -(m: Mat3i): Mat3i = Mat3i(
    this.m00 - m.m00, this.m01 - m.m01, this.m02 - m.m02,
    this.m10 - m.m10, this.m11 - m.m11, this.m12 - m.m12,
    this.m20 - m.m20, this.m21 - m.m21, this.m22 - m.m22
  )

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def minus(m: Mat3i): Mat3i = this - m

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix.
   */
  def unary_-(): Mat3i = Mat3i(
    -this.m00, -this.m01, -this.m02,
    -this.m10, -this.m11, -this.m12,
    -this.m20, -this.m21, -this.m22
  )

  /**
   * Returns the additive inverse of this matrix.
   *
   * This method can be used in place of the unary `-` operator for better interoperability with Java.
   *
   * @return The additive inverse of this matrix.
   */
  def negated: Mat3i = -this

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def *(k: Int): Mat3i = Mat3i(
    this.m00 * k, this.m01 * k, this.m02 * k,
    this.m10 * k, this.m11 * k, this.m12 * k,
    this.m20 * k, this.m21 * k, this.m22 * k
  )

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def multipliedBy(k: Int): Mat3i = this * k

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * Note that this method performs an integer division.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def /(k: Int): Mat3i = Mat3i(
    this.m00 / k, this.m01 / k, this.m02 / k,
    this.m10 / k, this.m11 / k, this.m12 / k,
    this.m20 / k, this.m21 / k, this.m22 / k
  )

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * Note that this method performs an integer division.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def dividedBy(k: Int): Mat3i = this / k

  /**
   * Returns the first row of this matrix as a [[Vec3i]].
   *
   * @return The first row of this matrix.
   * @see [[row]]
   */
  def row0: Vec3i = Vec3i(this.m00, this.m01, this.m02)

  /**
   * Returns the second row of this matrix as a [[Vec3i]].
   *
   * @return The second row of this matrix.
   * @see [[row]]
   */
  def row1: Vec3i = Vec3i(this.m10, this.m11, this.m12)

  /**
   * Returns the third row of this matrix as a [[Vec3i]].
   *
   * @return The third row of this matrix.
   * @see [[row]]
   */
  def row2: Vec3i = Vec3i(this.m20, this.m21, this.m22)

  /**
   * Returns the row at the given index as a [[Vec3i]].
   *
   * @param i The index of the requested row. Must be either 0, 1, or 2.
   * @return The row at the given index.
   * @throws scala.MatchError If the given index is out of bounds.
   * @see [[row0]], [[row1]], and [[row2]]
   */
  def row(i: Int): Vec3i = i match {
    case 0 => this.row0
    case 1 => this.row1
    case 2 => this.row2
  }

  /**
   * Returns the first column of this matrix as a [[Vec3i]].
   *
   * @return The first column of this matrix.
   * @see [[col]]
   */
  def col0: Vec3i = Vec3i(this.m00, this.m10, this.m20)

  /**
   * Returns the second column of this matrix as a [[Vec3i]].
   *
   * @return The second column of this matrix.
   * @see [[col]]
   */
  def col1: Vec3i = Vec3i(this.m01, this.m11, this.m21)

  /**
   * Returns the third column of this matrix as a [[Vec3i]].
   *
   * @return The third column of this matrix.
   * @see [[col]]
   */
  def col2: Vec3i = Vec3i(this.m02, this.m12, this.m22)

  /**
   * Returns the column at the given index as a [[Vec3i]].
   *
   * @param i The index of the requested column. Must be either 0, 1, or 2.
   * @return The column at the given index.
   * @throws scala.MatchError If the given index is out of bounds.
   * @see [[col0]], [[col1]], and [[col2]]
   */
  def col(i: Int): Vec3i = i match {
    case 0 => this.col0
    case 1 => this.col1
    case 2 => this.col2
  }

  /**
   * Multiplies this matrix by the given vector and returns the result.
   *
   * @param v The vector to multiply this matrix by.
   * @return The product of this matrix by the given vector.
   */
  def *(v: Vec3i): Vec3i = Vec3i(this.row0.dot(v), this.row1.dot(v), this.row2.dot(v))

  /**
   * Multiplies this matrix by the given vector and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param v The vector to multiply this matrix by.
   * @return The product of this matrix by the given vector.
   */
  def multiply(v: Vec3i): Vec3i = this * v

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * @param x The vector's x component.
   * @param y The vector's y component.
   * @param z The vector's z component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(x: Int, y: Int, z: Int): Vec3i = this * Vec3i(x, y, z)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param x The vector's x component.
   * @param y The vector's y component.
   * @param z The vector's z component.
   * @return The product of this matrix by the vector with the given components.
   */
  def multiply(x: Int, y: Int, z: Int): Vec3i = this * (x, y, z)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * Useful to simplify the transformation of a 2D point.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(xy: Vec2i, z: Int): Vec3i = this * (xy.x, xy.y, z)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * Useful to simplify the transformation of a 2D point.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   * @return The product of this matrix by the vector with the given components.
   */
  def multiply(xy: Vec2i, z: Int): Vec3i = this * (xy, z)

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def *(m: Mat3i): Mat3i = Mat3i(
    this.row0.dot(m.col0), this.row0.dot(m.col1), this.row0.dot(m.col2),
    this.row1.dot(m.col0), this.row1.dot(m.col1), this.row1.dot(m.col2),
    this.row2.dot(m.col0), this.row2.dot(m.col1), this.row2.dot(m.col2)
  )

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def multiply(m: Mat3i): Mat3i = this * m

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def *(m: Mat3x4i): Mat3x4i = Mat3x4i(
    this.row0.dot(m.col0), this.row0.dot(m.col1), this.row0.dot(m.col2), this.row0.dot(m.col3),
    this.row1.dot(m.col0), this.row1.dot(m.col1), this.row1.dot(m.col2), this.row1.dot(m.col3),
    this.row2.dot(m.col0), this.row2.dot(m.col1), this.row2.dot(m.col2), this.row2.dot(m.col3)
  )

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def multiply(m: Mat3x4i): Mat3x4i = this * m

  /**
   * Returns the transposed of this matrix.
   *
   * The transposed of a matrix is obtained by switching its rows and its columns.
   *
   * @return The transposed of this matrix.
   */
  def transposed: Mat3i = Mat3i(
    this.m00, this.m10, this.m20,
    this.m01, this.m11, this.m21,
    this.m02, this.m12, this.m22
  )

  /**
   * Checks if this matrix is symmetric by checking if it is equal to its [[transposed]].
   *
   * @return True if this matrix is equal to its transposed, otherwise false.
   */
  def isSymmetric: Boolean = this == this.transposed

  /**
   * Checks if this matrix is skew-symmetric by checking if it is equal to its [[negated]] [[transposed]].
   *
   * @return True if this matrix is equal to its negated transposed, otherwise false.
   */
  def isSkewSymmetric: Boolean = this == this.negated.transposed

  /**
   * Returns a submatrix of this matrix obtained by removing the row at index `i` and the column at index `j`.
   *
   * @param i Index of the row to remove. Must be either 0, 1, or 2.
   * @param j Index of the column to remove. Must be either 0, 1, or 2.
   * @return A submatrix of this matrix.
   * @throws scala.MatchError if one of the given indices is out of bounds.
   */
  def submatrix(i: Int, j: Int): Mat2i = (i, j) match {
    case (0, 0) => Mat2i(this.m11, this.m12, this.m21, this.m22)
    case (0, 1) => Mat2i(this.m10, this.m12, this.m20, this.m22)
    case (0, 2) => Mat2i(this.m10, this.m11, this.m20, this.m21)
    case (1, 0) => Mat2i(this.m01, this.m02, this.m21, this.m22)
    case (1, 1) => Mat2i(this.m00, this.m02, this.m20, this.m22)
    case (1, 2) => Mat2i(this.m00, this.m01, this.m20, this.m21)
    case (2, 0) => Mat2i(this.m01, this.m02, this.m11, this.m12)
    case (2, 1) => Mat2i(this.m00, this.m02, this.m10, this.m12)
    case (2, 2) => Mat2i(this.m00, this.m01, this.m10, this.m11)
  }

  /**
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix.
   */
  def determinant: Int = this.m00 * (this.m11 * this.m22 - this.m21 * this.m12) - this.m01 * (this.m10 * this.m22 - this.m20 * this.m12) + this.m02 * (this.m10 * this.m21 - this.m20 * this.m11)

  /**
   * Returns the adjugate of this matrix.
   *
   * @return The adjugate of this matrix.
   */
  def adjugate: Mat3i = Mat3i(
    this.m11 * this.m22 - this.m21 * this.m12, this.m02 * this.m21 - this.m01 * this.m22, this.m01 * this.m12 - this.m11 * this.m02,
    this.m12 * this.m20 - this.m10 * this.m22, this.m00 * this.m22 - this.m20 * this.m02, this.m02 * this.m10 - this.m00 * this.m12,
    this.m10 * this.m21 - this.m20 * this.m11, this.m20 * this.m01 - this.m00 * this.m21, this.m00 * this.m11 - this.m10 * this.m01
  )

  /**
   * Raises this matrix to the given power by multiplying it with itself `exp` times and returns the result.
   *
   * If the given exponent is zero, the result will be the identity matrix.
   *
   * Unlike [[Mat3f.power]], this method does not allow negative exponents.
   *
   * @param exp The exponent to raise this matrix to.
   * @return This matrix raised to the given power.
   * @throws IllegalArgumentException If the given exponent is negative.
   */
  def power(exp: Int): Mat3i = {
    if (exp < 0) {
      throw new IllegalArgumentException("Negative exponents are not allowed for integer matrices")
    } else if (exp == 1) {
      this
    } else if (exp == 0) {
      Mat3i.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  /**
   * Returns a matrix with all elements in absolute value.
   *
   * @return A matrix with all elements in absolute value.
   */
  def abs: Mat3i = Mat3i(
    this.m00.abs, this.m01.abs, this.m02.abs,
    this.m10.abs, this.m11.abs, this.m12.abs,
    this.m20.abs, this.m21.abs, this.m22.abs
  )

  /**
   * Returns a matrix with the signs of the elements of this matrix.
   *
   * @return A matrix with all elements representing the sign of this matrix.
   */
  def sign: Mat3i = Mat3i(
    this.m00.sign, this.m01.sign, this.m02.sign,
    this.m10.sign, this.m11.sign, this.m12.sign,
    this.m20.sign, this.m21.sign, this.m22.sign
  )

  /**
   * Returns the element at the given row and column index.
   *
   * @param row The row index of the desired element. Must be either 0, 1, or 2.
   * @param col The column index of the desired element. Must be either 0, 1, or 2.
   * @return The element at the given row and column index.
   * @throws scala.MatchError If any of the given indices is out of bounds.
   */
  def apply(row: Int, col: Int): Int = (row, col) match {
    case (0, 0) => this.m00
    case (0, 1) => this.m01
    case (0, 2) => this.m02
    case (1, 0) => this.m10
    case (1, 1) => this.m11
    case (1, 2) => this.m12
    case (2, 0) => this.m20
    case (2, 1) => this.m21
    case (2, 2) => this.m22
  }

  /**
   * Returns this matrix as a float matrix.
   *
   * @return This matrix as a float matrix.
   */
  def toFloat: Mat3f = Mat3f(
    this.m00, this.m01, this.m02,
    this.m10, this.m11, this.m12,
    this.m20, this.m21, this.m22
  )

  /**
   * Returns this matrix as a double matrix.
   *
   * @return This matrix as a double matrix.
   */
  def toDouble: Mat3d = Mat3d(
    this.m00, this.m01, this.m02,
    this.m10, this.m11, this.m12,
    this.m20, this.m21, this.m22
  )
}

/**
 * Constants, factory methods, and implicits for matrices.
 */
object Mat3i {

  /** Shorthand for the zero matrix */
  val Zero: Mat3i = Mat3i(0, 0, 0, 0, 0, 0, 0, 0, 0)

  /** Shorthand for the identity matrix */
  val Identity: Mat3i = Mat3i(1, 0, 0, 0, 1, 0, 0, 0, 1)

  /**
   * Returns a 3x3 matrix from the given rows.
   *
   * @param row0 The first row.
   * @param row1 The second row.
   * @param row2 The third row.
   * @return A 3x3 matrix from the given rows.
   */
  def fromRows(row0: Vec3i, row1: Vec3i, row2: Vec3i): Mat3i = Mat3i(
    row0.x, row0.y, row0.z,
    row1.x, row1.y, row1.z,
    row2.x, row2.y, row2.z
  )

  /**
   * Returns a 3x3 matrix from the given columns.
   *
   * @param col0 The first column.
   * @param col1 The second column.
   * @param col2 The third column.
   * @return A 3x3 matrix from the given columns.
   */
  def fromColumns(col0: Vec3i, col1: Vec3i, col2: Vec3i): Mat3i = Mat3i(
    col0.x, col1.x, col2.x,
    col0.y, col1.y, col2.y,
    col0.z, col1.z, col2.z
  )

  /**
   * Allows to use the `*` operator with a scalar as `1 * matrix`.
   *
   * @param self The scalar value.
   */
  implicit class MultiplicationExtender(val self: Int) extends AnyVal {

    /**
     * Multiplies the given matrix by this scalar and returns the result.
     *
     * @param v The matrix to multiply.
     * @return The product between this scalar and the given matrix.
     */
    def *(v: Mat3i): Mat3i = v * self
  }

  /**
   * Implicit conversion from [[Mat3i]] to [[Mat3f]].
   */
  implicit val mat3iToMat3f: Mat3i => Mat3f = v => v.toFloat

  /**
   * Implicit conversion from [[Mat3i]] to [[Mat3d]].
   */
  implicit val mat3iToMat3d: Mat3i => Mat3d = v => v.toDouble
}
