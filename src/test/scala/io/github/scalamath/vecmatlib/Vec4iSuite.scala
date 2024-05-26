package io.github.scalamath.vecmatlib

import org.scalatest.funsuite.AnyFunSuite

class Vec4iSuite extends AnyFunSuite {

  test("Construct from Vec3i and z") {
    val a = Vec3i(1, 2, 3)
    val b = Vec4i(a, 4)
    val exp = Vec4i(1, 2, 3, 4)
    assert(b == exp)
  }

  test("Construct from Vec2i, z, and w") {
    val a = Vec2i(1, 2)
    val b = Vec4i(a, 3, 4)
    val exp = Vec4i(1, 2, 3, 4)
    assert(b == exp)
  }

  test("Access xy components") {
    val a = Vec4i(1, 2, 3, 4)
    val b = Vec2i(1, 2)
    assert(a.xy == b)
  }

  test("Access xyz components") {
    val a = Vec4i(1, 2, 3, 4)
    val b = Vec3i(1, 2, 3)
    assert(a.xyz == b)
  }

  test("Sum of a vector and values") {
    val vec = Vec4i(1, 2, 3, 3)
    val res = vec + (2, 3, 1, -1)
    val exp = Vec4i(3, 5, 4, 2)
    assert(res == exp)
  }

  test("Sum of two vectors") {
    val a = Vec4i(1, 2, 3, 3)
    val b = Vec4i(2, 3, 1, -1)
    val res = Vec4i(3, 5, 4, 2)
    assert(a + b == res)
  }

  test("Test unary +") {
    val vec = Vec4i(1, 2, 3, 4)
    assert(+vec == vec)
  }

  test("Subtraction of a vector and values") {
    val vec = Vec4i(3, 5, 4, 2)
    val res = vec - (2, 3, 1, 4)
    val exp = Vec4i(1, 2, 3, -2)
    assert(res == exp)
  }

  test("Subtraction of two vectors") {
    val a = Vec4i(3, 5, 4, 2)
    val b = Vec4i(2, 3, 1, 4)
    val res = Vec4i(1, 2, 3, -2)
    assert(a - b == res)
  }

  test("Test unary -") {
    val vec = Vec4i(1, -2, 0, -4)
    val res = Vec4i(-1, 2, 0, 4)
    assert(-vec == res)
  }

  test("Component-wise multiplication with values") {
    val vec = Vec4i(2, 3, 4, 1)
    val res = vec * (3, 4, 2, 1)
    val exp = Vec4i(6, 12, 8, 1)
    assert(res == exp)
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec4i(2, 3, 4, 1)
    val b = Vec4i(3, 4, 2, 1)
    val exp = Vec4i(6, 12, 8, 1)
    assert(a * b == exp)
  }

  test("Multiplication of a vector by a scalar") {
    val vec = Vec4i(1, 2, 3, 4)
    val res = vec * 2
    val exp = Vec4i(2, 4, 6, 8)
    assert(res == exp)
  }

  test("Multiplication of a scalar by a vector") {
    val vec = Vec4i(1, 2, 3, 4)
    val res = 2 * vec
    val exp = Vec4i(2, 4, 6, 8)
    assert(res == exp)
  }

  test("Component-wise division with values") {
    val vec = Vec4i(6, 12, 8, 1)
    val res = vec / (3, 4, 2, 2)
    val exp = Vec4i(2, 3, 4, 0)
    assert(res == exp)
  }

  test("Component-wise division of two vectors") {
    val a = Vec4i(6, 12, 8, 1)
    val b = Vec4i(3, 4, 2, 2)
    val exp = Vec4i(2, 3, 4, 0)
    assert(a / b == exp)
  }

  test("Division of a vector by a scalar") {
    val vec = Vec4i(1, 2, 3, 4)
    val res = vec / 2
    val exp = Vec4i(0, 1, 1, 2)
    assert(res == exp)
  }

  test("Dot product with three values") {
    val vec = Vec4i(1, 2, 3, 4)
    val res = vec.dot(2, 3, 1, 4)
    assert(res == 27)
  }

  test("Dot product of two vectors") {
    val a = Vec4i(1, 2, 3, 4)
    val b = Vec4i(2, 3, 1, 4)
    val res = a dot b
    assert(res == 27)
  }

  ignore("Dot product with a 3D vector and a fourth value") {
    // TODO
  }

  ignore("Dot product with a 2D vector and a third and a fourth value") {
    // TODO
  }

  test("Length squared") {
    assert(Vec4i.One.lengthSquared == 4)
  }

  test("Length") {
    assert(Vec4i.One.length == math.sqrt(4.0).toFloat)
  }

  test("Vector absolute value") {
    val vec = Vec4i(-1, -2, 3, 0)
    val abs = Vec4i(1, 2, 3, 0)
    assert(vec.abs == abs)
  }

  test("Vector sign") {
    val vec = Vec4i(-1, 0, 3, 2)
    val sign = Vec4i(-1, 0, 1, 1)
    assert(vec.sign == sign)
  }

  test("Distance squared between two vectors") {
    val a = Vec4i(-1, 1, -1, 2)
    val b = Vec4i(1, 1, 1, 0)
    assert(a.distanceSquaredTo(b) == 12)
  }

  test("Distance squared between a vector and values") {
    val a = Vec4i(-1, 1, -1, 2)
    val dist = a.distanceSquaredTo(1, 1, 1, 0)
    assert(dist == 12)
  }

  test("Distance between two vectors") {
    val a = Vec4i(-1, 1, -1, 2)
    val b = Vec4i(1, 1, 1, 0)
    assert(a.distanceTo(b) == math.sqrt(12.0).toFloat)
  }

  test("Distance between a vector and values") {
    val a = Vec4i(-1, 1, -1, 2)
    val dist = a.distanceTo(1, 1, 1, 0)
    assert(dist == math.sqrt(12.0).toFloat)
  }

  test("Angle between two vectors") {
    val a = Vec4i(1, 0, 1, 0)
    val b = Vec4i(0, 2, 0, 0)
    assert(a.angleTo(b) == math.Pi / 2.0)
  }

  test("Angle to values") {
    val vec = Vec4i(1, 0, 1, 0)
    val angle = vec.angleTo(0, 2, 0, 0)
    assert(angle == math.Pi / 2.0)
  }

  test("Reflect a vector by a vector") {
    val v = Vec4i(1, 2, 3, 0)
    val n = Vec4i(0, 1, 0, 0)
    val res = Vec4i(1, -2, 3, 0)
    assert(v.reflect(n) == res)
  }

  test("Reflect a vector by a values") {
    val vec = Vec4i(1, 2, 3, 0)
    val ref = vec.reflect(0, 1, 0, 0)
    val res = Vec4i(1, -2, 3, 0)
    assert(ref == res)
  }

  test("Bounce a vector by a vector") {
    val v = Vec4i(1, 2, 3, 0)
    val n = Vec4i(0, 1, 0, 0)
    val res = Vec4i(-1, 2, -3, 0)
    assert(v.bounce(n) == res)
  }

  test("Bounce a vector by a values") {
    val vec = Vec4i(1, 2, 3, 0)
    val bounce = vec.bounce(0, 1, 0, 0)
    val res = Vec4i(-1, 2, -3, 0)
    assert(bounce == res)
  }

  test("Slide a vector on another vector") {
    val a = Vec4i(1, 1, 0, 0)
    val b = Vec4i(0, 1, 0, 0)
    val res = Vec4i(1, 0, 0, 0)
    assert(a.slide(b) == res)
  }

  test("Slide a vector on values") {
    val vec = Vec4i(1, 1, 0, 0)
    val slide = vec.slide(0, 1, 0, 0)
    val res = Vec4i(1, 0, 0, 0)
    assert(slide == res)
  }

  test("Component-wise mod between vector and values") {
    val vec = Vec4i(1, 3, 8, 8)
    val mod = vec % (2, 2, 3, 4)
    val res = Vec4i(1, 1, 2, 0)
    assert(mod == res)
  }

  test("Component-wise mod between two vectors") {
    val a = Vec4i(1, 3, 8, 8)
    val b = Vec4i(2, 2, 3, 4)
    val res = Vec4i(1, 1, 2, 0)
    assert(a % b == res)
  }

  test("Vector mod with single value") {
    val vec = Vec4i(1, 3, 8, 9)
    val mod = vec % 3
    val res = Vec4i(1, 0, 2, 0)
    assert(mod == res)
  }

  test("Outer product with four values") {
    val vec = Vec4i(1, 2, 3, 4)
    val outer = vec.outer(2, 3, 4, 5)
    val res = Mat4i(2, 3, 4, 5, 4, 6, 8, 10, 6, 9, 12, 15, 8, 12, 16, 20)
    assert(outer == res)
  }

  test("Outer product with a 4D vector") {
    val a = Vec4i(1, 2, 3, 4)
    val b = Vec4i(2, 3, 4, 5)
    val res = Mat4i(2, 3, 4, 5, 4, 6, 8, 10, 6, 9, 12, 15, 8, 12, 16, 20)
    assert(a.outer(b) == res)
  }

  test("Vector equals four values") {
    val vec = Vec4i(1, 2, 3, 4)
    assert(vec == (1, 2, 3, 4))
  }

  test("Access components with apply") {
    val vec = Vec4i(1, 2, 3, 4)
    assert(vec(0) == 1)
    assert(vec(1) == 2)
    assert(vec(2) == 3)
    assert(vec(3) == 4)
    assertThrows[MatchError] {vec(4)}
  }
}
