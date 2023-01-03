package vecmatlib.matrix

import vecmatlib.vector.VecDouble

/**
 * Abstract class with operation for double matrices.
 *
 * @tparam M The matrix class extending this one
 * @tparam V The corresponding vector class
 */
abstract class MatDouble[M <: MatDouble[M, V], V <: VecDouble[V]] extends MatAbstract[M, V] {

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
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix
   */
  def determinant: Double
}
