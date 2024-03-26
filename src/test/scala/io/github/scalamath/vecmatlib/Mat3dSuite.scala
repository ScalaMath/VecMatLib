package io.github.scalamath.vecmatlib

import org.scalactic.Equality
import org.scalatest.funsuite.AnyFunSuite

class Mat3dSuite extends AnyFunSuite {

  implicit val equalityMat3d: Equality[Mat3d] = (a: Mat3d, b: Any) => b match {
    case b: Mat3d => a ~= b
    case _ => false
  }

  implicit val equalityVec3d: Equality[Vec3d] = (a: Vec3d, b: Any) => b match {
    case b: Vec3d => a ~= b
    case _ => false
  }

  implicit val equalityVec2d: Equality[Vec2d] = (a: Vec2d, b: Any) => b match {
    case b: Vec2d => a ~= b
    case _ => false
  }

  test("Sum of two matrices") {
    val m1 = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val m2 = Mat3d(3.0, 4.0, 1.0, 2.0, 7.0, 5.0, 9.0, 6.0, 8.0)
    val res = Mat3d(4.0, 6.0, 4.0, 6.0, 12.0, 11.0, 16.0, 14.0, 17.0)
    assert(m1 + m2 === res)
  }

  test("Unary plus") {
    val m = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    assert(+m == m)
  }

  test("Subtraction of two matrices") {
    val m1 = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val m2 = Mat3d(3.0, 4.0, 1.0, 2.0, 7.0, 5.0, 9.0, 6.0, 8.0)
    val res = Mat3d(2.0, 2.0, -2.0, -2.0, 2.0, -1.0, 2.0, -2.0, -1.0)
    assert(m2 - m1 === res)
  }

  test("Unary minus") {
    val m = Mat3d(1.0, 2.0, -2.0, -1.0, 3.0, -2.0, 0.0, -9.0, 4.0)
    val r = Mat3d(-1.0, -2.0, 2.0, 1.0, -3.0, 2.0, 0.0, 9.0, -4.0)
    assert(-m == r)
  }

  test("Matrix multiplied by a scalar") {
    val m = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val r = Mat3d(1.5, 3.0, 4.5, 6.0, 7.5, 9.0, 10.5, 12.0, 13.5)
    assert(m * 1.5 === r)
  }

  test("Matrix divided by a scalar") {
    val m = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val r = Mat3d(0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5)
    assert(m / 2.0 === r)
  }

  test("Get the rows of the matrix") {
    val m = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val r0 = Vec3d(1.0, 2.0, 3.0)
    val r1 = Vec3d(4.0, 5.0, 6.0)
    val r2 = Vec3d(7.0, 8.0, 9.0)
    assert(m.row0 == r0)
    assert(m.row1 == r1)
    assert(m.row2 == r2)
  }

  test("Get row at index") {
    val m = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val r0 = Vec3d(1.0, 2.0, 3.0)
    val r1 = Vec3d(4.0, 5.0, 6.0)
    val r2 = Vec3d(7.0, 8.0, 9.0)
    assert(m.row(0) == r0)
    assert(m.row(1) == r1)
    assert(m.row(2) == r2)
    assertThrows[MatchError] {m.row(3)}
  }

  test("Get the columns of the matrix") {
    val m = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val c0 = Vec3d(1.0, 4.0, 7.0)
    val c1 = Vec3d(2.0, 5.0, 8.0)
    val c2 = Vec3d(3.0, 6.0, 9.0)
    assert(m.col0 == c0)
    assert(m.col1 == c1)
    assert(m.col2 == c2)
  }

  test("Get column at index") {
    val m = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val c0 = Vec3d(1.0, 4.0, 7.0)
    val c1 = Vec3d(2.0, 5.0, 8.0)
    val c2 = Vec3d(3.0, 6.0, 9.0)
    assert(m.col(0) == c0)
    assert(m.col(1) == c1)
    assert(m.col(2) == c2)
    assertThrows[MatchError] {m.col(3)}
  }

  test("Matrix vector product") {
    val mat = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val vec = Vec3d(1.5, 2.5, 3.5)
    val res = Vec3d(17.0, 39.5, 62.0)
    assert(mat * vec === res)
  }

  test("Matrix vector product with values") {
    val mat = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val res = Vec3d(17.0, 39.5, 62.0)
    assert(mat * (1.5, 2.5, 3.5) === res)
  }

  test("Matrix vector product with a 2D vector and a third value") {
    val mat = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val vec = Vec2d(1.5, 2.5)
    val res = Vec3d(17.0, 39.5, 62.0)
    assert(mat * (vec, 3.5) === res)
  }

  test("Matrix product with 3x3 matrix") {
    val m1 = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val m2 = Mat3d(3.0, 4.0, 1.0, 2.0, 7.0, 5.0, 9.0, 6.0, 8.0)
    val res = Mat3d(34.0, 36.0, 35.0, 76.0, 87.0, 77.0, 118.0, 138.0, 119.0)
    assert(m1 * m2 === res)
  }

  test("Matrix product with 3x4 matrix") {
    val m1 = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val m2 = Mat3x4d(3.0, 4.0, 1.0, 2.0, 7.0, 5.0, 9.0, 6.0, 8.0, 10.0, 11.0, 12.0)
    val res = Mat3x4d(41.0, 44.0, 52.0, 50.0, 95.0, 101.0, 115.0, 110.0, 149.0, 158.0, 178.0, 170.0)
    assert(m1 * m2 === res)
  }

  test("Transposed matrix") {
    val m = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val t = Mat3d(1.0, 4.0, 7.0, 2.0, 5.0, 8.0, 3.0, 6.0, 9.0)
    assert(m.transposed == t)
  }

  test("Symmetric matrix") {
    val m1 = Mat3d(1.0, 2.0, 3.0, 2.0, 4.0, 5.0, 3.0, 5.0, 6.0)
    val m2 = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    assert(m1.isSymmetric)
    assert(!m2.isSymmetric)
  }

  test("Skew-symmetric matrix") {
    val m1 = Mat3d(1.0, 2.0, 3.0, 2.0, 4.0, 5.0, 3.0, 5.0, 6.0)
    val m2 = Mat3d(0.0, 1.0, 2.0, -1.0, 0.0, 3.0, -2.0, -3.0, 0.0)
    assert(!m1.isSkewSymmetric)
    assert(m2.isSkewSymmetric)
  }

  test("Submatrix") {
    val m = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    assert(m.submatrix(0, 0) == Mat2d(5.0, 6.0, 8.0, 9.0))
    assert(m.submatrix(0, 1) == Mat2d(4.0, 6.0, 7.0, 9.0))
    assert(m.submatrix(0, 2) == Mat2d(4.0, 5.0, 7.0, 8.0))
    assert(m.submatrix(1, 0) == Mat2d(2.0, 3.0, 8.0, 9.0))
    assert(m.submatrix(1, 1) == Mat2d(1.0, 3.0, 7.0, 9.0))
    assert(m.submatrix(1, 2) == Mat2d(1.0, 2.0, 7.0, 8.0))
    assert(m.submatrix(2, 0) == Mat2d(2.0, 3.0, 5.0, 6.0))
    assert(m.submatrix(2, 1) == Mat2d(1.0, 3.0, 4.0, 6.0))
    assert(m.submatrix(2, 2) == Mat2d(1.0, 2.0, 4.0, 5.0))
  }

  test("Matrix determinant") {
    val m = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 0.0, 0.0, 1.0)
    assert(m.determinant == -3.0)
  }

  test("Adjugate matrix") {
    val mat = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val adj = Mat3d(-3.0, 6.0, -3.0, 6.0, -12.0, 6.0, -3.0, 6.0, -3.0)
    assert(mat.adjugate == adj)
  }

  test("Inverse matrix") {
    val mat = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 0.0, 0.0, 1.0)
    val inv = Mat3d(-5.0 / 3.0, 2.0 / 3.0, 1.0, 4.0 / 3.0, -1.0 / 3.0, -2.0, 0.0, 0.0, 1.0)
    assert(mat.inverse === inv)
  }

  test("Power of a matrix with a positive exponent") {
    val m = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    assert(m.power(3) === m * m * m)
  }

  test("Matrix to the power of zero") {
    val m = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    assert(m.power(0) == Mat3d.Identity)
  }

  test("Matrix to the power of one") {
    val m = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    assert(m.power(1) == m)
  }

  test("Power of a matrix with a negative exponent") {
    val m = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val i = m.inverse
    assert(m.power(-3) === i * i * i)
  }

  test("Lerp elements") {
    val from = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val to = Mat3d(2.0, 4.0, 6.0, 8.0, 10.0, 12.0, 14.0, 16.0, 18.0)
    val res = Mat3d(1.5, 3.0, 4.5, 6.0, 7.5, 9.0, 10.5, 12.0, 13.5)
    assert(from.lerp(to, 0.5) === res)
  }

  test("Absolute values of the elements of a matrix") {
    val mat = Mat3d(1.0, 2.0, 0.0, -2.0, 3.0, -1.0, -3.0, 0.0, 1.0)
    val abs = Mat3d(1.0, 2.0, 0.0, 2.0, 3.0, 1.0, 3.0, 0.0, 1.0)
    assert(mat.abs == abs)
  }

  test("Sign values of the elements of a matrix") {
    val mat = Mat3d(1.0, 2.0, 0.0, -2.0, 3.0, -1.0, -3.0, 0.0, 1.0)
    val sign = Mat3d(1.0, 1.0, 0.0, -1.0, 1.0, -1.0, -1.0, 0.0, 1.0)
    assert(mat.sign == sign)
  }

  test("Round the elements of a matrix") {
    val mat = Mat3d(1.1, 1.9, 0.2, 0.8, 2.1, 2.9, 2.7, 2.3, 0.9)
    val round = Mat3d(1.0, 2.0, 0.0, 1.0, 2.0, 3.0, 3.0, 2.0, 1.0)
    assert(mat.round == round)
  }

  test("Ceil the elements of a matrix") {
    val mat = Mat3d(1.1, 1.9, 0.2, 0.8, 2.1, 2.9, 2.7, 2.3, 0.9)
    val ceil = Mat3d(2.0, 2.0, 1.0, 1.0, 3.0, 3.0, 3.0, 3.0, 1.0)
    assert(mat.ceil == ceil)
  }

  test("Floor the elements of a matrix") {
    val mat = Mat3d(1.1, 1.9, 0.2, 0.8, 2.1, 2.9, 2.7, 2.3, 0.9)
    val floor = Mat3d(1.0, 1.0, 0.0, 0.0, 2.0, 2.0, 2.0, 2.0, 0.0)
    assert(mat.floor == floor)
  }

  // TODO: Orthonormalize

  test("Matrix equals approx") {
    val m1 = Mat3d(1.00000001, 1.99999999, 3.00000001, 3.99999999, 5.00000001, 5.99999999, 7.00000001, 7.99999999, 9.00000001)
    val m2 = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    assert(m1 ~= m2)
  }

  test("Get element at index") {
    val m = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    assert(m(0, 0) == 1.0)
    assert(m(0, 1) == 2.0)
    assert(m(0, 2) == 3.0)
    assert(m(1, 0) == 4.0)
    assert(m(1, 1) == 5.0)
    assert(m(1, 2) == 6.0)
    assert(m(2, 0) == 7.0)
    assert(m(2, 1) == 8.0)
    assert(m(2, 2) == 9.0)
    assertThrows[MatchError] {m(3, 0)}
    assertThrows[MatchError] {m(0, 3)}
    assertThrows[MatchError] {m(3, 3)}
  }

  test("Construct matrix from rows") {
    val m = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val r0 = Vec3d(1.0, 2.0, 3.0)
    val r1 = Vec3d(4.0, 5.0, 6.0)
    val r2 = Vec3d(7.0, 8.0, 9.0)
    assert(Mat3d.fromRows(r0, r1, r2) == m)
  }

  test("Construct matrix from columns") {
    val m = Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    val c0 = Vec3d(1.0, 4.0, 7.0)
    val c1 = Vec3d(2.0, 5.0, 8.0)
    val c2 = Vec3d(3.0, 6.0, 9.0)
    assert(Mat3d.fromColumns(c0, c1, c2) == m)
  }

  test("Translation matrix from values") {
    val v1 = Vec2d(1.0, 2.0)
    val v2 = Vec2d(4.0, 6.0)
    val m = Mat3d.translation(3.0, 4.0)
    assert((m * (v1, 1.0)).xy === v2)
  }

  test("Translation matrix from vector") {
    val v = Vec2d(1.0, 2.0)
    val t = Vec2d(3.0, 4.0)
    val m = Mat3d.translation(t)
    assert((m * (v, 1.0)).xy === v + t)
  }

  test("Rotation matrix around the x axis") {
    val v1 = Vec3d(1.0, 2.0, 1.0)
    val v2 = Vec3d(1.0, 0.70710678, 2.12132034)
    val m = Mat3d.rotationX(math.Pi / 4.0)
    assert(m * v1 === v2)
  }

  test("Rotation matrix around the y axis") {
    val v1 = Vec3d(1.0, 2.0, 1.0)
    val v2 = Vec3d(1.41421356, 2.0, 0.0)
    val m = Mat3d.rotationY(math.Pi / 4.0)
    assert(m * v1 === v2)
  }

  test("Rotation matrix around the z axis") {
    val v1 = Vec3d(1.0, 2.0, 1.0)
    val v2 = Vec3d(-0.70710678, 2.12132034, 1.0)
    val m = Mat3d.rotationZ(math.Pi / 4.0)
    assert(m * v1 === v2)
  }

  test("Rotation matrix around the three axes") {
    val v1 = Vec3d(1.0, 2.0, 1.0)
    val v2 = Vec3d(0.61237244, 0.42161062, 2.33393327)
    val m = Mat3d.rotation(math.Pi / 3.0, math.Pi / 4.0, math.Pi / 6.0)
    assert(m * v1 === v2)
  }

  test("Rotation matrix from rotation vector") {
    val v1 = Vec3d(1.0, 2.0, 1.0)
    val r = Vec3d(math.Pi / 3.0, math.Pi / 4.0, math.Pi / 6.0)
    val v2 = Vec3d(0.61237244, 0.42161062, 2.33393327)
    val m = Mat3d.rotation(r)
    assert(m * v1 === v2)
  }

  test("Rotation around an arbitrary axis") {
    val axis = Vec3d.One.normalized
    val point = Vec3d(1.0, 2.0, 1.0)
    val res = Vec3d(0.68938278, 1.80473785, 1.50587936)
    val matrix = Mat3d.rotation(axis, math.Pi / 4.0)
    assert(matrix * point === res)
  }

  test("Rotation matrix from quaternion") {
    val quaternion = Quatd(0.7233174, 0.3919038, 0.2005621, 0.5319757)
    val matrix = Mat3d.rotation(quaternion)
    val point = Vec3d(1.0, 2.0, 1.0)
    assert(matrix * point === quaternion.rotate(point))
  }

  test("Scaling matrix from values") {
    val v1 = Vec3d(1.5, 1.5, 1.5)
    val v2 = Vec3d(3.0, 4.5, 6.0)
    val m = Mat3d.scaling(2.0, 3.0, 4.0)
    assert(m * v1 === v2)
  }

  test("Scaling matrix from 3D vector") {
    val v = Vec3d(1.5, 1.5, 1.5)
    val s = Vec3d(2.0, 3.0, 4.0)
    val m = Mat3d.scaling(s)
    assert(m * v === v * s)
  }

  test("Scaling matrix from 2D vector") {
    val v = Vec2d(1.5, 1.5)
    val s = Vec2d(2.0, 3.0)
    val m = Mat3d.scaling(s)
    assert((m * (v, 0.0)).xy === v * s)
  }
}
