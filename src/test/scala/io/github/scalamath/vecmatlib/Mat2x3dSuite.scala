package io.github.scalamath.vecmatlib

import org.scalactic.Equality
import org.scalatest.funsuite.AnyFunSuite

class Mat2x3dSuite extends AnyFunSuite {

  implicit val equalityMat2x3d: Equality[Mat2x3d] = (a: Mat2x3d, b: Any) => b match {
    case b: Mat2x3d => a ~= b
    case _ => false
  }

  implicit val equalityVec2d: Equality[Vec2d] = (a: Vec2d, b: Any) => b match {
    case b: Vec2d => a ~= b
    case _ => false
  }

  implicit val equalityVec3d: Equality[Vec3d] = (a: Vec3d, b: Any) => b match {
    case b: Vec3d => a ~= b
    case _ => false
  }

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
    val m1 = Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    val m2 = Mat2x3d(3.0, 4.0, 1.0, 2.0, 6.0, 5.0)
    val res = Mat2x3d(4.0, 6.0, 4.0, 6.0, 11.0, 11.0)
    assert(m1 + m2 === res)
  }

  test("Unary plus") {
    val m = Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    assert(+m == m)
  }

  test("Subtraction of two matrices") {
    val m1 = Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    val m2 = Mat2x3d(3.0, 4.0, 1.0, 2.0, 6.0, 5.0)
    val res = Mat2x3d(2.0, 2.0, -2.0, -2.0, 1.0, -1.0)
    assert(m2 - m1 === res)
  }

  test("Unary minus") {
    val m = Mat2x3d(1.0, 2.0, -2.0, -1.0, 3.0, -2.0)
    val r = Mat2x3d(-1.0, -2.0, 2.0, 1.0, -3.0, 2.0)
    assert(-m == r)
  }

  test("Matrix multiplied by a scalar") {
    val m = Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    val r = Mat2x3d(1.5, 3.0, 4.5, 6.0, 7.5, 9.0)
    assert(m * 1.5 === r)
  }

  test("Matrix divided by a scalar") {
    val m = Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    val r = Mat2x3d(0.5, 1.0, 1.5, 2.0, 2.5, 3.0)
    assert(m / 2.0 === r)
  }

  test("Get the rows of the matrix") {
    val m = Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    val r0 = Vec3d(1.0, 2.0, 3.0)
    val r1 = Vec3d(4.0, 5.0, 6.0)
    assert(m.row0 == r0)
    assert(m.row1 == r1)
  }

  test("Get row at index") {
    val m = Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    val r0 = Vec3d(1.0, 2.0, 3.0)
    val r1 = Vec3d(4.0, 5.0, 6.0)
    assert(m.row(0) == r0)
    assert(m.row(1) == r1)
    assertThrows[MatchError] {m.row(2)}
  }

  test("Get the columns of the matrix") {
    val m = Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    val c0 = Vec2d(1.0, 4.0)
    val c1 = Vec2d(2.0, 5.0)
    val c2 = Vec2d(3.0, 6.0)
    assert(m.col0 == c0)
    assert(m.col1 == c1)
    assert(m.col2 == c2)
  }

  test("Get column at index") {
    val m = Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    val c0 = Vec2d(1.0, 4.0)
    val c1 = Vec2d(2.0, 5.0)
    val c2 = Vec2d(3.0, 6.0)
    assert(m.col(0) == c0)
    assert(m.col(1) == c1)
    assert(m.col(2) == c2)
    assertThrows[MatchError] {m.col(3)}
  }

  test("Matrix vector product") {
    val mat = Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    val vec = Vec3d(2.0, 3.0, 4.0)
    val res = Vec2d(20.0, 47.0)
    assert(mat * vec === res)
  }

  test("Matrix vector product with values") {
    val mat = Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    val res = Vec2d(20.0, 47.0)
    assert(mat * (2.0, 3.0, 4.0) === res)
  }

  test("Matrix vector product with a 2D vector and a third value") {
    val mat = Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    val vec = Vec2d(2.0, 3.0)
    val res = Vec2d(20.0, 47.0)
    assert(mat * (vec, 4.0) === res)
  }

  test("Matrix product with 3x3 matrix") {
    val m1 = Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    val m2 = Mat3d(3.0, 4.0, 1.0, 2.0, 6.0, 5.0, -2.0, 8.0, -1.0)
    val res = Mat2x3d(1.0, 40.0, 8.0, 10.0, 94.0, 23.0)
    assert(m1 * m2 === res)
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

  ignore("Affine inverse") {
    // TODO
  }

  test("Lerp elements") {
    val from = Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    val to = Mat2x3d(2.0, 4.0, 6.0, 8.0, 10.0, 12.0)
    val res = Mat2x3d(1.5, 3.0, 4.5, 6.0, 7.5, 9.0)
    assert(from.lerp(to, 0.5) === res)
  }

  test("Absolute values of the elements of a matrix") {
    val mat = Mat2x3d(1.0, 2.0, 0.0, -2.0, 0.0, -1.0)
    val abs = Mat2x3d(1.0, 2.0, 0.0, 2.0, 0.0, 1.0)
    assert(mat.abs == abs)
  }

  test("Sign values of the elements of a matrix") {
    val mat = Mat2x3d(1.0, 2.0, 0.0, -2.0, 0.0, -1.0)
    val sign = Mat2x3d(1.0, 1.0, 0.0, -1.0, 0.0, -1.0)
    assert(mat.sign == sign)
  }

  test("Round the elements of a matrix") {
    val mat = Mat2x3d(1.1, 1.9, 0.2, 0.8, 2.7, 2.2)
    val round = Mat2x3d(1.0, 2.0, 0.0, 1.0, 3.0, 2.0)
    assert(mat.round == round)
  }

  test("Ceil the elements of a matrix") {
    val mat = Mat2x3d(1.1, 1.9, 0.2, 0.8, 2.7, 2.2)
    val ceil = Mat2x3d(2.0, 2.0, 1.0, 1.0, 3.0, 3.0)
    assert(mat.ceil == ceil)
  }

  test("Floor the elements of a matrix") {
    val mat = Mat2x3d(1.1, 1.9, 0.2, 0.8, 2.7, 2.2)
    val floor = Mat2x3d(1.0, 1.0, 0.0, 0.0, 2.0, 2.0)
    assert(mat.floor == floor)
  }

  ignore("Orthonormalize matrix") {
    // TODO: Orthonormalize matrix
  }

  test("Matrix equals approx") {
    val m1 = Mat2x3d(1.00000001, 1.99999999, 3.00000001, 3.99999999, 0.00000001, -0.00000001)
    val m2 = Mat2x3d(1.0, 2.0, 3.0, 4.0, 0.0, 0.0)
    assert(m1 ~= m2)
  }

  test("Get element at index") {
    val m = Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    assert(m(0, 0) == 1.0)
    assert(m(0, 1) == 2.0)
    assert(m(0, 2) == 3.0)
    assert(m(1, 0) == 4.0)
    assert(m(1, 1) == 5.0)
    assert(m(1, 2) == 6.0)
    assertThrows[MatchError] {m(2, 0)}
    assertThrows[MatchError] {m(0, 3)}
    assertThrows[MatchError] {m(2, 3)}
  }

  test("Construct matrix from rows") {
    val m = Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    val r0 = Vec3d(1.0, 2.0, 3.0)
    val r1 = Vec3d(4.0, 5.0, 6.0)
    assert(Mat2x3d.fromRows(r0, r1) == m)
  }

  test("Construct matrix from columns") {
    val m = Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    val c0 = Vec2d(1.0, 4.0)
    val c1 = Vec2d(2.0, 5.0)
    val c2 = Vec2d(3.0, 6.0)
    assert(Mat2x3d.fromColumns(c0, c1, c2) == m)
  }

  test("Translation matrix from values") {
    val v1 = Vec2d(1.0, 1.0)
    val v2 = Vec2d(3.0, 4.0)
    val m = Mat2x3d.translation(2.0, 3.0)
    assert(m * (v1, 1.0) === v2)
  }

  test("Translation matrix from vector") {
    val v1 = Vec2d(1.0, 1.0)
    val v2 = Vec2d(3.0, 4.0)
    val m = Mat2x3d.translation(v2)
    assert(m * (v1, 1.0) === v1 + v2)
  }

  test("Rotation matrix") {
    val v1 = Vec2d(2.0, 0.0)
    val v2 = Vec2d(0.0, 2.0)
    val m = Mat2x3d.rotation(math.Pi / 2.0)
    assert(m * (v1, 0.0) === v2)
  }

  test("Scaling matrix from values") {
    val v1 = Vec2d(1.5, 1.5)
    val v2 = Vec2d(3.0, 4.5)
    val m = Mat2x3d.scaling(2.0, 3.0)
    assert(m * (v1, 0.0) === v2)
  }

  test("Scaling matrix from vector") {
    val v1 = Vec2d(1.5, 1.5)
    val v2 = Vec2d(3.0, 4.5)
    val m = Mat2x3d.scaling(Vec2d(2.0, 3.0))
    assert(m * (v1, 0.0) === v2)
  }

  test("Scaling matrix from equal scale") {
    val v1 = Vec2d(1.5, 2.0)
    val v2 = Vec2d(3.0, 4.0)
    val m = Mat2x3d.scaling(2.0)
    assert(m * (v1, 0.0) === v2)
  }

  // TODO: Shearing
}
