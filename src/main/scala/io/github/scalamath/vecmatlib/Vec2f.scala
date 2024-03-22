package io.github.scalamath.vecmatlib

import io.github.scalamath.FloatEqualsApprox

/**
 * A 2D vector using floating point coordinates.
 *
 * Can be used to represent 2D coordinates or any other tuple of numeric values.
 *
 * @constructor Constructs a 2D vector from the two given components.
 * @param x The vector's x component.
 * @param y The vector's y component.
 */
case class Vec2f(x: Float, y: Float) {

  /**
   * Adds the given values to the components of this vector and returns the result.
   *
   * @param x The x component to add.
   * @param y The y component to add.
   * @return The sum between this vector and the given values.
   */
  def +(x: Float, y: Float): Vec2f = Vec2f(this.x + x, this.y + y)

  /**
   * Adds the given values to the components of this vector and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param x The x component to add.
   * @param y The y component to add.
   * @return The sum between this vector and the given values.
   */
  def plus(x: Float, y: Float): Vec2f = this + (x, y)

  /**
   * Adds the given vector to this one and returns the result.
   *
   * @param v The vector to add.
   * @return The sum between this vector and the given one.
   */
  def +(v: Vec2f): Vec2f = this + (v.x, v.y)

  /**
   * Adds the given vector to this one and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param v The vector to add.
   * @return The sum between this vector and the given one.
   */
  def plus(v: Vec2f): Vec2f = this + v

  /**
   * Returns this exact vector.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This exact vector.
   */
  def unary_+(): Vec2f = this

  /**
   * Subtracts the given values from each component of this vector and returns the result.
   *
   * @param x The x component to subtract.
   * @param y The y component to subtract.
   * @return The subtraction between this vector and the given values.
   */
  def -(x: Float, y: Float): Vec2f = Vec2f(this.x - x, this.y - y)

  /**
   * Subtracts the given values from each component of this vector and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param x The x component to subtract.
   * @param y The y component to subtract.
   * @return The subtraction between this vector and the given values.
   */
  def minus(x: Float, y: Float): Vec2f = this - (x, y)

  /**
   * Subtracts the given vector from this one and returns the result.
   *
   * @param v The vector to subtract.
   * @return The subtraction between this vector and the given one.
   */
  def -(v: Vec2f): Vec2f = this - (v.x, v.y)

  /**
   * Subtracts the given vector from this one and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param v The vector to subtract.
   * @return The subtraction between this vector and the given one.
   */
  def minus(v: Vec2f): Vec2f = this - v

  /**
   * Returns the additive inverse of this vector.
   *
   * @return The additive inverse of this vector.
   */
  def unary_-(): Vec2f = Vec2f(-this.x, -this.y)

  /**
   * Returns the additive inverse of this vector.
   *
   * This method can be used in place of the unary `-` operator for better interoperability with Java.
   *
   * @return The additive inverse of this vector.
   */
  def negated: Vec2f = -this

  /**
   * Multiplies each component of this vector by the given values and returns the result.
   *
   * @param x Value to multiply the x component by.
   * @param y Value to multiply the y component by.
   * @return The component-wise multiplication between this vector and the given values.
   */
  def *(x: Float, y: Float): Vec2f = Vec2f(this.x * x, this.y * y)

  /**
   * Multiplies each component of this vector by the given values and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param x The value to multiply the x component by.
   * @param y The value to multiply the y component by.
   * @return The component-wise multiplication between this vector and the given values.
   */
  def multiply(x: Float, y: Float): Vec2f = this * (x, y)

  /**
   * Multiplies each component of this vector by the components of the given ones and returns the result.
   *
   * @param v The vector to multiply this one by.
   * @return The component-wise multiplication between this vector and the one.
   */
  def *(v: Vec2f): Vec2f = this * (v.x, v.y)

  /**
   * Multiplies each component of this vector by the components of the given ones and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param v The vector to multiply this one by.
   * @return The component-wise multiplication between this vector and the one.
   */
  def multiply(v: Vec2f): Vec2f = this * v

  /**
   * Multiplies this vector by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this vector by.
   * @return The product between this vector and the given scalar.
   */
  def *(k: Float): Vec2f = this * (k, k)

  /**
   * Multiplies this vector by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this vector by.
   * @return The product between this vector and the given scalar.
   */
  def multipliedBy(k: Float): Vec2f = this * k

  /**
   * Divides each component of this vector by the given values and returns the result.
   *
   * @param x The value to divide the x component by.
   * @param y The value to divide the y component by.
   * @return The component-wise division between this vector and the given values.
   */
  def /(x: Float, y: Float): Vec2f = Vec2f(this.x / x, this.y / y)

  /**
   * Divides each component of this vector by the given values and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param x The value to divide the x component by.
   * @param y The value to divide the y component by.
   * @return The component-wise division between this vector and the given values.
   */
  def divide(x: Float, y: Float): Vec2f = this / (x, y)

  /**
   * Divides each component of this vector by the components of the given ones and returns the result.
   *
   * @param v The vector to divide this one by.
   * @return The component-wise division between this vector and the one.
   */
  def /(v: Vec2f): Vec2f = this / (v.x, v.y)

  /**
   * Divides each component of this vector by the components of the given ones and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param v The vector to divide this one by.
   * @return The component-wise division between this vector and the one.
   */
  def divide(v: Vec2f): Vec2f = this / v

  /**
   * Divides this vector by the given scalar and returns the result.
   *
   * @param k The scalar to divide this vector by.
   * @return The division between this vector and the given scalar.
   */
  def /(k: Float): Vec2f = this / (k, k)

  /**
   * Divides this vector by the given scalar and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this vector by.
   * @return The division between this vector and the given scalar.
   */
  def dividedBy(k: Float): Vec2f = this / k

  /**
   * Returns the inverse of this vector with respect to component-wise multiplication.
   * For a vector `(x, y)`, that is the vector `(1.0 / x, 1.0 / y)`.
   *
   * @return The inverse of this vector.
   */
  def inverse: Vec2f = Vec2f(1.0f / this.x, 1.0f / this.y)

  /**
   * Returns the dot product, or scalar product, between this vector and the given values.
   *
   * @param x The x component of the vector to multiply this one by.
   * @param y The y component of the vector to multiply this one by.
   * @return The dot product between this vector and the given values.
   */
  def dot(x: Float, y: Float): Float = this.x * x + this.y * y

  /**
   * Returns the dot product, or scalar product, between this vector and the given one.
   *
   * @param v The second vector.
   * @return The dot product between this vector and the given one.
   */
  def dot(v: Vec2f): Float = this.dot(v.x, v.y)

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
  def normalized: Vec2f = this / this.length

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
  def limitLength(limit: Float): Vec2f = {
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
  def abs: Vec2f = Vec2f(this.x.abs, this.y.abs)

  /**
   * Returns a vector with the signs of the components of this vector.
   *
   * @return A vector with all components representing the sign of this vector.
   */
  def sign: Vec2f = Vec2f(this.x.sign, this.y.sign)

  /**
   * Returns a vector with all components rounded to the nearest integer.
   *
   * @return A vector with all components rounded to the nearest integer.
   */
  def round: Vec2f = Vec2f(this.x.round, this.y.round)

  /**
   * Returns a vector with all components rounded up.
   *
   * @return A vector with all components rounded up.
   */
  def ceil: Vec2f = Vec2f(this.x.ceil, this.y.ceil)

  /**
   * Returns a vector with all components rounded down.
   *
   * @return A vector with all components rounded down.
   */
  def floor: Vec2f = Vec2f(this.x.floor, this.y.floor)

  /**
   * Returns a vector moved toward the given one by the given delta without going past the final value.
   *
   * @param to The final value of the vector.
   * @param delta The fixed delta by which this vector is moved.
   * @return A vector moved toward the given one by the given delta.
   */
  def moveToward(to: Vec2f, delta: Float): Vec2f = {
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
  def lerp(to: Vec2f, weight: Float): Vec2f = this + (to - this) * weight

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
  def slerp(to: Vec2f, weight: Float): Vec2f = {
    if((this.lengthSquared ~= 0.0f) || (to.lengthSquared ~= 0.0f)) {
      this.lerp(to, weight)
    } else {
      this.rotated(this.angleTo(to) * weight) * (to.length / this.length)
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
  def directionTo(v: Vec2f): Vec2f = (v - this).normalized

  /**
   * Computes the normalized vector pointing from this one to the one with the given components and returns the result.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @return The normalized vector pointing from this one to the one with the given components.
   */
  def directionTo(x: Float, y: Float): Vec2f = this.directionTo(Vec2f(x, y))

  /**
   * Returns the squared distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).lengthSquared`.
   *
   * @param v The second vector.
   * @return The squared distance between this vector and the given one.
   * @see [[lengthSquared]]
   */
  def distanceSquaredTo(v: Vec2f): Float = (v - this).lengthSquared

  /**
   * Returns the squared distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).lengthSquared`.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @return The squared distance between this vector and the one with the given components.
   * @see [[lengthSquared]]
   */
  def distanceSquaredTo(x: Float, y: Float): Float = this.distanceSquaredTo(Vec2f(x, y))

  /**
   * Returns the distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).length`.
   *
   * @param v The second vector.
   * @return The squared between this vector and the given one.
   * @see [[length]]
   */
  def distanceTo(v: Vec2f): Float = (v - this).length

  /**
   * Returns the distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).length`.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @return The squared between this vector and the one with the given components.
   * @see [[length]]
   */
  def distanceTo(x: Float, y: Float): Float = this.distanceTo(Vec2f(x, y))

  /**
   * Returns the angle in radians between this vector and the given one.
   *
   * @param v The second vector.
   * @return The angle in radians between this vector and the given one.
   */
  def angleTo(v: Vec2f): Double = math.acos(this.dot(v) / (this.length * v.length))

  /**
   * Returns the angle in radians between this vector and the one with the given components.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @return The angle in radians between this vector and the one with the given components.
   */
  def angleTo(x: Float, y: Float): Double = this.angleTo(Vec2f(x, y))

  /**
   * Returns the angle in radians between this vector and the x axis.
   *
   * @return The angle in radians between this vector and the x axis.
   */
  def angle: Double = math.atan2(this.y, this.x)

  /**
   * Returns the angle in radians between the line connecting the two points represented by this vector and the given one and the X axis.
   *
   * This method is equivalent to `(b - a).angle`.
   *
   * @param v The second point.
   * @return The angle in radians between the line connecting the two points represented by this vector and the given one and the X axis.
   */
  def angleToPoint(v: Vec2f): Double = (v - this).angle

  /**
   * Returns the angle in radians between the line connecting the two points represented by this vector and the given coordinates and the X axis.
   *
   * This method is equivalent to `(b - a).angle`.
   *
   * @param x The x coordinate of the second point.
   * @param y The y coordinate of the second point.
   * @return The angle in radians between the line connecting the two points represented by this vector and the given coordinates and the X axis.
   */
  def angleToPoint(x: Float, y: Float): Double = this.angleToPoint(Vec2f(x, y))

  /**
   * Projects this vector on the given one and returns the result.
   *
   * @param v The second vector.
   * @return The projection of this vector on the given one.
   */
  def project(v: Vec2f): Vec2f = v * (this.dot(v) / v.lengthSquared)

  /**
   * Projects this vector on the one with the given components and returns the result.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @return The projection of this vector on the one with the given components.
   */
  def project(x: Float, y: Float): Vec2f = this.project(Vec2f(x, y))

  /**
   * Reflects this vector by the given normal and returns the result.
   *
   * @param n The reflection normal.
   * @return The reflection of this vector by the given normal.
   */
  def reflect(n: Vec2f): Vec2f = this - (n * (this.dot(n) * 2.0f))

  /**
   * Reflects this vector by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the reflection normal.
   * @param y The y component of the reflection normal.
   * @return The reflection of this vector by the normal defined by the given components.
   */
  def reflect(x: Float, y: Float): Vec2f = this.reflect(Vec2f(x, y))

  /**
   * "Bounces" this vector on a plane defined by the given normal and returns the result.
   *
   * @param n The normal of the plane.
   * @return A vector "bounced off" from a plane defined by the given normal.
   */
  def bounce(n: Vec2f): Vec2f = -this.reflect(n)

  /**
   * "Bounces" this vector on a plane defined by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the plane's normal.
   * @param y The y component of the plane's normal.
   * @return A vector "bounced off" from a plane defined by the normal defined by the given components.
   */
  def bounce(x: Float, y: Float): Vec2f = this.bounce(Vec2f(x, y))

  /**
   * Slides this vector along a plane defined by the given normal and returns the result.
   *
   * @param n The normal of the plane.
   * @return The result of sliding this vector along a plane defined by the given normal.
   */
  def slide(n: Vec2f): Vec2f = this - (n * this.dot(n))

  /**
   * Slides this vector along a plane defined by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the plane's normal.
   * @param y The y component of the plane's normal.
   * @return The result of sliding this vector along a plane defined by the normal defined by the given components.
   */
  def slide(x: Float, y: Float): Vec2f = this.slide(Vec2f(x, y))

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the given values.
   *
   * @param x The x component.
   * @param y The y component.
   * @return A vector composed by the reminder of the division between this vector's components and the given values.
   */
  def %(x: Float, y: Float): Vec2f = Vec2f(this.x % x, this.y % y)

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the given values.
   *
   * This method can be used in place of the `%` operator for better interoperability with Java.
   *
   * @param x The x component.
   * @param y The y component.
   * @return A vector composed by the reminder of the division between this vector's components and the given values.
   */
  def mod(x: Float, y: Float): Vec2f = this % (x, y)

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the components of the given vector.
   *
   * @param v The second vector.
   * @return A vector composed by the reminder of the division between this vector's components and the components of the given vector.
   */
  def %(v: Vec2f): Vec2f = this % (v.x, v.y)

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the components of the given vector.
   *
   * This method can be used in place of the `%` operator for better interoperability with Java.
   *
   * @param v The second vector.
   * @return A vector composed by the reminder of the division between this vector's components and the components of the given vector.
   */
  def mod(v: Vec2f): Vec2f = this % v

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the given scalar.
   *
   * @param k The scalar.
   * @return A vector composed by the reminder of the division between this vector's components and the given scalar.
   */
  def %(k: Float): Vec2f = this % (k, k)

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the given scalar.
   *
   * This method can be used in place of the `%` operator for better interoperability with Java.
   *
   * @param k The scalar.
   * @return A vector composed by the reminder of the division between this vector's components and the given scalar.
   */
  def mod(k: Float): Vec2f = this % k

  /**
   * Returns the aspect ratio of this vector.
   *
   * This method is the equivalent of `v.x / v.y`.
   *
   * @return The aspect ratio of this vector.
   */
  def aspect: Float = this.x / this.y

  /**
   * Returns a perpendicular vector rotated 90 degrees counter-clockwise compared to the original, with the same length.
   *
   * @return A vector perpendicular to this one with the same length.
   */
  def orthogonal: Vec2f = Vec2f(this.y, -this.x)

  /**
   * Rotates this vector by the given angle in radians and returns the result.
   *
   * @param angle The rotation angle in radians.
   * @return This vector rotated by the given angle.
   */
  def rotated(angle: Double): Vec2f = {
    val sin = math.sin(angle).toFloat
    val cos = math.cos(angle).toFloat
    Vec2f(this.x * cos - this.y * sin, this.x * sin + this.y * cos)
  }

  /**
   * Returns the cross product, or vector product, between this vector and the vector defined by the given components.
   *
   * Since the cross product is only defined in three dimensions, this vector is considered to be laying on the xy plane, i.e. its z component is considered to be zero.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The cross product between this vector and the vector defined by the given components.
   */
  def cross(x: Float, y: Float, z: Float): Vec3f = Vec3f(this.y * z, z * this.x, this.x * y - this.y * x)

  /**
   * Returns the cross product, or vector product, between this vector and the given one.
   *
   * Since the cross product is only defined in three dimensions, this vector is considered to be laying on the xy plane, i.e. its z component is considered to be zero.
   *
   * @param v The second vector.
   * @return The cross product between this vector and the given one.
   */
  def cross(v: Vec3f): Vec3f = this.cross(v.x, v.y, v.z)

  /**
   * Returns the cross product, or vector product, between this vector and the given one.
   *
   * Since the cross product is only defined in three dimensions, the two vectors are considered to be laying on the xy plane, i.e. their z component is considered to be zero.
   *
   * @param v The second vector.
   * @return The cross product between this vector and the given one.
   */
  def cross(v: Vec2f): Vec3f = this.cross(v.x, v.y, 0.0f)

  /**
   * Returns the outer product between this vector and the given values.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @return The outer product between this vector and the given values.
   */
  def outer(x: Float, y: Float): Mat2f = Mat2f(
    this.x * x, this.x * y,
    this.y * x, this.y * y
  )

  /**
   * Returns the outer product between this vector and the given one.
   *
   * @param v The second vector.
   * @return The outer product between this vector and the given one.
   */
  def outer(v: Vec2f): Mat2f = this.outer(v.x, v.y)

  /**
   * Returns the outer product between this vector and the given values.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The outer product between this vector and the given values.
   */
  def outer(x: Float, y: Float, z: Float): Mat2x3f = Mat2x3f(
    this.x * x, this.x * y, this.x * z,
    this.y * x, this.y * y, this.y * z
  )

  /**
   * Returns the outer product between this vector and the given one.
   *
   * @param v The second vector.
   * @return The outer product between this vector and the given one.
   */
  def outer(v: Vec3f): Mat2x3f = this.outer(v.x, v.y, v.z)

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x The x component.
   * @param y The y component.
   * @return True if the components of this vector are equal to the given ones, otherwise false.
   */
  def ==(x: Float, y: Float): Boolean = this.x == x && this.y == y

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * This method can be used in place of the `==` operator for better interoperability with Java.
   *
   * @param x The x component.
   * @param y The y component.
   * @return True if the components of this vector are equal to the given ones, otherwise false.
   */
  def equals(x: Float, y: Float): Boolean = this == (x, y)

  /**
   * Checks if the components of this vector are approximately equal to the given ones using an internal epsilon.
   *
   * @param x The x component.
   * @param y The y component.
   * @return True if the components of this vector are approximately equal to the given ones, otherwise false.
   * @see [[FloatEqualsApprox]]
   */
  def ~=(x: Float, y: Float): Boolean = (this.x ~= x) && (this.y ~= y)

  /**
   * Checks if the components of this vector are approximately equal to the given ones using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator for better interoperability with Java.
   *
   * @param x The x component.
   * @param y The y component.
   * @return True if the components of this vector are approximately equal to the given ones, otherwise false.
   * @see [[FloatEqualsApprox]]
   */
  def equalsApprox(x: Float, y: Float): Boolean = this ~= (x, y)

  /**
   * Checks if this vector is approximately equal to the given one using an internal epsilon.
   *
   * @param v The second vector.
   * @return True if this vector is approximately equal to the given one, otherwise false.
   * @see [[FloatEqualsApprox]]
   */
  def ~=(v: Vec2f): Boolean = this ~= (v.x, v.y)

  /**
   * Checks if this vector is approximately equal to the given one using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator for better interoperability with Java.
   *
   * @param v The second vector.
   * @return True if this vector is approximately equal to the given one, otherwise false.
   * @see [[FloatEqualsApprox]]
   */
  def equalsApprox(v: Vec2f): Boolean = this ~= v

  /**
   * Returns the component of this vector at the given index.
   * `0` for `x`, `1` for `y`.
   *
   * @param i The index of the requested component. Must be either 0, or 1.
   * @return The component of this vector at the given index.
   * @throws scala.MatchError If the given index is out of bounds.
   */
  def apply(i: Int): Float = i match {
    case 0 => this.x
    case 1 => this.y
  }

  /**
   * Casts this vector to an int vector.
   *
   * @return This vector cast to int.
   */
  def toInt: Vec2i = Vec2i(this.x.toInt, this.y.toInt)

  /**
   * Returns this vector as a double vector.
   *
   * @return This vector as a double vector.
   */
  def toDouble: Vec2d = Vec2d(this.x, this.y)
}

/**
 * Constants and implicits for vectors.
 */
object Vec2f {

  /** Shorthand for `Vec2f(0.0f, 0.0f)` */
  val Zero: Vec2f = Vec2f(0.0f, 0.0f)
  /** Shorthand for `Vec2f(1.0f, 1.0f)` */
  val One: Vec2f = Vec2f(1.0f, 1.0f)
  /** Shorthand for `Vec2f(1.0f, 0.0f)` */
  val Right: Vec2f = Vec2f(1.0f, 0.0f)
  /** Shorthand for `Vec2f(-1.0f, 0.0f)` */
  val Left: Vec2f = Vec2f(-1.0f, 0.0f)
  /** Shorthand for `Vec2f(0.0f, 1.0f)` */
  val Up: Vec2f = Vec2f(0.0f, 1.0f)
  /** Shorthand for `Vec2f(0.0f, -1.0f)` */
  val Down: Vec2f = Vec2f(0.0f, -1.0f)

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
    def *(v: Vec2f): Vec2f = v * self

    /**
     * Multiplies the [[Vec2f.inverse]] of the given vector by this scalar and returns the result.
     *
     * @param v The vector to multiply.
     * @return The product between this scalar and the inverse of the given vector.
     */
    def /(v: Vec2f): Vec2f = self * v.inverse
  }

  /**
   * Implicit conversion from [[Vec2f]] to [[Vec2d]].
   */
  implicit val vec2fToVec2d: Vec2f => Vec2d = v => v.toDouble
}
