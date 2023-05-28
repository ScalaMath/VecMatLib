package io.github.hexagonnico.vecmatlib.vector

import io.github.hexagonnico.vecmatlib.{Float2, Float3}

/**
 * Class that represents a three-dimensional float vector.
 *
 * @constructor Constructs a Vec3f from the three given values
 * @param x X component of the vector
 * @param y Y component of the vector
 * @param z Z component of the vector
 */
case class Vec3f(x: Float, y: Float, z: Float) extends VecFloat[Vec3f] with Float3 {

  /**
   * Constructs a Vec3d from the given xy tuple and z component.
   *
   * @param xy X and Y components of the vector
   * @param z  Y component of the vector
   */
  def this(xy: Float2, z: Float) = this(xy.x, xy.y, z)

  /**
   * Constructs a Vec3d from the given x component and yz tuple.
   *
   * @param x  X component of the vector
   * @param yz Y and Z components of the vector
   */
  def this(x: Float, yz: Float2) = this(x, yz.x, yz.y)

  /**
   * Returns a 2d vector with the x and y components of this vector.
   *
   * @return A 2d vector with the x and y components of this vector
   */
  def xy: Vec2f = Vec2f(this.x, this.y)

  /**
   * Returns a 2d vector with the y and z components of this vector.
   *
   * @return A 2d vector with the y and z components of this vector
   */
  def yz: Vec2f = Vec2f(this.y, this.z)

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @param z Z component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def +(x: Float, y: Float, z: Float): Vec3f = Vec3f(this.x + x, this.y + y, this.z + z)

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @param z Z component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def plus(x: Float, y: Float, z: Float): Vec3f = this + (x, y, z)

  /**
   * Returns the sum between this vector and the given one.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  override def +(v: Vec3f): Vec3f = this + (v.x, v.y, v.z)

  /**
   * Returns the additive inverse of this vector.
   *
   * @return The additive inverse of this vector
   */
  override def unary_- : Vec3f = Vec3f(-this.x, -this.y, -this.z)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def -(x: Float, y: Float, z: Float): Vec3f = this + (-x, -y, -z)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def minus(x: Float, y: Float, z: Float): Vec3f = this - (x, y, z)

  /**
   * Returns the product between this vector and the given scalar.
   *
   * @param k The scalar to which the vector is multiplied.
   * @return The result of the product between this vector and the given scalar.
   */
  override def *(k: Float): Vec3f = this * (k, k, k)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def *(x: Float, y: Float, z: Float): Vec3f = Vec3f(this.x * x, this.y * y, this.z * z)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def multiply(x: Float, y: Float, z: Float): Vec3f = this * (x, y, z)

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  override def *(v: Vec3f): Vec3f = this * (v.x, v.y, v.z)

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @param z Z component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Float, y: Float, z: Float): Float = this.x * x + this.y * y + this.z * z

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied.
   * @return The result of the dot product between this vector and the given one.
   */
  override def dot(v: Vec3f): Float = this.dot(v.x, v.y, v.z)

  /**
   * Returns the cross product (or vector product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @param z Z component of the vector by which this one is multiplied
   * @return The cross product between this vector and the one with the given components
   */
  def cross(x: Float, y: Float, z: Float): Vec3f = Vec3f(this.y * z - this.z * y, x * this.z - z * this.x, this.x * y - this.y * x)

  /**
   * Returns the cross product (or vector product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied
   * @return The cross product between this vector and the given one.
   */
  def cross(v: Vec3f): Vec3f = this.cross(v.x, v.y, v.z)

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
   * @param z Z component of the second vector
   * @return The angle in radians between this vector and the one with the given components
   */
  def angle(x: Double, y: Double, z: Double): Double = this.toDouble.angle(Vec3d(x, y, z))

  /**
   * Returns a vector whose components are the multiplicative inverse of this vectors components.
   *
   * @return A vector whose components are the multiplicative inverse of this vectors components
   */
  override def inverse: Vec3f = Vec3f(1.0f / this.x, 1.0f / this.y, 1.0f / this.z)

  /**
   * Returns the component-wise division between this vector and the given scalars.
   *
   * @param x Value by which the X component is divided
   * @param y Value by which the Y component is divided
   * @param z Value by which the Z component is divided
   * @return The component-wise division between this vector and the given scalars.
   */
  def /(x: Float, y: Float, z: Float): Vec3f = Vec3f(this.x / x, this.y / y, this.z / z)

  /**
   * Returns the component-wise division between this vector and the given scalars.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param x Value by which the X component is divided
   * @param y Value by which the Y component is divided
   * @param z Value by which the Z component is divided
   * @return The component-wise division between this vector and the given scalars.
   */
  def divide(x: Float, y: Float, z: Float): Vec3f = this / (x, y, z)

  /**
   * Returns a vector with all components in absolute value.
   *
   * @return This vector with all components in absolute value
   */
  override def abs: Vec3f = Vec3f(math.abs(this.x), math.abs(this.y), math.abs(this.z))

  /**
   * Returns the normalized vector pointing from this vector to the one with the given components.
   *
   * Using `a.directionTo(b)` is equivalent to using `(b - a).normalized`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @param z Z component of the second vector
   * @return The normalized vector pointing from this vector to the given one
   */
  def directionTo(x: Float, y: Float, z: Float): Vec3f = this.directionTo(Vec3f(x, y, z))

  /**
   * Returns the squared distance between this vector and the one with the given components.
   *
   * Using `a.distanceSquaredTo(b)` is equivalent to using `(b - a).lengthSquared`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @param z Z component of the second vector
   * @return The squared distance between this vector and the one with the given components
   */
  def distanceSquaredTo(x: Float, y: Float, z: Float): Float = this.distanceSquaredTo(Vec3f(x, y, z))

  /**
   * Returns the distance between this vector and the one with the given components.
   *
   * Using `a.distanceTo(b)` is equivalent to using `(b - a).length`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @param z Z component of the second vector
   * @return The distance between this vector and the one with the given components
   */
  def distanceTo(x: Float, y: Float, z: Float): Double = this.distanceTo(Vec3f(x, y, z))

  /**
   * Returns this vector reflected from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(x: Float, y: Float, z: Float): Vec3f = this.reflect(Vec3f(x, y, z))

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(x: Float, y: Float, z: Float): Vec3f = this.bounce(Vec3f(x, y, z))

  /**
   * Returns this vector projected onto the one with the given components.
   *
   * @param x X component of the vector to project onto
   * @param y Y component of the vector to project onto
   * @param z Z component of the vector to project onto
   * @return This vector projected onto the one with the given components
   */
  def project(x: Float, y: Float, z: Float): Vec3f = this.project(Vec3f(x, y, z))

  /**
   * Returns this vector slid along a plane defined by the normal with the given components.
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(x: Float, y: Float, z: Float): Vec3f = this.slide(Vec3f(x, y, z))

  /**
   * Casts this vector to an int vector.
   *
   * @return A vector same as this one cast to int
   */
  def toInt: Vec3i = Vec3i(this.x.toInt, this.y.toInt, this.z.toInt)

  /**
   * Converts this vector to a double vector.
   *
   * @return This same vector as a double vector
   */
  def toDouble: Vec3d = Vec3d(this.x.toDouble, this.y.toDouble, this.z.toDouble)

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @param z Z component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def ==(x: Float, y: Float, z: Float): Boolean = this.x == x && this.y == y && this.z == z

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * This method can be used in place of the '==' operator for better interoperability with Java.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @param z Z component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def equals(x: Float, y: Float, z: Float): Boolean = this == (x, y, z)
}

object Vec3f {
  /** Shorthand for `new Vec3f(0.0f, 0.0f, 0.0f)` */
  val Zero: Vec3f = Vec3f(0.0f, 0.0f, 0.0f)
  /** Shorthand for `new Vec3f(1.0f, 1.0f, 1.0f)` */
  val One: Vec3f = Vec3f(1.0f, 1.0f, 1.0f)
  /** Shorthand for `new Vec3f(1.0f, 0.0f, 0.0f)` */
  val Right: Vec3f = Vec3f(1.0f, 0.0f, 0.0f)
  /** Shorthand for `new Vec3f(-1.0f, 0.0f, 0.0f)` */
  val Left: Vec3f = Vec3f(-1.0f, 0.0f, 0.0f)
  /** Shorthand for `new Vec3f(0.0f, 1.0f, 0.0f)` */
  val Up: Vec3f = Vec3f(0.0f, 1.0f, 0.0f)
  /** Shorthand for `new Vec3f(0.0f, -1.0f, 0.0f)` */
  val Down: Vec3f = Vec3f(0.0f, -1.0f, 0.0f)
  /** Shorthand for `new Vec3f(0.0f, 0.0f, 1.0f)` */
  val Forward: Vec3f = Vec3f(0.0f, 0.0f, 1.0f)
  /** Shorthand for `new Vec3f(0.0f, 0.0f, -1.0f)` */
  val Backwards: Vec3f = Vec3f(0.0f, 0.0f, -1.0f)
}
