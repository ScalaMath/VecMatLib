package io.github.scalamath.vecmatlib

/**
 * A 2D vector using floating point coordinates.
 *
 * Can be used to represent 2D coordinates or any other tuple of numeric values.
 *
 * @constructor Constructs a 2D vector from the two given components.
 * @param x The vector's x component.
 * @param y The vector's y component.
 */
case class Vec2i(x: Int, y: Int) {

  /**
   * Adds the given values to the components of this vector and returns the result.
   *
   * @param x The x component to add.
   * @param y The y component to add.
   * @return The sum between this vector and the given values.
   */
  def +(x: Int, y: Int): Vec2i = Vec2i(this.x + x, this.y + y)

  /**
   * Adds the given values to the components of this vector and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param x The x component to add.
   * @param y The y component to add.
   * @return The sum between this vector and the given values.
   */
  def plus(x: Int, y: Int): Vec2i = this + (x, y)

  /**
   * Adds the given vector to this one and returns the result.
   *
   * @param v The vector to add.
   * @return The sum between this vector and the given one.
   */
  def +(v: Vec2i): Vec2i = this + (v.x, v.y)

  /**
   * Adds the given vector to this one and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param v The vector to add.
   * @return The sum between this vector and the given one.
   */
  def plus(v: Vec2i): Vec2i = this + v

  /**
   * Returns this same vector.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This same vector.
   */
  def unary_+ : Vec2i = this

  /**
   * Subtracts the given values from each component of this vector and returns the result.
   *
   * @param x The x component to subtract.
   * @param y The y component to subtract.
   * @return The subtraction between this vector and the given values.
   */
  def -(x: Int, y: Int): Vec2i = Vec2i(this.x - x, this.y - y)

  /**
   * Subtracts the given values from each component of this vector and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param x The x component to subtract.
   * @param y The y component to subtract.
   * @return The subtraction between this vector and the given values.
   */
  def minus(x: Int, y: Int): Vec2i = this - (x, y)

  /**
   * Subtracts the given vector from this one and returns the result.
   *
   * @param v The vector to subtract.
   * @return The subtraction between this vector and the given one.
   */
  def -(v: Vec2i): Vec2i = this - (v.x, v.y)

  /**
   * Subtracts the given vector from this one and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param v The vector to subtract.
   * @return The subtraction between this vector and the given one.
   */
  def minus(v: Vec2i): Vec2i = this - v

  /**
   * Returns the additive inverse of this vector.
   *
   * @return The additive inverse of this vector.
   */
  def unary_- : Vec2i = Vec2i(-this.x, -this.y)

  /**
   * Returns the additive inverse of this vector.
   *
   * This method can be used in place of the unary `-` operator for better interoperability with Java.
   *
   * @return The additive inverse of this vector.
   */
  def negated: Vec2i = -this

  /**
   * Multiplies each component of this vector by the given values and returns the result.
   *
   * @param x Value to multiply the x component by.
   * @param y Value to multiply the y component by.
   * @return The component-wise multiplication between this vector and the given values.
   */
  def *(x: Int, y: Int): Vec2i = Vec2i(this.x * x, this.y * y)

  /**
   * Multiplies each component of this vector by the given values and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param x The value to multiply the x component by.
   * @param y The value to multiply the y component by.
   * @return The component-wise multiplication between this vector and the given values.
   */
  def multiply(x: Int, y: Int): Vec2i = this * (x, y)

  /**
   * Multiplies each component of this vector by the components of the given ones and returns the result.
   *
   * @param v The vector to multiply this one by.
   * @return The component-wise multiplication between this vector and the one.
   */
  def *(v: Vec2i): Vec2i = this * (v.x, v.y)

  /**
   * Multiplies each component of this vector by the components of the given ones and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param v The vector to multiply this one by.
   * @return The component-wise multiplication between this vector and the one.
   */
  def multiply(v: Vec2i): Vec2i = this * v

  /**
   * Multiplies this vector by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this vector by.
   * @return The product between this vector and the given scalar.
   */
  def *(k: Int): Vec2i = this * (k, k)

  /**
   * Multiplies this vector by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this vector by.
   * @return The product between this vector and the given scalar.
   */
  def multipliedBy(k: Int): Vec2i = this * k

  /**
   * Divides each component of this vector by the given values and returns the result.
   *
   * Note that this method performs an integer division.
   *
   * @param x The value to divide the x component by.
   * @param y The value to divide the y component by.
   * @return The component-wise division between this vector and the given values.
   */
  def /(x: Int, y: Int): Vec2i = Vec2i(this.x / x, this.y / y)

  /**
   * Divides each component of this vector by the given values and returns the result.
   *
   * Note that this method performs an integer division.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param x The value to divide the x component by.
   * @param y The value to divide the y component by.
   * @return The component-wise division between this vector and the given values.
   */
  def divide(x: Int, y: Int): Vec2i = this / (x, y)

  /**
   * Divides each component of this vector by the components of the given ones and returns the result.
   *
   * Note that this method performs an integer division.
   *
   * @param v The vector to divide this one by.
   * @return The component-wise division between this vector and the one.
   */
  def /(v: Vec2i): Vec2i = this / (v.x, v.y)

  /**
   * Divides each component of this vector by the components of the given ones and returns the result.
   *
   * Note that this method performs an integer division.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param v The vector to divide this one by.
   * @return The component-wise division between this vector and the one.
   */
  def divide(v: Vec2i): Vec2i = this / v

  /**
   * Divides this vector by the given scalar and returns the result.
   *
   * Note that this method performs an integer division.
   *
   * @param k The scalar to divide this vector by.
   * @return The division between this vector and the given scalar.
   */
  def /(k: Int): Vec2i = this / (k, k)

  /**
   * Divides this vector by the given scalar and returns the result.
   *
   * Note that this method performs an integer division.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this vector by.
   * @return The division between this vector and the given scalar.
   */
  def dividedBy(k: Int): Vec2i = this / k

  /**
   * Returns the dot product, or scalar product, between this vector and the given values.
   *
   * @param x The x component of the vector to multiply this one by.
   * @param y The y component of the vector to multiply this one by.
   * @return The dot product between this vector and the given values.
   */
  def dot(x: Int, y: Int): Int = this.x * x + this.y * y

  /**
   * Returns the dot product, or scalar product, between this vector and the given one.
   *
   * @param v The second vector.
   * @return The dot product between this vector and the given one.
   */
  def dot(v: Vec2i): Int = this.dot(v.x, v.y)

  /**
   * Returns the squared length, or magnitude, or modulus, of this vector.
   *
   * When comparing vectors by their length, it is more efficient to compare them by their squared length, since computing it does not require computing a square root.
   *
   * @return The squared length of this vector.
   * @see [[length]]
   */
  def lengthSquared: Int = this.dot(this)

  /**
   * Returns the length, or magnitude, or modulus, of this vector.
   *
   * @return The length of this vector.
   * @see [[lengthSquared]]
   */
  def length: Float = math.sqrt(this.lengthSquared).toFloat

  /**
   * Returns a vector with all components in absolute value.
   *
   * Not to be confused with the modulus, or [[length]], of a vector.
   *
   * @return A vector with all components in absolute value.
   */
  def abs: Vec2i = Vec2i(this.x.abs, this.y.abs)

  /**
   * Returns a vector with the signs of the components of this vector.
   *
   * @return A vector with all components representing the sign of this vector.
   */
  def sign: Vec2i = Vec2i(this.x.sign, this.y.sign)

  /**
   * Returns the squared distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).lengthSquared`.
   *
   * @param v The second vector.
   * @return The squared distance between this vector and the given one.
   * @see [[lengthSquared]]
   */
  def distanceSquaredTo(v: Vec2i): Int = (v - this).lengthSquared

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
  def distanceSquaredTo(x: Int, y: Int): Int = this.distanceSquaredTo(Vec2i(x, y))

  /**
   * Returns the distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).length`.
   *
   * @param v The second vector.
   * @return The squared between this vector and the given one.
   * @see [[length]]
   */
  def distanceTo(v: Vec2i): Float = (v - this).length

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
  def distanceTo(x: Int, y: Int): Float = this.distanceTo(Vec2i(x, y))

  /**
   * Returns the angle in radians between this vector and the given one.
   *
   * @param v The second vector.
   * @return The angle in radians between this vector and the given one.
   */
  def angleTo(v: Vec2i): Double = math.acos(this.dot(v) / (this.length * v.length))

  /**
   * Returns the angle in radians between this vector and the one with the given components.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @return The angle in radians between this vector and the one with the given components.
   */
  def angleTo(x: Int, y: Int): Double = this.angleTo(Vec2i(x, y))

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
  def angleToPoint(v: Vec2i): Double = (v - this).angle

  /**
   * Returns the angle in radians between the line connecting the two points represented by this vector and the given coordinates and the X axis.
   *
   * This method is equivalent to `(b - a).angle`.
   *
   * @param x The x coordinate of the second point.
   * @param y The y coordinate of the second point.
   * @return The angle in radians between the line connecting the two points represented by this vector and the given coordinates and the X axis.
   */
  def angleToPoint(x: Int, y: Int): Double = this.angleToPoint(Vec2i(x, y))

  /**
   * Reflects this vector by the given normal and returns the result.
   *
   * @param n The reflection normal.
   * @return The reflection of this vector by the given normal.
   */
  def reflect(n: Vec2i): Vec2i = this - (n * (this.dot(n) * 2))

  /**
   * Reflects this vector by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the reflection normal.
   * @param y The y component of the reflection normal.
   * @return The reflection of this vector by the normal defined by the given components.
   */
  def reflect(x: Int, y: Int): Vec2i = this.reflect(Vec2i(x, y))

  /**
   * "Bounces" this vector on a plane defined by the given normal and returns the result.
   *
   * @param n The normal of the plane.
   * @return A vector "bounced off" from a plane defined by the given normal.
   */
  def bounce(n: Vec2i): Vec2i = -this.reflect(n)

  /**
   * "Bounces" this vector on a plane defined by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the plane's normal.
   * @param y The y component of the plane's normal.
   * @return A vector "bounced off" from a plane defined by the normal defined by the given components.
   */
  def bounce(x: Int, y: Int): Vec2i = this.bounce(Vec2i(x, y))

  /**
   * Slides this vector along a plane defined by the given normal and returns the result.
   *
   * @param n The normal of the plane.
   * @return The result of sliding this vector along a plane defined by the given normal.
   */
  def slide(n: Vec2i): Vec2i = this - (n * this.dot(n))

  /**
   * Slides this vector along a plane defined by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the plane's normal.
   * @param y The y component of the plane's normal.
   * @return The result of sliding this vector along a plane defined by the normal defined by the given components.
   */
  def slide(x: Int, y: Int): Vec2i = this.slide(Vec2i(x, y))

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the given values.
   *
   * @param x The x component.
   * @param y The y component.
   * @return A vector composed by the reminder of the division between this vector's components and the given values.
   */
  def %(x: Int, y: Int): Vec2i = Vec2i(this.x % x, this.y % y)

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the given values.
   *
   * This method can be used in place of the `%` operator for better interoperability with Java.
   *
   * @param x The x component.
   * @param y The y component.
   * @return A vector composed by the reminder of the division between this vector's components and the given values.
   */
  def mod(x: Int, y: Int): Vec2i = this % (x, y)

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the components of the given vector.
   *
   * @param v The second vector.
   * @return A vector composed by the reminder of the division between this vector's components and the components of the given vector.
   */
  def %(v: Vec2i): Vec2i = this % (v.x, v.y)

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the components of the given vector.
   *
   * This method can be used in place of the `%` operator for better interoperability with Java.
   *
   * @param v The second vector.
   * @return A vector composed by the reminder of the division between this vector's components and the components of the given vector.
   */
  def mod(v: Vec2i): Vec2i = this % v

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the given scalar.
   *
   * @param k The scalar.
   * @return A vector composed by the reminder of the division between this vector's components and the given scalar.
   */
  def %(k: Int): Vec2i = this % (k, k)

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the given scalar.
   *
   * This method can be used in place of the `%` operator for better interoperability with Java.
   *
   * @param k The scalar.
   * @return A vector composed by the reminder of the division between this vector's components and the given scalar.
   */
  def mod(k: Int): Vec2i = this % k

  /**
   * Returns the aspect ratio of this vector.
   *
   * This method is the equivalent of `v.x / v.y`.
   *
   * @return The aspect ratio of this vector.
   */
  def aspect: Float = this.x / this.y.toFloat

  /**
   * Returns a perpendicular vector rotated 90 degrees counter-clockwise compared to the original, with the same length.
   *
   * @return A vector perpendicular to this one with the same length.
   */
  def orthogonal: Vec2i = Vec2i(this.y, -this.x)

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
  def cross(x: Int, y: Int, z: Int): Vec3i = Vec3i(this.y * z, z * this.x, this.x * y - this.y * x)

  /**
   * Returns the cross product, or vector product, between this vector and the given one.
   *
   * Since the cross product is only defined in three dimensions, this vector is considered to be laying on the xy plane, i.e. its z component is considered to be zero.
   *
   * @param v The second vector.
   * @return The cross product between this vector and the given one.
   */
  def cross(v: Vec3i): Vec3i = this.cross(v.x, v.y, v.z)

  /**
   * Returns the cross product, or vector product, between this vector and the given one.
   *
   * Since the cross product is only defined in three dimensions, the two vectors are considered to be laying on the xy plane, i.e. their z component is considered to be zero.
   *
   * @param v The second vector.
   * @return The cross product between this vector and the given one.
   */
  def cross(v: Vec2i): Vec3i = this.cross(v.x, v.y, 0)

  /**
   * Returns the outer product between this vector and the given values.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @return The outer product between this vector and the given values.
   */
  def outer(x: Int, y: Int): Mat2i = Mat2i(
    this.x * x, this.x * y,
    this.y * x, this.y * y
  )

  /**
   * Returns the outer product between this vector and the given one.
   *
   * @param v The second vector.
   * @return The outer product between this vector and the given one.
   */
  def outer(v: Vec2i): Mat2i = this.outer(v.x, v.y)

  /**
   * Returns the outer product between this vector and the given values.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The outer product between this vector and the given values.
   */
  def outer(x: Int, y: Int, z: Int): Mat2x3i = Mat2x3i(
    this.x * x, this.x * y, this.x * z,
    this.y * x, this.y * y, this.y * z
  )

  /**
   * Returns the outer product between this vector and the given one.
   *
   * @param v The second vector.
   * @return The outer product between this vector and the given one.
   */
  def outer(v: Vec3i): Mat2x3i = this.outer(v.x, v.y, v.z)

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x The x component.
   * @param y The y component.
   * @return True if the components of this vector are equal to the given ones, otherwise false.
   */
  def ==(x: Int, y: Int): Boolean = this.x == x && this.y == y

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * This method can be used in place of the `==` operator for better interoperability with Java.
   *
   * @param x The x component.
   * @param y The y component.
   * @return True if the components of this vector are equal to the given ones, otherwise false.
   */
  def equals(x: Int, y: Int): Boolean = this == (x, y)

  /**
   * Returns the component of this vector at the given index.
   * `0` for `x`, `1` for `y`.
   *
   * @param i The index of the requested component. Must be either 0, or 1.
   * @return The component of this vector at the given index.
   * @throws MatchError If the given index is out of bounds.
   */
  def apply(i: Int): Int = i match {
    case 0 => this.x
    case 1 => this.y
  }

  /**
   * Returns this vector as a float vector.
   *
   * @return This vector as a float vector.
   */
  def toFloat: Vec2f = Vec2f(this.x.toFloat, this.y.toFloat)

  /**
   * Returns this vector as a double vector.
   *
   * @return This vector as a double vector.
   */
  def toDouble: Vec2d = Vec2d(this.x.toDouble, this.y.toDouble)
}

/**
 * Constants and implicits for vectors.
 */
object Vec2i {

  /** Shorthand for `Vec2i(0, 0)` */
  val Zero: Vec2i = Vec2i(0, 0)
  /** Shorthand for `Vec2i(1, 1)` */
  val One: Vec2i = Vec2i(1, 1)
  /** Shorthand for `Vec2i(1, 0)` */
  val Right: Vec2i = Vec2i(1, 0)
  /** Shorthand for `Vec2i(-1, 0)` */
  val Left: Vec2i = Vec2i(-1, 0)
  /** Shorthand for `Vec2i(0, 1)` */
  val Up: Vec2i = Vec2i(0, 1)
  /** Shorthand for `Vec2i(0, -1)` */
  val Down: Vec2i = Vec2i(0, -1)

  /**
   * Allows to use the `*` operator with a scalar as `1 * vector`.
   *
   * @param self The scalar value.
   */
  implicit class MultiplicationExtender(val self: Int) extends AnyVal {

    /**
     * Multiplies the given vector by this scalar and returns the result.
     *
     * @param v The vector to multiply.
     * @return The product between this scalar and the given vector.
     */
    def *(v: Vec2i): Vec2i = v * self
  }

  /**
   * Implicit conversion from [[Vec2i]] to [[Vec2f]].
   */
  implicit val vec2iToVec2f: Vec2i => Vec2f = v => v.toFloat

  /**
   * Implicit conversion from [[Vec2i]] to [[Vec2d]].
   */
  implicit val vec2fToVec2d: Vec2i => Vec2d = v => v.toDouble
}
