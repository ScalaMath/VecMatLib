package vecmatlib.matrix

import org.scalatest.funsuite.AnyFunSuite
import vecmatlib.vector.Vec4f

class Mat4fSuite extends AnyFunSuite {

  test("Sum of matrices") {
    val a = Mat4f(
      1.0f, 2.0f, 3.0f, 4.0f,
      2.0f, 3.0f, 4.0f, 1.0f,
      3.0f, 4.0f, 1.0f, 2.0f,
      4.0f, 1.0f, 2.0f, 3.0f
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

  test("Negative matrix") {
    assert(Mat4f(
      1.0f, 2.0f, 3.0f, 4.0f,
      2.0f, 3.0f, 4.0f, 1.0f,
      3.0f, 4.0f, 1.0f, 2.0f,
      4.0f, 1.0f, 2.0f, 3.0f
    ).negated == Mat4f(
      -1.0f, -2.0f, -3.0f, -4.0f,
      -2.0f, -3.0f, -4.0f, -1.0f,
      -3.0f, -4.0f, -1.0f, -2.0f,
      -4.0f, -1.0f, -2.0f, -3.0f
    ))
  }

  test("Subtraction of matrices") {
    val a = Mat4f(
      4.0f, 6.0f, 5.0f, 5.0f,
      6.0f, 5.0f, 5.0f, 4.0f,
      5.0f, 5.0f, 4.0f, 6.0f,
      5.0f, 4.0f, 6.0f, 5.0f
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

  test("Matrix multiplied by a scalar") {
    assert(Mat4f(
      1.0f, 1.0f, 1.0f, 1.0f,
      1.0f, 1.0f, 1.0f, 2.0f,
      1.0f, 1.0f, 2.0f, 2.0f,
      1.0f, 2.0f, 2.0f, 3.0f
    ) * 1.5f == Mat4f(
      1.5f, 1.5f, 1.5f, 1.5f,
      1.5f, 1.5f, 1.5f, 3.0f,
      1.5f, 1.5f, 3.0f, 3.0f,
      1.5f, 3.0f, 3.0f, 4.5f
    ))
  }

  test("Matrix-vector product") {
    val mat = Mat4f(
      0.0f, 1.0f, 0.0f, 0.0f,
      0.0f, 0.0f, 0.0f, 1.0f,
      1.0f, 0.0f, 0.0f, 0.0f,
      0.0f, 0.0f, 1.0f, 0.0f
    )
    val vec = Vec4f(2.0f, 3.0f, 4.0f, 5.0f)
    assert(mat * vec == Vec4f(3.0f, 5.0f, 2.0f, 4.0f))
  }

  test("Matrix-vector product by values") {
    val mat = Mat4f(
      0.0f, 1.0f, 0.0f, 0.0f,
      0.0f, 0.0f, 0.0f, 1.0f,
      1.0f, 0.0f, 0.0f, 0.0f,
      0.0f, 0.0f, 1.0f, 0.0f
    )
    assert(mat * (2.0f, 3.0f, 4.0f, 5.0f) == Vec4f(3.0f, 5.0f, 2.0f, 4.0f))
  }

  test("Transposed") {
    assert(Mat4f(
      0.0f, 1.0f, 0.0f, 0.0f,
      0.0f, 0.0f, 0.0f, 1.0f,
      1.0f, 0.0f, 0.0f, 0.0f,
      0.0f, 0.0f, 1.0f, 0.0f
    ).transposed == Mat4f(
      0.0f, 0.0f, 1.0f, 0.0f,
      1.0f, 0.0f, 0.0f, 0.0f,
      0.0f, 0.0f, 0.0f, 1.0f,
      0.0f, 1.0f, 0.0f, 0.0f
    ))
  }

  test("Symmetric matrix") {
    assert(Mat4f(
      0.0f, 1.0f, 2.0f, 3.0f,
      1.0f, 0.0f, 4.0f, 5.0f,
      2.0f, 4.0f, 0.0f, 6.0f,
      3.0f, 5.0f, 6.0f, 0.0f
    ).isSymmetric)
  }

  test("Skew symmetric matrix") {
    assert(Mat4f(
      0.0f, 1.0f, 2.0f, 3.0f,
      -1.0f, 0.0f, 4.0f, 5.0f,
      -2.0f, -4.0f, 0.0f, 6.0f,
      -3.0f, -5.0f, -6.0f, 0.0f
    ).isSkewSymmetric)
  }

  test("Matrix product") {
    val a = Mat4f(
      1.0f, 2.0f, 3.0f, 4.0f,
      2.0f, 3.0f, 4.0f, 1.0f,
      3.0f, 4.0f, 1.0f, 2.0f,
      4.0f, 1.0f, 2.0f, 3.0f
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

  test("Matrix power") {
    val a = Mat4f(
      1.0f, 2.0f, 3.0f, 4.0f,
      2.0f, 3.0f, 4.0f, 1.0f,
      3.0f, 4.0f, 1.0f, 2.0f,
      4.0f, 1.0f, 2.0f, 3.0f
    )
    assert((a power 3) == (a * a * a))
  }

  test("Matrix determinant") {
    val a = Mat4f(
      2.0f, 1.0f, 2.0f, 3.0f,
      1.0f, 2.0f, 2.0f, 2.0f,
      2.0f, 0.0f, 0.0f, 0.0f,
      1.0f, 2.0f, 0.0f, 0.0f
    )
    assert(a.determinant == -8.0f)
  }
}
