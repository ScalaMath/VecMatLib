package vecmatlib

/**
 * Trait that represents a 4-dimensional double tuple
 */
trait Double4 extends Double3 {

  /**
   * W component.
   *
   * @return The W component of this tuple
   */
  def w: Double

  /**
   * Returns an array of length 4 containing the x, y, z, and w components of this tuple.
   *
   * @return An array of length 4 containing the x, y, z, and w components of this tuple
   */
  override def toArray: Array[Double] = Array(this.x, this.y, this.z, this.w)
}
