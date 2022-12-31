package vecmatlib.matrix

import vecmatlib.vector.{VecAsFloat, VecFloat}

/**
 * Trait for all float matrices.
 *
 * @tparam M The matrix class extending this trait
 * @tparam V The corresponding vector class
 */
trait MatFloat[M <: MatFloat[M, V], V <: VecFloat[V]] extends MatBase[M, V] {

  /**
   * Returns the sum between this matrix and the given one.
   *
   * @param m The matrix to add
   * @return The sum between this matrix and the given one
   */
  def +(m: MatAsFloat[M, V]): M = this + m.toFloat

  /**
   * Returns the sum between this matrix and the given one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param m The matrix to add
   * @return The sum between this matrix and the given one
   */
  def plus(m: MatAsFloat[M, V]): M = this + m

  /**
   * Returns the subtraction between the given matrix and this one.
   *
   * @param m The matrix to subtract
   * @return The subtraction of the given matrix from this one
   */
  def -(m: MatAsFloat[M, V]): M = this - m.toFloat

  /**
   * Returns the subtraction between the given matrix and this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param m The matrix to subtract
   * @return The subtraction of the given matrix from this one
   */
  def minus(m: MatAsFloat[M, V]): M = this - m

  /**
   * Returns the product of this matrix by the given scalar.
   *
   * @param k The scalar by which this matrix is multiplied
   * @return The product of this matrix by the given scalar
   */
  def *(k: Float): M

  /**
   * Returns the product of this matrix by the given scalar.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param k The scalar by which this matrix is multiplied
   * @return The product of this matrix by the given scalar
   */
  def multipliedBy(k: Float): M = this * k

  /**
   * Returns the product of this matrix by the given vector.
   *
   * @param v The vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  def *(v: VecAsFloat[V]): V = this * v.toFloat

  /**
   * Returns the product of this matrix by the given vector.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param v The vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  def multiply(v: VecAsFloat[V]): V = this * v

  /**
   * Returns the product between this matrix and the given one.
   *
   * @param m The matrix by which this one is multiplied
   * @return The product between this matrix and the given one
   */
  def *(m: MatAsFloat[M, V]): M = this * m.toFloat

  /**
   * Returns the product between this matrix and the given one.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param m The matrix by which this one is multiplied
   * @return The product between this matrix and the given one
   */
  def multiply(m: MatAsFloat[M, V]): M = this * m
}
