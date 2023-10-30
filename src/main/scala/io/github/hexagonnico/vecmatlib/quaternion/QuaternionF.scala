package io.github.hexagonnico.vecmatlib.quaternion

import io.github.hexagonnico.vecmatlib.{Float3, Float4}
import io.github.hexagonnico.vecmatlib.vector.{Vec3d, Vec3f}

/**
 * Class that represents a single-precision float quaternion.
 *
 * @constructor Constructs a quaternion from the four given values
 * @param w The real/scalar part of the quaternion
 * @param x The first component of the vector part (imaginary 'i' axis)
 * @param y The second component of the vector part (imaginary 'j' axis)
 * @param z The third component of the vector part (imaginary 'k' axis)
 */
case class QuaternionF(w: Float, x: Float, y: Float, z: Float) extends Quaternion[Float, Vec3f, QuaternionF] with Float4 {

  /**
   * Constructs a quaternion from the given scalar part and the given vector part
   *
   * @param w The real/scalar part of the quaternion
   * @param v The vector part of the quaternion
   */
  def this(w: Float, v: Float3) = this(w, v.x, v.y, v.z)

  /**
   * Returns the sum between this quaternion and the quaternion `w + xi + yj + zk`.
   *
   * @param w The real/scalar part of the quaternion to add
   * @param x The first component of the vector part of the quaternion to add
   * @param y The second component of the vector part of the quaternion to add
   * @param z The third component of the vector part of the quaternion to add
   * @return The sum of this quaternion and the one with the quaternion `w + xi + yj + zk`
   */
  override def +(w: Float, x: Float, y: Float, z: Float): QuaternionF = QuaternionF(this.w + w, this.x + x, this.y + y, this.z + z)

  /**
   * Returns the additive inverse of this quaternion.
   *
   * @return The additive inverse of this quaternion
   */
  override def unary_-(): QuaternionF = QuaternionF(-this.w, -this.x, -this.y, -this.z)

  /**
   * Returns the subtraction between this quaternion and the quaternion `w + xi + yj + zk`.
   *
   * @param w The real/scalar part of the quaternion to subtract
   * @param x The first component of the vector part of the quaternion to subtract
   * @param y The second component of the vector part of the quaternion to subtract
   * @param z The third component of the vector part of the quaternion to subtract
   * @return The subtract of the quaternion `w + xi + yj + zk` from this one
   */
  override def -(w: Float, x: Float, y: Float, z: Float): QuaternionF = QuaternionF(this.w - w, this.x - x, this.y - y, this.z - z)

  /**
   * Returns the product between this quaternion and the given scalar.
   *
   * @param l The scalar to which the quaternion is multiplied
   * @return The result of the product between this quaternion and the given scalar
   */
  override def *(l: Float): QuaternionF = QuaternionF(this.w * l, this.x * l, this.y * l, this.z * l)

  /**
   * Returns the product between this quaternion and the quaternion `w + xi + yj + zk` as defined by the Hamilton product.
   *
   * @param w The real/scalar part of the second operand of the multiplication
   * @param x The first component of the vector part of the second operand of the multiplication
   * @param y The second component of the vector part of the second operand of the multiplication
   * @param z The third component of the vector part of the second operand of the multiplication
   * @return The product between this quaternion and the quaternion `w + xi + yj + zk`
   */
  override def *(w: Float, x: Float, y: Float, z: Float): QuaternionF = QuaternionF(
    this.w * w - this.x * x - this.y * y - this.z * z,
    this.w * x + this.x * w + this.y * z - this.z * y,
    this.w * y - this.x * z + this.y * w + this.z * x,
    this.w * z + this.x * y - this.y * x + this.z * w
  )

  /**
   * Returns the result of dividing this quaternion by the given scalar.
   *
   * @param l The scalar by which this quaternion is divided
   * @return The result of the division of this quaternion by the given scalar
   */
  override def /(l: Float): QuaternionF = QuaternionF(this.w / l, this.x / l, this.y / l, this.z / l)

  /**
   * Returns the conjugate of this quaternion.
   * The conjugate of a quaternion `w + xi + yj + zk` is the quaternion `w - xi - yj - zk`.
   *
   * @return The conjugate of this quaternion
   */
  override def conjugate: QuaternionF = QuaternionF(this.w, -this.x, -this.y, -this.z)

  /**
   * Returns the result of the dot product (or scalar product) between this quaternion and the quaternion `w + xi + yj + zk`.
   *
   * @param w The real/scalar part of the second operand of the product
   * @param x The first component of the vector part of the second operand of the product
   * @param y The second component of the vector part of the second operand of the product
   * @param z The third component of the vector part of the second operand of the product
   * @return The result of the dot product between this quaternion and the quaternion `w + xi + yj + zk`
   */
  override def dot(w: Float, x: Float, y: Float, z: Float): Float = this.w * w + this.x * x + this.y * y + this.z * z

  /**
   * Returns the squared length (or squared norm) of this quaternion.
   *
   * @return The squared norm of this quaternion
   */
  override def lengthSquared: Float = this dot this

  /**
   * Returns the length (or norm) of this quaternion.
   *
   * @return The norm of this quaternion
   */
  override def length: Double = math.sqrt(this.lengthSquared)

  /**
   * Returns this quaternion as a unit quaternion.
   * That is, this quaternion divided by its norm or [[length]].
   *
   * @return This quaternion as a unit quaternion
   */
  override def normalized: QuaternionF = this / this.length.toFloat

  /**
   * Returns the product of this quaternion by the [[reciprocal]] of the quaternion `w + xi + yj + zk`.
   *
   * @param w The real/scalar part of the second operand of the division
   * @param x The first component of the vector part of the second operand of the division
   * @param y The second component of the vector part of the second operand of the division
   * @param z The third component of the vector part of the second operand of the division
   * @return The product of this quaternion by the reciprocal of the quaternion `w + xi + yj + zk`
   */
  override def /(w: Float, x: Float, y: Float, z: Float): QuaternionF = this / QuaternionF(w, x, y, z)

  /**
   * Returns the exponential of this quaternion.
   *
   * @return The exponential of this quaternion
   */
  override def exp: QuaternionF = {
    val v = Vec3d(this.x, this.y, this.z)
    val length = v.length
    (QuaternionD(math.cos(length), v / v.length * math.sin(length)) * math.exp(this.w)).toFloat
  }

  /**
   * Returns the logarithm of this quaternion.
   *
   * @return The logarithm of this quaternion
   */
  override def log: QuaternionF = {
    val v = Vec3d(this.x, this.y, this.z)
    val length = this.length
    QuaternionD(math.log(length), v.normalized * math.acos(this.w / length)).toFloat
  }

  /**
   * Returns this quaternion's rotation in the form of euler angles.
   *
   * The result is undefined if this quaternion is not [[normalized]].
   *
   * @return This quaternion's rotation in the form of euler angles
   */
  override def euler: Vec3f = Vec3d(
    math.atan2(2.0 * (w * x + y * z), 1.0 - 2.0 * (x * x + y * y)),
    2.0 * math.atan2(1.0 + 2.0 * (w * y - x * z), 1.0 - 2.0 * (w * y - x * z)) - math.Pi / 2.0,
    math.atan2(2.0 * (w * z + x * y), 1.0 - 2.0 * (y * y + z * z))
  ).toFloat

  /**
   * Returns the angle of the rotation represented by this unit quaternion.
   *
   * The result is undefined if this quaternion is not [[normalized]].
   *
   * @return The angle of the rotation represented by this unit quaternion
   */
  override def angle: Double = 2.0 * math.acos(this.w)

  /**
   * Returns the axis this quaternion is rotating around.
   *
   * @return The axis this quaternion is rotating around
   */
  override def axis: Vec3f = {
    val r = 1.0f / math.sqrt(1.0 - w * w).toFloat
    Vec3f(x * r, y * r, z * r)
  }

  /**
   * Returns that is, this quaternion divided by its norm or [[length]].
   *
   * @return A unit quaternion
   */
  override def slerp(to: QuaternionF, weight: Float): QuaternionF = {
    val omega = math.acos(this dot to).toFloat
    val sinOmega = math.sin(omega).toFloat
    this * (math.sin((1.0 - weight) * omega).toFloat / sinOmega) + to * (math.sin(weight * omega).toFloat / sinOmega)
  }

  /**
   * Converts this quaternion to a double quaternion.
   *
   * @return This same quaternion as a double quaternion
   */
  def toDouble: QuaternionD = QuaternionD(this.w, this.x, this.y, this.z)

  /**
   * Returns a string representation of this quaternion in the form `w + xi + yj + zk`.
   *
   * @return A string representation of this quaternion
   */
  override def toString: String = {
    val s = new StringBuilder(if (this.w == 0.0f) "" else this.w.toString)
    if (this.x != 0.0f) {
      if (s.nonEmpty) {
        s ++= (if (this.x >= 0.0f) " + " else " - ")
      }
      s ++= f"${this.x.abs}i"
    }
    if (this.y != 0.0f) {
      if (s.nonEmpty) {
        s ++= (if (this.y >= 0.0f) " + " else " - ")
      }
      s ++= f"${this.y.abs}j"
    }
    if (this.z != 0.0f) {
      if (s.nonEmpty) {
        s ++= (if (this.z >= 0.0f) " + " else " - ")
      }
      s ++= f"${this.z.abs}k"
    }
    if (s.isEmpty) "0.0" else s.toString
  }
}

object QuaternionF {

  /** Shorthand for `QuaternionF(1.0f, 0.0f, 0.0f, 0.0f)` */
  val Identity: QuaternionF = QuaternionF(1.0f, 0.0f, 0.0f, 0.0f)
  /** Shorthand for `QuaternionF(0.0f, 0.0f, 0.0f, 0.0f)` */
  val Zero: QuaternionF = QuaternionF(0.0f, 0.0f, 0.0f, 0.0f)

  /**
   * Constructs a quaternion from the given scalar part and the given vector part.
   *
   * Allows to use the syntax `QuaternionF(w, v)` instead of `new QuaternionF(w, v)` in scala.
   *
   * @param w The real/scalar part of the quaternion
   * @param v The vector part of the quaternion
   * @return The resulting quaternion
   */
  def apply(w: Float, v: Float3): QuaternionF = new QuaternionF(w, v)

  /**
   * Constructs a quaternion from the given euler angles.
   *
   * @param euler Euler angles
   * @return The resulting quaternion
   */
  def apply(euler: Vec3f): QuaternionF = apply(euler.toDouble)

  /**
   * Constructs a quaternion from the given euler angles.
   *
   * @param euler Euler angles
   * @return The resulting quaternion
   */
  def apply(euler: Vec3d): QuaternionF = {
    val cr = math.cos(euler.x * 0.5)
    val sr = math.sin(euler.x * 0.5)
    val cp = math.cos(euler.y * 0.5)
    val sp = math.sin(euler.y * 0.5)
    val cy = math.cos(euler.z * 0.5)
    val sy = math.sin(euler.z * 0.5)
    QuaternionD(
      cr * cp * cy + sr * sp * sy,
      sr * cp * cy - cr * sp * sy,
      cr * sp * cy + sr * cp * sy,
      cr * cp * sy - sr * sp * cy
    ).toFloat
  }

  /**
   * Constructs a quaternion representing a rotation around the given axis of the given angle.
   *
   * @param axis  The rotation axis
   * @param angle The rotation angle
   * @return The resulting quaternion
   */
  def apply(axis: Vec3f, angle: Float): QuaternionF = apply(axis.toDouble, angle)

  /**
   * Constructs a quaternion representing a rotation around the given axis of the given angle.
   *
   * @param axis  The rotation axis
   * @param angle The rotation angle
   * @return The resulting quaternion
   */
  def apply(axis: Vec3d, angle: Double): QuaternionF = {
    val s = math.sin(angle * 0.5)
    QuaternionD(math.cos(angle * 0.5), axis.x * s, axis.y * s, axis.z * s).toFloat
  }

  /**
   * Constructs a quaternion representing the shortest arc between the two given unit vectors.
   *
   * The result is undefined if the two quaternions are not [[Quaternion.normalized]].
   *
   * @param from First vector
   * @param to   Second vector
   * @return The resulting quaternion
   */
  def apply(from: Vec3f, to: Vec3f): QuaternionF = apply(from.toDouble, to.toDouble)

  /**
   * Constructs a quaternion representing the shortest arc between the two given unit vectors.
   *
   * The result is undefined if the two quaternions are not [[Quaternion.normalized]].
   *
   * @param from First vector
   * @param to   Second vector
   * @return The resulting quaternion
   */
  def apply(from: Vec3d, to: Vec3d): QuaternionF = {
    val c = from cross to
    val s = math.sqrt((1.0 + (from dot to)) * 2.0)
    QuaternionD(s * 0.5, c.x / s, c.y / s, c.z / s).toFloat
  }

  /**
   * Allows to use the operators '*' and '/' with a scalar as `1.0 * quaternion` and `1.0 / quaternion`.
   *
   * @param l The scalar to which the quaternion is multiplied
   */
  implicit class MultiplicationExtender(val l: Float) extends AnyVal {

    /**
     * Returns the product between this scalar and the given quaternion.
     *
     * @param q The quaternion to which the scalar is multiplied
     * @return The result of the product between this scalar and the given quaternion
     */
    def *(q: QuaternionF): QuaternionF = q * l

    /**
     * Returns the product between this scalar and the [[Quaternion.reciprocal]] of the given quaternion.
     *
     * @param q The second operand of the division
     * @return The product of this scalar by the reciprocal of the given quaternion
     */
    def /(q: QuaternionF): QuaternionF = l * q.reciprocal
  }
}