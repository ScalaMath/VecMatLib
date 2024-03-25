package io.github.scalamath.vecmatlib

import io.github.scalamath
import org.scalactic.Equality
import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class QuatfSuite extends AnyFunSuite {

  // https://www.andre-gaschler.com/rotationconverter/

  implicit val equalityQuatf: Equality[Quatf] = (a: Quatf, b: Any) => b match {
    case b: Quatf => a ~= b
    case _ => false
  }

  implicit val equalityVec3f: Equality[Vec3f] = (a: Vec3f, b: Any) => b match {
    case b: Vec3f => a ~= b
    case _ => false
  }

  test("Quaternion from scalar and vector") {
    val q1 = Quatf(1.0f, 2.0f, 3.0f, 4.0f)
    val v = Vec3f(2.0f, 3.0f, 4.0f)
    val q2 = Quatf(1.0f, v)
    assert(q1 == q2)
  }

  test("Quaternion from axis and angle") {
    val q1 = Quatf(Vec3f.Up, math.Pi / 4.0)
    val q2 = Quatf(0.9238795f, 0.0f, 0.3826834f, 0.0f)
    assert(q1 === q2)
  }

  test("Sum of a quaternion and four values") {
    val q1 = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    val q2 = q1 + (0.3f, -1.5f, 1.1f, 0.0f)
    val res = Quatf(1.5f, -0.1f, -1.0f, 3.0f)
    assert(q2 === res)
  }

  test("Sum of two quaternions") {
    val q1 = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    val q2 = Quatf(0.3f, -1.5f, 1.1f, 0.0f)
    val res = Quatf(1.5f, -0.1f, -1.0f, 3.0f)
    assert(q1 + q2 === res)
  }

  test("Unary plus") {
    val q = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    assert(+q == q)
  }

  test("Subtraction of four values from a quaternion") {
    val q1 = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    val q2 = q1 - (0.3f, -1.5f, 1.1f, 0.0f)
    val res = Quatf(0.9f, 2.9f, -3.2f, 3.0f)
    assert(q2 === res)
  }

  test("Subtraction of two quaternions") {
    val q1 = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    val q2 = Quatf(0.3f, -1.5f, 1.1f, 0.0f)
    val res = Quatf(0.9f, 2.9f, -3.2f, 3.0f)
    assert(q1 - q2 === res)
  }

  test("Unary minus") {
    val q = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    val p = Quatf(-1.2f, -1.4f, 2.1f, -3.0f)
    assert(-q == p)
  }

  test("Quaternion multiplied by a scalar") {
    val q = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    val res = Quatf(1.44f, 1.68f, -2.52f, 3.6f)
    assert(q * 1.2f === res)
  }

  test("Scalar multiplied by a quaternion") {
    val q = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    val res = Quatf(1.44f, 1.68f, -2.52f, 3.6f)
    assert(1.2f * q === res)
  }

  test("Quaternion divided by a scalar") {
    val q = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    val res = Quatf(0.6f, 0.7f, -1.05f, 1.5f)
    assert(q / 2.0f === res)
  }

  test("Quaternion multiplied by four values") {
    val q1 = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    val q2 = q1 * (0.3f, -1.5f, 1.1f, 0.0f)
    val res = Quatf(4.77f, -4.68f, -3.81f, -0.71f)
    assert(q2 === res)
  }

  test("Product of two quaternions") {
    val q1 = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    val q2 = Quatf(0.3f, -1.5f, 1.1f, 0.0f)
    val res = Quatf(4.77f, -4.68f, -3.81f, -0.71f)
    assert(q1 * q2 === res)
  }

  test("Conjugate") {
    val q = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    val res = Quatf(1.2f, -1.4f, 2.1f, -3.0f)
    assert(q.conjugate === res)
  }

  test("Dot product between a quaternion and four values") {
    val q = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    val dot = q.dot(0.3f, -1.5f, 1.1f, 0.0f)
    assert(dot === -4.05f +- scalamath.Epsilon.toFloat)
  }

  test("Dot product between two quaternions") {
    val q1 = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    val q2 = Quatf(0.3f, -1.5f, 1.1f, 0.0f)
    val dot = q1.dot(q2)
    assert(dot === -4.05f +- scalamath.Epsilon.toFloat)
  }

  test("Squared norm of a quaternion") {
    val q = Quatf(2.0f, 2.0f, -2.0f, 2.0f)
    assert(q.lengthSquared == 16.0f)
  }

  test("Norm of a quaternion") {
    val q = Quatf(2.0f, 2.0f, -2.0f, 2.0f)
    assert(q.length == 4.0f)
  }

  test("Normalized quaternion") {
    val q = Quatf(2.0f, 2.0f, -2.0f, 2.0f)
    val res = Quatf(0.5f, 0.5f, -0.5f, 0.5f)
    assert(q.normalized === res)
  }

  test("Check if quaternion is normalized") {
    val q1 = Quatf(2.0f, 2.0f, -2.0f, 2.0f)
    val q2 = Quatf(0.5f, 0.5f, -0.5f, 0.5f)
    assert(!q1.isNormalized)
    assert(q2.isNormalized)
  }

  test("Inverse of a quaternion") {
    val q = Quatf(1.0f, 0.0f, 1.0f, 0.0f)
    val res = Quatf(0.5f, 0.0f, -0.5f, 0.0f)
    assert(q.inverse === res)
  }

  test("Scalar divided by a quaternion") {
    val q = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    val res = q.inverse * 2.0f
    assert(2.0f / q === res)
  }

  test("Quaternion divided by a quaternion") {
    val q1 = Quatf(1.0f, 1.0f, 1.0f, 1.0f)
    val q2 = Quatf(1.0f, 0.0f, 1.0f, 0.0f)
    val res = Quatf(1.0f, 1.0f, 0.0f, 0.0f)
    assert(q1 / q2 === res)
  }

  test("Quaternion divided by four values") {
    val q1 = Quatf(1.0f, 1.0f, 1.0f, 1.0f)
    val q2 = q1 / (1.0f, 0.0f, 1.0f, 0.0f)
    val res = Quatf(1.0f, 1.0f, 0.0f, 0.0f)
    assert(q2 === res)
  }

  test("Get the vector part of the quaternion") {
    val q = Quatf(1.0f, 2.0f, 3.0f, 4.0f)
    val v = Vec3f(2.0f, 3.0f, 4.0f)
    assert(q.vector == v)
  }

  test("Get the rotation angle from a quaternion") {
    val q = Quatf(Vec3f.Right, math.Pi / 4.0)
    assert(q.angle === math.Pi / 4.0 +- scalamath.Epsilon)
  }

  test("Get the rotation axis from a quaternion") {
    val q = Quatf(Vec3f.Left, math.Pi / 4.0)
    assert(q.axis === Vec3f.Left)
  }

  test("Quaternion exponential") {
    // https://www.mathworks.com/help/fusion/ref/quaternion.exp.html
    val q = Quatf(4.0f, 14.0f, 15.0f, 1.0f).exp
    assert(q.w === -6.66f +- 1e-3f)
    assert(q.x === 36.931f +- 1e-3f)
    assert(q.y === 39.569f +- 1e-3f)
    assert(q.z === 2.6379f +- 1e-3f)
  }

  test("Quaternion logarithm") {
    // https://www.mathworks.com/help/fusion/ref/quaternion.log.html
    val q = Quatf(0.5367f, 0.86217f, -0.43359f, 2.7694f).log
    assert(q.w === 1.0925f +- 1e-3f)
    assert(q.x === 0.40848f +- 1e-3f)
    assert(q.y === -0.20543f +- 1e-3f)
    assert(q.z === 1.3121f +- 1e-3f)
  }

  test("Quaternion power") {
    val q = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    val res = q * q * q
    assert(q.pow(3) === res)
    assert(q.inverse.pow(3) === q.pow(-3))
  }

  // TODO: angleTo

  // TODO: slerp

  test("Get euler angles in the default order") {
    val q = Quatf(0.9253338f, 0.0f, 0.3791534f, 0.0f)
    val res = Vec3f(0.0f, 0.7777625f, 0.0f)
    assert(q.euler === res)
  }

  test("Quaternion equals four values") {
    val q = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    assert(q == (1.2f, 1.4f, -2.1f, 3.0f))
  }

  test("Quaternion equals approx four values") {
    val q = Quatf(1.20000001f, 1.39999999f, -2.09999999f, 3.00000001f)
    assert(q ~= (1.2f, 1.4f, -2.1f, 3.0f))
  }

  test("Quaternion equals approx with another quaternion") {
    val q1 = Quatf(1.20000001f, 1.39999999f, -2.09999999f, 3.00000001f)
    val q2 = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    assert(q1 ~= q2)
  }

  test("Access quaternion elements using apply") {
    val q = Quatf(1.2f, 1.4f, -2.1f, 3.0f)
    assert(q(0) == 1.2f)
    assert(q(1) == 1.4f)
    assert(q(2) == -2.1f)
    assert(q(3) == 3.0f)
    assertThrows[MatchError] {q(4)}
  }

  test("Quaternion from euler in default order with double vector") {
    val euler = Vec3d(math.Pi / 6.0, math.Pi / 4.0, math.Pi / 3.0)
    val res = Quatf(0.8223632f, 0.02226f, 0.4396797f, 0.3604234f)
    assert(Quatf.fromEuler(euler) === res)
  }

  test("Quaternion from euler in default order with float vector") {
    val euler = Vec3d(math.Pi / 6.0, math.Pi / 4.0, math.Pi / 3.0).toFloat
    val res = Quatf(0.8223632f, 0.02226f, 0.4396797f, 0.3604234f)
    assert(Quatf.fromEuler(euler) === res)
  }

  test("Quaternion from euler in default order with four values") {
    val q = Quatf.fromEuler(math.Pi / 6.0, math.Pi / 4.0, math.Pi / 3.0)
    val res = Quatf(0.8223632f, 0.02226f, 0.4396797f, 0.3604234f)
    assert(q === res)
  }

  // TODO: Quaternion from shortest arc
}
