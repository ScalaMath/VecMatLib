package io.github.scalamath.vecmatlib

import io.github.scalamath
import io.github.scalamath.DoubleEqualsApprox

/**
 * A 4x4 double matrix.
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
case class Mat4d(
                  m00: Double, m01: Double, m02: Double, m03: Double,
                  m10: Double, m11: Double, m12: Double, m13: Double,
                  m20: Double, m21: Double, m22: Double, m23: Double,
                  m30: Double, m31: Double, m32: Double, m33: Double
                ) {

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def +(m: Mat4d): Mat4d = Mat4d(
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
  def plus(m: Mat4d): Mat4d = this + m

  /**
   * Returns this same matrix.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This matrix.
   */
  def unary_+ : Mat4d = this

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def -(m: Mat4d): Mat4d = Mat4d(
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
  def minus(m: Mat4d): Mat4d = this - m

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix.
   */
  def unary_- : Mat4d = Mat4d(
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
  def negated: Mat4d = -this

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def *(k: Double): Mat4d = Mat4d(
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
  def multipliedBy(k: Double): Mat4d = this * k

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def /(k: Double): Mat4d = Mat4d(
    this.m00 / k, this.m01 / k, this.m02 / k, this.m03 / k,
    this.m10 / k, this.m11 / k, this.m12 / k, this.m13 / k,
    this.m20 / k, this.m21 / k, this.m22 / k, this.m23 / k,
    this.m30 / k, this.m31 / k, this.m32 / k, this.m33 / k
  )

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def dividedBy(k: Double): Mat4d = this / k

  /**
   * Returns the first row of this matrix as a [[Vec4d]].
   *
   * @return The first row of this matrix.
   * @see [[row]]
   */
  def row0: Vec4d = Vec4d(this.m00, this.m01, this.m02, this.m03)

  /**
   * Returns the second row of this matrix as a [[Vec4d]].
   *
   * @return The second row of this matrix.
   * @see [[row]]
   */
  def row1: Vec4d = Vec4d(this.m10, this.m11, this.m12, this.m13)

  /**
   * Returns the third row of this matrix as a [[Vec4d]].
   *
   * @return The third row of this matrix.
   * @see [[row]]
   */
  def row2: Vec4d = Vec4d(this.m20, this.m21, this.m22, this.m23)

  /**
   * Returns the fourth row of this matrix as a [[Vec4d]].
   *
   * @return The fourth row of this matrix.
   * @see [[row]]
   */
  def row3: Vec4d = Vec4d(this.m30, this.m31, this.m32, this.m33)

  /**
   * Returns the row at the given index as a [[Vec4d]].
   *
   * @param i The index of the requested row. Must be either 0, 1, 2, or 3.
   * @return The row at the given index.
   * @throws scala.MatchError If the given index is out of bounds.
   * @see [[row0]], [[row1]], [[row2]], and [[row3]]
   */
  def row(i: Int): Vec4d = i match {
    case 0 => this.row0
    case 1 => this.row1
    case 2 => this.row2
    case 3 => this.row3
  }

  /**
   * Returns the first column of this matrix as a [[Vec4d]].
   *
   * @return The first column of this matrix.
   * @see [[col]]
   */
  def col0: Vec4d = Vec4d(this.m00, this.m10, this.m20, this.m30)

  /**
   * Returns the second column of this matrix as a [[Vec4d]].
   *
   * @return The second column of this matrix.
   * @see [[col]]
   */
  def col1: Vec4d = Vec4d(this.m01, this.m11, this.m21, this.m31)

  /**
   * Returns the third column of this matrix as a [[Vec4d]].
   *
   * @return The third column of this matrix.
   * @see [[col]]
   */
  def col2: Vec4d = Vec4d(this.m02, this.m12, this.m22, this.m32)

  /**
   * Returns the fourth column of this matrix as a [[Vec4d]].
   *
   * @return The fourth column of this matrix.
   * @see [[col]]
   */
  def col3: Vec4d = Vec4d(this.m03, this.m13, this.m23, this.m33)

  /**
   * Returns the column at the given index as a [[Vec4d]].
   *
   * @param i The index of the requested column. Must be either 0, 1, 2, or 3.
   * @return The column at the given index.
   * @throws scala.MatchError If the given index is out of bounds.
   * @see [[col0]], [[col1]], [[col2]], and [[col3]]
   */
  def col(i: Int): Vec4d = i match {
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
  def *(v: Vec4d): Vec4d = Vec4d(this.row0.dot(v), this.row1.dot(v), this.row2.dot(v), this.row3.dot(v))

  /**
   * Multiplies this matrix by the given vector and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param v The vector to multiply this matrix by.
   * @return The product of this matrix by the given vector.
   */
  def multiply(v: Vec4d): Vec4d = this * v

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * @param x The vector's x component.
   * @param y The vector's y component.
   * @param z The vector's z component.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(x: Double, y: Double, z: Double, w: Double): Vec4d = this * Vec4d(x, y, z, w)

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
  def multiply(x: Double, y: Double, z: Double, w: Double): Vec4d = this * (x, y, z, w)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * Useful to simplify the transformation of a 3D point.
   *
   * @param xyz The vector's x, y, and z components.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(xyz: Vec3d, w: Double): Vec4d = this * (xyz.x, xyz.y, xyz.z, w)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * Useful to simplify the transformation of a 3D point.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param xyz The vector's x, y, and z components.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def multiply(xyz: Vec3d, w: Double): Vec4d = this * (xyz, w)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * Useful to simplify the transformation of a 2D point.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(xy: Vec2d, z: Double, w: Double): Vec4d = this * (xy.x, xy.y, z, w)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * Useful to simplify the transformation of a 2D point.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def multiply(xy: Vec2d, z: Double, w: Double): Vec4d = this * (xy, z, w)

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def *(m: Mat4d): Mat4d = Mat4d(
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
  def multiply(m: Mat4d): Mat4d = this * m

  /**
   * Returns the transposed of this matrix.
   *
   * The transposed of a matrix is obtained by switching its rows and its columns.
   *
   * @return The transposed of this matrix.
   */
  def transposed: Mat4d = Mat4d(
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
   * @throws MatchError If one of the given indices is out of bounds.
   */
  def submatrix(i: Int, j: Int): Mat3d = (i, j) match {
    case (0, 0) => Mat3d(this.m11, this.m12, this.m13, this.m21, this.m22, this.m23, this.m31, this.m32, this.m33)
    case (0, 1) => Mat3d(this.m10, this.m12, this.m13, this.m20, this.m22, this.m23, this.m30, this.m32, this.m33)
    case (0, 2) => Mat3d(this.m10, this.m11, this.m13, this.m20, this.m21, this.m23, this.m30, this.m31, this.m33)
    case (0, 3) => Mat3d(this.m10, this.m11, this.m12, this.m20, this.m21, this.m22, this.m30, this.m31, this.m32)
    case (1, 0) => Mat3d(this.m01, this.m02, this.m03, this.m21, this.m22, this.m23, this.m31, this.m32, this.m33)
    case (1, 1) => Mat3d(this.m00, this.m02, this.m03, this.m20, this.m22, this.m23, this.m30, this.m32, this.m33)
    case (1, 2) => Mat3d(this.m00, this.m01, this.m03, this.m20, this.m21, this.m23, this.m30, this.m31, this.m33)
    case (1, 3) => Mat3d(this.m00, this.m01, this.m02, this.m20, this.m21, this.m22, this.m30, this.m31, this.m32)
    case (2, 0) => Mat3d(this.m01, this.m02, this.m03, this.m11, this.m12, this.m13, this.m31, this.m32, this.m33)
    case (2, 1) => Mat3d(this.m00, this.m02, this.m03, this.m10, this.m12, this.m13, this.m30, this.m32, this.m33)
    case (2, 2) => Mat3d(this.m00, this.m01, this.m03, this.m10, this.m11, this.m13, this.m30, this.m31, this.m33)
    case (2, 3) => Mat3d(this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m30, this.m31, this.m32)
    case (3, 0) => Mat3d(this.m01, this.m02, this.m03, this.m11, this.m12, this.m13, this.m21, this.m22, this.m23)
    case (3, 1) => Mat3d(this.m00, this.m02, this.m03, this.m10, this.m12, this.m13, this.m20, this.m22, this.m23)
    case (3, 2) => Mat3d(this.m00, this.m01, this.m03, this.m10, this.m11, this.m13, this.m20, this.m21, this.m23)
    case (3, 3) => Mat3d(this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22)
  }

  /**
   * Returns a submatrix obtained by removing the row at the given index from this one.
   *
   * @param i Index of the row to remove. Must be either 0, 1, 2, or 3.
   * @return A submatrix of this matrix.
   * @throws MatchError If the given index is out of bounds.
   */
  def submatrix(i: Int): Mat3x4d = i match {
    case 0 => Mat3x4d(this.m10, this.m11, this.m12, this.m13, this.m20, this.m21, this.m22, this.m23, this.m30, this.m31, this.m32, this.m33)
    case 1 => Mat3x4d(this.m00, this.m01, this.m02, this.m03, this.m20, this.m21, this.m22, this.m23, this.m30, this.m31, this.m32, this.m33)
    case 2 => Mat3x4d(this.m00, this.m01, this.m02, this.m03, this.m10, this.m11, this.m12, this.m13, this.m30, this.m31, this.m32, this.m33)
    case 3 => Mat3x4d(this.m00, this.m01, this.m02, this.m03, this.m10, this.m11, this.m12, this.m13, this.m20, this.m21, this.m22, this.m23)
  }

  /**
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix.
   */
  def determinant: Double = this.m00 * this.submatrix(0, 0).determinant - this.m01 * this.submatrix(0, 1).determinant + this.m02 * this.submatrix(0, 2).determinant - this.m03 * this.submatrix(0, 3).determinant

  /**
   * Returns the adjugate of this matrix.
   *
   * @return The adjugate of this matrix.
   */
  def adjugate: Mat4d = Mat4d(
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
  def inverse: Mat4d = this.adjugate / this.determinant

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
  def power(exp: Int): Mat4d = {
    if (exp < 0) {
      this.inverse.power(-exp)
    } else if (exp == 1) {
      this
    } else if (exp == 0) {
      Mat4d.Identity
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
  def lerp(to: Mat4d, weight: Double): Mat4d = Mat4d(
    scalamath.lerp(this.m00, to.m00, weight), scalamath.lerp(this.m01, to.m01, weight), scalamath.lerp(this.m02, to.m02, weight), scalamath.lerp(this.m03, to.m03, weight),
    scalamath.lerp(this.m10, to.m10, weight), scalamath.lerp(this.m11, to.m11, weight), scalamath.lerp(this.m12, to.m12, weight), scalamath.lerp(this.m13, to.m13, weight),
    scalamath.lerp(this.m20, to.m20, weight), scalamath.lerp(this.m21, to.m21, weight), scalamath.lerp(this.m22, to.m22, weight), scalamath.lerp(this.m23, to.m23, weight),
    scalamath.lerp(this.m30, to.m30, weight), scalamath.lerp(this.m31, to.m31, weight), scalamath.lerp(this.m32, to.m32, weight), scalamath.lerp(this.m33, to.m33, weight)
  )

  /**
   * Returns a matrix with all elements in absolute value.
   *
   * @return A matrix with all elements in absolute value.
   */
  def abs: Mat4d = Mat4d(
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
  def sign: Mat4d = Mat4d(
    this.m00.sign, this.m01.sign, this.m02.sign, this.m03.sign,
    this.m10.sign, this.m11.sign, this.m12.sign, this.m13.sign,
    this.m20.sign, this.m21.sign, this.m22.sign, this.m23.sign,
    this.m30.sign, this.m31.sign, this.m32.sign, this.m33.sign
  )

  /**
   * Returns a matrix with all elements rounded to the nearest integer.
   *
   * @return A matrix with all elements rounded to the nearest integer.
   */
  def round: Mat4d = Mat4d(
    this.m00.round.toDouble, this.m01.round.toDouble, this.m02.round.toDouble, this.m03.round.toDouble,
    this.m10.round.toDouble, this.m11.round.toDouble, this.m12.round.toDouble, this.m13.round.toDouble,
    this.m20.round.toDouble, this.m21.round.toDouble, this.m22.round.toDouble, this.m23.round.toDouble,
    this.m30.round.toDouble, this.m31.round.toDouble, this.m32.round.toDouble, this.m33.round.toDouble
  )

  /**
   * Returns a matrix with all elements rounded up.
   *
   * @return A matrix with all elements rounded up.
   */
  def ceil: Mat4d = Mat4d(
    this.m00.ceil, this.m01.ceil, this.m02.ceil, this.m03.ceil,
    this.m10.ceil, this.m11.ceil, this.m12.ceil, this.m13.ceil,
    this.m20.ceil, this.m21.ceil, this.m22.ceil, this.m23.ceil,
    this.m30.ceil, this.m31.ceil, this.m32.ceil, this.m33.ceil
  )

  /**
   * Returns a matrix with all elements rounded down.
   *
   * @return A matrix with all elements rounded down.
   */
  def floor: Mat4d = Mat4d(
    this.m00.floor, this.m01.floor, this.m02.floor, this.m03.floor,
    this.m10.floor, this.m11.floor, this.m12.floor, this.m13.floor,
    this.m20.floor, this.m21.floor, this.m22.floor, this.m23.floor,
    this.m30.floor, this.m31.floor, this.m32.floor, this.m33.floor
  )

  /**
   * Constructs an orthonormal matrix from the columns of this matrix using the Gram-Schmidt procedure.
   *
   * @return This matrix with orthogonal columns of unit length.
   */
  def orthonormalized: Mat4d = {
    var (v0, v1, v2, v3) = (this.col0, this.col1, this.col2, this.col3)
    v1 = v1 - v1.project(v0)
    v2 = v2 - v2.project(v0) - v2.project(v1)
    v3 = v3 - v3.project(v0) - v3.project(v1) - v3.project(v2)
    Mat4d.fromColumns(v0.normalized, v1.normalized, v2.normalized, v3.normalized)
  }

  /**
   * Checks if this matrix is approximately equal to the given one using an internal epsilon.
   *
   * @param m The second matrix.
   * @return True if this matrix is approximately equal to the given one, otherwise false.
   */
  def ~=(m: Mat4d): Boolean = (this.m00 ~= m.m00) && (this.m01 ~= m.m01) && (this.m02 ~= m.m02) && (this.m03 ~= m.m03) &&
    (this.m10 ~= m.m10) && (this.m11 ~= m.m11) && (this.m12 ~= m.m12) && (this.m13 ~= m.m13) &&
    (this.m20 ~= m.m20) && (this.m21 ~= m.m21) && (this.m22 ~= m.m22) && (this.m23 ~= m.m23) &&
    (this.m30 ~= m.m30) && (this.m31 ~= m.m31) && (this.m32 ~= m.m32) && (this.m33 ~= m.m33)

  /**
   * Checks if this matrix is approximately equal to the given one using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator.
   *
   * @param m The second matrix.
   * @return True if this matrix is approximately equal to the given one, otherwise false.
   */
  def equalsApprox(m: Mat4d): Boolean = this ~= m

  /**
   * Returns the element at the given row and column index.
   *
   * @param row The row index of the desired element. Must be either 0, 1, 2, or 3.
   * @param col The column index of the desired element. Must be either 0, 1, 2, or 3.
   * @return The element at the given row and column index.
   * @throws scala.MatchError If any of the given indices is out of bounds.
   */
  def apply(row: Int, col: Int): Double = (row, col) match {
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
   * Casts this matrix to an int matrix.
   *
   * @return This matrix cast to int.
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
   * @return This matrix cast to float.
   */
  def toFloat: Mat4f = Mat4f(
    this.m00.toFloat, this.m01.toFloat, this.m02.toFloat, this.m03.toFloat,
    this.m10.toFloat, this.m11.toFloat, this.m12.toFloat, this.m13.toFloat,
    this.m20.toFloat, this.m21.toFloat, this.m22.toFloat, this.m23.toFloat,
    this.m30.toFloat, this.m31.toFloat, this.m32.toFloat, this.m33.toFloat
  )
}

/**
 * Constants, factory methods, and implicits for matrices.
 */
object Mat4d {

  /** Shorthand for the zero matrix */
  val Zero: Mat4d = Mat4d(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)

  /** Shorthand for the identity matrix */
  val Identity: Mat4d = Mat4d(1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0)

  /**
   * Returns a 4x4 matrix from the given rows.
   *
   * @param row0 The first row.
   * @param row1 The second row.
   * @param row2 The third row.
   * @param row3 The fourth row.
   * @return A 4x4 matrix from the given rows.
   */
  def fromRows(row0: Vec4d, row1: Vec4d, row2: Vec4d, row3: Vec4d): Mat4d = Mat4d(
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
  def fromColumns(col0: Vec4d, col1: Vec4d, col2: Vec4d, col3: Vec4d): Mat4d = Mat4d(
    col0.x, col1.x, col2.x, col3.x,
    col0.y, col1.y, col2.y, col3.y,
    col0.z, col1.z, col2.z, col3.z,
    col0.w, col1.w, col2.w, col3.w
  )

  /**
   * Returns a 4x4 matrix representing a translation in a 3D space.
   *
   * A translation can be applied to a vector by multiplying it with this matrix as `m * (v, 1.0)` or `m.multiply(v, 1.0)`.
   *
   * @param x Translation on the x axis.
   * @param y Translation on the y axis.
   * @param z Translation on the z axis.
   * @return A 4x4 matrix representing a translation in a 3D space.
   */
  def translation(x: Double, y: Double, z: Double): Mat4d = Mat4d(1.0, 0.0, 0.0, x, 0.0, 1.0, 0.0, y, 0.0, 0.0, 1.0, z, 0.0, 0.0, 0.0, 1.0)

  /**
   * Returns a 4x4 matrix representing a translation in a 3D space.
   *
   * A translation can be applied to a vector by multiplying it with this matrix as `m * (v, 1.0)` or `m.multiply(v, 1.0)`.
   *
   * @param t The translation vector.
   * @return A 4x4 matrix representing a translation in a 3D space.
   */
  def translation(t: Vec3d): Mat4d = this.translation(t.x, t.y, t.z)

  /**
   * Returns a 4x4 matrix representing a translation in a 2D space.
   *
   * A translation can be applied to a vector by multiplying it with this matrix as `m * (v, 0.0, 1.0)` or `m.multiply(v, 0.0, 1.0)`.
   *
   * @param t The translation vector.
   * @return A 4x4 matrix representing a translation in a 2D space.
   */
  def translation(t: Vec2d): Mat4d = this.translation(t.x, t.y, 0.0)

  /**
   * Returns a 4x4 rotation matrix with the given rotation on the x axis.
   *
   * @param x Rotation angle in radians.
   * @return A 4x4 rotation matrix.
   */
  def rotationX(x: Double): Mat4d = {
    val sin = math.sin(x)
    val cos = math.cos(x)
    Mat4d(1.0, 0.0, 0.0, 0.0, 0.0, cos, -sin, 0.0, 0.0, sin, cos, 0.0, 0.0, 0.0, 0.0, 1.0)
  }

  /**
   * Returns a 4x4 rotation matrix with the given rotation on the y axis.
   *
   * @param y Rotation angle in radians.
   * @return A 4x4 rotation matrix.
   */
  def rotationY(y: Double): Mat4d = {
    val sin = math.sin(y)
    val cos = math.cos(y)
    Mat4d(cos, 0.0, sin, 0.0, 0.0, 1.0, 0.0, 0.0, -sin, 0.0, cos, 0.0, 0.0, 0.0, 0.0, 1.0)
  }

  /**
   * Returns a 4x4 rotation matrix with the given rotation on the z axis.
   *
   * @param z Rotation angle in radians.
   * @return A 4x4 rotation matrix.
   */
  def rotationZ(z: Double): Mat4d = {
    val sin = math.sin(z)
    val cos = math.cos(z)
    Mat4d(cos, -sin, 0.0, 0.0, sin, cos, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0)
  }

  /**
   * Returns a 4x4 rotation matrix with the given rotation.
   * The rotation is first applied on the z axis, then on the y axis, then on the x axis.
   *
   * @param x Rotation angle in radians on the x axis.
   * @param y Rotation angle in radians on the y axis.
   * @param z Rotation angle in radians on the z axis.
   * @return A 4x4 rotation matrix with the given rotation.
   */
  def rotation(x: Double, y: Double, z: Double): Mat4d = this.rotationX(x) * this.rotationY(y) * this.rotationZ(z)

  /**
   * Returns a 4x4 rotation matrix with the given rotation.
   * The rotation is first applied on the z axis, then on the y axis, then on the x axis.
   *
   * @param r A vector representing the rotation angle on the x, y, and z axes.
   * @return A 4x4 rotation matrix with the given rotation.
   */
  def rotation(r: Vec3d): Mat4d = this.rotation(r.x, r.y, r.z)

  /**
   * Returns a 4x4 rotation matrix with a rotation of the given angle around the given axis.
   *
   * @param axis A unit vector representing the rotation axis. The result is undefined if this vector is not [[Vec3d.normalized]].
   * @param angle The rotation angle in radians.
   * @return A 4x4 rotation matrix with the given rotation.
   */
  def rotation(axis: Vec3d, angle: Double): Mat4d = {
    val sin = math.sin(angle)
    val cos = math.cos(angle)
    Mat4d(
      cos + axis.x * axis.x * (1.0 - cos), axis.x * axis.y * (1.0 - cos) - axis.z * sin, axis.x * axis.z * (1.0 - cos) + axis.y * sin, 0.0,
      axis.y * axis.x * (1.0 - cos) + axis.z * sin, cos + axis.y * axis.y * (1.0 - cos), axis.y * axis.z * (1.0 - cos) - axis.x * sin, 0.0,
      axis.z * axis.x * (1.0 - cos) - axis.y * sin, axis.z * axis.y * (1.0 - cos) + axis.x * sin, cos + axis.z * axis.z * (1.0 - cos), 0.0,
      0.0, 0.0, 0.0, 1.0
    )
  }

  /**
   * Returns a 4x4 rotation matrix with the rotation expressed by the given quaternion.
   *
   * @param q The rotation quaternion. Must be a unit quaternion.
   * @return A 4x4 rotation matrix with the rotation expressed by the given quaternion.
   */
  def rotation(q: Quatd): Mat4d = {
    val s = 2.0 / q.lengthSquared
    Mat4d(
      1.0 - s * (q.y * q.y + q.z * q.z), s * (q.x * q.y - q.z * q.w), s * (q.x * q.z + q.y * q.w), 0.0,
      s * (q.x * q.y + q.z * q.w), 1.0 - s * (q.x * q.x + q.z * q.z), s * (q.y * q.z - q.x * q.w), 0.0,
      s * (q.x * q.z - q.y * q.w), s * (q.y * q.z + q.x * q.w), 1.0 - s * (q.x * q.x + q.y * q.y), 0.0,
      0.0, 0.0, 0.0, 1.0
    )
  }

  /**
   * Returns a 4x4 matrix representing a scaling by the given factor in a 3D space.
   *
   * @param x Scale factor on the x axis.
   * @param y Scale factor on the y axis.
   * @param z Scale factor on the z axis.
   * @return A 4x4 matrix representing a scaling by the given factor in a 3D space.
   */
  def scaling(x: Double, y: Double, z: Double): Mat4d = Mat4d(x, 0.0, 0.0, 0.0, 0.0, y, 0.0, 0.0, 0.0, 0.0, z, 0.0, 0.0, 0.0, 0.0, 1.0)

  /**
   * Returns a 4x4 matrix representing a scaling by the given factor in a 3D space.
   *
   * @param s A vector representing the scale factor on the x, y, and z axes.
   * @return A 4x4 matrix representing a scaling by the given factor in a 3D space.
   */
  def scaling(s: Vec3d): Mat4d = this.scaling(s.x, s.y, s.z)

  /**
   * Returns a 4x4 matrix representing a scaling by the given factor in a 2D space.
   *
   * @param s A vector representing the scale factor on the x and y axes.
   * @return A 4x4 matrix representing a scaling by the given factor in a 2D space.
   */
  def scaling(s: Vec2d): Mat4d = this.scaling(s.x, s.y, 1.0)

  /**
   * Returns a 4x4 projection matrix representing perspective screen projection.
   *
   * @param fov Field of view angle in radians.
   * @param aspect Aspect ratio of the screen.
   * @param near Near plane distance.
   * @param far Far plane distance.
   * @return A 4x4 projection matrix for perspective projection.
   */
  def perspectiveProjection(fov: Double, aspect: Double, near: Double, far: Double): Mat4d = {
    val focalLength = 1.0 / math.tan(fov)
    Mat4d(
      focalLength, 0.0, 0.0, 0.0,
      0.0, focalLength * aspect, 0.0, 0.0,
      0.0, 0.0, -(far + near) / (far - near), -(2 * far * near) / (far - near),
      0.0, 0.0, -1.0, 0.0
    )
  }

  /**
   * Returns a 4x4 projection matrix representing perspective screen projection.
   *
   * @param fov Field of view angle in radians.
   * @param width Screen width.
   * @param height Screen height.
   * @param near Near plane distance.
   * @param far Far plane distance.
   * @return A 4x4 projection matrix for perspective projection.
   */
  def perspectiveProjection(fov: Double, width: Double, height: Double, near: Double, far: Double): Mat4d = this.perspectiveProjection(fov, width / height, near, far)

  /**
   * Returns a 4x4 projection matrix representing perspective screen projection.
   *
   * @param fov Field of view angle in radians.
   * @param size A vector representing the size of the screen (width and height).
   * @param near Near plane distance.
   * @param far Far plane distance.
   * @return A 4x4 projection matrix for perspective projection.
   */
  def perspectiveProjection(fov: Double, size: Vec2d, near: Double, far: Double): Mat4d = this.perspectiveProjection(fov, size.aspect, near, far)

  /**
   * Returns a 4x4 projection matrix representing perspective screen projection.
   *
   * @param fov Field of view angle in radians.
   * @param size A vector representing the size of the screen (width and height).
   * @param near Near plane distance.
   * @param far Far plane distance.
   * @return A 4x4 projection matrix for perspective projection.
   */
  def perspectiveProjection(fov: Double, size: Vec2i, near: Double, far: Double): Mat4d = this.perspectiveProjection(fov, size.aspect, near, far)

  /**
   * Returns a 4x4 projection matrix representing orthographic screen projection.
   *
   * @param left Left clipping plane distance.
   * @param right Right clipping plane distance.
   * @param bottom Bottom clipping plane distance.
   * @param top Top clipping plane distance.
   * @param near Near plane distance.
   * @param far Far plane distance.
   * @return A 4x4 projection matrix for orthographic projection.
   */
  def orthographicProjection(left: Double, right: Double, bottom: Double, top: Double, near: Double, far: Double): Mat4d = Mat4d(
    2.0 / (right - left), 0.0, 0.0, -(right + left) / (right - left),
    0.0, 2.0 / (top - bottom), 0.0, -(top + bottom) / (top - bottom),
    0.0, 0.0, -2.0 / (far - near), -(far + near) / (far - near),
    0.0, 0.0, 0.0, 1.0
  )

  /**
   * Returns a 4x4 projection matrix representing orthographic screen projection.
   *
   * @param size Distance between the left and the right clipping planes. Can be seen as the width of the screen.
   * @param aspect Aspect ratio of the screen.
   * @param near Near plane distance.
   * @param far Far plane distance.
   * @return A 4x4 projection matrix for orthographic projection.
   */
  def orthographicProjection(size: Double, aspect: Double, near: Double, far: Double): Mat4d = this.orthographicProjection(-size / 2.0, size / 2.0, -size / aspect / 2.0, size / aspect / 2.0, near, far)

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
    def *(v: Mat4d): Mat4d = v * self
  }
}
