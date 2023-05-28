package io.github.hexagonnico.vecmatlib.matrix

import io.github.hexagonnico.vecmatlib.vector.VecFloat

/**
 * Abstract class with operation for float matrices.
 *
 * @tparam M The matrix class extending this one
 * @tparam V The corresponding vector class
 */
abstract class MatFloat[M <: MatFloat[M, V], V <: VecFloat[V]] extends MatAbstract[M, V] {

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
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix
   */
  def determinant: Float
}
