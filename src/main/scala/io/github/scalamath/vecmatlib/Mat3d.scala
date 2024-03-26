package io.github.scalamath.vecmatlib

import io.github.scalamath
import io.github.scalamath.DoubleEqualsApprox

/**
 * A 3x3 double matrix.
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
case class Mat3d(
                  m00: Double, m01: Double, m02: Double,
                  m10: Double, m11: Double, m12: Double,
                  m20: Double, m21: Double, m22: Double
                ) {

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def +(m: Mat3d): Mat3d = Mat3d(
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
  def plus(m: Mat3d): Mat3d = this + m

  /**
   * Returns this same matrix.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This matrix.
   */
  def unary_+ : Mat3d = this

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def -(m: Mat3d): Mat3d = Mat3d(
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
  def minus(m: Mat3d): Mat3d = this - m

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix.
   */
  def unary_- : Mat3d = Mat3d(
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
  def negated: Mat3d = -this

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def *(k: Double): Mat3d = Mat3d(
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
  def multipliedBy(k: Double): Mat3d = this * k

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def /(k: Double): Mat3d = Mat3d(
    this.m00 / k, this.m01 / k, this.m02 / k,
    this.m10 / k, this.m11 / k, this.m12 / k,
    this.m20 / k, this.m21 / k, this.m22 / k
  )

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def dividedBy(k: Double): Mat3d = this / k

  /**
   * Returns the first row of this matrix as a [[Vec3d]].
   *
   * @return The first row of this matrix.
   * @see [[row]]
   */
  def row0: Vec3d = Vec3d(this.m00, this.m01, this.m02)

  /**
   * Returns the second row of this matrix as a [[Vec3d]].
   *
   * @return The second row of this matrix.
   * @see [[row]]
   */
  def row1: Vec3d = Vec3d(this.m10, this.m11, this.m12)

  /**
   * Returns the third row of this matrix as a [[Vec3d]].
   *
   * @return The third row of this matrix.
   * @see [[row]]
   */
  def row2: Vec3d = Vec3d(this.m20, this.m21, this.m22)

  /**
   * Returns the row at the given index as a [[Vec3d]].
   *
   * @param i The index of the requested row. Must be either 0, 1, or 2.
   * @return The row at the given index.
   * @throws MatchError If the given index is out of bounds.
   * @see [[row0]], [[row1]], and [[row2]]
   */
  def row(i: Int): Vec3d = i match {
    case 0 => this.row0
    case 1 => this.row1
    case 2 => this.row2
  }

  /**
   * Returns the first column of this matrix as a [[Vec3d]].
   *
   * @return The first column of this matrix.
   * @see [[col]]
   */
  def col0: Vec3d = Vec3d(this.m00, this.m10, this.m20)

  /**
   * Returns the second column of this matrix as a [[Vec3d]].
   *
   * @return The second column of this matrix.
   * @see [[col]]
   */
  def col1: Vec3d = Vec3d(this.m01, this.m11, this.m21)

  /**
   * Returns the third column of this matrix as a [[Vec3d]].
   *
   * @return The third column of this matrix.
   * @see [[col]]
   */
  def col2: Vec3d = Vec3d(this.m02, this.m12, this.m22)

  /**
   * Returns the column at the given index as a [[Vec3d]].
   *
   * @param i The index of the requested column. Must be either 0, 1, or 2.
   * @return The column at the given index.
   * @throws MatchError If the given index is out of bounds.
   * @see [[col0]], [[col1]], and [[col2]]
   */
  def col(i: Int): Vec3d = i match {
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
  def *(v: Vec3d): Vec3d = Vec3d(this.row0.dot(v), this.row1.dot(v), this.row2.dot(v))

  /**
   * Multiplies this matrix by the given vector and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param v The vector to multiply this matrix by.
   * @return The product of this matrix by the given vector.
   */
  def multiply(v: Vec3d): Vec3d = this * v

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * @param x The vector's x component.
   * @param y The vector's y component.
   * @param z The vector's z component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(x: Double, y: Double, z: Double): Vec3d = this * Vec3d(x, y, z)

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
  def multiply(x: Double, y: Double, z: Double): Vec3d = this * (x, y, z)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * Useful to simplify the transformation of a 2D point.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(xy: Vec2d, z: Double): Vec3d = this * (xy.x, xy.y, z)

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
  def multiply(xy: Vec2d, z: Double): Vec3d = this * (xy, z)

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def *(m: Mat3d): Mat3d = Mat3d(
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
  def multiply(m: Mat3d): Mat3d = this * m

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def *(m: Mat3x4d): Mat3x4d = Mat3x4d(
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
  def multiply(m: Mat3x4d): Mat3x4d = this * m

  /**
   * Returns the transposed of this matrix.
   *
   * The transposed of a matrix is obtained by switching its rows and its columns.
   *
   * @return The transposed of this matrix.
   */
  def transposed: Mat3d = Mat3d(
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
   * @throws MatchError if one of the given indices is out of bounds.
   */
  def submatrix(i: Int, j: Int): Mat2d = (i, j) match {
    case (0, 0) => Mat2d(this.m11, this.m12, this.m21, this.m22)
    case (0, 1) => Mat2d(this.m10, this.m12, this.m20, this.m22)
    case (0, 2) => Mat2d(this.m10, this.m11, this.m20, this.m21)
    case (1, 0) => Mat2d(this.m01, this.m02, this.m21, this.m22)
    case (1, 1) => Mat2d(this.m00, this.m02, this.m20, this.m22)
    case (1, 2) => Mat2d(this.m00, this.m01, this.m20, this.m21)
    case (2, 0) => Mat2d(this.m01, this.m02, this.m11, this.m12)
    case (2, 1) => Mat2d(this.m00, this.m02, this.m10, this.m12)
    case (2, 2) => Mat2d(this.m00, this.m01, this.m10, this.m11)
  }

  /**
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix.
   */
  def determinant: Double = this.m00 * (this.m11 * this.m22 - this.m21 * this.m12) - this.m01 * (this.m10 * this.m22 - this.m20 * this.m12) + this.m02 * (this.m10 * this.m21 - this.m20 * this.m11)

  /**
   * Returns the adjugate of this matrix.
   *
   * @return The adjugate of this matrix.
   */
  def adjugate: Mat3d = Mat3d(
    this.m11 * this.m22 - this.m21 * this.m12, this.m02 * this.m21 - this.m01 * this.m22, this.m01 * this.m12 - this.m11 * this.m02,
    this.m12 * this.m20 - this.m10 * this.m22, this.m00 * this.m22 - this.m20 * this.m02, this.m02 * this.m10 - this.m00 * this.m12,
    this.m10 * this.m21 - this.m20 * this.m11, this.m20 * this.m01 - this.m00 * this.m21, this.m00 * this.m11 - this.m10 * this.m01
  )

  /**
   * Returns the inverse of this matrix.
   *
   * The result is undefined if this matrix is not invertible.
   * It is possible to check if the matrix is invertible by checking if its [[determinant]] is not zero.
   *
   * @return The inverse of this matrix.
   */
  def inverse: Mat3d = this.adjugate / this.determinant

  /**
   * Raises this matrix to the given power by multiplying it with itself `exp` times and returns the result.
   *
   * If the given exponent is zero, the result will be the identity matrix.
   *
   * A matrix raised to a negative power is defined as the [[inverse]] matrix raised to `-exp`.
   * The result is undefined if the given exponent is negative and this matrix is not invertible.
   *
   * @param exp The exponent to raise this matrix to.
   * @return This matrix raised to the given power.
   */
  def power(exp: Int): Mat3d = {
    if (exp < 0) {
      this.inverse.power(-exp)
    } else if (exp == 1) {
      this
    } else if (exp == 0) {
      Mat3d.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  /**
   * Computes the linear interpolation between the elements of this matrix and the elements of the given one by the given weight and returns the result.
   *
   * The given weight must be in the `[0.0, 1.0]` range, representing the amount of interpolation.
   *
   * @param to The second matrix.
   * @param weight The weight of the interpolation between `0.0` and `1.0`.
   * @return The result of linearly interpolating between the elements of this matrix and the elements of the given one.
   */
  def lerp(to: Mat3d, weight: Double): Mat3d = Mat3d(
    scalamath.lerp(this.m00, to.m00, weight), scalamath.lerp(this.m01, to.m01, weight), scalamath.lerp(this.m02, to.m02, weight),
    scalamath.lerp(this.m10, to.m10, weight), scalamath.lerp(this.m11, to.m11, weight), scalamath.lerp(this.m12, to.m12, weight),
    scalamath.lerp(this.m20, to.m20, weight), scalamath.lerp(this.m21, to.m21, weight), scalamath.lerp(this.m22, to.m22, weight)
  )

  /**
   * Returns a matrix with all elements in absolute value.
   *
   * @return A matrix with all elements in absolute value.
   */
  def abs: Mat3d = Mat3d(
    this.m00.abs, this.m01.abs, this.m02.abs,
    this.m10.abs, this.m11.abs, this.m12.abs,
    this.m20.abs, this.m21.abs, this.m22.abs
  )

  /**
   * Returns a matrix with the signs of the elements of this matrix.
   *
   * @return A matrix with all elements representing the sign of this matrix.
   */
  def sign: Mat3d = Mat3d(
    this.m00.sign, this.m01.sign, this.m02.sign,
    this.m10.sign, this.m11.sign, this.m12.sign,
    this.m20.sign, this.m21.sign, this.m22.sign
  )

  /**
   * Returns a matrix with all elements rounded to the nearest integer.
   *
   * @return A matrix with all elements rounded to the nearest integer.
   */
  def round: Mat3d = Mat3d(
    this.m00.round.toDouble, this.m01.round.toDouble, this.m02.round.toDouble,
    this.m10.round.toDouble, this.m11.round.toDouble, this.m12.round.toDouble,
    this.m20.round.toDouble, this.m21.round.toDouble, this.m22.round.toDouble
  )

  /**
   * Returns a matrix with all elements rounded up.
   *
   * @return A matrix with all elements rounded up.
   */
  def ceil: Mat3d = Mat3d(
    this.m00.ceil, this.m01.ceil, this.m02.ceil,
    this.m10.ceil, this.m11.ceil, this.m12.ceil,
    this.m20.ceil, this.m21.ceil, this.m22.ceil
  )

  /**
   * Returns a matrix with all elements rounded down.
   *
   * @return A matrix with all elements rounded down.
   */
  def floor: Mat3d = Mat3d(
    this.m00.floor, this.m01.floor, this.m02.floor,
    this.m10.floor, this.m11.floor, this.m12.floor,
    this.m20.floor, this.m21.floor, this.m22.floor
  )

  /**
   * Constructs an orthonormal matrix from the columns of this matrix using the Gram-Schmidt procedure.
   *
   * @return This matrix with orthogonal columns of unit length.
   */
  def orthonormalized: Mat3d = {
    var (v0, v1, v2) = (this.col0, this.col1, this.col2)
    v1 = v1 - v1.project(v0)
    v2 = v2 - v2.project(v0) - v2.project(v1)
    Mat3d.fromColumns(v0.normalized, v1.normalized, v2.normalized)
  }

  /**
   * Checks if this matrix is approximately equal to the given one using an internal epsilon.
   *
   * @param m The second matrix.
   * @return True if this matrix is approximately equal to the given one, otherwise false.
   */
  def ~=(m: Mat3d): Boolean = (this.m00 ~= m.m00) && (this.m01 ~= m.m01) && (this.m02 ~= m.m02) &&
    (this.m10 ~= m.m10) && (this.m11 ~= m.m11) && (this.m12 ~= m.m12) &&
    (this.m20 ~= m.m20) && (this.m21 ~= m.m21) && (this.m22 ~= m.m22)

  /**
   * Checks if this matrix is approximately equal to the given one using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator.
   *
   * @param m The second matrix.
   * @return True if this matrix is approximately equal to the given one, otherwise false.
   */
  def equalsApprox(m: Mat3d): Boolean = this ~= m

  /**
   * Returns the element at the given row and column index.
   *
   * @param row The row index of the desired element. Must be either 0, 1, or 2.
   * @param col The column index of the desired element. Must be either 0, 1, or 2.
   * @return The element at the given row and column index.
   * @throws MatchError If any of the given indices is out of bounds.
   */
  def apply(row: Int, col: Int): Double = (row, col) match {
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
   * Casts this matrix to an int matrix.
   *
   * @return This matrix cast to int.
   */
  def toInt: Mat3i = Mat3i(
    this.m00.toInt, this.m01.toInt, this.m02.toInt,
    this.m10.toInt, this.m11.toInt, this.m12.toInt,
    this.m20.toInt, this.m21.toInt, this.m22.toInt
  )

  /**
   * Casts this matrix to a float matrix.
   *
   * @return This matrix cast to float.
   */
  def toFloat: Mat3f = Mat3f(
    this.m00.toFloat, this.m01.toFloat, this.m02.toFloat,
    this.m10.toFloat, this.m11.toFloat, this.m12.toFloat,
    this.m20.toFloat, this.m21.toFloat, this.m22.toFloat
  )
}

/**
 * Constants, factory methods, and implicits for matrices.
 */
object Mat3d {

  /** Shorthand for the zero matrix */
  val Zero: Mat3d = Mat3d(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)

  /** Shorthand for the identity matrix */
  val Identity: Mat3d = Mat3d(1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0)

  /**
   * Returns a 3x3 matrix from the given rows.
   *
   * @param row0 The first row.
   * @param row1 The second row.
   * @param row2 The third row.
   * @return A 3x3 matrix from the given rows.
   */
  def fromRows(row0: Vec3d, row1: Vec3d, row2: Vec3d): Mat3d = Mat3d(
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
  def fromColumns(col0: Vec3d, col1: Vec3d, col2: Vec3d): Mat3d = Mat3d(
    col0.x, col1.x, col2.x,
    col0.y, col1.y, col2.y,
    col0.z, col1.z, col2.z
  )

  /**
   * Returns a 3x3 matrix representing a translation in a 2D space.
   *
   * A translation can be applied to a vector by multiplying it with this matrix as `m * (v, 1.0)` or `m.multiply(v, 1.0)`.
   *
   * @param x Translation on the x axis.
   * @param y Translation on the y axis.
   * @return A 3x3 matrix representing a translation in a 2D space.
   */
  def translation(x: Double, y: Double): Mat3d = Mat3d(1.0, 0.0, x, 0.0, 1.0, y, 0.0, 0.0, 1.0)

  /**
   * Returns a 3x3 matrix representing a translation in a 2D space.
   *
   * A translation can be applied to a vector by multiplying it with this matrix as `m * (v, 1.0)` or `m.multiply(v, 1.0)`.
   *
   * @param t The translation vector.
   * @return A 3x3 matrix representing a translation in a 2D space.
   */
  def translation(t: Vec2d): Mat3d = this.translation(t.x, t.y)

  /**
   * Returns a 3x3 rotation matrix with the given rotation on the x axis.
   *
   * @param x Rotation angle in radians.
   * @return A 3x3 rotation matrix.
   */
  def rotationX(x: Double): Mat3d = {
    val sin = math.sin(x)
    val cos = math.cos(x)
    Mat3d(1.0, 0.0, 0.0, 0.0, cos, -sin, 0.0, sin, cos)
  }

  /**
   * Returns a 3x3 rotation matrix with the given rotation on the y axis.
   *
   * @param y Rotation angle in radians.
   * @return A 3x3 rotation matrix.
   */
  def rotationY(y: Double): Mat3d = {
    val sin = math.sin(y)
    val cos = math.cos(y)
    Mat3d(cos, 0.0, sin, 0.0, 1.0, 0.0, -sin, 0.0, cos)
  }

  /**
   * Returns a 3x3 rotation matrix with the given rotation on the z axis.
   *
   * @param z Rotation angle in radians.
   * @return A 3x3 rotation matrix.
   */
  def rotationZ(z: Double): Mat3d = {
    val sin = math.sin(z)
    val cos = math.cos(z)
    Mat3d(cos, -sin, 0.0, sin, cos, 0.0, 0.0, 0.0, 1.0)
  }

  /**
   * Returns a 3x3 rotation matrix with the given rotation.
   * The rotation is first applied on the z axis, then on the y axis, then on the x axis.
   *
   * @param x Rotation angle in radians on the x axis.
   * @param y Rotation angle in radians on the y axis.
   * @param z Rotation angle in radians on the z axis.
   * @return A 3x3 rotation matrix with the given rotation.
   */
  def rotation(x: Double, y: Double, z: Double): Mat3d = this.rotationX(x) * this.rotationY(y) * this.rotationZ(z)

  /**
   * Returns a 3x3 rotation matrix with the given rotation.
   * The rotation is first applied on the z axis, then on the y axis, then on the x axis.
   *
   * @param r A vector representing the rotation angle on the x, y, and z axes.
   * @return A 3x3 rotation matrix with the given rotation.
   */
  def rotation(r: Vec3d): Mat3d = this.rotation(r.x, r.y, r.z)

  /**
   * Returns a 3x3 rotation matrix with a rotation of the given angle around the given axis.
   *
   * @param axis A unit vector representing the rotation axis. The result is undefined if this vector is not [[Vec3d.normalized]].
   * @param angle The rotation angle in radians.
   * @return A 3x3 rotation matrix with the given rotation.
   */
  def rotation(axis: Vec3d, angle: Double): Mat3d = {
    val sin = math.sin(angle)
    val cos = math.cos(angle)
    Mat3d(
      cos + axis.x * axis.x * (1.0 - cos), axis.x * axis.y * (1.0 - cos) - axis.z * sin, axis.x * axis.z * (1.0 - cos) + axis.y * sin,
      axis.y * axis.x * (1.0 - cos) + axis.z * sin, cos + axis.y * axis.y * (1.0 - cos), axis.y * axis.z * (1.0 - cos) - axis.x * sin,
      axis.z * axis.x * (1.0 - cos) - axis.y * sin, axis.z * axis.y * (1.0 - cos) + axis.x * sin, cos + axis.z * axis.z * (1.0 - cos)
    )
  }

  /**
   * Returns a 3x3 rotation matrix with the rotation expressed by the given quaternion.
   *
   * @param q The rotation quaternion. Must be a unit quaternion.
   * @return A 3x3 rotation matrix with the rotation expressed by the given quaternion.
   */
  def rotation(q: Quatd): Mat3d = {
    val s = 2.0 / q.lengthSquared
    Mat3d(
      1.0 - s * (q.y * q.y + q.z * q.z), s * (q.x * q.y - q.z * q.w), s * (q.x * q.z + q.y * q.w),
      s * (q.x * q.y + q.z * q.w), 1.0 - s * (q.x * q.x + q.z * q.z), s * (q.y * q.z - q.x * q.w),
      s * (q.x * q.z - q.y * q.w), s * (q.y * q.z + q.x * q.w), 1.0 - s * (q.x * q.x + q.y * q.y)
    )
  }

  /**
   * Returns a 3x3 matrix representing a scaling by the given factor in a 3D space.
   *
   * @param x Scale factor on the x axis.
   * @param y Scale factor on the y axis.
   * @param z Scale factor on the z axis.
   * @return A 3x3 matrix representing a scaling by the given factor in a 3D space.
   */
  def scaling(x: Double, y: Double, z: Double): Mat3d = Mat3d(x, 0.0, 0.0, 0.0, y, 0.0, 0.0, 0.0, z)

  /**
   * Returns a 3x3 matrix representing a scaling by the given factor in a 3D space.
   *
   * @param s A vector representing the scale factor on the x, y, and z axes.
   * @return A 3x3 matrix representing a scaling by the given factor in a 3D space.
   */
  def scaling(s: Vec3d): Mat3d = this.scaling(s.x, s.y, s.z)

  /**
   * Returns a 3x3 matrix representing a scaling by the given factor in a 2D space.
   *
   * @param s A vector representing the scale factor on the x and y axes.
   * @return A 3x3 matrix representing a scaling by the given factor in a 2D space.
   */
  def scaling(s: Vec2d): Mat3d = this.scaling(s.x, s.y, 1.0)

  /**
   * Allows to use the `*` operator with a scalar as `1.0 * matrix`.
   *
   * @param self The scalar value.
   */
  implicit class MultiplicationExtender(val self: Double) extends AnyVal {

    /**
     * Multiplies the given matrix by this scalar and returns the result.
     *
     * @param v The matrix to multiply.
     * @return The product between this scalar and the given matrix.
     */
    def *(v: Mat3d): Mat3d = v * self
  }
}
