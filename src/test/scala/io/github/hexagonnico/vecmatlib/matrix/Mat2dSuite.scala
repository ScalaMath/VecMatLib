package io.github.hexagonnico.vecmatlib.matrix

import io.github.hexagonnico.vecmatlib.vector.Vec2d
import org.scalatest.funsuite.AnyFunSuite

class Mat2dSuite extends AnyFunSuite {

  test("Sum of matrices") {
    val a = Mat2d(
      1.0, 2.0,
      2.0, 3.0
    )
    val b = Mat2d(
      3.0, 4.0,
      4.0, 2.0
    )
    assert(a + b == Mat2d(
      4.0, 6.0,
      6.0, 5.0
    ))
  }

  test("Negative matrix") {
    assert(Mat2d(
      1.0, 2.0,
      2.0, 3.0
    ).negated == Mat2d(
      -1.0, -2.0,
      -2.0, -3.0
    ))
  }

  test("Subtraction of matrices") {
    val a = Mat2d(
      4.0, 6.0,
      6.0, 5.0
    )
    val b = Mat2d(
      3.0, 4.0,
      4.0, 2.0
    )
    assert(a - b == Mat2d(
      1.0, 2.0,
      2.0, 3.0
    ))
  }

  test("Matrix multiplied by a scalar") {
    assert(Mat2d(
      1.0, 1.0,
      1.0, 1.0
    ) * 1.5 == Mat2d(
      1.5, 1.5,
      1.5, 1.5
    ))
  }

  test("Matrix-vector product") {
    val mat = Mat2d(
      0.0, 1.0,
      1.0, 0.0
    )
    val vec = Vec2d(2.0, 3.0)
    assert(mat * vec == Vec2d(3.0, 2.0))
  }

  test("Matrix-vector product by values") {
    val mat = Mat2d(
      0.0, 1.0,
      1.0, 0.0
    )
    assert(mat * (2.0, 3.0) == Vec2d(3.0, 2.0))
  }

  test("Transposed") {
    assert(Mat2d(
      1.0, 2.0,
      3.0, 4.0
    ).transposed == Mat2d(
      1.0, 3.0,
      2.0, 4.0
    ))
  }

  test("Symmetric matrix") {
    assert(Mat2d(
      0.0, 1.0,
      1.0, 0.0
    ).isSymmetric)
  }

  test("Skew symmetric matrix") {
    assert(Mat2d(
      0.0, 1.0,
      -1.0, 0.0
    ).isSkewSymmetric)
  }

  test("Matrix product") {
    val a = Mat2d(
      1.0, 2.0,
      2.0, 3.0
    )
    val b = Mat2d(
      3.0, 4.0,
      4.0, 2.0
    )
    assert(a * b == Mat2d(
      11.0, 8.0,
      18.0, 14.0
    ))
  }

  test("Matrix power") {
    val a = Mat2d(
      1.0, 2.0,
      2.0, 3.0
    )
    assert((a power 3) == (a * a * a))
  }

  test("Matrix determinant") {
    val a = Mat2d(
      4.0, 1.0,
      3.0, 2.0
    )
    assert(a.determinant == 5.0)
  }
}
