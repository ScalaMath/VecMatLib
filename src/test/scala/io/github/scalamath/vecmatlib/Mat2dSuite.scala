package io.github.scalamath.vecmatlib

import org.scalactic.Equality
import org.scalatest.funsuite.AnyFunSuite

class Mat2dSuite extends AnyFunSuite {

  implicit val equalityMat2d: Equality[Mat2d] = (a: Mat2d, b: Any) => b match {
    case b: Mat2d => a ~= b
    case _ => false
  }

  implicit val equalityVec2d: Equality[Vec2d] = (a: Vec2d, b: Any) => b match {
    case b: Vec2d => a ~= b
    case _ => false
  }

  test("Sum of two matrices") {
    val m1 = Mat2d(1.0, 2.0, 3.0, 4.0)
    val m2 = Mat2d(3.0, 4.0, 1.0, 2.0)
    val res = Mat2d(4.0, 6.0, 4.0, 6.0)
    assert(m1 + m2 === res)
  }

  test("Unary plus") {
    val m = Mat2d(1.0, 2.0, 3.0, 4.0)
    assert(+m == m)
  }

  test("Subtraction of two matrices") {
    val m1 = Mat2d(1.0, 2.0, 3.0, 4.0)
    val m2 = Mat2d(3.0, 4.0, 1.0, 2.0)
    val res = Mat2d(2.0, 2.0, -2.0, -2.0)
    assert(m2 - m1 === res)
  }

  test("Unary minus") {
    val m = Mat2d(1.0, 2.0, -2.0, -1.0)
    val r = Mat2d(-1.0, -2.0, 2.0, 1.0)
    assert(-m == r)
  }

  test("Matrix multiplied by a scalar") {
    val m = Mat2d(1.0, 2.0, 3.0, 4.0)
    val r = Mat2d(1.5, 3.0, 4.5, 6.0)
    assert(m * 1.5 === r)
  }

  test("Matrix divided by a scalar") {
    val m = Mat2d(1.0, 2.0, 3.0, 4.0)
    val r = Mat2d(0.5, 1.0, 1.5, 2.0)
    assert(m / 2.0 === r)
  }

  test("Get the rows of the matrix") {
    val m = Mat2d(1.0, 2.0, 3.0, 4.0)
    val r0 = Vec2d(1.0, 2.0)
    val r1 = Vec2d(3.0, 4.0)
    assert(m.row0 == r0)
    assert(m.row1 == r1)
  }

  test("Get row at index") {
    val m = Mat2d(1.0, 2.0, 3.0, 4.0)
    val r0 = Vec2d(1.0, 2.0)
    val r1 = Vec2d(3.0, 4.0)
    assert(m.row(0) == r0)
    assert(m.row(1) == r1)
    assertThrows[MatchError] {m.row(2)}
  }

  test("Get the columns of the matrix") {
    val m = Mat2d(1.0, 2.0, 3.0, 4.0)
    val c0 = Vec2d(1.0, 3.0)
    val c1 = Vec2d(2.0, 4.0)
    assert(m.col0 == c0)
    assert(m.col1 == c1)
  }

  test("Get column at index") {
    val m = Mat2d(1.0, 2.0, 3.0, 4.0)
    val c0 = Vec2d(1.0, 3.0)
    val c1 = Vec2d(2.0, 4.0)
    assert(m.col(0) == c0)
    assert(m.col(1) == c1)
    assertThrows[MatchError] {m.col(2)}
  }

  test("Matrix vector product") {
    val mat = Mat2d(1.0, 2.0, 3.0, 4.0)
    val vec = Vec2d(1.5, 2.5)
    val res = Vec2d(6.5, 14.5)
    assert(mat * vec === res)
  }

  test("Matrix vector product with values") {
    val mat = Mat2d(1.0, 2.0, 3.0, 4.0)
    val res = Vec2d(6.5, 14.5)
    assert(mat * (1.5, 2.5) === res)
  }

  test("Matrix product with 2x2 matrix") {
    val m1 = Mat2d(1.0, 2.0, 3.0, 4.0)
    val m2 = Mat2d(3.0, 4.0, 1.0, 2.0)
    val res = Mat2d(5.0, 8.0, 13.0, 20.0)
    assert(m1 * m2 === res)
  }

  test("Matrix product with 2x3 matrix") {
    val m1 = Mat2d(1.0, 2.0, 3.0, 4.0)
    val m2 = Mat2x3d(3.0, 4.0, 1.0, 2.0, 6.0, 5.0)
    val res = Mat2x3d(7.0, 16.0, 11.0, 17.0, 36.0, 23.0)
    assert(m1 * m2 === res)
  }

  test("Transposed matrix") {
    val m = Mat2d(1.0, 2.0, 3.0, 4.0)
    val t = Mat2d(1.0, 3.0, 2.0, 4.0)
    assert(m.transposed == t)
  }

  test("Symmetric matrix") {
    val m1 = Mat2d(1.0, 2.0, 2.0, 1.0)
    val m2 = Mat2d(1.0, 2.0, 3.0, 4.0)
    assert(m1.isSymmetric)
    assert(!m2.isSymmetric)
  }

  test("Skew-symmetric matrix") {
    val m1 = Mat2d(1.0, 2.0, 2.0, 1.0)
    val m2 = Mat2d(0.0, 1.0, -1.0, 0.0)
    assert(!m1.isSkewSymmetric)
    assert(m2.isSkewSymmetric)
  }

  test("Matrix determinant") {
    val m = Mat2d(1.0, 2.0, 3.0, 4.0)
    assert(m.determinant == -2.0)
  }

  test("Adjugate matrix") {
    val mat = Mat2d(1.0, 2.0, 3.0, 4.0)
    val adj = Mat2d(4.0, -2.0, -3.0, 1.0)
    assert(mat.adjugate == adj)
  }

  test("Inverse matrix") {
    val mat = Mat2d(1.0, 2.0, 3.0, 4.0)
    val inv = Mat2d(-2.0, 1.0, 3.0 / 2.0, -0.5)
    assert(mat.inverse === inv)
  }

  test("Power of a matrix with a positive exponent") {
    val m = Mat2d(1.0, 2.0, 3.0, 4.0)
    assert(m.power(3) === m * m * m)
  }

  test("Matrix to the power of zero") {
    val m = Mat2d(1.0, 2.0, 3.0, 4.0)
    assert(m.power(0) == Mat2d.Identity)
  }

  test("Matrix to the power of one") {
    val m = Mat2d(1.0, 2.0, 3.0, 4.0)
    assert(m.power(1) == m)
  }

  test("Power of a matrix with a negative exponent") {
    val m = Mat2d(1.0, 2.0, 3.0, 4.0)
    val i = m.inverse
    assert(m.power(-3) === i * i * i)
  }

  test("Lerp elements") {
    val from = Mat2d(1.0, 2.0, 3.0, 4.0)
    val to = Mat2d(2.0, 4.0, 6.0, 8.0)
    val res = Mat2d(1.5, 3.0, 4.5, 6.0)
    assert(from.lerp(to, 0.5) === res)
  }

  test("Absolute values of the elements of a matrix") {
    val mat = Mat2d(1.0, 2.0, 0.0, -2.0)
    val abs = Mat2d(1.0, 2.0, 0.0, 2.0)
    assert(mat.abs == abs)
  }

  test("Sign values of the elements of a matrix") {
    val mat = Mat2d(1.0, 2.0, 0.0, -2.0)
    val sign = Mat2d(1.0, 1.0, 0.0, -1.0)
    assert(mat.sign == sign)
  }

  test("Round the elements of a matrix") {
    val mat = Mat2d(1.1, 1.9, 0.2, 0.8)
    val round = Mat2d(1.0, 2.0, 0.0, 1.0)
    assert(mat.round == round)
  }

  test("Ceil the elements of a matrix") {
    val mat = Mat2d(1.1, 1.9, 0.2, 0.8)
    val ceil = Mat2d(2.0, 2.0, 1.0, 1.0)
    assert(mat.ceil == ceil)
  }

  test("Floor the elements of a matrix") {
    val mat = Mat2d(1.1, 1.9, 0.2, 0.8)
    val floor = Mat2d(1.0, 1.0, 0.0, 0.0)
    assert(mat.floor == floor)
  }

  test("Orthonormalize matrix") {
    val mat = Mat2d(1.0, 2.0, 3.0, 4.0)
    val res = Mat2d(1.0, 3.0, 3.0, -1.0) / math.sqrt(10.0)
    assert(mat.orthonormalized === res)
  }

  test("Matrix equals approx") {
    val m1 = Mat2d(1.00000001, 1.99999999, 3.00000001, 3.99999999)
    val m2 = Mat2d(1.0, 2.0, 3.0, 4.0)
    assert(m1 ~= m2)
  }

  test("Get element at index") {
    val m = Mat2d(1.0, 2.0, 3.0, 4.0)
    assert(m(0, 0) == 1.0)
    assert(m(0, 1) == 2.0)
    assert(m(1, 0) == 3.0)
    assert(m(1, 1) == 4.0)
    assertThrows[MatchError] {m(2, 0)}
    assertThrows[MatchError] {m(0, 2)}
    assertThrows[MatchError] {m(2, 2)}
  }

  test("Construct matrix from rows") {
    val m = Mat2d(1.0, 2.0, 3.0, 4.0)
    val r0 = Vec2d(1.0, 2.0)
    val r1 = Vec2d(3.0, 4.0)
    assert(Mat2d.fromRows(r0, r1) == m)
  }

  test("Construct matrix from columns") {
    val m = Mat2d(1.0, 2.0, 3.0, 4.0)
    val c0 = Vec2d(1.0, 3.0)
    val c1 = Vec2d(2.0, 4.0)
    assert(Mat2d.fromColumns(c0, c1) == m)
  }

  test("Rotation matrix") {
    val v1 = Vec2d(2.0, 0.0)
    val v2 = Vec2d(0.0, 2.0)
    val m = Mat2d.rotation(math.Pi / 2.0)
    assert(m * v1 === v2)
  }

  test("Scaling matrix from values") {
    val v1 = Vec2d(1.5, 1.5)
    val v2 = Vec2d(3.0, 4.5)
    val m = Mat2d.scaling(2.0, 3.0)
    assert(m * v1 === v2)
  }

  test("Scaling matrix from vector") {
    val v1 = Vec2d(1.5, 1.5)
    val v2 = Vec2d(3.0, 4.5)
    val m = Mat2d.scaling(Vec2d(2.0, 3.0))
    assert(m * v1 === v2)
  }

  test("Scaling matrix from equal scale") {
    val v1 = Vec2d(1.5, 2.0)
    val v2 = Vec2d(3.0, 4.0)
    val m = Mat2d.scaling(2.0)
    assert(m * v1 === v2)
  }

  // TODO: Shearing
}
