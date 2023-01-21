package vecmatlib

/**
 * Trait that represents a 4-dimensional int tuple
 */
trait Int4 extends Int3 {

  /**
   * W component.
   *
   * @return The W component of this tuple
   */
  def w: Int
}
