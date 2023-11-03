package io.github.hexagonnico.vecmatlib.quaternion

import io.github.hexagonnico.vecmatlib.vector.{Vec3d, Vec3f}
import org.scalactic.Equality
import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class QuaternionFSuite extends AnyFunSuite {

  implicit val quaternion: Equality[QuaternionF] = (a: QuaternionF, b: Any) => b match {
    case b: QuaternionF =>
      math.abs(a.w - b.w) < 1e-6 &&
      math.abs(a.x - b.x) < 1e-6 &&
      math.abs(a.y - b.y) < 1e-6 &&
      math.abs(a.z - b.z) < 1e-6
    case _ => false
  }

  implicit val vec3d: Equality[Vec3d] = (a: Vec3d, b: Any) => b match {
    case b: Vec3d =>
      math.abs(a.x - b.x) < 1e-6 &&
      math.abs(a.y - b.y) < 1e-6 &&
      math.abs(a.z - b.z) < 1e-6
    case _ => false
  }

  test("Sum of a quaternion and four values") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    val p = q + (0.3f, -1.5f, 1.1f, 0.0f)
    assert(p === QuaternionF(1.5f, -0.1f, -1.0f, 3.0f))
  }

  test("Sum of two quaternions") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    val p = QuaternionF(0.3f, -1.5f, 1.1f, 0.0f)
    assert(q + p === QuaternionF(1.5f, -0.1f, -1.0f, 3.0f))
  }

  test("Additive inverse") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    assert(-q === QuaternionF(-1.2f, -1.4f, 2.1f, -3.0f))
  }

  test("Subtraction of a quaternion and four values") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    val p = q - (0.3f, -1.5f, 1.1f, 0.0f)
    assert(p === QuaternionF(0.9f, 2.9f, -3.2f, 3.0f))
  }

  test("Subtraction of two quaternions") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    val p = QuaternionF(0.3f, -1.5f, 1.1f, 0.0f)
    assert(q - p === QuaternionF(0.9f, 2.9f, -3.2f, 3.0f))
  }

  test("Quaternion multiplied by a scalar") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    assert(q * 1.2f === QuaternionF(1.44f, 1.68f, -2.52f, 3.6f))
  }

  test("Quaternion multiplied by four values") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    val p = q * (0.3f, -1.5f, 1.1f, 0.0f)
    assert(p === QuaternionF(4.77f, -4.68f, -3.81f, -0.71f))
  }

  test("Product of two quaternions") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    val p = QuaternionF(0.3f, -1.5f, 1.1f, 0.0f)
    assert(q * p === QuaternionF(4.77f, -4.68f, -3.81f, -0.71f))
  }

  test("Quaternion divided by a scalar") {
    val q = QuaternionF(1.5f, 2.0f, -2.5f, 3.0f)
    assert(q / 2.0f === QuaternionF(0.75f, 1.0f, -1.25f, 1.5f))
  }

  test("Quaternion divided by zero") {
    val q = QuaternionF.Identity
    val p = q / 0.0f
    assert(p.w.isPosInfinity)
    assert(p.x.isNaN)
    assert(p.y.isNaN)
    assert(p.z.isNaN)
  }

  test("Conjugate") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    assert(q.conjugate === QuaternionF(1.2f, -1.4f, 2.1f, -3.0f))
  }

  test("Dot product between a quaternion and four values") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    val d = q dot (0.3f, -1.5f, 1.1f, 0.0f)
    assert(d === (-4.05f +- 1e-6f))
  }

  test("Dot product between two quaternions") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    val p = QuaternionF(0.3f, -1.5f, 1.1f, 0.0f)
    assert((q dot p) === (-4.05f +- 1e-6f))
  }

  test("Squared norm of a quaternion") {
    val q = QuaternionF(2.0f, 2.0f, -2.0f, 2.0f)
    assert(q.lengthSquared == 16.0f)
  }

  test("Norm of a quaternion") {
    val q = QuaternionF(2.0f, 2.0f, -2.0f, 2.0f)
    assert(q.length == 4.0f)
  }

  test("Normalized quaternion") {
    val q = QuaternionF(2.0f, 2.0f, -2.0f, 2.0f)
    assert(q.normalized === QuaternionF(0.5f, 0.5f, -0.5f, 0.5f))
  }

  test("Normalized zero quaternion") {
    val q = QuaternionF.Zero.normalized
    assert(q.w.isNaN)
    assert(q.x.isNaN)
    assert(q.y.isNaN)
    assert(q.z.isNaN)
  }

  test("Multiplicative inverse") {
    val q = QuaternionF(1.0f, 0.0f, 1.0f, 0.0f)
    assert(q.inverse === QuaternionF(0.5f, 0.0f, -0.5f, 0.0f))
  }

  test("Multiplicative inverse of the zero quaternion") {
    val q = QuaternionF.Zero.inverse
    assert(q.w.isNaN)
    assert(q.x.isNaN)
    assert(q.y.isNaN)
    assert(q.z.isNaN)
  }

  test("Quaternion divided by a quaternion") {
    val q = QuaternionF(1.0f, 1.0f, 1.0f, 1.0f)
    val p = QuaternionF(1.0f, 0.0f, 1.0f, 0.0f)
    assert(q / p === QuaternionF(1.0f, 1.0f, 0.0f, 0.0f))
  }

  test("Quaternion divided by the zero quaternion") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    val p = q / QuaternionF.Zero
    assert(p.w.isNaN)
    assert(p.x.isNaN)
    assert(p.y.isNaN)
    assert(p.z.isNaN)
  }

  test("Quaternion divided by four values") {
    val q = QuaternionF(1.0f, 1.0f, 1.0f, 1.0f)
    val p = q / (1.0f, 0.0f, 1.0f, 0.0f)
    assert(p === QuaternionF(1.0f, 1.0f, 0.0f, 0.0f))
  }

  test("Quaternion divided by four zeros") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    val p = q / (0.0f, 0.0f, 0.0f, 0.0f)
    assert(p.w.isNaN)
    assert(p.x.isNaN)
    assert(p.y.isNaN)
    assert(p.z.isNaN)
  }

  test("Quaternion exponential") {
    val q = QuaternionF(0.0f, 0.0f, 0.7854f, 0.0f)
    assert(q.exp === QuaternionF(0.7071055f, 0.0f, 0.7071081f, 0.0f))
  }

  test("Quaternion logarithm") {
    val q = QuaternionF(1.0f, 0.0f, 1.0f, 0.0f).normalized
    assert(q.log === QuaternionF(0.0f, 0.0f, 0.7853982f, 0.0f))
  }

  test("Euler angles from quaternion") {
    assert(QuaternionF(0.5f, 0.5f, 0.5f, 0.5f).euler == Vec3d(math.Pi * 0.5, 0.0, math.Pi * 0.5).toFloat)
  }

  test("Rotation angle from quaternion") {
    val q = QuaternionF(0.5f, 1.0f, 1.0f, 1.0f)
    assert(q.angle === 2.0 * math.Pi / 3.0 +- 1e-6)
  }

  test("Rotation axis from quaternion") {
    val v = Vec3f(0.5f, 0.5f, 0.5f)
    val q = QuaternionF(1.5f, v)
    assert(q.vector.normalized == v.normalized)
  }

  test("Quaternion equals four values") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    assert(q == (1.2f, 1.4f, -2.1f, 3.0f))
  }

  test("Quaternion to string") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    assert(q.toString == "1.2 + 1.4i - 2.1j + 3.0k")
  }

  test("Imaginary quaternion to string") {
    val q = QuaternionF(0.0f, 1.4f, -2.1f, 3.0f)
    assert(q.toString == "1.4i - 2.1j + 3.0k")
  }

  test("XZ quaternion to string") {
    val q = QuaternionF(0.0f, 1.4f, 0.0f, 3.0f)
    assert(q.toString == "1.4i + 3.0k")
  }

  test("Zero quaternion to string") {
    assert(QuaternionF.Zero.toString == "0.0")
  }

  test("Quaternion from euler angles") {
    val v = Vec3d(math.Pi * 0.5, 0.0, math.Pi * 0.5)
    val q = QuaternionF(v)
    assert(q === QuaternionF(0.5f, 0.5f, 0.5f, 0.5f))
  }

  test("Scalar multiplied by a quaternion") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    assert((1.2f * q) === QuaternionF(1.44f, 1.68f, -2.52f, 3.6f))
  }

  test("Scalar divided by a quaternion") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    assert((2.0f / q) === (q.inverse * 2.0f))
  }
}