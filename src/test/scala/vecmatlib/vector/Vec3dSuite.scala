package vecmatlib.vector

import org.scalatest.funsuite.AnyFunSuite

class Vec3dSuite extends AnyFunSuite {

  test("Sum of a vector and three values") {
    val vec = Vec3d(1.0, 2.0, 3.0)
    val res = vec + (2.0, 3.0, 1.0)
    assert(res == Vec3d(3.0, 5.0, 4.0))
  }

  test("Sum of two vectors") {
    val a = Vec3d(1.0, 2.0, 3.0)
    val b = Vec3d(2.0, 3.0, 1.0)
    assert(a + b == Vec3d(3.0, 5.0, 4.0))
  }

  test("Additive inverse") {
    val a = Vec3d(2.0, 3.0, 4.0)
    assert(-a == Vec3d(-2.0, -3.0, -4.0))
  }

  test("Subtraction of three values from a vector") {
    val vec = Vec3d(3.0, 5.0, 4.0)
    val res = vec - (2.0, 3.0, 1.0)
    assert(res == Vec3d(1.0, 2.0, 3.0))
  }

  test("Subtraction of two vectors") {
    val a = Vec3d(3.0, 5.0, 4.0)
    val b = Vec3d(2.0, 3.0, 1.0)
    assert(a - b == Vec3d(1.0, 2.0, 3.0))
  }

  test("Vector multiplied by a scalar") {
    val vec = Vec3d(1.0, 2.0, 3.0)
    val res = vec * 1.5
    assert(res == Vec3d(1.5, 3.0, 4.5))
  }

  test("Vector divided by a scalar") {
    val vec = Vec3d(1.0, 2.0, 3.0)
    val res = vec / 2.0
    assert(res == Vec3d(0.5, 1.0, 1.5))
  }

  test("Component-wise multiplication of a vector and three values") {
    val vec = Vec3d(2.0, 3.0, 4.0)
    val res = vec * (3.0, 4.0, 2.0)
    assert(res == Vec3d(6.0, 12.0, 8.0))
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec3d(2.0, 3.0, 4.0)
    val b = Vec3d(3.0, 4.0, 2.0)
    assert(a * b == Vec3d(6.0, 12.0, 8.0))
  }

  test("Dot product with three values") {
    val vec = Vec3d(1.0, 2.0, 3.0)
    val res = vec.dot(2.0, 3.0, 1.0)
    assert(res == 11.0)
  }

  test("Dot product of two vectors") {
    val a = Vec3d(1.0, 2.0, 3.0)
    val b = Vec3d(2.0, 3.0, 1.0)
    assert((a dot b) == 11.0)
  }

  test("Cross product with three values") {
    val vec = Vec3d.Right
    val res = vec.cross(0.0, 1.0, 0.0)
    assert(res == Vec3d.Forward)
  }

  test("Cross product of two vectors") {
    val a = Vec3d.Right
    val b = Vec3d.Up
    assert((a cross b) == Vec3d.Forward)
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
    assert(res == Vec3d(0.0, 1.0, 0.0))
  }

  test("Angle between two vectors") {
    val a = Vec3d.Up
    val b = Vec3d.Right
    assert(a.angle(b) == math.Pi / 2.0)
  }

  test("Angle between a vector and three values") {
    val vec = Vec3d.Right
    assert(vec.angle(0.0, 1.0, 0.0) == math.Pi / 2.0)
  }

  test("Direction to vector") {
    val a = Vec3d.Zero
    val b = Vec3d(0.0, 0.0, 10.0)
    assert(a.directionTo(b) == Vec3d.Forward)
  }

  test("Distance squared to three values") {
    val vec = Vec3d.Zero
    assert(vec.distanceSquaredTo(2.0, 2.0, 2.0) == 12.0)
  }

  test("Distance squared to vector") {
    val a = Vec3d.Zero
    val b = Vec3d.One * 2
    assert(a.distanceSquaredTo(b) == 12.0)
  }

  test("Distance to three values") {
    val vec = Vec3d.Zero
    assert(vec.distanceTo(2.0, 2.0, 2.0) == 2.0 * math.sqrt(3))
  }

  test("Distance to vector") {
    val a = Vec3d.Zero
    val b = Vec3d.One * 2.0
    assert(a.distanceTo(b) == 2.0 * math.sqrt(3))
  }

  test("Vector reflected by three values") {
    val vec = Vec3d(1.0, -1.0, 0.0)
    val res = vec.reflect(0.0, 1.0, 0.0)
    assert(res == Vec3d(1.0, 1.0, 0.0))
  }

  test("Vector reflected by another vector") {
    val a = Vec3d(1.0, -1.0, 0.0)
    val b = Vec3d(0.0, 1.0, 0.0)
    assert(a.reflect(b) == Vec3d(1.0, 1.0, 0.0))
  }

  test("Vector bounce by three values") {
    val vec = Vec3d(1.0, -1.0, 0.0)
    val res = vec.bounce(0.0, 1.0, 0.0)
    assert(res == Vec3d(-1.0, -1.0, 0.0))
  }

  test("Vector bounce by vector") {
    val a = Vec3d(1.0, -1.0, 0.0)
    val b = Vec3d(0.0, 1.0, 0.0)
    assert(a.bounce(b) == Vec3d(-1.0, -1.0, 0.0))
  }

  test("Vector projected on three values") {
    val vec = Vec3d(2.0, 1.0, 0.0)
    val res = vec.project(1.0, 0.0, 0.0)
    assert(res == Vec3d(2.0, 0.0, 0.0))
  }

  test("Vector projected on another vector") {
    val a = Vec3d(2.0, 1.0, 0.0)
    val b = Vec3d(1.0, 0.0, 0.0)
    assert(a.project(b) == Vec3d(2.0, 0.0, 0.0))
  }

  test("Vector slide on three values") {
    val vec = Vec3d(1.0, 1.0, 0.0)
    val res = vec.slide(0.0, 1.0, 0.0)
    assert(res == Vec3d(1.0, 0.0, 0.0))
  }

  test("Vector slide on vector") {
    val a = Vec3d(1.0, 1.0, 0.0)
    val b = Vec3d(0.0, 1.0, 0.0)
    assert(a.slide(b) == Vec3d(1.0, 0.0, 0.0))
  }
}