package vecmatlib

/**
 * Trait that represents a 2-dimensional double tuple
 */
trait Double2 {

  /**
   * X component.
   *
   * @return The X component of this tuple
   */
  def x: Double

  /**
   * Y component.
   *
   * @return The Y component of this tuple
   */
  def y: Double

  /**
   * Returns an array of length 2 containing the x and y components of this tuple.
   *
   * @return An array of length 2 containing the x and y components of this tuple
   */
  def toArray: Array[Double] = Array(this.x, this.y)
}
