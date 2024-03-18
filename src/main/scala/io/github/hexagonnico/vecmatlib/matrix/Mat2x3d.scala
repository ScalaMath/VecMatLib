package io.github.hexagonnico.vecmatlib.matrix

import io.github.hexagonnico.vecmatlib
import io.github.hexagonnico.vecmatlib.DoubleEqualsApprox
import io.github.hexagonnico.vecmatlib.vector.{Vec2d, Vec3d}

/**
 * A 2x3 (two rows and three columns) double matrix.
 *
 * Useful for representing 2D transformations such as translation, rotation, and scaling.
 *
 * @constructor Constructs a matrix from the given values.
 * @param m00 Element 0 0
 * @param m01 Element 0 1
 * @param m02 Element 0 2
 * @param m10 Element 1 0
 * @param m11 Element 1 1
 * @param m12 Element 1 2
 */
case class Mat2x3d(m00: Double, m01: Double, m02: Double, m10: Double, m11: Double, m12: Double) {

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def +(m: Mat2x3d): Mat2x3d = Mat2x3d(
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
  def plus(m: Mat2x3d): Mat2x3d = this + m

  /**
   * Returns this exact matrix.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This exact matrix.
   */
  def unary_+(): Mat2x3d = this

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def -(m: Mat2x3d): Mat2x3d = Mat2x3d(
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
  def minus(m: Mat2x3d): Mat2x3d = this - m

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix.
   */
  def unary_-(): Mat2x3d = Mat2x3d(
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
  def negated: Mat2x3d = -this

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def *(k: Double): Mat2x3d = Mat2x3d(
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
  def multipliedBy(k: Double): Mat2x3d = this * k

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def /(k: Double): Mat2x3d = Mat2x3d(
    this.m00 / k, this.m01 / k, this.m02 / k,
    this.m10 / k, this.m11 / k, this.m12 / k
  )

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def dividedBy(k: Double): Mat2x3d = this / k

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
   * Returns the row at the given index as a [[Vec3d]].
   *
   * @param i The index of the requested row. Must be either 0 or 1.
   * @return The row at the given index.
   * @throws scala.MatchError If the given index is out of bounds.
   * @see [[row0]] and [[row1]]
   */
  def row(i: Int): Vec3d = i match {
    case 0 => this.row0
    case 1 => this.row1
  }

  /**
   * Returns the first column of this matrix as a [[Vec2d]].
   *
   * @return The first column of this matrix.
   * @see [[col]]
   */
  def col0: Vec2d = Vec2d(this.m00, this.m10)

  /**
   * Returns the second column of this matrix as a [[Vec2d]].
   *
   * @return The second column of this matrix.
   * @see [[col]]
   */
  def col1: Vec2d = Vec2d(this.m01, this.m11)

  /**
   * Returns the third column of this matrix as a [[Vec2d]].
   *
   * @return The third column of this matrix.
   * @see [[col]]
   */
  def col2: Vec2d = Vec2d(this.m02, this.m12)

  /**
   * Returns the column at the given index as a [[Vec2d]].
   *
   * @param i The index of the requested column. Must be either 0, 1, or 2.
   * @return The column at the given index.
   * @throws scala.MatchError If the given index is out of bounds.
   * @see [[col0]], [[col1]], and [[col2]]
   */
  def col(i: Int): Vec2d = i match {
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
  def *(v: Vec3d): Vec2d = Vec2d(this.row0.dot(v), this.row1.dot(v))

  /**
   * Multiplies this matrix by the given vector and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param v The vector to multiply this matrix by.
   * @return The product of this matrix by the given vector.
   */
  def multiply(v: Vec3d): Vec2d = this * v

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * @param x The vector's x component.
   * @param y The vector's y component.
   * @param z The vector's z component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(x: Double, y: Double, z: Double): Vec2d = this * Vec3d(x, y, z)

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
  def multiply(x: Double, y: Double, z: Double): Vec2d = this * (x, y, z)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * Useful to simplify the transformation of a 2D point.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(xy: Vec2d, z: Double): Vec2d = this * (xy.x, xy.y, z)

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
  def multiply(xy: Vec2d, z: Double): Vec2d = this * (xy, z)

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def *(m: Mat3d): Mat2x3d = Mat2x3d(
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
  def multiply(m: Mat3d): Mat2x3d = this * m

  /**
   * Computes the linear interpolation between the elements of this matrix and the elements of the given one by the given weight and returns the result.
   *
   * The given weight must be in the `[0.0, 1.0]` range, representing the amount of interpolation.
   *
   * @param to The second matrix.
   * @param weight The weight of the interpolation between `0.0` and `1.0`.
   * @return The result of linearly interpolating between the elements of this matrix and the elements of the given one.
   */
  def lerp(to: Mat2x3d, weight: Double): Mat2x3d = Mat2x3d(
    vecmatlib.lerp(this.m00, to.m00, weight), vecmatlib.lerp(this.m01, to.m01, weight), vecmatlib.lerp(this.m02, to.m02, weight),
    vecmatlib.lerp(this.m10, to.m10, weight), vecmatlib.lerp(this.m11, to.m11, weight), vecmatlib.lerp(this.m12, to.m12, weight)
  )

  /**
   * Returns a matrix with all elements in absolute value.
   *
   * @return A matrix with all elements in absolute value.
   */
  def abs: Mat2x3d = Mat2x3d(
    this.m00.abs, this.m01.abs, this.m02.abs,
    this.m10.abs, this.m11.abs, this.m12.abs
  )

  /**
   * Returns a matrix with the signs of the elements of this matrix.
   *
   * @return A matrix with all elements representing the sign of this matrix.
   */
  def sign: Mat2x3d = Mat2x3d(
    this.m00.sign, this.m01.sign, this.m02.sign,
    this.m10.sign, this.m11.sign, this.m12.sign
  )

  /**
   * Returns a matrix with all elements rounded to the nearest integer.
   *
   * @return A matrix with all elements rounded to the nearest integer.
   */
  def round: Mat2x3d = Mat2x3d(
    this.m00.round, this.m01.round, this.m02.round,
    this.m10.round, this.m11.round, this.m12.round
  )

  /**
   * Returns a matrix with all elements rounded up.
   *
   * @return A matrix with all elements rounded up.
   */
  def ceil: Mat2x3d = Mat2x3d(
    this.m00.ceil, this.m01.ceil, this.m02.ceil,
    this.m10.ceil, this.m11.ceil, this.m12.ceil
  )

  /**
   * Returns a matrix with all elements rounded down.
   *
   * @return A matrix with all elements rounded down.
   */
  def floor: Mat2x3d = Mat2x3d(
    this.m00.floor, this.m01.floor, this.m02.floor,
    this.m10.floor, this.m11.floor, this.m12.floor
  )

  /**
   * Constructs an orthonormal matrix from the columns of this matrix using the Gram-Schmidt procedure.
   *
   * @return This matrix with orthogonal columns of unit length.
   */
  def orthonormalized: Mat2x3d = {
    var (v0, v1, v2) = (this.col0, this.col1, this.col2)
    v1 = v1 - v1.project(v0)
    v2 = v2 - v2.project(v0) - v2.project(v1)
    Mat2x3d.fromColumns(v0.normalized, v1.normalized, v2.normalized)
  }

  /**
   * Checks if this matrix is approximately equal to the given one using an internal epsilon.
   *
   * @param m The second matrix.
   * @return True if this matrix is approximately equal to the given one, otherwise false.
   */
  def ~=(m: Mat2x3d): Boolean = (this.m00 ~= m.m00) && (this.m01 ~= m.m01) && (this.m02 ~= m.m02) && (this.m10 ~= m.m10) && (this.m11 ~= m.m11) && (this.m12 ~= m.m12)

  /**
   * Checks if this matrix is approximately equal to the given one using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator.
   *
   * @param m The second matrix.
   * @return True if this matrix is approximately equal to the given one, otherwise false.
   */
  def equalsApprox(m: Mat2x3d): Boolean = this ~= m

  /**
   * Returns the element at the given row and column index.
   *
   * @param row The row index of the desired element. Must be either 0 or 1.
   * @param col The column index of the desired element. Must be either 0, 1, or 2.
   * @return The element at the given row and column index.
   * @throws scala.MatchError If any of the given indices is out of bounds.
   */
  def apply(row: Int, col: Int): Double = (row, col) match {
    case (0, 0) => this.m00
    case (0, 1) => this.m01
    case (0, 2) => this.m02
    case (1, 0) => this.m10
    case (1, 1) => this.m11
    case (1, 2) => this.m12
  }

  /**
   * Casts this matrix to an int matrix.
   *
   * @return This matrix cast to int.
   */
  def toInt: Mat2x3i = Mat2x3i(this.m00.toInt, this.m01.toInt, this.m02.toInt, this.m10.toInt, this.m11.toInt, this.m12.toInt)

  /**
   * Casts this matrix to a float matrix.
   *
   * @return This matrix cast to float.
   */
  def toFloat: Mat2x3f = Mat2x3f(this.m00.toFloat, this.m01.toFloat, this.m02.toFloat, this.m10.toFloat, this.m11.toFloat, this.m12.toFloat)
}

/**
 * Constants, factory methods, and implicits for matrices.
 */
object Mat2x3d {

  /** Shorthand for the zero matrix */
  val Zero: Mat2x3d = Mat2x3d(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)

  /**
   * Returns a 2x3 matrix from the given rows.
   *
   * @param row0 The first row.
   * @param row1 The second row.
   * @return A 2x3 matrix from the given rows.
   */
  def fromRows(row0: Vec3d, row1: Vec3d): Mat2x3d = Mat2x3d(row0.x, row0.y, row0.z, row1.x, row1.y, row1.z)

  /**
   * Returns a 2x3 matrix from the given columns.
   *
   * @param col0 The first column.
   * @param col1 The second column.
   * @param col2 The third column.
   * @return A 2x3 matrix from the given columns.
   */
  def fromColumns(col0: Vec2d, col1: Vec2d, col2: Vec2d): Mat2x3d = Mat2x3d(col0.x, col1.x, col2.x, col0.y, col1.y, col2.y)

  /**
   * Returns a 2x3 matrix representing a translation in a 2D space.
   *
   * @param x Translation on the x axis.
   * @param y Translation on the y axis.
   * @return A 2x3 matrix representing a translation in a 2D space.
   */
  def translation(x: Double, y: Double): Mat2x3d = Mat2x3d(1.0, 0.0, x, 0.0, 1.0, y)

  /**
   * Returns a 2x3 matrix representing a translation in a 2D space.
   *
   * @param v The translation vector.
   * @return A 2x3 matrix representing a translation in a 2D space.
   */
  def translation(v: Vec2d): Mat2x3d = this.translation(v.x, v.y)

  /**
   * Returns a 2x3 matrix representing a rotation by the given angle in a 2D space.
   *
   * @param angle The rotation angle in radians.
   * @return A 2x3 matrix representing a rotation by the given angle in a 2D space.
   */
  def rotation(angle: Double): Mat2x3d = {
    val sin = math.sin(angle)
    val cos = math.cos(angle)
    Mat2x3d(cos, -sin, 0.0, sin, cos, 0.0)
  }

  /**
   * Returns a 2x3 matrix representing a scaling by the given factor in a 2D space.
   *
   * @param x Scale factor on the x axis.
   * @param y Scale factor on the y axis.
   * @return A 2x3 matrix representing a scaling by the given factor in a 2D space.
   */
  def scaling(x: Double, y: Double): Mat2x3d = Mat2x3d(x, 0.0, 0.0, 0.0, y, 0.0)

  /**
   * Returns a 2x3 matrix representing a scaling by the given factor in a 2D space.
   *
   * @param v A vector representing the scale factor on the x and y axes.
   * @return A 2x3 matrix representing a scaling by the given factor in a 2D space.
   */
  def scaling(v: Vec2d): Mat2x3d = this.scaling(v.x, v.y)

  /**
   * Returns a 2x3 matrix representing a scaling by the given factor in a 2D space.
   *
   * @param scale Scale factor on the x and y axes.
   * @return A 2x3 matrix representing a scaling by the given factor in a 2D space.
   */
  def scaling(scale: Double): Mat2x3d = this.scaling(scale, scale)

  /**
   * Returns a 2x3 matrix representing a shear transformation by the given angles in a 2D space.
   *
   * @param x Angle on the x axis in radians.
   * @param y Angle on the y axis in radians.
   * @return A 2x3 matrix representing a shear transformation by the given angles in a 2D space.
   */
  def shearing(x: Double, y: Double): Mat2x3d = Mat2x3d(
    1.0, math.tan(x), 0.0,
    math.tan(y), 1.0, 0.0
  )

  /**
   * Returns a 2x3 matrix representing a shear transformation by the given angles in a 2D space.
   *
   * @param v A vector representing the shear angle on the x and y axes.
   * @return A 2x3 matrix representing a shear transformation by the given angles in a 2D space.
   */
  def shearing(v: Vec2d): Mat2x3d = this.shearing(v.x, v.y)

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
    def *(v: Mat2x3d): Mat2x3d = v * self
  }
}