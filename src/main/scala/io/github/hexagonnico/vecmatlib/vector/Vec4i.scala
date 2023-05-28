package io.github.hexagonnico.vecmatlib.vector

import io.github.hexagonnico.vecmatlib.{Int2, Int3, Int4}

/**
 * Class that represents a four-dimensional int vector.
 *
 * @constructor Constructs a Vec4i from the four given values
 * @param x X component of the vector
 * @param y Y component of the vector
 * @param z Z component of the vector
 * @param w W component of the vector
 */
case class Vec4i(x: Int, y: Int, z: Int, w: Int) extends VecInt[Vec4i] with Int4 {

  /**
   * Constructs a Vec4i from the given components.
   *
   * @param xy X and Y components of the vector
   * @param z  Z component of the vector
   * @param w  W component of the vector
   */
  def this(xy: Int2, z: Int, w: Int) = this(xy.x, xy.y, z, w)

  /**
   * Constructs a Vec4i from the given components.
   *
   * @param x  X component of the vector
   * @param yz Y and Z components of the vector
   * @param w  W component of the vector
   */
  def this(x: Int, yz: Int2, w: Int) = this(x, yz.x, yz.y, w)

  /**
   * Constructs a Vec4i from the given components.
   *
   * @param x  X component of the vector
   * @param y  Y component of the vector
   * @param zw Z and W components of the vector
   */
  def this(x: Int, y: Int, zw: Int2) = this(x, y, zw.x, zw.y)

  /**
   * Constructs a Vec4i from the given components.
   *
   * @param xyz X, Y, and Z components of the vector
   * @param w   W component of the vector
   */
  def this(xyz: Int3, w: Int) = this(xyz.x, xyz.y, xyz.z, w)

  /**
   * Constructs a Vec4i from the given components.
   *
   * @param x   X component of the vector
   * @param yzw Y, Z, and W components of the vector
   */
  def this(x: Int, yzw: Int3) = this(x, yzw.x, yzw.y, yzw.z)

  /**
   * Returns a 2d vector with the x and y components of this vector.
   *
   * @return A 2d vector with the x and y components of this vector
   */
  def xy: Vec2d = Vec2d(this.x, this.y)

  /**
   * Returns a 2d vector with the y and z components of this vector.
   *
   * @return A 2d vector with the y and z components of this vector
   */
  def yz: Vec2d = Vec2d(this.y, this.z)

  /**
   * Returns a 2d vector with the z and w components of this vector.
   *
   * @return A 2d vector with the z and w components of this vector
   */
  def zw: Vec2d = Vec2d(this.z, this.w)

  /**
   * Returns a 3d vector with the x, y, and z components of this vector.
   *
   * @return A 3d vector with the x, y, and z components of this vector
   */
  def xyz: Vec3d = Vec3d(this.x, this.y, this.z)

  /**
   * Returns a 3d vector with the y, z, and w components of this vector.
   *
   * @return A 3d vector with the y, z, and w components of this vector
   */
  def yzw: Vec3d = Vec3d(this.y, this.z, this.w)

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @param z Z component of the vector to add
   * @param w W component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def +(x: Int, y: Int, z: Int, w: Int): Vec4i = Vec4i(this.x + x, this.y + y, this.z + z, this.w + w)

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @param z Z component of the vector to add
   * @param w W component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def plus(x: Int, y: Int, z: Int, w: Int): Vec4i = this + (x, y, z, w)

  /**
   * Returns the sum between this vector and the given one.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  override def +(v: Vec4i): Vec4i = this + (v.x, v.y, v.z, v.w)

  /**
   * Returns the additive inverse of this vector.
   *
   * @return The additive inverse of this vector
   */
  override def unary_- : Vec4i = Vec4i(-this.x, -this.y, -this.z, -this.w)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @param w W component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def -(x: Int, y: Int, z: Int, w: Int): Vec4i = this + (-x, -y, -z, -w)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @param w W component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def minus(x: Int, y: Int, z: Int, w: Int): Vec4i = this - (x, y, z, w)

  /**
   * Returns the product between this vector and the given scalar.
   *
   * @param k The scalar to which the vector is multiplied.
   * @return The result of the product between this vector and the given scalar.
   */
  override def *(k: Int): Vec4i = this * (k, k, k, k)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @param w Value by which the W component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def *(x: Int, y: Int, z: Int, w: Int): Vec4i = Vec4i(this.x * x, this.y * y, this.z * z, this.w * w)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @param w Value by which the W component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def multiply(x: Int, y: Int, z: Int, w: Int): Vec4i = this * (x, y, z, w)

  /**
   * Returns the division of this vector by the given scalar.
   *
   * @param k The scalar by which the vector is divided.
   * @return The result of the division of this vector by the given scalar.
   */
  override def /(k: Int): Vec4i = Vec4i(this.x / k, this.y / k, this.z / k, this.w / k)

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  override def *(v: Vec4i): Vec4i = this * (v.x, v.y, v.z, v.w)

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @param z Z component of the vector by which this one is multiplied
   * @param w W component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Int, y: Int, z: Int, w: Int): Int = this.x * x + this.y * y + this.z * z + this.w * w

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied.
   * @return The result of the dot product between this vector and the given one.
   */
  override def dot(v: Vec4i): Int = this.dot(v.x, v.y, v.z, v.w)

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
   * @param w W component of the second vector
   * @return The angle in radians between this vector and the one with the given components
   */
  def angle(x: Double, y: Double, z: Double, w: Double): Double = this.toDouble.angle(Vec4d(x, y, z, w))

  /**
   * Returns a vector with all components in absolute value.
   *
   * @return This vector with all components in absolute value
   */
  override def abs: Vec4i = Vec4i(math.abs(this.x), math.abs(this.y), math.abs(this.z), math.abs(this.w))

  /**
   * Returns the squared distance between this vector and the one with the given components.
   *
   * Using `a.distanceSquaredTo(b)` is equivalent to using `(b - a).lengthSquared`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @param z Z component of the second vector
   * @param w W component of the second vector
   * @return The squared distance between this vector and the one with the given components
   */
  def distanceSquaredTo(x: Int, y: Int, z: Int, w: Int): Int = this.distanceSquaredTo(Vec4i(x, y, z, w))

  /**
   * Returns the distance between this vector and the one with the given components.
   *
   * Using `a.distanceTo(b)` is equivalent to using `(b - a).length`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @param z Z component of the second vector
   * @param w W component of the second vector
   * @return The distance between this vector and the one with the given components
   */
  def distanceTo(x: Int, y: Int, z: Int, w: Int): Double = this.distanceTo(Vec4i(x, y, z, w))

  /**
   * Returns this vector reflected from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @param w W component of the normal
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(x: Int, y: Int, z: Int, w: Int): Vec4i = this.reflect(Vec4i(x, y, z, w))

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @param w W component of the normal
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(x: Int, y: Int, z: Int, w: Int): Vec4i = this.bounce(Vec4i(x, y, z, w))

  /**
   * Returns this vector projected onto the one with the given components.
   *
   * @param x X component of the vector to project onto
   * @param y Y component of the vector to project onto
   * @param z Z component of the vector to project onto
   * @param w W component of the vector to project onto
   * @return This vector projected onto the one with the given components
   */
  def project(x: Int, y: Int, z: Int, w: Int): Vec4i = this.project(Vec4i(x, y, z, w))

  /**
   * Returns this vector slid along a plane defined by the normal with the given components.
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @param w W component of the normal
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(x: Int, y: Int, z: Int, w: Int): Vec4i = this.slide(Vec4i(x, y, z, w))

  /**
   * Converts this vector to a float vector.
   *
   * @return This same vector as a float vector
   */
  def toFloat: Vec4f = Vec4f(this.x.toFloat, this.y.toFloat, this.z.toFloat, this.w.toFloat)

  /**
   * Converts this vector to a double vector.
   *
   * @return This same vector as a double vector
   */
  def toDouble: Vec4d = Vec4d(this.x.toDouble, this.y.toDouble, this.z.toDouble, this.w.toDouble)

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @param z Z component of the vector
   * @param w W component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def ==(x: Int, y: Int, z: Int, w: Int): Boolean = this.x == x && this.y == y && this.z == z

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * This method can be used in place of the '==' operator for better interoperability with Java.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @param z Z component of the vector
   * @param w W component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def equals(x: Int, y: Int, z: Int, w: Int): Boolean = this == (x, y, z, w)
}

object Vec4i {
  /** Shorthand for `new Vec4i(0, 0, 0, 0)` */
  val Zero: Vec4i = Vec4i(0, 0, 0, 0)
  /** Shorthand for `new Vec4i(1, 1, 1, 1)` */
  val One: Vec4i = Vec4i(1, 1, 1, 1)
}
