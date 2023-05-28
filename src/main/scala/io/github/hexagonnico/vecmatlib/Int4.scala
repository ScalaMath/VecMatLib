package io.github.hexagonnico.vecmatlib

/**
 * Trait that represents a 4-dimensional int tuple
 */
trait Int4 extends Int3 {

  /**
   * W component.
   *
   * @return The W component of this tuple
   */
  def w: Int

  /**
   * Returns an array of length 4 containing the x, y, z, and w components of this tuple.
   *
   * @return An array of length 4 containing the x, y, z, and w components of this tuple
   */
  override def toArray: Array[Int] = Array(this.x, this.y, this.z, this.w)
}
