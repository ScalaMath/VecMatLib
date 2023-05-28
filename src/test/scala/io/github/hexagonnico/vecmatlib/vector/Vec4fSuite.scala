package io.github.hexagonnico.vecmatlib.vector

import org.scalatest.funsuite.AnyFunSuite

class Vec4fSuite extends AnyFunSuite {

  test("Sum of a vector and three values") {
    val vec = Vec4f(1.0f, 2.0f, 3.0f, 3.0f)
    val res = vec + (2.0f, 3.0f, 1.0f, -1.0f)
    assert(res == Vec4f(3.0f, 5.0f, 4.0f, 2.0f))
  }

  test("Sum of two vectors") {
    val a = Vec4f(1.0f, 2.0f, 3.0f, 3.0f)
    val b = Vec4f(2.0f, 3.0f, 1.0f, -1.0f)
    assert(a + b == Vec4f(3.0f, 5.0f, 4.0f, 2.0f))
  }

  test("Additive inverse") {
    val a = Vec4f(2.0f, 3.0f, 4.0f, -2.0f)
    assert(-a == Vec4f(-2.0f, -3.0f, -4.0f, 2.0f))
  }

  test("Subtraction of three values from a vector") {
    val vec = Vec4f(3.0f, 5.0f, 4.0f, 2.0f)
    val res = vec - (2.0f, 3.0f, 1.0f, 4.0f)
    assert(res == Vec4f(1.0f, 2.0f, 3.0f, -2.0f))
  }

  test("Subtraction of two vectors") {
    val a = Vec4f(3.0f, 5.0f, 4.0f, 2.0f)
    val b = Vec4f(2.0f, 3.0f, 1.0f, 4.0f)
    assert(a - b == Vec4f(1.0f, 2.0f, 3.0f, -2.0f))
  }

  test("Vector multiplied by a scalar") {
    val vec = Vec4f(1.0f, 2.0f, 3.0f, 4.0f)
    val res = vec * 1.5f
    assert(res == Vec4f(1.5f, 3.0f, 4.5f, 6.0f))
  }

  test("Vector divided by a scalar") {
    val vec = Vec4f(1.0f, 2.0f, 3.0f, 4.0f)
    val res = vec / 2.0f
    assert(res == Vec4f(0.5f, 1.0f, 1.5f, 2.0f))
  }

  test("Component-wise multiplication of a vector and three values") {
    val vec = Vec4f(2.0f, 3.0f, 4.0f, 1.0f)
    val res = vec * (3.0f, 4.0f, 2.0f, 1.0f)
    assert(res == Vec4f(6.0f, 12.0f, 8.0f, 1.0f))
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec4f(2.0f, 3.0f, 4.0f, 1.0f)
    val b = Vec4f(3.0f, 4.0f, 2.0f, 1.0f)
    assert(a * b == Vec4f(6.0f, 12.0f, 8.0f, 1.0f))
  }

  test("Dot product with three values") {
    val vec = Vec4f(1.0f, 2.0f, 3.0f, 4.0f)
    val res = vec.dot(2.0f, 3.0f, 1.0f, 4.0f)
    assert(res == 27.0f)
  }

  test("Dot product of two vectors") {
    val a = Vec4f(1.0f, 2.0f, 3.0f, 4.0f)
    val b = Vec4f(2.0f, 3.0f, 1.0f, 4.0f)
    assert((a dot b) == 27.0f)
  }

  test("Length squared") {
    assert(Vec4f.One.lengthSquared == 4.0f)
  }

  test("Length") {
    assert(Vec4f.One.length == math.sqrt(4))
  }

  test("Normalized vector") {
    val vec = Vec4f(0.0f, 3.0f, 0.0f, 0.0f)
    val res = vec.normalized
    assert(res == Vec4f(0.0f, 1.0f, 0.0f, 0.0f))
  }

  test("Angle between two vectors") {
    val a = Vec4f(0.0f, 0.0f, 1.0f, 0.0f)
    val b = Vec4f(0.0f, 1.0f, 0.0f, 0.0f)
    assert(a.angle(b) == math.Pi / 2.0)
  }

  test("Angle between a vector and four values") {
    val vec = Vec4f(0.0f, 0.0f, 1.0f, 0.0f)
    assert(vec.angle(0.0, 1.0, 0.0, 0.0) == math.Pi / 2.0)
  }

  test("Inverse of a vector") {
    val vec = Vec4f(2.0f, 4.0f, 5.0f, 1.0f)
    assert(vec.inverse == Vec4f(0.5f, 0.25f, 0.2f, 1.0f))
  }

  test("Component-wise division of two vectors") {
    val a = Vec4f(4.0f, 8.0f, 6.0f, 1.0f)
    val b = Vec4f(2.0f, 2.0f, 3.0f, 2.0f)
    assert(a / b == Vec4f(2.0f, 4.0f, 2.0f, 0.5f))
  }

  test("Component-wise division of a vector and four values") {
    val vec = Vec4f(4.0f, 8.0f, 6.0f, 1.0f)
    assert(vec / (2.0f, 2.0f, 3.0f, 2.0f) == Vec4f(2.0f, 4.0f, 2.0f, 0.5f))
  }

  test("Vector absolute value") {
    val vec = Vec4f(-1.5f, -2.1f, 3.7f, -4.0f)
    assert(vec.abs == Vec4f(1.5f, 2.1f, 3.7f, 4.0f))
  }

  test("Direction to vector") {
    val a = Vec4f.Zero
    val b = Vec4f(0.0f, 0.0f, 10.0f, 0.0f)
    assert(a.directionTo(b) == Vec4f(0.0f, 0.0f, 1.0f, 0.0f))
  }

  test("Distance squared to three values") {
    val vec = Vec4f.Zero
    assert(vec.distanceSquaredTo(2.0f, 2.0f, 2.0f, 2.0f) == 16.0f)
  }

  test("Distance squared to vector") {
    val a = Vec4f.Zero
    val b = Vec4f.One * 2
    assert(a.distanceSquaredTo(b) == 16.0f)
  }

  test("Distance to three values") {
    val vec = Vec4f.Zero
    assert(vec.distanceTo(2.0f, 2.0f, 2.0f, 2.0f) == 2.0 * math.sqrt(4))
  }

  test("Distance to vector") {
    val a = Vec4f.Zero
    val b = Vec4f.One * 2.0f
    assert(a.distanceTo(b) == 2.0 * math.sqrt(4))
  }

  test("Vector reflected by three values") {
    val vec = Vec4f(1.0f, -1.0f, 0.0f, 0.0f)
    val res = vec.reflect(0.0f, 1.0f, 0.0f, 0.0f)
    assert(res == Vec4f(1.0f, 1.0f, 0.0f, 0.0f))
  }

  test("Vector reflected by another vector") {
    val a = Vec4f(1.0f, -1.0f, 0.0f, 0.0f)
    val b = Vec4f(0.0f, 1.0f, 0.0f, 0.0f)
    assert(a.reflect(b) == Vec4f(1.0f, 1.0f, 0.0f, 0.0f))
  }

  test("Vector bounce by three values") {
    val vec = Vec4f(1.0f, -1.0f, 0.0f, 0.0f)
    val res = vec.bounce(0.0f, 1.0f, 0.0f, 0.0f)
    assert(res == Vec4f(-1.0f, -1.0f, 0.0f, 0.0f))
  }

  test("Vector bounce by vector") {
    val a = Vec4f(1.0f, -1.0f, 0.0f, 0.0f)
    val b = Vec4f(0.0f, 1.0f, 0.0f, 0.0f)
    assert(a.bounce(b) == Vec4f(-1.0f, -1.0f, 0.0f, 0.0f))
  }

  test("Vector projected on three values") {
    val vec = Vec4f(2.0f, 1.0f, 0.0f, 0.0f)
    val res = vec.project(1.0f, 0.0f, 0.0f, 0.0f)
    assert(res == Vec4f(2.0f, 0.0f, 0.0f, 0.0f))
  }

  test("Vector projected on another vector") {
    val a = Vec4f(2.0f, 1.0f, 0.0f, 0.0f)
    val b = Vec4f(1.0f, 0.0f, 0.0f, 0.0f)
    assert(a.project(b) == Vec4f(2.0f, 0.0f, 0.0f, 0.0f))
  }

  test("Vector slide on three values") {
    val vec = Vec4f(1.0f, 1.0f, 0.0f, 0.0f)
    val res = vec.slide(0.0f, 1.0f, 0.0f, 0.0f)
    assert(res == Vec4f(1.0f, 0.0f, 0.0f, 0.0f))
  }

  test("Vector slide on vector") {
    val a = Vec4f(1.0f, 1.0f, 0.0f, 0.0f)
    val b = Vec4f(0.0f, 1.0f, 0.0f, 0.0f)
    assert(a.slide(b) == Vec4f(1.0f, 0.0f, 0.0f, 0.0f))
  }

  test("To array") {
    val vec = Vec4f(1.1f, 2.2f, 3.3f, 4.4f)
    val array = Array(1.1f, 2.2f, 3.3f, 4.4f)
    assert(vec.toArray sameElements array)
  }
}