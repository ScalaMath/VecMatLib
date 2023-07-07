package io.github.hexagonnico.vecmatlib.vector

import io.github.hexagonnico.vecmatlib.{Float2, Float3, Float4}

/**
 * Class that represents a four-dimensional float vector.
 *
 * @constructor Constructs a Vec4f from the four given values
 * @param x X component of the vector
 * @param y Y component of the vector
 * @param z Z component of the vector
 * @param w W component of the vector
 */
case class Vec4f(x: Float, y: Float, z: Float, w: Float) extends VecFloat[Vec4f] with Float4 {

  /**
   * Constructs a Vec4f from the given components.
   *
   * @param xy X and Y components of the vector
   * @param z Z component of the vector
   * @param w W component of the vector
   */
  def this(xy: Float2, z: Float, w: Float) = this(xy.x, xy.y, z, w)

  /**
   * Constructs a Vec4f from the given components.
   *
   * @param x X component of the vector
   * @param yz Y and Z components of the vector
   * @param w W component of the vector
   */
  def this(x: Float, yz: Float2, w: Float) = this(x, yz.x, yz.y, w)

  /**
   * Constructs a Vec4f from the given components.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @param zw Z and W components of the vector
   */
  def this(x: Float, y: Float, zw: Float2) = this(x, y, zw.x, zw.y)

  /**
   * Constructs a Vec4f from the given components.
   *
   * @param xyz X, Y, and Z components of the vector
   * @param w W component of the vector
   */
  def this(xyz: Float3, w: Float) = this(xyz.x, xyz.y, xyz.z, w)

  /**
   * Constructs a Vec4f from the given components.
   *
   * @param x X component of the vector
   * @param yzw Y, Z, and W components of the vector
   */
  def this(x: Float, yzw: Float3) = this(x, yzw.x, yzw.y, yzw.z)

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
   * Returns a 2d vector with the z and w components of this vector.
   *
   * @return A 2d vector with the z and w components of this vector
   */
  def zw: Vec2f = Vec2f(this.z, this.w)

  /**
   * Returns a 3d vector with the x, y, and z components of this vector.
   *
   * @return A 3d vector with the x, y, and z components of this vector
   */
  def xyz: Vec3f = Vec3f(this.x, this.y, this.z)

  /**
   * Returns a 3d vector with the y, z, and w components of this vector.
   *
   * @return A 3d vector with the y, z, and w components of this vector
   */
  def yzw: Vec3f = Vec3f(this.y, this.z, this.w)

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @param z Z component of the vector to add
   * @param w W component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def +(x: Float, y: Float, z: Float, w: Float): Vec4f = Vec4f(this.x + x, this.y + y, this.z + z, this.w + w)

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
  def plus(x: Float, y: Float, z: Float, w: Float): Vec4f = this + (x, y, z, w)

  /**
   * Returns the sum between this vector and the given one.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  override def +(v: Vec4f): Vec4f = this + (v.x, v.y, v.z, v.w)

  /**
   * Returns the additive inverse of this vector.
   *
   * @return The additive inverse of this vector
   */
  override def unary_- : Vec4f = Vec4f(-this.x, -this.y, -this.z, -this.w)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @param w W component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def -(x: Float, y: Float, z: Float, w: Float): Vec4f = this + (-x, -y, -z, -w)

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
  def minus(x: Float, y: Float, z: Float, w: Float): Vec4f = this - (x, y, z, w)

  /**
   * Returns the product between this vector and the given scalar.
   *
   * @param k The scalar by which this vector is multiplied
   * @return The result of the product between this vector and the given scalar.
   */
  override def *(k: Float): Vec4f = this * (k, k, k, k)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @param w Value by which the W component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def *(x: Float, y: Float, z: Float, w: Float): Vec4f = Vec4f(this.x * x, this.y * y, this.z * z, this.w * w)

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
  def multiply(x: Float, y: Float, z: Float, w: Float): Vec4f = this * (x, y, z, w)

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  override def *(v: Vec4f): Vec4f = this * (v.x, v.y, v.z, v.w)

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @param z Z component of the vector by which this one is multiplied
   * @param w W component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Float, y: Float, z: Float, w: Float): Float = this.x * x + this.y * y + this.z * z + this.w * w

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied.
   * @return The result of the dot product between this vector and the given one.
   */
  override def dot(v: Vec4f): Float = this.dot(v.x, v.y, v.z, v.w)

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
   * @param w W component of the second vector
   * @return The angle in radians between this vector and the one with the given components
   */
  def angle(x: Double, y: Double, z: Double, w: Double): Double = this.toDouble.angle(Vec4d(x, y, z, w))

  /**
   * Returns a vector whose components are the multiplicative inverse of this vectors components.
   *
   * @return A vector whose components are the multiplicative inverse of this vectors components
   */
  override def inverse: Vec4f = Vec4f(1.0f / this.x, 1.0f / this.y, 1.0f / this.z, 1.0f / this.w)

  /**
   * Returns the component-wise division between this vector and the given scalars.
   *
   * @param x Value by which the X component is divided
   * @param y Value by which the Y component is divided
   * @param z Value by which the Z component is divided
   * @param w Value by which the W component is divided
   * @return The component-wise division between this vector and the given scalars.
   */
  def /(x: Float, y: Float, z: Float, w: Float): Vec4f = Vec4f(this.x / x, this.y / y, this.z / z, this.w / w)

  /**
   * Returns the component-wise division between this vector and the given scalars.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param x Value by which the X component is divided
   * @param y Value by which the Y component is divided
   * @param z Value by which the Z component is divided
   * @param w Value by which the W component is divided
   * @return The component-wise division between this vector and the given scalars.
   */
  def divide(x: Float, y: Float, z: Float, w: Float): Vec4f = this / (x, y, z, w)

  /**
   * Returns a vector with all components in absolute value.
   *
   * @return This vector with all components in absolute value
   */
  override def abs: Vec4f = Vec4f(math.abs(this.x), math.abs(this.y), math.abs(this.z), math.abs(this.w))

  /**
   * Returns the normalized vector pointing from this vector to the one with the given components.
   *
   * Using `a.directionTo(b)` is equivalent to using `(b - a).normalized`.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @param z Z component of the second vector
   * @param w W component of the second vector
   * @return The normalized vector pointing from this vector to the given one
   */
  def directionTo(x: Float, y: Float, z: Float, w: Float): Vec4f = this.directionTo(Vec4f(x, y, z, w))

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
  def distanceSquaredTo(x: Float, y: Float, z: Float, w: Float): Float = this.distanceSquaredTo(Vec4f(x, y, z, w))

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
  def distanceTo(x: Float, y: Float, z: Float, w: Float): Double = this.distanceTo(Vec4f(x, y, z, w))

  /**
   * Returns this vector reflected from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @param w W component of the normal
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(x: Float, y: Float, z: Float, w: Float): Vec4f = this.reflect(Vec4f(x, y, z, w))

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @param w W component of the normal
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(x: Float, y: Float, z: Float, w: Float): Vec4f = this.bounce(Vec4f(x, y, z, w))

  /**
   * Returns this vector projected onto the one with the given components.
   *
   * @param x X component of the vector to project onto
   * @param y Y component of the vector to project onto
   * @param z Z component of the vector to project onto
   * @param w W component of the vector to project onto
   * @return This vector projected onto the one with the given components
   */
  def project(x: Float, y: Float, z: Float, w: Float): Vec4f = this.project(Vec4f(x, y, z, w))

  /**
   * Returns this vector slid along a plane defined by the normal with the given components.
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @param w W component of the normal
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(x: Float, y: Float, z: Float, w: Float): Vec4f = this.slide(Vec4f(x, y, z, w))

  /**
   * Casts this vector to an int vector.
   *
   * @return A vector same as this one cast to int
   */
  def toInt: Vec4i = Vec4i(this.x.toInt, this.y.toInt, this.z.toInt, this.w.toInt)

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
  def ==(x: Float, y: Float, z: Float, w: Float): Boolean = this.x == x && this.y == y && this.z == z && this.w == w

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
  def equals(x: Float, y: Float, z: Float, w: Float): Boolean = this == (x, y, z, w)
}

object Vec4f {
  /** Shorthand for `new Vec4f(0.0f, 0.0f, 0.0f, 0.0f)` */
  val Zero: Vec4f = Vec4f(0.0f, 0.0f, 0.0f, 0.0f)
  /** Shorthand for `new Vec4f(1.0f, 1.0f, 1.0f, 1.0f)` */
  val One: Vec4f = Vec4f(1.0f, 1.0f, 1.0f, 1.0f)

  /**
   * Constructs a Vec4f from the given components.
   * Allows to use the syntax `Vec4f(xy, z, w)` instead of `new Vec4f(xy, z, w)` in scala.
   *
   * @param xy X and Y components of the vector
   * @param z  Z component of the vector
   * @param w  W component of the vector
   * @return The resulting vector
   */
  def apply(xy: Float2, z: Float, w: Float): Vec4f = new Vec4f(xy, z, w)

  /**
   * Constructs a Vec4f from the given components.
   * Allows to use the syntax `Vec4f(x, yz, w)` instead of `new Vec4f(x, yz, w)` in scala.
   *
   * @param x  X component of the vector
   * @param yz Y and Z components of the vector
   * @param w  W component of the vector
   * @return The resulting vector
   */
  def apply(x: Float, yz: Float2, w: Float): Vec4f = new Vec4f(x, yz, w)

  /**
   * Constructs a Vec4f from the given components.
   * Allows to use the syntax `Vec4f(x, y, zw)` instead of `new Vec4f(x, y, zw)` in scala.
   *
   * @param x  X component of the vector
   * @param y  Y component of the vector
   * @param zw Z and W components of the vector
   * @return The resulting vector
   */
  def apply(x: Float, y: Float, zw: Float2): Vec4f = new Vec4f(x, y, zw)

  /**
   * Constructs a Vec4f from the given components.
   * Allows to use the syntax `Vec4f(xyz, w)` instead of `new Vec4f(xyz, w)` in scala.
   *
   * @param xyz X, Y, and Z components of the vector
   * @param w   W component of the vector
   * @return The resulting vector
   */
  def apply(xyz: Float3, w: Float): Vec4f = new Vec4f(xyz, w)

  /**
   * Constructs a Vec4f from the given components.
   * Allows to use the syntax `Vec4f(x, yzw)` instead of `new Vec4f(x, yzw)` in scala.
   *
   * @param x   X component of the vector
   * @param yzw Y, Z, and W components of the vector
   * @return The resulting vector
   */
  def apply(x: Float, yzw: Float3): Vec4f = new Vec4f(x, yzw)

  /**
   * Allows to use the operator '*' with a scalar as `1.0f * vector`.
   *
   * @param k The scalar to which the vector is multiplied
   */
  implicit class MultiplicationExtender(val k: Float) extends AnyVal {

    /**
     * Returns the product between this scalar and the given vector.
     *
     * @param v The vector to which the scalar is multiplied
     * @return The result of the product between this scalar and the given vector
     */
    def *(v: Vec4f): Vec4f = v * k
  }
}
