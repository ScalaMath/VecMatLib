package io.github.hexagonnico.vecmatlib.matrix

import io.github.hexagonnico.vecmatlib.vector.Vec4i
import org.scalatest.funsuite.AnyFunSuite

class Mat4iSuite extends AnyFunSuite {

  test("Sum of matrices") {
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

  test("Negative matrix") {
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

  test("Subtraction of matrices") {
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

  test("Matrix multiplied by a scalar") {
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

  test("Matrix-vector product") {
    val mat = Mat4i(
      0, 1, 0, 0,
      0, 0, 0, 1,
      1, 0, 0, 0,
      0, 0, 1, 0
    )
    val vec = Vec4i(2, 3, 4, 5)
    assert(mat * vec == Vec4i(3, 5, 2, 4))
  }

  test("Matrix-vector product by values") {
    val mat = Mat4i(
      0, 1, 0, 0,
      0, 0, 0, 1,
      1, 0, 0, 0,
      0, 0, 1, 0
    )
    assert(mat * (2, 3, 4, 5) == Vec4i(3, 5, 2, 4))
  }

  test("Transposed") {
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

  test("Symmetric matrix") {
    assert(Mat4i(
      0, 1, 2, 3,
      1, 0, 4, 5,
      2, 4, 0, 6,
      3, 5, 6, 0
    ).isSymmetric)
  }

  test("Skew symmetric matrix") {
    assert(Mat4i(
      0, 1, 2, 3,
      -1, 0, 4, 5,
      -2, -4, 0, 6,
      -3, -5, -6, 0
    ).isSkewSymmetric)
  }

  test("Matrix product") {
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

  test("Matrix power") {
    val a = Mat4i(
      1, 2, 3, 4,
      2, 3, 4, 1,
      3, 4, 1, 2,
      4, 1, 2, 3
    )
    assert((a power 3) == (a * a * a))
  }

  test("Matrix determinant") {
    val a = Mat4i(
      2, 1, 2, 3,
      1, 2, 2, 2,
      2, 0, 0, 0,
      1, 2, 0, 0
    )
    assert(a.determinant == -8)
  }
}
