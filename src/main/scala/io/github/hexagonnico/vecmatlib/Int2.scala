package io.github.hexagonnico.vecmatlib

/**
 * Trait that represents a 2-dimensional int tuple
 */
trait Int2 {

  /**
   * X component.
   *
   * @return The X component of this tuple
   */
  def x: Int

  /**
   * Y component.
   *
   * @return The Y component of this tuple
   */
  def y: Int

  /**
   * Returns an array of length 2 containing the x and y components of this tuple.
   *
   * @return An array of length 2 containing the x and y components of this tuple
   */
  def toArray: Array[Int] = Array(this.x, this.y)
}
