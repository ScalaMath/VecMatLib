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

  override def toArray: Array[Float] = Array(this.x, this.y, this.z)
}
