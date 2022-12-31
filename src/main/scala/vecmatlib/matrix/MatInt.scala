package vecmatlib.matrix

import vecmatlib.vector.VecInt

/**
 * Trait for all int matrices.
 *
 * @tparam M The matrix class extending this trait
 * @tparam V The corresponding vector class
 */
trait MatInt[M <: MatInt[M, V], V <: VecInt[V]] extends MatBase[M, V] {

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
}
