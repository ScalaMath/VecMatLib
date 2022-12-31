package vecmatlib.vector

import org.scalatest.funsuite.AnyFunSuite

class Vec2dSuite extends AnyFunSuite {

  test("Test plus 1") {
    val vec = Vec2d(1.0, 2.0)
    val res = vec + (2.0, 3.0)
    assert(res == Vec2d(3.0, 5.0))
  }

  test("Test plus 2") {
    val a = Vec2d(1.0, 2.0)
    val b = Vec2i(2, 3)
    assert(a + b == Vec2d(3.0, 5.0))
  }

  test("Test plus 3") {
    val a = Vec2d(1.0, 2.0)
    val b = Vec2f(2.0f, 3.0f)
    assert(a + b == Vec2d(3.0, 5.0))
  }

  test("Test plus 4") {
    val a = Vec2d(1.0, 2.0)
    val b = Vec2d(2.0, 3.0)
    assert(a + b == Vec2d(3.0, 5.0))
  }

  test("Test negated") {
    val a = Vec2d(2.0, 3.0)
    assert(-a == Vec2d(-2.0, -3.0))
  }

  test("Test minus 1") {
    val vec = Vec2d(3.0, 5.0)
    val res = vec - (2.0, 3.0)
    assert(res == Vec2d(1.0, 2.0))
  }

  test("Test minus 2") {
    val a = Vec2d(3.0, 5.0)
    val b = Vec2i(2, 3)
    assert(a - b == Vec2d(1.0, 2.0))
  }

  test("Test minus 3") {
    val a = Vec2d(3.0, 5.0)
    val b = Vec2f(2.0f, 3.0f)
    assert(a - b == Vec2d(1.0, 2.0))
  }

  test("Test minus 4") {
    val a = Vec2d(3.0, 5.0)
    val b = Vec2d(2.0, 3.0)
    assert(a - b == Vec2d(1.0, 2.0))
  }

  test("Test multipliedBy") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec * 1.5
    assert(res == Vec2d(1.5, 3.0))
  }

  test("Test dividedBy") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec / 2.0
    assert(res == Vec2d(0.5, 1.0))
  }

  test("Test multiply 1") {
    val vec = Vec2d(2.0, 3.0)
    val res = vec * (3.0, 4.0)
    assert(res == Vec2d(6.0, 12.0))
  }

  test("Test multiply 2") {
    val a = Vec2d(2.0, 3.0)
    val b = Vec2i(3, 4)
    assert(a * b == Vec2d(6.0, 12.0))
  }

  test("Test multiply 3") {
    val a = Vec2d(2.0, 3.0)
    val b = Vec2f(3.0f, 4.0f)
    assert(a * b == Vec2d(6.0, 12.0))
  }

  test("Test multiply 4") {
    val a = Vec2d(2.0, 3.0)
    val b = Vec2d(3.0, 4.0)
    assert(a * b == Vec2d(6.0, 12.0))
  }

  test("Test dot 1") {
    val vec = Vec2d(1.0, 2.0)
    val res = vec dot(2.0, 3.0)
    assert(res == 8)
  }

  test("Test dot 2") {
    val a = Vec2d(1.0, 2.0)
    val b = Vec2i(2, 3)
    assert((a dot b) == 8)
  }

  test("Test dot 3") {
    val a = Vec2d(1.0, 2.0)
    val b = Vec2f(2.0f, 3.0f)
    assert((a dot b) == 8)
  }

  test("Test dot 4") {
    val a = Vec2d(1.0, 2.0)
    val b = Vec2d(2.0, 3.0)
    assert((a dot b) == 8)
  }

  test("Test length squared") {
    assert(Vec2d.One.lengthSquared == 2.0)
  }

  test("Test length") {
    assert(Vec2d.One.length == Math.sqrt(2))
  }

  test("Test normalized") {
    val vec = Vec2d.One
    val res = vec.normalized
    assert(res == Vec2d(1.0 / Math.sqrt(2), 1.0 / Math.sqrt(2)))
  }
}
