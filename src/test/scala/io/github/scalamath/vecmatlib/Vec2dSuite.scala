package io.github.scalamath.vecmatlib

import io.github.scalamath
import org.scalactic.Equality
import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class Vec2dSuite extends AnyFunSuite {

  implicit val equality: Equality[Vec2d] = (a: Vec2d, b: Any) => b match {
    case b: Vec2d => a ~= b
    case _ => false
  }

  test("Sum of a vector and values") {
    val vec = Vec2d(1.0, 2.0)
    val res = vec + (2.0, 3.0)
    val exp = Vec2d(3.0, 5.0)
    assert(res === exp)
  }

  test("Sum of two vectors") {
    val a = Vec2d(1.0, 2.0)
    val b = Vec2d(2.0, 3.0)
    val res = Vec2d(3.0, 5.0)
    assert(a + b === res)
  }

  test("Test unary +") {
    val vec = Vec2d(1.1, 2.2)
    assert(+vec == vec)
  }

  test("Subtraction of a vector and values") {
    val vec = Vec2d(3.0, 5.0)
    val res = vec - (2.0, 3.0)
    val exp = Vec2d(1.0, 2.0)
    assert(res === exp)
  }

  test("Subtraction of two vectors") {
    val a = Vec2d(3.0, 5.0)
    val b = Vec2d(2.0, 3.0)
    val res = Vec2d(1.0, 2.0)
    assert(a - b === res)
  }

  test("Test unary -") {
    val vec = Vec2d(1.1, -2.2)
    val res = Vec2d(-1.1, 2.2)
    assert(-vec == res)
  }

  test("Component-wise multiplication with values") {
    val vec = Vec2d(2.0, 3.0)
    val res = vec * (3.0, 4.0)
    val exp = Vec2d(6.0, 12.0)
    assert(res === exp)
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec2d(2.0, 3.0)
    val b = Vec2d(3.0, 4.0)
    val res = Vec2d(6.0, 12.0)
    assert(a * b === res)
  }

  test("Multiplication of a vector by a scalar") {
    val vec = Vec2d(1.0, 2.0)
    val res = vec * 1.5
    val exp = Vec2d(1.5, 3.0)
    assert(res === exp)
  }

  test("Multiplication of a scalar by a vector") {
    val vec = Vec2d(1.0, 2.0)
    val res = 1.5 * vec
    val exp = Vec2d(1.5, 3.0)
    assert(res === exp)
  }

  test("Component-wise division with values") {
    val vec = Vec2d(6.0, 12.0)
    val res = vec / (3.0, 4.0)
    val exp = Vec2d(2.0, 3.0)
    assert(res === exp)
  }

  test("Component-wise division of two vectors") {
    val a = Vec2d(6.0, 12.0)
    val b = Vec2d(3.0, 4.0)
    val res = Vec2d(2.0, 3.0)
    assert(a / b === res)
  }

  test("Division of a vector by a scalar") {
    val vec = Vec2d(1.0, 2.0)
    val res = vec / 2.0
    val exp = Vec2d(0.5, 1.0)
    assert(res === exp)
  }

  test("Inverse of a vector") {
    val vec = Vec2d(2.0, 4.0)
    val inv = Vec2d(0.5, 0.25)
    assert(vec.inverse === inv)
  }

  test("Division of a scalar by a vector") {
    val vec = Vec2d(2.0, 4.0)
    val inv = Vec2d(0.5, 0.25)
    assert(1.0 / vec === inv)
  }

  test("Dot product with two values") {
    val vec = Vec2d(1.0, 2.0)
    val res = vec.dot(2.0, 3.0)
    assert(res == 8.0)
  }

  test("Dot product of two vectors") {
    val a = Vec2d(1.0, 2.0)
    val b = Vec2d(2.0, 3.0)
    val res = a dot b
    assert(res == 8.0)
  }

  test("Length squared") {
    assert(Vec2d.One.lengthSquared == 2.0)
  }

  test("Length") {
    assert(Vec2d.One.length == math.sqrt(2))
  }

  test("Normalized vector") {
    val vec = Vec2d(0.0, 3.0)
    val res = vec.normalized
    val exp = Vec2d(0.0, 1.0)
    assert(res === exp)
  }

  test("Check if vector is normalized") {
    assert(!Vec2d.One.isNormalized)
    assert(Vec2d.Left.isNormalized)
    assert(Vec2d.One.normalized.isNormalized)
  }

  test("Limit length of a vector") {
    val a = Vec2d(6.0, 8.0)
    val b = a.limitLength(5.0)
    val res = Vec2d(3.0, 4.0)
    assert(b === res)
  }

  test("Vector absolute value") {
    val vec = Vec2d(-1.5, 3.7)
    val abs = Vec2d(1.5, 3.7)
    assert(vec.abs == abs)
  }

  test("Vector sign") {
    val vec = Vec2d(-1.5, 3.7)
    val sign = Vec2d(-1.0, 1.0)
    assert(vec.sign == sign)
  }

  test("Vector round") {
    val vec = Vec2d(1.9, 1.1)
    val res = Vec2d(2.0, 1.0)
    assert(vec.round == res)
  }

  test("Vector ceil") {
    val vec = Vec2d(1.9, 1.1)
    val res = Vec2d(2.0, 2.0)
    assert(vec.ceil == res)
  }

  test("Vector floor") {
    val vec = Vec2d(1.9, 1.1)
    val res = Vec2d(1.0, 1.0)
    assert(vec.floor == res)
  }

  test("Move vector toward vector") {
    val vec = Vec2d.One.moveToward(Vec2d.Zero, 0.5)
    assert(vec.length < Vec2d.One.length)
    assert(vec.length > 0.0)
  }

  test("Linear interpolation between vectors") {
    val from = Vec2d(1.0, 2.0)
    val to = Vec2d(2.0, 4.0)
    val v1 = Vec2d(1.5, 3.0)
    val v2 = Vec2d(1.25, 2.5)
    val v3 = Vec2d(1.75, 3.5)
    assert(from.lerp(to, 0.5) === v1)
    assert(from.lerp(to, 0.25) === v2)
    assert(from.lerp(to, 0.75) === v3)
  }

  test("Spherical linear interpolation between vectors") {
    val from = Vec2d.Left
    val to = Vec2d.Right
    val vec = Vec2d.Down
    assert(from.slerp(to, 0.5) === vec)
  }

  test("Spherical linear interpolation with zero vector") {
    val from = Vec2d.Zero
    val to = Vec2d.One
    assert(from.slerp(to, 0.5) == from.lerp(to, 0.5))
  }

  test("Direction to a vector") {
    val from = Vec2d.Zero
    val to = Vec2d(0.0, 10.0)
    assert(from.directionTo(to) === Vec2d.Up)
  }

  test("Direction to values") {
    val from = Vec2d.Zero
    val dir = from.directionTo(0.0, 10.0)
    assert(dir === Vec2d.Up)
  }

  test("Distance squared between two vectors") {
    val a = Vec2d(-1.0, 1.0)
    val b = Vec2d(1.0, 1.0)
    assert(a.distanceSquaredTo(b) == 4.0)
  }

  test("Distance squared between a vector and values") {
    val a = Vec2d(-1.0, 1.0)
    val dist = a.distanceSquaredTo(1.0, 1.0)
    assert(dist == 4.0)
  }

  test("Distance between two vectors") {
    val a = Vec2d(-1.0, 1.0)
    val b = Vec2d(1.0, 1.0)
    assert(a.distanceTo(b) == 2.0)
  }

  test("Distance between a vector and values") {
    val a = Vec2d(-1.0, 1.0)
    val dist = a.distanceTo(1.0, 1.0)
    assert(dist == 2.0)
  }

  test("Angle between two vectors") {
    val a = Vec2d(3.0, 3.0)
    val b = Vec2d(0.0, 2.0)
    assert(a.angleTo(b) === math.Pi / 4.0 +- scalamath.Epsilon)
  }

  test("Angle to values") {
    val vec = Vec2d(3.0, 3.0)
    val angle = vec.angleTo(0.0, 2.0)
    assert(angle === math.Pi / 4.0 +- scalamath.Epsilon)
  }

  test("Angle between a vector and the x axis") {
    val vec = Vec2d(2.0, 2.0)
    assert(vec.angle == math.Pi / 4.0)
  }

  test("Angle to a point with a vector") {
    val a = Vec2d(1.0, 2.0)
    val b = Vec2d(2.0, 3.0)
    assert(a.angleToPoint(b) == math.Pi / 4.0)
  }

  test("Angle to a point with a values") {
    val vec = Vec2d(1.0, 2.0)
    val angle = vec.angleToPoint(2.0, 3.0)
    assert(angle == math.Pi / 4.0)
  }

  test("Project a vector onto a vector") {
    val vec = Vec2d(2.0, 2.0)
    val proj = vec.project(Vec2d.Right)
    val res = Vec2d(2.0, 0.0)
    assert(proj === res)
  }

  test("Project a vector onto a values") {
    val vec = Vec2d(2.0, 2.0)
    val proj = vec.project(1.0, 0.0)
    val res = Vec2d(2.0, 0.0)
    assert(proj === res)
  }

  test("Reflect a vector by a vector") {
    val vec = Vec2d(1.0, -1.0)
    val ref = vec.reflect(Vec2d.Up)
    val res = Vec2d(1.0, 1.0)
    assert(ref === res)
  }

  test("Reflect a vector by a values") {
    val vec = Vec2d(1.0, -1.0)
    val ref = vec.reflect(0.0, 1.0)
    val res = Vec2d(1.0, 1.0)
    assert(ref == res)
  }

  test("Bounce a vector by a vector") {
    val vec = Vec2d(1.0, -1.0)
    val bounce = vec.bounce(Vec2d.Up)
    val res = Vec2d(-1.0, -1.0)
    assert(bounce === res)
  }

  test("Bounce a vector by a values") {
    val vec = Vec2d(1.0, -1.0)
    val bounce = vec.bounce(0.0, 1.0)
    val res = Vec2d(-1.0, -1.0)
    assert(bounce === res)
  }

  test("Slide a vector on another vector") {
    val a = Vec2d(1.0, 1.0)
    val b = Vec2d(0.0, 1.0)
    val res = Vec2d(1.0, 0.0)
    assert(a.slide(b) === res)
  }

  test("Slide a vector on values") {
    val vec = Vec2d(1.0, 1.0)
    val slide = vec.slide(0.0, 1.0)
    val res = Vec2d(1.0, 0.0)
    assert(slide === res)
  }

  test("Component-wise mod between vector and values") {
    val vec = Vec2d(1.0, 8.0)
    val mod = vec % (2.0, 3.0)
    val res = Vec2d(1.0, 2.0)
    assert(mod === res)
  }

  test("Component-wise mod between two vectors") {
    val a = Vec2d(1.0, 8.0)
    val b = Vec2d(2.0, 3.0)
    val res = Vec2d(1.0, 2.0)
    assert(a % b === res)
  }

  test("Vector mod with single value") {
    val vec = Vec2d(1.0, 8.0)
    val mod = vec % 3.0
    val res = Vec2d(1.0, 2.0)
    assert(mod === res)
  }

  test("Vector aspect ratio") {
    val vec = Vec2d(16.0, 9.0)
    assert(vec.aspect == 16.0 / 9.0)
  }

  test("Orthogonal vector") {
    val a = Vec2d(2.0, 3.0)
    val b = Vec2d(3.0, -2.0)
    assert(a.orthogonal == b)
    assert(a.angleTo(b) == math.Pi / 2.0)
  }

  test("Vector rotated by an angle") {
    val vec = Vec2d.Up
    val rot = vec.rotated(-math.Pi / 4.0)
    val res = Vec2d.One.normalized
    assert(rot === res)
  }

  test("Cross product with three values") {
    val vec = Vec2d.Right
    val cross = vec.cross(0.0, 1.0, 0.0)
    val res = Vec3d.Forward
    assert(cross === res)
  }

  test("Cross product with a 3D vector") {
    val vec = Vec2d.Right
    val cross = vec.cross(Vec3d.Up)
    val res = Vec3d.Forward
    assert(cross === res)
  }

  test("Cross product with a 2D vector") {
    val vec = Vec2d.Right
    val cross = vec.cross(Vec2d.Up)
    val res = Vec3d.Forward
    assert(cross == res)
  }

  test("Outer product with two values") {
    val vec = Vec2d(1.0, 2.0)
    val outer = vec.outer(2.0, 3.0)
    val res = Mat2d(2.0, 3.0, 4.0, 6.0)
    assert(outer == res)
  }

  test("Outer product with a 2D vector") {
    val a = Vec2d(1.0, 2.0)
    val b = Vec2d(2.0, 3.0)
    val res = Mat2d(2.0, 3.0, 4.0, 6.0)
    assert(a.outer(b) == res)
  }

  test("Outer product with three values") {
    val vec = Vec2d(1.0, 2.0)
    val outer = vec.outer(2.0, 3.0, 4.0)
    val res = Mat2x3d(2.0, 3.0, 4.0, 4.0, 6.0, 8.0)
    assert(outer == res)
  }

  test("Outer product with a 3D vector") {
    val a = Vec2d(1.0, 2.0)
    val b = Vec3d(2.0, 3.0, 4.0)
    val res = Mat2x3d(2.0, 3.0, 4.0, 4.0, 6.0, 8.0)
    assert(a.outer(b) == res)
  }

  test("Vector equals two values") {
    val vec = Vec2d(1.1, 2.2)
    assert(vec == (1.1, 2.2))
  }

  test("Vector equals approximately two value") {
    val vec = Vec2d(1.0, 2.0)
    assert(vec ~= (0.99999999, 1.99999999))
  }

  test("Vector equals approximately a vector") {
    val a = Vec2d(1.0, 2.0)
    val b = Vec2d(0.99999999, 1.99999999)
    assert(a ~= b)
  }

  test("Access components with apply") {
    val vec = Vec2d(1.1, 2.2)
    assert(vec(0) == 1.1)
    assert(vec(1) == 2.2)
    assertThrows[scala.MatchError] {vec(2)}
  }
}
