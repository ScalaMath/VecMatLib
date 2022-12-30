package vecmatlib.vector

import org.scalatest.funsuite.AnyFunSuite

class Vec4dSuite extends AnyFunSuite {

  test("Test plus 1") {
    val vec = Vec4d(1.0, 2.0, 3.0, 4.0)
    val res = vec + (2.0, 3.0, 1.0, -1.0)
    assert(res == Vec4d(3.0, 5.0, 4.0, 3.0))
  }

  test("Test plus 2") {
    val a = Vec4d(1.0, 2.0, 3.0, 4.0)
    val b = Vec4i(2, 3, 1, -1)
    assert(a + b == Vec4d(3.0, 5.0, 4.0, 3.0))
  }

  test("Test plus 3") {
    val a = Vec4d(1.0, 2.0, 3.0, 4.0)
    val b = Vec4f(2.0f, 3.0f, 1.0f, -1.0f)
    assert(a + b == Vec4d(3.0, 5.0, 4.0, 3.0))
  }

  test("Test plus 4") {
    val a = Vec4d(1.0, 2.0, 3.0, 4.0)
    val b = Vec4d(2.0, 3.0, 1.0, -1.0)
    assert(a + b == Vec4d(3.0, 5.0, 4.0, 3.0))
  }

  test("Test negated") {
    val a = Vec4d(2.0, 3.0, 4.0, -2.0)
    assert(-a == Vec4d(-2.0, -3.0, -4.0, 2.0))
  }

  test("Test minus 1") {
    val vec = Vec4d(3.0, 5.0, 4.0, 2.0)
    val res = vec - (2.0, 3.0, 1.0, 4.0)
    assert(res == Vec4d(1.0, 2.0, 3.0, -2.0))
  }

  test("Test minus 2") {
    val a = Vec4d(3.0, 5.0, 4.0, 2.0)
    val b = Vec4i(2, 3, 1, 4)
    assert(a - b == Vec4d(1.0, 2.0, 3.0, -2.0))
  }

  test("Test minus 3") {
    val a = Vec4d(3.0, 5.0, 4.0, 2.0)
    val b = Vec4f(2.0f, 3.0f, 1.0f, 4.0f)
    assert(a - b == Vec4d(1.0, 2.0, 3.0, -2.0))
  }

  test("Test minus 4") {
    val a = Vec4d(3.0, 5.0, 4.0, 2.0)
    val b = Vec4d(2.0, 3.0, 1.0, 4.0)
    assert(a - b == Vec4d(1.0, 2.0, 3.0, -2.0))
  }

  test("Test multipliedBy") {
    val vec = Vec4d(1.0, 2.0, 3.0, 4.0)
    val res = vec * 1.5
    assert(res == Vec4d(1.5, 3.0, 4.5, 6.0))
  }

  test("Test dividedBy") {
    val vec = Vec4d(1.0, 2.0, 3.0, 4.0)
    val res = vec / 2.0
    assert(res == Vec4d(0.5, 1.0, 1.5, 2.0))
  }

  test("Test multiply 1") {
    val vec = Vec4d(2.0, 3.0, 4.0, 1.0)
    val res = vec * (3.0, 4.0, 2.0, 1.0)
    assert(res == Vec4d(6.0, 12.0, 8.0, 1.0))
  }

  test("Test multiply 2") {
    val a = Vec4d(2.0, 3.0, 4.0, 1.0)
    val b = Vec4i(3, 4, 2, 1)
    assert(a * b == Vec4d(6.0, 12.0, 8.0, 1.0))
  }

  test("Test multiply 3") {
    val a = Vec4d(2.0, 3.0, 4.0, 1.0)
    val b = Vec4f(3.0f, 4.0f, 2.0f, 1.0f)
    assert(a * b == Vec4d(6.0, 12.0, 8.0, 1.0))
  }

  test("Test multiply 4") {
    val a = Vec4d(2.0, 3.0, 4.0, 1.0)
    val b = Vec4d(3.0, 4.0, 2.0, 1.0)
    assert(a * b == Vec4d(6.0, 12.0, 8.0, 1.0))
  }

  test("Test dot 1") {
    val vec = Vec4d(1.0, 2.0, 3.0, 4.0)
    val res = vec dot(2.0, 3.0, 1.0, 4.0)
    assert(res == 27.0)
  }

  test("Test dot 2") {
    val a = Vec4d(1.0, 2.0, 3.0, 4.0)
    val b = Vec4i(2, 3, 1, 4)
    assert((a dot b) == 27.0)
  }

  test("Test dot 3") {
    val a = Vec4d(1.0, 2.0, 3.0, 4.0)
    val b = Vec4f(2.0f, 3.0f, 1.0f, 4.0f)
    assert((a dot b) == 27.0)
  }

  test("Test dot 4") {
    val a = Vec4d(1.0, 2.0, 3.0, 4.0)
    val b = Vec4d(2.0, 3.0, 1.0, 4.0)
    assert((a dot b) == 27.0)
  }

  test("Test length squared") {
    assert(Vec4d(1.0, 1.0, 1.0, 1.0).lengthSquared == 4.0)
  }

  test("Test length") {
    assert(Vec4d(1.0, 1.0, 1.0, 1.0).length == Math.sqrt(4))
  }

  test("Test normalized") {
    val vec = Vec4d(4.0, 0.0, 0.0, 0.0)
    val res = vec.normalized
    assert(res == Vec4d(1.0, 0.0, 0.0, 0.0))
  }
}
