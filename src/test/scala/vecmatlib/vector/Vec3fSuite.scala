package vecmatlib.vector

import org.scalatest.funsuite.AnyFunSuite

class Vec3fSuite extends AnyFunSuite {

  test("Test plus 1") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val res = vec + (2.0f, 3.0f, 1.0f)
    assert(res == Vec3f(3.0f, 5.0f, 4.0f))
  }

  test("Test plus 2") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val res = vec + (2.0, 3.0, 1.0)
    assert(res == Vec3d(3.0, 5.0, 4.0))
  }

  test("Test plus 3") {
    val a = Vec3f(1.0f, 2.0f, 3.0f)
    val b = Vec3i(2, 3, 1)
    assert(a + b == Vec3f(3.0f, 5.0f, 4.0f))
  }

  test("Test plus 4") {
    val a = Vec3f(1.0f, 2.0f, 3.0f)
    val b = Vec3f(2.0f, 3.0f, 1.0f)
    assert(a + b == Vec3f(3.0f, 5.0f, 4.0f))
  }

  test("Test plus 5") {
    val a = Vec3f(1.0f, 2.0f, 3.0f)
    val b = Vec3d(2.0, 3.0, 1.0)
    assert(a + b == Vec3d(3.0, 5.0, 4.0))
  }

  test("Test negated") {
    val a = Vec3f(2.0f, 3.0f, 4.0f)
    assert(-a == Vec3f(-2.0f, -3.0f, -4.0f))
  }

  test("Test minus 1") {
    val vec = Vec3f(3.0f, 5.0f, 4.0f)
    val res = vec - (2.0f, 3.0f, 1.0f)
    assert(res == Vec3f(1.0f, 2.0f, 3.0f))
  }

  test("Test minus 2") {
    val vec = Vec3f(3.0f, 5.0f, 4.0f)
    val res = vec - (2.0, 3.0, 1.0)
    assert(res == Vec3d(1.0, 2.0, 3.0))
  }

  test("Test minus 3") {
    val a = Vec3f(3.0f, 5.0f, 4.0f)
    val b = Vec3i(2, 3, 1)
    assert(a - b == Vec3f(1.0f, 2.0f, 3.0f))
  }

  test("Test minus 4") {
    val a = Vec3f(3.0f, 5.0f, 4.0f)
    val b = Vec3f(2.0f, 3.0f, 1.0f)
    assert(a - b == Vec3f(1.0f, 2.0f, 3.0f))
  }

  test("Test minus 5") {
    val a = Vec3f(3.0f, 5.0f, 4.0f)
    val b = Vec3d(2.0, 3.0, 1.0)
    assert(a - b == Vec3d(1.0, 2.0, 3.0))
  }

  test("Test multipliedBy 1") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val res = vec * 1.5f
    assert(res == Vec3f(1.5f, 3.0f, 4.5f))
  }

  test("Test multipliedBy 2") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val res = vec * 1.5
    assert(res == Vec3d(1.5, 3.0, 4.5))
  }

  test("Test dividedBy 1") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val res = vec / 2.0f
    assert(res == Vec3f(0.5f, 1.0f, 1.5f))
  }

  test("Test dividedBy 2") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val res = vec / 2.0
    assert(res == Vec3d(0.5, 1.0, 1.5))
  }

  test("Test multiply 1") {
    val vec = Vec3f(2.0f, 3.0f, 4.0f)
    val res = vec * (3.0f, 4.0f, 2.0f)
    assert(res == Vec3f(6.0f, 12.0f, 8.0f))
  }

  test("Test multiply 2") {
    val vec = Vec3f(2.0f, 3.0f, 4.0f)
    val res = vec * (3.0, 4.0, 2.0)
    assert(res == Vec3d(6.0, 12.0, 8.0))
  }

  test("Test multiply 3") {
    val a = Vec3f(2.0f, 3.0f, 4.0f)
    val b = Vec3i(3, 4, 2)
    assert(a * b == Vec3f(6.0f, 12.0f, 8.0f))
  }

  test("Test multiply 4") {
    val a = Vec3f(2.0f, 3.0f, 4.0f)
    val b = Vec3f(3.0f, 4.0f, 2.0f)
    assert(a * b == Vec3f(6.0f, 12.0f, 8.0f))
  }

  test("Test multiply 5") {
    val a = Vec3f(2.0f, 3.0f, 4.0f)
    val b = Vec3d(3.0, 4.0, 2.0)
    assert(a * b == Vec3d(6.0, 12.0, 8.0))
  }

  test("Test dot 1") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val res = vec.dot(2.0f, 3.0f, 1.0f)
    assert(res == 11.0f)
  }

  test("Test dot 2") {
    val vec = Vec3f(1.0f, 2.0f, 3.0f)
    val res = vec.dot(2.0, 3.0, 1.0)
    assert(res == 11.0)
  }

  test("Test dot 3") {
    val a = Vec3f(1.0f, 2.0f, 3.0f)
    val b = Vec3i(2, 3, 1)
    assert((a dot b) == 11.0f)
  }

  test("Test dot 4") {
    val a = Vec3f(1.0f, 2.0f, 3.0f)
    val b = Vec3f(2.0f, 3.0f, 1.0f)
    assert((a dot b) == 11.0f)
  }

  test("Test dot 5") {
    val a = Vec3f(1.0f, 2.0f, 3.0f)
    val b = Vec3d(2.0, 3.0, 1.0)
    assert((a dot b) == 11.0)
  }

  test("Test cross 1") {
    val vec = Vec3f.Right
    val res = vec.cross(0.0f, 1.0f, 0.0f)
    assert(res == Vec3f.Forward)
  }

  test("Test cross 2") {
    val vec = Vec3f.Right
    val res = vec.cross(0.0, -1.0, 0.0)
    assert(res == Vec3d.Backwards)
  }

  test("Test cross 3") {
    val a = Vec3f.Right
    val b = Vec3i.Down
    assert((a cross b) == Vec3f.Backwards)
  }

  test("Test cross 4") {
    val a = Vec3f.Right
    val b = Vec3f.Up
    assert((a cross b) == Vec3f.Forward)
  }

  test("Test cross 5") {
    val a = Vec3f.Left
    val b = Vec3d.Up
    assert((a cross b) == Vec3d.Backwards)
  }

  test("Test length squared") {
    assert(Vec3f.One.lengthSquared == 3.0f)
  }

  test("Test length") {
    assert(Vec3f.One.length == Math.sqrt(3))
  }

  test("Test normalized") {
    val vec = Vec3f(0.0f, 3.0f, 0.0f)
    val res = vec.normalized
    assert(res == Vec3d(0.0, 1.0, 0.0))
  }
}
