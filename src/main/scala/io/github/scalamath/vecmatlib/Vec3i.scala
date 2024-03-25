package io.github.scalamath.vecmatlib

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
case class Vec3i(x: Int, y: Int, z: Int) {

  /**
   * Constructs a 3D vector from the given components.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   */
  def this(xy: Vec2i, z: Int) = this(xy.x, xy.y, z)

  /**
   * Returns a 2D vector composed of the x and the y components of this vector.
   *
   * @return A 2D vector composed of the x and the y components of this vector.
   */
  def xy: Vec2i = Vec2i(this.x, this.y)

  /**
   * Adds the given values to the components of this vector and returns the result.
   *
   * @param x The x component to add.
   * @param y The y component to add.
   * @param z The z component to add.
   * @return The sum between this vector and the given values.
   */
  def +(x: Int, y: Int, z: Int): Vec3i = Vec3i(this.x + x, this.y + y, this.z + z)

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
  def plus(x: Int, y: Int, z: Int): Vec3i = this + (x, y, z)

  /**
   * Adds the given vector to this one and returns the result.
   *
   * @param v The vector to add.
   * @return The sum between this vector and the given one.
   */
  def +(v: Vec3i): Vec3i = this + (v.x, v.y, v.z)

  /**
   * Adds the given vector to this one and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param v The vector to add.
   * @return The sum between this vector and the given one.
   */
  def plus(v: Vec3i): Vec3i = this + v

  /**
   * Returns this exact vector.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This exact vector.
   */
  def unary_+ : Vec3i = this

  /**
   * Subtracts the given values from each component of this vector and returns the result.
   *
   * @param x The x component to subtract.
   * @param y The y component to subtract.
   * @param z The z component to subtract.
   * @return The subtraction between this vector and the given values.
   */
  def -(x: Int, y: Int, z: Int): Vec3i = Vec3i(this.x - x, this.y - y, this.z - z)

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
  def minus(x: Int, y: Int, z: Int): Vec3i = this - (x, y, z)

  /**
   * Subtracts the given vector from this one and returns the result.
   *
   * @param v The vector to subtract.
   * @return The subtraction between this vector and the given one.
   */
  def -(v: Vec3i): Vec3i = this - (v.x, v.y, v.z)

  /**
   * Subtracts the given vector from this one and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param v The vector to subtract.
   * @return The subtraction between this vector and the given one.
   */
  def minus(v: Vec3i): Vec3i = this - v

  /**
   * Returns the additive inverse of this vector.
   *
   * @return The additive inverse of this vector.
   */
  def unary_- : Vec3i = Vec3i(-this.x, -this.y, -this.z)

  /**
   * Returns the additive inverse of this vector.
   *
   * This method can be used in place of the unary `-` operator for better interoperability with Java.
   *
   * @return The additive inverse of this vector.
   */
  def negated: Vec3i = -this

  /**
   * Multiplies each component of this vector by the given values and returns the result.
   *
   * @param x Value to multiply the x component by.
   * @param y Value to multiply the y component by.
   * @param z Value to multiply the z component by.
   * @return The component-wise multiplication between this vector and the given values.
   */
  def *(x: Int, y: Int, z: Int): Vec3i = Vec3i(this.x * x, this.y * y, this.z * z)

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
  def multiply(x: Int, y: Int, z: Int): Vec3i = this * (x, y, z)

  /**
   * Multiplies each component of this vector by the components of the given ones and returns the result.
   *
   * @param v The vector to multiply this one by.
   * @return The component-wise multiplication between this vector and the one.
   */
  def *(v: Vec3i): Vec3i = this * (v.x, v.y, v.z)

  /**
   * Multiplies each component of this vector by the components of the given ones and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param v The vector to multiply this one by.
   * @return The component-wise multiplication between this vector and the one.
   */
  def multiply(v: Vec3i): Vec3i = this * v

  /**
   * Multiplies this vector by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this vector by.
   * @return The product between this vector and the given scalar.
   */
  def *(k: Int): Vec3i = this * (k, k, k)

  /**
   * Multiplies this vector by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this vector by.
   * @return The product between this vector and the given scalar.
   */
  def multipliedBy(k: Int): Vec3i = this * k

  /**
   * Divides each component of this vector by the given values and returns the result.
   *
   * Note that this method performs an integer division.
   *
   * @param x The value to divide the x component by.
   * @param y The value to divide the y component by.
   * @param z The value to divide the z component by.
   * @return The component-wise division between this vector and the given values.
   */
  def /(x: Int, y: Int, z: Int): Vec3i = Vec3i(this.x / x, this.y / y, this.z / z)

  /**
   * Divides each component of this vector by the given values and returns the result.
   *
   * Note that this method performs an integer division.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param x The value to divide the x component by.
   * @param y The value to divide the y component by.
   * @param z The value to divide the z component by.
   * @return The component-wise division between this vector and the given values.
   */
  def divide(x: Int, y: Int, z: Int): Vec3i = this / (x, y, z)

  /**
   * Divides each component of this vector by the components of the given ones and returns the result.
   *
   * Note that this method performs an integer division.
   *
   * @param v The vector to divide this one by.
   * @return The component-wise division between this vector and the one.
   */
  def /(v: Vec3i): Vec3i = this / (v.x, v.y, v.z)

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
  def divide(v: Vec3i): Vec3i = this / v

  /**
   * Divides this vector by the given scalar and returns the result.
   *
   * Note that this method performs an integer division.
   *
   * @param k The scalar to divide this vector by.
   * @return The division between this vector and the given scalar.
   */
  def /(k: Int): Vec3i = this / (k, k, k)

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
  def dividedBy(k: Int): Vec3i = this / k

  /**
   * Returns the dot product, or scalar product, between this vector and the given values.
   *
   * @param x The x component of the vector to multiply this one by.
   * @param y The y component of the vector to multiply this one by.
   * @param z The z component of the vector to multiply this one by.
   * @return The dot product between this vector and the given values.
   */
  def dot(x: Int, y: Int, z: Int): Int = this.x * x + this.y * y + this.z * z

  /**
   * Returns the dot product, or scalar product, between this vector and the given one.
   *
   * @param v The second vector.
   * @return The dot product between this vector and the given one.
   */
  def dot(v: Vec3i): Int = this.dot(v.x, v.y, v.z)

  /**
   * Returns the cross product, or vector product, between this vector and the vector defined by the given components.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The cross product between this vector and the vector defined by the given components.
   */
  def cross(x: Int, y: Int, z: Int): Vec3i = Vec3i(this.y * z - this.z * y, x * this.z - z * this.x, this.x * y - this.y * x)

  /**
   * Returns the cross product, or vector product, between this vector and the given one.
   *
   * @param v The second vector.
   * @return The cross product between this vector and the given one.
   */
  def cross(v: Vec3i): Vec3i = this.cross(v.x, v.y, v.z)

  /**
   * Returns the cross product, or vector product, between this vector and the given one.
   *
   * Since the cross product is only defined in three dimensions, the given vector is considered to be laying on the xy plane, i.e. its z component is considered to be zero.
   *
   * @param v The second vector.
   * @return The cross product between this vector and the given one.
   */
  def cross(v: Vec2i): Vec3i = this.cross(v.x, v.y, 0)

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
  def abs: Vec3i = Vec3i(this.x.abs, this.y.abs, this.z.abs)

  /**
   * Returns a vector with the signs of the components of this vector.
   *
   * @return A vector with all components representing the sign of this vector.
   */
  def sign: Vec3i = Vec3i(this.x.sign, this.y.sign, this.z.sign)

  /**
   * Returns the squared distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).lengthSquared`.
   *
   * @param v The second vector.
   * @return The squared distance between this vector and the given one.
   * @see [[lengthSquared]]
   */
  def distanceSquaredTo(v: Vec3i): Int = (v - this).lengthSquared

  /**
   * Returns the squared distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).lengthSquared`.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The squared distance between this vector and the one with the given components.
   * @see [[lengthSquared]]
   */
  def distanceSquaredTo(x: Int, y: Int, z: Int): Int = this.distanceSquaredTo(Vec3i(x, y, z))

  /**
   * Returns the distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).length`.
   *
   * @param v The second vector.
   * @return The squared between this vector and the given one.
   * @see [[length]]
   */
  def distanceTo(v: Vec3i): Float = (v - this).length

  /**
   * Returns the distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).length`.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The squared between this vector and the one with the given components.
   * @see [[length]]
   */
  def distanceTo(x: Int, y: Int, z: Int): Float = this.distanceTo(Vec3i(x, y, z))

  /**
   * Returns the angle in radians between this vector and the given one.
   *
   * @param v The second vector.
   * @return The angle in radians between this vector and the given one.
   */
  def angleTo(v: Vec3i): Double = math.acos(this.dot(v) / (this.length * v.length))

  /**
   * Returns the angle in radians between this vector and the one with the given components.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The angle in radians between this vector and the one with the given components.
   */
  def angleTo(x: Int, y: Int, z: Int): Double = this.angleTo(Vec3i(x, y, z))

  /**
   * Returns the signed angle to the given vector in radians.
   *
   * @param to The second vector.
   * @param axis Specifies the sign of the angle.
   * @return The signed angle to the given vector in radians.
   */
  def signedAngleTo(to: Vec3i, axis: Vec3i): Double = {
    val cross = this.cross(to)
    math.atan2(cross.length, this.dot(to)) * cross.dot(axis).sign
  }

  /**
   * Reflects this vector by the given normal and returns the result.
   *
   * @param n The reflection normal.
   * @return The reflection of this vector by the given normal.
   */
  def reflect(n: Vec3i): Vec3i = this - (n * (this.dot(n) * 2))

  /**
   * Reflects this vector by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the reflection normal.
   * @param y The y component of the reflection normal.
   * @param z The z component of the reflection normal.
   * @return The reflection of this vector by the normal defined by the given components.
   */
  def reflect(x: Int, y: Int, z: Int): Vec3i = this.reflect(Vec3i(x, y, z))

  /**
   * "Bounces" this vector on a plane defined by the given normal and returns the result.
   *
   * @param n The normal of the plane.
   * @return A vector "bounced off" from a plane defined by the given normal.
   */
  def bounce(n: Vec3i): Vec3i = -this.reflect(n)

  /**
   * "Bounces" this vector on a plane defined by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the plane's normal.
   * @param y The y component of the plane's normal.
   * @param z The z component of the plane's normal.
   * @return A vector "bounced off" from a plane defined by the normal defined by the given components.
   */
  def bounce(x: Int, y: Int, z: Int): Vec3i = this.bounce(Vec3i(x, y, z))

  /**
   * Slides this vector along a plane defined by the given normal and returns the result.
   *
   * @param n The normal of the plane.
   * @return The result of sliding this vector along a plane defined by the given normal.
   */
  def slide(n: Vec3i): Vec3i = this - (n * this.dot(n))

  /**
   * Slides this vector along a plane defined by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the plane's normal.
   * @param y The y component of the plane's normal.
   * @param z The z component of the plane's normal.
   * @return The result of sliding this vector along a plane defined by the normal defined by the given components.
   */
  def slide(x: Int, y: Int, z: Int): Vec3i = this.slide(Vec3i(x, y, z))

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the given values.
   *
   * @param x The x component.
   * @param y The y component.
   * @param z The z component.
   * @return A vector composed by the reminder of the division between this vector's components and the given values.
   */
  def %(x: Int, y: Int, z: Int): Vec3i = Vec3i(this.x % x, this.y % y, this.z % z)

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
  def mod(x: Int, y: Int, z: Int): Vec3i = this % (x, y, z)

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the components of the given vector.
   *
   * @param v The second vector.
   * @return A vector composed by the reminder of the division between this vector's components and the components of the given vector.
   */
  def %(v: Vec3i): Vec3i = this % (v.x, v.y, v.z)

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the components of the given vector.
   *
   * This method can be used in place of the `%` operator for better interoperability with Java.
   *
   * @param v The second vector.
   * @return A vector composed by the reminder of the division between this vector's components and the components of the given vector.
   */
  def mod(v: Vec3i): Vec3i = this % v

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the given scalar.
   *
   * @param k The scalar.
   * @return A vector composed by the reminder of the division between this vector's components and the given scalar.
   */
  def %(k: Int): Vec3i = this % (k, k, k)

  /**
   * Returns a vector composed by the reminder of the division between this vector's components and the given scalar.
   *
   * This method can be used in place of the `%` operator for better interoperability with Java.
   *
   * @param k The scalar.
   * @return A vector composed by the reminder of the division between this vector's components and the given scalar.
   */
  def mod(k: Int): Vec3i = this % k

  /**
   * Returns the outer product between this vector and the given values.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The outer product between this vector and the given values.
   */
  def outer(x: Int, y: Int, z: Int): Mat3i = Mat3i(
    this.x * x, this.x * y, this.x * z,
    this.y * x, this.y * y, this.y * z,
    this.z * x, this.z * y, this.z * z
  )

  /**
   * Returns the outer product between this vector and the given one.
   *
   * @param v The second vector.
   * @return The outer product between this vector and the given one.
   */
  def outer(v: Vec3i): Mat3i = this.outer(v.x, v.y, v.z)

  /**
   * Returns the outer product between this vector and the given values.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @param w The w component of the second vector.
   * @return The outer product between this vector and the given values.
   */
  def outer(x: Int, y: Int, z: Int, w: Int): Mat3x4i = Mat3x4i(
    this.x * x, this.x * y, this.x * z, this.x * w,
    this.y * x, this.y * y, this.y * z, this.y * w,
    this.z * x, this.z * y, this.z * z, this.z * w
  )

  /**
   * Returns the outer product between this vector and the given one.
   *
   * @param v The second vector.
   * @return The outer product between this vector and the given one.
   */
  def outer(v: Vec4i): Mat3x4i = this.outer(v.x, v.y, v.z, v.w)

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x The x component.
   * @param y The y component.
   * @param z The z component.
   * @return True if the components of this vector are equal to the given ones, otherwise false.
   */
  def ==(x: Int, y: Int, z: Int): Boolean = this.x == x && this.y == y && this.z == z

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
  def equals(x: Int, y: Int, z: Int): Boolean = this == (x, y, z)

  /**
   * Returns the component of this vector at the given index.
   * `0` for `x`, `1` for `y`, `2` for `z`.
   *
   * @param i The index of the requested component. Must be either 0, 1, or 2.
   * @return The component of this vector at the given index.
   * @throws MatchError If the given index is out of bounds.
   */
  def apply(i: Int): Int = i match {
    case 0 => this.x
    case 1 => this.y
    case 2 => this.z
  }

  /**
   * Returns this vector as a float vector.
   *
   * @return This vector as a float vector.
   */
  def toFloat: Vec3f = Vec3f(this.x.toFloat, this.y.toFloat, this.z.toFloat)

  /**
   * Returns this vector as a double vector.
   *
   * @return This vector as a double vector.
   */
  def toDouble: Vec3d = Vec3d(this.x.toDouble, this.y.toDouble, this.z.toDouble)
}

/**
 * Constants, factory methods, and implicits for vectors.
 */
object Vec3i {

  /** Shorthand for `Vec3i(0, 0, 0)` */
  val Zero: Vec3i = Vec3i(0, 0, 0)
  /** Shorthand for `Vec3i(1, 1, 1)` */
  val One: Vec3i = Vec3i(1, 1, 1)
  /** Shorthand for `Vec3i(1, 0, 0)` */
  val Right: Vec3i = Vec3i(1, 0, 0)
  /** Shorthand for `Vec3i(-1, 0, 0)` */
  val Left: Vec3i = Vec3i(-1, 0, 0)
  /** Shorthand for `Vec3i(0, 1, 0)` */
  val Up: Vec3i = Vec3i(0, 1, 0)
  /** Shorthand for `Vec3i(0, -1, 0)` */
  val Down: Vec3i = Vec3i(0, -1, 0)
  /** Shorthand for `Vec3i(0, 0, 1` */
  val Forward: Vec3i = Vec3i(0, 0, 1)
  /** Shorthand for `Vec3i(0.0, 0, -1)` */
  val Backwards: Vec3i = Vec3i(0, 0, -1)

  /**
   * Constructs a 3D vector from the given components.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   * @return A 3D vector constructed from the given components.
   */
  def apply(xy: Vec2i, z: Int) = new Vec3i(xy, z)

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
    def *(v: Vec3i): Vec3i = v * self
  }

  /**
   * Implicit conversion from [[Vec3i]] to [[Vec3f]].
   */
  implicit val vec3iToVec3f: Vec3i => Vec3f = v => v.toFloat

  /**
   * Implicit conversion from [[Vec3i]] to [[Vec3d]].
   */
  implicit val vec3iToVec3d: Vec3i => Vec3d = v => v.toDouble
}
