package io.github.scalamath.vecmatlib

import org.scalatest.funsuite.AnyFunSuite

class Mat3x4iSuite extends AnyFunSuite {

  test("Construct a matrix from a submatrix and three values") {
    val m = Mat3i(1, 2, 3, 5, 6, 7, 9, 10, 11)
    val res = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    assert(Mat3x4i(m, 4, 8, 12) == res)
  }

  test("Construct a matrix from a submatrix and a column") {
    val m = Mat3i(1, 2, 3, 5, 6, 7, 9, 10, 11)
    val v = Vec3i(4, 8, 12)
    val res = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    assert(Mat3x4i(m, v) == res)
  }

  test("Construct a matrix from three values and a submatrix") {
    val m = Mat3i(2, 3, 4, 6, 7, 8, 10, 11, 12)
    val res = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    assert(Mat3x4i(1, 5, 9, m) == res)
  }

  test("Construct a matrix from a column and a submatrix") {
    val m = Mat3i(2, 3, 4, 6, 7, 8, 10, 11, 12)
    val v = Vec3i(1, 5, 9)
    val res = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    assert(Mat3x4i(v, m) == res)
  }

  test("Sum of two matrices") {
    val m1 = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val m2 = Mat3x4i(3, 4, 1, 2, 7, 5, 9, 6, 8, 11, 12, 10)
    val res = Mat3x4i(4, 6, 4, 6, 12, 11, 16, 14, 17, 21, 23, 22)
    assert(m1 + m2 == res)
  }

  test("Unary plus") {
    val m = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    assert(+m == m)
  }

  test("Subtraction of two matrices") {
    val m1 = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val m2 = Mat3x4i(3, 4, 1, 2, 7, 5, 9, 6, 8, 11, 12, 10)
    val res = Mat3x4i(2, 2, -2, -2, 2, -1, 2, -2, -1, 1, 1, -2)
    assert(m2 - m1 == res)
  }

  test("Unary minus") {
    val m = Mat3x4i(1, 2, -2, -1, 3, -2, 0, -9, 4, 2, 0, -5)
    val r = Mat3x4i(-1, -2, 2, 1, -3, 2, 0, 9, -4, -2, 0, 5)
    assert(-m == r)
  }

  test("Matrix multiplied by a scalar") {
    val m = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val r = Mat3x4i(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24)
    assert(m * 2 == r)
  }

  test("Matrix divided by a scalar") {
    val m = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val r = Mat3x4i(0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6)
    assert(m / 2 == r)
  }

  test("Get the rows of the matrix") {
    val m = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val r0 = Vec4i(1, 2, 3, 4)
    val r1 = Vec4i(5, 6, 7, 8)
    val r2 = Vec4i(9, 10, 11, 12)
    assert(m.row0 == r0)
    assert(m.row1 == r1)
    assert(m.row2 == r2)
  }

  test("Get row at index") {
    val m = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val r0 = Vec4i(1, 2, 3, 4)
    val r1 = Vec4i(5, 6, 7, 8)
    val r2 = Vec4i(9, 10, 11, 12)
    assert(m.row(0) == r0)
    assert(m.row(1) == r1)
    assert(m.row(2) == r2)
    assertThrows[MatchError] {m.row(3)}
  }

  test("Get the columns of the matrix") {
    val m = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val c0 = Vec3i(1, 5, 9)
    val c1 = Vec3i(2, 6, 10)
    val c2 = Vec3i(3, 7, 11)
    val c3 = Vec3i(4, 8, 12)
    assert(m.col0 == c0)
    assert(m.col1 == c1)
    assert(m.col2 == c2)
    assert(m.col3 == c3)
  }

  test("Get column at index") {
    val m = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val c0 = Vec3i(1, 5, 9)
    val c1 = Vec3i(2, 6, 10)
    val c2 = Vec3i(3, 7, 11)
    val c3 = Vec3i(4, 8, 12)
    assert(m.col(0) == c0)
    assert(m.col(1) == c1)
    assert(m.col(2) == c2)
    assert(m.col(3) == c3)
    assertThrows[MatchError] {m.col(4)}
  }

  test("Matrix vector product") {
    val mat = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val vec = Vec4i(2, 3, 4, 5)
    val res = Vec3i(40, 96, 152)
    assert(mat * vec == res)
  }

  test("Matrix vector product with values") {
    val mat = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val res = Vec3i(40, 96, 152)
    assert(mat * (2, 3, 4, 5) == res)
  }

  test("Matrix vector product with a 3D vector and a fourth value") {
    val mat = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val vec = Vec3i(2, 3, 4)
    val res = Vec3i(40, 96, 152)
    assert(mat * (vec, 5) == res)
  }

  test("Matrix vector product with a 2D vector and two values") {
    val mat = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val vec = Vec2i(2, 3)
    val res = Vec3i(40, 96, 152)
    assert(mat * (vec, 4, 5) == res)
  }

  test("Matrix product with 4x4 matrix") {
    val m1 = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val m2 = Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val res = Mat3x4i(90, 100, 110, 120, 202, 228, 254, 280, 314, 356, 398, 440)
    assert(m1 * m2 == res)
  }

  test("Matrix product with a 3x4 matrix and four values") {
    val m1 = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val m2 = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val res = Mat3x4i(90, 100, 110, 120, 202, 228, 254, 280, 314, 356, 398, 440)
    assert(m1 * (m2, 13, 14, 15, 16) == res)
  }

  test("Matrix product with a 3x4 matrix and a fourth row") {
    val m1 = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val m2 = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val v = Vec4i(13, 14, 15, 16)
    val res = Mat3x4i(90, 100, 110, 120, 202, 228, 254, 280, 314, 356, 398, 440)
    assert(m1 * (m2, v) == res)
  }

  test("3x3 submatrix") {
    val m = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    assert(m.submatrix(0) == Mat3i(2, 3, 4, 6, 7, 8, 10, 11, 12))
    assert(m.submatrix(1) == Mat3i(1, 3, 4, 5, 7, 8, 9, 11, 12))
    assert(m.submatrix(2) == Mat3i(1, 2, 4, 5, 6, 8, 9, 10, 12))
    assert(m.submatrix(3) == Mat3i(1, 2, 3, 5, 6, 7, 9, 10, 11))
    assertThrows[MatchError] {m.submatrix(4)}
  }

  test("Absolute values of the elements of a matrix") {
    val mat = Mat3x4i(1, 2, 0, -2, 3, -1, -3, 0, 1, -7, 4, 0)
    val abs = Mat3x4i(1, 2, 0, 2, 3, 1, 3, 0, 1, 7, 4, 0)
    assert(mat.abs == abs)
  }

  test("Sign values of the elements of a matrix") {
    val mat = Mat3x4i(1, 2, 0, -2, 3, -1, -3, 0, 1, -7, 4, 0)
    val sign = Mat3x4i(1, 1, 0, -1, 1, -1, -1, 0, 1, -1, 1, 0)
    assert(mat.sign == sign)
  }

  test("Get element at index") {
    val m = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
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
    assertThrows[MatchError] {m(3, 0)}
    assertThrows[MatchError] {m(0, 4)}
    assertThrows[MatchError] {m(3, 4)}
  }

  test("Construct matrix from rows") {
    val m = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val r0 = Vec4i(1, 2, 3, 4)
    val r1 = Vec4i(5, 6, 7, 8)
    val r2 = Vec4i(9, 10, 11, 12)
    assert(Mat3x4i.fromRows(r0, r1, r2) == m)
  }

  test("Construct matrix from columns") {
    val m = Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val c0 = Vec3i(1, 5, 9)
    val c1 = Vec3i(2, 6, 10)
    val c2 = Vec3i(3, 7, 11)
    val c3 = Vec3i(4, 8, 12)
    assert(Mat3x4i.fromColumns(c0, c1, c2, c3) == m)
  }
}
