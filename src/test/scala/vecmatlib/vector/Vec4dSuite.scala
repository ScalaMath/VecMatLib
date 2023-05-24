package vecmatlib.vector

import org.scalatest.funsuite.AnyFunSuite

class Vec4dSuite extends AnyFunSuite {

  test("Sum of a vector and three values") {
    val vec = Vec4d(1.0, 2.0, 3.0, 3.0)
    val res = vec + (2.0, 3.0, 1.0, -1.0)
    assert(res == Vec4d(3.0, 5.0, 4.0, 2.0))
  }

  test("Sum of two vectors") {
    val a = Vec4d(1.0, 2.0, 3.0, 3.0)
    val b = Vec4d(2.0, 3.0, 1.0, -1.0)
    assert(a + b == Vec4d(3.0, 5.0, 4.0, 2.0))
  }

  test("Additive inverse") {
    val a = Vec4d(2.0, 3.0, 4.0, -2.0)
    assert(-a == Vec4d(-2.0, -3.0, -4.0, 2.0))
  }

  test("Subtraction of three values from a vector") {
    val vec = Vec4d(3.0, 5.0, 4.0, 2.0)
    val res = vec - (2.0, 3.0, 1.0, 4.0)
    assert(res == Vec4d(1.0, 2.0, 3.0, -2.0))
  }

  test("Subtraction of two vectors") {
    val a = Vec4d(3.0, 5.0, 4.0, 2.0)
    val b = Vec4d(2.0, 3.0, 1.0, 4.0)
    assert(a - b == Vec4d(1.0, 2.0, 3.0, -2.0))
  }

  test("Vector multiplied by a scalar") {
    val vec = Vec4d(1.0, 2.0, 3.0, 4.0)
    val res = vec * 1.5
    assert(res == Vec4d(1.5, 3.0, 4.5, 6.0))
  }

  test("Vector divided by a scalar") {
    val vec = Vec4d(1.0, 2.0, 3.0, 4.0)
    val res = vec / 2.0
    assert(res == Vec4d(0.5, 1.0, 1.5, 2.0))
  }

  test("Component-wise multiplication of a vector and three values") {
    val vec = Vec4d(2.0, 3.0, 4.0, 1.0)
    val res = vec * (3.0, 4.0, 2.0, 1.0)
    assert(res == Vec4d(6.0, 12.0, 8.0, 1.0))
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec4d(2.0, 3.0, 4.0, 1.0)
    val b = Vec4d(3.0, 4.0, 2.0, 1.0)
    assert(a * b == Vec4d(6.0, 12.0, 8.0, 1.0))
  }

  test("Dot product with three values") {
    val vec = Vec4d(1.0, 2.0, 3.0, 4.0)
    val res = vec.dot(2.0, 3.0, 1.0, 4.0)
    assert(res == 27.0)
  }

  test("Dot product of two vectors") {
    val a = Vec4d(1.0, 2.0, 3.0, 4.0)
    val b = Vec4d(2.0, 3.0, 1.0, 4.0)
    assert((a dot b) == 27.0)
  }

  test("Length squared") {
    assert(Vec4d.One.lengthSquared == 4.0)
  }

  test("Length") {
    assert(Vec4d.One.length == math.sqrt(4))
  }

  test("Normalized vector") {
    val vec = Vec4d(0.0, 3.0, 0.0, 0.0)
    val res = vec.normalized
    assert(res == Vec4d(0.0, 1.0, 0.0, 0.0))
  }

  test("Angle between two vectors") {
    val a = Vec4d(0.0, 0.0, 1.0, 0.0)
    val b = Vec4d(0.0, 1.0, 0.0, 0.0)
    assert(a.angle(b) == math.Pi / 2.0)
  }

  test("Angle between a vector and four values") {
    val vec = Vec4d(0.0, 0.0, 1.0, 0.0)
    assert(vec.angle(0.0, 1.0, 0.0, 0.0) == math.Pi / 2.0)
  }

  test("Inverse of a vector") {
    val vec = Vec4d(2.0, 4.0, 8.0, 1.0)
    assert(vec.inverse == Vec4d(0.5f, 0.25f, 0.125f, 1.0))
  }

  test("Component-wise division of two vectors") {
    val a = Vec4d(4.0, 8.0, 6.0, 1.0)
    val b = Vec4d(2.0, 2.0, 3.0, 2.0)
    assert(a / b == Vec4d(2.0, 4.0, 2.0, 0.5f))
  }

  test("Component-wise division of a vector and four values") {
    val vec = Vec4d(4.0, 8.0, 6.0, 1.0)
    assert(vec / (2.0, 2.0, 3.0, 2.0) == Vec4d(2.0, 4.0, 2.0, 0.5f))
  }

  test("Vector absolute value") {
    val vec = Vec4d(-1.5, -2.1, 3.7, -4.0)
    assert(vec.abs == Vec4d(1.5, 2.1, 3.7, 4.0))
  }

  test("Direction to vector") {
    val a = Vec4d.Zero
    val b = Vec4d(0.0, 0.0, 10.0, 0.0)
    assert(a.directionTo(b) == Vec4d(0.0, 0.0, 1.0, 0.0))
  }

  test("Distance squared to three values") {
    val vec = Vec4d.Zero
    assert(vec.distanceSquaredTo(2.0, 2.0, 2.0, 2.0) == 16.0)
  }

  test("Distance squared to vector") {
    val a = Vec4d.Zero
    val b = Vec4d.One * 2
    assert(a.distanceSquaredTo(b) == 16.0)
  }

  test("Distance to three values") {
    val vec = Vec4d.Zero
    assert(vec.distanceTo(2.0, 2.0, 2.0, 2.0) == 2.0 * math.sqrt(4))
  }

  test("Distance to vector") {
    val a = Vec4d.Zero
    val b = Vec4d.One * 2.0
    assert(a.distanceTo(b) == 2.0 * math.sqrt(4))
  }

  test("Vector reflected by three values") {
    val vec = Vec4d(1.0, -1.0, 0.0, 0.0)
    val res = vec.reflect(0.0, 1.0, 0.0, 0.0)
    assert(res == Vec4d(1.0, 1.0, 0.0, 0.0))
  }

  test("Vector reflected by another vector") {
    val a = Vec4d(1.0, -1.0, 0.0, 0.0)
    val b = Vec4d(0.0, 1.0, 0.0, 0.0)
    assert(a.reflect(b) == Vec4d(1.0, 1.0, 0.0, 0.0))
  }

  test("Vector bounce by three values") {
    val vec = Vec4d(1.0, -1.0, 0.0, 0.0)
    val res = vec.bounce(0.0, 1.0, 0.0, 0.0)
    assert(res == Vec4d(-1.0, -1.0, 0.0, 0.0))
  }

  test("Vector bounce by vector") {
    val a = Vec4d(1.0, -1.0, 0.0, 0.0)
    val b = Vec4d(0.0, 1.0, 0.0, 0.0)
    assert(a.bounce(b) == Vec4d(-1.0, -1.0, 0.0, 0.0))
  }

  test("Vector projected on three values") {
    val vec = Vec4d(2.0, 1.0, 0.0, 0.0)
    val res = vec.project(1.0, 0.0, 0.0, 0.0)
    assert(res == Vec4d(2.0, 0.0, 0.0, 0.0))
  }

  test("Vector projected on another vector") {
    val a = Vec4d(2.0, 1.0, 0.0, 0.0)
    val b = Vec4d(1.0, 0.0, 0.0, 0.0)
    assert(a.project(b) == Vec4d(2.0, 0.0, 0.0, 0.0))
  }

  test("Vector slide on three values") {
    val vec = Vec4d(1.0, 1.0, 0.0, 0.0)
    val res = vec.slide(0.0, 1.0, 0.0, 0.0)
    assert(res == Vec4d(1.0, 0.0, 0.0, 0.0))
  }

  test("Vector slide on vector") {
    val a = Vec4d(1.0, 1.0, 0.0, 0.0)
    val b = Vec4d(0.0, 1.0, 0.0, 0.0)
    assert(a.slide(b) == Vec4d(1.0, 0.0, 0.0, 0.0))
  }

  test("To array") {
    val vec = Vec4d(1.1, 2.2, 3.3, 4.4)
    val array = Array(1.1, 2.2, 3.3, 4.4)
    assert(vec.toArray sameElements array)
  }
}