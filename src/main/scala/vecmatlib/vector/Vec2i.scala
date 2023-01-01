package vecmatlib.vector

import vecmatlib.Int2

/**
 * Two-dimensional int vector.
 *
 * @param x X component of the vector
 * @param y Y component of the vector
 */
case class Vec2i(x: Int, y: Int) extends Int2 with VecInt[Vec2i] with VecAsFloat[Vec2f] with VecAsDouble[Vec2d] {

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

  override def +(v: Vec2i): Vec2i = this + (v.x, v.y)

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

  override def *(k: Int): Vec2i = Vec2i(this.x * k, this.y * k)

  override def /(k: Int): Vec2i = Vec2i(this.x / k, this.y / k)

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

  override def *(v: Vec2i): Vec2i = this * (v.x, v.y)

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
  def dot(x: Int, y: Int): Int = this.x * x + this.y * y

  override def dot(v: Vec2i): Int = this.dot(v.x, v.y)

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Float, y: Float): Float = this.x * x + this.y * y

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Double, y: Double): Double = this.x * x + this.y * y

  override def lengthSquared: Int = this dot this

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
  def distanceSquaredTo(x: Int, y: Int): Int = this.distanceSquaredTo(Vec2i(x, y))

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
  def reflect(x: Int, y: Int): Vec2i = this.reflect(Vec2i(x, y))

  /**
   * Returns this vector reflected from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(x: Float, y: Float): Vec2f = this.reflect(Vec2f(x, y))

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
  def bounce(x: Int, y: Int): Vec2i = this.bounce(Vec2i(x, y))

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(x: Float, y: Float): Vec2f = this.bounce(Vec2f(x, y))

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
  def project(x: Int, y: Int): Vec2i = this.project(Vec2i(x, y))

  /**
   * Returns this vector projected onto the one with the given components.
   *
   * @param x X component of the vector to project onto
   * @param y Y component of the vector to project onto
   * @return This vector projected onto the one with the given components
   */
  def project(x: Float, y: Float): Vec2f = this.project(Vec2f(x, y))

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
  def slide(x: Int, y: Int): Vec2i = this.slide(Vec2i(x, y))

  /**
   * Returns this vector slid along a plane defined by the normal with the given components.
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(x: Float, y: Float): Vec2f = this.slide(Vec2f(x, y))

  /**
   * Returns this vector slid along a plane defined by the normal with the given components.
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(x: Double, y: Double): Vec2d = this.slide(Vec2d(x, y))

  override def toFloat: Vec2f = Vec2f(this.x.toFloat, this.y.toFloat)

  override def toDouble: Vec2d = Vec2d(this.x.toDouble, this.y.toDouble)

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x X component of the vector.
   * @param y Y component of the vector.
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def ==(x: Int, y: Int): Boolean = this.x == x && this.y == y

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * This method can be used in place of the '==' operator for better interoperability with Java.
   *
   * @param x X component of the vector.
   * @param y Y component of the vector.
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
}
