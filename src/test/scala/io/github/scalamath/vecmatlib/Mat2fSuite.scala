package io.github.scalamath.vecmatlib

import org.scalactic.Equality
import org.scalatest.funsuite.AnyFunSuite

class Mat2fSuite extends AnyFunSuite {

  implicit val equalityMat2f: Equality[Mat2f] = (a: Mat2f, b: Any) => b match {
    case b: Mat2f => a ~= b
    case _ => false
  }

  implicit val equalityVec2f: Equality[Vec2f] = (a: Vec2f, b: Any) => b match {
    case b: Vec2f => a ~= b
    case _ => false
  }

  test("Sum of two matrices") {
    val m1 = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val m2 = Mat2f(3.0f, 4.0f, 1.0f, 2.0f)
    val res = Mat2f(4.0f, 6.0f, 4.0f, 6.0f)
    assert(m1 + m2 === res)
  }

  test("Unary plus") {
    val m = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    assert(+m == m)
  }

  test("Subtraction of two matrices") {
    val m1 = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val m2 = Mat2f(3.0f, 4.0f, 1.0f, 2.0f)
    val res = Mat2f(2.0f, 2.0f, -2.0f, -2.0f)
    assert(m2 - m1 === res)
  }

  test("Unary minus") {
    val m = Mat2f(1.0f, 2.0f, -2.0f, -1.0f)
    val r = Mat2f(-1.0f, -2.0f, 2.0f, 1.0f)
    assert(-m == r)
  }

  test("Matrix multiplied by a scalar") {
    val m = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val r = Mat2f(1.5f, 3.0f, 4.5f, 6.0f)
    assert(m * 1.5f === r)
  }

  test("Matrix divided by a scalar") {
    val m = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val r = Mat2f(0.5f, 1.0f, 1.5f, 2.0f)
    assert(m / 2.0f === r)
  }

  test("Get the rows of the matrix") {
    val m = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val r0 = Vec2f(1.0f, 2.0f)
    val r1 = Vec2f(3.0f, 4.0f)
    assert(m.row0 == r0)
    assert(m.row1 == r1)
  }

  test("Get row at index") {
    val m = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val r0 = Vec2f(1.0f, 2.0f)
    val r1 = Vec2f(3.0f, 4.0f)
    assert(m.row(0) == r0)
    assert(m.row(1) == r1)
    assertThrows[scala.MatchError] {m.row(2)}
  }

  test("Get the columns of the matrix") {
    val m = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val c0 = Vec2f(1.0f, 3.0f)
    val c1 = Vec2f(2.0f, 4.0f)
    assert(m.col0 == c0)
    assert(m.col1 == c1)
  }

  test("Get column at index") {
    val m = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val c0 = Vec2f(1.0f, 3.0f)
    val c1 = Vec2f(2.0f, 4.0f)
    assert(m.col(0) == c0)
    assert(m.col(1) == c1)
    assertThrows[scala.MatchError] {m.col(2)}
  }

  test("Matrix vector product") {
    val mat = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val vec = Vec2f(1.5f, 2.5f)
    val res = Vec2f(6.5f, 14.5f)
    assert(mat * vec === res)
  }

  test("Matrix vector product with values") {
    val mat = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val res = Vec2f(6.5f, 14.5f)
    assert(mat * (1.5f, 2.5f) === res)
  }

  test("Matrix product with 2x2 matrix") {
    val m1 = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val m2 = Mat2f(3.0f, 4.0f, 1.0f, 2.0f)
    val res = Mat2f(5.0f, 8.0f, 13.0f, 20.0f)
    assert(m1 * m2 === res)
  }

  test("Matrix product with 2x3 matrix") {
    val m1 = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val m2 = Mat2x3f(3.0f, 4.0f, 1.0f, 2.0f, 6.0f, 5.0f)
    val res = Mat2x3f(7.0f, 16.0f, 11.0f, 17.0f, 36.0f, 23.0f)
    assert(m1 * m2 === res)
  }

  test("Transposed matrix") {
    val m = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val t = Mat2f(1.0f, 3.0f, 2.0f, 4.0f)
    assert(m.transposed == t)
  }

  test("Symmetric matrix") {
    val m1 = Mat2f(1.0f, 2.0f, 2.0f, 1.0f)
    val m2 = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    assert(m1.isSymmetric)
    assert(!m2.isSymmetric)
  }

  test("Skew-symmetric matrix") {
    val m1 = Mat2f(1.0f, 2.0f, 2.0f, 1.0f)
    val m2 = Mat2f(0.0f, 1.0f, -1.0f, 0.0f)
    assert(!m1.isSkewSymmetric)
    assert(m2.isSkewSymmetric)
  }

  test("Matrix determinant") {
    val m = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    assert(m.determinant == -2.0f)
  }

  test("Adjugate matrix") {
    val mat = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val adj = Mat2f(4.0f, -2.0f, -3.0f, 1.0f)
    assert(mat.adjugate == adj)
  }

  test("Inverse matrix") {
    val mat = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val inv = Mat2f(-2.0f, 1.0f, 3.0f / 2.0f, -0.5f)
    assert(mat.inverse === inv)
  }

  test("Power of a matrix with a positive exponent") {
    val m = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    assert(m.power(3) === m * m * m)
  }

  test("Matrix to the power of zero") {
    val m = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    assert(m.power(0) == Mat2f.Identity)
  }

  test("Matrix to the power of one") {
    val m = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    assert(m.power(1) == m)
  }

  test("Power of a matrix with a negative exponent") {
    val m = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val i = m.inverse
    assert(m.power(-3) === i * i * i)
  }

  test("Lerp elements") {
    val from = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val to = Mat2f(2.0f, 4.0f, 6.0f, 8.0f)
    val res = Mat2f(1.5f, 3.0f, 4.5f, 6.0f)
    assert(from.lerp(to, 0.5f) === res)
  }

  test("Absolute values of the elements of a matrix") {
    val mat = Mat2f(1.0f, 2.0f, 0.0f, -2.0f)
    val abs = Mat2f(1.0f, 2.0f, 0.0f, 2.0f)
    assert(mat.abs == abs)
  }

  test("Sign values of the elements of a matrix") {
    val mat = Mat2f(1.0f, 2.0f, 0.0f, -2.0f)
    val sign = Mat2f(1.0f, 1.0f, 0.0f, -1.0f)
    assert(mat.sign == sign)
  }

  test("Round the elements of a matrix") {
    val mat = Mat2f(1.1f, 1.9f, 0.2f, 0.8f)
    val round = Mat2f(1.0f, 2.0f, 0.0f, 1.0f)
    assert(mat.round == round)
  }

  test("Ceil the elements of a matrix") {
    val mat = Mat2f(1.1f, 1.9f, 0.2f, 0.8f)
    val ceil = Mat2f(2.0f, 2.0f, 1.0f, 1.0f)
    assert(mat.ceil == ceil)
  }

  test("Floor the elements of a matrix") {
    val mat = Mat2f(1.1f, 1.9f, 0.2f, 0.8f)
    val floor = Mat2f(1.0f, 1.0f, 0.0f, 0.0f)
    assert(mat.floor == floor)
  }

  // TODO: Orthonormalize

  test("Matrix equals approx") {
    val m1 = Mat2f(1.00000001f, 1.99999999f, 3.00000001f, 3.99999999f)
    val m2 = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    assert(m1 ~= m2)
  }

  test("Get element at index") {
    val m = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    assert(m(0, 0) == 1.0f)
    assert(m(0, 1) == 2.0f)
    assert(m(1, 0) == 3.0f)
    assert(m(1, 1) == 4.0f)
    assertThrows[scala.MatchError] {m(2, 0)}
    assertThrows[scala.MatchError] {m(0, 2)}
    assertThrows[scala.MatchError] {m(2, 2)}
  }

  test("Construct matrix from rows") {
    val m = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val r0 = Vec2f(1.0f, 2.0f)
    val r1 = Vec2f(3.0f, 4.0f)
    assert(Mat2f.fromRows(r0, r1) == m)
  }

  test("Construct matrix from columns") {
    val m = Mat2f(1.0f, 2.0f, 3.0f, 4.0f)
    val c0 = Vec2f(1.0f, 3.0f)
    val c1 = Vec2f(2.0f, 4.0f)
    assert(Mat2f.fromColumns(c0, c1) == m)
  }

  test("Rotation matrix") {
    val v1 = Vec2f(2.0f, 0.0f)
    val v2 = Vec2f(0.0f, 2.0f)
    val m = Mat2f.rotation(math.Pi / 2.0)
    assert(m * v1 === v2)
  }

  test("Scaling matrix from values") {
    val v1 = Vec2f(1.5f, 1.5f)
    val v2 = Vec2f(3.0f, 4.5f)
    val m = Mat2f.scaling(2.0f, 3.0f)
    assert(m * v1 === v2)
  }

  test("Scaling matrix from vector") {
    val v1 = Vec2f(1.5f, 1.5f)
    val v2 = Vec2f(3.0f, 4.5f)
    val m = Mat2f.scaling(Vec2f(2.0f, 3.0f))
    assert(m * v1 === v2)
  }

  test("Scaling matrix from equal scale") {
    val v1 = Vec2f(1.5f, 2.0f)
    val v2 = Vec2f(3.0f, 4.0f)
    val m = Mat2f.scaling(2.0f)
    assert(m * v1 === v2)
  }

  // TODO: Shearing
}
