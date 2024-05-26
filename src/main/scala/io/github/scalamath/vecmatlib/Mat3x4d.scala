package io.github.scalamath.vecmatlib

import io.github.scalamath
import io.github.scalamath.DoubleEqualsApprox

/**
 * A 3x4 (three rows and four columns) double matrix.
 *
 * Useful for representing 3D transformations such as translation, rotation, and scaling.
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
 */
case class Mat3x4d(
                  m00: Double, m01: Double, m02: Double, m03: Double,
                  m10: Double, m11: Double, m12: Double, m13: Double,
                  m20: Double, m21: Double, m22: Double, m23: Double
                ) {

  /**
   * Constructs a matrix from the given submatrix and column.
   *
   * @param m The first three columns of this matrix.
   * @param m03 The first element of the fourth column.
   * @param m13 The second element of the fourth column.
   * @param m23 The third element of the fourth column.
   */
  def this(m: Mat3d, m03: Double, m13: Double, m23: Double) = this(
    m.m00, m.m01, m.m02, m03,
    m.m10, m.m11, m.m12, m13,
    m.m20, m.m21, m.m22, m23
  )

  /**
   * Constructs a matrix from the given submatrix and column.
   *
   * @param m The first three columns of this matrix.
   * @param col3 The fourth column of this matrix.
   */
  def this(m: Mat3d, col3: Vec3d) = this(m, col3.x, col3.y, col3.z)

  /**
   * Constructs a matrix from the given submatrix and column.
   *
   * @param m00 The first element of the fourth column.
   * @param m10 The second element of the fourth column.
   * @param m20 The third element of the fourth column.
   * @param m The second, third, and fourth column of this matrix.
   */
  def this(m00: Double, m10: Double, m20: Double, m: Mat3d) = this(
    m00, m.m00, m.m01, m.m02,
    m10, m.m10, m.m11, m.m12,
    m20, m.m20, m.m21, m.m22
  )

  /**
   * Constructs a matrix from the given submatrix and column.
   *
   * @param col0 The first column of this matrix.
   * @param m The second, third, and fourth column of this matrix.
   */
  def this(col0: Vec3d, m: Mat3d) = this(col0.x, col0.y, col0.z, m)

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def +(m: Mat3x4d): Mat3x4d = Mat3x4d(
    this.m00 + m.m00, this.m01 + m.m01, this.m02 + m.m02, this.m03 + m.m03,
    this.m10 + m.m10, this.m11 + m.m11, this.m12 + m.m12, this.m13 + m.m13,
    this.m20 + m.m20, this.m21 + m.m21, this.m22 + m.m22, this.m23 + m.m23
  )

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def plus(m: Mat3x4d): Mat3x4d = this + m

  /**
   * Returns this same matrix.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This matrix.
   */
  def unary_+ : Mat3x4d = this

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def -(m: Mat3x4d): Mat3x4d = Mat3x4d(
    this.m00 - m.m00, this.m01 - m.m01, this.m02 - m.m02, this.m03 - m.m03,
    this.m10 - m.m10, this.m11 - m.m11, this.m12 - m.m12, this.m13 - m.m13,
    this.m20 - m.m20, this.m21 - m.m21, this.m22 - m.m22, this.m23 - m.m23
  )

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def minus(m: Mat3x4d): Mat3x4d = this - m

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix.
   */
  def unary_- : Mat3x4d = Mat3x4d(
    -this.m00, -this.m01, -this.m02, -this.m03,
    -this.m10, -this.m11, -this.m12, -this.m13,
    -this.m20, -this.m21, -this.m22, -this.m23
  )

  /**
   * Returns the additive inverse of this matrix.
   *
   * This method can be used in place of the unary `-` operator for better interoperability with Java.
   *
   * @return The additive inverse of this matrix.
   */
  def negated: Mat3x4d = -this

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def *(k: Double): Mat3x4d = Mat3x4d(
    this.m00 * k, this.m01 * k, this.m02 * k, this.m03 * k,
    this.m10 * k, this.m11 * k, this.m12 * k, this.m13 * k,
    this.m20 * k, this.m21 * k, this.m22 * k, this.m23 * k
  )

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def multipliedBy(k: Double): Mat3x4d = this * k

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def /(k: Double): Mat3x4d = Mat3x4d(
    this.m00 / k, this.m01 / k, this.m02 / k, this.m03 / k,
    this.m10 / k, this.m11 / k, this.m12 / k, this.m13 / k,
    this.m20 / k, this.m21 / k, this.m22 / k, this.m23 / k
  )

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def dividedBy(k: Double): Mat3x4d = this / k

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
   * Returns the row at the given index as a [[Vec4d]].
   *
   * @param i The index of the requested row. Must be either 0, 1, or 2.
   * @return The row at the given index.
   * @throws scala.MatchError If the given index is out of bounds.
   * @see [[row0]], [[row1]], and [[row2]]
   */
  def row(i: Int): Vec4d = i match {
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
   * Returns the fourth column of this matrix as a [[Vec3d]].
   *
   * @return The fourth column of this matrix.
   * @see [[col]]
   */
  def col3: Vec3d = Vec3d(this.m03, this.m13, this.m23)

  /**
   * Returns the column at the given index as a [[Vec3d]].
   *
   * @param i The index of the requested column. Must be either 0, 1, 2, or 3.
   * @return The column at the given index.
   * @throws scala.MatchError If the given index is out of bounds.
   * @see [[col0]], [[col1]], [[col2]], and [[col3]]
   */
  def col(i: Int): Vec3d = i match {
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
  def *(v: Vec4d): Vec3d = Vec3d(this.row0.dot(v), this.row1.dot(v), this.row2.dot(v))

  /**
   * Multiplies this matrix by the given vector and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param v The vector to multiply this matrix by.
   * @return The product of this matrix by the given vector.
   */
  def multiply(v: Vec4d): Vec3d = this * v

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * @param x The vector's x component.
   * @param y The vector's y component.
   * @param z The vector's z component.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(x: Double, y: Double, z: Double, w: Double): Vec3d = this * Vec4d(x, y, z, w)

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
  def multiply(x: Double, y: Double, z: Double, w: Double): Vec3d = this * (x, y, z, w)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * Useful to simplify the transformation of a 3D point.
   *
   * @param xyz The vector's x, y, and z components.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(xyz: Vec3d, w: Double): Vec3d = this * (xyz.x, xyz.y, xyz.z, w)

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
  def multiply(xyz: Vec3d, w: Double): Vec3d = this * (xyz, w)

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
  def *(xy: Vec2d, z: Double, w: Double): Vec3d = this * (xy.x, xy.y, z, w)

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
  def multiply(xy: Vec2d, z: Double, w: Double): Vec3d = this * (xy, z, w)

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def *(m: Mat4d): Mat3x4d = Mat3x4d(
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
  def multiply(m: Mat4d): Mat3x4d = this * m

  /**
   * Multiplies this matrix by the matrix with the given components and returns the result.
   *
   * Useful to simplify the composition of two 3x4 transformation matrices.
   *
   * @param m The first, second, and third row of the matrix to multiply this one by.
   * @param m30 The first element of the fourth column of the matrix to multiply this one by.
   * @param m31 The second element of the fourth column of the matrix to multiply this one by.
   * @param m32 The third element of the fourth column of the matrix to multiply this one by.
   * @param m33 The fourth element of the fourth column of the matrix to multiply this one by.
   * @return The product between this matrix and the matrix with the given components.
   */
  def *(m: Mat3x4d, m30: Double, m31: Double, m32: Double, m33: Double): Mat3x4d = Mat3x4d(
    this.row0.dot(m.col0, m30), this.row0.dot(m.col1, m31), this.row0.dot(m.col2, m32), this.row0.dot(m.col3, m33),
    this.row1.dot(m.col0, m30), this.row1.dot(m.col1, m31), this.row1.dot(m.col2, m32), this.row1.dot(m.col3, m33),
    this.row2.dot(m.col0, m30), this.row2.dot(m.col1, m31), this.row2.dot(m.col2, m32), this.row2.dot(m.col3, m33)
  )

  /**
   * Multiplies this matrix by the matrix with the given components and returns the result.
   *
   * Useful to simplify the composition of two 3x4 transformation matrices.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param m The first, second, and third row of the matrix to multiply this one by.
   * @param m30 The first element of the fourth column of the matrix to multiply this one by.
   * @param m31 The second element of the fourth column of the matrix to multiply this one by.
   * @param m32 The third element of the fourth column of the matrix to multiply this one by.
   * @param m33 The fourth element of the fourth column of the matrix to multiply this one by.
   * @return The product between this matrix and the matrix with the given components.
   */
  def multiply(m: Mat3x4d, m30: Double, m31: Double, m32: Double, m33: Double): Mat3x4d = this * (m, m30, m31, m32, m33)

  /**
   * Multiplies this matrix by the matrix with the given components and returns the result.
   *
   * Useful to simplify the composition of two 3x4 transformation matrices.
   *
   * @param m The first, second, and third row of the matrix to multiply this one by.
   * @param v The fourth column of the matrix to multiply this one by.
   * @return The product between this matrix and the matrix with the given components.
   */
  def *(m: Mat3x4d, v: Vec4d): Mat3x4d = this * (m, v.x, v.y, v.z, v.w)

  /**
   * Multiplies this matrix by the matrix with the given components and returns the result.
   *
   * Useful to simplify the composition of two 3x4 transformation matrices.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param m The first, second, and third row of the matrix to multiply this one by.
   * @param v The fourth column of the matrix to multiply this one by.
   * @return The product between this matrix and the matrix with the given components.
   */
  def multiply(m: Mat3x4d, v: Vec4d): Mat3x4d = this * (m, v)

  /**
   * Returns a submatrix of this matrix obtained by removing the column at the given index.
   *
   * @param i Index of the column to remove. Must be either 0, 1, 2, or 3.
   * @return A submatrix of this matrix.
   * @throws MatchError If the given index is out of bounds.
   */
  def submatrix(i: Int): Mat3d = i match {
    case 0 => Mat3d(this.m01, this.m02, this.m03, this.m11, this.m12, this.m13, this.m21, this.m22, this.m23)
    case 1 => Mat3d(this.m00, this.m02, this.m03, this.m10, this.m12, this.m13, this.m20, this.m22, this.m23)
    case 2 => Mat3d(this.m00, this.m01, this.m03, this.m10, this.m11, this.m13, this.m20, this.m21, this.m23)
    case 3 => Mat3d(this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22)
  }

  /**
   * Returns the inverse of this matrix, under the assumption that it is an affine transformation matrix.
   * The result is undefined if the determinant of the basis is zero.
   *
   * @return The affine inverse of this matrix.
   *
   * @example {{{
   *            val inverse: Mat3x4d = m.affineInverse
   *            // Is equivalent to
   *            val basis: Mat3d = m.submatrix(3)
   *            val inverse = Mat3x4d(
   *              basis.inverse, -basis.inverse * m.col3
   *            )
   * }}}
   */
  def affineInverse: Mat3x4d = {
    val inverseBasis = this.submatrix(3).inverse
    Mat3x4d(inverseBasis, inverseBasis * -this.col3)
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
  def lerp(to: Mat3x4d, weight: Double): Mat3x4d = Mat3x4d(
    scalamath.lerp(this.m00, to.m00, weight), scalamath.lerp(this.m01, to.m01, weight), scalamath.lerp(this.m02, to.m02, weight), scalamath.lerp(this.m03, to.m03, weight),
    scalamath.lerp(this.m10, to.m10, weight), scalamath.lerp(this.m11, to.m11, weight), scalamath.lerp(this.m12, to.m12, weight), scalamath.lerp(this.m13, to.m13, weight),
    scalamath.lerp(this.m20, to.m20, weight), scalamath.lerp(this.m21, to.m21, weight), scalamath.lerp(this.m22, to.m22, weight), scalamath.lerp(this.m23, to.m23, weight)
  )

  /**
   * Returns a matrix with all elements in absolute value.
   *
   * @return A matrix with all elements in absolute value.
   */
  def abs: Mat3x4d = Mat3x4d(
    this.m00.abs, this.m01.abs, this.m02.abs, this.m03.abs,
    this.m10.abs, this.m11.abs, this.m12.abs, this.m13.abs,
    this.m20.abs, this.m21.abs, this.m22.abs, this.m23.abs
  )

  /**
   * Returns a matrix with the signs of the elements of this matrix.
   *
   * @return A matrix with all elements representing the sign of this matrix.
   */
  def sign: Mat3x4d = Mat3x4d(
    this.m00.sign, this.m01.sign, this.m02.sign, this.m03.sign,
    this.m10.sign, this.m11.sign, this.m12.sign, this.m13.sign,
    this.m20.sign, this.m21.sign, this.m22.sign, this.m23.sign
  )

  /**
   * Returns a matrix with all elements rounded to the nearest integer.
   *
   * @return A matrix with all elements rounded to the nearest integer.
   */
  def round: Mat3x4d = Mat3x4d(
    this.m00.round.toDouble, this.m01.round.toDouble, this.m02.round.toDouble, this.m03.round.toDouble,
    this.m10.round.toDouble, this.m11.round.toDouble, this.m12.round.toDouble, this.m13.round.toDouble,
    this.m20.round.toDouble, this.m21.round.toDouble, this.m22.round.toDouble, this.m23.round.toDouble
  )

  /**
   * Returns a matrix with all elements rounded up.
   *
   * @return A matrix with all elements rounded up.
   */
  def ceil: Mat3x4d = Mat3x4d(
    this.m00.ceil, this.m01.ceil, this.m02.ceil, this.m03.ceil,
    this.m10.ceil, this.m11.ceil, this.m12.ceil, this.m13.ceil,
    this.m20.ceil, this.m21.ceil, this.m22.ceil, this.m23.ceil
  )

  /**
   * Returns a matrix with all elements rounded down.
   *
   * @return A matrix with all elements rounded down.
   */
  def floor: Mat3x4d = Mat3x4d(
    this.m00.floor, this.m01.floor, this.m02.floor, this.m03.floor,
    this.m10.floor, this.m11.floor, this.m12.floor, this.m13.floor,
    this.m20.floor, this.m21.floor, this.m22.floor, this.m23.floor
  )

  /**
   * Constructs an orthonormal matrix from the columns of this matrix using the Gram-Schmidt procedure.
   *
   * @return This matrix with orthogonal columns of unit length.
   */
  def orthonormalized: Mat3x4d = {
    var (v0, v1, v2, v3) = (this.col0, this.col1, this.col2, this.col3)
    v1 = v1 - v1.project(v0)
    v2 = v2 - v2.project(v0) - v2.project(v1)
    v3 = v3 - v3.project(v0) - v3.project(v1) - v3.project(v2)
    Mat3x4d.fromColumns(v0.normalized, v1.normalized, v2.normalized, v3.normalized)
  }

  /**
   * Checks if this matrix is approximately equal to the given one using an internal epsilon.
   *
   * @param m The second matrix.
   * @return True if this matrix is approximately equal to the given one, otherwise false.
   */
  def ~=(m: Mat3x4d): Boolean = (this.m00 ~= m.m00) && (this.m01 ~= m.m01) && (this.m02 ~= m.m02) && (this.m03 ~= m.m03) &&
    (this.m10 ~= m.m10) && (this.m11 ~= m.m11) && (this.m12 ~= m.m12) && (this.m13 ~= m.m13) &&
    (this.m20 ~= m.m20) && (this.m21 ~= m.m21) && (this.m22 ~= m.m22) && (this.m23 ~= m.m23)

  /**
   * Checks if this matrix is approximately equal to the given one using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator.
   *
   * @param m The second matrix.
   * @return True if this matrix is approximately equal to the given one, otherwise false.
   */
  def equalsApprox(m: Mat3x4d): Boolean = this ~= m

  /**
   * Returns the element at the given row and column index.
   *
   * @param row The row index of the desired element. Must be either 0, 1, or 2.
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
  }

  /**
   * Casts this matrix to an int matrix.
   *
   * @return This matrix cast to int.
   */
  def toInt: Mat3x4i = Mat3x4i(
    this.m00.toInt, this.m01.toInt, this.m02.toInt, this.m03.toInt,
    this.m10.toInt, this.m11.toInt, this.m12.toInt, this.m13.toInt,
    this.m20.toInt, this.m21.toInt, this.m22.toInt, this.m23.toInt
  )

  /**
   * Casts this matrix to a float matrix.
   *
   * @return This matrix cast to float.
   */
  def toFloat: Mat3x4f = Mat3x4f(
    this.m00.toFloat, this.m01.toFloat, this.m02.toFloat, this.m03.toFloat,
    this.m10.toFloat, this.m11.toFloat, this.m12.toFloat, this.m13.toFloat,
    this.m20.toFloat, this.m21.toFloat, this.m22.toFloat, this.m23.toFloat
  )
}

/**
 * Constants, factory methods, and implicits for matrices.
 */
object Mat3x4d {

  /** Shorthand for the zero matrix */
  val Zero: Mat3x4d = Mat3x4d(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)

  /**
   * Constructs a matrix from the given submatrix and column.
   *
   * Allows to construct a matrix without using the `new` keyword in Scala.
   *
   * @param m The first three columns of this matrix.
   * @param m03 The first element of the fourth column.
   * @param m13 The second element of the fourth column.
   * @param m23 The third element of the fourth column.
   */
  def apply(m: Mat3d, m03: Double, m13: Double, m23: Double) = new Mat3x4d(
    m.m00, m.m01, m.m02, m03,
    m.m10, m.m11, m.m12, m13,
    m.m20, m.m21, m.m22, m23
  )

  /**
   * Constructs a matrix from the given submatrix and column.
   *
   * Allows to construct a matrix without using the `new` keyword in Scala.
   *
   * @param m The first three columns of this matrix.
   * @param col3 The fourth column of this matrix.
   */
  def apply(m: Mat3d, col3: Vec3d) = new Mat3x4d(m, col3.x, col3.y, col3.z)

  /**
   * Constructs a matrix from the given submatrix and column.
   *
   * Allows to construct a matrix without using the `new` keyword in Scala.
   *
   * @param m00 The first element of the fourth column.
   * @param m10 The second element of the fourth column.
   * @param m20 The third element of the fourth column.
   * @param m The second, third, and fourth column of this matrix.
   */
  def apply(m00: Double, m10: Double, m20: Double, m: Mat3d) = new Mat3x4d(
    m00, m.m00, m.m01, m.m02,
    m10, m.m10, m.m11, m.m12,
    m20, m.m20, m.m21, m.m22
  )

  /**
   * Constructs a matrix from the given submatrix and column.
   *
   * Allows to construct a matrix without using the `new` keyword in Scala.
   *
   * @param col0 The first column of this matrix.
   * @param m The second, third, and fourth column of this matrix.
   */
  def apply(col0: Vec3d, m: Mat3d) = new Mat3x4d(col0.x, col0.y, col0.z, m)

  /**
   * Returns a 3x4 matrix from the given rows.
   *
   * @param row0 The first row.
   * @param row1 The second row.
   * @param row2 The third row.
   * @return A 3x4 matrix from the given rows.
   */
  def fromRows(row0: Vec4d, row1: Vec4d, row2: Vec4d): Mat3x4d = Mat3x4d(
    row0.x, row0.y, row0.z, row0.w,
    row1.x, row1.y, row1.z, row1.w,
    row2.x, row2.y, row2.z, row2.w
  )

  /**
   * Returns a 3x4 matrix from the given columns.
   *
   * @param col0 The first column.
   * @param col1 The second column.
   * @param col2 The third column.
   * @param col3 The fourth column.
   * @return A 3x4 matrix from the given columns.
   */
  def fromColumns(col0: Vec3d, col1: Vec3d, col2: Vec3d, col3: Vec3d): Mat3x4d = Mat3x4d(
    col0.x, col1.x, col2.x, col3.x,
    col0.y, col1.y, col2.y, col3.y,
    col0.z, col1.z, col2.z, col3.z
  )

  /**
   * Returns a 3x4 matrix representing a translation in a 3D space.
   *
   * A translation can be applied to a vector by multiplying it with this matrix as `m * (v, 1.0)` or `m.multiply(v, 1.0)`.
   *
   * @param x Translation on the x axis.
   * @param y Translation on the y axis.
   * @param z Translation on the z axis.
   * @return A 3x4 matrix representing a translation in a 3D space.
   */
  def translation(x: Double, y: Double, z: Double): Mat3x4d = Mat3x4d(1.0, 0.0, 0.0, x, 0.0, 1.0, 0.0, y, 0.0, 0.0, 1.0, z)

  /**
   * Returns a 3x4 matrix representing a translation in a 3D space.
   *
   * A translation can be applied to a vector by multiplying it with this matrix as `m * (v, 1.0)` or `m.multiply(v, 1.0)`.
   *
   * @param t The translation vector.
   * @return A 3x4 matrix representing a translation in a 3D space.
   */
  def translation(t: Vec3d): Mat3x4d = this.translation(t.x, t.y, t.z)

  /**
   * Returns a 3x4 matrix representing a translation in a 2D space.
   *
   * A translation can be applied to a vector by multiplying it with this matrix as `m * (v, 0.0, 1.0)` or `m.multiply(v, 0.0, 1.0)`.
   *
   * @param t The translation vector.
   * @return A 3x4 matrix representing a translation in a 2D space.
   */
  def translation(t: Vec2d): Mat3x4d = this.translation(t.x, t.y, 0.0)

  /**
   * Returns a 3x4 rotation matrix with the given rotation on the x axis.
   *
   * @param x Rotation angle in radians.
   * @return A 3x4 rotation matrix.
   */
  def rotationX(x: Double): Mat3x4d = {
    val sin = math.sin(x)
    val cos = math.cos(x)
    Mat3x4d(1.0, 0.0, 0.0, 0.0, 0.0, cos, -sin, 0.0, 0.0, sin, cos, 0.0)
  }

  /**
   * Returns a 3x4 rotation matrix with the given rotation on the y axis.
   *
   * @param y Rotation angle in radians.
   * @return A 3x4 rotation matrix.
   */
  def rotationY(y: Double): Mat3x4d = {
    val sin = math.sin(y)
    val cos = math.cos(y)
    Mat3x4d(cos, 0.0, sin, 0.0, 0.0, 1.0, 0.0, 0.0, -sin, 0.0, cos, 0.0)
  }

  /**
   * Returns a 3x4 rotation matrix with the given rotation on the z axis.
   *
   * @param z Rotation angle in radians.
   * @return A 3x4 rotation matrix.
   */
  def rotationZ(z: Double): Mat3x4d = {
    val sin = math.sin(z)
    val cos = math.cos(z)
    Mat3x4d(cos, -sin, 0.0, 0.0, sin, cos, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0)
  }

  /**
   * Returns a 3x4 rotation matrix with a rotation of the given angle around the given axis.
   *
   * @param axis A unit vector representing the rotation axis. The result is undefined if this vector is not [[Vec3d.normalized]].
   * @param angle The rotation angle in radians.
   * @return A 3x4 rotation matrix with the given rotation.
   */
  def rotation(axis: Vec3d, angle: Double): Mat3x4d = {
    val sin = math.sin(angle)
    val cos = math.cos(angle)
    Mat3x4d(
      cos + axis.x * axis.x * (1.0 - cos), axis.x * axis.y * (1.0 - cos) - axis.z * sin, axis.x * axis.z * (1.0 - cos) + axis.y * sin, 0.0,
      axis.y * axis.x * (1.0 - cos) + axis.z * sin, cos + axis.y * axis.y * (1.0 - cos), axis.y * axis.z * (1.0 - cos) - axis.x * sin, 0.0,
      axis.z * axis.x * (1.0 - cos) - axis.y * sin, axis.z * axis.y * (1.0 - cos) + axis.x * sin, cos + axis.z * axis.z * (1.0 - cos), 0.0
    )
  }

  /**
   * Returns a 3x4 rotation matrix with the rotation expressed by the given quaternion.
   *
   * @param q The rotation quaternion. Must be a unit quaternion.
   * @return A 3x4 rotation matrix with the rotation expressed by the given quaternion.
   */
  def rotation(q: Quatd): Mat3x4d = {
    val s = 2.0 / q.lengthSquared
    Mat3x4d(
      1.0 - s * (q.y * q.y + q.z * q.z), s * (q.x * q.y - q.z * q.w), s * (q.x * q.z + q.y * q.w), 0.0,
      s * (q.x * q.y + q.z * q.w), 1.0 - s * (q.x * q.x + q.z * q.z), s * (q.y * q.z - q.x * q.w), 0.0,
      s * (q.x * q.z - q.y * q.w), s * (q.y * q.z + q.x * q.w), 1.0 - s * (q.x * q.x + q.y * q.y), 0.0
    )
  }

  /**
   * Returns a 3x4 matrix representing a scaling by the given factor in a 3D space.
   *
   * @param x Scale factor on the x axis.
   * @param y Scale factor on the y axis.
   * @param z Scale factor on the z axis.
   * @return A 3x4 matrix representing a scaling by the given factor in a 3D space.
   */
  def scaling(x: Double, y: Double, z: Double): Mat3x4d = Mat3x4d(x, 0.0, 0.0, 0.0, 0.0, y, 0.0, 0.0, 0.0, 0.0, z, 0.0)

  /**
   * Returns a 3x4 matrix representing a scaling by the given factor in a 3D space.
   *
   * @param s A vector representing the scale factor on the x, y, and z axes.
   * @return A 3x4 matrix representing a scaling by the given factor in a 3D space.
   */
  def scaling(s: Vec3d): Mat3x4d = this.scaling(s.x, s.y, s.z)

  /**
   * Returns a 3x4 matrix representing a scaling by the given factor in a 2D space.
   *
   * @param s A vector representing the scale factor on the x and y axes.
   * @return A 3x4 matrix representing a scaling by the given factor in a 2D space.
   */
  def scaling(s: Vec2d): Mat3x4d = this.scaling(s.x, s.y, 1.0)

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
    def *(v: Mat3x4d): Mat3x4d = v * self
  }
}