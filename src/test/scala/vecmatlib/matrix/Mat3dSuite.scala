package vecmatlib.matrix

import org.scalatest.funsuite.AnyFunSuite
import vecmatlib.vector.{Vec3d, Vec3f, Vec3i}

class Mat3dSuite extends AnyFunSuite {

  test("Test plus 1") {
    val a = Mat3d(
      1.0, 2.0, 3.0,
      2.0, 3.0, 4.0,
      3.0, 4.0, 1.0
    )
    val b = Mat3i(
      3, 4, 2,
      4, 2, 1,
      2, 1, 3
    )
    assert(a + b == Mat3d(
      4.0, 6.0, 5.0,
      6.0, 5.0, 5.0,
      5.0, 5.0, 4.0
    ))
  }

  test("Test plus 2") {
    val a = Mat3d(
      1.0, 2.0, 3.0,
      2.0, 3.0, 4.0,
      3.0, 4.0, 1.0
    )
    val b = Mat3f(
      3.0f, 4.0f, 2.0f,
      4.0f, 2.0f, 1.0f,
      2.0f, 1.0f, 3.0f
    )
    assert(a + b == Mat3d(
      4.0, 6.0, 5.0,
      6.0, 5.0, 5.0,
      5.0, 5.0, 4.0
    ))
  }

  test("Test plus 3") {
    val a = Mat3d(
      1.0, 2.0, 3.0,
      2.0, 3.0, 4.0,
      3.0, 4.0, 1.0
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
    assert(Mat3d(
      1.0, 2.0, 3.0,
      2.0, 3.0, 4.0,
      3.0, 4.0, 1.0
    ).negated == Mat3d(
      -1.0, -2.0, -3.0,
      -2.0, -3.0, -4.0,
      -3.0, -4.0, -1.0
    ))
  }

  test("Test minus 1") {
    val a = Mat3d(
      4.0, 6.0, 5.0,
      6.0, 5.0, 5.0,
      5.0, 5.0, 4.0
    )
    val b = Mat3i(
      3, 4, 2,
      4, 2, 1,
      2, 1, 3
    )
    assert(a - b == Mat3d(
      1.0, 2.0, 3.0,
      2.0, 3.0, 4.0,
      3.0, 4.0, 1.0
    ))
  }

  test("Test minus 2") {
    val a = Mat3d(
      4.0, 6.0, 5.0,
      6.0, 5.0, 5.0,
      5.0, 5.0, 4.0
    )
    val b = Mat3f(
      3.0f, 4.0f, 2.0f,
      4.0f, 2.0f, 1.0f,
      2.0f, 1.0f, 3.0f
    )
    assert(a - b == Mat3d(
      1.0, 2.0, 3.0,
      2.0, 3.0, 4.0,
      3.0, 4.0, 1.0
    ))
  }

  test("Test minus 3") {
    val a = Mat3d(
      4.0, 6.0, 5.0,
      6.0, 5.0, 5.0,
      5.0, 5.0, 4.0
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
    assert(Mat3d(
      1.0, 1.0, 1.0,
      1.0, 1.0, 1.0,
      1.0, 1.0, 2.0
    ) * 1.5 == Mat3d(
      1.5, 1.5, 1.5,
      1.5, 1.5, 1.5,
      1.5, 1.5, 3.0
    ))
  }

  test("Test multiply vector 1") {
    val mat = Mat3d(
      0.0, 1.0, 0.0,
      0.0, 0.0, 1.0,
      1.0, 0.0, 0.0
    )
    val vec = Vec3i(2, 3, 4)
    assert(mat * vec == Vec3d(3.0, 4.0, 2.0))
  }

  test("Test multiply vector 2") {
    val mat = Mat3d(
      0.0, 1.0, 0.0,
      0.0, 0.0, 1.0,
      1.0, 0.0, 0.0
    )
    val vec = Vec3f(2.0f, 3.0f, 4.0f)
    assert(mat * vec == Vec3d(3.0, 4.0, 2.0))
  }

  test("Test multiply vector 3") {
    val mat = Mat3d(
      0.0, 1.0, 0.0,
      0.0, 0.0, 1.0,
      1.0, 0.0, 0.0
    )
    val vec = Vec3d(2.0, 3.0, 4.0)
    assert(mat * vec == Vec3d(3.0, 4.0, 2.0))
  }

  test("Test multiply vector 4") {
    val mat = Mat3d(
      0.0, 1.0, 0.0,
      0.0, 0.0, 1.0,
      1.0, 0.0, 0.0
    )
    assert(mat * (2.0, 3.0, 4.0) == Vec3d(3.0, 4.0, 2.0))
  }

  test("Test transposed") {
    assert(Mat3d(
      0.0, 1.0, 0.0,
      0.0, 0.0, 1.0,
      1.0, 0.0, 0.0
    ).transposed == Mat3d(
      0.0, 0.0, 1.0,
      1.0, 0.0, 0.0,
      0.0, 1.0, 0.0
    ))
  }

  test("Test symmetric") {
    assert(Mat3d(
      0.0, 1.0, 2.0,
      1.0, 0.0, 4.0,
      2.0, 4.0, 0.0
    ).isSymmetric)
  }

  test("Test skew symmetric") {
    assert(Mat3d(
      0.0, 1.0, 2.0,
      -1.0, 0.0, 4.0,
      -2.0, -4.0, 0.0
    ).isSkewSymmetric)
  }

  test("Test multiply matrix 1") {
    val a = Mat3d(
      1.0, 2.0, 3.0,
      2.0, 3.0, 4.0,
      3.0, 4.0, 1.0
    )
    val b = Mat3i(
      3, 4, 2,
      4, 2, 1,
      2, 1, 3
    )
    assert(a * b == Mat3d(
      17.0, 11.0, 13.0,
      26.0, 18.0, 19.0,
      27.0, 21.0, 13.0
    ))
  }

  test("Test multiply matrix 2") {
    val a = Mat3d(
      1.0, 2.0, 3.0,
      2.0, 3.0, 4.0,
      3.0, 4.0, 1.0
    )
    val b = Mat3f(
      3.0f, 4.0f, 2.0f,
      4.0f, 2.0f, 1.0f,
      2.0f, 1.0f, 3.0f
    )
    assert(a * b == Mat3d(
      17.0, 11.0, 13.0,
      26.0, 18.0, 19.0,
      27.0, 21.0, 13.0
    ))
  }

  test("Test multiply matrix 3") {
    val a = Mat3d(
      1.0, 2.0, 3.0,
      2.0, 3.0, 4.0,
      3.0, 4.0, 1.0
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
    val a = Mat3d(
      1.0, 2.0, 3.0,
      2.0, 3.0, 4.0,
      3.0, 4.0, 1.0
    )
    assert((a power 3) == (a * a * a))
  }
}
