package vecmatlib.vector

import org.scalatest.funsuite.AnyFunSuite

class Vec2fSuite extends AnyFunSuite {

  test("Sum of a vector and three values") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec + (2.0f, 3.0f)
    assert(res == Vec2f(3.0f, 5.0f))
  }

  test("Sum of two vectors") {
    val a = Vec2f(1.0f, 2.0f)
    val b = Vec2f(2.0f, 3.0f)
    assert(a + b == Vec2f(3.0f, 5.0f))
  }

  test("Additive inverse") {
    val a = Vec2f(2.0f, 3.0f)
    assert(-a == Vec2f(-2.0f, -3.0f))
  }

  test("Subtraction of three values from a vector") {
    val vec = Vec2f(3.0f, 5.0f)
    val res = vec - (2.0f, 3.0f)
    assert(res == Vec2f(1.0f, 2.0f))
  }

  test("Subtraction of two vectors") {
    val a = Vec2f(3.0f, 5.0f)
    val b = Vec2f(2.0f, 3.0f)
    assert(a - b == Vec2f(1.0f, 2.0f))
  }

  test("Vector multiplied by a scalar") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec * 1.5f
    assert(res == Vec2f(1.5f, 3.0f))
  }

  test("Vector divided by a scalar") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec / 2.0f
    assert(res == Vec2f(0.5f, 1.0f))
  }

  test("Component-wise multiplication of a vector and three values") {
    val vec = Vec2f(2.0f, 3.0f)
    val res = vec * (3.0f, 4.0f)
    assert(res == Vec2f(6.0f, 12.0f))
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec2f(2.0f, 3.0f)
    val b = Vec2f(3.0f, 4.0f)
    assert(a * b == Vec2f(6.0f, 12.0f))
  }

  test("Dot product with three values") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec.dot(2.0f, 3.0f)
    assert(res == 8.0f)
  }

  test("Dot product of two vectors") {
    val a = Vec2f(1.0f, 2.0f)
    val b = Vec2f(2.0f, 3.0f)
    assert((a dot b) == 8.0f)
  }

  test("Length squared") {
    assert(Vec2f.One.lengthSquared == 2.0f)
  }

  test("Length") {
    assert(Vec2f.One.length == math.sqrt(2))
  }

  test("Normalized vector") {
    val vec = Vec2f(0.0f, 3.0f)
    val res = vec.normalized
    assert(res == Vec2f(0.0f, 1.0f))
  }

  test("Angle between two vectors") {
    val a = Vec2f.Up
    val b = Vec2f.Right
    assert(a.angle(b) == math.Pi / 2.0)
  }

  test("Angle between a vector and two values") {
    val vec = Vec2f.Right
    assert(vec.angle(0.0, 1.0) == math.Pi / 2.0)
  }

  test("Inverse of a vector") {
    val vec = Vec2f(2.0f, 4.0f)
    assert(vec.inverse == Vec2f(0.5f, 0.25f))
  }

  test("Component-wise division of two vectors") {
    val a = Vec2f(4.0f, 8.0f)
    val b = Vec2f(2.0f, 2.0f)
    assert(a / b == Vec2f(2.0f, 4.0f))
  }

  test("Component-wise division of a vector and two values") {
    val vec = Vec2f(4.0f, 8.0f)
    assert(vec / (2.0f, 2.0f) == Vec2f(2.0f, 4.0f))
  }

  test("Vector absolute value") {
    val vec = Vec2f(-1.5f, -2.1f)
    assert(vec.abs == Vec2f(1.5f, 2.1f))
  }

  test("Direction to vector") {
    val a = Vec2f.Zero
    val b = Vec2f(0.0f, 10.0f)
    assert(a.directionTo(b) == Vec2f.Up)
  }

  test("Distance squared to three values") {
    val vec = Vec2f.Zero
    assert(vec.distanceSquaredTo(2.0f, 2.0f) == 8.0f)
  }

  test("Distance squared to vector") {
    val a = Vec2f.Zero
    val b = Vec2f.One * 2
    assert(a.distanceSquaredTo(b) == 8.0f)
  }

  test("Distance to three values") {
    val vec = Vec2f.Zero
    assert(vec.distanceTo(2.0f, 2.0f) == 2.0 * math.sqrt(2))
  }

  test("Distance to vector") {
    val a = Vec2f.Zero
    val b = Vec2f.One * 2.0f
    assert(a.distanceTo(b) == 2.0 * math.sqrt(2))
  }

  test("Vector reflected by three values") {
    val vec = Vec2f(1.0f, -1.0f)
    val res = vec.reflect(0.0f, 1.0f)
    assert(res == Vec2f(1.0f, 1.0f))
  }

  test("Vector reflected by another vector") {
    val a = Vec2f(1.0f, -1.0f)
    val b = Vec2f(0.0f, 1.0f)
    assert(a.reflect(b) == Vec2f(1.0f, 1.0f))
  }

  test("Vector bounce by three values") {
    val vec = Vec2f(1.0f, -1.0f)
    val res = vec.bounce(0.0f, 1.0f)
    assert(res == Vec2f(-1.0f, -1.0f))
  }

  test("Vector bounce by vector") {
    val a = Vec2f(1.0f, -1.0f)
    val b = Vec2f(0.0f, 1.0f)
    assert(a.bounce(b) == Vec2f(-1.0f, -1.0f))
  }

  test("Vector projected on three values") {
    val vec = Vec2f(2.0f, 1.0f)
    val res = vec.project(1.0f, 0.0f)
    assert(res == Vec2f(2.0f, 0.0f))
  }

  test("Vector projected on another vector") {
    val a = Vec2f(2.0f, 1.0f)
    val b = Vec2f(1.0f, 0.0f)
    assert(a.project(b) == Vec2f(2.0f, 0.0f))
  }

  test("Vector slide on three values") {
    val vec = Vec2f(1.0f, 1.0f)
    val res = vec.slide(0.0f, 1.0f)
    assert(res == Vec2f(1.0f, 0.0f))
  }

  test("Vector slide on vector") {
    val a = Vec2f(1.0f, 1.0f)
    val b = Vec2f(0.0f, 1.0f)
    assert(a.slide(b) == Vec2f(1.0f, 0.0f))
  }

  test("To array") {
    val vec = Vec2f(1.1f, 2.2f)
    val array = Array(1.1f, 2.2f)
    assert(vec.toArray sameElements array)
  }
}