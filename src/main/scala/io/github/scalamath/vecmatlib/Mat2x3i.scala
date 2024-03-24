package io.github.scalamath.vecmatlib

/**
 * A 2x3 (two rows and three columns) int matrix.
 *
 * @constructor Constructs a matrix from the given values.
 * @param m00 Element 0 0
 * @param m01 Element 0 1
 * @param m02 Element 0 2
 * @param m10 Element 1 0
 * @param m11 Element 1 1
 * @param m12 Element 1 2
 */
case class Mat2x3i(m00: Int, m01: Int, m02: Int, m10: Int, m11: Int, m12: Int) {

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def +(m: Mat2x3i): Mat2x3i = Mat2x3i(
    this.m00 + m.m00, this.m01 + m.m01, this.m02 + m.m02,
    this.m10 + m.m10, this.m11 + m.m11, this.m12 + m.m12
  )

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def plus(m: Mat2x3i): Mat2x3i = this + m

  /**
   * Returns this exact matrix.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This exact matrix.
   */
  def unary_+ : Mat2x3i = this

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def -(m: Mat2x3i): Mat2x3i = Mat2x3i(
    this.m00 - m.m00, this.m01 - m.m01, this.m02 - m.m02,
    this.m10 - m.m10, this.m11 - m.m11, this.m12 - m.m12
  )

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def minus(m: Mat2x3i): Mat2x3i = this - m

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix.
   */
  def unary_- : Mat2x3i = Mat2x3i(
    -this.m00, -this.m01, -this.m02,
    -this.m10, -this.m11, -this.m12
  )

  /**
   * Returns the additive inverse of this matrix.
   *
   * This method can be used in place of the unary `-` operator for better interoperability with Java.
   *
   * @return The additive inverse of this matrix.
   */
  def negated: Mat2x3i = -this

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def *(k: Int): Mat2x3i = Mat2x3i(
    this.m00 * k, this.m01 * k, this.m02 * k,
    this.m10 * k, this.m11 * k, this.m12 * k
  )

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def multipliedBy(k: Int): Mat2x3i = this * k

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * Note that this method performs an integer division.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def /(k: Int): Mat2x3i = Mat2x3i(
    this.m00 / k, this.m01 / k, this.m02 / k,
    this.m10 / k, this.m11 / k, this.m12 / k
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
  def dividedBy(k: Int): Mat2x3i = this / k

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
   * Returns the row at the given index as a [[Vec3i]].
   *
   * @param i The index of the requested row. Must be either 0 or 1.
   * @return The row at the given index.
   * @throws scala.MatchError If the given index is out of bounds.
   * @see [[row0]] and [[row1]]
   */
  def row(i: Int): Vec3i = i match {
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
   * Returns the third column of this matrix as a [[Vec2i]].
   *
   * @return The third column of this matrix.
   * @see [[col]]
   */
  def col2: Vec2i = Vec2i(this.m02, this.m12)

  /**
   * Returns the column at the given index as a [[Vec2i]].
   *
   * @param i The index of the requested column. Must be either 0, 1, or 2.
   * @return The column at the given index.
   * @throws scala.MatchError If the given index is out of bounds.
   * @see [[col0]], [[col1]], and [[col2]]
   */
  def col(i: Int): Vec2i = i match {
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
  def *(v: Vec3i): Vec2i = Vec2i(this.row0.dot(v), this.row1.dot(v))

  /**
   * Multiplies this matrix by the given vector and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param v The vector to multiply this matrix by.
   * @return The product of this matrix by the given vector.
   */
  def multiply(v: Vec3i): Vec2i = this * v

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * @param x The vector's x component.
   * @param y The vector's y component.
   * @param z The vector's z component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(x: Int, y: Int, z: Int): Vec2i = this * Vec3i(x, y, z)

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
  def multiply(x: Int, y: Int, z: Int): Vec2i = this * (x, y, z)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(xy: Vec2i, z: Int): Vec2i = this * (xy.x, xy.y, z)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   * @return The product of this matrix by the vector with the given components.
   */
  def multiply(xy: Vec2i, z: Int): Vec2i = this * (xy, z)

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def *(m: Mat3i): Mat2x3i = Mat2x3i(
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
  def multiply(m: Mat3i): Mat2x3i = this * m

  /**
   * Returns a matrix with all elements in absolute value.
   *
   * @return A matrix with all elements in absolute value.
   */
  def abs: Mat2x3i = Mat2x3i(
    this.m00.abs, this.m01.abs, this.m02.abs,
    this.m10.abs, this.m11.abs, this.m12.abs
  )

  /**
   * Returns a matrix with the signs of the elements of this matrix.
   *
   * @return A matrix with all elements representing the sign of this matrix.
   */
  def sign: Mat2x3i = Mat2x3i(
    this.m00.sign, this.m01.sign, this.m02.sign,
    this.m10.sign, this.m11.sign, this.m12.sign
  )

  /**
   * Returns the element at the given row and column index.
   *
   * @param row The row index of the desired element. Must be either 0 or 1.
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
  }

  /**
   * Returns this matrix as a float matrix.
   *
   * @return This matrix as a float matrix.
   */
  def toFloat: Mat2x3f = Mat2x3f(this.m00.toFloat, this.m01.toFloat, this.m02.toFloat, this.m10.toFloat, this.m11.toFloat, this.m12.toFloat)

  /**
   * Returns this matrix as a double matrix.
   *
   * @return This matrix as a double matrix.
   */
  def toDouble: Mat2x3d = Mat2x3d(this.m00.toDouble, this.m01.toDouble, this.m02.toDouble, this.m10.toDouble, this.m11.toDouble, this.m12.toDouble)
}

/**
 * Constants, factory methods, and implicits for matrices.
 */
object Mat2x3i {

  /** Shorthand for the zero matrix */
  val Zero: Mat2x3i = Mat2x3i(0, 0, 0, 0, 0, 0)

  /**
   * Returns a 2x3 matrix from the given rows.
   *
   * @param row0 The first row.
   * @param row1 The second row.
   * @return A 2x3 matrix from the given rows.
   */
  def fromRows(row0: Vec3i, row1: Vec3i): Mat2x3i = Mat2x3i(row0.x, row0.y, row0.z, row1.x, row1.y, row1.z)

  /**
   * Returns a 2x3 matrix from the given columns.
   *
   * @param col0 The first column.
   * @param col1 The second column.
   * @param col2 The third column.
   * @return A 2x3 matrix from the given columns.
   */
  def fromColumns(col0: Vec2i, col1: Vec2i, col2: Vec2i): Mat2x3i = Mat2x3i(col0.x, col1.x, col2.x, col0.y, col1.y, col2.y)

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
    def *(v: Mat2x3i): Mat2x3i = v * self
  }

  /**
   * Implicit conversion from [[Mat2x3i]] to [[Mat2x3f]].
   */
  implicit val mat2x3iTomMat2x3f: Mat2x3i => Mat2x3f = v => v.toFloat

  /**
   * Implicit conversion from [[Mat2x3i]] to [[Mat2x3d]].
   */
  implicit val mat2x3iTomMat2x3d: Mat2x3i => Mat2x3d = v => v.toDouble
}