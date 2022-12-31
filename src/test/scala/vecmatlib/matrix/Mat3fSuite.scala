package vecmatlib.matrix

import org.scalatest.funsuite.AnyFunSuite
import vecmatlib.vector.{Vec3d, Vec3f, Vec3i}

class Mat3fSuite extends AnyFunSuite {

  test("Test plus 1") {
    val a = Mat3f(
      1.0f, 2.0f, 3.0f,
      2.0f, 3.0f, 4.0f,
      3.0f, 4.0f, 1.0f
    )
    val b = Mat3i(
      3, 4, 2,
      4, 2, 1,
      2, 1, 3
    )
    assert(a + b == Mat3f(
      4.0f, 6.0f, 5.0f,
      6.0f, 5.0f, 5.0f,
      5.0f, 5.0f, 4.0f
    ))
  }

  test("Test plus 2") {
    val a = Mat3f(
      1.0f, 2.0f, 3.0f,
      2.0f, 3.0f, 4.0f,
      3.0f, 4.0f, 1.0f
    )
    val b = Mat3f(
      3.0f, 4.0f, 2.0f,
      4.0f, 2.0f, 1.0f,
      2.0f, 1.0f, 3.0f
    )
    assert(a + b == Mat3f(
      4.0f, 6.0f, 5.0f,
      6.0f, 5.0f, 5.0f,
      5.0f, 5.0f, 4.0f
    ))
  }

  test("Test plus 3") {
    val a = Mat3f(
      1.0f, 2.0f, 3.0f,
      2.0f, 3.0f, 4.0f,
      3.0f, 4.0f, 1.0f
    )
    val b = Mat3d(
      3.0, 4.0, 2.0,
      4.0, 2.0, 1.0,
      2.0, 1.0, 3.0
    )
    assert(a + b == Mat3d(
      4.0, 6.0, 5.0,
      6.0, 5.0, 5.0,
      5.0, 5.0, 4.0
    ))
  }

  test("Test negated") {
    assert(Mat3f(
      1.0f, 2.0f, 3.0f,
      2.0f, 3.0f, 4.0f,
      3.0f, 4.0f, 1.0f
    ).negated == Mat3f(
      -1.0f, -2.0f, -3.0f,
      -2.0f, -3.0f, -4.0f,
      -3.0f, -4.0f, -1.0f
    ))
  }

  test("Test minus 1") {
    val a = Mat3f(
      4.0f, 6.0f, 5.0f,
      6.0f, 5.0f, 5.0f,
      5.0f, 5.0f, 4.0f
    )
    val b = Mat3i(
      3, 4, 2,
      4, 2, 1,
      2, 1, 3
    )
    assert(a - b == Mat3f(
      1.0f, 2.0f, 3.0f,
      2.0f, 3.0f, 4.0f,
      3.0f, 4.0f, 1.0f
    ))
  }

  test("Test minus 2") {
    val a = Mat3f(
      4.0f, 6.0f, 5.0f,
      6.0f, 5.0f, 5.0f,
      5.0f, 5.0f, 4.0f
    )
    val b = Mat3f(
      3.0f, 4.0f, 2.0f,
      4.0f, 2.0f, 1.0f,
      2.0f, 1.0f, 3.0f
    )
    assert(a - b == Mat3f(
      1.0f, 2.0f, 3.0f,
      2.0f, 3.0f, 4.0f,
      3.0f, 4.0f, 1.0f
    ))
  }

  test("Test minus 3") {
    val a = Mat3f(
      4.0f, 6.0f, 5.0f,
      6.0f, 5.0f, 5.0f,
      5.0f, 5.0f, 4.0f
    )
    val b = Mat3d(
      3.0, 4.0, 2.0,
      4.0, 2.0, 1.0,
      2.0, 1.0, 3.0
    )
    assert(a - b == Mat3d(
      1.0, 2.0, 3.0,
      2.0, 3.0, 4.0,
      3.0, 4.0, 1.0,
    ))
  }

  test("Test multipliedBy 1") {
    assert(Mat3f(
      1.0f, 1.0f, 1.0f,
      1.0f, 1.0f, 1.0f,
      1.0f, 1.0f, 2.0f
    ) * 1.5f == Mat3f(
      1.5f, 1.5f, 1.5f,
      1.5f, 1.5f, 1.5f,
      1.5f, 1.5f, 3.0f
    ))
  }

  test("Test multipliedBy 2") {
    assert(Mat3f(
      1.0f, 1.0f, 1.0f,
      1.0f, 1.0f, 1.0f,
      1.0f, 1.0f, 2.0f
    ) * 1.5 == Mat3d(
      1.5, 1.5, 1.5,
      1.5, 1.5, 1.5,
      1.5, 1.5, 3.0
    ))
  }

  test("Test multiply vector 1") {
    val mat = Mat3f(
      0.0f, 1.0f, 0.0f,
      0.0f, 0.0f, 1.0f,
      1.0f, 0.0f, 0.0f
    )
    val vec = Vec3i(2, 3, 4)
    assert(mat * vec == Vec3f(3.0f, 4.0f, 2.0f))
  }

  test("Test multiply vector 2") {
    val mat = Mat3f(
      0.0f, 1.0f, 0.0f,
      0.0f, 0.0f, 1.0f,
      1.0f, 0.0f, 0.0f
    )
    val vec = Vec3f(2.0f, 3.0f, 4.0f)
    assert(mat * vec == Vec3f(3.0f, 4.0f, 2.0f))
  }

  test("Test multiply vector 3") {
    val mat = Mat3f(
      0.0f, 1.0f, 0.0f,
      0.0f, 0.0f, 1.0f,
      1.0f, 0.0f, 0.0f
    )
    val vec = Vec3d(2.0, 3.0, 4.0)
    assert(mat * vec == Vec3d(3.0, 4.0, 2.0))
  }

  test("Test multiply vector 4") {
    val mat = Mat3f(
      0.0f, 1.0f, 0.0f,
      0.0f, 0.0f, 1.0f,
      1.0f, 0.0f, 0.0f
    )
    assert(mat * (2.0f, 3.0f, 4.0f) == Vec3f(3.0f, 4.0f, 2.0f))
  }

  test("Test multiply vector 5") {
    val mat = Mat3f(
      0.0f, 1.0f, 0.0f,
      0.0f, 0.0f, 1.0f,
      1.0f, 0.0f, 0.0f
    )
    assert(mat * (2.0, 3.0, 4.0) == Vec3d(3.0, 4.0, 2.0))
  }

  test("Test transposed") {
    assert(Mat3f(
      0.0f, 1.0f, 0.0f,
      0.0f, 0.0f, 1.0f,
      1.0f, 0.0f, 0.0f
    ).transposed == Mat3f(
      0.0f, 0.0f, 1.0f,
      1.0f, 0.0f, 0.0f,
      0.0f, 1.0f, 0.0f
    ))
  }

  test("Test symmetric") {
    assert(Mat3f(
      0.0f, 1.0f, 2.0f,
      1.0f, 0.0f, 4.0f,
      2.0f, 4.0f, 0.0f
    ).isSymmetric)
  }

  test("Test skew symmetric") {
    assert(Mat3f(
      0.0f, 1.0f, 2.0f,
      -1.0f, 0.0f, 4.0f,
      -2.0f, -4.0f, 0.0f
    ).isSkewSymmetric)
  }

  test("Test multiply matrix 1") {
    val a = Mat3f(
      1.0f, 2.0f, 3.0f,
      2.0f, 3.0f, 4.0f,
      3.0f, 4.0f, 1.0f
    )
    val b = Mat3i(
      3, 4, 2,
      4, 2, 1,
      2, 1, 3
    )
    assert(a * b == Mat3f(
      17.0f, 11.0f, 13.0f,
      26.0f, 18.0f, 19.0f,
      27.0f, 21.0f, 13.0f
    ))
  }

  test("Test multiply matrix 2") {
    val a = Mat3f(
      1.0f, 2.0f, 3.0f,
      2.0f, 3.0f, 4.0f,
      3.0f, 4.0f, 1.0f
    )
    val b = Mat3f(
      3.0f, 4.0f, 2.0f,
      4.0f, 2.0f, 1.0f,
      2.0f, 1.0f, 3.0f
    )
    assert(a * b == Mat3f(
      17.0f, 11.0f, 13.0f,
      26.0f, 18.0f, 19.0f,
      27.0f, 21.0f, 13.0f
    ))
  }

  test("Test multiply matrix 3") {
    val a = Mat3f(
      1.0f, 2.0f, 3.0f,
      2.0f, 3.0f, 4.0f,
      3.0f, 4.0f, 1.0f
    )
    val b = Mat3d(
      3.0, 4.0, 2.0,
      4.0, 2.0, 1.0,
      2.0, 1.0, 3.0
    )
    assert(a * b == Mat3d(
      17.0, 11.0, 13.0,
      26.0, 18.0, 19.0,
      27.0, 21.0, 13.0
    ))
  }

  test("Test power") {
    val a = Mat3f(
      1.0f, 2.0f, 3.0f,
      2.0f, 3.0f, 4.0f,
      3.0f, 4.0f, 1.0f
    )
    assert((a power 3) == (a * a * a))
  }
}
