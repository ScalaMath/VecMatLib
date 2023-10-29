package io.github.hexagonnico.vecmatlib.quaternion

import io.github.hexagonnico.vecmatlib.vector.Vec3d
import org.scalactic.Equality
import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class QuaternionSuite extends AnyFunSuite {

  implicit val quaternion: Equality[Quaternion] = (a: Quaternion, b: Any) => b match {
    case b: Quaternion =>
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
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    val p = q + (0.3, -1.5, 1.1, 0.0)
    assert(p === Quaternion(1.5, -0.1, -1.0, 3.0))
  }

  test("Sum of two quaternions") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    val p = Quaternion(0.3, -1.5, 1.1, 0.0)
    assert(q + p === Quaternion(1.5, -0.1, -1.0, 3.0))
  }

  test("Additive inverse") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    assert(-q === Quaternion(-1.2, -1.4, 2.1, -3.0))
  }

  test("Subtraction of a quaternion and four values") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    val p = q - (0.3, -1.5, 1.1, 0.0)
    assert(p === Quaternion(0.9, 2.9, -3.2, 3.0))
  }

  test("Subtraction of two quaternions") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    val p = Quaternion(0.3, -1.5, 1.1, 0.0)
    assert(q - p === Quaternion(0.9, 2.9, -3.2, 3.0))
  }

  test("Quaternion multiplied by a scalar") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    assert(q * 1.2 === Quaternion(1.44, 1.68, -2.52, 3.6))
  }

  test("Quaternion multiplied by four values") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    val p = q * (0.3, -1.5, 1.1, 0.0)
    assert(p === Quaternion(4.77, -4.68, -3.81, -0.71))
  }

  test("Product of two quaternions") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    val p = Quaternion(0.3, -1.5, 1.1, 0.0)
    assert(q * p === Quaternion(4.77, -4.68, -3.81, -0.71))
  }

  test("Quaternion divided by a scalar") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    assert(q / 1.2 === Quaternion(1.0, 1.16666666667, -1.75, 2.5))
  }

  test("Quaternion divided by zero") {
    val q = Quaternion.Identity
    val p = q / 0.0
    assert(p.w.isPosInfinity)
    assert(p.x.isNaN)
    assert(p.y.isNaN)
    assert(p.z.isNaN)
  }

  test("Conjugate") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    assert(q.conjugate === Quaternion(1.2, -1.4, 2.1, -3.0))
  }

  test("Dot product between a quaternion and four values") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    val d = q dot (0.3, -1.5, 1.1, 0.0)
    assert(d === (-4.05 +- 1e-9))
  }

  test("Dot product between two quaternions") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    val p = Quaternion(0.3, -1.5, 1.1, 0.0)
    assert((q dot p) === (-4.05 +- 1e-9))
  }

  test("Squared norm of a quaternion") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    assert(q.lengthSquared === (16.81 +- 1e-9))
  }

  test("Norm of a quaternion") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    assert(q.length === (4.1 +- 1e-9))
  }

  test("Normalized quaternion") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    assert(q.normalized === Quaternion(0.292682926829, 0.341463414634, -0.512195121951, 0.731707317073))
  }

  test("Normalized zero quaternion") {
    val q = Quaternion.Zero.normalized
    assert(q.w.isNaN)
    assert(q.x.isNaN)
    assert(q.y.isNaN)
    assert(q.z.isNaN)
  }

  test("Multiplicative inverse") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    assert(q.reciprocal === Quaternion(0.07138607971445568, -0.08328375966686496, 0.12492563950029746, -0.17846519928613921))
  }

  test("Multiplicative inverse of the zero quaternion") {
    val q = Quaternion.Zero.reciprocal
    assert(q.w.isNaN)
    assert(q.x.isNaN)
    assert(q.y.isNaN)
    assert(q.z.isNaN)
  }

  test("Quaternion divided by a quaternion") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    val p = Quaternion(0.3, -1.5, 1.1, 0.0)
    assert(q / p === Quaternion(-1.1408450704225355, 1.5549295774647889, 0.7183098591549296, 0.7070422535211269))
  }

  test("Quaternion divided by the zero quaternion") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    val p = q / Quaternion.Zero
    assert(p.w.isNaN)
    assert(p.x.isNaN)
    assert(p.y.isNaN)
    assert(p.z.isNaN)
  }

  test("Quaternion divided by four values") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    val p = q / (0.3, -1.5, 1.1, 0.0)
    assert(p === Quaternion(-1.1408450704225355, 1.5549295774647889, 0.7183098591549296, 0.7070422535211269))
  }

  test("Quaternion divided by four zeros") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    val p = q / (0.0, 0.0, 0.0, 0.0)
    assert(p.w.isNaN)
    assert(p.x.isNaN)
    assert(p.y.isNaN)
    assert(p.z.isNaN)
  }

  test("Quaternion exponential") {
    val q = Quaternion(5.0, 11.0, 10.0, 8.0)
    assert(q.exp === Quaternion(-57.35934830430998, -89.1893488603172, -81.081226236652, -64.86498098932161))
  }

  test("Quaternion logarithm") {
    val q = Quaternion(1.8339, 0.31877, 0.34262, -1.3499)
    assert(q.log === Quaternion(0.8436087534264758, 0.14766753357708173, 0.15871584639137853, -0.6253298728729261))
  }

  // TODO: Euler angles from quaternion

  // TODO: Rotation angle from quaternion

  // TODO: Rotation axis from quaternion

  // TODO: slerp

  test("Quaternion equals four values") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    assert(q == (1.2, 1.4, -2.1, 3.0))
  }

  test("Quaternion to string") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    assert(q.toString == "1.2 + 1.4i - 2.1j + 3.0k")
  }

  test("Imaginary quaternion to string") {
    val q = Quaternion(0.0, 1.4, -2.1, 3.0)
    assert(q.toString == "1.4i - 2.1j + 3.0k")
  }

  test("XZ quaternion to string") {
    val q = Quaternion(0.0, 1.4, 0.0, 3.0)
    assert(q.toString == "1.4i + 3.0k")
  }

  test("Zero quaternion to string") {
    assert(Quaternion.Zero.toString == "0.0")
  }

  test("Quaternion from euler angles") {
    val v = Vec3d(math.Pi / 4.0, math.Pi / 2.0, 0.0)
    val q = Quaternion(v)
    assert(q === Quaternion(0.6532814824381883, 0.2705980500730985, 0.6532814824381882, -0.27059805007309845))
  }

  test("Quaternion from axis and angle") {
    val q = Quaternion(Vec3d.Up, math.Pi / 6.0)
    assert(q === Quaternion(0.9659258262890683, 0.0, 0.25881904510252074, 0.0))
  }

  // TODO: Quaternion from shortest arc

  test("Scalar multiplied by a quaternion") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    assert((1.2 * q) === Quaternion(1.44, 1.68, -2.52, 3.6))
  }

  test("Scalar divided by a quaternion") {
    val q = Quaternion(1.2, 1.4, -2.1, 3.0)
    assert((2.0 / q) === (q.reciprocal * 2.0))
  }
}