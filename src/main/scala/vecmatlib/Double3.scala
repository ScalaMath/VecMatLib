package vecmatlib

/**
 * Trait that represents a 3-dimensional double tuple
 */
trait Double3 extends Double2 {

  /**
   * Z component.
   *
   * @return The Z component of this tuple
   */
  def z: Double

  /**
   * Returns an array of length 3 containing the x, y, and z components of this tuple.
   *
   * @return An array of length 3 containing the x, y and z components of this tuple
   */
  override def toArray: Array[Double] = Array(this.x, this.y, this.z)
}
