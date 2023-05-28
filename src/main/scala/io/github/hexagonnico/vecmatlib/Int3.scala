package io.github.hexagonnico.vecmatlib

/**
 * Trait that represents a 3-dimensional int tuple
 */
trait Int3 extends Int2 {

  /**
   * Z component.
   *
   * @return The Z component of this tuple
   */
  def z: Int

  /**
   * Returns an array of length 3 containing the x, y, and z components of this tuple.
   *
   * @return An array of length 3 containing the x, y and z components of this tuple
   */
  override def toArray: Array[Int] = Array(this.x, this.y, this.z)
}
