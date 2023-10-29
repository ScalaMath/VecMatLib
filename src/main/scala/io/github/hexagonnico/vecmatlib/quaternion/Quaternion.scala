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

  def +(w: Double, x: Double, y: Double, z: Double): Quaternion = Quaternion(this.w + w, this.x + x, this.y + y, this.z + z)

  def plus(w: Double, x: Double, y: Double, z: Double): Quaternion = this + (w, x, y, z)

  def +(q: Quaternion): Quaternion = this + (q.w, q.x, q.y, q.z)

  def plus(q: Quaternion): Quaternion = this + q

  def unary_-(): Quaternion = Quaternion(-this.w, -this.x, -this.y, -this.z)

  def negated: Quaternion = -this

  def -(w: Double, x: Double, y: Double, z: Double): Quaternion = Quaternion(this.w - w, this.x - x, this.y - y, this.z - z)

  def minus(w: Double, x: Double, y: Double, z: Double): Quaternion = this - (w, x, y, z)

  def -(q: Quaternion): Quaternion = this - (q.w, q.x, q.y, q.z)

  def minus(q: Quaternion): Quaternion = this - q

  def *(l: Double): Quaternion = Quaternion(this.w * l, this.x * l, this.y * l, this.z * l)

  def multipliedBy(k: Double): Quaternion = this * k

  def *(w: Double, x: Double, y: Double, z: Double): Quaternion = Quaternion(
    this.w * w - this.x * x - this.y * y - this.z * z,
    this.w * x + this.x * w + this.y * z - this.z * y,
    this.w * y - this.x * z + this.y * w + this.z * x,
    this.w * z + this.x * y - this.y * x + this.z * w
  )

  def multiply(w: Double, x: Double, y: Double, z: Double): Quaternion = this * (w, x, y, z)

  def *(q: Quaternion): Quaternion = this * (q.w, q.x, q.y, q.z)

  def multiply(q: Quaternion): Quaternion = this * q

  def /(l: Double): Quaternion = Quaternion(this.w / l, this.x / l, this.y / l, this.z / l)

  def dividedBy(l: Double): Quaternion = this / l

  def conjugate: Quaternion = Quaternion(this.w, -this.x, -this.y, -this.z)

  def dot(w: Double, x: Double, y: Double, z: Double): Double = this.w * w + this.x * x + this.y * y + this.z * z

  def dot(q: Quaternion): Double = this dot (q.w, q.x, q.y, q.z)

  def lengthSquared: Double = this dot this

  def length: Double = math.sqrt(this.lengthSquared)

  def normalized: Quaternion = this / this.length

  def inverse: Quaternion = this.conjugate / this.lengthSquared

  def /(q: Quaternion): Quaternion = this * q.inverse

  def divide(q: Quaternion): Quaternion = this / q

  def /(w: Double, x: Double, y: Double, z: Double): Quaternion = this / Quaternion(w, x, y, z)

  def divide(w: Double, x: Double, y: Double, z: Double): Quaternion = this / (w, x, y, z)

  def exp: Double = {
    val v = Vec3d(this.x, this.y, this.z)
    val length = v.length
    math.exp(this.w) * (math.cos(length) + v / v.length * math.sin(length))
  }

  def log: Double = {
    val v = Vec3d(this.x, this.y, this.z)
    val length = this.length
    math.log(length) + v.normalized * math.acos(this.w / length)
  }

  def euler: Vec3d = Vec3d(
    math.atan2(2.0 * (w * x + y * z), 1.0 - 2.0 * (x * x + y * y)),
    2.0 * math.atan2(1.0 + 2.0 * (w * y - x * z), 1.0 - 2.0 * (w * y - x * z)) - math.Pi / 2.0,
    math.atan2(2.0 * (w * z + x * y), 1.0 - 2.0 * (y * y + z * z))
  )

  def angle: Double = 2.0 * math.acos(this.w)

  def axis: Vec3d = {
    val r = 1.0 / math.sqrt(1.0 - w * w);
    Vec3d(x * r, y * r, z * r)
  }

  def slerp(to: Quaternion, weight: Double): Quaternion = {
    val omega = math.acos(this dot to)
    val sinOmega = math.sin(omega)
    this * (math.sin((1.0 - weight) * omega) / sinOmega) + to * (math.sin(weight * omega) / sinOmega)
  }
}

object Quaternion {

  val Identity: Quaternion = Quaternion(1.0, 0.0, 0.0, 0.0)

  val Zero: Quaternion = Quaternion(0.0, 0.0, 0.0, 0.0)

  def apply(w: Double, v: Double3): Quaternion = new Quaternion(w, v)

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

  def apply(axis: Vec3d, angle: Double): Quaternion = {
    val s = math.sin(angle * 0.5)
    Quaternion(math.cos(angle * 0.5), axis.x * s, axis.y * s, axis.z * s)
  }

  def apply(from: Vec3d, to: Vec3d): Quaternion = {
    val c = from cross to
    val s = math.sqrt((1.0 + (from dot to)) * 2.0)
    Quaternion(s * 0.5, c.x / s, c.y / s, c.z / s)
  }

  implicit class MultiplicationExtender(val k: Double) extends AnyVal {

    def *(q: Quaternion): Quaternion = q * k

    def /(q: Quaternion): Quaternion = k * q.inverse
  }
}