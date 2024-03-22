package io.github.hexagonnico

import io.github.hexagonnico.vecmatlib.matrix.Mat4f
import io.github.hexagonnico.vecmatlib.vector.{Vec2f, Vec3f, Vec4f}
import org.scalactic.Equality
import org.scalatest.funsuite.AnyFunSuite

class Vec4fSuite extends AnyFunSuite {

  implicit val equality: Equality[Vec4f] = (a: Vec4f, b: Any) => b match {
    case b: Vec4f => a ~= b
    case _ => false
  }

  test("Construct from Vec3f and z") {
    val a = Vec3f(1.1f, 2.2f, 3.3f)
    val b = Vec4f(a, 4.4f)
    val exp = Vec4f(1.1f, 2.2f, 3.3f, 4.4f)
    assert(b == exp)
  }

  test("Construct from Vec2f, z, and w") {
    val a = Vec2f(1.1f, 2.2f)
    val b = Vec4f(a, 3.3f, 4.4f)
    val exp = Vec4f(1.1f, 2.2f, 3.3f, 4.4f)
    assert(b == exp)
  }

  test("Access xy components") {
    val a = Vec4f(1.1f, 2.2f, 3.3f, 4.4f)
    val b = Vec2f(1.1f, 2.2f)
    assert(a.xy == b)
  }

  test("Access xyz components") {
    val a = Vec4f(1.1f, 2.2f, 3.3f, 4.4f)
    val b = Vec3f(1.1f, 2.2f, 3.3f)
    assert(a.xyz == b)
  }

  test("Sum of a vector and values") {
    val vec = Vec4f(1.0f, 2.0f, 3.0f, 3.0f)
    val res = vec + (2.0f, 3.0f, 1.0f, -1.0f)
    val exp = Vec4f(3.0f, 5.0f, 4.0f, 2.0f)
    assert(res === exp)
  }

  test("Sum of two vectors") {
    val a = Vec4f(1.0f, 2.0f, 3.0f, 3.0f)
    val b = Vec4f(2.0f, 3.0f, 1.0f, -1.0f)
    val res = Vec4f(3.0f, 5.0f, 4.0f, 2.0f)
    assert(a + b === res)
  }

  test("Test unary +") {
    val vec = Vec4f(1.1f, 2.2f, 3.3f, 4.4f)
    assert(+vec == vec)
  }

  test("Subtraction of a vector and values") {
    val vec = Vec4f(3.0f, 5.0f, 4.0f, 2.0f)
    val res = vec - (2.0f, 3.0f, 1.0f, 4.0f)
    val exp = Vec4f(1.0f, 2.0f, 3.0f, -2.0f)
    assert(res === exp)
  }

  test("Subtraction of two vectors") {
    val a = Vec4f(3.0f, 5.0f, 4.0f, 2.0f)
    val b = Vec4f(2.0f, 3.0f, 1.0f, 4.0f)
    val res = Vec4f(1.0f, 2.0f, 3.0f, -2.0f)
    assert(a - b === res)
  }

  test("Test unary -") {
    val vec = Vec4f(1.1f, -2.2f, 0.0f, -4.4f)
    val res = Vec4f(-1.1f, 2.2f, 0.0f, 4.4f)
    assert(-vec == res)
  }

  test("Component-wise multiplication with values") {
    val vec = Vec4f(2.0f, 3.0f, 4.0f, 1.0f)
    val res = vec * (3.0f, 4.0f, 2.0f, 1.0f)
    val exp = Vec4f(6.0f, 12.0f, 8.0f, 1.0f)
    assert(res === exp)
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec4f(2.0f, 3.0f, 4.0f, 1.0f)
    val b = Vec4f(3.0f, 4.0f, 2.0f, 1.0f)
    val res = Vec4f(6.0f, 12.0f, 8.0f, 1.0f)
    assert(a * b === res)
  }

  test("Multiplication of a vector by a scalar") {
    val vec = Vec4f(1.0f, 2.0f, 3.0f, 4.0f)
    val res = vec * 1.5f
    val exp = Vec4f(1.5f, 3.0f, 4.5f, 6.0f)
    assert(res === exp)
  }

  test("Multiplication of a scalar by a vector") {
    val vec = Vec4f(1.0f, 2.0f, 3.0f, 4.0f)
    val res = 1.5f * vec
    val exp = Vec4f(1.5f, 3.0f, 4.5f, 6.0f)
    assert(res === exp)
  }

  test("Component-wise division with values") {
    val vec = Vec4f(6.0f, 12.0f, 8.0f, 1.0f)
    val res = vec / (3.0f, 4.0f, 2.0f, 2.0f)
    val exp = Vec4f(2.0f, 3.0f, 4.0f, 0.5f)
    assert(res === exp)
  }

  test("Component-wise division of two vectors") {
    val a = Vec4f(6.0f, 12.0f, 8.0f, 1.0f)
    val b = Vec4f(3.0f, 4.0f, 2.0f, 2.0f)
    val res = Vec4f(2.0f, 3.0f, 4.0f, 0.5f)
    assert(a / b === res)
  }

  test("Division of a vector by a scalar") {
    val vec = Vec4f(1.0f, 2.0f, 3.0f, 4.0f)
    val res = vec / 2.0f
    val exp = Vec4f(0.5f, 1.0f, 1.5f, 2.0f)
    assert(res === exp)
  }

  test("Inverse of a vector") {
    val vec = Vec4f(2.0f, 4.0f, 8.0f, 10.0f)
    val inv = Vec4f(0.5f, 0.25f, 0.125f, 0.1f)
    assert(vec.inverse === inv)
  }

  test("Division of a scalar by a vector") {
    val vec = Vec4f(2.0f, 4.0f, 8.0f, 10.0f)
    val inv = Vec4f(0.5f, 0.25f, 0.125f, 0.1f)
    assert(1.0f / vec === inv)
  }

  test("Dot product with three values") {
    val vec = Vec4f(1.0f, 2.0f, 3.0f, 4.0f)
    val res = vec.dot(2.0f, 3.0f, 1.0f, 4.0f)
    assert(res == 27.0f)
  }

  test("Dot product of two vectors") {
    val a = Vec4f(1.0f, 2.0f, 3.0f, 4.0f)
    val b = Vec4f(2.0f, 3.0f, 1.0f, 4.0f)
    val res = a dot b
    assert(res == 27.0f)
  }

  test("Length squared") {
    assert(Vec4f.One.lengthSquared == 4.0f)
  }

  test("Length") {
    assert(Vec4f.One.length == math.sqrt(4.0).toFloat)
  }

  test("Normalized vector") {
    val vec = Vec4f(0.0f, 3.0f, 0.0f, 0.0f)
    val res = vec.normalized
    val exp = Vec4f(0.0f, 1.0f, 0.0f, 0.0f)
    assert(res === exp)
  }

  test("Check if vector is normalized") {
    assert(!Vec4f.One.isNormalized)
    assert(Vec4f.One.normalized.isNormalized)
  }

  test("Limit length of a vector") {
    val a = Vec4f(6.0f, 9.0f, 18.0f, 0.0f)
    val b = a.limitLength(7.0f)
    val res = Vec4f(2.0f, 3.0f, 6.0f, 0.0f)
    assert(b === res)
  }

  test("Vector absolute value") {
    val vec = Vec4f(-1.5f, -2.1f, 3.7f, 0.0f)
    val abs = Vec4f(1.5f, 2.1f, 3.7f, 0.0f)
    assert(vec.abs == abs)
  }

  test("Vector sign") {
    val vec = Vec4f(-1.5f, 0.0f, 3.7f, 2.0f)
    val sign = Vec4f(-1.0f, 0.0f, 1.0f, 1.0f)
    assert(vec.sign == sign)
  }

  test("Vector round") {
    val vec = Vec4f(1.9f, 1.1f, 2.9f, 2.1f)
    val res = Vec4f(2.0f, 1.0f, 3.0f, 2.0f)
    assert(vec.round == res)
  }

  test("Vector ceil") {
    val vec = Vec4f(1.9f, 1.1f, 2.9f, 2.1f)
    val res = Vec4f(2.0f, 2.0f, 3.0f, 3.0f)
    assert(vec.ceil == res)
  }

  test("Vector floor") {
    val vec = Vec4f(1.9f, 1.1f, 2.9f, 2.1f)
    val res = Vec4f(1.0f, 1.0f, 2.0f, 2.0f)
    assert(vec.floor == res)
  }

  test("Move vector toward vector") {
    val vec = Vec4f.One.moveToward(Vec4f.Zero, 0.5f)
    assert(vec.length < Vec4f.One.length)
    assert(vec.length > 0.0f)
  }

  test("Linear interpolation between vectors") {
    val from = Vec4f(1.0f, 2.0f, 3.0f, 4.0f)
    val to = Vec4f(2.0f, 4.0f, 6.0f, 8.0f)
    val v1 = Vec4f(1.5f, 3.0f, 4.5f, 6.0f)
    val v2 = Vec4f(1.25f, 2.5f, 3.75f, 5.0f)
    val v3 = Vec4f(1.75f, 3.5f, 5.25f, 7.0f)
    assert(from.lerp(to, 0.5f) === v1)
    assert(from.lerp(to, 0.25f) === v2)
    assert(from.lerp(to, 0.75f) === v3)
  }

  test("Direction to a vector") {
    val from = Vec4f.Zero
    val to = Vec4f(0.0f, 0.0f, 10.0f, 0.0f)
    val res = Vec4f(0.0f, 0.0f, 1.0f, 0.0f)
    assert(from.directionTo(to) === res)
  }

  test("Direction to values") {
    val from = Vec4f.Zero
    val dir = from.directionTo(0.0f, 0.0f, 10.0f, 0.0f)
    val res = Vec4f(0.0f, 0.0f, 1.0f, 0.0f)
    assert(dir === res)
  }

  test("Distance squared between two vectors") {
    val a = Vec4f(-1.0f, 1.0f, -1.0f, 2.0f)
    val b = Vec4f(1.0f, 1.0f, 1.0f, 0.0f)
    assert(a.distanceSquaredTo(b) == 12.0f)
  }

  test("Distance squared between a vector and values") {
    val a = Vec4f(-1.0f, 1.0f, -1.0f, 2.0f)
    val dist = a.distanceSquaredTo(1.0f, 1.0f, 1.0f, 0.0f)
    assert(dist == 12.0f)
  }

  test("Distance between two vectors") {
    val a = Vec4f(-1.0f, 1.0f, -1.0f, 2.0f)
    val b = Vec4f(1.0f, 1.0f, 1.0f, 0.0f)
    assert(a.distanceTo(b) == math.sqrt(12.0).toFloat)
  }

  test("Distance between a vector and values") {
    val a = Vec4f(-1.0f, 1.0f, -1.0f, 2.0f)
    val dist = a.distanceTo(1.0f, 1.0f, 1.0f, 0.0f)
    assert(dist == math.sqrt(12.0).toFloat)
  }

  test("Angle between two vectors") {
    val a = Vec4f(1.0f, 0.0f, 1.0f, 0.0f)
    val b = Vec4f(0.0f, 2.0f, 0.0f, 0.0f)
    assert(a.angleTo(b) == math.Pi / 2.0)
  }

  test("Angle to values") {
    val vec = Vec4f(1.0f, 0.0f, 1.0f, 0.0f)
    val angle = vec.angleTo(0.0f, 2.0f, 0.0f, 0.0f)
    assert(angle == math.Pi / 2.0)
  }

  test("Project a vector onto a vector") {
    val v = Vec4f(2.0f, 2.0f, 1.0f, 0.0f)
    val n = Vec4f(0.0f, 1.0f, 0.0f, 0.0f)
    val res = Vec4f(0.0f, 2.0f, 0.0f, 0.0f)
    assert(v.project(n) === res)
  }

  test("Project a vector onto a values") {
    val vec = Vec4f(2.0f, 2.0f, 1.0f, 0.0f)
    val proj = vec.project(0.0f, 1.0f, 0.0f, 0.0f)
    val res = Vec4f(0.0f, 2.0f, 0.0f, 0.0f)
    assert(proj === res)
  }

  test("Reflect a vector by a vector") {
    val v = Vec4f(1.0f, 2.0f, 3.0f, 0.0f)
    val n = Vec4f(0.0f, 1.0f, 0.0f, 0.0f)
    val res = Vec4f(1.0f, -2.0f, 3.0f, 0.0f)
    assert(v.reflect(n) === res)
  }

  test("Reflect a vector by a values") {
    val vec = Vec4f(1.0f, 2.0f, 3.0f, 0.0f)
    val ref = vec.reflect(0.0f, 1.0f, 0.0f, 0.0f)
    val res = Vec4f(1.0f, -2.0f, 3.0f, 0.0f)
    assert(ref === res)
  }

  test("Bounce a vector by a vector") {
    val v = Vec4f(1.0f, 2.0f, 3.0f, 0.0f)
    val n = Vec4f(0.0f, 1.0f, 0.0f, 0.0f)
    val res = Vec4f(-1.0f, 2.0f, -3.0f, 0.0f)
    assert(v.bounce(n) === res)
  }

  test("Bounce a vector by a values") {
    val vec = Vec4f(1.0f, 2.0f, 3.0f, 0.0f)
    val bounce = vec.bounce(0.0f, 1.0f, 0.0f, 0.0f)
    val res = Vec4f(-1.0f, 2.0f, -3.0f, 0.0f)
    assert(bounce === res)
  }

  test("Slide a vector on another vector") {
    val a = Vec4f(1.0f, 1.0f, 0.0f, 0.0f)
    val b = Vec4f(0.0f, 1.0f, 0.0f, 0.0f)
    val res = Vec4f(1.0f, 0.0f, 0.0f, 0.0f)
    assert(a.slide(b) === res)
  }

  test("Slide a vector on values") {
    val vec = Vec4f(1.0f, 1.0f, 0.0f, 0.0f)
    val slide = vec.slide(0.0f, 1.0f, 0.0f, 0.0f)
    val res = Vec4f(1.0f, 0.0f, 0.0f, 0.0f)
    assert(slide === res)
  }

  test("Component-wise mod between vector and values") {
    val vec = Vec4f(1.0f, 3.0f, 8.0f, 8.0f)
    val mod = vec % (2.0f, 2.0f, 3.0f, 4.0f)
    val res = Vec4f(1.0f, 1.0f, 2.0f, 0.0f)
    assert(mod === res)
  }

  test("Component-wise mod between two vectors") {
    val a = Vec4f(1.0f, 3.0f, 8.0f, 8.0f)
    val b = Vec4f(2.0f, 2.0f, 3.0f, 4.0f)
    val res = Vec4f(1.0f, 1.0f, 2.0f, 0.0f)
    assert(a % b === res)
  }

  test("Vector mod with single value") {
    val vec = Vec4f(1.0f, 3.0f, 8.0f, 9.0f)
    val mod = vec % 3.0f
    val res = Vec4f(1.0f, 0.0f, 2.0f, 0.0f)
    assert(mod === res)
  }

  test("Outer product with four values") {
    val vec = Vec4f(1.0f, 2.0f, 3.0f, 4.0f)
    val outer = vec.outer(2.0f, 3.0f, 4.0f, 5.0f)
    val res = Mat4f(2.0f, 3.0f, 4.0f, 5.0f, 4.0f, 6.0f, 8.0f, 10.0f, 6.0f, 9.0f, 12.0f, 15.0f, 8.0f, 12.0f, 16.0f, 20.0f)
    assert(outer == res)
  }

  test("Outer product with a 4D vector") {
    val a = Vec4f(1.0f, 2.0f, 3.0f, 4.0f)
    val b = Vec4f(2.0f, 3.0f, 4.0f, 5.0f)
    val res = Mat4f(2.0f, 3.0f, 4.0f, 5.0f, 4.0f, 6.0f, 8.0f, 10.0f, 6.0f, 9.0f, 12.0f, 15.0f, 8.0f, 12.0f, 16.0f, 20.0f)
    assert(a.outer(b) == res)
  }

  test("Vector equals four values") {
    val vec = Vec4f(1.1f, 2.2f, 3.3f, 4.4f)
    assert(vec == (1.1f, 2.2f, 3.3f, 4.4f))
  }

  test("Vector equals approximately three value") {
    val vec = Vec4f(1.0f, 2.0f, 3.0f, 4.0f)
    assert(vec ~= (0.99999999f, 1.99999999f, 3.00000001f, 3.99999999f))
  }

  test("Vector equals approximately a vector") {
    val a = Vec4f(1.0f, 2.0f, 3.0f, 4.0f)
    val b = Vec4f(0.99999999f, 1.99999999f, 3.00000001f, 3.99999999f)
    assert(a ~= b)
  }

  test("Access components with apply") {
    val vec = Vec4f(1.1f, 2.2f, 3.3f, 4.4f)
    assert(vec(0) == 1.1f)
    assert(vec(1) == 2.2f)
    assert(vec(2) == 3.3f)
    assert(vec(3) == 4.4f)
    assertThrows[scala.MatchError] {vec(4)}
  }
}
