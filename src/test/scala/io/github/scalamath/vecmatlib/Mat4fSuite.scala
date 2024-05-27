package io.github.scalamath.vecmatlib

import org.scalactic.Equality
import org.scalatest.funsuite.AnyFunSuite

class Mat4fSuite extends AnyFunSuite {

  implicit val equalityMat4f: Equality[Mat4f] = (a: Mat4f, b: Any) => b match {
    case b: Mat4f => a ~= b
    case _ => false
  }

  implicit val equalityVec4f: Equality[Vec4f] = (a: Vec4f, b: Any) => b match {
    case b: Vec4f => a ~= b
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
    val m1 = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    val m2 = Mat4f(3.0f, 4.0f, 1.0f, 2.0f, 7.0f, 5.0f, 9.0f, 6.0f, 8.0f, 11.0f, 14.0f, 16.0f, 15.0f, 13.0f, 12.0f, 10.0f)
    val res = Mat4f(4.0f, 6.0f, 4.0f, 6.0f, 12.0f, 11.0f, 16.0f, 14.0f, 17.0f, 21.0f, 25.0f, 28.0f, 28.0f, 27.0f, 27.0f, 26.0f)
    assert(m1 + m2 === res)
  }

  test("Unary plus") {
    val m = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    assert(+m == m)
  }

  test("Subtraction of two matrices") {
    val m1 = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    val m2 = Mat4f(3.0f, 4.0f, 1.0f, 2.0f, 7.0f, 5.0f, 9.0f, 6.0f, 8.0f, 11.0f, 14.0f, 16.0f, 15.0f, 13.0f, 12.0f, 10.0f)
    val res = Mat4f(2.0f, 2.0f, -2.0f, -2.0f, 2.0f, -1.0f, 2.0f, -2.0f, -1.0f, 1.0f, 3.0f, 4.0f, 2.0f, -1.0f, -3.0f, -6.0f)
    assert(m2 - m1 === res)
  }

  test("Unary minus") {
    val m = Mat4f(1.0f, 2.0f, -2.0f, -1.0f, 3.0f, -2.0f, 0.0f, -9.0f, 4.0f, 2.0f, -5.0f, -4.0f, 7.0f, 2.0f, 8.0f, 0.0f)
    val r = Mat4f(-1.0f, -2.0f, 2.0f, 1.0f, -3.0f, 2.0f, 0.0f, 9.0f, -4.0f, -2.0f, 5.0f, 4.0f, -7.0f, -2.0f, -8.0f, 0.0f)
    assert(-m == r)
  }

  test("Matrix multiplied by a scalar") {
    val m = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    val r = Mat4f(1.5f, 3.0f, 4.5f, 6.0f, 7.5f, 9.0f, 10.5f, 12.0f, 13.5f, 15.0f, 16.5f, 18.0f, 19.5f, 21.0f, 22.5f, 24.0f)
    assert(m * 1.5f === r)
  }

  test("Matrix divided by a scalar") {
    val m = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    val r = Mat4f(0.5f, 1.0f, 1.5f, 2.0f, 2.5f, 3.0f, 3.5f, 4.0f, 4.5f, 5.0f, 5.5f, 6.0f, 6.5f, 7.0f, 7.5f, 8.0f)
    assert(m / 2.0f === r)
  }

  test("Get the rows of the matrix") {
    val m = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    val r0 = Vec4f(1.0f, 2.0f, 3.0f, 4.0f)
    val r1 = Vec4f(5.0f, 6.0f, 7.0f, 8.0f)
    val r2 = Vec4f(9.0f, 10.0f, 11.0f, 12.0f)
    val r3 = Vec4f(13.0f, 14.0f, 15.0f, 16.0f)
    assert(m.row0 == r0)
    assert(m.row1 == r1)
    assert(m.row2 == r2)
    assert(m.row3 == r3)
  }

  test("Get row at index") {
    val m = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    val r0 = Vec4f(1.0f, 2.0f, 3.0f, 4.0f)
    val r1 = Vec4f(5.0f, 6.0f, 7.0f, 8.0f)
    val r2 = Vec4f(9.0f, 10.0f, 11.0f, 12.0f)
    val r3 = Vec4f(13.0f, 14.0f, 15.0f, 16.0f)
    assert(m.row(0) == r0)
    assert(m.row(1) == r1)
    assert(m.row(2) == r2)
    assert(m.row(3) == r3)
    assertThrows[MatchError] {m.row(4)}
  }

  test("Get the columns of the matrix") {
    val m = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    val c0 = Vec4f(1.0f, 5.0f, 9.0f, 13.0f)
    val c1 = Vec4f(2.0f, 6.0f, 10.0f, 14.0f)
    val c2 = Vec4f(3.0f, 7.0f, 11.0f, 15.0f)
    val c3 = Vec4f(4.0f, 8.0f, 12.0f, 16.0f)
    assert(m.col0 == c0)
    assert(m.col1 == c1)
    assert(m.col2 == c2)
    assert(m.col3 == c3)
  }

  test("Get column at index") {
    val m = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    val c0 = Vec4f(1.0f, 5.0f, 9.0f, 13.0f)
    val c1 = Vec4f(2.0f, 6.0f, 10.0f, 14.0f)
    val c2 = Vec4f(3.0f, 7.0f, 11.0f, 15.0f)
    val c3 = Vec4f(4.0f, 8.0f, 12.0f, 16.0f)
    assert(m.col(0) == c0)
    assert(m.col(1) == c1)
    assert(m.col(2) == c2)
    assert(m.col(3) == c3)
    assertThrows[MatchError] {m.col(4)}
  }

  test("Matrix vector product") {
    val mat = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    val vec = Vec4f(1.5f, 2.5f, 3.5f, 4.5f)
    val res = Vec4f(35.0f, 83.0f, 131.0f, 179.0f)
    assert(mat * vec === res)
  }

  test("Matrix vector product with values") {
    val mat = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    val res = Vec4f(35.0f, 83.0f, 131.0f, 179.0f)
    assert(mat * (1.5f, 2.5f, 3.5f, 4.5f) === res)
  }

  test("Matrix vector product with a 3D vector and a fourth value") {
    val mat = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    val vec = Vec3f(1.5f, 2.5f, 3.5f)
    val res = Vec4f(35.0f, 83.0f, 131.0f, 179.0f)
    assert(mat * (vec, 4.5f) === res)
  }

  test("Matrix vector product with a 2D vector and a two values") {
    val mat = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    val vec = Vec2f(1.5f, 2.5f)
    val res = Vec4f(35.0f, 83.0f, 131.0f, 179.0f)
    assert(mat * (vec, 3.5f, 4.5f) === res)
  }

  test("Matrix product with 4x4 matrix") {
    val m1 = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    val m2 = Mat4f(3.0f, 4.0f, 1.0f, 2.0f, 7.0f, 5.0f, 9.0f, 6.0f, 8.0f, 11.0f, 14.0f, 16.0f, 15.0f, 13.0f, 12.0f, 10.0f)
    val res = Mat4f(101.0f, 99.0f, 109.0f, 102.0f, 233.0f, 231.0f, 253.0f, 238.0f, 365.0f, 363.0f, 397.0f, 374.0f, 497.0f, 495.0f, 541.0f, 510.0f)
    assert(m1 * m2 === res)
  }

  test("Transposed matrix") {
    val m = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    val t = Mat4f(1.0f, 5.0f, 9.0f, 13.0f, 2.0f, 6.0f, 10.0f, 14.0f, 3.0f, 7.0f, 11.0f, 15.0f, 4.0f, 8.0f, 12.0f, 16.0f)
    assert(m.transposed == t)
  }

  test("Symmetric matrix") {
    val m1 = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 2.0f, 5.0f, 6.0f, 7.0f, 3.0f, 6.0f, 8.0f, 9.0f, 4.0f, 7.0f, 9.0f, 10.0f)
    val m2 = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    assert(m1.isSymmetric)
    assert(!m2.isSymmetric)
  }

  test("Skew-symmetric matrix") {
    val m1 = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 2.0f, 5.0f, 6.0f, 7.0f, 3.0f, 6.0f, 8.0f, 9.0f, 4.0f, 7.0f, 9.0f, 10.0f)
    val m2 = Mat4f(0.0f, 1.0f, 2.0f, 3.0f, -1.0f, 0.0f, 4.0f, 5.0f, -2.0f, -4.0f, 0.0f, 6.0f, -3.0f, -5.0f, -6.0f, 0.0f)
    assert(!m1.isSkewSymmetric)
    assert(m2.isSkewSymmetric)
  }

  test("3x3 submatrix") {
    val m = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    assert(m.submatrix(0, 0) == Mat3f(6.0f, 7.0f, 8.0f, 10.0f, 11.0f, 12.0f, 14.0f, 15.0f, 16.0f))
    assert(m.submatrix(0, 1) == Mat3f(5.0f, 7.0f, 8.0f, 9.0f, 11.0f, 12.0f, 13.0f, 15.0f, 16.0f))
    assert(m.submatrix(0, 2) == Mat3f(5.0f, 6.0f, 8.0f, 9.0f, 10.0f, 12.0f, 13.0f, 14.0f, 16.0f))
    assert(m.submatrix(0, 3) == Mat3f(5.0f, 6.0f, 7.0f, 9.0f, 10.0f, 11.0f, 13.0f, 14.0f, 15.0f))
    assert(m.submatrix(1, 0) == Mat3f(2.0f, 3.0f, 4.0f, 10.0f, 11.0f, 12.0f, 14.0f, 15.0f, 16.0f))
    assert(m.submatrix(1, 1) == Mat3f(1.0f, 3.0f, 4.0f, 9.0f, 11.0f, 12.0f, 13.0f, 15.0f, 16.0f))
    assert(m.submatrix(1, 2) == Mat3f(1.0f, 2.0f, 4.0f, 9.0f, 10.0f, 12.0f, 13.0f, 14.0f, 16.0f))
    assert(m.submatrix(1, 3) == Mat3f(1.0f, 2.0f, 3.0f, 9.0f, 10.0f, 11.0f, 13.0f, 14.0f, 15.0f))
    assert(m.submatrix(2, 0) == Mat3f(2.0f, 3.0f, 4.0f, 6.0f, 7.0f, 8.0f, 14.0f, 15.0f, 16.0f))
    assert(m.submatrix(2, 1) == Mat3f(1.0f, 3.0f, 4.0f, 5.0f, 7.0f, 8.0f, 13.0f, 15.0f, 16.0f))
    assert(m.submatrix(2, 2) == Mat3f(1.0f, 2.0f, 4.0f, 5.0f, 6.0f, 8.0f, 13.0f, 14.0f, 16.0f))
    assert(m.submatrix(2, 3) == Mat3f(1.0f, 2.0f, 3.0f, 5.0f, 6.0f, 7.0f, 13.0f, 14.0f, 15.0f))
    assert(m.submatrix(3, 0) == Mat3f(2.0f, 3.0f, 4.0f, 6.0f, 7.0f, 8.0f, 10.0f, 11.0f, 12.0f))
    assert(m.submatrix(3, 1) == Mat3f(1.0f, 3.0f, 4.0f, 5.0f, 7.0f, 8.0f, 9.0f, 11.0f, 12.0f))
    assert(m.submatrix(3, 2) == Mat3f(1.0f, 2.0f, 4.0f, 5.0f, 6.0f, 8.0f, 9.0f, 10.0f, 12.0f))
    assert(m.submatrix(3, 3) == Mat3f(1.0f, 2.0f, 3.0f, 5.0f, 6.0f, 7.0f, 9.0f, 10.0f, 11.0f))
  }

  test("3x4 submatrix") {
    val m = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    assert(m.submatrix(0) == Mat3x4f(5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f))
    assert(m.submatrix(1) == Mat3x4f(1.0f, 2.0f, 3.0f, 4.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f))
    assert(m.submatrix(2) == Mat3x4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 13.0f, 14.0f, 15.0f, 16.0f))
    assert(m.submatrix(3) == Mat3x4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f))
    assertThrows[MatchError] {m.submatrix(4)}
  }

  test("Matrix determinant") {
    val m = Mat4f(1.0f, 3.0f, 5.0f, 9.0f, 1.0f, 3.0f, 1.0f, 7.0f, 4.0f, 3.0f, 9.0f, 7.0f, 5.0f, 2.0f, 0.0f, 9.0f)
    assert(m.determinant == -376.0f)
  }

  test("Adjugate matrix") {
    val mat = Mat4f(1.0f, 3.0f, 5.0f, 9.0f, 1.0f, 3.0f, 1.0f, 7.0f, 4.0f, 3.0f, 9.0f, 7.0f, 5.0f, 2.0f, 0.0f, 9.0f)
    val adj = Mat4f(104.0f, -16.0f, -56.0f, -48.0f, 235.0f, -329.0f, -94.0f, 94.0f, -39.0f, 53.0f, -26.0f, 18.0f, -110.0f, 82.0f, 52.0f, -36.0f)
    assert(mat.adjugate === adj)
  }

  test("Inverse matrix") {
    val mat = Mat4f(1.0f, 3.0f, 5.0f, 9.0f, 1.0f, 3.0f, 1.0f, 7.0f, 4.0f, 3.0f, 9.0f, 7.0f, 5.0f, 2.0f, 0.0f, 9.0f)
    val inv = Mat4f(-13.0f / 47.0f, 2.0f / 47.0f, 7.0f / 47.0f, 6.0f / 47.0f, -5.0f / 8.0f, 7.0f / 8.0f, 1.0f / 4.0f, -1.0f / 4.0f, 39.0f / 376.0f, -53.0f / 376.0f, 13.0f / 188.0f, -9.0f / 188.0f, 55.0f / 188.0f, -41.0f / 188.0f, -13.0f / 94.0f, 9.0f / 94.0f)
    assert(mat.inverse === inv)
  }

  test("Power of a matrix with a positive exponent") {
    val m = Mat4f(1.0f, 3.0f, 5.0f, 9.0f, 1.0f, 3.0f, 1.0f, 7.0f, 4.0f, 3.0f, 9.0f, 7.0f, 5.0f, 2.0f, 0.0f, 9.0f)
    assert(m.power(3) === m * m * m)
  }

  test("Matrix to the power of zero") {
    val m = Mat4f(1.0f, 3.0f, 5.0f, 9.0f, 1.0f, 3.0f, 1.0f, 7.0f, 4.0f, 3.0f, 9.0f, 7.0f, 5.0f, 2.0f, 0.0f, 9.0f)
    assert(m.power(0) == Mat4f.Identity)
  }

  test("Matrix to the power of one") {
    val m = Mat4f(1.0f, 3.0f, 5.0f, 9.0f, 1.0f, 3.0f, 1.0f, 7.0f, 4.0f, 3.0f, 9.0f, 7.0f, 5.0f, 2.0f, 0.0f, 9.0f)
    assert(m.power(1) == m)
  }

  test("Power of a matrix with a negative exponent") {
    val m = Mat4f(1.0f, 3.0f, 5.0f, 9.0f, 1.0f, 3.0f, 1.0f, 7.0f, 4.0f, 3.0f, 9.0f, 7.0f, 5.0f, 2.0f, 0.0f, 9.0f)
    val i = m.inverse
    assert(m.power(-3) === i * i * i)
  }

  test("Lerp elements") {
    val from = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    val to = Mat4f(2.0f, 4.0f, 6.0f, 8.0f, 10.0f, 12.0f, 14.0f, 16.0f, 18.0f, 20.0f, 22.0f, 24.0f, 26.0f, 28.0f, 30.0f, 32.0f)
    val res = Mat4f(1.5f, 3.0f, 4.5f, 6.0f, 7.5f, 9.0f, 10.5f, 12.0f, 13.5f, 15.0f, 16.5f, 18.0f, 19.5f, 21.0f, 22.5f, 24.0f)
    assert(from.lerp(to, 0.5f) === res)
  }

  test("Absolute values of the elements of a matrix") {
    val mat = Mat4f(1.0f, 2.0f, 0.0f, -2.0f, 3.0f, -1.0f, -3.0f, 0.0f, 1.0f, -3.0f, 2.0f, 6.0f, -1.0f, -7.0f, 4.0f, 0.0f)
    val abs = Mat4f(1.0f, 2.0f, 0.0f, 2.0f, 3.0f, 1.0f, 3.0f, 0.0f, 1.0f, 3.0f, 2.0f, 6.0f, 1.0f, 7.0f, 4.0f, 0.0f)
    assert(mat.abs == abs)
  }

  test("Sign values of the elements of a matrix") {
    val mat = Mat4f(1.0f, 2.0f, 0.0f, -2.0f, 3.0f, -1.0f, -3.0f, 0.0f, 1.0f, -3.0f, 2.0f, 6.0f, -1.0f, -7.0f, 4.0f, 0.0f)
    val sign = Mat4f(1.0f, 1.0f, 0.0f, -1.0f, 1.0f, -1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 0.0f)
    assert(mat.sign == sign)
  }

  test("Round the elements of a matrix") {
    val mat = Mat4f(1.1f, 1.9f, 0.2f, 0.8f, 2.1f, 2.9f, 2.7f, 2.3f, 0.9f, 5.9f, 5.4f, 6.6f, 1.2f, 1.1f, 0.9f, 2.6f)
    val round = Mat4f(1.0f, 2.0f, 0.0f, 1.0f, 2.0f, 3.0f, 3.0f, 2.0f, 1.0f, 6.0f, 5.0f, 7.0f, 1.0f, 1.0f, 1.0f, 3.0f)
    assert(mat.round == round)
  }

  test("Ceil the elements of a matrix") {
    val mat = Mat4f(1.1f, 1.9f, 0.2f, 0.8f, 2.1f, 2.9f, 2.7f, 2.3f, 0.9f, 5.9f, 5.4f, 6.6f, 1.2f, 1.1f, 0.9f, 2.6f)
    val ceil = Mat4f(2.0f, 2.0f, 1.0f, 1.0f, 3.0f, 3.0f, 3.0f, 3.0f, 1.0f, 6.0f, 6.0f, 7.0f, 2.0f, 2.0f, 1.0f, 3.0f)
    assert(mat.ceil == ceil)
  }

  test("Floor the elements of a matrix") {
    val mat = Mat4f(1.1f, 1.9f, 0.2f, 0.8f, 2.1f, 2.9f, 2.7f, 2.3f, 0.9f, 5.9f, 5.4f, 6.6f, 1.2f, 1.1f, 0.9f, 2.6f)
    val floor = Mat4f(1.0f, 1.0f, 0.0f, 0.0f, 2.0f, 2.0f, 2.0f, 2.0f, 0.0f, 5.0f, 5.0f, 6.0f, 1.0f, 1.0f, 0.0f, 2.0f)
    assert(mat.floor == floor)
  }

  // TODO: Orthonormalize

  test("Matrix equals approx") {
    val m1 = Mat4f(1.00000001f, 1.99999999f, 3.00000001f, 3.99999999f, 5.00000001f, 5.99999999f, 7.00000001f, 7.99999999f, 9.00000001f, 0.00000001f, 1.00000001f, 0.99999999f, 3.99999999f, 4.00000001f, 2.99999999f, 1.00000001f)
    val m2 = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 0.0f, 1.0f, 1.0f, 4.0f, 4.0f, 3.0f, 1.0f)
    assert(m1 ~= m2)
  }

  test("Get element at index") {
    val m = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    assert(m(0, 0) == 1.0f)
    assert(m(0, 1) == 2.0f)
    assert(m(0, 2) == 3.0f)
    assert(m(0, 3) == 4.0f)
    assert(m(1, 0) == 5.0f)
    assert(m(1, 1) == 6.0f)
    assert(m(1, 2) == 7.0f)
    assert(m(1, 3) == 8.0f)
    assert(m(2, 0) == 9.0f)
    assert(m(2, 1) == 10.0f)
    assert(m(2, 2) == 11.0f)
    assert(m(2, 3) == 12.0f)
    assert(m(3, 0) == 13.0f)
    assert(m(3, 1) == 14.0f)
    assert(m(3, 2) == 15.0f)
    assert(m(3, 3) == 16.0f)
    assertThrows[MatchError] {m(4, 0)}
    assertThrows[MatchError] {m(0, 4)}
    assertThrows[MatchError] {m(4, 4)}
  }

  test("Construct matrix from rows") {
    val m = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    val r0 = Vec4f(1.0f, 2.0f, 3.0f, 4.0f)
    val r1 = Vec4f(5.0f, 6.0f, 7.0f, 8.0f)
    val r2 = Vec4f(9.0f, 10.0f, 11.0f, 12.0f)
    val r3 = Vec4f(13.0f, 14.0f, 15.0f, 16.0f)
    assert(Mat4f.fromRows(r0, r1, r2, r3) == m)
  }

  test("Construct matrix from columns") {
    val m = Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f)
    val c0 = Vec4f(1.0f, 5.0f, 9.0f, 13.0f)
    val c1 = Vec4f(2.0f, 6.0f, 10.0f, 14.0f)
    val c2 = Vec4f(3.0f, 7.0f, 11.0f, 15.0f)
    val c3 = Vec4f(4.0f, 8.0f, 12.0f, 16.0f)
    assert(Mat4f.fromColumns(c0, c1, c2, c3) == m)
  }

  test("Translation matrix from values") {
    val v1 = Vec3f(1.0f, 2.0f, 3.0f)
    val v2 = Vec3f(4.0f, 6.0f, 5.0f)
    val m = Mat4f.translation(3.0f, 4.0f, 2.0f)
    assert((m * (v1, 1.0f)).xyz === v2)
  }

  test("Translation matrix from 3D vector") {
    val v = Vec3f(1.0f, 2.0f, 3.0f)
    val t = Vec3f(3.0f, 4.0f, 2.0f)
    val m = Mat4f.translation(t)
    assert((m * (v, 1.0f)).xyz === v + t)
  }

  test("Translation matrix from 2D vector") {
    val v = Vec2f(1.0f, 2.0f)
    val t = Vec2f(3.0f, 4.0f)
    val m = Mat4f.translation(t)
    assert((m * (v, 0.0f, 1.0f)).xy === v + t)
  }

  test("Rotation matrix around the x axis") {
    val v1 = Vec3f(1.0f, 2.0f, 1.0f)
    val v2 = Vec3f(1.0f, 0.70710678f, 2.12132034f)
    val m = Mat4f.rotationX(math.Pi / 4.0)
    assert((m * (v1, 0.0f)).xyz === v2)
  }

  test("Rotation matrix around the y axis") {
    val v1 = Vec3f(1.0f, 2.0f, 1.0f)
    val v2 = Vec3f(1.41421356f, 2.0f, 0.0f)
    val m = Mat4f.rotationY(math.Pi / 4.0)
    assert((m * (v1, 0.0f)).xyz === v2)
  }

  test("Rotation matrix around the z axis") {
    val v1 = Vec3f(1.0f, 2.0f, 1.0f)
    val v2 = Vec3f(-0.70710678f, 2.12132034f, 1.0f)
    val m = Mat4f.rotationZ(math.Pi / 4.0)
    assert((m * (v1, 0.0f)).xyz === v2)
  }

  test("Rotation matrix around the three axes") {
    val v1 = Vec3f(1.0f, 2.0f, 1.0f)
    val v2 = Vec3f(0.61237244f, 0.42161062f, 2.33393327f)
    val m = Mat4f.rotation(math.Pi / 3.0, math.Pi / 4.0, math.Pi / 6.0)
    assert((m * (v1, 0.0f)).xyz === v2)
  }

  test("Rotation matrix from rotation vector") {
    val v1 = Vec3f(1.0f, 2.0f, 1.0f)
    val r = Vec3d(math.Pi / 3.0, math.Pi / 4.0, math.Pi / 6.0)
    val v2 = Vec3f(0.61237244f, 0.42161062f, 2.33393327f)
    val m = Mat4f.rotation(r)
    assert((m * (v1, 0.0f)).xyz === v2)
  }

  test("Rotation around an arbitrary axis") {
    val axis = Vec3f.One.normalized
    val point = Vec3f(1.0f, 2.0f, 1.0f)
    val res = Vec3f(0.68938278f, 1.80473785f, 1.50587936f)
    val matrix = Mat4f.rotation(axis, math.Pi / 4.0)
    assert((matrix * (point, 0.0f)).xyz === res)
  }

  test("Rotation matrix from quaternion") {
    val quaternion = Quatf(0.7233174f, 0.3919038f, 0.2005621f, 0.5319757f)
    val matrix = Mat4f.rotation(quaternion)
    val point = Vec3f(1.0f, 2.0f, 1.0f)
    assert((matrix * (point, 0.0f)).xyz === quaternion.rotate(point))
  }

  test("Scaling matrix from values") {
    val v1 = Vec3f(1.5f, 1.5f, 1.5f)
    val v2 = Vec3f(3.0f, 4.5f, 6.0f)
    val m = Mat4f.scaling(2.0f, 3.0f, 4.0f)
    assert((m * (v1, 0.0f)).xyz === v2)
  }

  test("Scaling matrix from 3D vector") {
    val v = Vec3f(1.5f, 1.5f, 1.5f)
    val s = Vec3f(2.0f, 3.0f, 4.0f)
    val m = Mat4f.scaling(s)
    assert((m * (v, 0.0f)).xyz === v * s)
  }

  test("Scaling matrix from 2D vector") {
    val v = Vec2f(1.5f, 1.5f)
    val s = Vec2f(2.0f, 3.0f)
    val m = Mat4f.scaling(s)
    assert((m * (v, 0.0f, 0.0f)).xy === v * s)
  }
}
