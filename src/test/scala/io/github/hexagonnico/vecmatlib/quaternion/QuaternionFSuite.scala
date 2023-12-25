package io.github.hexagonnico.vecmatlib.quaternion

import io.github.hexagonnico.vecmatlib.matrix.Mat3f
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

  implicit val mat3f: Equality[Mat3f] = (a: Mat3f, b: Any) => b match {
    case b: Mat3f =>
      math.abs(a.m00 - b.m00) < 1e-4 && math.abs(a.m01 - b.m01) < 1e-4 && math.abs(a.m02 - b.m02) < 1e-4 &&
      math.abs(a.m10 - b.m10) < 1e-4 && math.abs(a.m11 - b.m11) < 1e-4 && math.abs(a.m12 - b.m12) < 1e-4 &&
      math.abs(a.m20 - b.m20) < 1e-4 && math.abs(a.m21 - b.m21) < 1e-4 && math.abs(a.m22 - b.m22) < 1e-4
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

  test("Quaternion power") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    assert((q * q * q) === q.pow(3))
  }

  test("Quaternion to the power of zero") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    assert(q.pow(0) == QuaternionF.Identity)
  }

  test("Quaternion to a negative power") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    val p = q.inverse
    assert((p * p * p) === q.pow(-3))
  }

  test("Quaternion exponential") {
    // https://www.mathworks.com/help/fusion/ref/quaternion.exp.html
    val q = QuaternionF(4.0f, 14.0f, 15.0f, 1.0f).exp
    assert(q.w === -6.66f +- 1e-3f)
    assert(q.x === 36.931f +- 1e-3f)
    assert(q.y === 39.569f +- 1e-3f)
    assert(q.z === 2.6379f +- 1e-3f)
  }

  test("Quaternion logarithm") {
    // https://www.mathworks.com/help/fusion/ref/quaternion.log.html
    val q = QuaternionF(0.5367f, 0.86217f, -0.43359f, 2.7694f).log
    assert(q.w === 1.0925f +- 1e-3f)
    assert(q.x === 0.40848f +- 1e-3f)
    assert(q.y === -0.20543f +- 1e-3f)
    assert(q.z === 1.3121f +- 1e-3f)
  }

  // TODO: Test euler angles
//  test("Euler angles from quaternion") {
//    assert(QuaternionF(0.5f, 0.5f, 0.5f, 0.5f).euler == Vec3d(math.Pi * 0.5, 0.0, math.Pi * 0.5).toFloat)
//  }

  test("Rotation angle from quaternion") {
    val q = QuaternionF(0.5f, 1.0f / 6.0f, 1.0f / 6.0f, 1.0f / 6.0f)
    assert(q.angle === 2.0 * math.Pi / 3.0 +- 1e-6)
  }

  test("Rotation axis from quaternion") {
    val v = Vec3f(0.5f, 0.5f, 0.5f)
    val q = QuaternionF(1.5f, v)
    assert(q.vector.normalized == v.normalized)
  }

  // TODO: Test slerp

  test("Test quaternion to rotation matrix") {
    // https://www.mathworks.com/help/nav/ref/quaternion.rotmat.html
    val q = QuaternionF(0.8924f, 0.23912f, 0.36964f, 0.099046f)
    val m = Mat3f(
      0.7071f, 0.0f, 0.7071f,
      0.3536f, 0.866f, -0.3536f,
      -0.6124f, 0.5f, 0.6124f
    )
    assert(q.rotationMatrix === m)
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

  // TODO: Test euler angles
//  test("Quaternion from euler angles") {
//    val v = Vec3d(math.Pi * 0.5, 0.0, math.Pi * 0.5)
//    val q = QuaternionF(v)
//    assert(q === QuaternionF(0.5f, 0.5f, 0.5f, 0.5f))
//  }

  // TODO: Quaternion from euler angles

  test("Test quaternion from axis and rotation") {
    // https://it.mathworks.com/help/robotics/ref/axang2quat.html
    val q = QuaternionF(Vec3f.Right, (math.Pi / 2.0).toFloat)
    val s2 = (math.sqrt(2.0) / 2.0).toFloat
    assert(q === QuaternionF(s2, s2, 0.0f, 0.0f))
  }

  // TODO: Quaternion from shortest arc

  test("Scalar multiplied by a quaternion") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    assert((1.2f * q) === QuaternionF(1.44f, 1.68f, -2.52f, 3.6f))
  }

  test("Scalar divided by a quaternion") {
    val q = QuaternionF(1.2f, 1.4f, -2.1f, 3.0f)
    assert((2.0f / q) === (q.inverse * 2.0f))
  }
}