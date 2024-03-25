package io.github.scalamath.vecmatlib

import org.scalactic.Equality
import org.scalatest.funsuite.AnyFunSuite

class Mat3fSuite extends AnyFunSuite {

  implicit val equalityMat3f: Equality[Mat3f] = (a: Mat3f, b: Any) => b match {
    case b: Mat3f => a ~= b
    case _ => false
  }

  implicit val equalityVec3f: Equality[Vec3f] = (a: Vec3f, b: Any) => b match {
    case b: Vec3f => a ~= b
    case _ => false
  }

  implicit val equalityVec2f: Equality[Vec2f] = (a: Vec2f, b: Any) => b match {
    case b: Vec2f => a ~= b
    case _ => false
  }

  test("Sum of two matrices") {
    val m1 = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val m2 = Mat3f(3.0f, 4.0f, 1.0f, 2.0f, 7.0f, 5.0f, 9.0f, 6.0f, 8.0f)
    val res = Mat3f(4.0f, 6.0f, 4.0f, 6.0f, 12.0f, 11.0f, 16.0f, 14.0f, 17.0f)
    assert(m1 + m2 === res)
  }

  test("Unary plus") {
    val m = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    assert(+m == m)
  }

  test("Subtraction of two matrices") {
    val m1 = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val m2 = Mat3f(3.0f, 4.0f, 1.0f, 2.0f, 7.0f, 5.0f, 9.0f, 6.0f, 8.0f)
    val res = Mat3f(2.0f, 2.0f, -2.0f, -2.0f, 2.0f, -1.0f, 2.0f, -2.0f, -1.0f)
    assert(m2 - m1 === res)
  }

  test("Unary minus") {
    val m = Mat3f(1.0f, 2.0f, -2.0f, -1.0f, 3.0f, -2.0f, 0.0f, -9.0f, 4.0f)
    val r = Mat3f(-1.0f, -2.0f, 2.0f, 1.0f, -3.0f, 2.0f, 0.0f, 9.0f, -4.0f)
    assert(-m == r)
  }

  test("Matrix multiplied by a scalar") {
    val m = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val r = Mat3f(1.5f, 3.0f, 4.5f, 6.0f, 7.5f, 9.0f, 10.5f, 12.0f, 13.5f)
    assert(m * 1.5f === r)
  }

  test("Matrix divided by a scalar") {
    val m = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val r = Mat3f(0.5f, 1.0f, 1.5f, 2.0f, 2.5f, 3.0f, 3.5f, 4.0f, 4.5f)
    assert(m / 2.0f === r)
  }

  test("Get the rows of the matrix") {
    val m = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val r0 = Vec3f(1.0f, 2.0f, 3.0f)
    val r1 = Vec3f(4.0f, 5.0f, 6.0f)
    val r2 = Vec3f(7.0f, 8.0f, 9.0f)
    assert(m.row0 == r0)
    assert(m.row1 == r1)
    assert(m.row2 == r2)
  }

  test("Get row at index") {
    val m = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val r0 = Vec3f(1.0f, 2.0f, 3.0f)
    val r1 = Vec3f(4.0f, 5.0f, 6.0f)
    val r2 = Vec3f(7.0f, 8.0f, 9.0f)
    assert(m.row(0) == r0)
    assert(m.row(1) == r1)
    assert(m.row(2) == r2)
    assertThrows[MatchError] {m.row(3)}
  }

  test("Get the columns of the matrix") {
    val m = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val c0 = Vec3f(1.0f, 4.0f, 7.0f)
    val c1 = Vec3f(2.0f, 5.0f, 8.0f)
    val c2 = Vec3f(3.0f, 6.0f, 9.0f)
    assert(m.col0 == c0)
    assert(m.col1 == c1)
    assert(m.col2 == c2)
  }

  test("Get column at index") {
    val m = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val c0 = Vec3f(1.0f, 4.0f, 7.0f)
    val c1 = Vec3f(2.0f, 5.0f, 8.0f)
    val c2 = Vec3f(3.0f, 6.0f, 9.0f)
    assert(m.col(0) == c0)
    assert(m.col(1) == c1)
    assert(m.col(2) == c2)
    assertThrows[MatchError] {m.col(3)}
  }

  test("Matrix vector product") {
    val mat = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val vec = Vec3f(1.5f, 2.5f, 3.5f)
    val res = Vec3f(17.0f, 39.5f, 62.0f)
    assert(mat * vec === res)
  }

  test("Matrix vector product with values") {
    val mat = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val res = Vec3f(17.0f, 39.5f, 62.0f)
    assert(mat * (1.5f, 2.5f, 3.5f) === res)
  }

  test("Matrix vector product with a 2D vector and a third value") {
    val mat = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val vec = Vec2f(1.5f, 2.5f)
    val res = Vec3f(17.0f, 39.5f, 62.0f)
    assert(mat * (vec, 3.5f) === res)
  }

  test("Matrix product with 3x3 matrix") {
    val m1 = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val m2 = Mat3f(3.0f, 4.0f, 1.0f, 2.0f, 7.0f, 5.0f, 9.0f, 6.0f, 8.0f)
    val res = Mat3f(34.0f, 36.0f, 35.0f, 76.0f, 87.0f, 77.0f, 118.0f, 138.0f, 119.0f)
    assert(m1 * m2 === res)
  }

  test("Matrix product with 3x4 matrix") {
    val m1 = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val m2 = Mat3x4f(3.0f, 4.0f, 1.0f, 2.0f, 7.0f, 5.0f, 9.0f, 6.0f, 8.0f, 10.0f, 11.0f, 12.0f)
    val res = Mat3x4f(41.0f, 44.0f, 52.0f, 50.0f, 95.0f, 101.0f, 115.0f, 110.0f, 149.0f, 158.0f, 178.0f, 170.0f)
    assert(m1 * m2 === res)
  }

  test("Transposed matrix") {
    val m = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val t = Mat3f(1.0f, 4.0f, 7.0f, 2.0f, 5.0f, 8.0f, 3.0f, 6.0f, 9.0f)
    assert(m.transposed == t)
  }

  test("Symmetric matrix") {
    val m1 = Mat3f(1.0f, 2.0f, 3.0f, 2.0f, 4.0f, 5.0f, 3.0f, 5.0f, 6.0f)
    val m2 = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    assert(m1.isSymmetric)
    assert(!m2.isSymmetric)
  }

  test("Skew-symmetric matrix") {
    val m1 = Mat3f(1.0f, 2.0f, 3.0f, 2.0f, 4.0f, 5.0f, 3.0f, 5.0f, 6.0f)
    val m2 = Mat3f(0.0f, 1.0f, 2.0f, -1.0f, 0.0f, 3.0f, -2.0f, -3.0f, 0.0f)
    assert(!m1.isSkewSymmetric)
    assert(m2.isSkewSymmetric)
  }

  test("Submatrix") {
    val m = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    assert(m.submatrix(0, 0) == Mat2f(5.0f, 6.0f, 8.0f, 9.0f))
    assert(m.submatrix(0, 1) == Mat2f(4.0f, 6.0f, 7.0f, 9.0f))
    assert(m.submatrix(0, 2) == Mat2f(4.0f, 5.0f, 7.0f, 8.0f))
    assert(m.submatrix(1, 0) == Mat2f(2.0f, 3.0f, 8.0f, 9.0f))
    assert(m.submatrix(1, 1) == Mat2f(1.0f, 3.0f, 7.0f, 9.0f))
    assert(m.submatrix(1, 2) == Mat2f(1.0f, 2.0f, 7.0f, 8.0f))
    assert(m.submatrix(2, 0) == Mat2f(2.0f, 3.0f, 5.0f, 6.0f))
    assert(m.submatrix(2, 1) == Mat2f(1.0f, 3.0f, 4.0f, 6.0f))
    assert(m.submatrix(2, 2) == Mat2f(1.0f, 2.0f, 4.0f, 5.0f))
  }

  test("Matrix determinant") {
    val m = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 0.0f, 0.0f, 1.0f)
    assert(m.determinant == -3.0f)
  }

  test("Adjugate matrix") {
    val mat = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val adj = Mat3f(-3.0f, 6.0f, -3.0f, 6.0f, -12.0f, 6.0f, -3.0f, 6.0f, -3.0f)
    assert(mat.adjugate == adj)
  }

  test("Inverse matrix") {
    val mat = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 0.0f, 0.0f, 1.0f)
    val inv = Mat3f(-5.0f / 3.0f, 2.0f / 3.0f, 1.0f, 4.0f / 3.0f, -1.0f / 3.0f, -2.0f, 0.0f, 0.0f, 1.0f)
    assert(mat.inverse === inv)
  }

  test("Power of a matrix with a positive exponent") {
    val m = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    assert(m.power(3) === m * m * m)
  }

  test("Matrix to the power of zero") {
    val m = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    assert(m.power(0) == Mat3f.Identity)
  }

  test("Matrix to the power of one") {
    val m = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    assert(m.power(1) == m)
  }

  test("Power of a matrix with a negative exponent") {
    val m = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val i = m.inverse
    assert(m.power(-3) === i * i * i)
  }

  test("Lerp elements") {
    val from = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val to = Mat3f(2.0f, 4.0f, 6.0f, 8.0f, 10.0f, 12.0f, 14.0f, 16.0f, 18.0f)
    val res = Mat3f(1.5f, 3.0f, 4.5f, 6.0f, 7.5f, 9.0f, 10.5f, 12.0f, 13.5f)
    assert(from.lerp(to, 0.5f) === res)
  }

  test("Absolute values of the elements of a matrix") {
    val mat = Mat3f(1.0f, 2.0f, 0.0f, -2.0f, 3.0f, -1.0f, -3.0f, 0.0f, 1.0f)
    val abs = Mat3f(1.0f, 2.0f, 0.0f, 2.0f, 3.0f, 1.0f, 3.0f, 0.0f, 1.0f)
    assert(mat.abs == abs)
  }

  test("Sign values of the elements of a matrix") {
    val mat = Mat3f(1.0f, 2.0f, 0.0f, -2.0f, 3.0f, -1.0f, -3.0f, 0.0f, 1.0f)
    val sign = Mat3f(1.0f, 1.0f, 0.0f, -1.0f, 1.0f, -1.0f, -1.0f, 0.0f, 1.0f)
    assert(mat.sign == sign)
  }

  test("Round the elements of a matrix") {
    val mat = Mat3f(1.1f, 1.9f, 0.2f, 0.8f, 2.1f, 2.9f, 2.7f, 2.3f, 0.9f)
    val round = Mat3f(1.0f, 2.0f, 0.0f, 1.0f, 2.0f, 3.0f, 3.0f, 2.0f, 1.0f)
    assert(mat.round == round)
  }

  test("Ceil the elements of a matrix") {
    val mat = Mat3f(1.1f, 1.9f, 0.2f, 0.8f, 2.1f, 2.9f, 2.7f, 2.3f, 0.9f)
    val ceil = Mat3f(2.0f, 2.0f, 1.0f, 1.0f, 3.0f, 3.0f, 3.0f, 3.0f, 1.0f)
    assert(mat.ceil == ceil)
  }

  test("Floor the elements of a matrix") {
    val mat = Mat3f(1.1f, 1.9f, 0.2f, 0.8f, 2.1f, 2.9f, 2.7f, 2.3f, 0.9f)
    val floor = Mat3f(1.0f, 1.0f, 0.0f, 0.0f, 2.0f, 2.0f, 2.0f, 2.0f, 0.0f)
    assert(mat.floor == floor)
  }

  // TODO: Orthonormalize

  test("Matrix equals approx") {
    val m1 = Mat3f(1.00000001f, 1.99999999f, 3.00000001f, 3.99999999f, 5.00000001f, 5.99999999f, 7.00000001f, 7.99999999f, 9.00000001f)
    val m2 = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    assert(m1 ~= m2)
  }

  test("Get element at index") {
    val m = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    assert(m(0, 0) == 1.0f)
    assert(m(0, 1) == 2.0f)
    assert(m(0, 2) == 3.0f)
    assert(m(1, 0) == 4.0f)
    assert(m(1, 1) == 5.0f)
    assert(m(1, 2) == 6.0f)
    assert(m(2, 0) == 7.0f)
    assert(m(2, 1) == 8.0f)
    assert(m(2, 2) == 9.0f)
    assertThrows[MatchError] {m(3, 0)}
    assertThrows[MatchError] {m(0, 3)}
    assertThrows[MatchError] {m(3, 3)}
  }

  test("Construct matrix from rows") {
    val m = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val r0 = Vec3f(1.0f, 2.0f, 3.0f)
    val r1 = Vec3f(4.0f, 5.0f, 6.0f)
    val r2 = Vec3f(7.0f, 8.0f, 9.0f)
    assert(Mat3f.fromRows(r0, r1, r2) == m)
  }

  test("Construct matrix from columns") {
    val m = Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f)
    val c0 = Vec3f(1.0f, 4.0f, 7.0f)
    val c1 = Vec3f(2.0f, 5.0f, 8.0f)
    val c2 = Vec3f(3.0f, 6.0f, 9.0f)
    assert(Mat3f.fromColumns(c0, c1, c2) == m)
  }

  test("Translation matrix from values") {
    val v1 = Vec2f(1.0f, 2.0f)
    val v2 = Vec2f(4.0f, 6.0f)
    val m = Mat3f.translation(3.0f, 4.0f)
    assert((m * (v1, 1.0f)).xy === v2)
  }

  test("Translation matrix from vector") {
    val v = Vec2f(1.0f, 2.0f)
    val t = Vec2f(3.0f, 4.0f)
    val m = Mat3f.translation(t)
    assert((m * (v, 1.0f)).xy === v + t)
  }

  // TODO: Rotation matrices

  test("Scaling matrix from values") {
    val v1 = Vec3f(1.5f, 1.5f, 1.5f)
    val v2 = Vec3f(3.0f, 4.5f, 6.0f)
    val m = Mat3f.scaling(2.0f, 3.0f, 4.0f)
    assert(m * v1 === v2)
  }

  test("Scaling matrix from 3D vector") {
    val v = Vec3f(1.5f, 1.5f, 1.5f)
    val s = Vec3f(2.0f, 3.0f, 4.0f)
    val m = Mat3f.scaling(s)
    assert(m * v === v * s)
  }

  test("Scaling matrix from 2D vector") {
    val v = Vec2f(1.5f, 1.5f)
    val s = Vec2f(2.0f, 3.0f)
    val m = Mat3f.scaling(s)
    assert((m * (v, 0.0f)).xy === v * s)
  }
}
