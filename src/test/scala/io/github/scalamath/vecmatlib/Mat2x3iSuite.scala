package io.github.scalamath.vecmatlib

import org.scalatest.funsuite.AnyFunSuite

class Mat2x3iSuite extends AnyFunSuite {

  ignore("Construct a matrix from a submatrix and two values") {
    // TODO
  }

  ignore("Construct a matrix from a submatrix and a column") {
    // TODO
  }

  ignore("Construct a matrix from two values and a submatrix") {
    // TODO
  }

  ignore("Construct a matrix from a column and a submatrix") {
    // TODO
  }

  test("Sum of two matrices") {
    val m1 = Mat2x3i(1, 2, 3, 4, 5, 6)
    val m2 = Mat2x3i(3, 4, 1, 2, 6, 5)
    val res = Mat2x3i(4, 6, 4, 6, 11, 11)
    assert(m1 + m2 == res)
  }

  test("Unary plus") {
    val m = Mat2x3i(1, 2, 3, 4, 5, 6)
    assert(+m == m)
  }

  test("Subtraction of two matrices") {
    val m1 = Mat2x3i(1, 2, 3, 4, 5, 6)
    val m2 = Mat2x3i(3, 4, 1, 2, 6, 5)
    val res = Mat2x3i(2, 2, -2, -2, 1, -1)
    assert(m2 - m1 == res)
  }

  test("Unary minus") {
    val m = Mat2x3i(1, 2, -2, -1, 3, -2)
    val r = Mat2x3i(-1, -2, 2, 1, -3, 2)
    assert(-m == r)
  }

  test("Matrix multiplied by a scalar") {
    val m = Mat2x3i(1, 2, 3, 4, 5, 6)
    val r = Mat2x3i(2, 4, 6, 8, 10, 12)
    assert(m * 2 == r)
  }

  test("Matrix divided by a scalar") {
    val m = Mat2x3i(1, 2, 3, 4, 5, 6)
    val r = Mat2x3i(0, 1, 1, 2, 2, 3)
    assert(m / 2 == r)
  }

  test("Get the rows of the matrix") {
    val m = Mat2x3i(1, 2, 3, 4, 5, 6)
    val r0 = Vec3i(1, 2, 3)
    val r1 = Vec3i(4, 5, 6)
    assert(m.row0 == r0)
    assert(m.row1 == r1)
  }

  test("Get row at index") {
    val m = Mat2x3i(1, 2, 3, 4, 5, 6)
    val r0 = Vec3i(1, 2, 3)
    val r1 = Vec3i(4, 5, 6)
    assert(m.row(0) == r0)
    assert(m.row(1) == r1)
    assertThrows[MatchError] {m.row(2)}
  }

  test("Get the columns of the matrix") {
    val m = Mat2x3i(1, 2, 3, 4, 5, 6)
    val c0 = Vec2i(1, 4)
    val c1 = Vec2i(2, 5)
    val c2 = Vec2i(3, 6)
    assert(m.col0 == c0)
    assert(m.col1 == c1)
    assert(m.col2 == c2)
  }

  test("Get column at index") {
    val m = Mat2x3i(1, 2, 3, 4, 5, 6)
    val c0 = Vec2i(1, 4)
    val c1 = Vec2i(2, 5)
    val c2 = Vec2i(3, 6)
    assert(m.col(0) == c0)
    assert(m.col(1) == c1)
    assert(m.col(2) == c2)
    assertThrows[MatchError] {m.col(3)}
  }

  test("Matrix vector product") {
    val mat = Mat2x3i(1, 2, 3, 4, 5, 6)
    val vec = Vec3i(2, 3, 4)
    val res = Vec2i(20, 47)
    assert(mat * vec == res)
  }

  test("Matrix vector product with values") {
    val mat = Mat2x3i(1, 2, 3, 4, 5, 6)
    val res = Vec2i(20, 47)
    assert(mat * (2, 3, 4) == res)
  }

  test("Matrix vector product with a 2D vector and a third value") {
    val mat = Mat2x3i(1, 2, 3, 4, 5, 6)
    val vec = Vec2i(2, 3)
    val res = Vec2i(20, 47)
    assert(mat * (vec, 4) == res)
  }

  test("Matrix product with 3x3 matrix") {
    val m1 = Mat2x3i(1, 2, 3, 4, 5, 6)
    val m2 = Mat3i(3, 4, 1, 2, 6, 5, -2, 8, -1)
    val res = Mat2x3i(1, 40, 8, 10, 94, 23)
    assert(m1 * m2 == res)
  }

  ignore("Matrix product with a 2x3 matrix and three values") {
    // TODO
  }

  ignore("Matrix product with a 2x3 matrix and a third row") {
    // TODO
  }

  ignore("2x2 submatrix") {
    // TODO
  }

  test("Absolute values of the elements of a matrix") {
    val mat = Mat2x3i(1, 2, 0, -2, 0, -1)
    val abs = Mat2x3i(1, 2, 0, 2, 0, 1)
    assert(mat.abs == abs)
  }

  test("Sign values of the elements of a matrix") {
    val mat = Mat2x3i(1, 2, 0, -2, 0, -1)
    val sign = Mat2x3i(1, 1, 0, -1, 0, -1)
    assert(mat.sign == sign)
  }

  test("Get element at index") {
    val m = Mat2x3i(1, 2, 3, 4, 5, 6)
    assert(m(0, 0) == 1)
    assert(m(0, 1) == 2)
    assert(m(0, 2) == 3)
    assert(m(1, 0) == 4)
    assert(m(1, 1) == 5)
    assert(m(1, 2) == 6)
    assertThrows[MatchError] {m(2, 0)}
    assertThrows[MatchError] {m(0, 3)}
    assertThrows[MatchError] {m(2, 3)}
  }

  test("Construct matrix from rows") {
    val m = Mat2x3i(1, 2, 3, 4, 5, 6)
    val r0 = Vec3i(1, 2, 3)
    val r1 = Vec3i(4, 5, 6)
    assert(Mat2x3i.fromRows(r0, r1) == m)
  }

  test("Construct matrix from columns") {
    val m = Mat2x3i(1, 2, 3, 4, 5, 6)
    val c0 = Vec2i(1, 4)
    val c1 = Vec2i(2, 5)
    val c2 = Vec2i(3, 6)
    assert(Mat2x3i.fromColumns(c0, c1, c2) == m)
  }
}
