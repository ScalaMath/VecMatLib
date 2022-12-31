package vecmatlib.vector

import org.scalatest.funsuite.AnyFunSuite

class Vec2fSuite extends AnyFunSuite {

  test("Test plus 1") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec + (2.0f, 3.0f)
    assert(res == Vec2f(3.0f, 5.0f))
  }

  test("Test plus 2") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec + (2.0, 3.0)
    assert(res == Vec2d(3.0, 5.0))
  }

  test("Test plus 3") {
    val a = Vec2f(1.0f, 2.0f)
    val b = Vec2i(2, 3)
    assert(a + b == Vec2f(3.0f, 5.0f))
  }

  test("Test plus 4") {
    val a = Vec2f(1.0f, 2.0f)
    val b = Vec2f(2.0f, 3.0f)
    assert(a + b == Vec2f(3.0f, 5.0f))
  }

  test("Test plus 5") {
    val a = Vec2f(1.0f, 2.0f)
    val b = Vec2d(2.0, 3.0)
    assert(a + b == Vec2d(3.0, 5.0))
  }

  test("Test negated") {
    val a = Vec2f(2.0f, 3.0f)
    assert(-a == Vec2f(-2.0f, -3.0f))
  }

  test("Test minus 1") {
    val vec = Vec2f(3.0f, 5.0f)
    val res = vec - (2.0f, 3.0f)
    assert(res == Vec2f(1.0f, 2.0f))
  }

  test("Test minus 2") {
    val vec = Vec2f(3.0f, 5.0f)
    val res = vec - (2.0, 3.0)
    assert(res == Vec2d(1.0, 2.0))
  }

  test("Test minus 3") {
    val a = Vec2f(3.0f, 5.0f)
    val b = Vec2i(2, 3)
    assert(a - b == Vec2f(1.0f, 2.0f))
  }

  test("Test minus 4") {
    val a = Vec2f(3.0f, 5.0f)
    val b = Vec2f(2.0f, 3.0f)
    assert(a - b == Vec2f(1.0f, 2.0f))
  }

  test("Test minus 5") {
    val a = Vec2f(3.0f, 5.0f)
    val b = Vec2d(2.0, 3.0)
    assert(a - b == Vec2d(1.0, 2.0))
  }

  test("Test multipliedBy 1") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec * 1.5f
    assert(res == Vec2f(1.5f, 3.0f))
  }

  test("Test multipliedBy 2") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec * 1.5
    assert(res == Vec2d(1.5, 3.0))
  }

  test("Test dividedBy 1") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec / 2.0f
    assert(res == Vec2f(0.5f, 1.0f))
  }

  test("Test dividedBy 2") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec / 2.0
    assert(res == Vec2d(0.5, 1.0))
  }

  test("Test multiply 1") {
    val vec = Vec2f(2.0f, 3.0f)
    val res = vec * (3.0f, 4.0f)
    assert(res == Vec2f(6.0f, 12.0f))
  }

  test("Test multiply 2") {
    val vec = Vec2f(2.0f, 3.0f)
    val res = vec * (3.0, 4.0)
    assert(res == Vec2d(6.0, 12.0))
  }

  test("Test multiply 3") {
    val a = Vec2f(2.0f, 3.0f)
    val b = Vec2i(3, 4)
    assert(a * b == Vec2f(6.0f, 12.0f))
  }

  test("Test multiply 4") {
    val a = Vec2f(2.0f, 3.0f)
    val b = Vec2f(3.0f, 4.0f)
    assert(a * b == Vec2f(6.0f, 12.0f))
  }

  test("Test multiply 5") {
    val a = Vec2f(2.0f, 3.0f)
    val b = Vec2d(3.0, 4.0)
    assert(a * b == Vec2d(6.0, 12.0))
  }

  test("Test dot 1") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec dot(2.0f, 3.0f)
    assert(res == 8.0f)
  }

  test("Test dot 2") {
    val vec = Vec2f(1.0f, 2.0f)
    val res = vec dot(2.0, 3.0)
    assert(res == 8.0)
  }

  test("Test dot 3") {
    val a = Vec2f(1.0f, 2.0f)
    val b = Vec2i(2, 3)
    assert((a dot b) == 8.0f)
  }

  test("Test dot 4") {
    val a = Vec2f(1.0f, 2.0f)
    val b = Vec2f(2.0f, 3.0f)
    assert((a dot b) == 8.0f)
  }

  test("Test dot 5") {
    val a = Vec2f(1.0f, 2.0f)
    val b = Vec2d(2.0, 3.0)
    assert((a dot b) == 8.0)
  }

  test("Test length squared") {
    assert(Vec2f.One.lengthSquared == 2.0f)
  }

  test("Test length") {
    assert(Vec2f.One.length == Math.sqrt(2))
  }

  test("Test normalized") {
    val vec = Vec2f.One
    val res = vec.normalized
    assert(res == Vec2d(1.0 / Math.sqrt(2), 1.0 / Math.sqrt(2)))
  }
}
