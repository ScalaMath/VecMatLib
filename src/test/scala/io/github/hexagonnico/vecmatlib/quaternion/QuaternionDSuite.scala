package io.github.hexagonnico.vecmatlib.quaternion

import io.github.hexagonnico.vecmatlib.matrix.Mat3d
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

  implicit val mat3d: Equality[Mat3d] = (a: Mat3d, b: Any) => b match {
    case b: Mat3d =>
      math.abs(a.m00 - b.m00) < 1e-4 && math.abs(a.m01 - b.m01) < 1e-4 && math.abs(a.m02 - b.m02) < 1e-4 &&
        math.abs(a.m10 - b.m10) < 1e-4 && math.abs(a.m11 - b.m11) < 1e-4 && math.abs(a.m12 - b.m12) < 1e-4 &&
        math.abs(a.m20 - b.m20) < 1e-4 && math.abs(a.m21 - b.m21) < 1e-4 && math.abs(a.m22 - b.m22) < 1e-4
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

  test("Quaternion power") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    assert((q * q * q) === q.pow(3))
  }

  test("Quaternion to the power of zero") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    assert(q.pow(0) == QuaternionD.Identity)
  }

  test("Quaternion to a negative power") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    val p = q.inverse
    assert((p * p * p) === q.pow(-3))
  }

  test("Quaternion exponential") {
    // https://www.mathworks.com/help/fusion/ref/quaternion.exp.html
    val q = QuaternionD(4.0, 14.0, 15.0, 1.0).exp
    assert(q.w === -6.66 +- 1e-3)
    assert(q.x === 36.931 +- 1e-3)
    assert(q.y === 39.569 +- 1e-3)
    assert(q.z === 2.6379 +- 1e-3)
  }

  test("Quaternion logarithm") {
    // https://www.mathworks.com/help/fusion/ref/quaternion.log.html
    val q = QuaternionD(0.5367, 0.86217, -0.43359, 2.7694).log
    assert(q.w === 1.0925 +- 1e-3)
    assert(q.x === 0.40848 +- 1e-3)
    assert(q.y === -0.20543 +- 1e-3)
    assert(q.z === 1.3121 +- 1e-3)
  }

  // TODO: Test euler angles
//  test("Euler angles from quaternion") {
//    assert(QuaternionD(0.5, 0.5, 0.5, 0.5).euler == Vec3d(math.Pi * 0.5, 0.0, math.Pi * 0.5))
//  }

  test("Rotation angle from quaternion") {
    val q = QuaternionD(0.5, 1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0)
    assert(q.angle === 2.0 * math.Pi / 3.0 +- 1e-9)
  }

  test("Rotation axis from quaternion") {
    val v = Vec3d(0.5, 0.5, 0.5)
    val q = QuaternionD(1.5, v)
    assert(q.vector.normalized == v.normalized)
  }

  // TODO: Test slerp

  test("Test quaternion to rotation matrix") {
    // https://www.mathworks.com/help/nav/ref/quaternion.rotmat.html
    val q = QuaternionD(0.8924, 0.23912, 0.36964, 0.099046)
    val m = Mat3d(
      0.7071, 0.0, 0.7071,
      0.3536, 0.866, -0.3536,
      -0.6124, 0.5, 0.6124
    )
    assert(q.rotationMatrix === m)
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

  // TODO: Test euler angles
//  test("Quaternion from euler angles") {
//    val v = Vec3d(math.Pi * 0.5, 0.0, math.Pi * 0.5)
//    val q = QuaternionD(v)
//    assert(q === QuaternionD(0.5, 0.5, 0.5, 0.5))
//  }

  test("Scalar multiplied by a quaternion") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    assert((1.2 * q) === QuaternionD(1.44, 1.68, -2.52, 3.6))
  }

  // TODO: Quaternion from euler angles

  // TODO: Quaternion from axis and rotation

  // TODO: Quaternion from shortest arc

  test("Scalar divided by a quaternion") {
    val q = QuaternionD(1.2, 1.4, -2.1, 3.0)
    assert((2.0 / q) === (q.inverse * 2.0))
  }
}