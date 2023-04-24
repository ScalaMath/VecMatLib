package vecmatlib

/**
 * Trait that represents a 3-dimensional float tuple
 */
trait Float3 extends Float2 {

  /**
   * Z component.
   *
   * @return The Z component of this tuple
   */
  def z: Float

  /**
   * Returns an array of length 3 containing the x, y, and z components of this tuple.
   *
   * @return An array of length 3 containing the x, y and z components of this tuple
   */
  override def toArray: Array[Float] = Array(this.x, this.y, this.z)
}
