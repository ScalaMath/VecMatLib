package io.github.hexagonnico.vecmatlib.quaternion

import io.github.hexagonnico.vecmatlib.vector.Vec3d
import org.scalactic.Equality
import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class QuaternionDSuite extends AnyFunSuite {

  implicit val quaternion: Equality[QuaternionD] = (a: QuaternionD, b: Any) => b match {
    case b: QuaternionD =>
      math.abs(a.w - b.w) < 1e-9 &&
      math.abs(a.x - b.x) < 1e-9 &&
      math.abs(a.y - b.y) < 1e-9 &&
      math.abs(a.z - b.z) < 1e-9
    case _ => false
  }

  implicit val vec3d: Equality[Vec3d] = (a: Vec3d, b: Any) => b match {
    case b: Vec3d =>
      math.abs(a.x - b.x) < 1e-9 &&
      math.abs(a.y - b.y) < 1e-9 &&
      math.abs(a.z - b.z) < 1e-9
    case _ => false
  }

  test("Sum of a quaternion and four values") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    val p = q + (0.3, -1.5, 1.1, 0.0)
    assert(p === QuaternionD(1.5, -0.1, -1.0, 3.0))
  }

  test("Sum of two quaternions") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    val p = QuaternionD(0.3, -1.5, 1.1, 0.0)
    assert(q + p === QuaternionD(1.5, -0.1, -1.0, 3.0))
  }

  test("Additive inverse") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    assert(-q === QuaternionD(-1.2, -1.4, 2.1, -3.0))
  }

  test("Subtraction of a quaternion and four values") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    val p = q - (0.3, -1.5, 1.1, 0.0)
    assert(p === QuaternionD(0.9, 2.9, -3.2, 3.0))
  }

  test("Subtraction of two quaternions") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    val p = QuaternionD(0.3, -1.5, 1.1, 0.0)
    assert(q - p === QuaternionD(0.9, 2.9, -3.2, 3.0))
  }

  test("Quaternion multiplied by a scalar") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    assert(q * 1.2 === QuaternionD(1.44, 1.68, -2.52, 3.6))
  }

  test("Quaternion multiplied by four values") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    val p = q * (0.3, -1.5, 1.1, 0.0)
    assert(p === QuaternionD(4.77, -4.68, -3.81, -0.71))
  }

  test("Product of two quaternions") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    val p = QuaternionD(0.3, -1.5, 1.1, 0.0)
    assert(q * p === QuaternionD(4.77, -4.68, -3.81, -0.71))
  }

  test("Quaternion divided by a scalar") {
    val q = QuaternionD(1.5, 2.0, -2.5, 3.0)
    assert(q / 2.0 === QuaternionD(0.75, 1.0, -1.25, 1.5))
  }

  test("Quaternion divided by zero") {
    val q = QuaternionD.Identity
    val p = q / 0.0
    assert(p.w.isPosInfinity)
    assert(p.x.isNaN)
    assert(p.y.isNaN)
    assert(p.z.isNaN)
  }

  test("Conjugate") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    assert(q.conjugate === QuaternionD(1.2, -1.4, 2.1, -3.0))
  }

  test("Dot product between a quaternion and four values") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    val d = q dot (0.3, -1.5, 1.1, 0.0)
    assert(d === (-4.05 +- 1e-9))
  }

  test("Dot product between two quaternions") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    val p = QuaternionD(0.3, -1.5, 1.1, 0.0)
    assert((q dot p) === (-4.05 +- 1e-9))
  }

  test("Squared norm of a quaternion") {
    val q = QuaternionD(2.0, 2.0, -2.0, 2.0)
    assert(q.lengthSquared == 16.0)
  }

  test("Norm of a quaternion") {
    val q = QuaternionD(2.0, 2.0, -2.0, 2.0)
    assert(q.length == 4.0)
  }

  test("Normalized quaternion") {
    val q = QuaternionD(2.0, 2.0, -2.0, 2.0)
    assert(q.normalized === QuaternionD(0.5, 0.5, -0.5, 0.5))
  }

  test("Normalized zero quaternion") {
    val q = QuaternionD.Zero.normalized
    assert(q.w.isNaN)
    assert(q.x.isNaN)
    assert(q.y.isNaN)
    assert(q.z.isNaN)
  }

  test("Multiplicative inverse") {
    val q = QuaternionD(1.0, 0.0, 1.0, 0.0)
    assert(q.inverse === QuaternionD(0.5, 0.0, -0.5, 0.0))
  }

  test("Multiplicative inverse of the zero quaternion") {
    val q = QuaternionD.Zero.inverse
    assert(q.w.isNaN)
    assert(q.x.isNaN)
    assert(q.y.isNaN)
    assert(q.z.isNaN)
  }

  test("Quaternion divided by a quaternion") {
    val q = QuaternionD(1.0, 1.0, 1.0, 1.0)
    val p = QuaternionD(1.0, 0.0, 1.0, 0.0)
    assert(q / p === QuaternionD(1.0, 1.0, 0.0, 0.0))
  }

  test("Quaternion divided by the zero quaternion") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    val p = q / QuaternionD.Zero
    assert(p.w.isNaN)
    assert(p.x.isNaN)
    assert(p.y.isNaN)
    assert(p.z.isNaN)
  }

  test("Quaternion divided by four values") {
    val q = QuaternionD(1.0, 1.0, 1.0, 1.0)
    val p = q / (1.0, 0.0, 1.0, 0.0)
    assert(p === QuaternionD(1.0, 1.0, 0.0, 0.0))
  }

  test("Quaternion divided by four zeros") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    val p = q / (0.0, 0.0, 0.0, 0.0)
    assert(p.w.isNaN)
    assert(p.x.isNaN)
    assert(p.y.isNaN)
    assert(p.z.isNaN)
  }

  test("Quaternion exponential") {
    val q = QuaternionD(0.0, 0.0, 0.7854, 0.0)
    assert(q.exp === QuaternionD(0.7071054825112363, 0.0, 0.7071080798594735, 0.0))
  }

  test("Quaternion logarithm") {
    val q = QuaternionD(1.0, 0.0, 1.0, 0.0).normalized
    assert(q.log === QuaternionD(0.0, 0.0, 0.7853981633974483, 0.0))
  }

  test("Euler angles from quaternion") {
    assert(QuaternionD(0.5, 0.5, 0.5, 0.5).euler == Vec3d(math.Pi * 0.5, 0.0, math.Pi * 0.5))
  }

  test("Rotation angle from quaternion") {
    val q = QuaternionD(0.5, 1.0, 1.0, 1.0)
    assert(q.angle === 2.0 * math.Pi / 3.0 +- 1e-9)
  }

  test("Rotation axis from quaternion") {
    val v = Vec3d(0.5, 0.5, 0.5)
    val q = QuaternionD(1.5, v)
    assert(q.vector.normalized == v.normalized)
  }

  test("Quaternion equals four values") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    assert(q == (1.2, 1.4, -2.1, 3.0))
  }

  test("Quaternion to string") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    assert(q.toString == "1.2 + 1.4i - 2.1j + 3.0k")
  }

  test("Imaginary quaternion to string") {
    val q = QuaternionD(0.0, 1.4, -2.1, 3.0)
    assert(q.toString == "1.4i - 2.1j + 3.0k")
  }

  test("XZ quaternion to string") {
    val q = QuaternionD(0.0, 1.4, 0.0, 3.0)
    assert(q.toString == "1.4i + 3.0k")
  }

  test("Zero quaternion to string") {
    assert(QuaternionD.Zero.toString == "0.0")
  }

  test("Quaternion from euler angles") {
    val v = Vec3d(math.Pi * 0.5, 0.0, math.Pi * 0.5)
    val q = QuaternionD(v)
    assert(q === QuaternionD(0.5, 0.5, 0.5, 0.5))
  }

  test("Scalar multiplied by a quaternion") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    assert((1.2 * q) === QuaternionD(1.44, 1.68, -2.52, 3.6))
  }

  test("Scalar divided by a quaternion") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    assert((2.0 / q) === (q.inverse * 2.0))
  }
}