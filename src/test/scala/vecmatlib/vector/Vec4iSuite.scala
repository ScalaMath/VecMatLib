package vecmatlib.vector

import org.scalatest.funsuite.AnyFunSuite

class Vec4iSuite extends AnyFunSuite {

  test("Sum of a vector and three values") {
    val vec = Vec4i(1, 2, 3, 3)
    val res = vec + (2, 3, 1, -1)
    assert(res == Vec4i(3, 5, 4, 2))
  }

  test("Sum of two vectors") {
    val a = Vec4i(1, 2, 3, 3)
    val b = Vec4i(2, 3, 1, -1)
    assert(a + b == Vec4i(3, 5, 4, 2))
  }

  test("Additive inverse") {
    val a = Vec4i(2, 3, 4, -2)
    assert(-a == Vec4i(-2, -3, -4, 2))
  }

  test("Subtraction of three values from a vector") {
    val vec = Vec4i(3, 5, 4, 2)
    val res = vec - (2, 3, 1, 4)
    assert(res == Vec4i(1, 2, 3, -2))
  }

  test("Subtraction of two vectors") {
    val a = Vec4i(3, 5, 4, 2)
    val b = Vec4i(2, 3, 1, 4)
    assert(a - b == Vec4i(1, 2, 3, -2))
  }

  test("Vector multiplied by a scalar") {
    val vec = Vec4i(1, 2, 3, 4)
    val res = vec * 2
    assert(res == Vec4i(2, 4, 6, 8))
  }

  test("Vector divided by a scalar") {
    val vec = Vec4i(1, 2, 3, 4)
    val res = vec / 2
    assert(res == Vec4i(0, 1, 1, 2))
  }

  test("Component-wise multiplication of a vector and three values") {
    val vec = Vec4i(2, 3, 4, 1)
    val res = vec * (3, 4, 2, 1)
    assert(res == Vec4i(6, 12, 8, 1))
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec4i(2, 3, 4, 1)
    val b = Vec4i(3, 4, 2, 1)
    assert(a * b == Vec4i(6, 12, 8, 1))
  }

  test("Dot product with three values") {
    val vec = Vec4i(1, 2, 3, 4)
    val res = vec.dot(2, 3, 1, 4)
    assert(res == 27)
  }

  test("Dot product of two vectors") {
    val a = Vec4i(1, 2, 3, 4)
    val b = Vec4i(2, 3, 1, 4)
    assert((a dot b) == 27)
  }

  test("Length squared") {
    assert(Vec4i.One.lengthSquared == 4)
  }

  test("Length") {
    assert(Vec4i.One.length == math.sqrt(4))
  }

  test("Angle between two vectors") {
    val a = Vec4i(0, 0, 1, 0)
    val b = Vec4i(0, 1, 0, 0)
    assert(a.angle(b) == math.Pi / 2)
  }

  test("Angle between a vector and three values") {
    val vec = Vec4i(0, 0, 1, 0)
    assert(vec.angle(0, 1, 0, 0) == math.Pi / 2)
  }

  test("Vector absolute value") {
    val vec = Vec4i(-1, -2, 3, -4)
    assert(vec.abs == Vec4i(1, 2, 3, 4))
  }

  test("Distance squared to three values") {
    val vec = Vec4i.Zero
    assert(vec.distanceSquaredTo(2, 2, 2, 2) == 16)
  }

  test("Distance squared to vector") {
    val a = Vec4i.Zero
    val b = Vec4i.One * 2
    assert(a.distanceSquaredTo(b) == 16)
  }

  test("Distance to three values") {
    val vec = Vec4i.Zero
    assert(vec.distanceTo(2, 2, 2, 2) == 2 * math.sqrt(4))
  }

  test("Distance to vector") {
    val a = Vec4i.Zero
    val b = Vec4i.One * 2
    assert(a.distanceTo(b) == 2 * math.sqrt(4))
  }

  test("Vector reflected by three values") {
    val vec = Vec4i(1, -1, 0, 0)
    val res = vec.reflect(0, 1, 0, 0)
    assert(res == Vec4i(1, 1, 0, 0))
  }

  test("Vector reflected by another vector") {
    val a = Vec4i(1, -1, 0, 0)
    val b = Vec4i(0, 1, 0, 0)
    assert(a.reflect(b) == Vec4i(1, 1, 0, 0))
  }

  test("Vector bounce by three values") {
    val vec = Vec4i(1, -1, 0, 0)
    val res = vec.bounce(0, 1, 0, 0)
    assert(res == Vec4i(-1, -1, 0, 0))
  }

  test("Vector bounce by vector") {
    val a = Vec4i(1, -1, 0, 0)
    val b = Vec4i(0, 1, 0, 0)
    assert(a.bounce(b) == Vec4i(-1, -1, 0, 0))
  }

  test("Vector projected on three values") {
    val vec = Vec4i(2, 1, 0, 0)
    val res = vec.project(1, 0, 0, 0)
    assert(res == Vec4i(2, 0, 0, 0))
  }

  test("Vector projected on another vector") {
    val a = Vec4i(2, 1, 0, 0)
    val b = Vec4i(1, 0, 0, 0)
    assert(a.project(b) == Vec4i(2, 0, 0, 0))
  }

  test("Vector slide on three values") {
    val vec = Vec4i(1, 1, 0, 0)
    val res = vec.slide(0, 1, 0, 0)
    assert(res == Vec4i(1, 0, 0, 0))
  }

  test("Vector slide on vector") {
    val a = Vec4i(1, 1, 0, 0)
    val b = Vec4i(0, 1, 0, 0)
    assert(a.slide(b) == Vec4i(1, 0, 0, 0))
  }
}