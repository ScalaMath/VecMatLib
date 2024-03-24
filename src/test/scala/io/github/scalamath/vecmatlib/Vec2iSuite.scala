package io.github.scalamath.vecmatlib

import io.github.scalamath
import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class Vec2iSuite extends AnyFunSuite {

  test("Sum of a vector and values") {
    val vec = Vec2i(1, 2)
    val res = vec + (2, 3)
    val exp = Vec2i(3, 5)
    assert(res == exp)
  }

  test("Sum of two vectors") {
    val a = Vec2i(1, 2)
    val b = Vec2i(2, 3)
    val res = Vec2i(3, 5)
    assert(a + b == res)
  }

  test("Test unary +") {
    val vec = Vec2i(1, 2)
    assert(+vec == vec)
  }

  test("Subtraction of a vector and values") {
    val vec = Vec2i(3, 5)
    val res = vec - (2, 3)
    val exp = Vec2i(1, 2)
    assert(res == exp)
  }

  test("Subtraction of two vectors") {
    val a = Vec2i(3, 5)
    val b = Vec2i(2, 3)
    val res = Vec2i(1, 2)
    assert(a - b == res)
  }

  test("Test unary -") {
    val vec = Vec2i(1, -2)
    val res = Vec2i(-1, 2)
    assert(-vec == res)
  }

  test("Component-wise multiplication with values") {
    val vec = Vec2i(2, 3)
    val res = vec * (3, 4)
    val exp = Vec2i(6, 12)
    assert(res == exp)
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec2i(2, 3)
    val b = Vec2i(3, 4)
    val exp = Vec2i(6, 12)
    assert(a * b == exp)
  }

  test("Multiplication of a vector by a scalar") {
    val vec = Vec2i(1, 2)
    val res = vec * 2
    val exp = Vec2i(2, 4)
    assert(res == exp)
  }

  test("Multiplication of a scalar by a vector") {
    val vec = Vec2i(1, 2)
    val res = 2 * vec
    val exp = Vec2i(2, 4)
    assert(res == exp)
  }

  test("Component-wise division with values") {
    val vec = Vec2i(6, 12)
    val res = vec / (3, 4)
    val exp = Vec2i(2, 3)
    assert(res == exp)
  }

  test("Component-wise division of two vectors") {
    val a = Vec2i(6, 12)
    val b = Vec2i(3, 4)
    val exp = Vec2i(2, 3)
    assert(a / b == exp)
  }

  test("Division of a vector by a scalar") {
    val vec = Vec2i(1, 2)
    val res = vec / 2
    val exp = Vec2i(0, 1)
    assert(res == exp)
  }

  test("Dot product with two values") {
    val vec = Vec2i(1, 2)
    val res = vec.dot(2, 3)
    assert(res == 8)
  }

  test("Dot product of two vectors") {
    val a = Vec2i(1, 2)
    val b = Vec2i(2, 3)
    val res = a dot b
    assert(res == 8)
  }

  test("Length squared") {
    assert(Vec2i.One.lengthSquared == 2)
  }

  test("Length") {
    assert(Vec2i.One.length == math.sqrt(2).toFloat)
  }

  test("Vector absolute value") {
    val vec = Vec2i(-1, 3)
    val abs = Vec2i(1, 3)
    assert(vec.abs == abs)
  }

  test("Vector sign") {
    val vec = Vec2i(-1, 3)
    val sign = Vec2i(-1, 1)
    assert(vec.sign == sign)
  }

  test("Distance squared between two vectors") {
    val a = Vec2i(-1, 1)
    val b = Vec2i(1, 1)
    assert(a.distanceSquaredTo(b) == 4)
  }

  test("Distance squared between a vector and values") {
    val a = Vec2i(-1, 1)
    val dist = a.distanceSquaredTo(1, 1)
    assert(dist == 4)
  }

  test("Distance between two vectors") {
    val a = Vec2i(-1, 1)
    val b = Vec2i(1, 1)
    assert(a.distanceTo(b) == 2.0f)
  }

  test("Distance between a vector and values") {
    val a = Vec2i(-1, 1)
    val dist = a.distanceTo(1, 1)
    assert(dist == 2.0f)
  }

  test("Angle between two vectors") {
    val a = Vec2i(3, 3)
    val b = Vec2i(0, 2)
    assert(a.angleTo(b) === math.Pi / 4 +- scalamath.Epsilon)
  }

  test("Angle to values") {
    val vec = Vec2i(3, 3)
    val angle = vec.angleTo(0, 2)
    assert(angle === math.Pi / 4 +- scalamath.Epsilon)
  }

  test("Angle between a vector and the x axis") {
    val vec = Vec2i(2, 2)
    assert(vec.angle === math.Pi / 4 +- scalamath.Epsilon)
  }

  test("Angle to a point with a vector") {
    val a = Vec2i(1, 2)
    val b = Vec2i(2, 3)
    assert(a.angleToPoint(b) === math.Pi / 4 +- scalamath.Epsilon)
  }

  test("Angle to a point with a values") {
    val vec = Vec2i(1, 2)
    val angle = vec.angleToPoint(2, 3)
    assert(angle === math.Pi / 4 +- scalamath.Epsilon)
  }

  test("Reflect a vector by a vector") {
    val vec = Vec2i(1, -1)
    val ref = vec.reflect(Vec2i.Up)
    val res = Vec2i(1, 1)
    assert(ref == res)
  }

  test("Reflect a vector by a values") {
    val vec = Vec2i(1, -1)
    val ref = vec.reflect(0, 1)
    val res = Vec2i(1, 1)
    assert(ref == res)
  }

  test("Bounce a vector by a vector") {
    val vec = Vec2i(1, -1)
    val bounce = vec.bounce(Vec2i.Up)
    val res = Vec2i(-1, -1)
    assert(bounce == res)
  }

  test("Bounce a vector by a values") {
    val vec = Vec2i(1, -1)
    val bounce = vec.bounce(0, 1)
    val res = Vec2i(-1, -1)
    assert(bounce == res)
  }

  test("Slide a vector on another vector") {
    val a = Vec2i(1, 1)
    val b = Vec2i(0, 1)
    val res = Vec2i(1, 0)
    assert(a.slide(b) == res)
  }

  test("Slide a vector on values") {
    val vec = Vec2i(1, 1)
    val slide = vec.slide(0, 1)
    val res = Vec2i(1, 0)
    assert(slide == res)
  }

  test("Component-wise mod between vector and values") {
    val vec = Vec2i(1, 8)
    val mod = vec % (2, 3)
    val res = Vec2i(1, 2)
    assert(mod == res)
  }

  test("Component-wise mod between two vectors") {
    val a = Vec2i(1, 8)
    val b = Vec2i(2, 3)
    val res = Vec2i(1, 2)
    assert(a % b == res)
  }

  test("Vector mod with single value") {
    val vec = Vec2i(1, 8)
    val mod = vec % 3
    val res = Vec2i(1, 2)
    assert(mod == res)
  }

  test("Vector aspect ratio") {
    val vec = Vec2i(16, 9)
    assert(vec.aspect == 16.0f / 9.0f)
  }

  test("Orthogonal vector") {
    val a = Vec2i(2, 3)
    val b = Vec2i(3, -2)
    assert(a.orthogonal == b)
    assert(a.angleTo(b) === math.Pi / 2 +- scalamath.Epsilon)
  }

  test("Cross product with three values") {
    val vec = Vec2i.Right
    val cross = vec.cross(0, 1, 0)
    val res = Vec3i.Forward
    assert(cross == res)
  }

  test("Cross product with a 3D vector") {
    val vec = Vec2i.Right
    val cross = vec.cross(Vec3i.Up)
    val res = Vec3i.Forward
    assert(cross == res)
  }

  test("Cross product with a 2D vector") {
    val vec = Vec2i.Right
    val cross = vec.cross(Vec2i.Up)
    val res = Vec3i.Forward
    assert(cross == res)
  }

  test("Outer product with two values") {
    val vec = Vec2i(1, 2)
    val outer = vec.outer(2, 3)
    val res = Mat2i(2, 3, 4, 6)
    assert(outer == res)
  }

  test("Outer product with a 2D vector") {
    val a = Vec2i(1, 2)
    val b = Vec2i(2, 3)
    val res = Mat2i(2, 3, 4, 6)
    assert(a.outer(b) == res)
  }

  test("Outer product with three values") {
    val vec = Vec2i(1, 2)
    val outer = vec.outer(2, 3, 4)
    val res = Mat2x3i(2, 3, 4, 4, 6, 8)
    assert(outer == res)
  }

  test("Outer product with a 3D vector") {
    val a = Vec2i(1, 2)
    val b = Vec3i(2, 3, 4)
    val res = Mat2x3i(2, 3, 4, 4, 6, 8)
    assert(a.outer(b) == res)
  }

  test("Vector equals two values") {
    val vec = Vec2i(1, 2)
    assert(vec == (1, 2))
  }

  test("Access components with apply") {
    val vec = Vec2i(1, 2)
    assert(vec(0) == 1)
    assert(vec(1) == 2)
    assertThrows[scala.MatchError] {vec(2)}
  }
}
