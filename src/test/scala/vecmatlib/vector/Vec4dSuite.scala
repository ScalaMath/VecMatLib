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

  test("Test angle 1") {
    val a = Vec4d(0.0, 1.0, 0.0, 0.0)
    val b = Vec4i(-1, 0, 0, 0)
    assert(a.angle(b) == math.Pi / 2.0)
  }

  test("Test angle 2") {
    val a = Vec4d(0.0, 1.0, 0.0, 0.0)
    val b = Vec4f(1.0f, 0.0f, 0.0f, 0.0f)
    assert(a.angle(b) == math.Pi / 2.0)
  }

  test("Test angle 3") {
    val a = Vec4d(0.0, 1.0, 0.0, 0.0)
    val b = Vec4d(0.0, -1.0, 0.0, 0.0)
    assert(a.angle(b) == math.Pi)
  }

  test("Test angle 4") {
    val vec = Vec4d(1.0, 0.0, 0.0, 0.0)
    assert(vec.angle(0.0, 1.0, 0.0, 0.0) == math.Pi / 2.0)
  }

  test("Test direction to 1") {
    val a = Vec4d.Zero
    val b = Vec4i(0, 0, 10, 0)
    assert(a.directionTo(b) == Vec4d(0.0, 0.0, 1.0, 0.0))
  }

  test("Test direction to 2") {
    val a = Vec4d.Zero
    val b = Vec4f(0.0f, 0.0f, 10.0f, 0.0f)
    assert(a.directionTo(b) == Vec4d(0.0, 0.0, 1.0, 0.0))
  }

  test("Test direction to 3") {
    val a = Vec4d.Zero
    val b = Vec4d(0.0, 0.0, 10.0, 0.0)
    assert(a.directionTo(b) == Vec4d(0.0, 0.0, 1.0, 0.0))
  }

  test("Test direction to 4") {
    val vec = Vec4d.Zero
    assert(vec.directionTo(0.0, 0.0, 10.0, 0.0) == Vec4d(0.0, 0.0, 1.0, 0.0))
  }

  test("Test distance squared to 1") {
    val vec = Vec4d.Zero
    assert(vec.distanceSquaredTo(2.0, 2.0, 2.0, 2.0) == 16.0)
  }

  test("Test distance squared to 2") {
    val a = Vec4d.Zero
    val b = Vec4i.One * 2
    assert(a.distanceSquaredTo(b) == 16)
  }

  test("Test distance squared to 3") {
    val a = Vec4d.Zero
    val b = Vec4f.One * 2
    assert(a.distanceSquaredTo(b) == 16.0f)
  }

  test("Test distance squared to 4") {
    val a = Vec4d.Zero
    val b = Vec4d.One * 2
    assert(a.distanceSquaredTo(b) == 16.0)
  }

  test("Test distance to 1") {
    val vec = Vec4d.Zero
    assert(vec.distanceTo(2.0, 2.0, 2.0, 2.0) == 2.0 * math.sqrt(4))
  }

  test("Test distance to 2") {
    val a = Vec4d.Zero
    val b = Vec4i.One * 2
    assert(a.distanceTo(b) == 2.0 * math.sqrt(4))
  }

  test("Test distance to 3") {
    val a = Vec4d.Zero
    val b = Vec4f.One * 2.0f
    assert(a.distanceTo(b) == 2.0 * math.sqrt(4))
  }

  test("Test distance to 4") {
    val a = Vec4d.Zero
    val b = Vec4d.One * 2.0
    assert(a.distanceTo(b) == 2.0 * math.sqrt(4))
  }

  test("Test reflect 1") {
    val vec = Vec4d(1.0, -1.0, 0.0, 0.0)
    val res = vec.reflect(0.0, 1.0, 0.0, 0.0)
    assert(res == Vec4d(1.0, 1.0, 0.0, 0.0))
  }

  test("Test reflect 2") {
    val a = Vec4d(1.0, -1.0, 0.0, 0.0)
    val b = Vec4i(0, 1, 0, 0)
    assert(a.reflect(b) == Vec4d(1.0, 1.0, 0.0, 0.0))
  }

  test("Test reflect 3") {
    val a = Vec4d(1.0, -1.0, 0.0, 0.0)
    val b = Vec4f(0.0f, 1.0f, 0.0f, 0.0f)
    assert(a.reflect(b) == Vec4d(1.0, 1.0, 0.0, 0.0))
  }

  test("Test reflect 4") {
    val a = Vec4d(1.0, -1.0, 0.0, 0.0)
    val b = Vec4d(0.0, 1.0, 0.0, 0.0)
    assert(a.reflect(b) == Vec4d(1.0, 1.0, 0.0, 0.0))
  }

  test("Test bounce 1") {
    val vec = Vec4d(1.0, -1.0, 0.0, 0.0)
    val res = vec.bounce(0.0, 1.0, 0.0, 0.0)
    assert(res == Vec4d(-1.0, -1.0, 0.0, 0.0))
  }

  test("Test bounce 2") {
    val a = Vec4d(1.0, -1.0, 0.0, 0.0)
    val b = Vec4i(0, 1, 0, 0)
    assert(a.bounce(b) == Vec4d(-1.0, -1.0, 0.0, 0.0))
  }

  test("Test bounce 3") {
    val a = Vec4d(1.0, -1.0, 0.0, 0.0)
    val b = Vec4f(0.0f, 1.0f, 0.0f, 0.0f)
    assert(a.bounce(b) == Vec4d(-1.0, -1.0, 0.0, 0.0))
  }

  test("Test bounce 4") {
    val a = Vec4d(1.0, -1.0, 0.0, 0.0)
    val b = Vec4d(0.0, 1.0, 0.0, 0.0)
    assert(a.bounce(b) == Vec4d(-1.0, -1.0, 0.0, 0.0))
  }

  test("Test project 1") {
    val vec = Vec4d(2.0, 1.0, 0.0, 0.0)
    val res = vec.project(1.0, 0.0, 0.0, 0.0)
    assert(res == Vec4d(2.0, 0.0, 0.0, 0.0))
  }

  test("Test project 2") {
    val a = Vec4d(2.0, 1.0, 0.0, 0.0)
    val b = Vec4i(1, 0, 0, 0)
    assert(a.project(b) == Vec4d(2.0, 0.0, 0.0, 0.0))
  }

  test("Test project 3") {
    val a = Vec4d(2.0, 1.0, 0.0, 0.0)
    val b = Vec4f(1.0f, 0.0f, 0.0f, 0.0f)
    assert(a.project(b) == Vec4d(2.0, 0.0, 0.0, 0.0))
  }

  test("Test project 4") {
    val a = Vec4d(2.0, 1.0, 0.0, 0.0)
    val b = Vec4d(1.0, 0.0, 0.0, 0.0)
    assert(a.project(b) == Vec4d(2.0, 0.0, 0.0, 0.0))
  }

  test("Test slide 1") {
    val vec = Vec4d(1.0, 1.0, 0.0, 0.0)
    assert(vec.slide(0.0, 1.0, 0.0, 0.0) == Vec4d(1.0, 0.0, 0.0, 0.0))
  }

  test("Test slide 2") {
    val a = Vec4d(1.0, 1.0, 0.0, 0.0)
    val b = Vec4i(0, 1, 0, 0)
    assert(a.slide(b) == Vec4d(1.0, 0.0, 0.0, 0.0))
  }

  test("Test slide 3") {
    val a = Vec4d(1.0, 1.0, 0.0, 0.0)
    val b = Vec4f(0.0f, 1.0f, 0.0f, 0.0f)
    assert(a.slide(b) == Vec4d(1.0, 0.0, 0.0, 0.0))
  }

  test("Test slide 4") {
    val a = Vec4d(1.0, 1.0, 0.0, 0.0)
    val b = Vec4d(0.0, 1.0, 0.0, 0.0)
    assert(a.slide(b) == Vec4d(1.0, 0.0, 0.0, 0.0))
  }
}
