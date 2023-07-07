package io.github.hexagonnico.vecmatlib.vector

import io.github.hexagonnico.vecmatlib.Int2

/**
 * Class that represents a two-dimensional int vector.
 *
 * @constructor Constructs a Vec2i from the three given values.
 * @param x X component of the vector
 * @param y Y component of the vector
 */
case class Vec2i(x: Int, y: Int) extends VecInt[Vec2i] with Int2 {

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def +(x: Int, y: Int): Vec2i = Vec2i(this.x + x, this.y + y)

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def plus(x: Int, y: Int): Vec2i = this + (x, y)

  /**
   * Returns the sum between this vector and the given one.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  override def +(v: Vec2i): Vec2i = this + (v.x, v.y)

  /**
   * Returns the additive inverse of this vector.
   *
   * @return The additive inverse of this vector
   */
  override def unary_- : Vec2i = Vec2i(-this.x, -this.y)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def -(x: Int, y: Int): Vec2i = this + (-x, -y)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def minus(x: Int, y: Int): Vec2i = this - (x, y)

  /**
   * Returns the product between this vector and the given scalar.
   *
   * @param k The scalar to which the vector is multiplied.
   * @return The result of the product between this vector and the given scalar.
   */
  override def *(k: Int): Vec2i = this * (k, k)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def *(x: Int, y: Int): Vec2i = Vec2i(this.x * x, this.y * y)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def multiply(x: Int, y: Int): Vec2i = this * (x, y)

  /**
   * Returns the division of this vector by the given scalar.
   *
   * @param k The scalar by which the vector is divided.
   * @return The result of the division of this vector by the given scalar.
   */
  override def /(k: Int): Vec2i = Vec2i(this.x / k, this.y / k)

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  override def *(v: Vec2i): Vec2i = this * (v.x, v.y)

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Int, y: Int): Int = this.x * x + this.y * y

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied.
   * @return The result of the dot product between this vector and the given one.
   */
  override def dot(v: Vec2i): Int = this.dot(v.x, v.y)

  /**
   * Returns the squared length (or squared magnitude) of this vector.
   *
   * @return The squared length of this vector.
   */
  override def lengthSquared: Int = this dot this

  /**
   * Returns the angle in radians between this vector and the one with the given components.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @return The angle in radians between this vector and the one with the given components
   */
  def angle(x: Double, y: Double): Double = this.toDouble.angle(Vec2d(x, y))

  /**
   * Returns a vector with all components in absolute value.
   *
   * @return This vector with all components in absolute value
   */
  override def abs: Vec2i = Vec2i(math.abs(this.x), math.abs(this.y))

  /**
   * Returns the squared distance between this vector and the one with the given components.
   *
   * Using `a.distanceSquaredTo(b)` is equivalent to using `(b - a).lengthSquared`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @return The squared distance between this vector and the one with the given components
   */
  def distanceSquaredTo(x: Int, y: Int): Int = this.distanceSquaredTo(Vec2i(x, y))

  /**
   * Returns the distance between this vector and the one with the given components.
   *
   * Using `a.distanceTo(b)` is equivalent to using `(b - a).length`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @return The distance between this vector and the one with the given components
   */
  def distanceTo(x: Int, y: Int): Double = this.distanceTo(Vec2i(x, y))

  /**
   * Returns this vector reflected from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(x: Int, y: Int): Vec2i = this.reflect(Vec2i(x, y))

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(x: Int, y: Int): Vec2i = this.bounce(Vec2i(x, y))

  /**
   * Returns this vector projected onto the one with the given components.
   *
   * @param x X component of the vector to project onto
   * @param y Y component of the vector to project onto
   * @return This vector projected onto the one with the given components
   */
  def project(x: Int, y: Int): Vec2i = this.project(Vec2i(x, y))

  /**
   * Returns this vector slid along a plane defined by the normal with the given components.
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(x: Int, y: Int): Vec2i = this.slide(Vec2i(x, y))

  /**
   * Converts this vector to a float vector.
   *
   * @return This same vector as a float vector
   */
  def toFloat: Vec2f = Vec2f(this.x.toFloat, this.y.toFloat)

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
  def ==(x: Int, y: Int): Boolean = this.x == x && this.y == y

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * This method can be used in place of the '==' operator for better interoperability with Java.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def equals(x: Int, y: Int): Boolean = this == (x, y)
}

object Vec2i {
  /** Shorthand for `new Vec2i(0, 0)` */
  val Zero: Vec2i = Vec2i(0, 0)
  /** Shorthand for `new Vec2i(1, 1)` */
  val One: Vec2i = Vec2i(1, 1)
  /** Shorthand for `new Vec2i(1, 0)` */
  val Right: Vec2i = Vec2i(1, 0)
  /** Shorthand for `new Vec2i(-1, 0)` */
  val Left: Vec2i = Vec2i(-1, 0)
  /** Shorthand for `new Vec2i(0, 1)` */
  val Up: Vec2i = Vec2i(0, 1)
  /** Shorthand for `new Vec2i(0, -1)` */
  val Down: Vec2i = Vec2i(0, -1)

  /**
   * Allows to use the operator '*' with a scalar as `1.0f * vector`.
   *
   * @param k The scalar to which the vector is multiplied
   */
  implicit class MultiplicationExtender(val k: Int) extends AnyVal {

    /**
     * Returns the product between this scalar and the given vector.
     *
     * @param v The vector to which the scalar is multiplied
     * @return The result of the product between this scalar and the given vector
     */
    def *(v: Vec2i): Vec2i = v * k
  }
}
