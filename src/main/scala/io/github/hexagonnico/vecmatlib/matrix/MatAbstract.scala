package io.github.hexagonnico.vecmatlib.matrix

import io.github.hexagonnico.vecmatlib.vector.VecAbstract

/**
 * Abstract class with base operation for all matrix types.
 *
 * @tparam M The matrix class extending this one
 * @tparam V The corresponding vector class
 */
abstract class MatAbstract[M <: MatAbstract[M, V], V <: VecAbstract[V]] {

  /**
   * Returns the sum between this matrix and the given one.
   *
   * @param m The matrix to add
   * @return The sum between this matrix and the given one
   */
  def +(m: M): M

  /**
   * Returns the sum between this matrix and the given one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param m The matrix to add
   * @return The sum between this matrix and the given one
   */
  def plus(m: M): M = this + m

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix
   */
  def unary_- : M

  /**
   * Returns the additive inverse of this matrix.
   *
   * This method can be used in place of the unary '-' operator for better interoperability with Java.
   *
   * @return The additive inverse of this matrix
   */
  def negated: M = -this

  /**
   * Returns the subtraction between the given matrix and this one.
   *
   * @param m The matrix to subtract
   * @return The subtraction of the given matrix from this one
   */
  def -(m: M): M = this + -m

  /**
   * Returns the subtraction between the given matrix and this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param m The matrix to subtract
   * @return The subtraction of the given matrix from this one
   */
  def minus(m: M): M = this - m

  /**
   * Returns the product of this matrix by the given vector.
   *
   * @param v The vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  def *(v: V): V

  /**
   * Returns the product of this matrix by the given vector.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param v The vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  def multiply(v: V): V = this * v

  /**
   * Returns the transposed of this matrix.
   *
   * @return The transposed of this matrix
   */
  def transposed: M

  /**
   * Returns the negated transposed of this matrix.
   *
   * @return The negated transposed of this matrix
   */
  def negatedTransposed: M = -this.transposed

  /**
   * Checks if this matrix is symmetric, i. e., if it is equal to its transposed.
   *
   * @return True if this matrix is symmetric, otherwise false
   */
  def isSymmetric: Boolean = this == this.transposed

  /**
   * Checks if this matrix is skew-symmetric, i. e., if it is equal to its negated transposed.
   *
   * @return True if this matrix is skew-symmetric, otherwise false
   */
  def isSkewSymmetric: Boolean = this == this.negatedTransposed

  /**
   * Returns the product between this matrix and the given one.
   *
   * @param m The matrix by which this one is multiplied
   * @return The product between this matrix and the given one
   */
  def *(m: M): M

  /**
   * Returns the product between this matrix and the given one.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param m The matrix by which this one is multiplied
   * @return The product between this matrix and the given one
   */
  def multiply(m: M): M = this * m

  /**
   * Returns this matrix to the power of the given exponent.
   *
   * @param exp The exponent
   * @return This matrix raised to the power of the given exponent
   */
  def power(exp: Int): M
}
