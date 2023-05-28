package io.github.hexagonnico.vecmatlib.matrix

import io.github.hexagonnico.vecmatlib.vector.Vec2i
import org.scalatest.funsuite.AnyFunSuite

class Mat2iSuite extends AnyFunSuite {

  test("Sum of matrices") {
    val a = Mat2i(
      1, 2,
      2, 3
    )
    val b = Mat2i(
      3, 4,
      4, 2
    )
    assert(a + b == Mat2i(
      4, 6,
      6, 5
    ))
  }

  test("Negative matrix") {
    assert(Mat2i(
      1, 2,
      2, 3
    ).negated == Mat2i(
      -1, -2,
      -2, -3
    ))
  }

  test("Subtraction of matrices") {
    val a = Mat2i(
      4, 6,
      6, 5
    )
    val b = Mat2i(
      3, 4,
      4, 2
    )
    assert(a - b == Mat2i(
      1, 2,
      2, 3
    ))
  }

  test("Matrix multiplied by a scalar") {
    assert(Mat2i(
      1, 1,
      1, 1
    ) * 2 == Mat2i(
      2, 2,
      2, 2
    ))
  }

  test("Matrix-vector product") {
    val mat = Mat2i(
      0, 1,
      1, 0
    )
    val vec = Vec2i(2, 3)
    assert(mat * vec == Vec2i(3, 2))
  }

  test("Matrix-vector product by values") {
    val mat = Mat2i(
      0, 1,
      1, 0
    )
    assert(mat * (2, 3) == Vec2i(3, 2))
  }

  test("Transposed") {
    assert(Mat2i(
      1, 2,
      3, 4
    ).transposed == Mat2i(
      1, 3,
      2, 4
    ))
  }

  test("Symmetric matrix") {
    assert(Mat2i(
      0, 1,
      1, 0
    ).isSymmetric)
  }

  test("Skew symmetric matrix") {
    assert(Mat2i(
      0, 1,
      -1, 0
    ).isSkewSymmetric)
  }

  test("Matrix product") {
    val a = Mat2i(
      1, 2,
      2, 3
    )
    val b = Mat2i(
      3, 4,
      4, 2
    )
    assert(a * b == Mat2i(
      11, 8,
      18, 14
    ))
  }

  test("Matrix power") {
    val a = Mat2i(
      1, 2,
      2, 3
    )
    assert((a power 3) == (a * a * a))
  }

  test("Matrix determinant") {
    val a = Mat2i(
      4, 1,
      3, 2
    )
    assert(a.determinant == 5)
  }
}
