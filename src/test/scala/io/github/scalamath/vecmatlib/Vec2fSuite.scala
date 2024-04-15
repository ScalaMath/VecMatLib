package io.github.scalamath.vecmatlib

import io.github.scalamath
import org.scalactic.Equality
import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class Vec2fSuite extends AnyFunSuite {

  implicit val equality: Equality[Vec2f] = (a: Vec2f, b: Any) => b match {
    case b: Vec2f => a ~= b
    case _ => false
  }

  test("Sum of a vector and values") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec + (2.0f, 3.0f)
    val exp = Vec2f(3.0f, 5.0f)
    assert(res === exp)
  }

  test("Sum of two vectors") {
    val a = Vec2f(1.0f, 2.0f)
    val b = Vec2f(2.0f, 3.0f)
    val res = Vec2f(3.0f, 5.0f)
    assert(a + b === res)
  }

  test("Test unary +") {
    val vec = Vec2f(1.1f, 2.2f)
    assert(+vec == vec)
  }

  test("Subtraction of a vector and values") {
    val vec = Vec2f(3.0f, 5.0f)
    val res = vec - (2.0f, 3.0f)
    val exp = Vec2f(1.0f, 2.0f)
    assert(res === exp)
  }

  test("Subtraction of two vectors") {
    val a = Vec2f(3.0f, 5.0f)
    val b = Vec2f(2.0f, 3.0f)
    val res = Vec2f(1.0f, 2.0f)
    assert(a - b === res)
  }

  test("Test unary -") {
    val vec = Vec2f(1.1f, -2.2f)
    val res = Vec2f(-1.1f, 2.2f)
    assert(-vec == res)
  }

  test("Component-wise multiplication with values") {
    val vec = Vec2f(2.0f, 3.0f)
    val res = vec * (3.0f, 4.0f)
    val exp = Vec2f(6.0f, 12.0f)
    assert(res === exp)
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec2f(2.0f, 3.0f)
    val b = Vec2f(3.0f, 4.0f)
    val res = Vec2f(6.0f, 12.0f)
    assert(a * b === res)
  }

  test("Multiplication of a vector by a scalar") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec * 1.5f
    val exp = Vec2f(1.5f, 3.0f)
    assert(res === exp)
  }

  test("Multiplication of a scalar by a vector") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = 1.5f * vec
    val exp = Vec2f(1.5f, 3.0f)
    assert(res === exp)
  }

  test("Component-wise division with values") {
    val vec = Vec2f(6.0f, 12.0f)
    val res = vec / (3.0f, 4.0f)
    val exp = Vec2f(2.0f, 3.0f)
    assert(res === exp)
  }

  test("Component-wise division of two vectors") {
    val a = Vec2f(6.0f, 12.0f)
    val b = Vec2f(3.0f, 4.0f)
    val res = Vec2f(2.0f, 3.0f)
    assert(a / b === res)
  }

  test("Division of a vector by a scalar") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec / 2.0f
    val exp = Vec2f(0.5f, 1.0f)
    assert(res === exp)
  }

  test("Inverse of a vector") {
    val vec = Vec2f(2.0f, 4.0f)
    val inv = Vec2f(0.5f, 0.25f)
    assert(vec.inverse === inv)
  }

  test("Division of a scalar by a vector") {
    val vec = Vec2f(2.0f, 4.0f)
    val inv = Vec2f(0.5f, 0.25f)
    assert(1.0f / vec === inv)
  }

  test("Dot product with two values") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec.dot(2.0f, 3.0f)
    assert(res == 8.0f)
  }

  test("Dot product of two vectors") {
    val a = Vec2f(1.0f, 2.0f)
    val b = Vec2f(2.0f, 3.0f)
    val res = a dot b
    assert(res == 8.0f)
  }

  test("Length squared") {
    assert(Vec2f.One.lengthSquared == 2.0f)
  }

  test("Length") {
    assert(Vec2f.One.length == math.sqrt(2).toFloat)
  }

  test("Normalized vector") {
    val vec = Vec2f(0.0f, 3.0f)
    val res = vec.normalized
    val exp = Vec2f(0.0f, 1.0f)
    assert(res === exp)
  }

  test("Check if vector is normalized") {
    assert(!Vec2f.One.isNormalized)
    assert(Vec2f.Left.isNormalized)
    assert(Vec2f.One.normalized.isNormalized)
  }

  test("Limit length of a vector") {
    val a = Vec2f(6.0f, 8.0f)
    val b = a.limitLength(5.0f)
    val res = Vec2f(3.0f, 4.0f)
    assert(b === res)
  }

  test("Vector absolute value") {
    val vec = Vec2f(-1.5f, 3.7f)
    val abs = Vec2f(1.5f, 3.7f)
    assert(vec.abs == abs)
  }

  test("Vector sign") {
    val vec = Vec2f(-1.5f, 3.7f)
    val sign = Vec2f(-1.0f, 1.0f)
    assert(vec.sign == sign)
  }

  test("Vector round") {
    val vec = Vec2f(1.9f, 1.1f)
    val res = Vec2f(2.0f, 1.0f)
    assert(vec.round == res)
  }

  test("Vector ceil") {
    val vec = Vec2f(1.9f, 1.1f)
    val res = Vec2f(2.0f, 2.0f)
    assert(vec.ceil == res)
  }

  test("Vector floor") {
    val vec = Vec2f(1.9f, 1.1f)
    val res = Vec2f(1.0f, 1.0f)
    assert(vec.floor == res)
  }

  test("Move vector toward vector") {
    val vec = Vec2f.One.moveToward(Vec2f.Zero, 0.5f)
    assert(vec.length < Vec2f.One.length)
    assert(vec.length > 0.0f)
  }

  test("Linear interpolation between vectors") {
    val from = Vec2f(1.0f, 2.0f)
    val to = Vec2f(2.0f, 4.0f)
    val v1 = Vec2f(1.5f, 3.0f)
    val v2 = Vec2f(1.25f, 2.5f)
    val v3 = Vec2f(1.75f, 3.5f)
    assert(from.lerp(to, 0.5f) === v1)
    assert(from.lerp(to, 0.25f) === v2)
    assert(from.lerp(to, 0.75f) === v3)
  }

  test("Spherical linear interpolation between vectors") {
    val from = Vec2f.Left
    val to = Vec2f.Right
    val vec = Vec2f.Down
    assert(from.slerp(to, 0.5f) === vec)
  }

  test("Spherical linear interpolation with zero vector") {
    val from = Vec2f.Zero
    val to = Vec2f.One
    assert(from.slerp(to, 0.5f) == from.lerp(to, 0.5f))
  }

  test("Direction to a vector") {
    val from = Vec2f.Zero
    val to = Vec2f(0.0f, 10.0f)
    assert(from.directionTo(to) === Vec2f.Up)
  }

  test("Direction to values") {
    val from = Vec2f.Zero
    val dir = from.directionTo(0.0f, 10.0f)
    assert(dir === Vec2f.Up)
  }

  test("Distance squared between two vectors") {
    val a = Vec2f(-1.0f, 1.0f)
    val b = Vec2f(1.0f, 1.0f)
    assert(a.distanceSquaredTo(b) == 4.0f)
  }

  test("Distance squared between a vector and values") {
    val a = Vec2f(-1.0f, 1.0f)
    val dist = a.distanceSquaredTo(1.0f, 1.0f)
    assert(dist == 4.0f)
  }

  test("Distance between two vectors") {
    val a = Vec2f(-1.0f, 1.0f)
    val b = Vec2f(1.0f, 1.0f)
    assert(a.distanceTo(b) == 2.0f)
  }

  test("Distance between a vector and values") {
    val a = Vec2f(-1.0f, 1.0f)
    val dist = a.distanceTo(1.0f, 1.0f)
    assert(dist == 2.0f)
  }

  test("Angle between two vectors") {
    val a = Vec2f(3.0f, 3.0f)
    val b = Vec2f(0.0f, 2.0f)
    assert(a.angleTo(b) === math.Pi / 4.0 +- scalamath.Epsilon)
  }

  test("Angle to values") {
    val vec = Vec2f(3.0f, 3.0f)
    val angle = vec.angleTo(0.0f, 2.0f)
    assert(angle === math.Pi / 4.0 +- scalamath.Epsilon)
  }

  test("Angle between a vector and the x axis") {
    val vec = Vec2f(2.0f, 2.0f)
    assert(vec.angle == math.Pi / 4.0)
  }

  test("Angle to a point with a vector") {
    val a = Vec2f(1.0f, 2.0f)
    val b = Vec2f(2.0f, 3.0f)
    assert(a.angleToPoint(b) == math.Pi / 4.0)
  }

  test("Angle to a point with a values") {
    val vec = Vec2f(1.0f, 2.0f)
    val angle = vec.angleToPoint(2.0f, 3.0f)
    assert(angle == math.Pi / 4.0)
  }

  test("Project a vector onto a vector") {
    val vec = Vec2f(2.0f, 2.0f)
    val proj = vec.project(Vec2f.Right)
    val res = Vec2f(2.0f, 0.0f)
    assert(proj === res)
  }

  test("Project a vector onto a values") {
    val vec = Vec2f(2.0f, 2.0f)
    val proj = vec.project(1.0f, 0.0f)
    val res = Vec2f(2.0f, 0.0f)
    assert(proj === res)
  }

  test("Reflect a vector by a vector") {
    val vec = Vec2f(1.0f, -1.0f)
    val ref = vec.reflect(Vec2f.Up)
    val res = Vec2f(1.0f, 1.0f)
    assert(ref === res)
  }

  test("Reflect a vector by a values") {
    val vec = Vec2f(1.0f, -1.0f)
    val ref = vec.reflect(0.0f, 1.0f)
    val res = Vec2f(1.0f, 1.0f)
    assert(ref === res)
  }

  test("Bounce a vector by a vector") {
    val vec = Vec2f(1.0f, -1.0f)
    val bounce = vec.bounce(Vec2f.Up)
    val res = Vec2f(-1.0f, -1.0f)
    assert(bounce === res)
  }

  test("Bounce a vector by a values") {
    val vec = Vec2f(1.0f, -1.0f)
    val bounce = vec.bounce(0.0f, 1.0f)
    val res = Vec2f(-1.0f, -1.0f)
    assert(bounce === res)
  }

  test("Slide a vector on another vector") {
    val a = Vec2f(1.0f, 1.0f)
    val b = Vec2f(0.0f, 1.0f)
    val res = Vec2f(1.0f, 0.0f)
    assert(a.slide(b) === res)
  }

  test("Slide a vector on values") {
    val vec = Vec2f(1.0f, 1.0f)
    val slide = vec.slide(0.0f, 1.0f)
    val res = Vec2f(1.0f, 0.0f)
    assert(slide === res)
  }

  test("Component-wise mod between vector and values") {
    val vec = Vec2f(1.0f, 8.0f)
    val mod = vec % (2.0f, 3.0f)
    val res = Vec2f(1.0f, 2.0f)
    assert(mod === res)
  }

  test("Component-wise mod between two vectors") {
    val a = Vec2f(1.0f, 8.0f)
    val b = Vec2f(2.0f, 3.0f)
    val res = Vec2f(1.0f, 2.0f)
    assert(a % b === res)
  }

  test("Vector mod with single value") {
    val vec = Vec2f(1.0f, 8.0f)
    val mod = vec % 3.0f
    val res = Vec2f(1.0f, 2.0f)
    assert(mod === res)
  }

  test("Vector aspect ratio") {
    val vec = Vec2f(16.0f, 9.0f)
    assert(vec.aspect == 16.0f / 9.0f)
  }

  test("Orthogonal vector") {
    val a = Vec2f(2.0f, 3.0f)
    val b = Vec2f(3.0f, -2.0f)
    assert(a.orthogonal == b)
    assert(a.angleTo(b) == math.Pi / 2.0)
  }

  test("Vector rotated by an angle") {
    val vec = Vec2f.Up
    val rot = vec.rotated(-math.Pi / 4.0)
    val res = Vec2f.One.normalized
    assert(rot === res)
  }

  test("Cross product with three values") {
    val vec = Vec2f.Right
    val cross = vec.cross(0.0f, 1.0f, 0.0f)
    val res = Vec3f.Forward
    assert(cross === res)
  }

  test("Cross product with a 3D vector") {
    val vec = Vec2f.Right
    val cross = vec.cross(Vec3f.Up)
    val res = Vec3f.Forward
    assert(cross === res)
  }

  test("Cross product with a 2D vector") {
    val vec = Vec2f.Right
    val cross = vec.cross(Vec2f.Up)
    val res = Vec3f.Forward
    assert(cross === res)
  }

  test("Outer product with two values") {
    val vec = Vec2f(1.0f, 2.0f)
    val outer = vec.outer(2.0f, 3.0f)
    val res = Mat2f(2.0f, 3.0f, 4.0f, 6.0f)
    assert(outer == res)
  }

  test("Outer product with a 2D vector") {
    val a = Vec2f(1.0f, 2.0f)
    val b = Vec2f(2.0f, 3.0f)
    val res = Mat2f(2.0f, 3.0f, 4.0f, 6.0f)
    assert(a.outer(b) == res)
  }

  test("Outer product with three values") {
    val vec = Vec2f(1.0f, 2.0f)
    val outer = vec.outer(2.0f, 3.0f, 4.0f)
    val res = Mat2x3f(2.0f, 3.0f, 4.0f, 4.0f, 6.0f, 8.0f)
    assert(outer == res)
  }

  test("Outer product with a 3D vector") {
    val a = Vec2f(1.0f, 2.0f)
    val b = Vec3f(2.0f, 3.0f, 4.0f)
    val res = Mat2x3f(2.0f, 3.0f, 4.0f, 4.0f, 6.0f, 8.0f)
    assert(a.outer(b) == res)
  }

  test("Quadratic Bézier interpolation") {
    val p0 = Vec2f(1.0f, 1.5f)
    val p2 = Vec2f(5.0f, 6.0f)
    val p1 = Vec2f(2.0f, 3.0f)
    val t = 0.35f
    val l1 = p0.lerp(p1, t)
    val l2 = p1.lerp(p2, t)
    val res = l1.lerp(l2, t)
    assert(p0.bezierInterpolate(p2, p1, t) === res)
  }

  test("Quadratic Bézier derivative") {
    val p0 = Vec2f(0.0f, 0.0f)
    val p1 = Vec2f(2.0f, 0.0f)
    val control = Vec2f(1.0f, 1.0f)
    val res = Vec2f(0.0f, 2.0f)
    assert(p0.bezierDerivative(p1, control, 0.5f) === res)
  }

  test("Cubic Bézier interpolation") {
    val p0 = Vec2f(1.0f, 1.5f)
    val p3 = Vec2f(5.0f, 6.0f)
    val p1 = Vec2f(1.5f, 2.5f)
    val p2 = Vec2f(3.0f, 4.0f)
    val t = 0.35f
    val m1 = p0.lerp(p1, t)
    val m2 = p1.lerp(p2, t)
    val m3 = p2.lerp(p3, t)
    val l1 = m1.lerp(m2, t)
    val l2 = m2.lerp(m3, t)
    val res = l1.lerp(l2, t)
    assert(p0.bezierInterpolate(p3, p1, p2, t) === res)
  }

  ignore("Cubic Bézier derivative") {
    // TODO
  }

  test("Vector equals two values") {
    val vec = Vec2f(1.1f, 2.2f)
    assert(vec == (1.1f, 2.2f))
  }

  test("Vector equals approximately two value") {
    val vec = Vec2f(1.0f, 2.0f)
    assert(vec ~= (0.99999999f, 1.99999999f))
  }

  test("Vector equals approximately a vector") {
    val a = Vec2f(1.0f, 2.0f)
    val b = Vec2f(0.99999999f, 1.99999999f)
    assert(a ~= b)
  }

  test("Access components with apply") {
    val vec = Vec2f(1.1f, 2.2f)
    assert(vec(0) == 1.1f)
    assert(vec(1) == 2.2f)
    assertThrows[MatchError] {vec(2)}
  }

  test("Unit vector from angle") {
    val vec = Vec2f.fromAngle(math.Pi / 4.0)
    assert(vec === Vec2f.One.normalized)
    assert(vec === Vec2f.Right.rotated(math.Pi / 4.0))
  }
}
