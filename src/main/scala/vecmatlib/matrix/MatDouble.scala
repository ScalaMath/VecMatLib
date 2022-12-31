package vecmatlib.matrix

import vecmatlib.vector.{VecAsDouble, VecDouble}

/**
 * Trait for all double matrices.
 *
 * @tparam M The matrix class extending this trait
 * @tparam V The corresponding vector class
 */
trait MatDouble[M <: MatDouble[M, V], V <: VecDouble[V]] extends MatBase[M, V] {

  /**
   * Returns the sum between this matrix and the given one.
   *
   * @param m The matrix to add
   * @return The sum between this matrix and the given one
   */
  def +(m: MatAsDouble[M, V]): M = this + m.toDouble

  /**
   * Returns the sum between this matrix and the given one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param m The matrix to add
   * @return The sum between this matrix and the given one
   */
  def plus(m: MatAsDouble[M, V]): M = this + m

  /**
   * Returns the subtraction between the given matrix and this one.
   *
   * @param m The matrix to subtract
   * @return The subtraction of the given matrix from this one
   */
  def -(m: MatAsDouble[M, V]): M = this - m.toDouble

  /**
   * Returns the subtraction between the given matrix and this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param m The matrix to subtract
   * @return The subtraction of the given matrix from this one
   */
  def minus(m: MatAsDouble[M, V]): M = this - m

  /**
   * Returns the product of this matrix by the given scalar.
   *
   * @param k The scalar by which this matrix is multiplied
   * @return The product of this matrix by the given scalar
   */
  def *(k: Double): M

  /**
   * Returns the product of this matrix by the given scalar.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param k The scalar by which this matrix is multiplied
   * @return The product of this matrix by the given scalar
   */
  def multipliedBy(k: Double): M = this * k

  /**
   * Returns the product of this matrix by the given vector.
   *
   * @param v The vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  def *(v: VecAsDouble[V]): V = this * v.toDouble

  /**
   * Returns the product of this matrix by the given vector.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param v The vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  def multiply(v: VecAsDouble[V]): V = this * v

  /**
   * Returns the product between this matrix and the given one.
   *
   * @param m The matrix by which this one is multiplied
   * @return The product between this matrix and the given one
   */
  def *(m: MatAsDouble[M, V]): M = this * m.toDouble

  /**
   * Returns the product between this matrix and the given one.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param m The matrix by which this one is multiplied
   * @return The product between this matrix and the given one
   */
  def multiply(m: MatAsDouble[M, V]): M = this * m
}
