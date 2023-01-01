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

  test("Test angle 1") {
    val a = Vec2f.Up
    val b = Vec2i.Left
    assert(a.angle(b) == math.Pi / 2.0)
  }

  test("Test angle 2") {
    val a = Vec2f.Up
    val b = Vec2f.Right
    assert(a.angle(b) == math.Pi / 2.0)
  }

  test("Test angle 3") {
    val a = Vec2f.Up
    val b = Vec2d.Down
    assert(a.angle(b) == math.Pi)
  }

  test("Test angle 4") {
    val vec = Vec2f.Right
    assert(vec.angle(0.0, 1.0) == math.Pi / 2.0)
  }

  test("Test direction to 1") {
    val a = Vec2f.Zero
    val b = Vec2i(0, 10)
    assert(a.directionTo(b) == Vec2d.Up)
  }

  test("Test direction to 2") {
    val a = Vec2f.Zero
    val b = Vec2f(0.0f, 10.0f)
    assert(a.directionTo(b) == Vec2d.Up)
  }

  test("Test direction to 3") {
    val a = Vec2f.Zero
    val b = Vec2d(0.0, -10.0)
    assert(a.directionTo(b) == Vec2d.Down)
  }

  test("Test direction to 4") {
    val vec = Vec2f.Zero
    assert(vec.directionTo(0.0, 10.0) == Vec2d.Up)
  }

  test("Test distance squared to 1") {
    val vec = Vec2f.Zero
    assert(vec.distanceSquaredTo(2.0f, 2.0f) == 8.0f)
  }

  test("Test distance squared to 2") {
    val vec = Vec2f.Zero
    assert(vec.distanceSquaredTo(2.0, 2.0) == 8.0)
  }

  test("Test distance squared to 3") {
    val a = Vec2f.Zero
    val b = Vec2i.One * 2
    assert(a.distanceSquaredTo(b) == 8)
  }

  test("Test distance squared to 4") {
    val a = Vec2i.Zero
    val b = Vec2f.One * 2
    assert(a.distanceSquaredTo(b) == 8.0f)
  }

  test("Test distance squared to 5") {
    val a = Vec2i.Zero
    val b = Vec2d.One * 2
    assert(a.distanceSquaredTo(b) == 8.0)
  }

  test("Test distance to 1") {
    val vec = Vec2f.Zero
    assert(vec.distanceTo(2.0, 2.0) == 2.0 * math.sqrt(2))
  }

  test("Test distance to 2") {
    val a = Vec2f.Zero
    val b = Vec2i.One * 2
    assert(a.distanceTo(b) == 2.0 * math.sqrt(2))
  }

  test("Test distance to 3") {
    val a = Vec2f.Zero
    val b = Vec2f.One * 2.0f
    assert(a.distanceTo(b) == 2.0 * math.sqrt(2))
  }

  test("Test distance to 4") {
    val a = Vec2f.Zero
    val b = Vec2d.One * 2.0
    assert(a.distanceTo(b) == 2.0 * math.sqrt(2))
  }

  test("Test reflect 1") {
    val vec = Vec2f(1.0f, -1.0f)
    val res = vec.reflect(0.0f, 1.0f)
    assert(res == Vec2f(1.0f, 1.0f))
  }

  test("Test reflect 2") {
    val vec = Vec2f(1.0f, -1.0f)
    val res = vec.reflect(0.0, 1.0)
    assert(res == Vec2d(1.0, 1.0))
  }

  test("Test reflect 3") {
    val a = Vec2f(1.0f, -1.0f)
    val b = Vec2i(0, 1)
    assert(a.reflect(b) == Vec2f(1.0f, 1.0f))
  }

  test("Test reflect 4") {
    val a = Vec2f(1.0f, -1.0f)
    val b = Vec2f(0.0f, 1.0f)
    assert(a.reflect(b) == Vec2f(1.0f, 1.0f))
  }

  test("Test reflect 5") {
    val a = Vec2f(1.0f, -1.0f)
    val b = Vec2d(0.0, 1.0)
    assert(a.reflect(b) == Vec2d(1.0, 1.0))
  }

  test("Test bounce 1") {
    val vec = Vec2f(1.0f, -1.0f)
    val res = vec.bounce(0.0f, 1.0f)
    assert(res == Vec2f(-1.0f, -1.0f))
  }

  test("Test bounce 2") {
    val vec = Vec2f(1.0f, -1.0f)
    val res = vec.bounce(0.0, 1.0)
    assert(res == Vec2d(-1.0, -1.0))
  }

  test("Test bounce 3") {
    val a = Vec2f(1.0f, -1.0f)
    val b = Vec2i(0, 1)
    assert(a.bounce(b) == Vec2f(-1, -1))
  }

  test("Test bounce 4") {
    val a = Vec2f(1.0f, -1.0f)
    val b = Vec2f(0.0f, 1.0f)
    assert(a.bounce(b) == Vec2f(-1.0f, -1.0f))
  }

  test("Test bounce 5") {
    val a = Vec2f(1.0f, -1.0f)
    val b = Vec2d(0.0, 1.0)
    assert(a.bounce(b) == Vec2d(-1.0, -1.0))
  }

  test("Test project 1") {
    val vec = Vec2f(2.0f, 1.0f)
    val res = vec.project(1.0f, 0.0f)
    assert(res == Vec2f(2.0f, 0.0f))
  }

  test("Test project 2") {
    val vec = Vec2f(2.0f, 1.0f)
    val res = vec.project(1.0, 0.0)
    assert(res == Vec2d(2.0, 0.0))
  }

  test("Test project 3") {
    val a = Vec2f(2.0f, 1.0f)
    val b = Vec2i(1, 0)
    assert(a.project(b) == Vec2f(2.0f, 0.0f))
  }

  test("Test project 4") {
    val a = Vec2f(2.0f, 1.0f)
    val b = Vec2f(1.0f, 0.0f)
    assert(a.project(b) == Vec2f(2.0f, 0.0f))
  }

  test("Test project 5") {
    val a = Vec2f(2.0f, 1.0f)
    val b = Vec2d(1.0, 0.0)
    assert(a.project(b) == Vec2d(2.0, 0.0))
  }

  test("Test slide 1") {
    val vec = Vec2f(1.0f, 1.0f)
    assert(vec.slide(0.0f, 1.0f) == Vec2f(1.0f, 0.0f))
  }

  test("Test slide 2") {
    val vec = Vec2f(1.0f, 1.0f)
    assert(vec.slide(0.0, 1.0) == Vec2d(1.0, 0.0))
  }

  test("Test slide 3") {
    val a = Vec2f(1.0f, 1.0f)
    val b = Vec2i(0, 1)
    assert(a.slide(b) == Vec2f(1.0f, 0.0f))
  }

  test("Test slide 4") {
    val a = Vec2f(1.0f, 1.0f)
    val b = Vec2f(0.0f, 1.0f)
    assert(a.slide(b) == Vec2f(1.0f, 0.0f))
  }

  test("Test slide 5") {
    val a = Vec2f(1.0f, 1.0f)
    val b = Vec2d(0.0, 1.0)
    assert(a.slide(b) == Vec2d(1.0, 0.0))
  }
}
