package io.github.scalamath.vecmatlib

import io.github.scalamath
import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class Vec3iSuite extends AnyFunSuite {

  test("Construct from Vec2i and z") {
    val a = Vec2i(1, 2)
    val b = Vec3i(a, 3)
    val exp = Vec3i(1, 2, 3)
    assert(b == exp)
  }

  test("Access xy components") {
    val a = Vec3i(1, 2, 3)
    val b = Vec2i(1, 2)
    assert(a.xy == b)
  }

  test("Sum of a vector and values") {
    val vec = Vec3i(1, 2, 3)
    val res = vec + (2, 3, 1)
    val exp = Vec3i(3, 5, 4)
    assert(res == exp)
  }

  test("Sum of two vectors") {
    val a = Vec3i(1, 2, 3)
    val b = Vec3i(2, 3, 1)
    val res =Vec3i(3, 5, 4)
    assert(a + b == res)
  }

  test("Test unary +") {
    val vec = Vec3i(1, 2, 3)
    assert(+vec == vec)
  }

  test("Subtraction of a vector and values") {
    val vec = Vec3i(3, 5, 4)
    val res = vec - (2, 3, 1)
    val exp = Vec3i(1, 2, 3)
    assert(res == exp)
  }

  test("Subtraction of two vectors") {
    val a = Vec3i(3, 5, 4)
    val b = Vec3i(2, 3, 1)
    val res = Vec3i(1, 2, 3)
    assert(a - b == res)
  }

  test("Test unary -") {
    val vec = Vec3i(1, -2, 3)
    val res = Vec3i(-1, 2, -3)
    assert(-vec == res)
  }

  test("Component-wise multiplication with values") {
    val vec = Vec3i(2, 3, 4)
    val res = vec * (3, 4, 2)
    val exp = Vec3i(6, 12, 8)
    assert(res == exp)
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec3i(2, 3, 4)
    val b = Vec3i(3, 4, 2)
    val exp = Vec3i(6, 12, 8)
    assert(a * b == exp)
  }

  test("Multiplication of a vector by a scalar") {
    val vec = Vec3i(1, 2, 3)
    val res = vec * 2
    val exp = Vec3i(2, 4, 6)
    assert(res == exp)
  }

  test("Multiplication of a scalar by a vector") {
    val vec = Vec3i(1, 2, 3)
    val res = 2 * vec
    val exp = Vec3i(2, 4, 6)
    assert(res == exp)
  }

  test("Component-wise division with values") {
    val vec = Vec3i(6, 12, 8)
    val res = vec / (3, 4, 2)
    val exp = Vec3i(2, 3, 4)
    assert(res == exp)
  }

  test("Component-wise division of two vectors") {
    val a = Vec3i(6, 12, 8)
    val b = Vec3i(3, 4, 2)
    val exp = Vec3i(2, 3, 4)
    assert(a / b == exp)
  }

  test("Division of a vector by a scalar") {
    val vec = Vec3i(1, 2, 3)
    val res = vec / 2
    val exp = Vec3i(0, 1, 1)
    assert(res == exp)
  }

  test("Dot product with three values") {
    val vec = Vec3i(1, 2, 3)
    val res = vec.dot(2, 3, 1)
    assert(res == 11)
  }

  test("Dot product of two vectors") {
    val a = Vec3i(1, 2, 3)
    val b = Vec3i(2, 3, 1)
    val res = a dot b
    assert(res == 11)
  }

  ignore("Dot product with a 2D vector and a third value") {
    // TODO
  }

  test("Cross product with three values") {
    val vec = Vec3i.Right
    val res = vec.cross(0, 1, 0)
    assert(res == Vec3i.Forward)
  }

  test("Cross product of two vectors") {
    val a = Vec3i.Right
    val b = Vec3i.Up
    val res = a cross b
    assert(res == Vec3i.Forward)
  }

  test("Cross product with a 2D vector") {
    val a = Vec3i.Right
    val b = Vec2i.Up
    val res = a cross b
    assert(res == Vec3i.Forward)
  }

  test("Length squared") {
    assert(Vec3i.One.lengthSquared == 3)
  }

  test("Length") {
    assert(Vec3i.One.length == math.sqrt(3).toFloat)
  }

  test("Vector absolute value") {
    val vec = Vec3i(-1, -2, 3)
    val abs = Vec3i(1, 2, 3)
    assert(vec.abs == abs)
  }

  test("Vector sign") {
    val vec = Vec3i(-1, 0, 3)
    val sign = Vec3i(-1, 0, 1)
    assert(vec.sign == sign)
  }

  test("Distance squared between two vectors") {
    val a = Vec3i(-1, 1, -1)
    val b = Vec3i(1, 1, 1)
    assert(a.distanceSquaredTo(b) == 8)
  }

  test("Distance squared between a vector and values") {
    val a = Vec3i(-1, 1, -1)
    val dist = a.distanceSquaredTo(1, 1, 1)
    assert(dist == 8)
  }

  test("Distance between two vectors") {
    val a = Vec3i(-1, 1, -1)
    val b = Vec3i(1, 1, 1)
    assert(a.distanceTo(b) == math.sqrt(8).toFloat)
  }

  test("Distance between a vector and values") {
    val a = Vec3i(-1, 1, -1)
    val dist = a.distanceTo(1, 1, 1)
    assert(dist == math.sqrt(8).toFloat)
  }

  test("Angle between two vectors") {
    val a = Vec3i(1, 0, 1)
    val b = Vec3i(0, 2, 0)
    assert(a.angleTo(b) == math.Pi / 2)
  }

  test("Angle to values") {
    val vec = Vec3i(1, 0, 1)
    val angle = vec.angleTo(0, 2, 0)
    assert(angle == math.Pi / 2)
  }

  test("Signed angle to vector") {
    val a = Vec3i(1, 1, 0)
    val b = Vec3i(0, 1, 1)
    assert(a.signedAngleTo(b, Vec3i.Up) === -math.Pi / 3 +- scalamath.Epsilon)
    assert(a.signedAngleTo(b, Vec3i.Down) === math.Pi / 3 +- scalamath.Epsilon)
  }

  test("Reflect a vector by a vector") {
    val vec = Vec3i(1, 2, 3)
    val ref = vec.reflect(Vec3i.Up)
    val res = Vec3i(1, -2, 3)
    assert(ref == res)
  }

  test("Reflect a vector by a values") {
    val vec = Vec3i(1, 2, 3)
    val ref = vec.reflect(0, 1, 0)
    val res = Vec3i(1, -2, 3)
    assert(ref == res)
  }

  test("Bounce a vector by a vector") {
    val vec = Vec3i(1, 2, 3)
    val bounce = vec.bounce(Vec3i.Up)
    val res = Vec3i(-1, 2, -3)
    assert(bounce == res)
  }

  test("Bounce a vector by a values") {
    val vec = Vec3i(1, 2, 3)
    val bounce = vec.bounce(0, 1, 0)
    val res = Vec3i(-1, 2, -3)
    assert(bounce == res)
  }

  test("Slide a vector on another vector") {
    val a = Vec3i(1, 1, 0)
    val b = Vec3i(0, 1, 0)
    val res = Vec3i(1, 0, 0)
    assert(a.slide(b) == res)
  }

  test("Slide a vector on values") {
    val vec = Vec3i(1, 1, 0)
    val slide = vec.slide(0, 1, 0)
    val res = Vec3i(1, 0, 0)
    assert(slide == res)
  }

  test("Component-wise mod between vector and values") {
    val vec = Vec3i(1, 3, 8)
    val mod = vec % (2, 2, 3)
    val res = Vec3i(1, 1, 2)
    assert(mod == res)
  }

  test("Component-wise mod between two vectors") {
    val a = Vec3i(1, 3, 8)
    val b = Vec3i(2, 2, 3)
    val res = Vec3i(1, 1, 2)
    assert(a % b == res)
  }

  test("Vector mod with single value") {
    val vec = Vec3i(1, 3, 8)
    val mod = vec % 3
    val res = Vec3i(1, 0, 2)
    assert(mod == res)
  }

  test("Outer product with three values") {
    val vec = Vec3i(1, 2, 3)
    val outer = vec.outer(2, 3, 4)
    val res = Mat3i(2, 3, 4, 4, 6, 8, 6, 9, 12)
    assert(outer == res)
  }

  test("Outer product with a 3D vector") {
    val a = Vec3i(1, 2, 3)
    val b = Vec3i(2, 3, 4)
    val res = Mat3i(2, 3, 4, 4, 6, 8, 6, 9, 12)
    assert(a.outer(b) == res)
  }

  test("Outer product with four values") {
    val vec = Vec3i(1, 2, 3)
    val outer = vec.outer(2, 3, 4, 5)
    val res = Mat3x4i(2, 3, 4, 5, 4, 6, 8, 10, 6, 9, 12, 15)
    assert(outer == res)
  }

  test("Outer product with a 4D vector") {
    val a = Vec3i(1, 2, 3)
    val b = Vec4i(2, 3, 4, 5)
    val res = Mat3x4i(2, 3, 4, 5, 4, 6, 8, 10, 6, 9, 12, 15)
    assert(a.outer(b) == res)
  }

  test("Vector equals three values") {
    val vec = Vec3i(1, 2, 3)
    assert(vec == (1, 2, 3))
  }

  test("Access components with apply") {
    val vec = Vec3i(1, 2, 3)
    assert(vec(0) == 1)
    assert(vec(1) == 2)
    assert(vec(2) == 3)
    assertThrows[MatchError] {vec(3)}
  }
}
