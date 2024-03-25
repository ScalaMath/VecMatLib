package io.github.scalamath.vecmatlib

import org.scalatest.funsuite.AnyFunSuite

class Mat2iSuite extends AnyFunSuite {

  test("Sum of two matrices") {
    val m1 = Mat2i(1, 2, 3, 4)
    val m2 = Mat2i(3, 4, 1, 2)
    val res = Mat2i(4, 6, 4, 6)
    assert(m1 + m2 == res)
  }

  test("Unary plus") {
    val m = Mat2i(1, 2, 3, 4)
    assert(+m == m)
  }

  test("Subtraction of two matrices") {
    val m1 = Mat2i(1, 2, 3, 4)
    val m2 = Mat2i(3, 4, 1, 2)
    val res = Mat2i(2, 2, -2, -2)
    assert(m2 - m1 == res)
  }

  test("Unary minus") {
    val m = Mat2i(1, 2, -2, -1)
    val r = Mat2i(-1, -2, 2, 1)
    assert(-m == r)
  }

  test("Matrix multiplied by a scalar") {
    val m = Mat2i(1, 2, 3, 4)
    val r = Mat2i(2, 4, 6, 8)
    assert(m * 2 == r)
  }

  test("Matrix divided by a scalar") {
    val m = Mat2i(1, 2, 3, 4)
    val r = Mat2i(0, 1, 1, 2)
    assert(m / 2 == r)
  }

  test("Get the rows of the matrix") {
    val m = Mat2i(1, 2, 3, 4)
    val r0 = Vec2i(1, 2)
    val r1 = Vec2i(3, 4)
    assert(m.row0 == r0)
    assert(m.row1 == r1)
  }

  test("Get row at index") {
    val m = Mat2i(1, 2, 3, 4)
    val r0 = Vec2i(1, 2)
    val r1 = Vec2i(3, 4)
    assert(m.row(0) == r0)
    assert(m.row(1) == r1)
    assertThrows[MatchError] {m.row(2)}
  }

  test("Get the columns of the matrix") {
    val m = Mat2i(1, 2, 3, 4)
    val c0 = Vec2i(1, 3)
    val c1 = Vec2i(2, 4)
    assert(m.col0 == c0)
    assert(m.col1 == c1)
  }

  test("Get column at index") {
    val m = Mat2i(1, 2, 3, 4)
    val c0 = Vec2i(1, 3)
    val c1 = Vec2i(2, 4)
    assert(m.col(0) == c0)
    assert(m.col(1) == c1)
    assertThrows[MatchError] {m.col(2)}
  }

  test("Matrix vector product") {
    val mat = Mat2i(1, 2, 3, 4)
    val vec = Vec2i(2, 3)
    val res = Vec2i(8, 18)
    assert(mat * vec == res)
  }

  test("Matrix vector product with values") {
    val mat = Mat2i(1, 2, 3, 4)
    val res = Vec2i(8, 18)
    assert(mat * (2, 3) == res)
  }

  test("Matrix product with 2x2 matrix") {
    val m1 = Mat2i(1, 2, 3, 4)
    val m2 = Mat2i(3, 4, 1, 2)
    val res = Mat2i(5, 8, 13, 20)
    assert(m1 * m2 == res)
  }

  test("Matrix product with 2x3 matrix") {
    val m1 = Mat2i(1, 2, 3, 4)
    val m2 = Mat2x3i(3, 4, 1, 2, 6, 5)
    val res = Mat2x3i(7, 16, 11, 17, 36, 23)
    assert(m1 * m2 == res)
  }

  test("Transposed matrix") {
    val m = Mat2i(1, 2, 3, 4)
    val t = Mat2i(1, 3, 2, 4)
    assert(m.transposed == t)
  }

  test("Symmetric matrix") {
    val m1 = Mat2i(1, 2, 2, 1)
    val m2 = Mat2i(1, 2, 3, 4)
    assert(m1.isSymmetric)
    assert(!m2.isSymmetric)
  }

  test("Skew-symmetric matrix") {
    val m1 = Mat2i(1, 2, 2, 1)
    val m2 = Mat2i(0, 1, -1, 0)
    assert(!m1.isSkewSymmetric)
    assert(m2.isSkewSymmetric)
  }

  test("Matrix determinant") {
    val m = Mat2i(1, 2, 3, 4)
    assert(m.determinant == -2)
  }

  test("Adjugate matrix") {
    val mat = Mat2i(1, 2, 3, 4)
    val adj = Mat2i(4, -2, -3, 1)
    assert(mat.adjugate == adj)
  }

  test("Power of a matrix with a positive exponent") {
    val m = Mat2i(1, 2, 3, 4)
    assert(m.power(3) == m * m * m)
  }

  test("Matrix to the power of zero") {
    val m = Mat2i(1, 2, 3, 4)
    assert(m.power(0) == Mat2i.Identity)
  }

  test("Matrix to the power of one") {
    val m = Mat2i(1, 2, 3, 4)
    assert(m.power(1) == m)
  }

  test("Power of a matrix with a negative exponent") {
    val m = Mat2i(1, 2, 3, 4)
    assertThrows[IllegalArgumentException] {m.power(-2)}
  }

  test("Absolute values of the elements of a matrix") {
    val mat = Mat2i(1, 2, 0, -2)
    val abs = Mat2i(1, 2, 0, 2)
    assert(mat.abs == abs)
  }

  test("Sign values of the elements of a matrix") {
    val mat = Mat2i(1, 2, 0, -2)
    val sign = Mat2i(1, 1, 0, -1)
    assert(mat.sign == sign)
  }

  test("Get element at index") {
    val m = Mat2i(1, 2, 3, 4)
    assert(m(0, 0) == 1)
    assert(m(0, 1) == 2)
    assert(m(1, 0) == 3)
    assert(m(1, 1) == 4)
    assertThrows[MatchError] {m(2, 0)}
    assertThrows[MatchError] {m(0, 2)}
    assertThrows[MatchError] {m(2, 2)}
  }

  test("Construct matrix from rows") {
    val m = Mat2i(1, 2, 3, 4)
    val r0 = Vec2i(1, 2)
    val r1 = Vec2i(3, 4)
    assert(Mat2i.fromRows(r0, r1) == m)
  }

  test("Construct matrix from columns") {
    val m = Mat2i(1, 2, 3, 4)
    val c0 = Vec2i(1, 3)
    val c1 = Vec2i(2, 4)
    assert(Mat2i.fromColumns(c0, c1) == m)
  }
}
