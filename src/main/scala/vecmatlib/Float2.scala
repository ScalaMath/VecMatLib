package vecmatlib

/**
 * Trait that represents a 2-dimensional float tuple
 */
trait Float2 {

  /**
   * X component.
   *
   * @return The X component of this tuple
   */
  def x: Float

  /**
   * Y component.
   *
   * @return The Y component of this tuple
   */
  def y: Float

  /**
   * Returns an array of length 2 containing the x and y components of this tuple.
   *
   * @return An array of length 2 containing the x and y components of this tuple
   */
  def toArray: Array[Float] = Array(this.x, this.y)
}
