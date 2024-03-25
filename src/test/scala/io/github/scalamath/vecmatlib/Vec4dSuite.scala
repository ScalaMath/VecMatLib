package io.github.scalamath.vecmatlib

import org.scalactic.Equality
import org.scalatest.funsuite.AnyFunSuite

class Vec4dSuite extends AnyFunSuite {

  implicit val equality: Equality[Vec4d] = (a: Vec4d, b: Any) => b match {
    case b: Vec4d => a ~= b
    case _ => false
  }

  test("Construct from Vec3d and z") {
    val a = Vec3d(1.1, 2.2, 3.3)
    val b = Vec4d(a, 4.4)
    val exp = Vec4d(1.1, 2.2, 3.3, 4.4)
    assert(b == exp)
  }

  test("Construct from Vec2d, z, and w") {
    val a = Vec2d(1.1, 2.2)
    val b = Vec4d(a, 3.3, 4.4)
    val exp = Vec4d(1.1, 2.2, 3.3, 4.4)
    assert(b == exp)
  }

  test("Access xy components") {
    val a = Vec4d(1.1, 2.2, 3.3, 4.4)
    val b = Vec2d(1.1, 2.2)
    assert(a.xy == b)
  }

  test("Access xyz components") {
    val a = Vec4d(1.1, 2.2, 3.3, 4.4)
    val b = Vec3d(1.1, 2.2, 3.3)
    assert(a.xyz == b)
  }

  test("Sum of a vector and values") {
    val vec = Vec4d(1.0, 2.0, 3.0, 3.0)
    val res = vec + (2.0, 3.0, 1.0, -1.0)
    val exp = Vec4d(3.0, 5.0, 4.0, 2.0)
    assert(res === exp)
  }

  test("Sum of two vectors") {
    val a = Vec4d(1.0, 2.0, 3.0, 3.0)
    val b = Vec4d(2.0, 3.0, 1.0, -1.0)
    val res = Vec4d(3.0, 5.0, 4.0, 2.0)
    assert(a + b === res)
  }

  test("Test unary +") {
    val vec = Vec4d(1.1, 2.2, 3.3, 4.4)
    assert(+vec == vec)
  }

  test("Subtraction of a vector and values") {
    val vec = Vec4d(3.0, 5.0, 4.0, 2.0)
    val res = vec - (2.0, 3.0, 1.0, 4.0)
    val exp = Vec4d(1.0, 2.0, 3.0, -2.0)
    assert(res === exp)
  }

  test("Subtraction of two vectors") {
    val a = Vec4d(3.0, 5.0, 4.0, 2.0)
    val b = Vec4d(2.0, 3.0, 1.0, 4.0)
    val res = Vec4d(1.0, 2.0, 3.0, -2.0)
    assert(a - b === res)
  }

  test("Test unary -") {
    val vec = Vec4d(1.1, -2.2, 0.0, -4.4)
    val res = Vec4d(-1.1, 2.2, 0.0, 4.4)
    assert(-vec == res)
  }

  test("Component-wise multiplication with values") {
    val vec = Vec4d(2.0, 3.0, 4.0, 1.0)
    val res = vec * (3.0, 4.0, 2.0, 1.0)
    val exp = Vec4d(6.0, 12.0, 8.0, 1.0)
    assert(res === exp)
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec4d(2.0, 3.0, 4.0, 1.0)
    val b = Vec4d(3.0, 4.0, 2.0, 1.0)
    val exp = Vec4d(6.0, 12.0, 8.0, 1.0)
    assert(a * b === exp)
  }

  test("Multiplication of a vector by a scalar") {
    val vec = Vec4d(1.0, 2.0, 3.0, 4.0)
    val res = vec * 1.5
    val exp = Vec4d(1.5, 3.0, 4.5, 6.0)
    assert(res === exp)
  }

  test("Multiplication of a scalar by a vector") {
    val vec = Vec4d(1.0, 2.0, 3.0, 4.0)
    val res = 1.5 * vec
    val exp = Vec4d(1.5, 3.0, 4.5, 6.0)
    assert(res === exp)
  }

  test("Component-wise division with values") {
    val vec = Vec4d(6.0, 12.0, 8.0, 1.0)
    val res = vec / (3.0, 4.0, 2.0, 2.0)
    val exp = Vec4d(2.0, 3.0, 4.0, 0.5)
    assert(res === exp)
  }

  test("Component-wise division of two vectors") {
    val a = Vec4d(6.0, 12.0, 8.0, 1.0)
    val b = Vec4d(3.0, 4.0, 2.0, 2.0)
    val exp = Vec4d(2.0, 3.0, 4.0, 0.5)
    assert(a / b === exp)
  }

  test("Division of a vector by a scalar") {
    val vec = Vec4d(1.0, 2.0, 3.0, 4.0)
    val res = vec / 2.0
    val exp = Vec4d(0.5, 1.0, 1.5, 2.0)
    assert(res === exp)
  }

  test("Inverse of a vector") {
    val vec = Vec4d(2.0, 4.0, 8.0, 10.0)
    val inv = Vec4d(0.5, 0.25, 0.125, 0.1)
    assert(vec.inverse == inv)
  }

  test("Division of a scalar by a vector") {
    val vec = Vec4d(2.0, 4.0, 8.0, 10.0)
    val inv = Vec4d(0.5, 0.25, 0.125, 0.1)
    assert(1.0 / vec === inv)
  }

  test("Dot product with three values") {
    val vec = Vec4d(1.0, 2.0, 3.0, 4.0)
    val res = vec.dot(2.0, 3.0, 1.0, 4.0)
    assert(res == 27.0)
  }

  test("Dot product of two vectors") {
    val a = Vec4d(1.0, 2.0, 3.0, 4.0)
    val b = Vec4d(2.0, 3.0, 1.0, 4.0)
    val res = a dot b
    assert(res == 27.0)
  }

  test("Length squared") {
    assert(Vec4d.One.lengthSquared == 4.0)
  }

  test("Length") {
    assert(Vec4d.One.length == math.sqrt(4.0))
  }

  test("Normalized vector") {
    val vec = Vec4d(0.0, 3.0, 0.0, 0.0)
    val res = vec.normalized
    val exp = Vec4d(0.0, 1.0, 0.0, 0.0)
    assert(res === exp)
  }

  test("Check if vector is normalized") {
    assert(!Vec4d.One.isNormalized)
    assert(Vec4d.One.normalized.isNormalized)
  }

  test("Limit length of a vector") {
    val a = Vec4d(6.0, 9.0, 18.0, 0.0)
    val b = a.limitLength(7.0)
    val res = Vec4d(2.0, 3.0, 6.0, 0.0)
    assert(b === res)
  }

  test("Vector absolute value") {
    val vec = Vec4d(-1.5, -2.1, 3.7, 0.0)
    val abs = Vec4d(1.5, 2.1, 3.7, 0.0)
    assert(vec.abs == abs)
  }

  test("Vector sign") {
    val vec = Vec4d(-1.5, 0.0, 3.7, 2.0)
    val sign = Vec4d(-1.0, 0.0, 1.0, 1.0)
    assert(vec.sign == sign)
  }

  test("Vector round") {
    val vec = Vec4d(1.9, 1.1, 2.9, 2.1)
    val res = Vec4d(2.0, 1.0, 3.0, 2.0)
    assert(vec.round == res)
  }

  test("Vector ceil") {
    val vec = Vec4d(1.9, 1.1, 2.9, 2.1)
    val res = Vec4d(2.0, 2.0, 3.0, 3.0)
    assert(vec.ceil == res)
  }

  test("Vector floor") {
    val vec = Vec4d(1.9, 1.1, 2.9, 2.1)
    val res = Vec4d(1.0, 1.0, 2.0, 2.0)
    assert(vec.floor == res)
  }

  test("Move vector toward vector") {
    val vec = Vec4d.One.moveToward(Vec4d.Zero, 0.5)
    assert(vec.length < Vec4d.One.length)
    assert(vec.length > 0.0)
  }

  test("Linear interpolation between vectors") {
    val from = Vec4d(1.0, 2.0, 3.0, 4.0)
    val to = Vec4d(2.0, 4.0, 6.0, 8.0)
    val v1 = Vec4d(1.5, 3.0, 4.5, 6.0)
    val v2 = Vec4d(1.25, 2.5, 3.75, 5.0)
    val v3 = Vec4d(1.75, 3.5, 5.25, 7.0)
    assert(from.lerp(to, 0.5) === v1)
    assert(from.lerp(to, 0.25) === v2)
    assert(from.lerp(to, 0.75) === v3)
  }

  test("Direction to a vector") {
    val from = Vec4d.Zero
    val to = Vec4d(0.0, 0.0, 10.0, 0.0)
    val res = Vec4d(0.0, 0.0, 1.0, 0.0)
    assert(from.directionTo(to) === res)
  }

  test("Direction to values") {
    val from = Vec4d.Zero
    val dir = from.directionTo(0.0, 0.0, 10.0, 0.0)
    val res = Vec4d(0.0, 0.0, 1.0, 0.0)
    assert(dir === res)
  }

  test("Distance squared between two vectors") {
    val a = Vec4d(-1.0, 1.0, -1.0, 2.0)
    val b = Vec4d(1.0, 1.0, 1.0, 0.0)
    assert(a.distanceSquaredTo(b) == 12.0)
  }

  test("Distance squared between a vector and values") {
    val a = Vec4d(-1.0, 1.0, -1.0, 2.0)
    val dist = a.distanceSquaredTo(1.0, 1.0, 1.0, 0.0)
    assert(dist == 12.0)
  }

  test("Distance between two vectors") {
    val a = Vec4d(-1.0, 1.0, -1.0, 2.0)
    val b = Vec4d(1.0, 1.0, 1.0, 0.0)
    assert(a.distanceTo(b) == math.sqrt(12.0))
  }

  test("Distance between a vector and values") {
    val a = Vec4d(-1.0, 1.0, -1.0, 2.0)
    val dist = a.distanceTo(1.0, 1.0, 1.0, 0.0)
    assert(dist == math.sqrt(12.0))
  }

  test("Angle between two vectors") {
    val a = Vec4d(1.0, 0.0, 1.0, 0.0)
    val b = Vec4d(0.0, 2.0, 0.0, 0.0)
    assert(a.angleTo(b) == math.Pi / 2.0)
  }

  test("Angle to values") {
    val vec = Vec4d(1.0, 0.0, 1.0, 0.0)
    val angle = vec.angleTo(0.0, 2.0, 0.0, 0.0)
    assert(angle == math.Pi / 2.0)
  }

  test("Project a vector onto a vector") {
    val v = Vec4d(2.0, 2.0, 1.0, 0.0)
    val n = Vec4d(0.0, 1.0, 0.0, 0.0)
    val res = Vec4d(0.0, 2.0, 0.0, 0.0)
    assert(v.project(n) === res)
  }

  test("Project a vector onto a values") {
    val vec = Vec4d(2.0, 2.0, 1.0, 0.0)
    val proj = vec.project(0.0, 1.0, 0.0, 0.0)
    val res = Vec4d(0.0, 2.0, 0.0, 0.0)
    assert(proj === res)
  }

  test("Reflect a vector by a vector") {
    val v = Vec4d(1.0, 2.0, 3.0, 0.0)
    val n = Vec4d(0.0, 1.0, 0.0, 0.0)
    val res = Vec4d(1.0, -2.0, 3.0, 0.0)
    assert(v.reflect(n) === res)
  }

  test("Reflect a vector by a values") {
    val vec = Vec4d(1.0, 2.0, 3.0, 0.0)
    val ref = vec.reflect(0.0, 1.0, 0.0, 0.0)
    val res = Vec4d(1.0, -2.0, 3.0, 0.0)
    assert(ref === res)
  }

  test("Bounce a vector by a vector") {
    val v = Vec4d(1.0, 2.0, 3.0, 0.0)
    val n = Vec4d(0.0, 1.0, 0.0, 0.0)
    val res = Vec4d(-1.0, 2.0, -3.0, 0.0)
    assert(v.bounce(n) === res)
  }

  test("Bounce a vector by a values") {
    val vec = Vec4d(1.0, 2.0, 3.0, 0.0)
    val bounce = vec.bounce(0.0, 1.0, 0.0, 0.0)
    val res = Vec4d(-1.0, 2.0, -3.0, 0.0)
    assert(bounce === res)
  }

  test("Slide a vector on another vector") {
    val a = Vec4d(1.0, 1.0, 0.0, 0.0)
    val b = Vec4d(0.0, 1.0, 0.0, 0.0)
    val res = Vec4d(1.0, 0.0, 0.0, 0.0)
    assert(a.slide(b) === res)
  }

  test("Slide a vector on values") {
    val vec = Vec4d(1.0, 1.0, 0.0, 0.0)
    val slide = vec.slide(0.0, 1.0, 0.0, 0.0)
    val res = Vec4d(1.0, 0.0, 0.0, 0.0)
    assert(slide === res)
  }

  test("Component-wise mod between vector and values") {
    val vec = Vec4d(1.0, 3.0, 8.0, 8.0)
    val mod = vec % (2.0, 2.0, 3.0, 4.0)
    val res = Vec4d(1.0, 1.0, 2.0, 0.0)
    assert(mod === res)
  }

  test("Component-wise mod between two vectors") {
    val a = Vec4d(1.0, 3.0, 8.0, 8.0)
    val b = Vec4d(2.0, 2.0, 3.0, 4.0)
    val res = Vec4d(1.0, 1.0, 2.0, 0.0)
    assert(a % b === res)
  }

  test("Vector mod with single value") {
    val vec = Vec4d(1.0, 3.0, 8.0, 9.0)
    val mod = vec % 3.0
    val res = Vec4d(1.0, 0.0, 2.0, 0.0)
    assert(mod === res)
  }

  test("Outer product with four values") {
    val vec = Vec4d(1.0, 2.0, 3.0, 4.0)
    val outer = vec.outer(2.0, 3.0, 4.0, 5.0)
    val res = Mat4d(2.0, 3.0, 4.0, 5.0, 4.0, 6.0, 8.0, 10.0, 6.0, 9.0, 12.0, 15.0, 8.0, 12.0, 16.0, 20.0)
    assert(outer == res)
  }

  test("Outer product with a 4D vector") {
    val a = Vec4d(1.0, 2.0, 3.0, 4.0)
    val b = Vec4d(2.0, 3.0, 4.0, 5.0)
    val res = Mat4d(2.0, 3.0, 4.0, 5.0, 4.0, 6.0, 8.0, 10.0, 6.0, 9.0, 12.0, 15.0, 8.0, 12.0, 16.0, 20.0)
    assert(a.outer(b) == res)
  }

  test("Vector equals four values") {
    val vec = Vec4d(1.1, 2.2, 3.3, 4.4)
    assert(vec == (1.1, 2.2, 3.3, 4.4))
  }

  test("Vector equals approximately three value") {
    val vec = Vec4d(1.0, 2.0, 3.0, 4.0)
    assert(vec ~= (0.99999999, 1.99999999, 3.00000001, 3.99999999))
  }

  test("Vector equals approximately a vector") {
    val a = Vec4d(1.0, 2.0, 3.0, 4.0)
    val b = Vec4d(0.99999999, 1.99999999, 3.00000001, 3.99999999)
    assert(a ~= b)
  }

  test("Access components with apply") {
    val vec = Vec4d(1.1, 2.2, 3.3, 4.4)
    assert(vec(0) == 1.1)
    assert(vec(1) == 2.2)
    assert(vec(2) == 3.3)
    assert(vec(3) == 4.4)
    assertThrows[MatchError] {vec(4)}
  }
}
