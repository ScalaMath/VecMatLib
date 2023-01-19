package vecmatlib.vector

import org.scalatest.funsuite.AnyFunSuite

class Vec2iSuite extends AnyFunSuite {

  test("Sum of a vector and three values") {
    val vec = Vec2i(1, 2)
    val res = vec + (2, 3)
    assert(res == Vec2i(3, 5))
  }

  test("Sum of two vectors") {
    val a = Vec2i(1, 2)
    val b = Vec2i(2, 3)
    assert(a + b == Vec2i(3, 5))
  }

  test("Additive inverse") {
    val a = Vec2i(2, 3)
    assert(-a == Vec2i(-2, -3))
  }

  test("Subtraction of three values from a vector") {
    val vec = Vec2i(3, 5)
    val res = vec - (2, 3)
    assert(res == Vec2i(1, 2))
  }

  test("Subtraction of two vectors") {
    val a = Vec2i(3, 5)
    val b = Vec2i(2, 3)
    assert(a - b == Vec2i(1, 2))
  }

  test("Vector multiplied by a scalar") {
    val vec = Vec2i(1, 2)
    val res = vec * 2
    assert(res == Vec2i(2, 4))
  }

  test("Vector divided by a scalar") {
    val vec = Vec2i(1, 2)
    val res = vec / 2
    assert(res == Vec2i(0, 1))
  }

  test("Component-wise multiplication of a vector and three values") {
    val vec = Vec2i(2, 3)
    val res = vec * (3, 4)
    assert(res == Vec2i(6, 12))
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec2i(2, 3)
    val b = Vec2i(3, 4)
    assert(a * b == Vec2i(6, 12))
  }

  test("Dot product with three values") {
    val vec = Vec2i(1, 2)
    val res = vec.dot(2, 3)
    assert(res == 8)
  }

  test("Dot product of two vectors") {
    val a = Vec2i(1, 2)
    val b = Vec2i(2, 3)
    assert((a dot b) == 8)
  }

  test("Length squared") {
    assert(Vec2i.One.lengthSquared == 2)
  }

  test("Length") {
    assert(Vec2i.One.length == math.sqrt(2))
  }

  test("Angle between two vectors") {
    val a = Vec2i.Up
    val b = Vec2i.Right
    assert(a.angle(b) == math.Pi / 2.0)
  }

  test("Angle between a vector and three values") {
    val vec = Vec2i.Right
    assert(vec.angle(0.0, 1.0) == math.Pi / 2.0)
  }

  test("Vector absolute value") {
    val vec = Vec2i(-1, -2)
    assert(vec.abs == Vec2i(1, 2))
  }

  test("Distance squared to three values") {
    val vec = Vec2i.Zero
    assert(vec.distanceSquaredTo(2, 2) == 8)
  }

  test("Distance squared to vector") {
    val a = Vec2i.Zero
    val b = Vec2i.One * 2
    assert(a.distanceSquaredTo(b) == 8)
  }

  test("Distance to three values") {
    val vec = Vec2i.Zero
    assert(vec.distanceTo(2, 2) == 2.0 * math.sqrt(2))
  }

  test("Distance to vector") {
    val a = Vec2i.Zero
    val b = Vec2i.One * 2
    assert(a.distanceTo(b) == 2.0 * math.sqrt(2))
  }

  test("Vector reflected by three values") {
    val vec = Vec2i(1, -1)
    val res = vec.reflect(0, 1)
    assert(res == Vec2i(1, 1))
  }

  test("Vector reflected by another vector") {
    val a = Vec2i(1, -1)
    val b = Vec2i(0, 1)
    assert(a.reflect(b) == Vec2i(1, 1))
  }

  test("Vector bounce by three values") {
    val vec = Vec2i(1, -1)
    val res = vec.bounce(0, 1)
    assert(res == Vec2i(-1, -1))
  }

  test("Vector bounce by vector") {
    val a = Vec2i(1, -1)
    val b = Vec2i(0, 1)
    assert(a.bounce(b) == Vec2i(-1, -1))
  }

  test("Vector projected on three values") {
    val vec = Vec2i(2, 1)
    val res = vec.project(1, 0)
    assert(res == Vec2i(2, 0))
  }

  test("Vector projected on another vector") {
    val a = Vec2i(2, 1)
    val b = Vec2i(1, 0)
    assert(a.project(b) == Vec2i(2, 0))
  }

  test("Vector slide on three values") {
    val vec = Vec2i(1, 1)
    val res = vec.slide(0, 1)
    assert(res == Vec2i(1, 0))
  }

  test("Vector slide on vector") {
    val a = Vec2i(1, 1)
    val b = Vec2i(0, 1)
    assert(a.slide(b) == Vec2i(1, 0))
  }
}
