package io.github.hexagonnico.vecmatlib.vector

import io.github.hexagonnico.vecmatlib.FloatEqualsApprox
import io.github.hexagonnico.vecmatlib.matrix.{Mat3f, Mat3x4f}

/**
 * A 3D vector using floating point coordinates.
 *
 * Can be used to represent 3D coordinates or any other triplet of numeric values.
 *
 * @constructor Constructs a 3D vector from the three given components.
 * @param x The vector's x component.
 * @param y The vector's y component.
 * @param z The vector's z component.
 */
case class Vec3f(x: Float, y: Float, z: Float) {

  /**
   * Constructs a 3D vector from the given components.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   */
  def this(xy: Vec2f, z: Float) = this(xy.x, xy.y, z)

  /**
   * Returns a 2D vector composed of the x and the y components of this vector.
   *
   * @return A 2D vector composed of the x and the y components of this vector.
   */
  def xy: Vec2f = Vec2f(this.x, this.y)

  /**
   * Adds the given values to the components of this vector and returns the result.
   *
   * @param x The x component to add.
   * @param y The y component to add.
   * @param z The z component to add.
   * @return The sum between this vector and the given values.
   */
  def +(x: Float, y: Float, z: Float): Vec3f = Vec3f(this.x + x, this.y + y, this.z + z)

  /**
   * Adds the given values to the components of this vector and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param x The x component to add.
   * @param y The y component to add.
   * @param z The z component to add.
   * @return The sum between this vector and the given values.
   */
  def plus(x: Float, y: Float, z: Float): Vec3f = this + (x, y, z)

  /**
   * Adds the given vector to this one and returns the result.
   *
   * @param v The vector to add.
   * @return The sum between this vector and the given one.
   */
  def +(v: Vec3f): Vec3f = this + (v.x, v.y, v.z)

  /**
   * Adds the given vector to this one and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param v The vector to add.
   * @return The sum between this vector and the given one.
   */
  def plus(v: Vec3f): Vec3f = this + v

  /**
   * Returns this exact vector.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This exact vector.
   */
  def unary_+(): Vec3f = this

  /**
   * Subtracts the given values from each component of this vector and returns the result.
   *
   * @param x The x component to subtract.
   * @param y The y component to subtract.
   * @param z The z component to subtract.
   * @return The subtraction between this vector and the given values.
   */
  def -(x: Float, y: Float, z: Float): Vec3f = Vec3f(this.x - x, this.y - y, this.z - z)

  /**
   * Subtracts the given values from each component of this vector and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param x The x component to subtract.
   * @param y The y component to subtract.
   * @param z The z component to subtract.
   * @return The subtraction between this vector and the given values.
   */
  def minus(x: Float, y: Float, z: Float): Vec3f = this - (x, y, z)

  /**
   * Subtracts the given vector from this one and returns the result.
   *
   * @param v The vector to subtract.
   * @return The subtraction between this vector and the given one.
   */
  def -(v: Vec3f): Vec3f = this - (v.x, v.y, v.z)

  /**
   * Subtracts the given vector from this one and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param v The vector to subtract.
   * @return The subtraction between this vector and the given one.
   */
  def minus(v: Vec3f): Vec3f = this - v

  /**
   * Returns the additive inverse of this vector.
   *
   * @return The additive inverse of this vector.
   */
  def unary_-(): Vec3f = Vec3f(-this.x, -this.y, -this.z)

  /**
   * Returns the additive inverse of this vector.
   *
   * This method can be used in place of the unary `-` operator for better interoperability with Java.
   *
   * @return The additive inverse of this vector.
   */
  def negated: Vec3f = -this

  /**
   * Multiplies each component of this vector by the given values and returns the result.
   *
   * @param x Value to multiply the x component by.
   * @param y Value to multiply the y component by.
   * @param z Value to multiply the z component by.
   * @return The component-wise multiplication between this vector and the given values.
   */
  def *(x: Float, y: Float, z: Float): Vec3f = Vec3f(this.x * x, this.y * y, this.z * z)

  /**
   * Multiplies each component of this vector by the given values and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param x The value to multiply the x component by.
   * @param y The value to multiply the y component by.
   * @param z The value to multiply the z component by.
   * @return The component-wise multiplication between this vector and the given values.
   */
  def multiply(x: Float, y: Float, z: Float): Vec3f = this * (x, y, z)

  /**
   * Multiplies each component of this vector by the components of the given ones and returns the result.
   *
   * @param v The vector to multiply this one by.
   * @return The component-wise multiplication between this vector and the one.
   */
  def *(v: Vec3f): Vec3f = this * (v.x, v.y, v.z)

  /**
   * Multiplies each component of this vector by the components of the given ones and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param v The vector to multiply this one by.
   * @return The component-wise multiplication between this vector and the one.
   */
  def multiply(v: Vec3f): Vec3f = this * v

  /**
   * Multiplies this vector by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this vector by.
   * @return The product between this vector and the given scalar.
   */
  def *(k: Float): Vec3f = this * (k, k, k)

  /**
   * Multiplies this vector by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this vector by.
   * @return The product between this vector and the given scalar.
   */
  def multipliedBy(k: Float): Vec3f = this * k

  /**
   * Divides each component of this vector by the given values and returns the result.
   *
   * @param x The value to divide the x component by.
   * @param y The value to divide the y component by.
   * @param z The value to divide the z component by.
   * @return The component-wise division between this vector and the given values.
   */
  def /(x: Float, y: Float, z: Float): Vec3f = Vec3f(this.x / x, this.y / y, this.z / z)

  /**
   * Divides each component of this vector by the given values and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param x The value to divide the x component by.
   * @param y The value to divide the y component by.
   * @param z The value to divide the z component by.
   * @return The component-wise division between this vector and the given values.
   */
  def divide(x: Float, y: Float, z: Float): Vec3f = this / (x, y, z)

  /**
   * Divides each component of this vector by the components of the given ones and returns the result.
   *
   * @param v The vector to divide this one by.
   * @return The component-wise division between this vector and the one.
   */
  def /(v: Vec3f): Vec3f = this / (v.x, v.y, v.z)

  /**
   * Divides each component of this vector by the components of the given ones and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param v The vector to divide this one by.
   * @return The component-wise division between this vector and the one.
   */
  def divide(v: Vec3f): Vec3f = this / v

  /**
   * Divides this vector by the given scalar and returns the result.
   *
   * @param k The scalar to divide this vector by.
   * @return The division between this vector and the given scalar.
   */
  def /(k: Float): Vec3f = this / (k, k, k)

  /**
   * Divides this vector by the given scalar and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this vector by.
   * @return The division between this vector and the given scalar.
   */
  def dividedBy(k: Float): Vec3f = this / k

  /**
   * Returns the inverse of this vector with respect to component-wise multiplication.
   * For a vector `(x, y, z)`, that is the vector `(1.0 / x, 1.0 / y, 1.0 / z)`.
   *
   * @return The inverse of this vector.
   */
  def inverse: Vec3f = Vec3f(1.0f / this.x, 1.0f / this.y, 1.0f / this.z)

  /**
   * Returns the dot product, or scalar product, between this vector and the given values.
   *
   * @param x The x component of the vector to multiply this one by.
   * @param y The y component of the vector to multiply this one by.
   * @param z The z component of the vector to multiply this one by.
   * @return The dot product between this vector and the given values.
   */
  def dot(x: Float, y: Float, z: Float): Float = this.x * x + this.y * y + this.z * z

  /**
   * Returns the dot product, or scalar product, between this vector and the given one.
   *
   * @param v The second vector.
   * @return The dot product between this vector and the given one.
   */
  def dot(v: Vec3f): Float = this.dot(v.x, v.y, v.z)

  /**
   * Returns the cross product, or vector product, between this vector and the vector defined by the given components.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The cross product between this vector and the vector defined by the given components.
   */
  def cross(x: Float, y: Float, z: Float): Vec3f = Vec3f(this.y * z - this.z * y, x * this.z - z * this.x, this.x * y - this.y * x)

  /**
   * Returns the cross product, or vector product, between this vector and the given one.
   *
   * @param v The second vector.
   * @return The cross product between this vector and the given one.
   */
  def cross(v: Vec3f): Vec3f = this.cross(v.x, v.y, v.z)

  /**
   * Returns the cross product, or vector product, between this vector and the given one.
   *
   * Since the cross product is only defined in three dimensions, the given vector is considered to be laying on the xy plane, i.e. its z component is considered to be zero.
   *
   * @param v The second vector.
   * @return The cross product between this vector and the given one.
   */
  def cross(v: Vec2f): Vec3f = this.cross(v.x, v.y, 0.0f)

  /**
   * Returns the squared length, or magnitude, or modulus, of this vector.
   *
   * When comparing vectors by their length, it is more efficient to compare them by their squared length, since computing it does not require computing a square root.
   *
   * @return The squared length of this vector.
   * @see [[length]]
   */
  def lengthSquared: Float = this.dot(this)

  /**
   * Returns the length, or magnitude, or modulus, of this vector.
   *
   * @return The length of this vector.
   * @see [[lengthSquared]]
   */
  def length: Float = math.sqrt(this.lengthSquared).toFloat

  /**
   * Returns the result of scaling this vector to unit length.
   * Equivalent to `v / v.length`.
   *
   * The resulting vector has the same direction as this one, but a length of `1.0`.
   *
   * @return The result of scaling this vector to unit length.
   * @see [[isNormalized]]
   */
  def normalized: Vec3f = this / this.length

  /**
   * Checks if this vector is a unit vector by checking if its length is approximately equal to `1.0`.
   *
   * @return True if this vector is a unit vector, otherwise false.
   * @see [[normalized]]
   */
  def isNormalized: Boolean = this.lengthSquared ~= 1.0f

  /**
   * Returns the vector with a maximum length by limiting its length to the given limit.
   *
   * @param limit The maximum length of the resulting vector.
   * @return The vector with a maximum length limited by the given limit.
   */
  def limitLength(limit: Float): Vec3f = {
    val length = this.length
    if(length > 0.0f && limit < length) {
      this / length * limit
    } else {
      this
    }
  }

  /**
   * Returns a vector with all components in absolute value.
   *
   * Not to be confused with the modulus, or [[length]], of a vector.
   *
   * @return A vector with all components in absolute value.
   */
  def abs: Vec3f = Vec3f(this.x.abs, this.y.abs, this.z.abs)

  /**
   * Returns a vector with the signs of the components of this vector.
   *
   * @return A vector with all components representing the sign of this vector.
   */
  def sign: Vec3f = Vec3f(this.x.sign, this.y.sign, this.z.sign)

  /**
   * Returns a vector with all components rounded to the nearest integer.
   *
   * @return A vector with all components rounded to the nearest integer.
   */
  def round: Vec3f = Vec3f(this.x.round, this.y.round, this.z.round)

  /**
   * Returns a vector with all components rounded up.
   *
   * @return A vector with all components rounded up.
   */
  def ceil: Vec3f = Vec3f(this.x.ceil, this.y.ceil, this.z.ceil)

  /**
   * Returns a vector with all components rounded down.
   *
   * @return A vector with all components rounded down.
   */
  def floor: Vec3f = Vec3f(this.x.floor, this.y.floor, this.z.floor)

  /**
   * Returns a vector moved toward the given one by the given delta without going past the final value.
   *
   * @param to The final value of the vector.
   * @param delta The fixed delta by which this vector is moved.
   * @return A vector moved toward the given one by the given delta.
   */
  def moveToward(to: Vec3f, delta: Float): Vec3f = {
    val vd = to - this
    val length = vd.length
    if(length <= delta) {
      to
    } else {
      this + vd / length * delta
    }
  }

  /**
   * Computes the linear interpolation between this vector and the given one by the given weight and returns the result.
   *
   * The given weight must be in the `[0.0, 1.0]` range, representing the amount of interpolation.
   *
   * @param to The second vector.
   * @param weight The weight of the interpolation between `0.0` and `1.0`.
   * @return The result of linearly interpolating between this vector and the given one.
   */
  def lerp(to: Vec3f, weight: Float): Vec3f = this + (to - this) * weight

  /**
   * Computes the spherical linear interpolation between this vector and the given one by the given weight and returns the result.
   *
   * The given weight must be in the `[0.0, 1.0]` range, representing the amount of interpolation.
   *
   * If this vector or the given one are approximately zero, this method behaves like [[lerp]].
   *
   * @param to The second vector.
   * @param weight The weight of the interpolation between `0.0` and `1.0`.
   * @return The result of the spherical linear interpolation between this vector and the given one by the given weight.
   */
  def slerp(to: Vec3f, weight: Float): Vec3f = {
    if((this.lengthSquared ~= 0.0f) || (to.lengthSquared ~= 0.0f)) {
      this.lerp(to, weight)
    } else {
      this.rotated(this.cross(to).normalized, this.angleTo(to) * weight) * (to.length / this.length)
    }
  }

  /**
   * Computes the normalized vector pointing from this one to the given one and returns the result.
   *
   * This method is equivalent to `(b - a).normalized`.
   *
   * @param v The second vector.
   * @return The normalized vector pointing from this one to the given one.
   */
  def directionTo(v: Vec3f): Vec3f = (v - this).normalized

  /**
   * Computes the normalized vector pointing from this one to the one with the given components and returns the result.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The normalized vector pointing from this one to the one with the given components.
   */
  def directionTo(x: Float, y: Float, z: Float): Vec3f = this.directionTo(Vec3f(x, y, z))

  /**
   * Returns the squared distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).lengthSquared`
   *
   * @param v The second vector.
   * @return The squared distance between this vector and the given one.
   * @see [[lengthSquared]]
   */
  def distanceSquaredTo(v: Vec3f): Float = (v - this).lengthSquared

  /**
   * Returns the squared distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).lengthSquared`
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The squared distance between this vector and the one with the given components.
   * @see [[lengthSquared]]
   */
  def distanceSquaredTo(x: Float, y: Float, z: Float): Float = this.distanceSquaredTo(Vec3f(x, y, z))

  /**
   * Returns the distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).length`
   *
   * @param v The second vector.
   * @return The squared between this vector and the given one.
   * @see [[length]]
   */
  def distanceTo(v: Vec3f): Float = (v - this).length

  /**
   * Returns the distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).length`
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The squared between this vector and the one with the given components.
   * @see [[length]]
   */
  def distanceTo(x: Float, y: Float, z: Float): Float = this.distanceTo(Vec3f(x, y, z))

  /**
   * Returns the angle in radians between this vector and the given one.
   *
   * @param v The second vector.
   * @return The angle in radians between this vector and the given one.
   */
  def angleTo(v: Vec3f): Double = math.acos((this dot v) / (this.length * v.length))

  /**
   * Returns the angle in radians between this vector and the one with the given components.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The angle in radians between this vector and the one with the given components.
   */
  def angleTo(x: Float, y: Float, z: Float): Double = this.angleTo(Vec3f(x, y, z))

  /**
   * Returns the signed angle to the given vector in radians.
   *
   * @param to The second vector.
   * @param axis Specifies the sign of the angle.
   * @return The signed angle to the given vector in radians.
   */
  def signedAngleTo(to: Vec3f, axis: Vec3f): Double = {
    val cross = this.cross(to)
    val angle = math.atan2(cross.length, this.dot(to))
    if (cross.dot(axis) < 0) {
      -angle
    } else {
      angle
    }
  }

  /**
   * Projects this vector on the given one and returns the result.
   *
   * @param v The second vector.
   * @return The projection of this vector on the given one.
   */
  def project(v: Vec3f): Vec3f = v * ((this dot v) / v.lengthSquared)

  /**
   * Projects this vector on the one with the given components and returns the result.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The projection of this vector on the one with the given components.
   */
  def project(x: Float, y: Float, z: Float): Vec3f = this.project(Vec3f(x, y, z))

  /**
   * Reflects this vector by the given normal and returns the result.
   *
   * @param n The reflection normal.
   * @return The reflection of this vector by the given normal.
   */
  def reflect(n: Vec3f): Vec3f = this - (n * (this dot n) * 2.0f)

  /**
   * Reflects this vector by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the reflection normal.
   * @param y The y component of the reflection normal.
   * @param z The z component of the reflection normal.
   * @return The reflection of this vector by the normal defined by the given components.
   */
  def reflect(x: Float, y: Float, z: Float): Vec3f = this.reflect(Vec3f(x, y, z))

  /**
   * "Bounces" this vector on a plane defined by the given normal and returns the result.
   *
   * @param n The normal of the plane.
   * @return A vector "bounced off" from a plane defined by the given normal.
   */
  def bounce(n: Vec3f): Vec3f = -this.reflect(n)

  /**
   * "Bounces" this vector on a plane defined by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the plane's normal.
   * @param y The y component of the plane's normal.
   * @param z The z component of the plane's normal.
   * @return A vector "bounced off" from a plane defined by the normal defined by the given components.
   */
  def bounce(x: Float, y: Float, z: Float): Vec3f = this.bounce(Vec3f(x, y, z))

  /**
   * Slides this vector along a plane defined by the given normal and returns the result.
   *
   * @param n The normal of the plane.
   * @return The result of sliding this vector along a plane defined by the given normal.
   */
  def slide(n: Vec3f): Vec3f = this - (n * (this dot n))

  /**
   * Slides this vector along a plane defined by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the plane's normal.
   * @param y The y component of the plane's normal.
   * @param z The z component of the plane's normal.
   * @return The result of sliding this vector along a plane defined by the normal defined by the given components.
   */
  def slide(x: Float, y: Float, z: Float): Vec3f = this.slide(Vec3f(x, y, z))

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the given values.
   *
   * @param x The x component.
   * @param y The y component.
   * @param z The z component.
   * @return A vector composed by the reminder of the division between this vector's components and the given values.
   */
  def %(x: Float, y: Float, z: Float): Vec3f = Vec3f(this.x % x, this.y % y, this.z % z)

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the given values.
   *
   * This method can be used in place of the `%` operator for better interoperability with Java.
   *
   * @param x The x component.
   * @param y The y component.
   * @param z The z component.
   * @return A vector composed by the reminder of the division between this vector's components and the given values.
   */
  def mod(x: Float, y: Float, z: Float): Vec3f = this % (x, y, z)

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the components of the given vector.
   *
   * @param v The second vector.
   * @return A vector composed by the reminder of the division between this vector's components and the components of the given vector.
   */
  def %(v: Vec3f): Vec3f = this % (v.x, v.y, v.z)

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the components of the given vector.
   *
   * This method can be used in place of the `%` operator for better interoperability with Java.
   *
   * @param v The second vector.
   * @return A vector composed by the reminder of the division between this vector's components and the components of the given vector.
   */
  def mod(v: Vec3f): Vec3f = this % v

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the given scalar.
   *
   * @param k The scalar.
   * @return A vector composed by the reminder of the division between this vector's components and the given scalar.
   */
  def %(k: Float): Vec3f = this % (k, k, k)

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the given scalar.
   *
   * This method can be used in place of the `%` operator for better interoperability with Java.
   *
   * @param k The scalar.
   * @return A vector composed by the reminder of the division between this vector's components and the given scalar.
   */
  def mod(k: Float): Vec3f = this % k

  /**
   * Rotates this vector around the given axis by the given angle and returns the result.
   * The given axis must be [[normalized]].
   *
   * @param axis The rotation axis.
   * @param angle The rotation angle in radians.
   * @return The result of rotating this vector around the given axis by the given angle.
   */
  def rotated(axis: Vec3f, angle: Double): Vec3f = Mat3f.rotation(axis, angle) * this

  /**
   * Returns the outer product between this vector and the given one.
   *
   * @param v The second vector.
   * @return The outer product between this vector and the given one.
   */
  def outer(v: Vec3f): Mat3f = Mat3f(
    this.x * v.x, this.x * v.y, this.x * v.z,
    this.y * v.x, this.y * v.y, this.y * v.z,
    this.z * v.x, this.z * v.y, this.z * v.z
  )

  /**
   * Returns the outer product between this vector and the given one.
   *
   * @param v The second vector.
   * @return The outer product between this vector and the given one.
   */
  def outer(v: Vec4f): Mat3x4f = Mat3x4f(
    this.x * v.x, this.x * v.y, this.x * v.z, this.x * v.w,
    this.y * v.x, this.y * v.y, this.y * v.z, this.y * v.w,
    this.z * v.x, this.z * v.y, this.z * v.z, this.z * v.w
  )

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x The x component.
   * @param y The y component.
   * @param z The z component.
   * @return True if the components of this vector are equal to the given ones, otherwise false.
   */
  def ==(x: Float, y: Float, z: Float): Boolean = this.x == x && this.y == y && this.z == z

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * This method can be used in place of the `==` operator for better interoperability with Java.
   *
   * @param x The x component.
   * @param y The y component.
   * @param z The z component.
   * @return True if the components of this vector are equal to the given ones, otherwise false.
   */
  def equals(x: Float, y: Float, z: Float): Boolean = this == (x, y, z)

  /**
   * Checks if the components of this vector are approximately equal to the given ones using an internal epsilon.
   *
   * @param x The x component.
   * @param y The y component.
   * @param z The z component.
   * @return True if the components of this vector are approximately equal to the given ones, otherwise false.
   */
  def ~=(x: Float, y: Float, z: Float): Boolean = (this.x ~= x) && (this.y ~= y) && (this.z ~= z)

  /**
   * Checks if the components of this vector are approximately equal to the given ones using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator for better interoperability with Java.
   *
   * @param x The x component.
   * @param y The y component.
   * @param z The z component.
   * @return True if the components of this vector are approximately equal to the given ones, otherwise false.
   */
  def equalsApprox(x: Float, y: Float, z: Float): Boolean = this ~= (x, y, z)

  /**
   * Checks if this vector is approximately equal to the given one using an internal epsilon.
   *
   * @param v The second vector.
   * @return True if this vector is approximately equal to the given one, otherwise false.
   */
  def ~=(v: Vec3f): Boolean = this ~= (v.x, v.y, v.z)

  /**
   * Checks if this vector is approximately equal to the given one using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator for better interoperability with Java.
   *
   * @param v The second vector.
   * @return True if this vector is approximately equal to the given one, otherwise false.
   */
  def equalsApprox(v: Vec3f): Boolean = this ~= v

  /**
   * Returns the component of this vector at the given index.
   * `0` for `x`, `1` for `y`, `2` for `z`.
   *
   * @param i The index of the requested component. Must be either 0, 1, or 2.
   * @return The component of this vector at the given index.
   * @throws scala.MatchError If the given index is out of bounds.
   */
  def apply(i: Int): Float = i match {
    case 0 => this.x
    case 1 => this.y
    case 2 => this.z
  }

  /**
   * Casts this vector to an int vector.
   *
   * @return This vector cast to int.
   */
  def toInt: Vec3i = Vec3i(this.x.toInt, this.y.toInt, this.z.toInt)

  /**
   * Returns this vector as a double vector.
   *
   * @return This vector as a double vector.
   */
  def toDouble: Vec3d = Vec3d(this.x, this.y, this.z)
}

/**
 * Constants, factory methods, and implicits for vectors.
 */
object Vec3f {

  /** Shorthand for `Vec3f(0.0f, 0.0f, 0.0f)` */
  val Zero: Vec3f = Vec3f(0.0f, 0.0f, 0.0f)
  /** Shorthand for `Vec3f(1.0f, 1.0f, 1.0f)` */
  val One: Vec3f = Vec3f(1.0f, 1.0f, 1.0f)
  /** Shorthand for `Vec3f(1.0f, 0.0f, 0.0f)` */
  val Right: Vec3f = Vec3f(1.0f, 0.0f, 0.0f)
  /** Shorthand for `Vec3f(-1.0f, 0.0f, 0.0f)` */
  val Left: Vec3f = Vec3f(-1.0f, 0.0f, 0.0f)
  /** Shorthand for `Vec3f(0.0f, 1.0f, 0.0f)` */
  val Up: Vec3f = Vec3f(0.0f, 1.0f, 0.0f)
  /** Shorthand for `Vec3f(0.0f, -1.0f, 0.0f)` */
  val Down: Vec3f = Vec3f(0.0f, -1.0f, 0.0f)
  /** Shorthand for `Vec3f(0.0f, 0.0f, 1.0f` */
  val Forward: Vec3f = Vec3f(0.0f, 0.0f, 1.0f)
  /** Shorthand for `Vec3f(0.0, 0.0f, -1.0f)` */
  val Backwards: Vec3f = Vec3f(0.0f, 0.0f, -1.0f)

  /**
   * Constructs a 3D vector from the given components.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   * @return A 3D vector constructed from the given components.
   */
  def apply(xy: Vec2f, z: Float) = new Vec3f(xy, z)

  /**
   * Allows to use the `*` and `/` operators with a scalar as `1.0f * vector`.
   *
   * @param self The scalar value.
   */
  implicit class MultiplicationExtender(val self: Float) extends AnyVal {

    /**
     * Multiplies the given vector by this scalar and returns the result.
     *
     * @param v The vector to multiply.
     * @return The product between this scalar and the given vector.
     */
    def *(v: Vec3f): Vec3f = v * self

    /**
     * Multiplies the [[Vec3f.inverse]] of the given vector by this scalar and returns the result.
     *
     * @param v The vector to multiply.
     * @return The product between this scalar and the inverse of the given vector.
     */
    def /(v: Vec3f): Vec3f = self * v.inverse
  }

  /**
   * Implicit conversion from [[Vec3f]] to [[Vec3d]].
   */
  implicit val vec3fToVec3d: Vec3f => Vec3d = v => v.toDouble
}
