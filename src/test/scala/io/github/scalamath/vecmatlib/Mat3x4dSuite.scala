package io.github.scalamath.vecmatlib

import org.scalactic.Equality
import org.scalatest.funsuite.AnyFunSuite

class Mat3x4dSuite extends AnyFunSuite {

  implicit val equalityMat3x4d: Equality[Mat3x4d] = (a: Mat3x4d, b: Any) => b match {
    case b: Mat3x4d => a ~= b
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
    val m1 = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
    val m2 = Mat3x4d(3.0, 4.0, 1.0, 2.0, 7.0, 5.0, 9.0, 6.0, 8.0, 11.0, 12.0, 10.0)
    val res = Mat3x4d(4.0, 6.0, 4.0, 6.0, 12.0, 11.0, 16.0, 14.0, 17.0, 21.0, 23.0, 22.0)
    assert(m1 + m2 === res)
  }

  test("Unary plus") {
    val m = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
    assert(+m == m)
  }

  test("Subtraction of two matrices") {
    val m1 = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
    val m2 = Mat3x4d(3.0, 4.0, 1.0, 2.0, 7.0, 5.0, 9.0, 6.0, 8.0, 11.0, 12.0, 10.0)
    val res = Mat3x4d(2.0, 2.0, -2.0, -2.0, 2.0, -1.0, 2.0, -2.0, -1.0, 1.0, 1.0, -2.0)
    assert(m2 - m1 === res)
  }

  test("Unary minus") {
    val m = Mat3x4d(1.0, 2.0, -2.0, -1.0, 3.0, -2.0, 0.0, -9.0, 4.0, 2.0, 0.0, -5.0)
    val r = Mat3x4d(-1.0, -2.0, 2.0, 1.0, -3.0, 2.0, 0.0, 9.0, -4.0, -2.0, 0.0, 5.0)
    assert(-m == r)
  }

  test("Matrix multiplied by a scalar") {
    val m = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
    val r = Mat3x4d(1.5, 3.0, 4.5, 6.0, 7.5, 9.0, 10.5, 12.0, 13.5, 15.0, 16.5, 18.0)
    assert(m * 1.5 === r)
  }

  test("Matrix divided by a scalar") {
    val m = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
    val r = Mat3x4d(0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0, 5.5, 6.0)
    assert(m / 2.0 === r)
  }

  test("Get the rows of the matrix") {
    val m = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
    val r0 = Vec4d(1.0, 2.0, 3.0, 4.0)
    val r1 = Vec4d(5.0, 6.0, 7.0, 8.0)
    val r2 = Vec4d(9.0, 10.0, 11.0, 12.0)
    assert(m.row0 == r0)
    assert(m.row1 == r1)
    assert(m.row2 == r2)
  }

  test("Get row at index") {
    val m = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
    val r0 = Vec4d(1.0, 2.0, 3.0, 4.0)
    val r1 = Vec4d(5.0, 6.0, 7.0, 8.0)
    val r2 = Vec4d(9.0, 10.0, 11.0, 12.0)
    assert(m.row(0) == r0)
    assert(m.row(1) == r1)
    assert(m.row(2) == r2)
    assertThrows[scala.MatchError] {m.row(3)}
  }

  test("Get the columns of the matrix") {
    val m = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
    val c0 = Vec3d(1.0, 5.0, 9.0)
    val c1 = Vec3d(2.0, 6.0, 10.0)
    val c2 = Vec3d(3.0, 7.0, 11.0)
    val c3 = Vec3d(4.0, 8.0, 12.0)
    assert(m.col0 == c0)
    assert(m.col1 == c1)
    assert(m.col2 == c2)
    assert(m.col3 == c3)
  }

  test("Get column at index") {
    val m = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
    val c0 = Vec3d(1.0, 5.0, 9.0)
    val c1 = Vec3d(2.0, 6.0, 10.0)
    val c2 = Vec3d(3.0, 7.0, 11.0)
    val c3 = Vec3d(4.0, 8.0, 12.0)
    assert(m.col(0) == c0)
    assert(m.col(1) == c1)
    assert(m.col(2) == c2)
    assert(m.col(3) == c3)
    assertThrows[scala.MatchError] {m.col(4)}
  }

  test("Matrix vector product") {
    val mat = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
    val vec = Vec4d(1.5, 2.5, 3.5, 4.5)
    val res = Vec3d(35.0, 83.0, 131.0)
    assert(mat * vec === res)
  }

  test("Matrix vector product with values") {
    val mat = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
    val res = Vec3d(35.0, 83.0, 131.0)
    assert(mat * (1.5, 2.5, 3.5, 4.5) === res)
  }

  test("Matrix vector product with a 3D vector and a fourth value") {
    val mat = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
    val vec = Vec3d(1.5, 2.5, 3.5)
    val res = Vec3d(35.0, 83.0, 131.0)
    assert(mat * (vec, 4.5) === res)
  }

  test("Matrix vector product with a 2D vector and two values") {
    val mat = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
    val vec = Vec2d(1.5, 2.5)
    val res = Vec3d(35.0, 83.0, 131.0)
    assert(mat * (vec, 3.5, 4.5) === res)
  }

  test("Matrix product with 4x4 matrix") {
    val m1 = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
    val m2 = Mat4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0)
    val res = Mat3x4d(90.0, 100.0, 110.0, 120.0, 202.0, 228.0, 254.0, 280.0, 314.0, 356.0, 398.0, 440.0)
    assert(m1 * m2 === res)
  }

  test("Lerp elements") {
    val from = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
    val to = Mat3x4d(2.0, 4.0, 6.0, 8.0, 10.0, 12.0, 14.0, 16.0, 18.0, 20.0, 22.0, 24.0)
    val res = Mat3x4d(1.5, 3.0, 4.5, 6.0, 7.5, 9.0, 10.5, 12.0, 13.5, 15.0, 16.5, 18.0)
    assert(from.lerp(to, 0.5) === res)
  }

  test("Absolute values of the elements of a matrix") {
    val mat = Mat3x4d(1.0, 2.0, 0.0, -2.0, 3.0, -1.0, -3.0, 0.0, 1.0, -7.0, 4.0, 0.0)
    val abs = Mat3x4d(1.0, 2.0, 0.0, 2.0, 3.0, 1.0, 3.0, 0.0, 1.0, 7.0, 4.0, 0.0)
    assert(mat.abs == abs)
  }

  test("Sign values of the elements of a matrix") {
    val mat = Mat3x4d(1.0, 2.0, 0.0, -2.0, 3.0, -1.0, -3.0, 0.0, 1.0, -7.0, 4.0, 0.0)
    val sign = Mat3x4d(1.0, 1.0, 0.0, -1.0, 1.0, -1.0, -1.0, 0.0, 1.0, -1.0, 1.0, 0.0)
    assert(mat.sign == sign)
  }

  test("Round the elements of a matrix") {
    val mat = Mat3x4d(1.1, 1.9, 0.2, 0.8, 2.1, 2.9, 2.7, 2.3, 0.9, 1.1, 0.9, 2.6)
    val round = Mat3x4d(1.0, 2.0, 0.0, 1.0, 2.0, 3.0, 3.0, 2.0, 1.0, 1.0, 1.0, 3.0)
    assert(mat.round == round)
  }

  test("Ceil the elements of a matrix") {
    val mat = Mat3x4d(1.1, 1.9, 0.2, 0.8, 2.1, 2.9, 2.7, 2.3, 0.9, 1.1, 0.9, 2.6)
    val ceil = Mat3x4d(2.0, 2.0, 1.0, 1.0, 3.0, 3.0, 3.0, 3.0, 1.0, 2.0, 1.0, 3.0)
    assert(mat.ceil == ceil)
  }

  test("Floor the elements of a matrix") {
    val mat = Mat3x4d(1.1, 1.9, 0.2, 0.8, 2.1, 2.9, 2.7, 2.3, 0.9, 1.1, 0.9, 2.6)
    val floor = Mat3x4d(1.0, 1.0, 0.0, 0.0, 2.0, 2.0, 2.0, 2.0, 0.0, 1.0, 0.0, 2.0)
    assert(mat.floor == floor)
  }

  // TODO: Orthonormalize

  test("Matrix equals approx") {
    val m1 = Mat3x4d(1.00000001, 1.99999999, 3.00000001, 3.99999999, 5.00000001, 5.99999999, 7.00000001, 7.99999999, 9.00000001, 2.00000001, 1.99999999, 3.00000001)
    val m2 = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 2.0, 2.0, 3.0)
    assert(m1 ~= m2)
  }

  test("Get element at index") {
    val m = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
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
    assertThrows[scala.MatchError] {m(3, 0)}
    assertThrows[scala.MatchError] {m(0, 4)}
    assertThrows[scala.MatchError] {m(3, 4)}
  }

  test("Construct matrix from rows") {
    val m = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
    val r0 = Vec4d(1.0, 2.0, 3.0, 4.0)
    val r1 = Vec4d(5.0, 6.0, 7.0, 8.0)
    val r2 = Vec4d(9.0, 10.0, 11.0, 12.0)
    assert(Mat3x4d.fromRows(r0, r1, r2) == m)
  }

  test("Construct matrix from columns") {
    val m = Mat3x4d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)
    val c0 = Vec3d(1.0, 5.0, 9.0)
    val c1 = Vec3d(2.0, 6.0, 10.0)
    val c2 = Vec3d(3.0, 7.0, 11.0)
    val c3 = Vec3d(4.0, 8.0, 12.0)
    assert(Mat3x4d.fromColumns(c0, c1, c2, c3) == m)
  }

  test("Translation matrix from values") {
    val v1 = Vec3d(1.0, 2.0, 3.0)
    val v2 = Vec3d(4.0, 6.0, 5.0)
    val m = Mat3x4d.translation(3.0, 4.0, 2.0)
    assert(m * (v1, 1.0) === v2)
  }

  test("Translation matrix from 3D vector") {
    val v = Vec3d(1.0, 2.0, 3.0)
    val t = Vec3d(3.0, 4.0, 2.0)
    val m = Mat3x4d.translation(t)
    assert(m * (v, 1.0) === v + t)
  }

  test("Translation matrix from 2D vector") {
    val v = Vec2d(1.0, 2.0)
    val t = Vec2d(3.0, 4.0)
    val m = Mat3x4d.translation(t)
    assert((m * (v, 0.0, 1.0)).xy === v + t)
  }

  // TODO: Rotation matrices

  test("Scaling matrix from values") {
    val v1 = Vec3d(1.5, 1.5, 1.5)
    val v2 = Vec3d(3.0, 4.5, 6.0)
    val m = Mat3x4d.scaling(2.0, 3.0, 4.0)
    assert(m * (v1, 0.0) === v2)
  }

  test("Scaling matrix from 3D vector") {
    val v = Vec3d(1.5, 1.5, 1.5)
    val s = Vec3d(2.0, 3.0, 4.0)
    val m = Mat3x4d.scaling(s)
    assert(m * (v, 0.0) === v * s)
  }

  test("Scaling matrix from 2D vector") {
    val v = Vec2d(1.5, 1.5)
    val s = Vec2d(2.0, 3.0)
    val m = Mat4d.scaling(s)
    assert((m * (v, 0.0, 0.0)).xy === v * s)
  }
}
