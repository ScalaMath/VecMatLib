package vecmatlib

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

  override def toArray: Array[Int] = Array(this.x, this.y, this.z)
}
