package vecmatlib.vector

import vecmatlib.{Double2, Double3, Double4}

/**
 * Class that represents a four-dimensional double vector.
 *
 * @constructor Constructs a Vec4d from the four given values
 * @param x X component of the vector
 * @param y Y component of the vector
 * @param z Z component of the vector
 * @param w W component of the vector
 */
case class Vec4d(x: Double, y: Double, z: Double, w: Double) extends VecDouble[Vec4d] with Double4 {

  /**
   * Constructs a Vec4d from the given components.
   *
   * @param xy X and Y components of the vector
   * @param z  Z component of the vector
   * @param w  W component of the vector
   */
  def this(xy: Double2, z: Double, w: Double) = this(xy.x, xy.y, z, w)

  /**
   * Constructs a Vec4d from the given components.
   *
   * @param x  X component of the vector
   * @param yz Y and Z components of the vector
   * @param w  W component of the vector
   */
  def this(x: Double, yz: Double2, w: Double) = this(x, yz.x, yz.y, w)

  /**
   * Constructs a Vec4d from the given components.
   *
   * @param x  X component of the vector
   * @param y  Y component of the vector
   * @param zw Z and W components of the vector
   */
  def this(x: Double, y: Double, zw: Double2) = this(x, y, zw.x, zw.y)

  /**
   * Constructs a Vec4d from the given components.
   *
   * @param xyz X, Y, and Z components of the vector
   * @param w   W component of the vector
   */
  def this(xyz: Double3, w: Double) = this(xyz.x, xyz.y, xyz.z, w)

  /**
   * Constructs a Vec4d from the given components.
   *
   * @param x   X component of the vector
   * @param yzw Y, Z, and W components of the vector
   */
  def this(x: Double, yzw: Double3) = this(x, yzw.x, yzw.y, yzw.z)

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
  def +(x: Double, y: Double, z: Double, w: Double): Vec4d = Vec4d(this.x + x, this.y + y, this.z + z, this.w + w)

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
  def plus(x: Double, y: Double, z: Double, w: Double): Vec4d = this + (x, y, z, w)

  /**
   * Returns the sum between this vector and the given one.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  override def +(v: Vec4d): Vec4d = this + (v.x, v.y, v.z, v.w)

  /**
   * Returns the additive inverse of this vector.
   *
   * @return The additive inverse of this vector
   */
  override def unary_- : Vec4d = Vec4d(-this.x, -this.y, -this.z, -this.w)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @param w W component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def -(x: Double, y: Double, z: Double, w: Double): Vec4d = this + (-x, -y, -z, -w)

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
  def minus(x: Double, y: Double, z: Double, w: Double): Vec4d = this - (x, y, z, w)

  /**
   * Returns the product between this vector and the given scalar.
   *
   * @param k The scalar to which the vector is multiplied.
   * @return The result of the product between this vector and the given scalar.
   */
  override def *(k: Double): Vec4d = this * (k, k, k, k)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @param w Value by which the W component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def *(x: Double, y: Double, z: Double, w: Double): Vec4d = Vec4d(this.x * x, this.y * y, this.z * z, this.w * w)

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
  def multiply(x: Double, y: Double, z: Double, w: Double): Vec4d = this * (x, y, z, w)

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  override def *(v: Vec4d): Vec4d = this * (v.x, v.y, v.z, v.w)

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @param z Z component of the vector by which this one is multiplied
   * @param w W component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Double, y: Double, z: Double, w: Double): Double = this.x * x + this.y * y + this.z * z + this.w * w

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied.
   * @return The result of the dot product between this vector and the given one.
   */
  override def dot(v: Vec4d): Double = this.dot(v.x, v.y, v.z, v.w)

  /**
   * Returns the squared length (or squared magnitude) of this vector.
   *
   * @return The squared length of this vector.
   */
  override def lengthSquared: Double = this dot this

  /**
   * Returns the angle in radians between this vector and the one with the given components.
   *
   * @param x X component of the second vector
   * @param y Y component of the second vector
   * @param z Z component of the second vector
   * @param w W component of the second vector
   * @return The angle in radians between this vector and the one with the given components
   */
  def angle(x: Double, y: Double, z: Double, w: Double): Double = this.angle(Vec4d(x, y, z, w))

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
  def directionTo(x: Double, y: Double, z: Double, w: Double): Vec4d = this.directionTo(Vec4d(x, y, z, w))

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
  def distanceSquaredTo(x: Double, y: Double, z: Double, w: Double): Double = this.distanceSquaredTo(Vec4d(x, y, z, w))

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
  def distanceTo(x: Double, y: Double, z: Double, w: Double): Double = this.distanceTo(Vec4d(x, y, z, w))

  /**
   * Returns this vector reflected from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @param w W component of the normal
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(x: Double, y: Double, z: Double, w: Double): Vec4d = this.reflect(Vec4d(x, y, z, w))

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @param w W component of the normal
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(x: Double, y: Double, z: Double, w: Double): Vec4d = this.bounce(Vec4d(x, y, z, w))

  /**
   * Returns this vector projected onto the one with the given components.
   *
   * @param x X component of the vector to project onto
   * @param y Y component of the vector to project onto
   * @param z Z component of the vector to project onto
   * @param w W component of the vector to project onto
   * @return This vector projected onto the one with the given components
   */
  def project(x: Double, y: Double, z: Double, w: Double): Vec4d = this.project(Vec4d(x, y, z, w))

  /**
   * Returns this vector slid along a plane defined by the normal with the given components.
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @param w W component of the normal
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(x: Double, y: Double, z: Double, w: Double): Vec4d = this.slide(Vec4d(x, y, z, w))

  /**
   * Casts this vector to an int vector.
   *
   * @return A vector same as this one cast to int
   */
  def toInt: Vec4i = Vec4i(this.x.toInt, this.y.toInt, this.z.toInt, this.w.toInt)

  /**
   * Casts this vector to a float vector.
   *
   * @return A vector same as this one cast to float
   */
  def toFloat: Vec4f = Vec4f(this.x.toFloat, this.y.toFloat, this.z.toFloat, this.w.toFloat)

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @param z Z component of the vector
   * @param w W component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def ==(x: Double, y: Double, z: Double, w: Double): Boolean = this.x == x && this.y == y && this.z == z && this.w == w

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
  def equals(x: Double, y: Double, z: Double, w: Double): Boolean = this == (x, y, z, w)
}

object Vec4d {
  /** Shorthand for `new Vec4d(0.0, 0.0, 0.0, 0.0)` */
  val Zero: Vec4d = Vec4d(0.0, 0.0, 0.0, 0.0)
  /** Shorthand for `new Vec4d(1.0, 1.0, 1.0, 1.0)` */
  val One: Vec4d = Vec4d(1.0, 1.0, 1.0, 1.0)
}
