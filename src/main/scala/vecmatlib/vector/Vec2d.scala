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
   * Returns the angle in radians between this vector and the one with the given components.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @return The angle in radians between this vector and the one with the given components
   */
  def angle(x: Double, y: Double): Double = this.angle(Vec2d(x, y))

  /**
   * Returns the normalized vector pointing from this vector to the one with the given components.
   *
   * Using `a.directionTo(b)` is equivalent to using `(b - a).normalized`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @return The normalized vector pointing from this vector to the given one
   */
  def directionTo(x: Double, y: Double): Vec2d = this.directionTo(Vec2d(x, y))

  /**
   * Returns the squared distance between this vector and the one with the given components.
   *
   * Using `a.distanceSquaredTo(b)` is equivalent to using `(b - a).lengthSquared`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @return The squared distance between this vector and the one with the given components
   */
  def distanceSquaredTo(x: Double, y: Double): Double = this.distanceSquaredTo(Vec2d(x, y))

  /**
   * Returns the distance between this vector and the one with the given components.
   *
   * Using `a.distanceTo(b)` is equivalent to using `(b - a).length`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @return The distance between this vector and the one with the given components
   */
  def distanceTo(x: Double, y: Double): Double = this.distanceTo(Vec2d(x, y))

  /**
   * Returns this vector reflected from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(x: Double, y: Double): Vec2d = this.reflect(Vec2d(x, y))

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(x: Double, y: Double): Vec2d = this.bounce(Vec2d(x, y))

  /**
   * Returns this vector projected onto the one with the given components.
   *
   * @param x X component of the vector to project onto
   * @param y Y component of the vector to project onto
   * @return This vector projected onto the one with the given components
   */
  def project(x: Double, y: Double): Vec2d = this.project(Vec2d(x, y))

  /**
   * Returns this vector slid along a plane defined by the normal with the given components.
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(x: Double, y: Double): Vec2d = this.slide(Vec2d(x, y))

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
