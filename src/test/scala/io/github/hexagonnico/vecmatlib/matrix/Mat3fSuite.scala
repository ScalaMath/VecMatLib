package io.github.hexagonnico.vecmatlib.matrix

import io.github.hexagonnico.vecmatlib.vector.Vec3f
import org.scalatest.funsuite.AnyFunSuite

class Mat3fSuite extends AnyFunSuite {

  test("Sum of matrices") {
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

  test("Negative matrix") {
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

  test("Subtraction of matrices") {
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

  test("Matrix multiplied by a scalar") {
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

  test("Matrix multiplied by a scalar commutativity") {
    assert(1.5f * Mat3f(
      1.0f, 1.0f, 1.0f,
      1.0f, 1.0f, 1.0f,
      1.0f, 1.0f, 2.0f
    ) == Mat3f(
      1.5f, 1.5f, 1.5f,
      1.5f, 1.5f, 1.5f,
      1.5f, 1.5f, 3.0f
    ))
  }

  test("Matrix-vector product") {
    val mat = Mat3f(
      0.0f, 1.0f, 0.0f,
      0.0f, 0.0f, 1.0f,
      1.0f, 0.0f, 0.0f
    )
    val vec = Vec3f(2.0f, 3.0f, 4.0f)
    assert(mat * vec == Vec3f(3.0f, 4.0f, 2.0f))
  }

  test("Matrix-vector product by values") {
    val mat = Mat3f(
      0.0f, 1.0f, 0.0f,
      0.0f, 0.0f, 1.0f,
      1.0f, 0.0f, 0.0f
    )
    assert(mat * (2.0f, 3.0f, 4.0f) == Vec3f(3.0f, 4.0f, 2.0f))
  }

  test("Transposed") {
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

  test("Symmetric matrix") {
    assert(Mat3f(
      0.0f, 1.0f, 2.0f,
      1.0f, 0.0f, 4.0f,
      2.0f, 4.0f, 0.0f
    ).isSymmetric)
  }

  test("Skew symmetric matrix") {
    assert(Mat3f(
      0.0f, 1.0f, 2.0f,
      -1.0f, 0.0f, 4.0f,
      -2.0f, -4.0f, 0.0f
    ).isSkewSymmetric)
  }

  test("Matrix product") {
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

  test("Matrix power") {
    val a = Mat3f(
      1.0f, 2.0f, 3.0f,
      2.0f, 3.0f, 4.0f,
      3.0f, 4.0f, 1.0f
    )
    assert((a power 3) == (a * a * a))
  }

  test("Matrix determinant") {
    val a = Mat3f(
      2.0f, 1.0f, 2.0f,
      1.0f, 2.0f, 2.0f,
      2.0f, 0.0f, 0.0f
    )
    assert(a.determinant == -4.0f)
  }
}
