package io.github.scalamath.vecmatlib

import io.github.scalamath
import org.scalactic.Equality
import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class QuatdSuite extends AnyFunSuite {

  // https://www.andre-gaschler.com/rotationconverter/

  implicit val equalityQuatd: Equality[Quatd] = (a: Quatd, b: Any) => b match {
    case b: Quatd => a ~= b
    case _ => false
  }

  implicit val equalityVec3d: Equality[Vec3d] = (a: Vec3d, b: Any) => b match {
    case b: Vec3d => a ~= b
    case _ => false
  }

  test("Quaternion from scalar and vector") {
    val q1 = Quatd(1.0, 2.0, 3.0, 4.0)
    val v = Vec3d(2.0, 3.0, 4.0)
    val q2 = Quatd(1.0, v)
    assert(q1 == q2)
  }

  test("Quaternion from axis and angle") {
    val q1 = Quatd(Vec3d.Up, math.Pi / 4.0)
    val q2 = Quatd(0.9238795, 0.0, 0.3826834, 0.0)
    assert(q1 === q2)
  }

  test("Sum of a quaternion and four values") {
    val q1 = Quatd(1.2, 1.4, -2.1, 3.0)
    val q2 = q1 + (0.3, -1.5, 1.1, 0.0)
    val res = Quatd(1.5, -0.1, -1.0, 3.0)
    assert(q2 === res)
  }

  test("Sum of two quaternions") {
    val q1 = Quatd(1.2, 1.4, -2.1, 3.0)
    val q2 = Quatd(0.3, -1.5, 1.1, 0.0)
    val res = Quatd(1.5, -0.1, -1.0, 3.0)
    assert(q1 + q2 === res)
  }

  test("Unary plus") {
    val q = Quatd(1.2, 1.4, -2.1, 3.0)
    assert(+q == q)
  }

  test("Subtraction of four values from a quaternion") {
    val q1 = Quatd(1.2, 1.4, -2.1, 3.0)
    val q2 = q1 - (0.3, -1.5, 1.1, 0.0)
    val res = Quatd(0.9, 2.9, -3.2, 3.0)
    assert(q2 === res)
  }

  test("Subtraction of two quaternions") {
    val q1 = Quatd(1.2, 1.4, -2.1, 3.0)
    val q2 = Quatd(0.3, -1.5, 1.1, 0.0)
    val res = Quatd(0.9, 2.9, -3.2, 3.0)
    assert(q1 - q2 === res)
  }

  test("Unary minus") {
    val q = Quatd(1.2, 1.4, -2.1, 3.0)
    val p = Quatd(-1.2, -1.4, 2.1, -3.0)
    assert(-q == p)
  }

  test("Quaternion multiplied by a scalar") {
    val q = Quatd(1.2, 1.4, -2.1, 3.0)
    val res = Quatd(1.44, 1.68, -2.52, 3.6)
    assert(q * 1.2 === res)
  }

  test("Scalar multiplied by a quaternion") {
    val q = Quatd(1.2, 1.4, -2.1, 3.0)
    val res = Quatd(1.44, 1.68, -2.52, 3.6)
    assert(1.2 * q === res)
  }

  test("Quaternion divided by a scalar") {
    val q = Quatd(1.2, 1.4, -2.1, 3.0)
    val res = Quatd(0.6, 0.7, -1.05, 1.5)
    assert(q / 2.0 === res)
  }

  test("Quaternion multiplied by four values") {
    val q1 = Quatd(1.2, 1.4, -2.1, 3.0)
    val q2 = q1 * (0.3, -1.5, 1.1, 0.0)
    val res = Quatd(4.77, -4.68, -3.81, -0.71)
    assert(q2 === res)
  }

  test("Product of two quaternions") {
    val q1 = Quatd(1.2, 1.4, -2.1, 3.0)
    val q2 = Quatd(0.3, -1.5, 1.1, 0.0)
    val res = Quatd(4.77, -4.68, -3.81, -0.71)
    assert(q1 * q2 === res)
  }

  test("Conjugate") {
    val q = Quatd(1.2, 1.4, -2.1, 3.0)
    val res = Quatd(1.2, -1.4, 2.1, -3.0)
    assert(q.conjugate === res)
  }

  test("Dot product between a quaternion and four values") {
    val q = Quatd(1.2, 1.4, -2.1, 3.0)
    val dot = q.dot(0.3, -1.5, 1.1, 0.0)
    assert(dot === -4.05 +- scalamath.Epsilon)
  }

  test("Dot product between two quaternions") {
    val q1 = Quatd(1.2, 1.4, -2.1, 3.0)
    val q2 = Quatd(0.3, -1.5, 1.1, 0.0)
    val dot = q1.dot(q2)
    assert(dot === -4.05 +- scalamath.Epsilon)
  }

  test("Squared norm of a quaternion") {
    val q = Quatd(2.0, 2.0, -2.0, 2.0)
    assert(q.lengthSquared == 16.0)
  }

  test("Norm of a quaternion") {
    val q = Quatd(2.0, 2.0, -2.0, 2.0)
    assert(q.length == 4.0)
  }

  test("Normalized quaternion") {
    val q = Quatd(2.0, 2.0, -2.0, 2.0)
    val res = Quatd(0.5, 0.5, -0.5, 0.5)
    assert(q.normalized === res)
  }

  test("Check if quaternion is normalized") {
    val q1 = Quatd(2.0, 2.0, -2.0, 2.0)
    val q2 = Quatd(0.5, 0.5, -0.5, 0.5)
    assert(!q1.isNormalized)
    assert(q2.isNormalized)
  }

  test("Inverse of a quaternion") {
    val q = Quatd(1.0, 0.0, 1.0, 0.0)
    val res = Quatd(0.5, 0.0, -0.5, 0.0)
    assert(q.inverse === res)
  }

  test("Scalar divided by a quaternion") {
    val q = Quatd(1.2, 1.4, -2.1, 3.0)
    val res = q.inverse * 2.0
    assert(2.0 / q === res)
  }

  test("Quaternion divided by a quaternion") {
    val q1 = Quatd(1.0, 1.0, 1.0, 1.0)
    val q2 = Quatd(1.0, 0.0, 1.0, 0.0)
    val res = Quatd(1.0, 1.0, 0.0, 0.0)
    assert(q1 / q2 === res)
  }

  test("Quaternion divided by four values") {
    val q1 = Quatd(1.0, 1.0, 1.0, 1.0)
    val q2 = q1 / (1.0, 0.0, 1.0, 0.0)
    val res = Quatd(1.0, 1.0, 0.0, 0.0)
    assert(q2 === res)
  }

  test("Get the vector part of the quaternion") {
    val q = Quatd(1.0, 2.0, 3.0, 4.0)
    val v = Vec3d(2.0, 3.0, 4.0)
    assert(q.vector == v)
  }

  test("Get the rotation angle from a quaternion") {
    val q = Quatd(Vec3d.Right, math.Pi / 4.0)
    assert(q.angle === math.Pi / 4.0 +- scalamath.Epsilon)
  }

  test("Get the rotation axis from a quaternion") {
    val q = Quatd(Vec3d.Left, math.Pi / 4.0)
    assert(q.axis === Vec3d.Left)
  }

  test("Quaternion exponential") {
    // https://www.mathworks.com/help/fusion/ref/quaternion.exp.html
    val q = Quatd(4.0, 14.0, 15.0, 1.0).exp
    assert(q.w === -6.66 +- 1e-3)
    assert(q.x === 36.931 +- 1e-3)
    assert(q.y === 39.569 +- 1e-3)
    assert(q.z === 2.6379 +- 1e-3)
  }

  test("Quaternion logarithm") {
    // https://www.mathworks.com/help/fusion/ref/quaternion.log.html
    val q = Quatd(0.5367, 0.86217, -0.43359, 2.7694).log
    assert(q.w === 1.0925 +- 1e-3)
    assert(q.x === 0.40848 +- 1e-3)
    assert(q.y === -0.20543 +- 1e-3)
    assert(q.z === 1.3121 +- 1e-3)
  }

  test("Quaternion power") {
    val q = Quatd(1.2, 1.4, -2.1, 3.0)
    val res = q * q * q
    assert(q.pow(3) === res)
    assert(q.inverse.pow(3) === q.pow(-3))
  }

  // TODO: angleTo

  test("Quaternion slerp") {
    val sq2 = math.sqrt(2.0) / 2.0
    val q1 = Quatd(sq2, 0.0, 0.0, sq2)
    val q2 = Quatd(0.0, sq2, sq2, 0.0)
    val res = Quatd(0.5, 0.5, 0.5, 0.5)
    assert(q1.slerp(q2, 0.5) === res)
  }

  test("Get euler angles in the default order") {
    val q = Quatd(0.9253338, 0.0, 0.3791534, 0.0)
    val res = Vec3d(0.0, 0.7777625, 0.0)
    assert(q.euler === res)
  }

  test("Rotate point") {
    val quaternion = Quatd(Vec3d.Up, math.Pi / 2.0)
    val point = Vec3d(1.0, 0.0, 0.0)
    val res = Vec3d(0.0, 0.0, -1.0)
    assert(quaternion.rotate(point) === res)
  }

  test("Quaternion equals four values") {
    val q = Quatd(1.2, 1.4, -2.1, 3.0)
    assert(q == (1.2, 1.4, -2.1, 3.0))
  }

  test("Quaternion equals approx four values") {
    val q = Quatd(1.20000001, 1.39999999, -2.09999999, 3.00000001)
    assert(q ~= (1.2, 1.4, -2.1, 3.0))
  }

  test("Quaternion equals approx with another quaternion") {
    val q1 = Quatd(1.20000001, 1.39999999, -2.09999999, 3.00000001)
    val q2 = Quatd(1.2, 1.4, -2.1, 3.0)
    assert(q1 ~= q2)
  }

  test("Access quaternion elements using apply") {
    val q = Quatd(1.2, 1.4, -2.1, 3.0)
    assert(q(0) == 1.2)
    assert(q(1) == 1.4)
    assert(q(2) == -2.1)
    assert(q(3) == 3.0)
    assertThrows[MatchError] {q(4)}
  }

  test("Quaternion from euler in default order") {
    val euler = Vec3d(math.Pi / 6.0, math.Pi / 4.0, math.Pi / 3.0)
    val res = Quatd(0.8223632, 0.02226, 0.4396797, 0.3604234)
    assert(Quatd.fromEuler(euler) === res)
  }

  test("Quaternion from euler in default order with four values") {
    val q = Quatd.fromEuler(math.Pi / 6.0, math.Pi / 4.0, math.Pi / 3.0)
    val res = Quatd(0.8223632, 0.02226, 0.4396797, 0.3604234)
    assert(q === res)
  }

  // TODO: Quaternion from shortest arc
}
