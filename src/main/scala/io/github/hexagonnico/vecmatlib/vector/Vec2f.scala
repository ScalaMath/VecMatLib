package io.github.hexagonnico.vecmatlib.vector

import io.github.hexagonnico.vecmatlib.Float2

/**
 * Class that represents a two-dimensional float vector.
 *
 * @constructor Constructs a Vec2f from the three given values.
 * @param x X component of the vector
 * @param y Y component of the vector
 */
case class Vec2f(x: Float, y: Float) extends VecFloat[Vec2f] with Float2 {

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

  /**
   * Returns the sum between this vector and the given one.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  override def +(v: Vec2f): Vec2f = this + (v.x, v.y)

  /**
   * Returns the additive inverse of this vector.
   *
   * @return The additive inverse of this vector
   */
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
   * Returns the product between this vector and the given scalar.
   *
   * @param k The scalar to which the vector is multiplied.
   * @return The result of the product between this vector and the given scalar.
   */
  override def *(k: Float): Vec2f = this * (k, k)

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

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  override def *(v: Vec2f): Vec2f = this * (v.x, v.y)

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Float, y: Float): Float = this.x * x + this.y * y

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied.
   * @return The result of the dot product between this vector and the given one.
   */
  override def dot(v: Vec2f): Float = this.dot(v.x, v.y)

  /**
   * Returns the squared length (or squared magnitude) of this vector.
   *
   * @return The squared length of this vector.
   */
  override def lengthSquared: Float = this dot this

  /**
   * Returns the angle in radians between this vector and the one with the given components.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @return The angle in radians between this vector and the one with the given components
   */
  def angle(x: Double, y: Double): Double = this.toDouble.angle(Vec2d(x, y))

  /**
   * Returns a vector whose components are the multiplicative inverse of this vectors components.
   *
   * @return A vector whose components are the multiplicative inverse of this vectors components
   */
  override def inverse: Vec2f = Vec2f(1.0f / this.x, 1.0f / this.y)

  /**
   * Returns the component-wise division between this vector and the given scalars.
   *
   * @param x Value by which the X component is divided
   * @param y Value by which the Y component is divided
   * @return The component-wise division between this vector and the given scalars.
   */
  def /(x: Float, y: Float): Vec2f = Vec2f(this.x / x, this.y / y)

  /**
   * Returns the component-wise division between this vector and the given scalars.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param x Value by which the X component is divided
   * @param y Value by which the Y component is divided
   * @return The component-wise division between this vector and the given scalars.
   */
  def divide(x: Float, y: Float): Vec2f = this / (x, y)

  /**
   * Returns a vector with all components in absolute value.
   *
   * @return This vector with all components in absolute value
   */
  override def abs: Vec2f = Vec2f(math.abs(this.x), math.abs(this.y))

  /**
   * Returns the normalized vector pointing from this vector to the one with the given components.
   *
   * Using `a.directionTo(b)` is equivalent to using `(b - a).normalized`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @return The normalized vector pointing from this vector to the given one
   */
  def directionTo(x: Float, y: Float): Vec2f = this.directionTo(Vec2f(x, y))

  /**
   * Returns the squared distance between this vector and the one with the given components.
   *
   * Using `a.distanceSquaredTo(b)` is equivalent to using `(b - a).lengthSquared`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @return The squared distance between this vector and the one with the given components
   */
  def distanceSquaredTo(x: Float, y: Float): Float = this.distanceSquaredTo(Vec2f(x, y))

  /**
   * Returns the distance between this vector and the one with the given components.
   *
   * Using `a.distanceTo(b)` is equivalent to using `(b - a).length`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @return The distance between this vector and the one with the given components
   */
  def distanceTo(x: Float, y: Float): Double = this.distanceTo(Vec2f(x, y))

  /**
   * Returns this vector reflected from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(x: Float, y: Float): Vec2f = this.reflect(Vec2f(x, y))

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(x: Float, y: Float): Vec2f = this.bounce(Vec2f(x, y))

  /**
   * Returns this vector projected onto the one with the given components.
   *
   * @param x X component of the vector to project onto
   * @param y Y component of the vector to project onto
   * @return This vector projected onto the one with the given components
   */
  def project(x: Float, y: Float): Vec2f = this.project(Vec2f(x, y))

  /**
   * Returns this vector slid along a plane defined by the normal with the given components.
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(x: Float, y: Float): Vec2f = this.slide(Vec2f(x, y))

  /**
   * Casts this vector to an int vector.
   *
   * @return A vector same as this one cast to int
   */
  def toInt: Vec2i = Vec2i(this.x.toInt, this.y.toInt)

  /**
   * Converts this vector to a double vector.
   *
   * @return This same vector as a double vector
   */
  def toDouble: Vec2d = Vec2d(this.x.toDouble, this.y.toDouble)

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def ==(x: Float, y: Float): Boolean = this.x == x && this.y == y

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * This method can be used in place of the '==' operator for better interoperability with Java.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def equals(x: Float, y: Float): Boolean = this == (x, y)
}

object Vec2f {
  /** Shorthand for `new Vec2f(0.0f, 0.0f)` */
  val Zero: Vec2f = Vec2f(0.0f, 0.0f)
  /** Shorthand for `new Vec2f(1.0f, 1.0f)` */
  val One: Vec2f = Vec2f(1.0f, 1.0f)
  /** Shorthand for `new Vec2f(1.0f, 0.0f)` */
  val Right: Vec2f = Vec2f(1.0f, 0.0f)
  /** Shorthand for `new Vec2f(-1.0f, 0.0f)` */
  val Left: Vec2f = Vec2f(-1.0f, 0.0f)
  /** Shorthand for `new Vec2f(0.0f, 1.0f)` */
  val Up: Vec2f = Vec2f(0.0f, 1.0f)
  /** Shorthand for `new Vec2f(0.0f, -1.0f)` */
  val Down: Vec2f = Vec2f(0.0f, -1.0f)
}
