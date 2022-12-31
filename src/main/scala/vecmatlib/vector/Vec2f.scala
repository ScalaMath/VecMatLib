package vecmatlib.vector

import vecmatlib.Float2

/**
 * Two-dimensional float vector.
 *
 * @param x X component of the vector
 * @param y Y component of the vector
 */
case class Vec2f(x: Float, y: Float) extends Float2 with VecFloat[Vec2f] with VecAsDouble[Vec2d] {

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def +(x: Float, y: Float): Vec2f = Vec2f(this.x + x, this.y + y)

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def plus(x: Float, y: Float): Vec2f = this + (x, y)

  override def +(v: Vec2f): Vec2f = this + (v.x, v.y)

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

  override def unary_- : Vec2f = Vec2f(-this.x, -this.y)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def -(x: Float, y: Float): Vec2f = this + (-x, -y)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def minus(x: Float, y: Float): Vec2f = this - (x, y)

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

  override def *(k: Float): Vec2f = Vec2f(this.x * k, this.y * k)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def *(x: Float, y: Float): Vec2f = Vec2f(this.x * x, this.y * y)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def multiply(x: Float, y: Float): Vec2f = this * (x, y)

  override def *(v: Vec2f): Vec2f = this * (v.x, v.y)

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

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Float, y: Float): Float = this.x * x + this.y * y

  override def dot(v: Vec2f): Float = this.dot(v.x, v.y)

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Double, y: Double): Double = this.x * x + this.y * y

  override def lengthSquared: Float = this dot this

  /**
   * Casts this vector to an int vector.
   *
   * @return A vector same as this one cast to int.
   */
  def toInt: Vec2i = Vec2i(this.x.toInt, this.y.toInt)

  override def toDouble: Vec2d = Vec2d(this.x.toDouble, this.y.toDouble)

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x X component of the vector.
   * @param y Y component of the vector.
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def ==(x: Float, y: Float): Boolean = this.x == x && this.y == y

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * This method can be used in place of the '==' operator for better interoperability with Java.
   *
   * @param x X component of the vector.
   * @param y Y component of the vector.
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def equals(x: Float, y: Float): Boolean = this == (x, y)
}

object Vec2f {
  /** Shorthand for `new Vec3f(0.0f, 0.0f)` */
  val Zero: Vec2f = Vec2f(0.0f, 0.0f)
  /** Shorthand for `new Vec3f(1.0f, 1.0f)` */
  val One: Vec2f = Vec2f(1.0f, 1.0f)
  /** Shorthand for `new Vec3f(1.0f, 0.0f)` */
  val Right: Vec2f = Vec2f(1.0f, 0.0f)
  /** Shorthand for `new Vec3f(-1.0f, 0.0f)` */
  val Left: Vec2f = Vec2f(-1.0f, 0.0f)
  /** Shorthand for `new Vec3f(0.0f, 1.0f)` */
  val Up: Vec2f = Vec2f(0.0f, 1.0f)
  /** Shorthand for `new Vec3f(0.0f, -1.0f)` */
  val Down: Vec2f = Vec2f(0.0f, -1.0f)
}
