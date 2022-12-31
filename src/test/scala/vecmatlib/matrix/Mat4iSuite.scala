package vecmatlib.matrix

import org.scalatest.funsuite.AnyFunSuite
import vecmatlib.vector.{Vec4d, Vec4f, Vec4i}

class Mat4iSuite extends AnyFunSuite {

  test("Test plus 1") {
    val a = Mat4i(
      1, 2, 3, 4,
      2, 3, 4, 1,
      3, 4, 1, 2,
      4, 1, 2, 3
    )
    val b = Mat4i(
      3, 4, 2, 1,
      4, 2, 1, 3,
      2, 1, 3, 4,
      1, 3, 4, 2
    )
    assert(a + b == Mat4i(
      4, 6, 5, 5,
      6, 5, 5, 4,
      5, 5, 4, 6,
      5, 4, 6, 5
    ))
  }

  test("Test plus 2") {
    val a = Mat4i(
      1, 2, 3, 4,
      2, 3, 4, 1,
      3, 4, 1, 2,
      4, 1, 2, 3
    )
    val b = Mat4f(
      3.0f, 4.0f, 2.0f, 1.0f,
      4.0f, 2.0f, 1.0f, 3.0f,
      2.0f, 1.0f, 3.0f, 4.0f,
      1.0f, 3.0f, 4.0f, 2.0f
    )
    assert(a + b == Mat4f(
      4.0f, 6.0f, 5.0f, 5.0f,
      6.0f, 5.0f, 5.0f, 4.0f,
      5.0f, 5.0f, 4.0f, 6.0f,
      5.0f, 4.0f, 6.0f, 5.0f
    ))
  }

  test("Test plus 3") {
    val a = Mat4i(
      1, 2, 3, 4,
      2, 3, 4, 1,
      3, 4, 1, 2,
      4, 1, 2, 3
    )
    val b = Mat4d(
      3.0, 4.0, 2.0, 1.0,
      4.0, 2.0, 1.0, 3.0,
      2.0, 1.0, 3.0, 4.0,
      1.0, 3.0, 4.0, 2.0
    )
    assert(a + b == Mat4d(
      4.0, 6.0, 5.0, 5.0,
      6.0, 5.0, 5.0, 4.0,
      5.0, 5.0, 4.0, 6.0,
      5.0, 4.0, 6.0, 5.0
    ))
  }

  test("Test negated") {
    assert(Mat4i(
      1, 2, 3, 4,
      2, 3, 4, 1,
      3, 4, 1, 2,
      4, 1, 2, 3
    ).negated == Mat4i(
      -1, -2, -3, -4,
      -2, -3, -4, -1,
      -3, -4, -1, -2,
      -4, -1, -2, -3
    ))
  }

  test("Test minus 1") {
    val a = Mat4i(
      4, 6, 5, 5,
      6, 5, 5, 4,
      5, 5, 4, 6,
      5, 4, 6, 5
    )
    val b = Mat4i(
      3, 4, 2, 1,
      4, 2, 1, 3,
      2, 1, 3, 4,
      1, 3, 4, 2
    )
    assert(a - b == Mat4i(
      1, 2, 3, 4,
      2, 3, 4, 1,
      3, 4, 1, 2,
      4, 1, 2, 3
    ))
  }

  test("Test minus 2") {
    val a = Mat4i(
      4, 6, 5, 5,
      6, 5, 5, 4,
      5, 5, 4, 6,
      5, 4, 6, 5
    )
    val b = Mat4f(
      3.0f, 4.0f, 2.0f, 1.0f,
      4.0f, 2.0f, 1.0f, 3.0f,
      2.0f, 1.0f, 3.0f, 4.0f,
      1.0f, 3.0f, 4.0f, 2.0f
    )
    assert(a - b == Mat4f(
      1.0f, 2.0f, 3.0f, 4.0f,
      2.0f, 3.0f, 4.0f, 1.0f,
      3.0f, 4.0f, 1.0f, 2.0f,
      4.0f, 1.0f, 2.0f, 3.0f
    ))
  }

  test("Test minus 3") {
    val a = Mat4i(
      4, 6, 5, 5,
      6, 5, 5, 4,
      5, 5, 4, 6,
      5, 4, 6, 5
    )
    val b = Mat4d(
      3.0, 4.0, 2.0, 1.0,
      4.0, 2.0, 1.0, 3.0,
      2.0, 1.0, 3.0, 4.0,
      1.0, 3.0, 4.0, 2.0
    )
    assert(a - b == Mat4d(
      1.0, 2.0, 3.0, 4.0,
      2.0, 3.0, 4.0, 1.0,
      3.0, 4.0, 1.0, 2.0,
      4.0, 1.0, 2.0, 3.0
    ))
  }

  test("Test multipliedBy 1") {
    assert(Mat4i(
      1, 1, 1, 1,
      1, 1, 1, 2,
      1, 1, 2, 2,
      1, 2, 2, 3
    ) * 2 == Mat4i(
      2, 2, 2, 2,
      2, 2, 2, 4,
      2, 2, 4, 4,
      2, 4, 4, 6
    ))
  }

  test("Test multipliedBy 2") {
    assert(Mat4i(
      1, 1, 1, 1,
      1, 1, 1, 2,
      1, 1, 2, 2,
      1, 2, 2, 3
    ) * 1.5f == Mat4f(
      1.5f, 1.5f, 1.5f, 1.5f,
      1.5f, 1.5f, 1.5f, 3.0f,
      1.5f, 1.5f, 3.0f, 3.0f,
      1.5f, 3.0f, 3.0f, 4.5f
    ))
  }

  test("Test multipliedBy 3") {
    assert(Mat4i(
      1, 1, 1, 1,
      1, 1, 1, 2,
      1, 1, 2, 2,
      1, 2, 2, 3
    ) * 1.5 == Mat4d(
      1.5, 1.5, 1.5, 1.5,
      1.5, 1.5, 1.5, 3.0,
      1.5, 1.5, 3.0, 3.0,
      1.5, 3.0, 3.0, 4.5
    ))
  }

  test("Test multiply vector 1") {
    val mat = Mat4i(
      0, 1, 0, 0,
      0, 0, 0, 1,
      1, 0, 0, 0,
      0, 0, 1, 0
    )
    val vec = Vec4i(2, 3, 4, 5)
    assert(mat * vec == Vec4i(3, 5, 2, 4))
  }

  test("Test multiply vector 2") {
    val mat = Mat4i(
      0, 1, 0, 0,
      0, 0, 0, 1,
      1, 0, 0, 0,
      0, 0, 1, 0
    )
    val vec = Vec4f(2.0f, 3.0f, 4.0f, 5.0f)
    assert(mat * vec == Vec4f(3.0f, 5.0f, 2.0f, 4.0f))
  }

  test("Test multiply vector 3") {
    val mat = Mat4i(
      0, 1, 0, 0,
      0, 0, 0, 1,
      1, 0, 0, 0,
      0, 0, 1, 0
    )
    val vec = Vec4d(2.0, 3.0, 4.0, 5.0)
    assert(mat * vec == Vec4d(3.0, 5.0, 2.0, 4.0))
  }

  test("Test multiply vector 4") {
    val mat = Mat4i(
      0, 1, 0, 0,
      0, 0, 0, 1,
      1, 0, 0, 0,
      0, 0, 1, 0
    )
    assert(mat * (2, 3, 4, 5) == Vec4i(3, 5, 2, 4))
  }

  test("Test multiply vector 5") {
    val mat = Mat4i(
      0, 1, 0, 0,
      0, 0, 0, 1,
      1, 0, 0, 0,
      0, 0, 1, 0
    )
    assert(mat * (2.0f, 3.0f, 4.0f, 5.0f) == Vec4f(3.0f, 5.0f, 2.0f, 4.0f))
  }

  test("Test multiply vector 6") {
    val mat = Mat4i(
      0, 1, 0, 0,
      0, 0, 0, 1,
      1, 0, 0, 0,
      0, 0, 1, 0
    )
    assert(mat * (2.0, 3.0, 4.0, 5.0) == Vec4d(3.0, 5.0, 2.0, 4.0))
  }

  test("Test transposed") {
    assert(Mat4i(
      0, 1, 0, 0,
      0, 0, 0, 1,
      1, 0, 0, 0,
      0, 0, 1, 0
    ).transposed == Mat4i(
      0, 0, 1, 0,
      1, 0, 0, 0,
      0, 0, 0, 1,
      0, 1, 0, 0
    ))
  }

  test("Test symmetric") {
    assert(Mat4i(
      0, 1, 2, 3,
      1, 0, 4, 5,
      2, 4, 0, 6,
      3, 5, 6, 0
    ).isSymmetric)
  }

  test("Test skew symmetric") {
    assert(Mat4i(
      0, 1, 2, 3,
      -1, 0, 4, 5,
      -2, -4, 0, 6,
      -3, -5, -6, 0
    ).isSkewSymmetric)
  }

  test("Test multiply matrix 1") {
    val a = Mat4i(
      1, 2, 3, 4,
      2, 3, 4, 1,
      3, 4, 1, 2,
      4, 1, 2, 3
    )
    val b = Mat4i(
      3, 4, 2, 1,
      4, 2, 1, 3,
      2, 1, 3, 4,
      1, 3, 4, 2
    )
    assert(a * b == Mat4i(
      21, 23, 29, 27,
      27, 21, 23, 29,
      29, 27, 21, 23,
      23, 29, 27, 21
    ))
  }

  test("Test multiply matrix 2") {
    val a = Mat4i(
      1, 2, 3, 4,
      2, 3, 4, 1,
      3, 4, 1, 2,
      4, 1, 2, 3
    )
    val b = Mat4f(
      3.0f, 4.0f, 2.0f, 1.0f,
      4.0f, 2.0f, 1.0f, 3.0f,
      2.0f, 1.0f, 3.0f, 4.0f,
      1.0f, 3.0f, 4.0f, 2.0f
    )
    assert(a * b == Mat4f(
      21.0f, 23.0f, 29.0f, 27.0f,
      27.0f, 21.0f, 23.0f, 29.0f,
      29.0f, 27.0f, 21.0f, 23.0f,
      23.0f, 29.0f, 27.0f, 21.0f
    ))
  }

  test("Test multiply matrix 3") {
    val a = Mat4i(
      1, 2, 3, 4,
      2, 3, 4, 1,
      3, 4, 1, 2,
      4, 1, 2, 3
    )
    val b = Mat4d(
      3.0, 4.0, 2.0, 1.0,
      4.0, 2.0, 1.0, 3.0,
      2.0, 1.0, 3.0, 4.0,
      1.0, 3.0, 4.0, 2.0
    )
    assert(a * b == Mat4d(
      21.0, 23.0, 29.0, 27.0,
      27.0, 21.0, 23.0, 29.0,
      29.0, 27.0, 21.0, 23.0,
      23.0, 29.0, 27.0, 21.0
    ))
  }

  test("Test power") {
    val a = Mat4i(
      1, 2, 3, 4,
      2, 3, 4, 1,
      3, 4, 1, 2,
      4, 1, 2, 3
    )
    assert((a power 3) == (a * a * a))
  }
}
