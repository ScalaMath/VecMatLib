package io.github.hexagonnico.vecmatlib.vector

import io.github.hexagonnico.vecmatlib.{Int2, Int3}

/**
 * Class that represents a three-dimensional int vector.
 *
 * @constructor Constructs a Vec3i from the three given values.
 * @param x X component of the vector
 * @param y Y component of the vector
 * @param z Z component of the vector
 */
case class Vec3i(x: Int, y: Int, z: Int) extends VecInt[Vec3i] with Int3 {

  /**
   * Constructs a Vec3d from the given xy tuple and z component.
   *
   * @param xy X and Y components of the vector
   * @param z  Y component of the vector
   */
  def this(xy: Int2, z: Int) = this(xy.x, xy.y, z)

  /**
   * Constructs a Vec3d from the given x component and yz tuple.
   *
   * @param x  X component of the vector
   * @param yz Y and Z components of the vector
   */
  def this(x: Int, yz: Int2) = this(x, yz.x, yz.y)

  /**
   * Returns a 2d vector with the x and y components of this vector.
   *
   * @return A 2d vector with the x and y components of this vector
   */
  def xy: Vec2i = Vec2i(this.x, this.y)

  /**
   * Returns a 2d vector with the y and z components of this vector.
   *
   * @return A 2d vector with the y and z components of this vector
   */
  def yz: Vec2i = Vec2i(this.y, this.z)

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @param z Z component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def +(x: Int, y: Int, z: Int): Vec3i = Vec3i(this.x + x, this.y + y, this.z + z)

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
  def plus(x: Int, y: Int, z: Int): Vec3i = this + (x, y, z)

  /**
   * Returns the sum between this vector and the given one.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  override def +(v: Vec3i): Vec3i = this + (v.x, v.y, v.z)

  /**
   * Returns the additive inverse of this vector.
   *
   * @return The additive inverse of this vector
   */
  override def unary_- : Vec3i = Vec3i(-this.x, -this.y, -this.z)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def -(x: Int, y: Int, z: Int): Vec3i = this + (-x, -y, -z)

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
  def minus(x: Int, y: Int, z: Int): Vec3i = this - (x, y, z)

  /**
   * Returns the product between this vector and the given scalar.
   *
   * @param k The scalar to which the vector is multiplied.
   * @return The result of the product between this vector and the given scalar.
   */
  override def *(k: Int): Vec3i = this * (k, k, k)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def *(x: Int, y: Int, z: Int): Vec3i = Vec3i(this.x * x, this.y * y, this.z * z)

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
  def multiply(x: Int, y: Int, z: Int): Vec3i = this * (x, y, z)

  /**
   * Returns the division of this vector by the given scalar.
   *
   * @param k The scalar by which the vector is divided.
   * @return The result of the division of this vector by the given scalar.
   */
  override def /(k: Int): Vec3i = Vec3i(this.x / k, this.y / k, this.z / k)

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  override def *(v: Vec3i): Vec3i = this * (v.x, v.y, v.z)

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @param z Z component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Int, y: Int, z: Int): Int = this.x * x + this.y * y + this.z * z

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied.
   * @return The result of the dot product between this vector and the given one.
   */
  override def dot(v: Vec3i): Int = this.dot(v.x, v.y, v.z)

  /**
   * Returns the cross product (or vector product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @param z Z component of the vector by which this one is multiplied
   * @return The cross product between this vector and the one with the given components
   */
  def cross(x: Int, y: Int, z: Int): Vec3i = Vec3i(this.y * z - this.z * y, x * this.z - z * this.x, this.x * y - this.y * x)

  /**
   * Returns the cross product (or vector product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied
   * @return The cross product between this vector and the given one.
   */
  def cross(v: Vec3i): Vec3i = this.cross(v.x, v.y, v.z)

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
   * @param z Z component of the second vector
   * @return The angle in radians between this vector and the one with the given components
   */
  def angle(x: Double, y: Double, z: Double): Double = this.toDouble.angle(Vec3d(x, y, z))

  /**
   * Returns a vector with all components in absolute value.
   *
   * @return This vector with all components in absolute value
   */
  override def abs: Vec3i = Vec3i(math.abs(this.x), math.abs(this.y), math.abs(this.z))

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
  def distanceSquaredTo(x: Int, y: Int, z: Int): Int = this.distanceSquaredTo(Vec3i(x, y, z))

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
  def distanceTo(x: Int, y: Int, z: Int): Double = this.distanceTo(Vec3i(x, y, z))

  /**
   * Returns this vector reflected from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(x: Int, y: Int, z: Int): Vec3i = this.reflect(Vec3i(x, y, z))

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(x: Int, y: Int, z: Int): Vec3i = this.bounce(Vec3i(x, y, z))

  /**
   * Returns this vector projected onto the one with the given components.
   *
   * @param x X component of the vector to project onto
   * @param y Y component of the vector to project onto
   * @param z Z component of the vector to project onto
   * @return This vector projected onto the one with the given components
   */
  def project(x: Int, y: Int, z: Int): Vec3i = this.project(Vec3i(x, y, z))

  /**
   * Returns this vector slid along a plane defined by the normal with the given components.
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(x: Int, y: Int, z: Int): Vec3i = this.slide(Vec3i(x, y, z))

  /**
   * Converts this vector to a float vector.
   *
   * @return This same vector as a float vector
   */
  def toFloat: Vec3f = Vec3f(this.x.toFloat, this.y.toFloat, this.z.toFloat)

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
  def ==(x: Int, y: Int, z: Int): Boolean = this.x == x && this.y == y && this.z == z

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
  def equals(x: Int, y: Int, z: Int): Boolean = this == (x, y, z)
}

object Vec3i {
  /** Shorthand for `new Vec3i(0, 0, 0)` */
  val Zero: Vec3i = Vec3i(0, 0, 0)
  /** Shorthand for `new Vec3i(1, 1, 1)` */
  val One: Vec3i = Vec3i(1, 1, 1)
  /** Shorthand for `new Vec3i(1, 0, 0)` */
  val Right: Vec3i = Vec3i(1, 0, 0)
  /** Shorthand for `new Vec3i(-1, 0, 0)` */
  val Left: Vec3i = Vec3i(-1, 0, 0)
  /** Shorthand for `new Vec3i(0, 1, 0)` */
  val Up: Vec3i = Vec3i(0, 1, 0)
  /** Shorthand for `new Vec3i(0, -1, 0)` */
  val Down: Vec3i = Vec3i(0, -1, 0)
  /** Shorthand for `new Vec3i(0, 0, 1)` */
  val Forward: Vec3i = Vec3i(0, 0, 1)
  /** Shorthand for `new Vec3i(0, 0, -1)` */
  val Backwards: Vec3i = Vec3i(0, 0, -1)
}
