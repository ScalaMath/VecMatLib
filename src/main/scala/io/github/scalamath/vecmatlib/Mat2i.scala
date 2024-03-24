package io.github.scalamath.vecmatlib

/**
 * A 2x2 int matrix.
 *
 * @constructor Constructs a matrix from the given values.
 * @param m00 Element 0 0
 * @param m01 Element 0 1
 * @param m10 Element 1 0
 * @param m11 Element 1 1
 */
case class Mat2i(m00: Int, m01: Int, m10: Int, m11: Int) {

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def +(m: Mat2i): Mat2i = Mat2i(
    this.m00 + m.m00, this.m01 + m.m01,
    this.m10 + m.m10, this.m11 + m.m11
  )

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def plus(m: Mat2i): Mat2i = this + m

  /**
   * Returns this exact matrix.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This exact matrix.
   */
  def unary_+(): Mat2i = this

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def -(m: Mat2i): Mat2i = Mat2i(
    this.m00 - m.m00, this.m01 - m.m01,
    this.m10 - m.m10, this.m11 - m.m11
  )

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def minus(m: Mat2i): Mat2i = this - m

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix.
   */
  def unary_-(): Mat2i = Mat2i(
    -this.m00, -this.m01,
    -this.m10, -this.m11
  )

  /**
   * Returns the additive inverse of this matrix.
   *
   * This method can be used in place of the unary `-` operator for better interoperability with Java.
   *
   * @return The additive inverse of this matrix.
   */
  def negated: Mat2i = -this

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def *(k: Int): Mat2i = Mat2i(
    this.m00 * k, this.m01 * k,
    this.m10 * k, this.m11 * k
  )

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def multipliedBy(k: Int): Mat2i = this * k

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * Note that this method performs an integer division.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def /(k: Int): Mat2i = Mat2i(
    this.m00 / k, this.m01 / k,
    this.m10 / k, this.m11 / k
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
  def dividedBy(k: Int): Mat2i = this / k

  /**
   * Returns the first row of this matrix as a [[Vec2i]].
   *
   * @return The first row of this matrix.
   * @see [[row]]
   */
  def row0: Vec2i = Vec2i(this.m00, this.m01)

  /**
   * Returns the second row of this matrix as a [[Vec2i]].
   *
   * @return The second row of this matrix.
   * @see [[row]]
   */
  def row1: Vec2i = Vec2i(this.m10, this.m11)

  /**
   * Returns the row at the given index as a [[Vec2i]].
   *
   * @param i The index of the requested row. Must be either 0 or 1.
   * @return The row at the given index.
   * @throws scala.MatchError If the given index is out of bounds.
   * @see [[row0]] and [[row1]]
   */
  def row(i: Int): Vec2i = i match {
    case 0 => this.row0
    case 1 => this.row1
  }

  /**
   * Returns the first column of this matrix as a [[Vec2i]].
   *
   * @return The first column of this matrix.
   * @see [[col]]
   */
  def col0: Vec2i = Vec2i(this.m00, this.m10)

  /**
   * Returns the second column of this matrix as a [[Vec2i]].
   *
   * @return The second column of this matrix.
   * @see [[col]]
   */
  def col1: Vec2i = Vec2i(this.m01, this.m11)

  /**
   * Returns the column at the given index as a [[Vec2i]].
   *
   * @param i The index of the requested column. Must be either 0 or 1.
   * @return The column at the given index.
   * @throws scala.MatchError If the given index is out of bounds.
   * @see [[col0]] and [[col1]]
   */
  def col(i: Int): Vec2i = i match {
    case 0 => this.col0
    case 1 => this.col1
  }

  /**
   * Multiplies this matrix by the given vector and returns the result.
   *
   * @param v The vector to multiply this matrix by.
   * @return The product of this matrix by the given vector.
   */
  def *(v: Vec2i): Vec2i = Vec2i(this.row0.dot(v), this.row1.dot(v))

  /**
   * Multiplies this matrix by the given vector and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param v The vector to multiply this matrix by.
   * @return The product of this matrix by the given vector.
   */
  def multiply(v: Vec2i): Vec2i = this * v

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * @param x The vector's x component.
   * @param y The vector's y component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(x: Int, y: Int): Vec2i = this * Vec2i(x, y)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param x The vector's x component.
   * @param y The vector's y component.
   * @return The product of this matrix by the vector with the given components.
   */
  def multiply(x: Int, y: Int): Vec2i = this * (x, y)

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def *(m: Mat2i): Mat2i = Mat2i(
    this.row0.dot(m.col0), this.row0.dot(m.col1),
    this.row1.dot(m.col0), this.row1.dot(m.col1)
  )

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def multiply(m: Mat2i): Mat2i = this * m

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def *(m: Mat2x3i): Mat2x3i = Mat2x3i(
    this.row0.dot(m.col0), this.row0.dot(m.col1), this.row0.dot(m.col2),
    this.row1.dot(m.col0), this.row1.dot(m.col1), this.row1.dot(m.col2)
  )

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def multiply(m: Mat2x3i): Mat2x3i = this * m

  /**
   * Returns the transposed of this matrix.
   *
   * The transposed of a matrix is obtained by switching its rows and its columns.
   *
   * @return The transposed of this matrix.
   */
  def transposed: Mat2i = Mat2i(
    this.m00, this.m10,
    this.m01, this.m11
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
   * Returns the determinant of this matrix.
   *
   * For a 2x2 matrix `[a, b, c, d]`, the determinant is `ad - bc`.
   *
   * @return The determinant of this matrix.
   */
  def determinant: Int = this.m00 * this.m11 - this.m01 * this.m10

  /**
   * Returns the adjugate of this matrix.
   *
   * For a 2x2 matrix `[a, b, c, d]`, the adjugate is defined as the 2x2 matrix `[d, -b, -c, a]`.
   *
   * @return The adjugate of this matrix.
   */
  def adjugate: Mat2i = Mat2i(
    this.m11, -this.m01,
    -this.m10, this.m00
  )

  /**
   * Raises this matrix to the given power by multiplying it with itself `exp` times and returns the result.
   *
   * If the given exponent is zero, the result will be the identity matrix.
   *
   * Unlike [[Mat2f.power]], this method does not allow negative exponents.
   *
   * @param exp The exponent to raise this matrix to.
   * @return This matrix raised to the given power.
   * @throws IllegalArgumentException If the given exponent is negative.
   */
  def power(exp: Int): Mat2i = {
    if (exp < 0) {
      throw new IllegalArgumentException("Negative exponents are not allowed for integer matrices")
    } else if (exp == 1) {
      this
    } else if (exp == 0) {
      Mat2i.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  /**
   * Returns a matrix with all elements in absolute value.
   *
   * @return A matrix with all elements in absolute value.
   */
  def abs: Mat2i = Mat2i(
    this.m00.abs, this.m01.abs,
    this.m10.abs, this.m11.abs
  )

  /**
   * Returns a matrix with the signs of the elements of this matrix.
   *
   * @return A matrix with all elements representing the sign of this matrix.
   */
  def sign: Mat2i = Mat2i(
    this.m00.sign, this.m01.sign,
    this.m10.sign, this.m11.sign
  )

  /**
   * Returns the element at the given row and column index.
   *
   * @param row The row index of the desired element. Must be either 0 or 1.
   * @param col The column index of the desired element. Must be either 0 or 1.
   * @return The element at the given row and column index.
   * @throws scala.MatchError If any of the given indices is out of bounds.
   */
  def apply(row: Int, col: Int): Int = (row, col) match {
    case (0, 0) => this.m00
    case (0, 1) => this.m01
    case (1, 0) => this.m10
    case (1, 1) => this.m11
  }

  /**
   * Returns this matrix as a float matrix.
   *
   * @return This matrix as a float matrix.
   */
  def toFloat: Mat2f = Mat2f(this.m00, this.m01, this.m10, this.m11)

  /**
   * Returns this matrix as a double matrix.
   *
   * @return This matrix as a double matrix.
   */
  def toDouble: Mat2d = Mat2d(this.m00, this.m01, this.m10, this.m11)
}

/**
 * Constants, factory methods, and implicits for matrices.
 */
object Mat2i {

  /** Shorthand for an identity matrix */
  val Identity: Mat2i = Mat2i(1, 0, 0, 1)

  /** Shorthand for the zero matrix */
  val Zero: Mat2i = Mat2i(0, 0, 0, 0)

  /**
   * Returns a 2x2 matrix from the given rows.
   *
   * @param row0 The first row.
   * @param row1 The second row.
   * @return A 2x2 matrix from the given rows.
   */
  def fromRows(row0: Vec2i, row1: Vec2i): Mat2i = Mat2i(row0.x, row0.y, row1.x, row1.y)

  /**
   * Returns a 2x2 matrix from the given columns.
   *
   * @param col0 The first column.
   * @param col1 The second column.
   * @return A 2x2 matrix from the given columns.
   */
  def fromColumns(col0: Vec2i, col1: Vec2i): Mat2i = Mat2i(col0.x, col1.x, col0.y, col1.y)

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
    def *(v: Mat2i): Mat2i = v * self
  }

  /**
   * Implicit conversion from [[Mat2i]] to [[Mat2f]].
   */
  implicit val mat2iToMat2f: Mat2i => Mat2f = v => v.toFloat

  /**
   * Implicit conversion from [[Mat2i]] to [[Mat2d]].
   */
  implicit val mat2iToMat2d: Mat2i => Mat2d = v => v.toDouble
}
