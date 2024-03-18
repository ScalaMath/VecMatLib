package io.github.hexagonnico.vecmatlib.quaternion

import io.github.hexagonnico.vecmatlib
import io.github.hexagonnico.vecmatlib.DoubleEqualsApprox
import io.github.hexagonnico.vecmatlib.vector.Vec3f

/**
 * A single-precision quaternion.
 * Can be used to represent a 3D rotation.
 *
 * @constructor Constructs a quaternion from the given components.
 * @param w The real/scalar part of the quaternion.
 * @param x The first component of the vector part (imaginary `i` axis).
 * @param y The second component of the vector part (imaginary `j` axis).
 * @param z The third component of the vector part (imaginary `k` axis).
 */
case class Quatf(w: Float, x: Float, y: Float, z: Float) {

  /**
   * Constructs a quaternion from the given real part and vector part.
   *
   * @param w The real/scalar part of the quaternion.
   * @param v The vector part of the quaternion.
   */
  def this(w: Float, v: Vec3f) = this(w, v.x, v.y, v.z)

  /**
   * Constructs a quaternion that represents a rotation around the given axis by the specified angle.
   * The given axis must be normalized.
   *
   * @param axis The rotation axis. Must be normalized.
   * @param angle The rotation angle in radians.
   */
  def this(axis: Vec3f, angle: Double) = this(math.cos(angle).toFloat, axis * math.sin(angle).toFloat / axis.length)

  /**
   * Computes the sum between this quaternion and the given values and returns the result.
   *
   * @param w The w component to add.
   * @param x The x component to add.
   * @param y The y component to add.
   * @param z The z component to add.
   * @return The sum of this quaternion and the given values.
   */
  def +(w: Float, x: Float, y: Float, z: Float): Quatf = Quatf(this.w + w, this.x + x, this.y + y, this.z + z)

  /**
   * Computes the sum between this quaternion and the given values and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param w The w component to add.
   * @param x The x component to add.
   * @param y The y component to add.
   * @param z The z component to add.
   * @return The sum of this quaternion and the given values.
   */
  def plus(w: Float, x: Float, y: Float, z: Float): Quatf = this + (w, x, y, z)

  /**
   * Computes the sum between this quaternion and the given one and returns the result.
   *
   * @param q The quaternion to add.
   * @return The sum of this quaternion and the given one.
   */
  def +(q: Quatf): Quatf = this + (q.w, q.x, q.y, q.z)

  /**
   * Computes the sum between this quaternion and the given one and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param q The quaternion to add.
   * @return The sum of this quaternion and the given one.
   */
  def plus(q: Quatf): Quatf = this + q

  /**
   * Returns this same quaternion.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This quaternion.
   */
  def unary_+(): Quatf = this

  /**
   * Computes the subtraction of the given values from this quaternion and returns the result.
   *
   * @param w The w component to subtract.
   * @param x The x component to subtract.
   * @param y The y component to subtract.
   * @param z The z component to subtract.
   * @return The subtraction of the given values from this quaternion
   */
  def -(w: Float, x: Float, y: Float, z: Float): Quatf = Quatf(this.w - w, this.x - x, this.y - y, this.z - z)

  /**
   * Computes the subtraction of the given values from this quaternion and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param w The w component to subtract.
   * @param x The x component to subtract.
   * @param y The y component to subtract.
   * @param z The z component to subtract.
   * @return The subtraction of the given values from this quaternion
   */
  def minus(w: Float, x: Float, y: Float, z: Float): Quatf = this - (w, x, y, z)

  /**
   * Computes the subtraction of the given quaternion from this one and returns the result.
   *
   * @param q The quaternion to subtract.
   * @return The subtraction of the given quaternion from this one.
   */
  def -(q: Quatf): Quatf = this - (q.w, q.x, q.z, q.y)

  /**
   * Computes the subtraction of the given quaternion from this one and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param q The quaternion to subtract.
   * @return The subtraction of the given quaternion from this one.
   */
  def minus(q: Quatf): Quatf = this - q

  /**
   * Returns the additive inverse of this quaternion.
   *
   * @return The additive inverse of this quaternion.
   */
  def unary_-(): Quatf = Quatf(-this.w, -this.x, -this.y, -this.z)

  /**
   * Returns the additive inverse of this quaternion.
   *
   * This method can be used in place of the unary `-` operator for better interoperability with Java.
   *
   * @return The additive inverse of this quaternion.
   */
  def negated: Quatf = -this

  /**
   * Multiplies this quaternion by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this quaternion by.
   * @return The product of this quaternion by the given scalar.
   */
  def *(k: Float): Quatf = Quatf(this.w * k, this.x * k, this.y * k, this.z * k)

  /**
   * Multiplies this quaternion by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this quaternion by.
   * @return The product of this quaternion by the given scalar.
   */
  def multipliedBy(k: Float): Quatf = this * k

  /**
   * Divides this quaternion by the given scalar and returns the result.
   *
   * @param k The scalar to divide this quaternion by.
   * @return The division of this quaternion by the given scalar.
   */
  def /(k: Float): Quatf = Quatf(this.w / k, this.x / k, this.y / k, this.z / k)

  /**
   * Divides this quaternion by the given scalar and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this quaternion by.
   * @return The division of this quaternion by the given scalar.
   */
  def dividedBy(k: Float): Quatf = this / k

  /**
   * Multiplies this quaternion by the given values as defined by the Hamilton product and returns the result.
   *
   * @param w The real/scalar part of the quaternion to multiply this one by.
   * @param x The x component of the vector part of the quaternion to multiply this one by.
   * @param y The y component of the vector part of the quaternion to multiply this one by.
   * @param z The z component of the vector part of the quaternion to multiply this one by.
   * @return The product of this quaternion by the given values.
   */
  def *(w: Float, x: Float, y: Float, z: Float): Quatf = Quatf(
    this.w * w - this.x * x - this.y * y - this.z * z,
    this.w * x + this.x * w + this.y * z - this.z * y,
    this.w * y - this.x * z + this.y * w + this.z * x,
    this.w * z + this.x * y - this.y * x + this.z * w
  )

  /**
   * Multiplies this quaternion by the given values as defined by the Hamilton product and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param w The real/scalar part of the quaternion to multiply this one by.
   * @param x The x component of the vector part of the quaternion to multiply this one by.
   * @param y The y component of the vector part of the quaternion to multiply this one by.
   * @param z The z component of the vector part of the quaternion to multiply this one by.
   * @return The product of this quaternion by the given values.
   */
  def multiply(w: Float, x: Float, y: Float, z: Float): Quatf = this * (w, x, y, z)

  /**
   * Multiplies this quaternion by the given one as defined by the Hamilton product and returns the result.
   *
   * @param q The quaternion to multiply this one by.
   * @return The product between this quaternion and the given one.
   */
  def *(q: Quatf): Quatf = this * (q.w, q.x, q.y, q.z)

  /**
   * Multiplies this quaternion by the given one as defined by the Hamilton product and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param q The quaternion to multiply this one by.
   * @return The product between this quaternion and the given one.
   */
  def multiply(q: Quatf): Quatf = this * q

  /**
   * Returns the conjugate of this quaternion.
   * The conjugate of a quaternion `w + xi + yj + zk` is the quaternion `w - xi - yj - zk`.
   *
   * @return The conjugate of this quaternion.
   */
  def conjugate: Quatf = Quatf(this.w, -this.x, -this.y, -this.z)

  /**
   * Computes the dot product between this quaternion and the given values and returns the result.
   *
   * @param w The w component of the second quaternion.
   * @param x The x component of the second quaternion.
   * @param y The y component of the second quaternion.
   * @param z The z component of the second quaternion.
   * @return The dot product between this quaternion and the given values.
   */
  def dot(w: Float, x: Float, y: Float, z: Float): Float = this.w * w + this.x * x + this.y * y + this.z * z

  /**
   * Computes the dot product between this quaternion and the given one and returns the result.
   *
   * @param q The second quaternion.
   * @return The dot product between this quaternion and the given one.
   */
  def dot(q: Quatf): Float = this.dot(q.w, q.x, q.y, q.z)

  /**
   * Returns the squared length, or squared norm, of this quaternion.
   *
   * When comparing quaternions by their length, it is more efficient to compare them by their squared length, since computing it does not require a square root.
   *
   * @return The squared length of this quaternion.
   * @see [[length]]
   */
  def lengthSquared: Float = this.dot(this)

  /**
   * Returns the length, or norm, of this quaternion.
   *
   * @return The length of this quaternion.
   * @see [[lengthSquared]]
   */
  def length: Float = math.sqrt(this.lengthSquared).toFloat

  /**
   * Returns the result of scaling this quaternion to unit length.
   * Equivalent to `q / q.length`.
   *
   * Only unit quaternions represent a rotation.
   *
   * The result will be NaN if this quaternion is the zero quaternion.
   *
   * @return The result of scaling this quaternion to unit length.
   * @see [[isNormalized]]
   */
  def normalized: Quatf = this / this.length

  /**
   * Checks if this quaternion is a unit quaternion, i.e. its length is approximately equal to `1.0`.
   *
   * @return True if this quaternion is normalized, otherwise false.
   */
  def isNormalized: Boolean = this.lengthSquared ~= 1.0f

  /**
   * Returns the multiplicative inverse of this quaternion.
   *
   * @return The multiplicative inverse of this quaternion.
   */
  def inverse: Quatf = this.conjugate / this.lengthSquared

  /**
   * Multiplies this quaternion by the [[inverse]] of the given one as defined by the Hamilton product and returns the result.
   *
   * @param q The quaternion to divide this one by.
   * @return The product between this quaternion and the inverse of the given one.
   */
  def /(q: Quatf): Quatf = this * q.inverse

  /**
   * Multiplies this quaternion by the [[inverse]] of the given one as defined by the Hamilton product and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param q The quaternion to divide this one by.
   * @return The product between this quaternion and the inverse of the given one.
   */
  def divide(q: Quatf): Quatf = this / q

  /**
   * Divides this quaternion by the given values as defined by the Hamilton product and returns the result.
   *
   * @param w The real/scalar part of the quaternion to divide this one by.
   * @param x The x component of the vector part of the quaternion to divide this one by.
   * @param y The y component of the vector part of the quaternion to divide this one by.
   * @param z The z component of the vector part of the quaternion to divide this one by.
   * @return The division of this quaternion by the given values.
   */
  def /(w: Float, x: Float, y: Float, z: Float): Quatf = this / Quatf(w, x, y, z)

  /**
   * Divides this quaternion by the given values as defined by the Hamilton product and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param w The real/scalar part of the quaternion to divide this one by.
   * @param x The x component of the vector part of the quaternion to divide this one by.
   * @param y The y component of the vector part of the quaternion to divide this one by.
   * @param z The z component of the vector part of the quaternion to divide this one by.
   * @return The division of this quaternion by the given values.
   */
  def divide(w: Float, x: Float, y: Float, z: Float): Quatf = this / (w, x, y, z)

  /**
   * Returns the vector part of this quaternion.
   *
   * @return The vector part of this quaternion.
   */
  def vector: Vec3f = Vec3f(this.x, this.y, this.z)

  /**
   * Returns the angle of the rotation represented by this quaternion.
   *
   * @return The angle of the rotation represented by this quaternion.
   * @see [[axis]]
   */
  def angle: Double = 2.0 * math.acos(this.w)

  /**
   * Returns the axis of the rotation specified by this quaternion.
   *
   * @return The axis of the rotation specified by this quaternion.
   * @see [[angle]]
   */
  def axis: Vec3f = {
    if(math.abs(this.w) > 1.0 - vecmatlib.Epsilon) {
      this.vector
    } else {
      this.vector / math.sqrt(1.0f - this.w * this.w).toFloat
    }
  }

  /**
   * Returns the exponential of this quaternion.
   *
   * Returns the identity quaternion if this quaternion has no vector part.
   *
   * @return The exponential of this quaternion
   */
  def exp: Quatf = {
    val l = this.vector.length
    if (l > 0.0f) {
      math.exp(this.w).toFloat * Quatf(math.cos(l).toFloat, this.vector / l * math.sin(l).toFloat)
    } else {
      Quatf.Identity
    }
  }

  /**
   * Returns the natural logarithm of this quaternion.
   *
   * @return The natural logarithm of this quaternion.
   */
  def log: Quatf = {
    val n = this.length
    Quatf(math.log(n).toFloat, this.vector.normalized * math.acos(this.w / n).toFloat)
  }

  /**
   * Raises this quaternion to the power of the given exponent and returns the result.
   *
   * @param exp The exponent.
   * @return This quaternion to the power of the given exponent.
   */
  def pow(exp: Float): Quatf = (this.log * exp).exp

  /**
   * Returns the angle between this quaternion and the given one.
   * This is the magnitude of the angle you would need to rotate by to get from one to the other.
   *
   * @param q The second quaternion.
   * @return The angle between this quaternion and the given one.
   */
  def angleTo(q: Quatf): Double = {
    val d = this.dot(q)
    math.acos(d * d * 2.0f - 1.0f)
  }

  /**
   * Computes the spherical linear interpolation between this quaternion and the given one by the given weight and returns the result.
   *
   * The given weight must be in the `[0.0, 1.0]` range, representing the amount of interpolation.
   *
   * @param to The second quaternion.
   * @param weight The weight of the interpolation between `0.0` and `1.0`.
   * @return The result of the spherical linear interpolation between this quaternion and the given one by the given weight.
   */
  def slerp(to: Quatf, weight: Float): Quatf = (to * this.inverse).pow(weight) * this

  /**
   * Returns this quaternion's rotation in the form of euler angles.
   *
   * @param order The decomposing oder.
   * @return A [[Vec3f]] representing this quaternion's rotation in the form of euler angles.
   * @see [[EulerOrder]]
   */
  def euler(order: EulerOrder): Vec3f = order.toEulerAngles(this.toDouble).toFloat

  /**
   * Returns this quaternion's rotation in the form of euler angles using the `YXZ` convention.
   *
   * @return A [[Vec3f]] representing this quaternion's rotation in the form of euler angles.
   * @see [[EulerOrder]]
   */
  def euler: Vec3f = this.euler(EulerOrder.YXZ)

  /**
   * Checks if the components of this quaternion are equal to the given ones.
   *
   * @param w The real/scalar part of the quaternion.
   * @param x The first component of the vector part.
   * @param y The second component of the vector part.
   * @param z The third component of the vector part.
   * @return True if the components of this quaternion are equal to the given ones, otherwise false.
   */
  def ==(w: Float, x: Float, y: Float, z: Float): Boolean = this.w == w && this.x == x && this.y == y && this.z == z

  /**
   * Checks if the components of this quaternion are equal to the given ones.
   *
   * This method can be used in place of the `==` operator for better interoperability with Java.
   *
   * @param w The real/scalar part of the quaternion.
   * @param x The first component of the vector part.
   * @param y The second component of the vector part.
   * @param z The third component of the vector part.
   * @return True if the components of this quaternion are equal to the given ones, otherwise false.
   */
  def equals(w: Float, x: Float, y: Float, z: Float): Boolean = this == (w, x, y, z)

  /**
   * Checks if the components of this quaternion are approximately equal to the given ones using an internal epsilon.
   *
   * @param w The real/scalar part of the quaternion.
   * @param x The first component of the vector part.
   * @param y The second component of the vector part.
   * @param z The third component of the vector part.
   * @return True if the components of this quaternion are approximately equal to the given ones, otherwise false.
   * @see [[DoubleEqualsApprox]]
   */
  def ~=(w: Float, x: Float, y: Float, z: Float): Boolean = (this.w ~= w) && (this.x ~= x) && (this.y ~= y) && (this.z ~= z)

  /**
   * Checks if the components of this quaternion are approximately equal to the given ones using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator for better interoperability with Java.
   *
   * @param w The real/scalar part of the quaternion.
   * @param x The first component of the vector part.
   * @param y The second component of the vector part.
   * @param z The third component of the vector part.
   * @return True if the components of this quaternion are approximately equal to the given ones, otherwise false.
   * @see [[DoubleEqualsApprox]]
   */
  def equalsApprox(w: Float, x: Float, y: Float, z: Float): Boolean = this ~= (w, x, y, z)

  /**
   * Checks if this quaternion is approximately equal to the given one using an internal epsilon.
   *
   * @param q The second quaternion.
   * @return True if this quaternion is approximately equal to the given one, otherwise false.
   */
  def ~=(q: Quatf): Boolean = this ~= (q.w, q.x, q.y, q.z)

  /**
   * Checks if this quaternion is approximately equal to the given one using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator for better interoperability with Java.
   *
   * @param q The second quaternion.
   * @return True if this quaternion is approximately equal to the given one, otherwise false.
   */
  def equalsApprox(q: Quatf): Boolean = this ~= q

  /**
   * Access quaternion components using their index.
   *
   * Index `0` is equivalent to `w`, index `1` is equivalent to `x`, index 2 is equivalent to `y`, index `3` is equivalent to `z`.
   *
   * @param i The index of the requested component. Must be either 0, 1, 2, or 3.
   * @return The requested component.
   * @throws scala.MatchError if the given index is out of bounds.
   */
  def apply(i: Int): Float = i match {
    case 0 => this.w
    case 1 => this.x
    case 2 => this.y
    case 3 => this.z
  }

  /**
   * Converts this single-precision quaternion to a double-precision quaternion.
   *
   * @return A [[Quatd]] with the same value as this one.
   */
  def toDouble: Quatd = Quatd(this.w, this.x, this.y, this.z)
}

/**
 * Constants, implicits, and factory methods for quaternions.
 */
object Quatf {

  /** Shorthand for `Quatf(1.0f, 0.0f, 0.0f, 0.0f)` */
  val Identity: Quatf = Quatf(1.0f, 0.0f, 0.0f, 0.0f)

  /** Shorthand for `Quatf(0.0f, 0.0f, 0.0f, 0.0f)` */
  val Zero: Quatf = Quatf(0.0f, 0.0f, 0.0f, 0.0f)

  /**
   * Constructs a quaternion from the given real part and vector part.
   *
   * @param w The real/scalar part of the quaternion.
   * @param v The vector part of the quaternion.
   */
  def apply(w: Float, v: Vec3f): Quatf = new Quatf(w, v)

  /**
   * Constructs a quaternion that represents a rotation around the given axis by the specified angle.
   * The given axis must be normalized.
   *
   * @param axis The rotation axis. Must be normalized.
   * @param angle The rotation angle in radians.
   */
  def apply(axis: Vec3f, angle: Double): Quatf = new Quatf(axis, angle)

  /**
   * Constructs a quaternion from the given euler angles and rotation order.
   *
   * @param euler A [[Vec3f]] representing the quaternion's rotation in form of euler angles.
   * @param order The rotation order.
   * @return The quaternion constructed from the given euler angles and rotation order.
   */
  def fromEuler(euler: Vec3f, order: EulerOrder): Quatf = order.toQuaternion(euler).toFloat

  /**
   * Constructs a quaternion from the given euler angles and rotation order.
   *
   * @param x Rotation angle on the x axis.
   * @param y Rotation angle on the y axis.
   * @param z Rotation angle on the z axis.
   * @param order The rotation order.
   * @return The quaternion constructed from the given euler angles and rotation order.
   */
  def fromEuler(x: Float, y: Float, z: Float, order: EulerOrder): Quatf = order.toQuaternion(x, y, z).toFloat

  /**
   * Constructs a quaternion from the given euler angles in the `YXZ` order.
   *
   * @param euler A [[Vec3f]] representing the quaternion's rotation in form of euler angles.
   * @return The quaternion constructed from the given euler angles in the `YXZ` order.
   */
  def fromEuler(euler: Vec3f): Quatf = this.fromEuler(euler, EulerOrder.YXZ)

  /**
   * Constructs a quaternion from the given euler angles in the `YXZ` order.
   *
   * @param x Rotation angle on the x axis.
   * @param y Rotation angle on the y axis.
   * @param z Rotation angle on the z axis.
   * @return The quaternion constructed from the given euler angles in the `YXZ` order.
   */
  def fromEuler(x: Float, y: Float, z: Float): Quatf = this.fromEuler(x, y, z, EulerOrder.YXZ)

  /**
   * Constructs a quaternion representing the shortest arc between two points on the surface of a sphere with a radius of `1.0`.
   *
   * @param from The first point.
   * @param to The second point.
   * @return A quaternion representing the shortest arc between two points on the surface of a sphere with a radius of `1.0`.
   */
  def shortestArc(from: Vec3f, to: Vec3f): Quatf = {
    val dot = from.dot(to)
    if (dot < -1.0 + vecmatlib.Epsilon) {
      Quatf(0.0f, 0.0f, 1.0f, 0.0f)
    } else {
      val s = math.sqrt((1.0 + dot) * 2.0).toFloat
      Quatf(s * 0.5f, from.cross(to) / s)
    }
  }

  /**
   * Allows to use the operators '*' and '/' with a scalar as `1.0 * quaternion` and `1.0 / quaternion`.
   *
   * @param self The scalar to which the quaternion is multiplied
   */
  implicit class MultiplicationExtender(val self: Float) extends AnyVal {

    /**
     * Returns the product between this scalar and the given quaternion.
     *
     * @param q The quaternion to which the scalar is multiplied
     * @return The result of the product between this scalar and the given quaternion
     */
    def *(q: Quatf): Quatf = q * self

    /**
     * Returns the product between this scalar and the inverse of the given quaternion.
     *
     * @param q The second operand of the division
     * @return The product of this scalar by the inverse of the given quaternion
     */
    def /(q: Quatf): Quatf = self * q.inverse
  }

  /**
   * Implicit conversion from float quaternion to double quaternion.
   */
  implicit val toDouble: Quatf => Quatd = q => q.toDouble
}