package io.github.hexagonnico.vecmatlib.vector

import io.github.hexagonnico.vecmatlib.{Double2, Double3}

/**
 * Class that represents a three-dimensional double vector.
 *
 * @constructor Constructs a Vec3d from the three given values
 * @param x X component of the vector
 * @param y Y component of the vector
 * @param z Z component of the vector
 */
case class Vec3d(x: Double, y: Double, z: Double) extends VecDouble[Vec3d] with Double3 {

  /**
   * Constructs a Vec3d from the given xy tuple and z component.
   *
   * @param xy X and Y components of the vector
   * @param z  Y component of the vector
   */
  def this(xy: Double2, z: Double) = this(xy.x, xy.y, z)

  /**
   * Constructs a Vec3d from the given x component and yz tuple.
   *
   * @param x  X component of the vector
   * @param yz Y and Z components of the vector
   */
  def this(x: Double, yz: Double2) = this(x, yz.x, yz.y)

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
   * Returns the sum between this vector and the one with the given components.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @param z Z component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def +(x: Double, y: Double, z: Double): Vec3d = Vec3d(this.x + x, this.y + y, this.z + z)

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
  def plus(x: Double, y: Double, z: Double): Vec3d = this + (x, y, z)

  /**
   * Returns the sum between this vector and the given one.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  override def +(v: Vec3d): Vec3d = this + (v.x, v.y, v.z)

  /**
   * Returns the additive inverse of this vector.
   *
   * @return The additive inverse of this vector
   */
  override def unary_- : Vec3d = Vec3d(-this.x, -this.y, -this.z)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def -(x: Double, y: Double, z: Double): Vec3d = this + (-x, -y, -z)

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
  def minus(x: Double, y: Double, z: Double): Vec3d = this - (x, y, z)

  /**
   * Returns the product between this vector and the given scalar.
   *
   * @param k The scalar to which the vector is multiplied.
   * @return The result of the product between this vector and the given scalar.
   */
  override def *(k: Double): Vec3d = this * (k, k, k)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def *(x: Double, y: Double, z: Double): Vec3d = Vec3d(this.x * x, this.y * y, this.z * z)

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
  def multiply(x: Double, y: Double, z: Double): Vec3d = this * (x, y, z)

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  override def *(v: Vec3d): Vec3d = this * (v.x, v.y, v.z)

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @param z Z component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Double, y: Double, z: Double): Double = this.x * x + this.y * y + this.z * z

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied.
   * @return The result of the dot product between this vector and the given one.
   */
  override def dot(v: Vec3d): Double = this.dot(v.x, v.y, v.z)

  /**
   * Returns the cross product (or vector product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @param z Z component of the vector by which this one is multiplied
   * @return The cross product between this vector and the one with the given components
   */
  def cross(x: Double, y: Double, z: Double): Vec3d = Vec3d(this.y * z - this.z * y, x * this.z - z * this.x, this.x * y - this.y * x)

  /**
   * Returns the cross product (or vector product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied
   * @return The cross product between this vector and the given one.
   */
  def cross(v: Vec3d): Vec3d = this.cross(v.x, v.y, v.z)

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
   * @return The angle in radians between this vector and the one with the given components
   */
  def angle(x: Double, y: Double, z: Double): Double = this.angle(Vec3d(x, y, z))

  /**
   * Returns a vector whose components are the multiplicative inverse of this vectors components.
   *
   * @return A vector whose components are the multiplicative inverse of this vectors components
   */
  override def inverse: Vec3d = Vec3d(1.0 / this.x, 1.0 / this.y, 1.0 / this.z)

  /**
   * Returns the component-wise division between this vector and the given scalars.
   *
   * @param x Value by which the X component is divided
   * @param y Value by which the Y component is divided
   * @param z Value by which the Z component is divided
   * @return The component-wise division between this vector and the given scalars.
   */
  def /(x: Double, y: Double, z: Double): Vec3d = Vec3d(this.x / x, this.y / y, this.z / z)

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
  def divide(x: Double, y: Double, z: Double): Vec3d = this / (x, y, z)

  /**
   * Returns a vector with all components in absolute value.
   *
   * @return This vector with all components in absolute value
   */
  override def abs: Vec3d = Vec3d(math.abs(this.x), math.abs(this.y), math.abs(this.z))

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
  def directionTo(x: Double, y: Double, z: Double): Vec3d = this.directionTo(Vec3d(x, y, z))

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
  def distanceSquaredTo(x: Double, y: Double, z: Double): Double = this.distanceSquaredTo(Vec3d(x, y, z))

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
  def distanceTo(x: Double, y: Double, z: Double): Double = this.distanceTo(Vec3d(x, y, z))

  /**
   * Returns this vector reflected from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @return This vector reflected from a plane defined by the given normal
   */
  def reflect(x: Double, y: Double, z: Double): Vec3d = this.reflect(Vec3d(x, y, z))

  /**
   * Returns this vector "bounced off" from a plane defined by the given normal (must be normalized).
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @return This vector "bounced off" from a plane defined by the given normal
   */
  def bounce(x: Double, y: Double, z: Double): Vec3d = this.bounce(Vec3d(x, y, z))

  /**
   * Returns this vector projected onto the one with the given components.
   *
   * @param x X component of the vector to project onto
   * @param y Y component of the vector to project onto
   * @param z Z component of the vector to project onto
   * @return This vector projected onto the one with the given components
   */
  def project(x: Double, y: Double, z: Double): Vec3d = this.project(Vec3d(x, y, z))

  /**
   * Returns this vector slid along a plane defined by the normal with the given components.
   *
   * @param x X component of the normal
   * @param y Y component of the normal
   * @param z Z component of the normal
   * @return This vector slid along a plane defined by the given normal
   */
  def slide(x: Double, y: Double, z: Double): Vec3d = this.slide(Vec3d(x, y, z))

  /**
   * Casts this vector to an int vector.
   *
   * @return A vector same as this one cast to int
   */
  def toInt: Vec3i = Vec3i(this.x.toInt, this.y.toInt, this.z.toInt)

  /**
   * Casts this vector to a float vector.
   *
   * @return A vector same as this one cast to float
   */
  def toFloat: Vec3f = Vec3f(this.x.toFloat, this.y.toFloat, this.z.toFloat)

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @param z Z component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def ==(x: Double, y: Double, z: Double): Boolean = this.x == x && this.y == y && this.z == z

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
  def equals(x: Double, y: Double, z: Double): Boolean = this == (x, y, z)
}

object Vec3d {
  /** Shorthand for `new Vec3d(0.0, 0.0, 0.0)` */
  val Zero: Vec3d = Vec3d(0.0, 0.0, 0.0)
  /** Shorthand for `new Vec3d(1.0, 1.0, 1.0)` */
  val One: Vec3d = Vec3d(1.0, 1.0, 1.0)
  /** Shorthand for `new Vec3d(1.0, 0.0, 0.0)` */
  val Right: Vec3d = Vec3d(1.0, 0.0, 0.0)
  /** Shorthand for `new Vec3d(-1.0, 0.0, 0.0)` */
  val Left: Vec3d = Vec3d(-1.0, 0.0, 0.0)
  /** Shorthand for `new Vec3d(0.0, 1.0, 0.0)` */
  val Up: Vec3d = Vec3d(0.0, 1.0, 0.0)
  /** Shorthand for `new Vec3d(0.0, -1.0, 0.0)` */
  val Down: Vec3d = Vec3d(0.0, -1.0, 0.0)
  /** Shorthand for `new Vec3d(0.0, 0.0, 1.0)` */
  val Forward: Vec3d = Vec3d(0.0, 0.0, 1.0)
  /** Shorthand for `new Vec3d(0.0, 0.0, -1.0)` */
  val Backwards: Vec3d = Vec3d(0.0, 0.0, -1.0)

  /**
   * Constructs a Vec3d from the given xy tuple and z component.
   * Allows to use the syntax `Vec3d(xy, z)` instead of `new Vec3d(xy, z)` in scala.
   *
   * @param xy X and Y components of the vector
   * @param z  Y component of the vector
   * @return The resulting vector
   */
  def apply(xy: Double2, z: Double): Vec3d = new Vec3d(xy, z)

  /**
   * Constructs a Vec3d from the given x component and yz tuple.
   * Allows to use the syntax `Vec3d(x, yz)` instead of `new Vec3d(x, yz)` in scala.
   *
   * @param x  X component of the vector
   * @param yz Y and Z components of the vector
   * @return The resulting vector
   */
  def apply(x: Double, yz: Double2): Vec3d = new Vec3d(x, yz)

  /**
   * Allows to use the operator '*' with a scalar as `1.0 * vector`.
   *
   * @param k The scalar to which the vector is multiplied
   */
  implicit class MultiplicationExtender(val k: Double) extends AnyVal {

    /**
     * Returns the product between this scalar and the given vector.
     *
     * @param v The vector to which the scalar is multiplied
     * @return The result of the product between this scalar and the given vector
     */
    def *(v: Vec3d): Vec3d = v * k
  }
}
