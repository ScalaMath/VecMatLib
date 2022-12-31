package vecmatlib.vector

import vecmatlib.Double2

/**
 * Two-dimensional double vector.
 *
 * @param x X component of the vector
 * @param y Y component of the vector
 */
case class Vec2d(x: Double, y: Double) extends Double2 with VecDouble[Vec2d] {

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def +(x: Double, y: Double): Vec2d = Vec2d(this.x + x, this.y + y)

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def plus(x: Double, y: Double): Vec2d = this + (x, y)

  override def +(v: Vec2d): Vec2d = this + (v.x, v.y)

  override def unary_- : Vec2d = Vec2d(-this.x, -this.y)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def -(x: Double, y: Double): Vec2d = this + (-x, -y)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def minus(x: Double, y: Double): Vec2d = this - (x, y)

  override def *(k: Double): Vec2d = Vec2d(this.x * k, this.y * k)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def *(x: Double, y: Double): Vec2d = Vec2d(this.x * x, this.y * y)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def multiply(x: Double, y: Double): Vec2d = this * (x, y)

  override def *(v: Vec2d): Vec2d = this * (v.x, v.y)

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Double, y: Double): Double = this.x * x + this.y * y

  override def dot(v: Vec2d): Double = this.dot(v.x, v.y)

  override def lengthSquared: Double = this dot this

  /**
   * Casts this vector to an int vector.
   *
   * @return A vector same as this one cast to int
   */
  def toInt: Vec2i = Vec2i(this.x.toInt, this.y.toInt)

  /**
   * Casts this vector to a float vector.
   *
   * @return A vector same as this one cast to float
   */
  def toFloat: Vec2f = Vec2f(this.x.toFloat, this.y.toFloat)

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def ==(x: Double, y: Double): Boolean = this.x == x && this.y == y

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * This method can be used in place of the '==' operator for better interoperability with Java.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def equals(x: Double, y: Double): Boolean = this == (x, y)
}

object Vec2d {
  /** Shorthand for `new Vec2d(0.0, 0.0)` */
  val Zero: Vec2d = Vec2d(0.0, 0.0)
  /** Shorthand for `new Vec2d(1.0, 1.0)` */
  val One: Vec2d = Vec2d(1.0, 1.0)
  /** Shorthand for `new Vec2d(1.0, 0.0)` */
  val Right: Vec2d = Vec2d(1.0, 0.0)
  /** Shorthand for `new Vec2d(-1.0, 0.0)` */
  val Left: Vec2d = Vec2d(-1.0, 0.0)
  /** Shorthand for `new Vec2d(0.0, 1.0)` */
  val Up: Vec2d = Vec2d(0.0, 1.0)
  /** Shorthand for `new Vec2d(0.0, -1.0)` */
  val Down: Vec2d = Vec2d(0.0, -1.0)
}
