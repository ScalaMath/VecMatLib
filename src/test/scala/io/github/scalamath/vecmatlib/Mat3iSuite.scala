package io.github.scalamath.vecmatlib

import org.scalatest.funsuite.AnyFunSuite

class Mat3iSuite extends AnyFunSuite {

  test("Sum of two matrices") {
    val m1 = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val m2 = Mat3i(3, 4, 1, 2, 7, 5, 9, 6, 8)
    val res = Mat3i(4, 6, 4, 6, 12, 11, 16, 14, 17)
    assert(m1 + m2 == res)
  }

  test("Unary plus") {
    val m = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    assert(+m == m)
  }

  test("Subtraction of two matrices") {
    val m1 = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val m2 = Mat3i(3, 4, 1, 2, 7, 5, 9, 6, 8)
    val res = Mat3i(2, 2, -2, -2, 2, -1, 2, -2, -1)
    assert(m2 - m1 == res)
  }

  test("Unary minus") {
    val m = Mat3i(1, 2, -2, -1, 3, -2, 0, -9, 4)
    val r = Mat3i(-1, -2, 2, 1, -3, 2, 0, 9, -4)
    assert(-m == r)
  }

  test("Matrix multiplied by a scalar") {
    val m = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val r = Mat3i(2, 4, 6, 8, 10, 12, 14, 16, 18)
    assert(m * 2 == r)
  }

  test("Matrix divided by a scalar") {
    val m = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val r = Mat3i(0, 1, 1, 2, 2, 3, 3, 4, 4)
    assert(m / 2 == r)
  }

  test("Get the rows of the matrix") {
    val m = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val r0 = Vec3i(1, 2, 3)
    val r1 = Vec3i(4, 5, 6)
    val r2 = Vec3i(7, 8, 9)
    assert(m.row0 == r0)
    assert(m.row1 == r1)
    assert(m.row2 == r2)
  }

  test("Get row at index") {
    val m = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val r0 = Vec3i(1, 2, 3)
    val r1 = Vec3i(4, 5, 6)
    val r2 = Vec3i(7, 8, 9)
    assert(m.row(0) == r0)
    assert(m.row(1) == r1)
    assert(m.row(2) == r2)
    assertThrows[MatchError] {m.row(3)}
  }

  test("Get the columns of the matrix") {
    val m = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val c0 = Vec3i(1, 4, 7)
    val c1 = Vec3i(2, 5, 8)
    val c2 = Vec3i(3, 6, 9)
    assert(m.col0 == c0)
    assert(m.col1 == c1)
    assert(m.col2 == c2)
  }

  test("Get column at index") {
    val m = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val c0 = Vec3i(1, 4, 7)
    val c1 = Vec3i(2, 5, 8)
    val c2 = Vec3i(3, 6, 9)
    assert(m.col(0) == c0)
    assert(m.col(1) == c1)
    assert(m.col(2) == c2)
    assertThrows[MatchError] {m.col(3)}
  }

  test("Matrix vector product") {
    val mat = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val vec = Vec3i(2, 3, 4)
    val res = Vec3i(20, 47, 74)
    assert(mat * vec == res)
  }

  test("Matrix vector product with values") {
    val mat = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val res = Vec3i(20, 47, 74)
    assert(mat * (2, 3, 4) == res)
  }

  test("Matrix vector product with a 2D vector and a third value") {
    val mat = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val vec = Vec2i(2, 3)
    val res = Vec3i(20, 47, 74)
    assert(mat * (vec, 4) == res)
  }

  test("Matrix product with 3x3 matrix") {
    val m1 = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val m2 = Mat3i(3, 4, 1, 2, 7, 5, 9, 6, 8)
    val res = Mat3i(34, 36, 35, 76, 87, 77, 118, 138, 119)
    assert(m1 * m2 == res)
  }

  test("Matrix product with 3x4 matrix") {
    val m1 = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val m2 = Mat3x4i(3, 4, 1, 2, 7, 5, 9, 6, 8, 10, 11, 12)
    val res = Mat3x4i(41, 44, 52, 50, 95, 101, 115, 110, 149, 158, 178, 170)
    assert(m1 * m2 == res)
  }

  test("Transposed matrix") {
    val m = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val t = Mat3i(1, 4, 7, 2, 5, 8, 3, 6, 9)
    assert(m.transposed == t)
  }

  test("Symmetric matrix") {
    val m1 = Mat3i(1, 2, 3, 2, 4, 5, 3, 5, 6)
    val m2 = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    assert(m1.isSymmetric)
    assert(!m2.isSymmetric)
  }

  test("Skew-symmetric matrix") {
    val m1 = Mat3i(1, 2, 3, 2, 4, 5, 3, 5, 6)
    val m2 = Mat3i(0, 1, 2, -1, 0, 3, -2, -3, 0)
    assert(!m1.isSkewSymmetric)
    assert(m2.isSkewSymmetric)
  }

  test("Submatrix") {
    val m = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    assert(m.submatrix(0, 0) == Mat2i(5, 6, 8, 9))
    assert(m.submatrix(0, 1) == Mat2i(4, 6, 7, 9))
    assert(m.submatrix(0, 2) == Mat2i(4, 5, 7, 8))
    assert(m.submatrix(1, 0) == Mat2i(2, 3, 8, 9))
    assert(m.submatrix(1, 1) == Mat2i(1, 3, 7, 9))
    assert(m.submatrix(1, 2) == Mat2i(1, 2, 7, 8))
    assert(m.submatrix(2, 0) == Mat2i(2, 3, 5, 6))
    assert(m.submatrix(2, 1) == Mat2i(1, 3, 4, 6))
    assert(m.submatrix(2, 2) == Mat2i(1, 2, 4, 5))
  }

  test("Matrix determinant") {
    val m = Mat3i(1, 2, 3, 4, 5, 6, 0, 0, 1)
    assert(m.determinant == -3)
  }

  test("Adjugate matrix") {
    val mat = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val adj = Mat3i(-3, 6, -3, 6, -12, 6, -3, 6, -3)
    assert(mat.adjugate == adj)
  }

  test("Power of a matrix with a positive exponent") {
    val m = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    assert(m.power(3) == m * m * m)
  }

  test("Matrix to the power of zero") {
    val m = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    assert(m.power(0) == Mat3i.Identity)
  }

  test("Matrix to the power of one") {
    val m = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    assert(m.power(1) == m)
  }

  test("Power of a matrix with a negative exponent") {
    val m = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    assertThrows[IllegalArgumentException] {m.power(-2)}
  }

  test("Absolute values of the elements of a matrix") {
    val mat = Mat3i(1, 2, 0, -2, 3, -1, -3, 0, 1)
    val abs = Mat3i(1, 2, 0, 2, 3, 1, 3, 0, 1)
    assert(mat.abs == abs)
  }

  test("Sign values of the elements of a matrix") {
    val mat = Mat3i(1, 2, 0, -2, 3, -1, -3, 0, 1)
    val sign = Mat3i(1, 1, 0, -1, 1, -1, -1, 0, 1)
    assert(mat.sign == sign)
  }

  test("Get element at index") {
    val m = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    assert(m(0, 0) == 1)
    assert(m(0, 1) == 2)
    assert(m(0, 2) == 3)
    assert(m(1, 0) == 4)
    assert(m(1, 1) == 5)
    assert(m(1, 2) == 6)
    assert(m(2, 0) == 7)
    assert(m(2, 1) == 8)
    assert(m(2, 2) == 9)
    assertThrows[MatchError] {m(3, 0)}
    assertThrows[MatchError] {m(0, 3)}
    assertThrows[MatchError] {m(3, 3)}
  }

  test("Construct matrix from rows") {
    val m = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val r0 = Vec3i(1, 2, 3)
    val r1 = Vec3i(4, 5, 6)
    val r2 = Vec3i(7, 8, 9)
    assert(Mat3i.fromRows(r0, r1, r2) == m)
  }

  test("Construct matrix from columns") {
    val m = Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val c0 = Vec3i(1, 4, 7)
    val c1 = Vec3i(2, 5, 8)
    val c2 = Vec3i(3, 6, 9)
    assert(Mat3i.fromColumns(c0, c1, c2) == m)
  }
}
