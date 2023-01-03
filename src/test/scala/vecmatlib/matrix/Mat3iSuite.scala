package vecmatlib.matrix

import org.scalatest.funsuite.AnyFunSuite
import vecmatlib.vector.Vec3i

class Mat3iSuite extends AnyFunSuite {

  test("Sum of matrices") {
    val a = Mat3i(
      1, 2, 3,
      2, 3, 4,
      3, 4, 1
    )
    val b = Mat3i(
      3, 4, 2,
      4, 2, 1,
      2, 1, 3
    )
    assert(a + b == Mat3i(
      4, 6, 5,
      6, 5, 5,
      5, 5, 4
    ))
  }

  test("Negative matrix") {
    assert(Mat3i(
      1, 2, 3,
      2, 3, 4,
      3, 4, 1
    ).negated == Mat3i(
      -1, -2, -3,
      -2, -3, -4,
      -3, -4, -1
    ))
  }

  test("Subtraction of matrices") {
    val a = Mat3i(
      4, 6, 5,
      6, 5, 5,
      5, 5, 4
    )
    val b = Mat3i(
      3, 4, 2,
      4, 2, 1,
      2, 1, 3
    )
    assert(a - b == Mat3i(
      1, 2, 3,
      2, 3, 4,
      3, 4, 1
    ))
  }

  test("Matrix multiplied by a scalar") {
    assert(Mat3i(
      1, 1, 1,
      1, 1, 1,
      1, 1, 2
    ) * 2 == Mat3i(
      2, 2, 2,
      2, 2, 2,
      2, 2, 4
    ))
  }

  test("Matrix-vector product") {
    val mat = Mat3i(
      0, 1, 0,
      0, 0, 1,
      1, 0, 0
    )
    val vec = Vec3i(2, 3, 4)
    assert(mat * vec == Vec3i(3, 4, 2))
  }

  test("Matrix-vector product by values") {
    val mat = Mat3i(
      0, 1, 0,
      0, 0, 1,
      1, 0, 0
    )
    assert(mat * (2, 3, 4) == Vec3i(3, 4, 2))
  }

  test("Transposed") {
    assert(Mat3i(
      0, 1, 0,
      0, 0, 1,
      1, 0, 0
    ).transposed == Mat3i(
      0, 0, 1,
      1, 0, 0,
      0, 1, 0
    ))
  }

  test("Symmetric matrix") {
    assert(Mat3i(
      0, 1, 2,
      1, 0, 4,
      2, 4, 0
    ).isSymmetric)
  }

  test("Skew symmetric matrix") {
    assert(Mat3i(
      0, 1, 2,
      -1, 0, 4,
      -2, -4, 0
    ).isSkewSymmetric)
  }

  test("Matrix product") {
    val a = Mat3i(
      1, 2, 3,
      2, 3, 4,
      3, 4, 1
    )
    val b = Mat3i(
      3, 4, 2,
      4, 2, 1,
      2, 1, 3
    )
    assert(a * b == Mat3i(
      17, 11, 13,
      26, 18, 19,
      27, 21, 13
    ))
  }

  test("Matrix power") {
    val a = Mat3i(
      1, 2, 3,
      2, 3, 4,
      3, 4, 1
    )
    assert((a power 3) == (a * a * a))
  }

  test("Matrix determinant") {
    val a = Mat3i(
      2, 1, 2,
      1, 2, 2,
      2, 0, 0
    )
    assert(a.determinant == -4)
  }
}
