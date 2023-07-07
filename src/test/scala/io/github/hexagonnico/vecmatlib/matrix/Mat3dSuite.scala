package io.github.hexagonnico.vecmatlib.matrix

import io.github.hexagonnico.vecmatlib.vector.Vec3d
import org.scalatest.funsuite.AnyFunSuite

class Mat3dSuite extends AnyFunSuite {

  test("Sum of matrices") {
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

  test("Negative matrix") {
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

  test("Subtraction of matrices") {
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

  test("Matrix multiplied by a scalar") {
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

  test("Matrix multiplied by a scalar commutativity") {
    assert(1.5 * Mat3d(
      1.0, 1.0, 1.0,
      1.0, 1.0, 1.0,
      1.0, 1.0, 2.0
    ) == Mat3d(
      1.5, 1.5, 1.5,
      1.5, 1.5, 1.5,
      1.5, 1.5, 3.0
    ))
  }

  test("Matrix-vector product") {
    val mat = Mat3d(
      0.0, 1.0, 0.0,
      0.0, 0.0, 1.0,
      1.0, 0.0, 0.0
    )
    val vec = Vec3d(2.0, 3.0, 4.0)
    assert(mat * vec == Vec3d(3.0, 4.0, 2.0))
  }

  test("Matrix-vector product by values") {
    val mat = Mat3d(
      0.0, 1.0, 0.0,
      0.0, 0.0, 1.0,
      1.0, 0.0, 0.0
    )
    assert(mat * (2.0, 3.0, 4.0) == Vec3d(3.0, 4.0, 2.0))
  }

  test("Transposed") {
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

  test("Symmetric matrix") {
    assert(Mat3d(
      0.0, 1.0, 2.0,
      1.0, 0.0, 4.0,
      2.0, 4.0, 0.0
    ).isSymmetric)
  }

  test("Skew symmetric matrix") {
    assert(Mat3d(
      0.0, 1.0, 2.0,
      -1.0, 0.0, 4.0,
      -2.0, -4.0, 0.0
    ).isSkewSymmetric)
  }

  test("Matrix product") {
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

  test("Matrix power") {
    val a = Mat3d(
      1.0, 2.0, 3.0,
      2.0, 3.0, 4.0,
      3.0, 4.0, 1.0
    )
    assert((a power 3) == (a * a * a))
  }

  test("Matrix determinant") {
    val a = Mat3d(
      2.0, 1.0, 2.0,
      1.0, 2.0, 2.0,
      2.0, 0.0, 0.0
    )
    assert(a.determinant == -4.0)
  }
}
