package io.github.scalamath.vecmatlib

import org.scalactic.Equality
import org.scalatest.funsuite.AnyFunSuite

class Vec3dSuite extends AnyFunSuite {

  implicit val equality: Equality[Vec3d] = (a: Vec3d, b: Any) => b match {
    case b: Vec3d => a ~= b
    case _ => false
  }

  test("Construct from Vec2d and z") {
    val a = Vec2d(1.1, 2.2)
    val b = Vec3d(a, 3.3)
    val exp = Vec3d(1.1, 2.2, 3.3)
    assert(b == exp)
  }

  test("Access xy components") {
    val a = Vec3d(1.1, 2.2, 3.3)
    val b = Vec2d(1.1, 2.2)
    assert(a.xy == b)
  }

  test("Sum of a vector and values") {
    val vec = Vec3d(1.0, 2.0, 3.0)
    val res = vec + (2.0, 3.0, 1.0)
    val exp = Vec3d(3.0, 5.0, 4.0)
    assert(res === exp)
  }

  test("Sum of two vectors") {
    val a = Vec3d(1.0, 2.0, 3.0)
    val b = Vec3d(2.0, 3.0, 1.0)
    val res = Vec3d(3.0, 5.0, 4.0)
    assert(a + b === res)
  }

  test("Test unary +") {
    val vec = Vec3d(1.1, 2.2, 3.3)
    assert(+vec == vec)
  }

  test("Subtraction of a vector and values") {
    val vec = Vec3d(3.0, 5.0, 4.0)
    val res = vec - (2.0, 3.0, 1.0)
    val exp = Vec3d(1.0, 2.0, 3.0)
    assert(res === exp)
  }

  test("Subtraction of two vectors") {
    val a = Vec3d(3.0, 5.0, 4.0)
    val b = Vec3d(2.0, 3.0, 1.0)
    val res = Vec3d(1.0, 2.0, 3.0)
    assert(a - b === res)
  }

  test("Test unary -") {
    val vec = Vec3d(1.1, -2.2, 3.3)
    val res = Vec3d(-1.1, 2.2, -3.3)
    assert(-vec == res)
  }

  test("Component-wise multiplication with values") {
    val vec = Vec3d(2.0, 3.0, 4.0)
    val res = vec * (3.0, 4.0, 2.0)
    val exp = Vec3d(6.0, 12.0, 8.0)
    assert(res === exp)
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec3d(2.0, 3.0, 4.0)
    val b = Vec3d(3.0, 4.0, 2.0)
    val res = Vec3d(6.0, 12.0, 8.0)
    assert(a * b === res)
  }

  test("Multiplication of a vector by a scalar") {
    val vec = Vec3d(1.0, 2.0, 3.0)
    val res = vec * 1.5
    val exp = Vec3d(1.5, 3.0, 4.5)
    assert(res === exp)
  }

  test("Multiplication of a scalar by a vector") {
    val vec = Vec3d(1.0, 2.0, 3.0)
    val res = 1.5 * vec
    val exp = Vec3d(1.5, 3.0, 4.5)
    assert(res === exp)
  }

  test("Component-wise division with values") {
    val vec = Vec3d(6.0, 12.0, 8.0)
    val res = vec / (3.0, 4.0, 2.0)
    val exp = Vec3d(2.0, 3.0, 4.0)
    assert(res === exp)
  }

  test("Component-wise division of two vectors") {
    val a = Vec3d(6.0, 12.0, 8.0)
    val b = Vec3d(3.0, 4.0, 2.0)
    val res = Vec3d(2.0, 3.0, 4.0)
    assert(a / b === res)
  }

  test("Division of a vector by a scalar") {
    val vec = Vec3d(1.0, 2.0, 3.0)
    val res = vec / 2.0
    val exp = Vec3d(0.5, 1.0, 1.5)
    assert(res === exp)
  }

  test("Inverse of a vector") {
    val vec = Vec3d(2.0, 4.0, 8.0)
    val inv = Vec3d(0.5, 0.25, 0.125)
    assert(vec.inverse === inv)
  }

  test("Division of a scalar by a vector") {
    val vec = Vec3d(2.0, 4.0, 8.0)
    val inv = Vec3d(0.5, 0.25, 0.125)
    assert(1.0 / vec === inv)
  }

  test("Dot product with three values") {
    val vec = Vec3d(1.0, 2.0, 3.0)
    val res = vec.dot(2.0, 3.0, 1.0)
    assert(res == 11.0)
  }

  test("Dot product of two vectors") {
    val a = Vec3d(1.0, 2.0, 3.0)
    val b = Vec3d(2.0, 3.0, 1.0)
    val res = a dot b
    assert(res == 11.0)
  }

  test("Cross product with three values") {
    val vec = Vec3d.Right
    val res = vec.cross(0.0, 1.0, 0.0)
    assert(res === Vec3d.Forward)
  }

  test("Cross product of two vectors") {
    val a = Vec3d.Right
    val b = Vec3d.Up
    val res = a cross b
    assert(res === Vec3d.Forward)
  }

  test("Cross product with a 2D vector") {
    val a = Vec3d.Right
    val b = Vec2d.Up
    val res = a cross b
    assert(res === Vec3d.Forward)
  }

  test("Length squared") {
    assert(Vec3d.One.lengthSquared == 3.0)
  }

  test("Length") {
    assert(Vec3d.One.length == math.sqrt(3))
  }

  test("Normalized vector") {
    val vec = Vec3d(0.0, 3.0, 0.0)
    val res = vec.normalized
    val exp = Vec3d(0.0, 1.0, 0.0)
    assert(res === exp)
  }

  test("Check if vector is normalized") {
    assert(!Vec3d.One.isNormalized)
    assert(Vec3d.Forward.isNormalized)
    assert(Vec3d.One.normalized.isNormalized)
  }

  test("Limit length of a vector") {
    val a = Vec3d(6.0, 9.0, 18.0)
    val b = a.limitLength(7.0)
    val res = Vec3d(2.0, 3.0, 6.0)
    assert(b === res)
  }

  test("Vector absolute value") {
    val vec = Vec3d(-1.5, -2.1, 3.7)
    val abs = Vec3d(1.5, 2.1, 3.7)
    assert(vec.abs == abs)
  }

  test("Vector sign") {
    val vec = Vec3d(-1.5, 0.0, 3.7)
    val sign = Vec3d(-1.0, 0.0, 1.0)
    assert(vec.sign == sign)
  }

  test("Vector round") {
    val vec = Vec3d(1.9, 1.1, 2.9)
    val res = Vec3d(2.0, 1.0, 3.0)
    assert(vec.round == res)
  }

  test("Vector ceil") {
    val vec = Vec3d(1.9, 1.1, 2.9)
    val res = Vec3d(2.0, 2.0, 3.0)
    assert(vec.ceil == res)
  }

  test("Vector floor") {
    val vec = Vec3d(1.9, 1.1, 2.9)
    val res = Vec3d(1.0, 1.0, 2.0)
    assert(vec.floor == res)
  }

  test("Move vector toward vector") {
    val vec = Vec3d.One.moveToward(Vec3d.Zero, 0.5)
    assert(vec.length < Vec3d.One.length)
    assert(vec.length > 0.0)
  }

  test("Linear interpolation between vectors") {
    val from = Vec3d(1.0, 2.0, 3.0)
    val to = Vec3d(2.0, 4.0, 6.0)
    val v1 = Vec3d(1.5, 3.0, 4.5)
    val v2 = Vec3d(1.25, 2.5, 3.75)
    val v3 = Vec3d(1.75, 3.5, 5.25)
    assert(from.lerp(to, 0.5) === v1)
    assert(from.lerp(to, 0.25) === v2)
    assert(from.lerp(to, 0.75) === v3)
  }

  test("Spherical linear interpolation between vectors") {
    val from = Vec3d.Left
    val to = Vec3d.Backwards
    val vec = Vec3d(-math.sin(math.Pi / 4.0), 0.0, -math.sin(math.Pi / 4.0))
    assert(from.slerp(to, 0.5) === vec)
  }

  test("Spherical linear interpolation with zero vector") {
    val from = Vec3d.Zero
    val to = Vec3d.One
    assert(from.slerp(to, 0.5) == from.lerp(to, 0.5))
  }

  test("Direction to a vector") {
    val from = Vec3d.Zero
    val to = Vec3d(0.0, 10.0, 0.0)
    assert(from.directionTo(to) === Vec3d.Up)
  }

  test("Direction to values") {
    val from = Vec3d.Zero
    val dir = from.directionTo(0.0, 10.0, 0.0)
    assert(dir === Vec3d.Up)
  }

  test("Distance squared between two vectors") {
    val a = Vec3d(-1.0, 1.0, -1.0)
    val b = Vec3d(1.0, 1.0, 1.0)
    assert(a.distanceSquaredTo(b) == 8.0)
  }

  test("Distance squared between a vector and values") {
    val a = Vec3d(-1.0, 1.0, -1.0)
    val dist = a.distanceSquaredTo(1.0, 1.0, 1.0)
    assert(dist == 8.0)
  }

  test("Distance between two vectors") {
    val a = Vec3d(-1.0, 1.0, -1.0)
    val b = Vec3d(1.0, 1.0, 1.0)
    assert(a.distanceTo(b) == math.sqrt(8.0))
  }

  test("Distance between a vector and values") {
    val a = Vec3d(-1.0, 1.0, -1.0)
    val dist = a.distanceTo(1.0, 1.0, 1.0)
    assert(dist == math.sqrt(8.0))
  }

  test("Angle between two vectors") {
    val a = Vec3d(1.0, 0.0, 1.0)
    val b = Vec3d(0.0, 2.0, 0.0)
    assert(a.angleTo(b) == math.Pi / 2.0)
  }

  test("Angle to values") {
    val vec = Vec3d(1.0, 0.0, 1.0)
    val angle = vec.angleTo(0.0, 2.0, 0.0)
    assert(angle == math.Pi / 2.0)
  }

  // TODO: Signed angle to

  test("Project a vector onto a vector") {
    val vec = Vec3d(2.0, 2.0, 1.0)
    val proj = vec.project(Vec3d.Right)
    val res = Vec3d(2.0, 0.0, 0.0)
    assert(proj === res)
  }

  test("Project a vector onto a values") {
    val vec = Vec3d(2.0, 2.0, 1.0)
    val proj = vec.project(1.0, 0.0, 0.0)
    val res = Vec3d(2.0, 0.0, 0.0)
    assert(proj === res)
  }

  test("Reflect a vector by a vector") {
    val vec = Vec3d(1.0, 2.0, 3.0)
    val ref = vec.reflect(Vec3d.Up)
    val res = Vec3d(1.0, -2.0, 3.0)
    assert(ref === res)
  }

  test("Reflect a vector by a values") {
    val vec = Vec3d(1.0, 2.0, 3.0)
    val ref = vec.reflect(0.0, 1.0, 0.0)
    val res = Vec3d(1.0, -2.0, 3.0)
    assert(ref === res)
  }

  test("Bounce a vector by a vector") {
    val vec = Vec3d(1.0, 2.0, 3.0)
    val bounce = vec.bounce(Vec3d.Up)
    val res = Vec3d(-1.0, 2.0, -3.0)
    assert(bounce === res)
  }

  test("Bounce a vector by a values") {
    val vec = Vec3d(1.0, 2.0, 3.0)
    val bounce = vec.bounce(0.0, 1.0, 0.0)
    val res = Vec3d(-1.0, 2.0, -3.0)
    assert(bounce === res)
  }

  test("Slide a vector on another vector") {
    val a = Vec3d(1.0, 1.0, 0.0)
    val b = Vec3d(0.0, 1.0, 0.0)
    val res = Vec3d(1.0, 0.0, 0.0)
    assert(a.slide(b) === res)
  }

  test("Slide a vector on values") {
    val vec = Vec3d(1.0, 1.0, 0.0)
    val slide = vec.slide(0.0, 1.0, 0.0)
    val res = Vec3d(1.0, 0.0, 0.0)
    assert(slide === res)
  }

  test("Component-wise mod between vector and values") {
    val vec = Vec3d(1.0, 3.0, 8.0)
    val mod = vec % (2.0, 2.0, 3.0)
    val res = Vec3d(1.0, 1.0, 2.0)
    assert(mod === res)
  }

  test("Component-wise mod between two vectors") {
    val a = Vec3d(1.0, 3.0, 8.0)
    val b = Vec3d(2.0, 2.0, 3.0)
    val res = Vec3d(1.0, 1.0, 2.0)
    assert(a % b === res)
  }

  test("Vector mod with single value") {
    val vec = Vec3d(1.0, 3.0, 8.0)
    val mod = vec % 3.0
    val res = Vec3d(1.0, 0.0, 2.0)
    assert(mod === res)
  }

  // TODO: Rotated by axis and angle

  test("Outer product with three values") {
    val vec = Vec3d(1.0, 2.0, 3.0)
    val outer = vec.outer(2.0, 3.0, 4.0)
    val res = Mat3d(2.0, 3.0, 4.0, 4.0, 6.0, 8.0, 6.0, 9.0, 12.0)
    assert(outer == res)
  }

  test("Outer product with a 3D vector") {
    val a = Vec3d(1.0, 2.0, 3.0)
    val b = Vec3d(2.0, 3.0, 4.0)
    val res = Mat3d(2.0, 3.0, 4.0, 4.0, 6.0, 8.0, 6.0, 9.0, 12.0)
    assert(a.outer(b) == res)
  }

  test("Outer product with four values") {
    val vec = Vec3d(1.0, 2.0, 3.0)
    val outer = vec.outer(2.0, 3.0, 4.0, 5.0)
    val res = Mat3x4d(2.0, 3.0, 4.0, 5.0, 4.0, 6.0, 8.0, 10.0, 6.0, 9.0, 12.0, 15.0)
    assert(outer == res)
  }

  test("Outer product with a 4D vector") {
    val a = Vec3d(1.0, 2.0, 3.0)
    val b = Vec4d(2.0, 3.0, 4.0, 5.0)
    val res = Mat3x4d(2.0, 3.0, 4.0, 5.0, 4.0, 6.0, 8.0, 10.0, 6.0, 9.0, 12.0, 15.0)
    assert(a.outer(b) == res)
  }

  test("Vector equals three values") {
    val vec = Vec3d(1.1, 2.2, 3.3)
    assert(vec == (1.1, 2.2, 3.3))
  }

  test("Vector equals approximately three value") {
    val vec = Vec3d(1.0, 2.0, 3.0)
    assert(vec ~= (0.99999999, 1.99999999, 3.00000001))
  }

  test("Vector equals approximately a vector") {
    val a = Vec3d(1.0, 2.0, 3.0)
    val b = Vec3d(0.99999999, 1.99999999, 3.00000001)
    assert(a ~= b)
  }

  test("Access components with apply") {
    val vec = Vec3d(1.1, 2.2, 3.3)
    assert(vec(0) == 1.1)
    assert(vec(1) == 2.2)
    assert(vec(2) == 3.3)
    assertThrows[scala.MatchError] {vec(3)}
  }
}
