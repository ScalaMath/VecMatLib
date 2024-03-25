package io.github.scalamath.vecmatlib

import org.scalatest.funsuite.AnyFunSuite

class Mat4iSuite extends AnyFunSuite {

  test("Sum of two matrices") {
    val m1 = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val m2 = Mat4i(3, 4, 1, 2, 7, 5, 9, 6, 8, 11, 14, 16, 15, 13, 12, 10)
    val res = Mat4i(4, 6, 4, 6, 12, 11, 16, 14, 17, 21, 25, 28, 28, 27, 27, 26)
    assert(m1 + m2 == res)
  }

  test("Unary plus") {
    val m = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    assert(+m == m)
  }

  test("Subtraction of two matrices") {
    val m1 = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val m2 = Mat4i(3, 4, 1, 2, 7, 5, 9, 6, 8, 11, 14, 16, 15, 13, 12, 10)
    val res = Mat4i(2, 2, -2, -2, 2, -1, 2, -2, -1, 1, 3, 4, 2, -1, -3, -6)
    assert(m2 - m1 == res)
  }

  test("Unary minus") {
    val m = Mat4i(1, 2, -2, -1, 3, -2, 0, -9, 4, 2, -5, -4, 7, 2, 8, 0)
    val r = Mat4i(-1, -2, 2, 1, -3, 2, 0, 9, -4, -2, 5, 4, -7, -2, -8, 0)
    assert(-m == r)
  }

  test("Matrix multiplied by a scalar") {
    val m = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val r = Mat4i(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32)
    assert(m * 2 == r)
  }

  test("Matrix divided by a scalar") {
    val m = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val r = Mat4i(0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8)
    assert(m / 2 == r)
  }

  test("Get the rows of the matrix") {
    val m = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val r0 = Vec4i(1, 2, 3, 4)
    val r1 = Vec4i(5, 6, 7, 8)
    val r2 = Vec4i(9, 10, 11, 12)
    val r3 = Vec4i(13, 14, 15, 16)
    assert(m.row0 == r0)
    assert(m.row1 == r1)
    assert(m.row2 == r2)
    assert(m.row3 == r3)
  }

  test("Get row at index") {
    val m = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val r0 = Vec4i(1, 2, 3, 4)
    val r1 = Vec4i(5, 6, 7, 8)
    val r2 = Vec4i(9, 10, 11, 12)
    val r3 = Vec4i(13, 14, 15, 16)
    assert(m.row(0) == r0)
    assert(m.row(1) == r1)
    assert(m.row(2) == r2)
    assert(m.row(3) == r3)
    assertThrows[MatchError] {m.row(4)}
  }

  test("Get the columns of the matrix") {
    val m = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val c0 = Vec4i(1, 5, 9, 13)
    val c1 = Vec4i(2, 6, 10, 14)
    val c2 = Vec4i(3, 7, 11, 15)
    val c3 = Vec4i(4, 8, 12, 16)
    assert(m.col0 == c0)
    assert(m.col1 == c1)
    assert(m.col2 == c2)
    assert(m.col3 == c3)
  }

  test("Get column at index") {
    val m = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val c0 = Vec4i(1, 5, 9, 13)
    val c1 = Vec4i(2, 6, 10, 14)
    val c2 = Vec4i(3, 7, 11, 15)
    val c3 = Vec4i(4, 8, 12, 16)
    assert(m.col(0) == c0)
    assert(m.col(1) == c1)
    assert(m.col(2) == c2)
    assert(m.col(3) == c3)
    assertThrows[MatchError] {m.col(4)}
  }

  test("Matrix vector product") {
    val mat = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val vec = Vec4i(2, 3, 4, 5)
    val res = Vec4i(40, 96, 152, 208)
    assert(mat * vec == res)
  }

  test("Matrix vector product with values") {
    val mat = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val res = Vec4i(40, 96, 152, 208)
    assert(mat * (2, 3, 4, 5) == res)
  }

  test("Matrix vector product with a 3D vector and a fourth value") {
    val mat = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val vec = Vec3i(2, 3, 4)
    val res = Vec4i(40, 96, 152, 208)
    assert(mat * (vec, 5) == res)
  }

  test("Matrix vector product with a 2D vector and a two values") {
    val mat = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val vec = Vec2i(2, 3)
    val res = Vec4i(40, 96, 152, 208)
    assert(mat * (vec, 4, 5) == res)
  }

  test("Matrix product with 4x4 matrix") {
    val m1 = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val m2 = Mat4i(3, 4, 1, 2, 7, 5, 9, 6, 8, 11, 14, 16, 15, 13, 12, 10)
    val res = Mat4i(101, 99, 109, 102, 233, 231, 253, 238, 365, 363, 397, 374, 497, 495, 541, 510)
    assert(m1 * m2 == res)
  }

  test("Transposed matrix") {
    val m = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val t = Mat4i(1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15, 4, 8, 12, 16)
    assert(m.transposed == t)
  }

  test("Symmetric matrix") {
    val m1 = Mat4i(1, 2, 3, 4, 2, 5, 6, 7, 3, 6, 8, 9, 4, 7, 9, 10)
    val m2 = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    assert(m1.isSymmetric)
    assert(!m2.isSymmetric)
  }

  test("Skew-symmetric matrix") {
    val m1 = Mat4i(1, 2, 3, 4, 2, 5, 6, 7, 3, 6, 8, 9, 4, 7, 9, 10)
    val m2 = Mat4i(0, 1, 2, 3, -1, 0, 4, 5, -2, -4, 0, 6, -3, -5, -6, 0)
    assert(!m1.isSkewSymmetric)
    assert(m2.isSkewSymmetric)
  }

  test("Submatrix") {
    val m = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    assert(m.submatrix(0, 0) == Mat3i(6, 7, 8, 10, 11, 12, 14, 15, 16))
    assert(m.submatrix(0, 1) == Mat3i(5, 7, 8, 9, 11, 12, 13, 15, 16))
    assert(m.submatrix(0, 2) == Mat3i(5, 6, 8, 9, 10, 12, 13, 14, 16))
    assert(m.submatrix(0, 3) == Mat3i(5, 6, 7, 9, 10, 11, 13, 14, 15))
    assert(m.submatrix(1, 0) == Mat3i(2, 3, 4, 10, 11, 12, 14, 15, 16))
    assert(m.submatrix(1, 1) == Mat3i(1, 3, 4, 9, 11, 12, 13, 15, 16))
    assert(m.submatrix(1, 2) == Mat3i(1, 2, 4, 9, 10, 12, 13, 14, 16))
    assert(m.submatrix(1, 3) == Mat3i(1, 2, 3, 9, 10, 11, 13, 14, 15))
    assert(m.submatrix(2, 0) == Mat3i(2, 3, 4, 6, 7, 8, 14, 15, 16))
    assert(m.submatrix(2, 1) == Mat3i(1, 3, 4, 5, 7, 8, 13, 15, 16))
    assert(m.submatrix(2, 2) == Mat3i(1, 2, 4, 5, 6, 8, 13, 14, 16))
    assert(m.submatrix(2, 3) == Mat3i(1, 2, 3, 5, 6, 7, 13, 14, 15))
    assert(m.submatrix(3, 0) == Mat3i(2, 3, 4, 6, 7, 8, 10, 11, 12))
    assert(m.submatrix(3, 1) == Mat3i(1, 3, 4, 5, 7, 8, 9, 11, 12))
    assert(m.submatrix(3, 2) == Mat3i(1, 2, 4, 5, 6, 8, 9, 10, 12))
    assert(m.submatrix(3, 3) == Mat3i(1, 2, 3, 5, 6, 7, 9, 10, 11))
  }

  test("Matrix determinant") {
    val m = Mat4i(1, 3, 5, 9, 1, 3, 1, 7, 4, 3, 9, 7, 5, 2, 0, 9)
    assert(m.determinant == -376)
  }

  test("Adjugate matrix") {
    val mat = Mat4i(1, 3, 5, 9, 1, 3, 1, 7, 4, 3, 9, 7, 5, 2, 0, 9)
    val adj = Mat4i(104, -16, -56, -48, 235, -329, -94, 94, -39, 53, -26, 18, -110, 82, 52, -36)
    assert(mat.adjugate == adj)
  }

  test("Power of a matrix with a positive exponent") {
    val m = Mat4i(1, 3, 5, 9, 1, 3, 1, 7, 4, 3, 9, 7, 5, 2, 0, 9)
    assert(m.power(3) == m * m * m)
  }

  test("Matrix to the power of zero") {
    val m = Mat4i(1, 3, 5, 9, 1, 3, 1, 7, 4, 3, 9, 7, 5, 2, 0, 9)
    assert(m.power(0) == Mat4i.Identity)
  }

  test("Matrix to the power of one") {
    val m = Mat4i(1, 3, 5, 9, 1, 3, 1, 7, 4, 3, 9, 7, 5, 2, 0, 9)
    assert(m.power(1) == m)
  }

  test("Power of a matrix with a negative exponent") {
    val m = Mat4i(1, 3, 5, 9, 1, 3, 1, 7, 4, 3, 9, 7, 5, 2, 0, 9)
    assertThrows[IllegalArgumentException] {m.power(-2)}
  }

  test("Absolute values of the elements of a matrix") {
    val mat = Mat4i(1, 2, 0, -2, 3, -1, -3, 0, 1, -3, 2, 6, -1, -7, 4, 0)
    val abs = Mat4i(1, 2, 0, 2, 3, 1, 3, 0, 1, 3, 2, 6, 1, 7, 4, 0)
    assert(mat.abs == abs)
  }

  test("Sign values of the elements of a matrix") {
    val mat = Mat4i(1, 2, 0, -2, 3, -1, -3, 0, 1, -3, 2, 6, -1, -7, 4, 0)
    val sign = Mat4i(1, 1, 0, -1, 1, -1, -1, 0, 1, -1, 1, 1, -1, -1, 1, 0)
    assert(mat.sign == sign)
  }

  test("Get element at index") {
    val m = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    assert(m(0, 0) == 1)
    assert(m(0, 1) == 2)
    assert(m(0, 2) == 3)
    assert(m(0, 3) == 4)
    assert(m(1, 0) == 5)
    assert(m(1, 1) == 6)
    assert(m(1, 2) == 7)
    assert(m(1, 3) == 8)
    assert(m(2, 0) == 9)
    assert(m(2, 1) == 10)
    assert(m(2, 2) == 11)
    assert(m(2, 3) == 12)
    assert(m(3, 0) == 13)
    assert(m(3, 1) == 14)
    assert(m(3, 2) == 15)
    assert(m(3, 3) == 16)
    assertThrows[MatchError] {m(4, 0)}
    assertThrows[MatchError] {m(0, 4)}
    assertThrows[MatchError] {m(4, 4)}
  }

  test("Construct matrix from rows") {
    val m = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val r0 = Vec4i(1, 2, 3, 4)
    val r1 = Vec4i(5, 6, 7, 8)
    val r2 = Vec4i(9, 10, 11, 12)
    val r3 = Vec4i(13, 14, 15, 16)
    assert(Mat4i.fromRows(r0, r1, r2, r3) == m)
  }

  test("Construct matrix from columns") {
    val m = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val c0 = Vec4i(1, 5, 9, 13)
    val c1 = Vec4i(2, 6, 10, 14)
    val c2 = Vec4i(3, 7, 11, 15)
    val c3 = Vec4i(4, 8, 12, 16)
    assert(Mat4i.fromColumns(c0, c1, c2, c3) == m)
  }
}
