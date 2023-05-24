package vecmatlib.matrix

import org.scalatest.funsuite.AnyFunSuite
import vecmatlib.vector.Vec2f

class Mat2fSuite extends AnyFunSuite {

  test("Sum of matrices") {
    val a = Mat2f(
      1.0f, 2.0f,
      2.0f, 3.0f
    )
    val b = Mat2f(
      3.0f, 4.0f,
      4.0f, 2.0f
    )
    assert(a + b == Mat2f(
      4.0f, 6.0f,
      6.0f, 5.0f
    ))
  }

  test("Negative matrix") {
    assert(Mat2f(
      1.0f, 2.0f,
      2.0f, 3.0f
    ).negated == Mat2f(
      -1.0f, -2.0f,
      -2.0f, -3.0f
    ))
  }

  test("Subtraction of matrices") {
    val a = Mat2f(
      4.0f, 6.0f,
      6.0f, 5.0f
    )
    val b = Mat2f(
      3.0f, 4.0f,
      4.0f, 2.0f
    )
    assert(a - b == Mat2f(
      1.0f, 2.0f,
      2.0f, 3.0f
    ))
  }

  test("Matrix multiplied by a scalar") {
    assert(Mat2f(
      1.0f, 1.0f,
      1.0f, 1.0f
    ) * 1.5f == Mat2f(
      1.5f, 1.5f,
      1.5f, 1.5f
    ))
  }

  test("Matrix-vector product") {
    val mat = Mat2f(
      0.0f, 1.0f,
      1.0f, 0.0f
    )
    val vec = Vec2f(2.0f, 3.0f)
    assert(mat * vec == Vec2f(3.0f, 2.0f))
  }

  test("Matrix-vector product by values") {
    val mat = Mat2f(
      0.0f, 1.0f,
      1.0f, 0.0f
    )
    assert(mat * (2.0f, 3.0f) == Vec2f(3.0f, 2.0f))
  }

  test("Transposed") {
    assert(Mat2f(
      1.0f, 2.0f,
      3.0f, 4.0f
    ).transposed == Mat2f(
      1.0f, 3.0f,
      2.0f, 4.0f
    ))
  }

  test("Symmetric matrix") {
    assert(Mat2f(
      0.0f, 1.0f,
      1.0f, 0.0f
    ).isSymmetric)
  }

  test("Skew symmetric matrix") {
    assert(Mat2f(
      0.0f, 1.0f,
      -1.0f, 0.0f
    ).isSkewSymmetric)
  }

  test("Matrix product") {
    val a = Mat2f(
      1.0f, 2.0f,
      2.0f, 3.0f
    )
    val b = Mat2f(
      3.0f, 4.0f,
      4.0f, 2.0f
    )
    assert(a * b == Mat2f(
      11.0f, 8.0f,
      18.0f, 14.0f
    ))
  }

  test("Matrix power") {
    val a = Mat2f(
      1.0f, 2.0f,
      2.0f, 3.0f
    )
    assert((a power 3) == (a * a * a))
  }

  test("Matrix determinant") {
    val a = Mat2f(
      4.0f, 1.0f,
      3.0f, 2.0f
    )
    assert(a.determinant == 5.0f)
  }
}
