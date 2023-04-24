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

  override def toArray: Array[Double] = Array(this.x, this.y, this.z, this.w)
}
