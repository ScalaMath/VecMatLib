package io.github.hexagonnico.vecmatlib.quaternion

import io.github.hexagonnico.vecmatlib.vector.Vec3d
import io.github.hexagonnico.vecmatlib.{Double3, Double4}

/**
 * Class that represents a quaternion which can represent a rotation.
 *
 * @constructor Constructs a quaternion from the four given values
 * @param w The real/scalar part of the quaternion
 * @param x The first component of the vector part (imaginary 'i' axis)
 * @param y The second component of the vector part (imaginary 'j' axis)
 * @param z The third component of the vector part (imaginary 'l' axis)
 */
case class Quaternion(w: Double, x: Double, y: Double, z: Double) extends Double4 {

  /**
   * Constructs a quaternion from the given scalar part and the given vector part
   *
   * @param w The real/scalar part of the quaternion
   * @param v The vector part of the quaternion
   */
  def this(w: Double, v: Double3) = this(w, v.x, v.y, v.z)

  /**
   * Returns the sum between this quaternion and the quaternion `w + xi + yj + zk`.
   *
   * @param w The real/scalar part of the quaternion to add
   * @param x The first component of the vector part of the quaternion to add
   * @param y The second component of the vector part of the quaternion to add
   * @param z The third component of the vector part of the quaternion to add
   * @return The sum of this quaternion and the one with the quaternion `w + xi + yj + zk`
   */
  def +(w: Double, x: Double, y: Double, z: Double): Quaternion = Quaternion(this.w + w, this.x + x, this.y + y, this.z + z)

  /**
   * Returns the sum between this quaternion and the quaternion `w + xi + yj + zk`.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param w The real/scalar part of the quaternion to add
   * @param x The first component of the vector part of the quaternion to add
   * @param y The second component of the vector part of the quaternion to add
   * @param z The third component of the vector part of the quaternion to add
   * @return The sum of this quaternion and the one with the quaternion `w + xi + yj + zk`
   */
  def plus(w: Double, x: Double, y: Double, z: Double): Quaternion = this + (w, x, y, z)

  /**
   * Returns the sum between this quaternion and the given one.
   *
   * @param q The quaternion to add
   * @return The sum of this quaternion and the given one
   */
  def +(q: Quaternion): Quaternion = this + (q.w, q.x, q.y, q.z)

  /**
   * Returns the sum between this quaternion and the given one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param q The quaternion to add
   * @return The sum of this quaternion and the given one
   */
  def plus(q: Quaternion): Quaternion = this + q

  /**
   * Returns the additive inverse of this quaternion.
   *
   * @return The additive inverse of this quaternion
   */
  def unary_-(): Quaternion = Quaternion(-this.w, -this.x, -this.y, -this.z)

  /**
   * Returns the additive inverse of this quaternion.
   *
   * This method can be used in place of the unary '-' operator for better interoperability with Java.
   *
   * @return The additive inverse of this quaternion
   */
  def negated: Quaternion = -this

  /**
   * Returns the subtraction between this quaternion and the quaternion `w + xi + yj + zk`.
   *
   * @param w The real/scalar part of the quaternion to subtract
   * @param x The first component of the vector part of the quaternion to subtract
   * @param y The second component of the vector part of the quaternion to subtract
   * @param z The third component of the vector part of the quaternion to subtract
   * @return The subtract of the quaternion `w + xi + yj + zk` from this one
   */
  def -(w: Double, x: Double, y: Double, z: Double): Quaternion = Quaternion(this.w - w, this.x - x, this.y - y, this.z - z)

  /**
   * Returns the subtraction between this quaternion and the quaternion `w + xi + yj + zk`.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param w The real/scalar part of the quaternion to subtract
   * @param x The first component of the vector part of the quaternion to subtract
   * @param y The second component of the vector part of the quaternion to subtract
   * @param z The third component of the vector part of the quaternion to subtract
   * @return The subtract of the quaternion `w + xi + yj + zk` from this one
   */
  def minus(w: Double, x: Double, y: Double, z: Double): Quaternion = this - (w, x, y, z)

  /**
   * Returns the subtraction between the given quaternion and this one.
   *
   * @param q The quaternion to subtract
   * @return The subtraction of the given quaternion from this one
   */
  def -(q: Quaternion): Quaternion = this - (q.w, q.x, q.y, q.z)

  /**
   * Returns the subtraction between the given quaternion and this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param q The quaternion to subtract
   * @return The subtraction of the given quaternion from this one
   */
  def minus(q: Quaternion): Quaternion = this - q

  /**
   * Returns the product between this quaternion and the given scalar.
   *
   * @param l The scalar to which the quaternion is multiplied
   * @return The result of the product between this quaternion and the given scalar
   */
  def *(l: Double): Quaternion = Quaternion(this.w * l, this.x * l, this.y * l, this.z * l)

  /**
   * Returns the product between this quaternion and the given scalar.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param l The scalar to which the quaternion is multiplied
   * @return The result of the product between this quaternion and the given scalar
   */
  def multipliedBy(l: Double): Quaternion = this * l

  /**
   * Returns the product between this quaternion and the quaternion `w + xi + yj + zk` as defined by the Hamilton product.
   *
   * @param w The real/scalar part of the second operand of the multiplication
   * @param x The first component of the vector part of the second operand of the multiplication
   * @param y The second component of the vector part of the second operand of the multiplication
   * @param z The third component of the vector part of the second operand of the multiplication
   * @return The product between this quaternion and the quaternion `w + xi + yj + zk`
   */
  def *(w: Double, x: Double, y: Double, z: Double): Quaternion = Quaternion(
    this.w * w - this.x * x - this.y * y - this.z * z,
    this.w * x + this.x * w + this.y * z - this.z * y,
    this.w * y - this.x * z + this.y * w + this.z * x,
    this.w * z + this.x * y - this.y * x + this.z * w
  )

  /**
   * Returns the product between this quaternion and the quaternion `w + xi + yj + zk` as defined by the Hamilton product.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param w The real/scalar part of the second operand of the multiplication
   * @param x The first component of the vector part of the second operand of the multiplication
   * @param y The second component of the vector part of the second operand of the multiplication
   * @param z The third component of the vector part of the second operand of the multiplication
   * @return The product between this quaternion and the quaternion `w + xi + yj + zk`
   */
  def multiply(w: Double, x: Double, y: Double, z: Double): Quaternion = this * (w, x, y, z)

  /**
   * Returns the product between this quaternion and the given one as defined by the Hamilton product.
   *
   * @param q The second operand of the multiplication
   * @return The product between this quaternion and the given one
   */
  def *(q: Quaternion): Quaternion = this * (q.w, q.x, q.y, q.z)

  /**
   * Returns the product between this quaternion and the given one as defined by the Hamilton product.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param q The second operand of the multiplication
   * @return The product between this quaternion and the given one
   */
  def multiply(q: Quaternion): Quaternion = this * q

  /**
   * Returns the result of dividing this quaternion by the given scalar.
   *
   * @param l The scalar by which this quaternion is divided
   * @return The result of the division of this quaternion by the given scalar
   */
  def /(l: Double): Quaternion = Quaternion(this.w / l, this.x / l, this.y / l, this.z / l)

  /**
   * Returns the result of dividing this quaternion by the given scalar.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param l The scalar by which this quaternion is divided
   * @return The result of the division of this quaternion by the given scalar
   */
  def dividedBy(l: Double): Quaternion = this / l

  /**
   * Returns the conjugate of this quaternion.
   * The conjugate of a quaternion `w + xi + yj + zk` is the quaternion `w - xi - yj - zk`.
   *
   * @return The conjugate of this quaternion
   */
  def conjugate: Quaternion = Quaternion(this.w, -this.x, -this.y, -this.z)

  /**
   * Returns the result of the dot product (or scalar product) between this quaternion and the quaternion `w + xi + yj + zk`.
   *
   * @param w The real/scalar part of the second operand of the product
   * @param x The first component of the vector part of the second operand of the product
   * @param y The second component of the vector part of the second operand of the product
   * @param z The third component of the vector part of the second operand of the product
   * @return The result of the dot product between this quaternion and the quaternion `w + xi + yj + zk`
   */
  def dot(w: Double, x: Double, y: Double, z: Double): Double = this.w * w + this.x * x + this.y * y + this.z * z

  /**
   * Returns the result of the dot product (or scalar product) between this quaternion and the given one.
   *
   * @param q The second operand of the product
   * @return The result of the dot product between this quaternion and the given one
   */
  def dot(q: Quaternion): Double = this dot (q.w, q.x, q.y, q.z)

  /**
   * Returns the squared length (or squared norm) of this quaternion.
   *
   * @return The squared norm of this quaternion
   */
  def lengthSquared: Double = this dot this

  /**
   * Returns the length (or norm) of this quaternion.
   *
   * @return The norm of this quaternion
   */
  def length: Double = math.sqrt(this.lengthSquared)

  /**
   * Returns that is, this quaternion divided by its norm or [[length]].
   *
   * @return A unit quaternion
   */
  def normalized: Quaternion = this / this.length

  /**
   * Returns the multiplicative inverse (or the reciprocal) of this quaternion.
   *
   * The same quaternion can be obtained with `1.0 / q`.
   *
   * @return The reciprocal of this quaternion
   */
  def reciprocal: Quaternion = this.conjugate / this.lengthSquared

  /**
   * Returns the product of this quaternion by the [[reciprocal]] of the given one.
   *
   * @param q The second operand of the division
   * @return The product of this quaternion by the reciprocal of the given one
   */
  def /(q: Quaternion): Quaternion = this * q.reciprocal

  /**
   * Returns the product of this quaternion by the [[reciprocal]] of the given one.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param q The second operand of the division
   * @return The product of this quaternion by the reciprocal of the given one
   */
  def divide(q: Quaternion): Quaternion = this / q

  /**
   * Returns the product of this quaternion by the [[reciprocal]] of the quaternion `w + xi + yj + zk`.
   *
   * @param w The real/scalar part of the second operand of the division
   * @param x The first component of the vector part of the second operand of the division
   * @param y The second component of the vector part of the second operand of the division
   * @param z The third component of the vector part of the second operand of the division
   * @return The product of this quaternion by the reciprocal of the quaternion `w + xi + yj + zk`
   */
  def /(w: Double, x: Double, y: Double, z: Double): Quaternion = this / Quaternion(w, x, y, z)

  /**
   * Returns the product of this quaternion by the [[reciprocal]] of the quaternion `w + xi + yj + zk`.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param w The real/scalar part of the second operand of the division
   * @param x The first component of the vector part of the second operand of the division
   * @param y The second component of the vector part of the second operand of the division
   * @param z The third component of the vector part of the second operand of the division
   * @return The product of this quaternion by the reciprocal of the quaternion `w + xi + yj + zk`
   */
  def divide(w: Double, x: Double, y: Double, z: Double): Quaternion = this / (w, x, y, z)

  /**
   * Returns the exponential of this quaternion.
   *
   * @return The exponential of this quaternion
   */
  def exp: Quaternion = {
    val v = Vec3d(this.x, this.y, this.z)
    val length = v.length
    Quaternion(math.cos(length), v / v.length * math.sin(length)) * math.exp(this.w)
  }

  /**
   * Returns the logarithm of this quaternion.
   *
   * @return The logarithm of this quaternion
   */
  def log: Quaternion = {
    val v = Vec3d(this.x, this.y, this.z)
    val length = this.length
    Quaternion(math.log(length), v.normalized * math.acos(this.w / length))
  }

  /**
   * Returns this quaternion's rotation in the form of euler angles.
   *
   * The result is undefined if this quaternion is not [[normalized]].
   *
   * @return This quaternion's rotation in the form of euler angles
   */
  def euler: Vec3d = Vec3d(
    math.atan2(2.0 * (w * x + y * z), 1.0 - 2.0 * (x * x + y * y)),
    2.0 * math.atan2(1.0 + 2.0 * (w * y - x * z), 1.0 - 2.0 * (w * y - x * z)) - math.Pi / 2.0,
    math.atan2(2.0 * (w * z + x * y), 1.0 - 2.0 * (y * y + z * z))
  )

  /**
   * Returns the angle of the rotation represented by this unit quaternion.
   *
   * The result is undefined if this quaternion is not [[normalized]].
   *
   * @return The angle of the rotation represented by this unit quaternion
   */
  def angle: Double = 2.0 * math.acos(this.w)

  /**
   * Returns the axis this quaternion is rotating around.
   *
   * @return The axis this quaternion is rotating around
   */
  def axis: Vec3d = {
    val r = 1.0 / math.sqrt(1.0 - w * w);
    Vec3d(x * r, y * r, z * r)
  }

  /**
   * Returns the result of the spherical linear interpolation between this quaternion and the given one by the given weight.
   *
   * The result is undefined if the two quaternions are not [[normalized]].
   *
   * @param to The quaternion to interpolate towards
   * @param weight Weight of the interpolation
   * @return The spherical linear interpolation between this quaternion and the given one
   */
  def slerp(to: Quaternion, weight: Double): Quaternion = {
    val omega = math.acos(this dot to)
    val sinOmega = math.sin(omega)
    this * (math.sin((1.0 - weight) * omega) / sinOmega) + to * (math.sin(weight * omega) / sinOmega)
  }

  /**
   * Checks if the components of this quaternion are equal to the given ones.
   *
   * @param w The real/scalar part of the quaternion
   * @param x The first component of the vector part of the quaternion
   * @param y The second component of the vector part of the quaternion
   * @param z The third component of the vector part of the quaternion
   * @return True if the components of this quaternion equal the given ones, otherwise false
   */
  def ==(w: Double, x: Double, y: Double, z: Double): Boolean = this.w == w && this.x == x && this.y == y && this.z == z

  /**
   * Checks if the components of this quaternion are equal to the given ones.
   *
   * This method can be used in place of the '==' operator for better interoperability with Java.
   *
   * @param w The real/scalar part of the quaternion
   * @param x The first component of the vector part of the quaternion
   * @param y The second component of the vector part of the quaternion
   * @param z The third component of the vector part of the quaternion
   * @return True if the components of this quaternion equal the given ones, otherwise false
   */
  def equals(w: Double, x: Double, y: Double, z: Double): Boolean = this == (w, x, y, z)

  /**
   * Returns a string representation of this quaternion in the form `w + xi + yj + zk`.
   *
   * @return A string representation of this quaternion
   */
  override def toString: String = {
    val s = new StringBuilder(if (this.w == 0.0) "" else this.w.toString)
    if (this.x != 0.0) {
      if (s.nonEmpty) {
        s ++= (if (this.x >= 0.0) " + " else " - ")
      }
      s ++= this.x.abs + "i"
    }
    if (this.y != 0.0) {
      if (s.nonEmpty) {
        s ++= (if (this.y >= 0.0) " + " else " - ")
      }
      s ++= this.y.abs + "j"
    }
    if (this.z != 0.0) {
      if (s.nonEmpty) {
        s ++= (if (this.z >= 0.0) " + " else " - ")
      }
      s ++= this.z.abs + "k"
    }
    if (s.isEmpty) "0.0" else s.toString
  }
}

object Quaternion {

  /** Shorthand for `Quaternion(1.0, 0.0, 0.0, 0.0)` */
  val Identity: Quaternion = Quaternion(1.0, 0.0, 0.0, 0.0)
  /** Shorthand for `Quaternion(0.0, 0.0, 0.0, 0.0)` */
  val Zero: Quaternion = Quaternion(0.0, 0.0, 0.0, 0.0)

  /**
   * Constructs a quaternion from the given scalar part and the given vector part.
   *
   * Allows to use the syntax `Quaternion(w, v)` instead of `new Quaternion(w, v)` in scala.
   *
   * @param w The real/scalar part of the quaternion
   * @param v The vector part of the quaternion
   * @return The resulting quaternion
   */
  def apply(w: Double, v: Double3): Quaternion = new Quaternion(w, v)

  /**
   * Constructs a quaternion from the given euler angles.
   *
   * @param euler Euler angles
   * @return The resulting quaternion
   */
  def apply(euler: Vec3d): Quaternion = {
    val cr = math.cos(euler.x * 0.5)
    val sr = math.sin(euler.x * 0.5)
    val cp = math.cos(euler.y * 0.5)
    val sp = math.sin(euler.y * 0.5)
    val cy = math.cos(euler.z * 0.5)
    val sy = math.sin(euler.z * 0.5)
    Quaternion(
      cr * cp * cy + sr * sp * sy,
      sr * cp * cy - cr * sp * sy,
      cr * sp * cy + sr * cp * sy,
      cr * cp * sy - sr * sp * cy
    )
  }

  /**
   * Constructs a quaternion representing a rotation around the given axis of the given angle.
   *
   * @param axis The rotation axis
   * @param angle The rotation angle
   * @return The resulting quaternion
   */
  def apply(axis: Vec3d, angle: Double): Quaternion = {
    val s = math.sin(angle * 0.5)
    Quaternion(math.cos(angle * 0.5), axis.x * s, axis.y * s, axis.z * s)
  }

  /**
   * Constructs a quaternion representing the shortest arc between the two given unit vectors.
   *
   * The result is undefined if the two quaternions are not [[Quaternion.normalized]].
   *
   * @param from First vector
   * @param to Second vector
   * @return The resulting quaternion
   */
  def apply(from: Vec3d, to: Vec3d): Quaternion = {
    val c = from cross to
    val s = math.sqrt((1.0 + (from dot to)) * 2.0)
    Quaternion(s * 0.5, c.x / s, c.y / s, c.z / s)
  }

  /**
   * Allows to use the operators '*' and '/' with a scalar as `1.0 * quaternion` and `1.0 / quaternion`.
   *
   * @param l The scalar to which the quaternion is multiplied
   */
  implicit class MultiplicationExtender(val l: Double) extends AnyVal {

    /**
     * Returns the product between this scalar and the given quaternion.
     *
     * @param q The quaternion to which the scalar is multiplied
     * @return The result of the product between this scalar and the given quaternion
     */
    def *(q: Quaternion): Quaternion = q * l

    /**
     * Returns the product between this scalar and the [[Quaternion.reciprocal]] of the given quaternion.
     *
     * @param q The second operand of the division
     * @return The product of this scalar by the reciprocal of the given quaternion
     */
    def /(q: Quaternion): Quaternion = l * q.reciprocal
  }
}
