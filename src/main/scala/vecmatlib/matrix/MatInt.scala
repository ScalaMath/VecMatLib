package vecmatlib.matrix

import vecmatlib.vector.VecInt

/**
 * Abstract class with operation for int matrices.
 *
 * @tparam M The matrix class extending this one
 * @tparam V The corresponding vector class
 */
abstract class MatInt[M <: MatInt[M, V], V <: VecInt[V]] extends MatAbstract[M, V] {

  /**
   * Returns the product of this matrix by the given scalar.
   *
   * @param k The scalar by which this matrix is multiplied
   * @return The product of this matrix by the given scalar
   */
  def *(k: Int): M

  /**
   * Returns the product of this matrix by the given scalar.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param k The scalar by which this matrix is multiplied
   * @return The product of this matrix by the given scalar
   */
  def multipliedBy(k: Int): M = this * k

  /**
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix
   */
  def determinant: Int
}
