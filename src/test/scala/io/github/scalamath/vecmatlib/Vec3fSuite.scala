package io.github.scalamath.vecmatlib

import io.github.scalamath
import org.scalactic.Equality
import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class Vec3fSuite extends AnyFunSuite {

  implicit val equality: Equality[Vec3f] = (a: Vec3f, b: Any) => b match {
    case b: Vec3f => a ~= b
    case _ => false
  }

  test("Construct from Vec2f and z") {
    val a = Vec2f(1.1f, 2.2f)
    val b = Vec3f(a, 3.3f)
    val exp = Vec3f(1.1f, 2.2f, 3.3f)
    assert(b == exp)
  }

  test("Access xy components") {
    val a = Vec3f(1.1f, 2.2f, 3.3f)
    val b = Vec2f(1.1f, 2.2f)
    assert(a.xy == b)
  }

  test("Sum of a vector and values") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val res = vec + (2.0f, 3.0f, 1.0f)
    val exp = Vec3f(3.0f, 5.0f, 4.0f)
    assert(res === exp)
  }

  test("Sum of two vectors") {
    val a = Vec3f(1.0f, 2.0f, 3.0f)
    val b = Vec3f(2.0f, 3.0f, 1.0f)
    val res = Vec3f(3.0f, 5.0f, 4.0f)
    assert(a + b === res)
  }

  test("Test unary +") {
    val vec = Vec3f(1.1f, 2.2f, 3.3f)
    assert(+vec == vec)
  }

  test("Subtraction of a vector and values") {
    val vec = Vec3f(3.0f, 5.0f, 4.0f)
    val res = vec - (2.0f, 3.0f, 1.0f)
    val exp = Vec3f(1.0f, 2.0f, 3.0f)
    assert(res === exp)
  }

  test("Subtraction of two vectors") {
    val a = Vec3f(3.0f, 5.0f, 4.0f)
    val b = Vec3f(2.0f, 3.0f, 1.0f)
    val res = Vec3f(1.0f, 2.0f, 3.0f)
    assert(a - b === res)
  }

  test("Test unary -") {
    val vec = Vec3f(1.1f, -2.2f, 3.3f)
    val res = Vec3f(-1.1f, 2.2f, -3.3f)
    assert(-vec == res)
  }

  test("Component-wise multiplication with values") {
    val vec = Vec3f(2.0f, 3.0f, 4.0f)
    val res = vec * (3.0f, 4.0f, 2.0f)
    val exp = Vec3f(6.0f, 12.0f, 8.0f)
    assert(res === exp)
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec3f(2.0f, 3.0f, 4.0f)
    val b = Vec3f(3.0f, 4.0f, 2.0f)
    val exp = Vec3f(6.0f, 12.0f, 8.0f)
    assert(a * b === exp)
  }

  test("Multiplication of a vector by a scalar") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val res = vec * 1.5f
    val exp = Vec3f(1.5f, 3.0f, 4.5f)
    assert(res === exp)
  }

  test("Multiplication of a scalar by a vector") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val res = 1.5f * vec
    val exp = Vec3f(1.5f, 3.0f, 4.5f)
    assert(res === exp)
  }

  test("Component-wise division with values") {
    val vec = Vec3f(6.0f, 12.0f, 8.0f)
    val res = vec / (3.0f, 4.0f, 2.0f)
    val exp = Vec3f(2.0f, 3.0f, 4.0f)
    assert(res === exp)
  }

  test("Component-wise division of two vectors") {
    val a = Vec3f(6.0f, 12.0f, 8.0f)
    val b = Vec3f(3.0f, 4.0f, 2.0f)
    val exp = Vec3f(2.0f, 3.0f, 4.0f)
    assert(a / b === exp)
  }

  test("Division of a vector by a scalar") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val res = vec / 2.0f
    val exp = Vec3f(0.5f, 1.0f, 1.5f)
    assert(res === exp)
  }

  test("Inverse of a vector") {
    val vec = Vec3f(2.0f, 4.0f, 8.0f)
    val inv = Vec3f(0.5f, 0.25f, 0.125f)
    assert(vec.inverse === inv)
  }

  test("Division of a scalar by a vector") {
    val vec = Vec3f(2.0f, 4.0f, 8.0f)
    val inv = Vec3f(0.5f, 0.25f, 0.125f)
    assert(1.0f / vec === inv)
  }

  test("Dot product with three values") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val res = vec.dot(2.0f, 3.0f, 1.0f)
    assert(res == 11.0f)
  }

  test("Dot product of two vectors") {
    val a = Vec3f(1.0f, 2.0f, 3.0f)
    val b = Vec3f(2.0f, 3.0f, 1.0f)
    val res = a dot b
    assert(res == 11.0f)
  }

  test("Cross product with three values") {
    val vec = Vec3f.Right
    val res = vec.cross(0.0f, 1.0f, 0.0f)
    assert(res === Vec3f.Forward)
  }

  test("Cross product of two vectors") {
    val a = Vec3f.Right
    val b = Vec3f.Up
    val res = a cross b
    assert(res === Vec3f.Forward)
  }

  test("Cross product with a 2D vector") {
    val a = Vec3f.Right
    val b = Vec2f.Up
    val res = a cross b
    assert(res === Vec3f.Forward)
  }

  test("Length squared") {
    assert(Vec3f.One.lengthSquared == 3.0f)
  }

  test("Length") {
    assert(Vec3f.One.length == math.sqrt(3).toFloat)
  }

  test("Normalized vector") {
    val vec = Vec3f(0.0f, 3.0f, 0.0f)
    val res = vec.normalized
    val exp = Vec3f(0.0f, 1.0f, 0.0f)
    assert(res === exp)
  }

  test("Check if vector is normalized") {
    assert(!Vec3f.One.isNormalized)
    assert(Vec3f.Forward.isNormalized)
    assert(Vec3f.One.normalized.isNormalized)
  }

  test("Limit length of a vector") {
    val a = Vec3f(6.0f, 9.0f, 18.0f)
    val b = a.limitLength(7.0f)
    val res = Vec3f(2.0f, 3.0f, 6.0f)
    assert(b === res)
  }

  test("Vector absolute value") {
    val vec = Vec3f(-1.5f, -2.1f, 3.7f)
    val abs = Vec3f(1.5f, 2.1f, 3.7f)
    assert(vec.abs == abs)
  }

  test("Vector sign") {
    val vec = Vec3f(-1.5f, 0.0f, 3.7f)
    val sign = Vec3f(-1.0f, 0.0f, 1.0f)
    assert(vec.sign == sign)
  }

  test("Vector round") {
    val vec = Vec3f(1.9f, 1.1f, 2.9f)
    val res = Vec3f(2.0f, 1.0f, 3.0f)
    assert(vec.round == res)
  }

  test("Vector ceil") {
    val vec = Vec3f(1.9f, 1.1f, 2.9f)
    val res = Vec3f(2.0f, 2.0f, 3.0f)
    assert(vec.ceil == res)
  }

  test("Vector floor") {
    val vec = Vec3f(1.9f, 1.1f, 2.9f)
    val res = Vec3f(1.0f, 1.0f, 2.0f)
    assert(vec.floor == res)
  }

  test("Move vector toward vector") {
    val vec = Vec3f.One.moveToward(Vec3f.Zero, 0.5f)
    assert(vec.length < Vec3f.One.length)
    assert(vec.length > 0.0f)
  }

  test("Linear interpolation between vectors") {
    val from = Vec3f(1.0f, 2.0f, 3.0f)
    val to = Vec3f(2.0f, 4.0f, 6.0f)
    val v1 = Vec3f(1.5f, 3.0f, 4.5f)
    val v2 = Vec3f(1.25f, 2.5f, 3.75f)
    val v3 = Vec3f(1.75f, 3.5f, 5.25f)
    assert(from.lerp(to, 0.5f) === v1)
    assert(from.lerp(to, 0.25f) === v2)
    assert(from.lerp(to, 0.75f) === v3)
  }

  test("Spherical linear interpolation between vectors") {
    val from = Vec3f.Left
    val to = Vec3f.Backwards
    val vec = Vec3f(-math.sin(math.Pi / 4.0f).toFloat, 0.0f, -math.sin(math.Pi / 4.0f).toFloat)
    assert(from.slerp(to, 0.5f) === vec)
  }

  test("Spherical linear interpolation with zero vector") {
    val from = Vec3f.Zero
    val to = Vec3f.One
    assert(from.slerp(to, 0.5f) == from.lerp(to, 0.5f))
  }

  test("Direction to a vector") {
    val from = Vec3f.Zero
    val to = Vec3f(0.0f, 10.0f, 0.0f)
    assert(from.directionTo(to) === Vec3f.Up)
  }

  test("Direction to values") {
    val from = Vec3f.Zero
    val dir = from.directionTo(0.0f, 10.0f, 0.0f)
    assert(dir === Vec3f.Up)
  }

  test("Distance squared between two vectors") {
    val a = Vec3f(-1.0f, 1.0f, -1.0f)
    val b = Vec3f(1.0f, 1.0f, 1.0f)
    assert(a.distanceSquaredTo(b) == 8.0f)
  }

  test("Distance squared between a vector and values") {
    val a = Vec3f(-1.0f, 1.0f, -1.0f)
    val dist = a.distanceSquaredTo(1.0f, 1.0f, 1.0f)
    assert(dist == 8.0f)
  }

  test("Distance between two vectors") {
    val a = Vec3f(-1.0f, 1.0f, -1.0f)
    val b = Vec3f(1.0f, 1.0f, 1.0f)
    assert(a.distanceTo(b) == math.sqrt(8.0).toFloat)
  }

  test("Distance between a vector and values") {
    val a = Vec3f(-1.0f, 1.0f, -1.0f)
    val dist = a.distanceTo(1.0f, 1.0f, 1.0f)
    assert(dist == math.sqrt(8.0).toFloat)
  }

  test("Angle between two vectors") {
    val a = Vec3f(1.0f, 0.0f, 1.0f)
    val b = Vec3f(0.0f, 2.0f, 0.0f)
    assert(a.angleTo(b) == math.Pi / 2.0)
  }

  test("Angle to values") {
    val vec = Vec3f(1.0f, 0.0f, 1.0f)
    val angle = vec.angleTo(0.0f, 2.0f, 0.0f)
    assert(angle == math.Pi / 2.0)
  }

  test("Signed angle to vector") {
    val a = Vec3f(1.0f, 1.0f, 0.0f)
    val b = Vec3f(0.0f, 1.0f, 1.0f)
    assert(a.signedAngleTo(b, Vec3f.Up) === -math.Pi / 3 +- scalamath.Epsilon)
    assert(a.signedAngleTo(b, Vec3f.Down) === math.Pi / 3 +- scalamath.Epsilon)
  }

  test("Project a vector onto a vector") {
    val vec = Vec3f(2.0f, 2.0f, 1.0f)
    val proj = vec.project(Vec3f.Right)
    val res = Vec3f(2.0f, 0.0f, 0.0f)
    assert(proj === res)
  }

  test("Project a vector onto a values") {
    val vec = Vec3f(2.0f, 2.0f, 1.0f)
    val proj = vec.project(1.0f, 0.0f, 0.0f)
    val res = Vec3f(2.0f, 0.0f, 0.0f)
    assert(proj === res)
  }

  test("Reflect a vector by a vector") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val ref = vec.reflect(Vec3f.Up)
    val res = Vec3f(1.0f, -2.0f, 3.0f)
    assert(ref === res)
  }

  test("Reflect a vector by a values") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val ref = vec.reflect(0.0f, 1.0f, 0.0f)
    val res = Vec3f(1.0f, -2.0f, 3.0f)
    assert(ref === res)
  }

  test("Bounce a vector by a vector") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val bounce = vec.bounce(Vec3f.Up)
    val res = Vec3f(-1.0f, 2.0f, -3.0f)
    assert(bounce == res)
  }

  test("Bounce a vector by a values") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val bounce = vec.bounce(0.0f, 1.0f, 0.0f)
    val res = Vec3f(-1.0f, 2.0f, -3.0f)
    assert(bounce === res)
  }

  test("Slide a vector on another vector") {
    val a = Vec3f(1.0f, 1.0f, 0.0f)
    val b = Vec3f(0.0f, 1.0f, 0.0f)
    val res = Vec3f(1.0f, 0.0f, 0.0f)
    assert(a.slide(b) === res)
  }

  test("Slide a vector on values") {
    val vec = Vec3f(1.0f, 1.0f, 0.0f)
    val slide = vec.slide(0.0f, 1.0f, 0.0f)
    val res = Vec3f(1.0f, 0.0f, 0.0f)
    assert(slide === res)
  }

  test("Component-wise mod between vector and values") {
    val vec = Vec3f(1.0f, 3.0f, 8.0f)
    val mod = vec % (2.0f, 2.0f, 3.0f)
    val res = Vec3f(1.0f, 1.0f, 2.0f)
    assert(mod === res)
  }

  test("Component-wise mod between two vectors") {
    val a = Vec3f(1.0f, 3.0f, 8.0f)
    val b = Vec3f(2.0f, 2.0f, 3.0f)
    val res = Vec3f(1.0f, 1.0f, 2.0f)
    assert(a % b === res)
  }

  test("Vector mod with single value") {
    val vec = Vec3f(1.0f, 3.0f, 8.0f)
    val mod = vec % 3.0f
    val res = Vec3f(1.0f, 0.0f, 2.0f)
    assert(mod === res)
  }

  test("Vector rotated by axis and angle") {
    val vec = Vec3f.Right
    val rot = vec.rotated(Vec3f.Up, math.Pi / 2.0)
    val res = Vec3f.Backwards
    assert(rot === res)
  }

  test("Outer product with three values") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val outer = vec.outer(2.0f, 3.0f, 4.0f)
    val res = Mat3f(2.0f, 3.0f, 4.0f, 4.0f, 6.0f, 8.0f, 6.0f, 9.0f, 12.0f)
    assert(outer == res)
  }

  test("Outer product with a 3D vector") {
    val a = Vec3f(1.0f, 2.0f, 3.0f)
    val b = Vec3f(2.0f, 3.0f, 4.0f)
    val res = Mat3f(2.0f, 3.0f, 4.0f, 4.0f, 6.0f, 8.0f, 6.0f, 9.0f, 12.0f)
    assert(a.outer(b) == res)
  }

  test("Outer product with four values") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val outer = vec.outer(2.0f, 3.0f, 4.0f, 5.0f)
    val res = Mat3x4f(2.0f, 3.0f, 4.0f, 5.0f, 4.0f, 6.0f, 8.0f, 10.0f, 6.0f, 9.0f, 12.0f, 15.0f)
    assert(outer == res)
  }

  test("Outer product with a 4D vector") {
    val a = Vec3f(1.0f, 2.0f, 3.0f)
    val b = Vec4f(2.0f, 3.0f, 4.0f, 5.0f)
    val res = Mat3x4f(2.0f, 3.0f, 4.0f, 5.0f, 4.0f, 6.0f, 8.0f, 10.0f, 6.0f, 9.0f, 12.0f, 15.0f)
    assert(a.outer(b) == res)
  }

  test("Vector equals three values") {
    val vec = Vec3f(1.1f, 2.2f, 3.3f)
    assert(vec == (1.1f, 2.2f, 3.3f))
  }

  test("Vector equals approximately three value") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    assert(vec ~= (0.99999999f, 1.99999999f, 3.00000001f))
  }

  test("Vector equals approximately a vector") {
    val a = Vec3f(1.0f, 2.0f, 3.0f)
    val b = Vec3f(0.99999999f, 1.99999999f, 3.00000001f)
    assert(a ~= b)
  }

  test("Access components with apply") {
    val vec = Vec3f(1.1f, 2.2f, 3.3f)
    assert(vec(0) == 1.1f)
    assert(vec(1) == 2.2f)
    assert(vec(2) == 3.3f)
    assertThrows[MatchError] {vec(3)}
  }
}
