package vecmatlib.vector

import org.scalatest.funsuite.AnyFunSuite

class Vec2dSuite extends AnyFunSuite {

  test("Sum of a vector and three values") {
    val vec = Vec2d(1.0, 2.0)
    val res = vec + (2.0, 3.0)
    assert(res == Vec2d(3.0, 5.0))
  }

  test("Sum of two vectors") {
    val a = Vec2d(1.0, 2.0)
    val b = Vec2d(2.0, 3.0)
    assert(a + b == Vec2d(3.0, 5.0))
  }

  test("Additive inverse") {
    val a = Vec2d(2.0, 3.0)
    assert(-a == Vec2d(-2.0, -3.0))
  }

  test("Subtraction of three values from a vector") {
    val vec = Vec2d(3.0, 5.0)
    val res = vec - (2.0, 3.0)
    assert(res == Vec2d(1.0, 2.0))
  }

  test("Subtraction of two vectors") {
    val a = Vec2d(3.0, 5.0)
    val b = Vec2d(2.0, 3.0)
    assert(a - b == Vec2d(1.0, 2.0))
  }

  test("Vector multiplied by a scalar") {
    val vec = Vec2d(1.0, 2.0)
    val res = vec * 1.5
    assert(res == Vec2d(1.5, 3.0))
  }

  test("Vector divided by a scalar") {
    val vec = Vec2d(1.0, 2.0)
    val res = vec / 2.0
    assert(res == Vec2d(0.5, 1.0))
  }

  test("Component-wise multiplication of a vector and three values") {
    val vec = Vec2d(2.0, 3.0)
    val res = vec * (3.0, 4.0)
    assert(res == Vec2d(6.0, 12.0))
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec2d(2.0, 3.0)
    val b = Vec2d(3.0, 4.0)
    assert(a * b == Vec2d(6.0, 12.0))
  }

  test("Dot product with three values") {
    val vec = Vec2d(1.0, 2.0)
    val res = vec.dot(2.0, 3.0)
    assert(res == 8.0)
  }

  test("Dot product of two vectors") {
    val a = Vec2d(1.0, 2.0)
    val b = Vec2d(2.0, 3.0)
    assert((a dot b) == 8.0)
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
    assert(res == Vec2d(0.0, 1.0))
  }

  test("Angle between two vectors") {
    val a = Vec2d.Up
    val b = Vec2d.Right
    assert(a.angle(b) == math.Pi / 2.0)
  }

  test("Angle between a vector and two values") {
    val vec = Vec2d.Right
    assert(vec.angle(0.0, 1.0) == math.Pi / 2.0)
  }

  test("Inverse of a vector") {
    val vec = Vec2d(2.0, 4.0)
    assert(vec.inverse == Vec2d(0.5, 0.25))
  }

  test("Component-wise division of two vectors") {
    val a = Vec2d(4.0, 8.0)
    val b = Vec2d(2.0, 2.0)
    assert(a / b == Vec2d(2.0, 4.0))
  }

  test("Component-wise division of a vector and two values") {
    val vec = Vec2d(4.0, 8.0)
    assert(vec / (2.0, 2.0) == Vec2d(2.0, 4.0))
  }

  test("Vector absolute value") {
    val vec = Vec2d(-1.5, -2.1)
    assert(vec.abs == Vec2d(1.5, 2.1))
  }

  test("Direction to vector") {
    val a = Vec2d.Zero
    val b = Vec2d(0.0, 10.0)
    assert(a.directionTo(b) == Vec2d.Up)
  }

  test("Distance squared to three values") {
    val vec = Vec2d.Zero
    assert(vec.distanceSquaredTo(2.0, 2.0) == 8.0)
  }

  test("Distance squared to vector") {
    val a = Vec2d.Zero
    val b = Vec2d.One * 2
    assert(a.distanceSquaredTo(b) == 8.0)
  }

  test("Distance to three values") {
    val vec = Vec2d.Zero
    assert(vec.distanceTo(2.0, 2.0) == 2.0 * math.sqrt(2))
  }

  test("Distance to vector") {
    val a = Vec2d.Zero
    val b = Vec2d.One * 2.0
    assert(a.distanceTo(b) == 2.0 * math.sqrt(2))
  }

  test("Vector reflected by three values") {
    val vec = Vec2d(1.0, -1.0)
    val res = vec.reflect(0.0, 1.0)
    assert(res == Vec2d(1.0, 1.0))
  }

  test("Vector reflected by another vector") {
    val a = Vec2d(1.0, -1.0)
    val b = Vec2d(0.0, 1.0)
    assert(a.reflect(b) == Vec2d(1.0, 1.0))
  }

  test("Vector bounce by three values") {
    val vec = Vec2d(1.0, -1.0)
    val res = vec.bounce(0.0, 1.0)
    assert(res == Vec2d(-1.0, -1.0))
  }

  test("Vector bounce by vector") {
    val a = Vec2d(1.0, -1.0)
    val b = Vec2d(0.0, 1.0)
    assert(a.bounce(b) == Vec2d(-1.0, -1.0))
  }

  test("Vector projected on three values") {
    val vec = Vec2d(2.0, 1.0)
    val res = vec.project(1.0, 0.0)
    assert(res == Vec2d(2.0, 0.0))
  }

  test("Vector projected on another vector") {
    val a = Vec2d(2.0, 1.0)
    val b = Vec2d(1.0, 0.0)
    assert(a.project(b) == Vec2d(2.0, 0.0))
  }

  test("Vector slide on three values") {
    val vec = Vec2d(1.0, 1.0)
    val res = vec.slide(0.0, 1.0)
    assert(res == Vec2d(1.0, 0.0))
  }

  test("Vector slide on vector") {
    val a = Vec2d(1.0, 1.0)
    val b = Vec2d(0.0, 1.0)
    assert(a.slide(b) == Vec2d(1.0, 0.0))
  }

  test("To array") {
    val vec = Vec2d(1.1, 2.2)
    val array = Array(1.1, 2.2)
    assert(vec.toArray sameElements array)
  }
}