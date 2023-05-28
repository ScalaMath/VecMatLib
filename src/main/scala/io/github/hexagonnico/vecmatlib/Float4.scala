package io.github.hexagonnico.vecmatlib

/**
 * Trait that represents a 4-dimensional float tuple
 */
trait Float4 extends Float3 {

  /**
   * W component.
   *
   * @return The W component of this tuple
   */
  def w: Float

  /**
   * Returns an array of length 4 containing the x, y, z, and w components of this tuple.
   *
   * @return An array of length 4 containing the x, y, z, and w components of this tuple
   */
  override def toArray: Array[Float] = Array(this.x, this.y, this.z, this.w)
}
