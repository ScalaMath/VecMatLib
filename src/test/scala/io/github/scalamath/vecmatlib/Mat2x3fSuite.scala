package io.github.scalamath.vecmatlib

import org.scalactic.Equality
import org.scalatest.funsuite.AnyFunSuite

class Mat2x3fSuite extends AnyFunSuite {

  implicit val equalityMat2x3f: Equality[Mat2x3f] = (a: Mat2x3f, b: Any) => b match {
    case b: Mat2x3f => a ~= b
    case _ => false
  }

  implicit val equalityVec2f: Equality[Vec2f] = (a: Vec2f, b: Any) => b match {
    case b: Vec2f => a ~= b
    case _ => false
  }

  implicit val equalityVec3f: Equality[Vec3f] = (a: Vec3f, b: Any) => b match {
    case b: Vec3f => a ~= b
    case _ => false
  }

  test("Sum of two matrices") {
    val m1 = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f)
    val m2 = Mat2x3f(3.0f, 4.0f, 1.0f, 2.0f, 6.0f, 5.0f)
    val res = Mat2x3f(4.0f, 6.0f, 4.0f, 6.0f, 11.0f, 11.0f)
    assert(m1 + m2 === res)
  }

  test("Unary plus") {
    val m = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f)
    assert(+m == m)
  }

  test("Subtraction of two matrices") {
    val m1 = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f)
    val m2 = Mat2x3f(3.0f, 4.0f, 1.0f, 2.0f, 6.0f, 5.0f)
    val res = Mat2x3f(2.0f, 2.0f, -2.0f, -2.0f, 1.0f, -1.0f)
    assert(m2 - m1 === res)
  }

  test("Unary minus") {
    val m = Mat2x3f(1.0f, 2.0f, -2.0f, -1.0f, 3.0f, -2.0f)
    val r = Mat2x3f(-1.0f, -2.0f, 2.0f, 1.0f, -3.0f, 2.0f)
    assert(-m == r)
  }

  test("Matrix multiplied by a scalar") {
    val m = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f)
    val r = Mat2x3f(1.5f, 3.0f, 4.5f, 6.0f, 7.5f, 9.0f)
    assert(m * 1.5f === r)
  }

  test("Matrix divided by a scalar") {
    val m = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f)
    val r = Mat2x3f(0.5f, 1.0f, 1.5f, 2.0f, 2.5f, 3.0f)
    assert(m / 2.0f === r)
  }

  test("Get the rows of the matrix") {
    val m = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f)
    val r0 = Vec3f(1.0f, 2.0f, 3.0f)
    val r1 = Vec3f(4.0f, 5.0f, 6.0f)
    assert(m.row0 == r0)
    assert(m.row1 == r1)
  }

  test("Get row at index") {
    val m = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f)
    val r0 = Vec3f(1.0f, 2.0f, 3.0f)
    val r1 = Vec3f(4.0f, 5.0f, 6.0f)
    assert(m.row(0) == r0)
    assert(m.row(1) == r1)
    assertThrows[scala.MatchError] {m.row(2)}
  }

  test("Get the columns of the matrix") {
    val m = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f)
    val c0 = Vec2f(1.0f, 4.0f)
    val c1 = Vec2f(2.0f, 5.0f)
    val c2 = Vec2f(3.0f, 6.0f)
    assert(m.col0 == c0)
    assert(m.col1 == c1)
    assert(m.col2 == c2)
  }

  test("Get column at index") {
    val m = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f)
    val c0 = Vec2f(1.0f, 4.0f)
    val c1 = Vec2f(2.0f, 5.0f)
    val c2 = Vec2f(3.0f, 6.0f)
    assert(m.col(0) == c0)
    assert(m.col(1) == c1)
    assert(m.col(2) == c2)
    assertThrows[scala.MatchError] {m.col(3)}
  }

  test("Matrix vector product") {
    val mat = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f)
    val vec = Vec3f(2.0f, 3.0f, 4.0f)
    val res = Vec2f(20.0f, 47.0f)
    assert(mat * vec === res)
  }

  test("Matrix vector product with values") {
    val mat = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f)
    val res = Vec2f(20.0f, 47.0f)
    assert(mat * (2.0f, 3.0f, 4.0f) === res)
  }

  test("Matrix vector product with a 2D vector and a third value") {
    val mat = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f)
    val vec = Vec2f(2.0f, 3.0f)
    val res = Vec2f(20.0f, 47.0f)
    assert(mat * (vec, 4.0f) === res)
  }

  test("Matrix product with 3x3 matrix") {
    val m1 = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f)
    val m2 = Mat3f(3.0f, 4.0f, 1.0f, 2.0f, 6.0f, 5.0f, -2.0f, 8.0f, -1.0f)
    val res = Mat2x3f(1.0f, 40.0f, 8.0f, 10.0f, 94.0f, 23.0f)
    assert(m1 * m2 === res)
  }

  test("Lerp elements") {
    val from = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f)
    val to = Mat2x3f(2.0f, 4.0f, 6.0f, 8.0f, 10.0f, 12.0f)
    val res = Mat2x3f(1.5f, 3.0f, 4.5f, 6.0f, 7.5f, 9.0f)
    assert(from.lerp(to, 0.5f) === res)
  }

  test("Absolute values of the elements of a matrix") {
    val mat = Mat2x3f(1.0f, 2.0f, 0.0f, -2.0f, 0.0f, -1.0f)
    val abs = Mat2x3f(1.0f, 2.0f, 0.0f, 2.0f, 0.0f, 1.0f)
    assert(mat.abs == abs)
  }

  test("Sign values of the elements of a matrix") {
    val mat = Mat2x3f(1.0f, 2.0f, 0.0f, -2.0f, 0.0f, -1.0f)
    val sign = Mat2x3f(1.0f, 1.0f, 0.0f, -1.0f, 0.0f, -1.0f)
    assert(mat.sign == sign)
  }

  test("Round the elements of a matrix") {
    val mat = Mat2x3f(1.1f, 1.9f, 0.2f, 0.8f, 2.7f, 2.2f)
    val round = Mat2x3f(1.0f, 2.0f, 0.0f, 1.0f, 3.0f, 2.0f)
    assert(mat.round == round)
  }

  test("Ceil the elements of a matrix") {
    val mat = Mat2x3f(1.1f, 1.9f, 0.2f, 0.8f, 2.7f, 2.2f)
    val ceil = Mat2x3f(2.0f, 2.0f, 1.0f, 1.0f, 3.0f, 3.0f)
    assert(mat.ceil == ceil)
  }

  test("Floor the elements of a matrix") {
    val mat = Mat2x3f(1.1f, 1.9f, 0.2f, 0.8f, 2.7f, 2.2f)
    val floor = Mat2x3f(1.0f, 1.0f, 0.0f, 0.0f, 2.0f, 2.0f)
    assert(mat.floor == floor)
  }

  // TODO: Orthonormalize

  test("Matrix equals approx") {
    val m1 = Mat2x3f(1.00000001f, 1.99999999f, 3.00000001f, 3.99999999f, 0.00000001f, -0.00000001f)
    val m2 = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 0.0f, 0.0f)
    assert(m1 ~= m2)
  }

  test("Get element at index") {
    val m = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f)
    assert(m(0, 0) == 1.0f)
    assert(m(0, 1) == 2.0f)
    assert(m(0, 2) == 3.0f)
    assert(m(1, 0) == 4.0f)
    assert(m(1, 1) == 5.0f)
    assert(m(1, 2) == 6.0f)
    assertThrows[scala.MatchError] {m(2, 0)}
    assertThrows[scala.MatchError] {m(0, 3)}
    assertThrows[scala.MatchError] {m(2, 3)}
  }

  test("Construct matrix from rows") {
    val m = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f)
    val r0 = Vec3f(1.0f, 2.0f, 3.0f)
    val r1 = Vec3f(4.0f, 5.0f, 6.0f)
    assert(Mat2x3f.fromRows(r0, r1) == m)
  }

  test("Construct matrix from columns") {
    val m = Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f)
    val c0 = Vec2f(1.0f, 4.0f)
    val c1 = Vec2f(2.0f, 5.0f)
    val c2 = Vec2f(3.0f, 6.0f)
    assert(Mat2x3f.fromColumns(c0, c1, c2) == m)
  }

  test("Translation matrix from values") {
    val v1 = Vec2f(1.0f, 1.0f)
    val v2 = Vec2f(3.0f, 4.0f)
    val m = Mat2x3f.translation(2.0f, 3.0f)
    assert(m * (v1, 1.0f) === v2)
  }

  test("Translation matrix from vector") {
    val v1 = Vec2f(1.0f, 1.0f)
    val v2 = Vec2f(3.0f, 4.0f)
    val m = Mat2x3f.translation(v2)
    assert(m * (v1, 1.0f) === v1 + v2)
  }

  test("Rotation matrix") {
    val v1 = Vec2f(2.0f, 0.0f)
    val v2 = Vec2f(0.0f, 2.0f)
    val m = Mat2x3f.rotation(math.Pi / 2.0)
    assert(m * (v1, 0.0f) === v2)
  }

  test("Scaling matrix from values") {
    val v1 = Vec2f(1.5f, 1.5f)
    val v2 = Vec2f(3.0f, 4.5f)
    val m = Mat2x3f.scaling(2.0f, 3.0f)
    assert(m * (v1, 0.0f) === v2)
  }

  test("Scaling matrix from vector") {
    val v1 = Vec2f(1.5f, 1.5f)
    val v2 = Vec2f(3.0f, 4.5f)
    val m = Mat2x3f.scaling(Vec2f(2.0f, 3.0f))
    assert(m * (v1, 0.0f) === v2)
  }

  test("Scaling matrix from equal scale") {
    val v1 = Vec2f(1.5f, 2.0f)
    val v2 = Vec2f(3.0f, 4.0f)
    val m = Mat2x3f.scaling(2.0f)
    assert(m * (v1, 0.0f) === v2)
  }

  // TODO: Shearing
}
