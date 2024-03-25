package io.github.scalamath.vecmatlib

import org.scalactic.Equality
import org.scalatest.funsuite.AnyFunSuite

class Mat4dSuite extends AnyFunSuite {

  implicit val equalityMat4d: Equality[Mat4d] = (a: Mat4d, b: Any) => b match {
    case b: Mat4d => a ~= b
    case _ => false
  }

  implicit val equalityVec4d: Equality[Vec4d] = (a: Vec4d, b: Any) => b match {
    case b: Vec4d => a ~= b
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
    val m1 = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val m2 = Mat4d(3.0, 4.0, 1.0, 2.0, 7.0, 5.0, 9.0, 6.0, 8.0, 11.0, 14.0, 16.0, 15.0, 13.0, 12.0, 10.0)
    val res = Mat4d(4.0, 6.0, 4.0, 6.0, 12.0, 11.0, 16.0, 14.0, 17.0, 21.0, 25.0, 28.0, 28.0, 27.0, 27.0, 26.0)
    assert(m1 + m2 === res)
  }

  test("Unary plus") {
    val m = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    assert(+m == m)
  }

  test("Subtraction of two matrices") {
    val m1 = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val m2 = Mat4d(3.0, 4.0, 1.0, 2.0, 7.0, 5.0, 9.0, 6.0, 8.0, 11.0, 14.0, 16.0, 15.0, 13.0, 12.0, 10.0)
    val res = Mat4d(2.0, 2.0, -2.0, -2.0, 2.0, -1.0, 2.0, -2.0, -1.0, 1.0, 3.0, 4.0, 2.0, -1.0, -3.0, -6.0)
    assert(m2 - m1 === res)
  }

  test("Unary minus") {
    val m = Mat4d(1.0, 2.0, -2.0, -1.0, 3.0, -2.0, 0.0, -9.0, 4.0, 2.0, -5.0, -4.0, 7.0, 2.0, 8.0, 0.0)
    val r = Mat4d(-1.0, -2.0, 2.0, 1.0, -3.0, 2.0, 0.0, 9.0, -4.0, -2.0, 5.0, 4.0, -7.0, -2.0, -8.0, 0.0)
    assert(-m == r)
  }

  test("Matrix multiplied by a scalar") {
    val m = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val r = Mat4d(1.5, 3.0, 4.5, 6.0, 7.5, 9.0, 10.5, 12.0, 13.5, 15.0, 16.5, 18.0, 19.5, 21.0, 22.5, 24.0)
    assert(m * 1.5 === r)
  }

  test("Matrix divided by a scalar") {
    val m = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val r = Mat4d(0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0, 5.5, 6.0, 6.5, 7.0, 7.5, 8.0)
    assert(m / 2.0 === r)
  }

  test("Get the rows of the matrix") {
    val m = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val r0 = Vec4d(1.0, 2.0, 3.0, 4.0)
    val r1 = Vec4d(5.0, 6.0, 7.0, 8.0)
    val r2 = Vec4d(9.0, 10.0, 11.0, 12.0)
    val r3 = Vec4d(13.0, 14.0, 15.0, 16.0)
    assert(m.row0 == r0)
    assert(m.row1 == r1)
    assert(m.row2 == r2)
    assert(m.row3 == r3)
  }

  test("Get row at index") {
    val m = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val r0 = Vec4d(1.0, 2.0, 3.0, 4.0)
    val r1 = Vec4d(5.0, 6.0, 7.0, 8.0)
    val r2 = Vec4d(9.0, 10.0, 11.0, 12.0)
    val r3 = Vec4d(13.0, 14.0, 15.0, 16.0)
    assert(m.row(0) == r0)
    assert(m.row(1) == r1)
    assert(m.row(2) == r2)
    assert(m.row(3) == r3)
    assertThrows[MatchError] {m.row(4)}
  }

  test("Get the columns of the matrix") {
    val m = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val c0 = Vec4d(1.0, 5.0, 9.0, 13.0)
    val c1 = Vec4d(2.0, 6.0, 10.0, 14.0)
    val c2 = Vec4d(3.0, 7.0, 11.0, 15.0)
    val c3 = Vec4d(4.0, 8.0, 12.0, 16.0)
    assert(m.col0 == c0)
    assert(m.col1 == c1)
    assert(m.col2 == c2)
    assert(m.col3 == c3)
  }

  test("Get column at index") {
    val m = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val c0 = Vec4d(1.0, 5.0, 9.0, 13.0)
    val c1 = Vec4d(2.0, 6.0, 10.0, 14.0)
    val c2 = Vec4d(3.0, 7.0, 11.0, 15.0)
    val c3 = Vec4d(4.0, 8.0, 12.0, 16.0)
    assert(m.col(0) == c0)
    assert(m.col(1) == c1)
    assert(m.col(2) == c2)
    assert(m.col(3) == c3)
    assertThrows[MatchError] {m.col(4)}
  }

  test("Matrix vector product") {
    val mat = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val vec = Vec4d(1.5, 2.5, 3.5, 4.5)
    val res = Vec4d(35.0, 83.0, 131.0, 179.0)
    assert(mat * vec === res)
  }

  test("Matrix vector product with values") {
    val mat = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val res = Vec4d(35.0, 83.0, 131.0, 179.0)
    assert(mat * (1.5, 2.5, 3.5, 4.5) === res)
  }

  test("Matrix vector product with a 3D vector and a fourth value") {
    val mat = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val vec = Vec3d(1.5, 2.5, 3.5)
    val res = Vec4d(35.0, 83.0, 131.0, 179.0)
    assert(mat * (vec, 4.5) === res)
  }

  test("Matrix vector product with a 2D vector and a two values") {
    val mat = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val vec = Vec2d(1.5, 2.5)
    val res = Vec4d(35.0, 83.0, 131.0, 179.0)
    assert(mat * (vec, 3.5, 4.5) === res)
  }

  test("Matrix product with 4x4 matrix") {
    val m1 = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val m2 = Mat4d(3.0, 4.0, 1.0, 2.0, 7.0, 5.0, 9.0, 6.0, 8.0, 11.0, 14.0, 16.0, 15.0, 13.0, 12.0, 10.0)
    val res = Mat4d(101.0, 99.0, 109.0, 102.0, 233.0, 231.0, 253.0, 238.0, 365.0, 363.0, 397.0, 374.0, 497.0, 495.0, 541.0, 510.0)
    assert(m1 * m2 === res)
  }

  test("Transposed matrix") {
    val m = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val t = Mat4d(1.0, 5.0, 9.0, 13.0, 2.0, 6.0, 10.0, 14.0, 3.0, 7.0, 11.0, 15.0, 4.0, 8.0, 12.0, 16.0)
    assert(m.transposed == t)
  }

  test("Symmetric matrix") {
    val m1 = Mat4d(1.0, 2.0, 3.0, 4.0, 2.0, 5.0, 6.0, 7.0, 3.0, 6.0, 8.0, 9.0, 4.0, 7.0, 9.0, 10.0)
    val m2 = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    assert(m1.isSymmetric)
    assert(!m2.isSymmetric)
  }

  test("Skew-symmetric matrix") {
    val m1 = Mat4d(1.0, 2.0, 3.0, 4.0, 2.0, 5.0, 6.0, 7.0, 3.0, 6.0, 8.0, 9.0, 4.0, 7.0, 9.0, 10.0)
    val m2 = Mat4d(0.0, 1.0, 2.0, 3.0, -1.0, 0.0, 4.0, 5.0, -2.0, -4.0, 0.0, 6.0, -3.0, -5.0, -6.0, 0.0)
    assert(!m1.isSkewSymmetric)
    assert(m2.isSkewSymmetric)
  }

  test("Submatrix") {
    val m = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    assert(m.submatrix(0, 0) == Mat3d(6.0, 7.0, 8.0, 10.0, 11.0, 12.0, 14.0, 15.0, 16.0))
    assert(m.submatrix(0, 1) == Mat3d(5.0, 7.0, 8.0, 9.0, 11.0, 12.0, 13.0, 15.0, 16.0))
    assert(m.submatrix(0, 2) == Mat3d(5.0, 6.0, 8.0, 9.0, 10.0, 12.0, 13.0, 14.0, 16.0))
    assert(m.submatrix(0, 3) == Mat3d(5.0, 6.0, 7.0, 9.0, 10.0, 11.0, 13.0, 14.0, 15.0))
    assert(m.submatrix(1, 0) == Mat3d(2.0, 3.0, 4.0, 10.0, 11.0, 12.0, 14.0, 15.0, 16.0))
    assert(m.submatrix(1, 1) == Mat3d(1.0, 3.0, 4.0, 9.0, 11.0, 12.0, 13.0, 15.0, 16.0))
    assert(m.submatrix(1, 2) == Mat3d(1.0, 2.0, 4.0, 9.0, 10.0, 12.0, 13.0, 14.0, 16.0))
    assert(m.submatrix(1, 3) == Mat3d(1.0, 2.0, 3.0, 9.0, 10.0, 11.0, 13.0, 14.0, 15.0))
    assert(m.submatrix(2, 0) == Mat3d(2.0, 3.0, 4.0, 6.0, 7.0, 8.0, 14.0, 15.0, 16.0))
    assert(m.submatrix(2, 1) == Mat3d(1.0, 3.0, 4.0, 5.0, 7.0, 8.0, 13.0, 15.0, 16.0))
    assert(m.submatrix(2, 2) == Mat3d(1.0, 2.0, 4.0, 5.0, 6.0, 8.0, 13.0, 14.0, 16.0))
    assert(m.submatrix(2, 3) == Mat3d(1.0, 2.0, 3.0, 5.0, 6.0, 7.0, 13.0, 14.0, 15.0))
    assert(m.submatrix(3, 0) == Mat3d(2.0, 3.0, 4.0, 6.0, 7.0, 8.0, 10.0, 11.0, 12.0))
    assert(m.submatrix(3, 1) == Mat3d(1.0, 3.0, 4.0, 5.0, 7.0, 8.0, 9.0, 11.0, 12.0))
    assert(m.submatrix(3, 2) == Mat3d(1.0, 2.0, 4.0, 5.0, 6.0, 8.0, 9.0, 10.0, 12.0))
    assert(m.submatrix(3, 3) == Mat3d(1.0, 2.0, 3.0, 5.0, 6.0, 7.0, 9.0, 10.0, 11.0))
  }

  test("Matrix determinant") {
    val m = Mat4d(1.0, 3.0, 5.0, 9.0, 1.0, 3.0, 1.0, 7.0, 4.0, 3.0, 9.0, 7.0, 5.0, 2.0, 0.0, 9.0)
    assert(m.determinant == -376.0)
  }

  test("Adjugate matrix") {
    val mat = Mat4d(1.0, 3.0, 5.0, 9.0, 1.0, 3.0, 1.0, 7.0, 4.0, 3.0, 9.0, 7.0, 5.0, 2.0, 0.0, 9.0)
    val adj = Mat4d(104.0, -16.0, -56.0, -48.0, 235.0, -329.0, -94.0, 94.0, -39.0, 53.0, -26.0, 18.0, -110.0, 82.0, 52.0, -36.0)
    assert(mat.adjugate === adj)
  }

  test("Inverse matrix") {
    val mat = Mat4d(1.0, 3.0, 5.0, 9.0, 1.0, 3.0, 1.0, 7.0, 4.0, 3.0, 9.0, 7.0, 5.0, 2.0, 0.0, 9.0)
    val inv = Mat4d(-13.0 / 47.0, 2.0 / 47.0, 7.0 / 47.0, 6.0 / 47.0, -5.0 / 8.0, 7.0 / 8.0, 1.0 / 4.0, -1.0 / 4.0, 39.0 / 376.0, -53.0 / 376.0, 13.0 / 188.0, -9.0 / 188.0, 55.0 / 188.0, -41.0 / 188.0, -13.0 / 94.0, 9.0 / 94.0)
    assert(mat.inverse === inv)
  }

  test("Power of a matrix with a positive exponent") {
    val m = Mat4d(1.0, 3.0, 5.0, 9.0, 1.0, 3.0, 1.0, 7.0, 4.0, 3.0, 9.0, 7.0, 5.0, 2.0, 0.0, 9.0)
    assert(m.power(3) === m * m * m)
  }

  test("Matrix to the power of zero") {
    val m = Mat4d(1.0, 3.0, 5.0, 9.0, 1.0, 3.0, 1.0, 7.0, 4.0, 3.0, 9.0, 7.0, 5.0, 2.0, 0.0, 9.0)
    assert(m.power(0) == Mat4d.Identity)
  }

  test("Matrix to the power of one") {
    val m = Mat4d(1.0, 3.0, 5.0, 9.0, 1.0, 3.0, 1.0, 7.0, 4.0, 3.0, 9.0, 7.0, 5.0, 2.0, 0.0, 9.0)
    assert(m.power(1) == m)
  }

  test("Power of a matrix with a negative exponent") {
    val m = Mat4d(1.0, 3.0, 5.0, 9.0, 1.0, 3.0, 1.0, 7.0, 4.0, 3.0, 9.0, 7.0, 5.0, 2.0, 0.0, 9.0)
    val i = m.inverse
    assert(m.power(-3) === i * i * i)
  }

  test("Lerp elements") {
    val from = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val to = Mat4d(2.0, 4.0, 6.0, 8.0, 10.0, 12.0, 14.0, 16.0, 18.0, 20.0, 22.0, 24.0, 26.0, 28.0, 30.0, 32.0)
    val res = Mat4d(1.5, 3.0, 4.5, 6.0, 7.5, 9.0, 10.5, 12.0, 13.5, 15.0, 16.5, 18.0, 19.5, 21.0, 22.5, 24.0)
    assert(from.lerp(to, 0.5) === res)
  }

  test("Absolute values of the elements of a matrix") {
    val mat = Mat4d(1.0, 2.0, 0.0, -2.0, 3.0, -1.0, -3.0, 0.0, 1.0, -3.0, 2.0, 6.0, -1.0, -7.0, 4.0, 0.0)
    val abs = Mat4d(1.0, 2.0, 0.0, 2.0, 3.0, 1.0, 3.0, 0.0, 1.0, 3.0, 2.0, 6.0, 1.0, 7.0, 4.0, 0.0)
    assert(mat.abs == abs)
  }

  test("Sign values of the elements of a matrix") {
    val mat = Mat4d(1.0, 2.0, 0.0, -2.0, 3.0, -1.0, -3.0, 0.0, 1.0, -3.0, 2.0, 6.0, -1.0, -7.0, 4.0, 0.0)
    val sign = Mat4d(1.0, 1.0, 0.0, -1.0, 1.0, -1.0, -1.0, 0.0, 1.0, -1.0, 1.0, 1.0, -1.0, -1.0, 1.0, 0.0)
    assert(mat.sign == sign)
  }

  test("Round the elements of a matrix") {
    val mat = Mat4d(1.1, 1.9, 0.2, 0.8, 2.1, 2.9, 2.7, 2.3, 0.9, 5.9, 5.4, 6.6, 1.2, 1.1, 0.9, 2.6)
    val round = Mat4d(1.0, 2.0, 0.0, 1.0, 2.0, 3.0, 3.0, 2.0, 1.0, 6.0, 5.0, 7.0, 1.0, 1.0, 1.0, 3.0)
    assert(mat.round == round)
  }

  test("Ceil the elements of a matrix") {
    val mat = Mat4d(1.1, 1.9, 0.2, 0.8, 2.1, 2.9, 2.7, 2.3, 0.9, 5.9, 5.4, 6.6, 1.2, 1.1, 0.9, 2.6)
    val ceil = Mat4d(2.0, 2.0, 1.0, 1.0, 3.0, 3.0, 3.0, 3.0, 1.0, 6.0, 6.0, 7.0, 2.0, 2.0, 1.0, 3.0)
    assert(mat.ceil == ceil)
  }

  test("Floor the elements of a matrix") {
    val mat = Mat4d(1.1, 1.9, 0.2, 0.8, 2.1, 2.9, 2.7, 2.3, 0.9, 5.9, 5.4, 6.6, 1.2, 1.1, 0.9, 2.6)
    val floor = Mat4d(1.0, 1.0, 0.0, 0.0, 2.0, 2.0, 2.0, 2.0, 0.0, 5.0, 5.0, 6.0, 1.0, 1.0, 0.0, 2.0)
    assert(mat.floor == floor)
  }

  // TODO: Orthonormalize

  test("Matrix equals approx") {
    val m1 = Mat4d(1.00000001, 1.99999999, 3.00000001, 3.99999999, 5.00000001, 5.99999999, 7.00000001, 7.99999999, 9.00000001, 0.00000001, 1.00000001, 0.99999999, 3.99999999, 4.00000001, 2.99999999, 1.00000001)
    val m2 = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 0.0, 1.0, 1.0, 4.0, 4.0, 3.0, 1.0)
    assert(m1 ~= m2)
  }

  test("Get element at index") {
    val m = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    assert(m(0, 0) == 1.0)
    assert(m(0, 1) == 2.0)
    assert(m(0, 2) == 3.0)
    assert(m(0, 3) == 4.0)
    assert(m(1, 0) == 5.0)
    assert(m(1, 1) == 6.0)
    assert(m(1, 2) == 7.0)
    assert(m(1, 3) == 8.0)
    assert(m(2, 0) == 9.0)
    assert(m(2, 1) == 10.0)
    assert(m(2, 2) == 11.0)
    assert(m(2, 3) == 12.0)
    assert(m(3, 0) == 13.0)
    assert(m(3, 1) == 14.0)
    assert(m(3, 2) == 15.0)
    assert(m(3, 3) == 16.0)
    assertThrows[MatchError] {m(4, 0)}
    assertThrows[MatchError] {m(0, 4)}
    assertThrows[MatchError] {m(4, 4)}
  }

  test("Construct matrix from rows") {
    val m = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val r0 = Vec4d(1.0, 2.0, 3.0, 4.0)
    val r1 = Vec4d(5.0, 6.0, 7.0, 8.0)
    val r2 = Vec4d(9.0, 10.0, 11.0, 12.0)
    val r3 = Vec4d(13.0, 14.0, 15.0, 16.0)
    assert(Mat4d.fromRows(r0, r1, r2, r3) == m)
  }

  test("Construct matrix from columns") {
    val m = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val c0 = Vec4d(1.0, 5.0, 9.0, 13.0)
    val c1 = Vec4d(2.0, 6.0, 10.0, 14.0)
    val c2 = Vec4d(3.0, 7.0, 11.0, 15.0)
    val c3 = Vec4d(4.0, 8.0, 12.0, 16.0)
    assert(Mat4d.fromColumns(c0, c1, c2, c3) == m)
  }

  test("Translation matrix from values") {
    val v1 = Vec3d(1.0, 2.0, 3.0)
    val v2 = Vec3d(4.0, 6.0, 5.0)
    val m = Mat4d.translation(3.0, 4.0, 2.0)
    assert((m * (v1, 1.0)).xyz === v2)
  }

  test("Translation matrix from 3D vector") {
    val v = Vec3d(1.0, 2.0, 3.0)
    val t = Vec3d(3.0, 4.0, 2.0)
    val m = Mat4d.translation(t)
    assert((m * (v, 1.0)).xyz === v + t)
  }

  test("Translation matrix from 2D vector") {
    val v = Vec2d(1.0, 2.0)
    val t = Vec2d(3.0, 4.0)
    val m = Mat4d.translation(t)
    assert((m * (v, 0.0, 1.0)).xy === v + t)
  }

  // TODO: Rotation matrices

  test("Scaling matrix from values") {
    val v1 = Vec3d(1.5, 1.5, 1.5)
    val v2 = Vec3d(3.0, 4.5, 6.0)
    val m = Mat4d.scaling(2.0, 3.0, 4.0)
    assert((m * (v1, 0.0)).xyz === v2)
  }

  test("Scaling matrix from 3D vector") {
    val v = Vec3d(1.5, 1.5, 1.5)
    val s = Vec3d(2.0, 3.0, 4.0)
    val m = Mat4d.scaling(s)
    assert((m * (v, 0.0)).xyz === v * s)
  }

  test("Scaling matrix from 2D vector") {
    val v = Vec2d(1.5, 1.5)
    val s = Vec2d(2.0, 3.0)
    val m = Mat4d.scaling(s)
    assert((m * (v, 0.0, 0.0)).xy === v * s)
  }
}
