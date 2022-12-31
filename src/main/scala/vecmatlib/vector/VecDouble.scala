package vecmatlib.vector

/**
 * Trait for all double vectors.
 *
 * @tparam D The vector class extending this trait
 */
trait VecDouble[D <: VecDouble[D]] extends VecBase[D] {

  /**
   * Returns the sum between this vector and the given one.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  def +(v: VecAsDouble[D]): D = this + v.toDouble

  /**
   * Returns the sum between this vector and the given one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  def plus(v: VecAsDouble[D]): D = this + v

  /**
   * Returns the subtraction between the given vector and this one.
   *
   * @param v The vector to subtract.
   * @return The subtraction of the given vector from this one.
   */
  def -(v: VecAsDouble[D]): D = this - v.toDouble

  /**
   * Returns the subtraction between the given vector and this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param v The vector to subtract.
   * @return The subtraction of the given vector from this one.
   */
  def minus(v: VecAsDouble[D]): D = this - v

  /**
   * Returns the product between this vector and the given scalar.
   *
   * @param k The scalar to which the vector is multiplied.
   * @return The result of the product between this vector and the given scalar.
   */
  def *(k: Double): D

  /**
   * Returns the product between this vector and the given scalar.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param k The scalar to which the vector is multiplied.
   * @return The result of the product between this vector and the given scalar.
   */
  def multipliedBy(k: Double): D = this * k

  /**
   * Returns the division of this vector by the given scalar.
   *
   * @param k The scalar by which the vector is divided.
   * @return The result of the division of this vector by the given scalar.
   */
  def /(k: Double): D = this * (1.0 / k)

  /**
   * Returns the division of this vector by the given scalar.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param k The scalar by which the vector is divided.
   * @return The result of the division of this vector by the given scalar.
   */
  def dividedBy(k: Double): D = this / k

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  def *(v: VecAsDouble[D]): D = this * v.toDouble

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  def multiply(v: VecAsDouble[D]): D = this * v

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied.
   * @return The result of the dot product between this vector and the given one.
   */
  def dot(v: D): Double

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied.
   * @return The result of the dot product between this vector and the given one.
   */
  def dot(v: VecAsDouble[D]): Double = this dot v.toDouble

  /**
   * Returns the squared length (or squared magnitude) of this vector.
   *
   * @return The squared length of this vector.
   */
  def lengthSquared: Double

  override def length: Double = Math.sqrt(this.lengthSquared)

  /**
   * Returns a normalized vector that has the same direction as this one.
   *
   * @return A vector with the same direction as this one and length 1.
   */
  def normalized: D = this / this.length
}
