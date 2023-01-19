package vecmatlib.vector

import org.scalatest.funsuite.AnyFunSuite

class Vec3iSuite extends AnyFunSuite {

  test("Sum of a vector and three values") {
    val vec = Vec3i(1, 2, 3)
    val res = vec + (2, 3, 1)
    assert(res == Vec3i(3, 5, 4))
  }

  test("Sum of two vectors") {
    val a = Vec3i(1, 2, 3)
    val b = Vec3i(2, 3, 1)
    assert(a + b == Vec3i(3, 5, 4))
  }

  test("Additive inverse") {
    val a = Vec3i(2, 3, 4)
    assert(-a == Vec3i(-2, -3, -4))
  }

  test("Subtraction of three values from a vector") {
    val vec = Vec3i(3, 5, 4)
    val res = vec - (2, 3, 1)
    assert(res == Vec3i(1, 2, 3))
  }

  test("Subtraction of two vectors") {
    val a = Vec3i(3, 5, 4)
    val b = Vec3i(2, 3, 1)
    assert(a - b == Vec3i(1, 2, 3))
  }

  test("Vector multiplied by a scalar") {
    val vec = Vec3i(1, 2, 3)
    val res = vec * 2
    assert(res == Vec3i(2, 4, 6))
  }

  test("Vector divided by a scalar") {
    val vec = Vec3i(1, 2, 3)
    val res = vec / 2
    assert(res == Vec3i(0, 1, 1))
  }

  test("Component-wise multiplication of a vector and three values") {
    val vec = Vec3i(2, 3, 4)
    val res = vec * (3, 4, 2)
    assert(res == Vec3i(6, 12, 8))
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec3i(2, 3, 4)
    val b = Vec3i(3, 4, 2)
    assert(a * b == Vec3i(6, 12, 8))
  }

  test("Dot product with three values") {
    val vec = Vec3i(1, 2, 3)
    val res = vec.dot(2, 3, 1)
    assert(res == 11)
  }

  test("Dot product of two vectors") {
    val a = Vec3i(1, 2, 3)
    val b = Vec3i(2, 3, 1)
    assert((a dot b) == 11)
  }

  test("Cross product with three values") {
    val vec = Vec3i.Right
    val res = vec.cross(0, 1, 0)
    assert(res == Vec3i.Forward)
  }

  test("Cross product of two vectors") {
    val a = Vec3i.Right
    val b = Vec3i.Up
    assert((a cross b) == Vec3i.Forward)
  }

  test("Length squared") {
    assert(Vec3i.One.lengthSquared == 3)
  }

  test("Length") {
    assert(Vec3i.One.length == math.sqrt(3))
  }

  test("Angle between two vectors") {
    val a = Vec3i.Up
    val b = Vec3i.Right
    assert(a.angle(b) == math.Pi / 2.0)
  }

  test("Angle between a vector and three values") {
    val vec = Vec3i.Right
    assert(vec.angle(0.0, 1.0, 0.0) == math.Pi / 2.0)
  }

  test("Vector absolute value") {
    val vec = Vec3i(-1, -2, 3)
    assert(vec.abs == Vec3i(1, 2, 3))
  }

  test("Distance squared to three values") {
    val vec = Vec3i.Zero
    assert(vec.distanceSquaredTo(2, 2, 2) == 12)
  }

  test("Distance squared to vector") {
    val a = Vec3i.Zero
    val b = Vec3i.One * 2
    assert(a.distanceSquaredTo(b) == 12)
  }

  test("Distance to three values") {
    val vec = Vec3i.Zero
    assert(vec.distanceTo(2, 2, 2) == 2.0 * math.sqrt(3))
  }

  test("Distance to vector") {
    val a = Vec3i.Zero
    val b = Vec3i.One * 2
    assert(a.distanceTo(b) == 2.0 * math.sqrt(3))
  }

  test("Vector reflected by three values") {
    val vec = Vec3i(1, -1, 0)
    val res = vec.reflect(0, 1, 0)
    assert(res == Vec3i(1, 1, 0))
  }

  test("Vector reflected by another vector") {
    val a = Vec3i(1, -1, 0)
    val b = Vec3i(0, 1, 0)
    assert(a.reflect(b) == Vec3i(1, 1, 0))
  }

  test("Vector bounce by three values") {
    val vec = Vec3i(1, -1, 0)
    val res = vec.bounce(0, 1, 0)
    assert(res == Vec3i(-1, -1, 0))
  }

  test("Vector bounce by vector") {
    val a = Vec3i(1, -1, 0)
    val b = Vec3i(0, 1, 0)
    assert(a.bounce(b) == Vec3i(-1, -1, 0))
  }

  test("Vector projected on three values") {
    val vec = Vec3i(2, 1, 0)
    val res = vec.project(1, 0, 0)
    assert(res == Vec3i(2, 0, 0))
  }

  test("Vector projected on another vector") {
    val a = Vec3i(2, 1, 0)
    val b = Vec3i(1, 0, 0)
    assert(a.project(b) == Vec3i(2, 0, 0))
  }

  test("Vector slide on three values") {
    val vec = Vec3i(1, 1, 0)
    val res = vec.slide(0, 1, 0)
    assert(res == Vec3i(1, 0, 0))
  }

  test("Vector slide on vector") {
    val a = Vec3i(1, 1, 0)
    val b = Vec3i(0, 1, 0)
    assert(a.slide(b) == Vec3i(1, 0, 0))
  }
}
