package io.github.hexagonnico.vecmatlib.matrix

import io.github.hexagonnico.vecmatlib.vector._

/**
 * A 4x4 int matrix.
 *
 * @constructor Constructs a matrix from the given values.
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
case class Mat4i(
                  m00: Int, m01: Int, m02: Int, m03: Int,
                  m10: Int, m11: Int, m12: Int, m13: Int,
                  m20: Int, m21: Int, m22: Int, m23: Int,
                  m30: Int, m31: Int, m32: Int, m33: Int
                ) {

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def +(m: Mat4i): Mat4i = Mat4i(
    this.m00 + m.m00, this.m01 + m.m01, this.m02 + m.m02, this.m03 + m.m03,
    this.m10 + m.m10, this.m11 + m.m11, this.m12 + m.m12, this.m13 + m.m13,
    this.m20 + m.m20, this.m21 + m.m21, this.m22 + m.m22, this.m23 + m.m23,
    this.m30 + m.m30, this.m31 + m.m31, this.m32 + m.m32, this.m33 + m.m33
  )

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def plus(m: Mat4i): Mat4i = this + m

  /**
   * Returns this same matrix.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This matrix.
   */
  def unary_+(): Mat4i = this

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def -(m: Mat4i): Mat4i = Mat4i(
    this.m00 - m.m00, this.m01 - m.m01, this.m02 - m.m02, this.m03 - m.m03,
    this.m10 - m.m10, this.m11 - m.m11, this.m12 - m.m12, this.m13 - m.m13,
    this.m20 - m.m20, this.m21 - m.m21, this.m22 - m.m22, this.m23 - m.m23,
    this.m30 - m.m30, this.m31 - m.m31, this.m32 - m.m32, this.m33 - m.m33
  )

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def minus(m: Mat4i): Mat4i = this - m

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix.
   */
  def unary_-(): Mat4i = Mat4i(
    -this.m00, -this.m01, -this.m02, -this.m03,
    -this.m10, -this.m11, -this.m12, -this.m13,
    -this.m20, -this.m21, -this.m22, -this.m23,
    -this.m30, -this.m31, -this.m32, -this.m33
  )

  /**
   * Returns the additive inverse of this matrix.
   *
   * This method can be used in place of the unary `-` operator for better interoperability with Java.
   *
   * @return The additive inverse of this matrix.
   */
  def negated: Mat4i = -this

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def *(k: Int): Mat4i = Mat4i(
    this.m00 * k, this.m01 * k, this.m02 * k, this.m03 * k,
    this.m10 * k, this.m11 * k, this.m12 * k, this.m13 * k,
    this.m20 * k, this.m21 * k, this.m22 * k, this.m23 * k,
    this.m30 * k, this.m31 * k, this.m32 * k, this.m33 * k
  )

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def multipliedBy(k: Int): Mat4i = this * k

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * Note that this method performs an integer division.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def /(k: Int): Mat4i = Mat4i(
    this.m00 / k, this.m01 / k, this.m02 / k, this.m03 / k,
    this.m10 / k, this.m11 / k, this.m12 / k, this.m13 / k,
    this.m20 / k, this.m21 / k, this.m22 / k, this.m23 / k,
    this.m30 / k, this.m31 / k, this.m32 / k, this.m33 / k
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
  def dividedBy(k: Int): Mat4i = this / k

  /**
   * Returns the first row of this matrix as a [[Vec4i]].
   *
   * @return The first row of this matrix.
   * @see [[row]]
   */
  def row0: Vec4i = Vec4i(this.m00, this.m01, this.m02, this.m03)

  /**
   * Returns the second row of this matrix as a [[Vec4i]].
   *
   * @return The second row of this matrix.
   * @see [[row]]
   */
  def row1: Vec4i = Vec4i(this.m10, this.m11, this.m12, this.m13)

  /**
   * Returns the third row of this matrix as a [[Vec4i]].
   *
   * @return The third row of this matrix.
   * @see [[row]]
   */
  def row2: Vec4i = Vec4i(this.m20, this.m21, this.m22, this.m23)

  /**
   * Returns the fourth row of this matrix as a [[Vec4i]].
   *
   * @return The fourth row of this matrix.
   * @see [[row]]
   */
  def row3: Vec4i = Vec4i(this.m30, this.m31, this.m32, this.m33)

  /**
   * Returns the row at the given index as a [[Vec4i]].
   *
   * @param i The index of the requested row. Must be either 0, 1, 2, or 3.
   * @return The row at the given index.
   * @throws scala.MatchError If the given index is out of bounds.
   * @see [[row0]], [[row1]], [[row2]], and [[row3]]
   */
  def row(i: Int): Vec4i = i match {
    case 0 => this.row0
    case 1 => this.row1
    case 2 => this.row2
    case 3 => this.row3
  }

  /**
   * Returns the first column of this matrix as a [[Vec4i]].
   *
   * @return The first column of this matrix.
   * @see [[col]]
   */
  def col0: Vec4i = Vec4i(this.m00, this.m10, this.m20, this.m30)

  /**
   * Returns the second column of this matrix as a [[Vec4i]].
   *
   * @return The second column of this matrix.
   * @see [[col]]
   */
  def col1: Vec4i = Vec4i(this.m01, this.m11, this.m21, this.m31)

  /**
   * Returns the third column of this matrix as a [[Vec4i]].
   *
   * @return The third column of this matrix.
   * @see [[col]]
   */
  def col2: Vec4i = Vec4i(this.m02, this.m12, this.m22, this.m32)

  /**
   * Returns the fourth column of this matrix as a [[Vec4i]].
   *
   * @return The fourth column of this matrix.
   * @see [[col]]
   */
  def col3: Vec4i = Vec4i(this.m03, this.m13, this.m23, this.m33)

  /**
   * Returns the column at the given index as a [[Vec4i]].
   *
   * @param i The index of the requested column. Must be either 0, 1, 2, or 3.
   * @return The column at the given index.
   * @throws scala.MatchError If the given index is out of bounds.
   * @see [[col0]], [[col1]], [[col2]], and [[col3]]
   */
  def col(i: Int): Vec4i = i match {
    case 0 => this.col0
    case 1 => this.col1
    case 2 => this.col2
    case 3 => this.col3
  }

  /**
   * Multiplies this matrix by the given vector and returns the result.
   *
   * @param v The vector to multiply this matrix by.
   * @return The product of this matrix by the given vector.
   */
  def *(v: Vec4i): Vec4i = Vec4i(this.row0.dot(v), this.row1.dot(v), this.row2.dot(v), this.row3.dot(v))

  /**
   * Multiplies this matrix by the given vector and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param v The vector to multiply this matrix by.
   * @return The product of this matrix by the given vector.
   */
  def multiply(v: Vec4i): Vec4i = this * v

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * @param x The vector's x component.
   * @param y The vector's y component.
   * @param z The vector's z component.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(x: Int, y: Int, z: Int, w: Int): Vec4i = this * Vec4i(x, y, z, w)

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
  def multiply(x: Int, y: Int, z: Int, w: Int): Vec4i = this * (x, y, z, w)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * @param xyz The vector's x, y, and z components.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(xyz: Vec3i, w: Int): Vec4i = this * (xyz.x, xyz.y, xyz.z, w)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param xyz The vector's x, y, and z components.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def multiply(xyz: Vec3i, w: Int): Vec4i = this * (xyz, w)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(xy: Vec2i, z: Int, w: Int): Vec4i = this * (xy.x, xy.y, z, w)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def multiply(xy: Vec2i, z: Int, w: Int): Vec4i = this * (xy, z, w)

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def *(m: Mat4i): Mat4i = Mat4i(
    this.row0.dot(m.col0), this.row0.dot(m.col1), this.row0.dot(m.col2), this.row0.dot(m.col3),
    this.row1.dot(m.col0), this.row1.dot(m.col1), this.row1.dot(m.col2), this.row1.dot(m.col3),
    this.row2.dot(m.col0), this.row2.dot(m.col1), this.row2.dot(m.col2), this.row2.dot(m.col3),
    this.row3.dot(m.col0), this.row3.dot(m.col1), this.row3.dot(m.col2), this.row3.dot(m.col3)
  )

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def multiply(m: Mat4i): Mat4i = this * m

  /**
   * Returns the transposed of this matrix.
   *
   * The transposed of a matrix is obtained by switching its rows and its columns.
   *
   * @return The transposed of this matrix.
   */
  def transposed: Mat4i = Mat4i(
    this.m00, this.m10, this.m20, this.m30,
    this.m01, this.m11, this.m21, this.m31,
    this.m02, this.m12, this.m22, this.m32,
    this.m03, this.m13, this.m23, this.m33
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
   * @param i Index of the row to remove. Must be either 0, 1, 2, or 3.
   * @param j Index of the column to remove. Must be either 0, 1, 2, or 3.
   * @return A submatrix of this matrix.
   * @throws scala.MatchError if one of the given indices is out of bounds.
   */
  def submatrix(i: Int, j: Int): Mat3i = (i, j) match {
    case (0, 0) => Mat3i(this.m11, this.m12, this.m13, this.m21, this.m22, this.m23, this.m31, this.m32, this.m33)
    case (0, 1) => Mat3i(this.m10, this.m12, this.m13, this.m20, this.m22, this.m23, this.m30, this.m32, this.m33)
    case (0, 2) => Mat3i(this.m10, this.m11, this.m13, this.m20, this.m21, this.m23, this.m30, this.m31, this.m33)
    case (0, 3) => Mat3i(this.m10, this.m11, this.m12, this.m20, this.m21, this.m23, this.m30, this.m31, this.m32)
    case (1, 0) => Mat3i(this.m01, this.m02, this.m03, this.m21, this.m22, this.m23, this.m31, this.m32, this.m33)
    case (1, 1) => Mat3i(this.m00, this.m02, this.m03, this.m20, this.m22, this.m23, this.m30, this.m32, this.m33)
    case (1, 2) => Mat3i(this.m00, this.m01, this.m03, this.m20, this.m21, this.m23, this.m30, this.m31, this.m33)
    case (1, 3) => Mat3i(this.m00, this.m01, this.m02, this.m20, this.m21, this.m22, this.m30, this.m31, this.m32)
    case (2, 0) => Mat3i(this.m01, this.m02, this.m03, this.m11, this.m12, this.m13, this.m31, this.m32, this.m33)
    case (2, 1) => Mat3i(this.m00, this.m02, this.m03, this.m10, this.m12, this.m13, this.m30, this.m32, this.m33)
    case (2, 2) => Mat3i(this.m00, this.m01, this.m03, this.m10, this.m11, this.m13, this.m30, this.m31, this.m33)
    case (2, 3) => Mat3i(this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m30, this.m31, this.m23)
    case (3, 0) => Mat3i(this.m01, this.m02, this.m03, this.m11, this.m12, this.m12, this.m21, this.m22, this.m23)
    case (3, 1) => Mat3i(this.m00, this.m02, this.m03, this.m10, this.m12, this.m13, this.m20, this.m22, this.m23)
    case (3, 2) => Mat3i(this.m00, this.m01, this.m03, this.m10, this.m11, this.m13, this.m20, this.m21, this.m23)
    case (3, 3) => Mat3i(this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22)
  }

  /**
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix.
   */
  def determinant: Int = this.m00 * this.submatrix(0, 0).determinant - this.m01 * this.submatrix(0, 1).determinant + this.m02 * this.submatrix(0, 2).determinant - this.m03 * this.submatrix(0, 3).determinant

  /**
   * Returns the adjugate of this matrix.
   *
   * @return The adjugate of this matrix.
   */
  def adjugate: Mat4i = Mat4i(
    this.submatrix(0, 0).determinant, -this.submatrix(1, 0).determinant, this.submatrix(2, 0).determinant, -this.submatrix(3, 0).determinant,
    -this.submatrix(0, 1).determinant, this.submatrix(1, 1).determinant, -this.submatrix(2, 1).determinant, this.submatrix(3, 1).determinant,
    this.submatrix(0, 2).determinant, -this.submatrix(1, 2).determinant, this.submatrix(2, 2).determinant, -this.submatrix(3, 2).determinant,
    -this.submatrix(0, 3).determinant, this.submatrix(1, 3).determinant, -this.submatrix(2, 3).determinant, this.submatrix(3, 3).determinant
  )

  /**
   * Returns the inverse of this matrix.
   *
   * The result is undefined if this matrix is not invertible.
   * It is possible to check if the matrix is invertible by checking if its [[determinant]] is not zero.
   *
   * @return The inverse of this matrix.
   */
  def inverse: Mat4f = this.adjugate.toFloat / this.determinant

  /**
   * Raises this matrix to the given power by multiplying it with itself `exp` times and returns the result.
   *
   * If the given exponent is zero, the result will be the identity matrix.
   *
   * Unlike [[Mat4f.power]], this method does not allow negative exponents.
   *
   * @param exp The exponent to raise this matrix to.
   * @return This matrix raised to the given power.
   * @throws IllegalArgumentException If the given exponent is negative.
   */
  def power(exp: Int): Mat4i = {
    if (exp < 0) {
      throw new IllegalArgumentException("Negative exponents are not allowed for integer matrices")
    } else if (exp == 1) {
      this
    } else if (exp == 0) {
      Mat4i.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  /**
   * Returns a matrix with all elements in absolute value.
   *
   * @return A matrix with all elements in absolute value.
   */
  def abs: Mat4i = Mat4i(
    this.m00.abs, this.m01.abs, this.m02.abs, this.m03.abs,
    this.m10.abs, this.m11.abs, this.m12.abs, this.m13.abs,
    this.m20.abs, this.m21.abs, this.m22.abs, this.m23.abs,
    this.m30.abs, this.m31.abs, this.m32.abs, this.m33.abs
  )

  /**
   * Returns a matrix with the signs of the elements of this matrix.
   *
   * @return A matrix with all elements representing the sign of this matrix.
   */
  def sign: Mat4i = Mat4i(
    this.m00.sign, this.m01.sign, this.m02.sign, this.m03.sign,
    this.m10.sign, this.m11.sign, this.m12.sign, this.m13.sign,
    this.m20.sign, this.m21.sign, this.m22.sign, this.m23.sign,
    this.m30.sign, this.m31.sign, this.m32.sign, this.m33.sign
  )

  /**
   * Returns the element at the given row and column index.
   *
   * @param row The row index of the desired element. Must be either 0, 1, 2, or 3.
   * @param col The column index of the desired element. Must be either 0, 1, 2, or 3.
   * @return The element at the given row and column index.
   * @throws scala.MatchError If any of the given indices is out of bounds.
   */
  def apply(row: Int, col: Int): Int = (row, col) match {
    case (0, 0) => this.m00
    case (0, 1) => this.m01
    case (0, 2) => this.m02
    case (0, 3) => this.m03
    case (1, 0) => this.m10
    case (1, 1) => this.m11
    case (1, 2) => this.m12
    case (1, 3) => this.m13
    case (2, 0) => this.m20
    case (2, 1) => this.m21
    case (2, 2) => this.m22
    case (2, 3) => this.m23
    case (3, 0) => this.m30
    case (3, 1) => this.m31
    case (3, 2) => this.m32
    case (3, 3) => this.m33
  }

  /**
   * Returns this matrix as a float matrix.
   *
   * @return This matrix as a float matrix.
   */
  def toFloat: Mat4f = Mat4f(
    this.m00, this.m01, this.m02, this.m03,
    this.m10, this.m11, this.m12, this.m13,
    this.m20, this.m21, this.m22, this.m23,
    this.m30, this.m31, this.m32, this.m33
  )

  /**
   * Returns this matrix as a double matrix.
   *
   * @return This matrix as a double matrix.
   */
  def toDouble: Mat4d = Mat4d(
    this.m00, this.m01, this.m02, this.m03,
    this.m10, this.m11, this.m12, this.m13,
    this.m20, this.m21, this.m22, this.m23,
    this.m30, this.m31, this.m32, this.m33
  )
}

/**
 * Constants, factory methods, and implicits for matrices.
 */
object Mat4i {

  /** Shorthand for the zero matrix */
  val Zero: Mat4i = Mat4i(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

  /** Shorthand for the identity matrix */
  val Identity: Mat4i = Mat4i(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1)

  /**
   * Returns a 4x4 matrix from the given rows.
   *
   * @param row0 The first row.
   * @param row1 The second row.
   * @param row2 The third row.
   * @param row3 The fourth row.
   * @return A 4x4 matrix from the given rows.
   */
  def fromRows(row0: Vec4i, row1: Vec4i, row2: Vec4i, row3: Vec4i): Mat4i = Mat4i(
    row0.x, row0.y, row0.z, row0.w,
    row1.x, row1.y, row1.z, row1.w,
    row2.x, row2.y, row2.z, row2.w,
    row3.x, row3.y, row3.z, row3.w
  )

  /**
   * Returns a 4x4 matrix from the given columns.
   *
   * @param col0 The first column.
   * @param col1 The second column.
   * @param col2 The third column.
   * @param col3 The fourth column.
   * @return A 4x4 matrix from the given columns.
   */
  def fromColumns(col0: Vec4i, col1: Vec4i, col2: Vec4i, col3: Vec4i): Mat4i = Mat4i(
    col0.x, col1.x, col2.x, col3.x,
    col0.y, col1.y, col2.y, col3.y,
    col0.z, col1.z, col2.z, col3.z,
    col0.w, col1.w, col2.w, col3.w
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
    def *(v: Mat4i): Mat4i = v * self
  }

  /**
   * Implicit conversion from [[Mat4i]] to [[Mat4f]].
   */
  implicit val mat3iToMat4f: Mat4i => Mat4f = v => v.toFloat

  /**
   * Implicit conversion from [[Mat4i]] to [[Mat4d]].
   */
  implicit val mat3iToMat4d: Mat4i => Mat4d = v => v.toDouble
}
