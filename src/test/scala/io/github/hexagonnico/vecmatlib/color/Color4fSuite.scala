package io.github.hexagonnico.vecmatlib.color

import org.scalatest.funsuite.AnyFunSuite

class Color4fSuite extends AnyFunSuite {

  test("Test color plus three values") {
    val color = Color4f(1.0f, 0.5f, 0.1f)
    assert(color + (1.0f, 0.5f, 0.4f) == Color4f(2.0f, 1.0f, 0.5f))
  }

  test("Test color plus four values") {
    val color = Color4f(1.0f, 0.5f, 0.1f, 0.5f)
    assert(color + (1.0f, 0.5f, 0.4f, 0.4f) == Color4f(2.0f, 1.0f, 0.5f, 0.9f))
  }

  test("Test color sum") {
    val a = Color4f(0.1f, 0.2f, 0.3f)
    val b = Color4f(0.2f, 0.3f, 0.3f)
    assert(a + b == Color4f(0.3f, 0.5f, 0.6f, 2.0f))
  }

  test("Test color minus three values") {
    val color = Color4f(1.0f, 0.5f, 0.4f)
    assert(color - (0.5f, 0.2f, 0.1f) == Color4f(0.5f, 0.3f, 0.3f))
  }

  test("Test color minus four values") {
    val color = Color4f(1.0f, 0.5f, 0.4f)
    assert(color - (0.5f, 0.2f, 0.1f, 0.5f) == Color4f(0.5f, 0.3f, 0.3f, 0.5f))
  }

  test("Test color difference") {
    val a = Color4f(0.1f, 0.2f, 0.4f)
    val b = Color4f(0.2f, 0.4f, 0.8f)
    assert(b - a == Color4f(0.1f, 0.2f, 0.4f, 0.0f))
  }

  test("Test color multiplication with three values") {
    val color = Color4f(1.0f, 0.8f, 0.6f)
    assert(color * (0.5f, 0.5f, 0.5f) == Color4f(0.5f, 0.4f, 0.3f))
  }

  test("Test color multiplication with four values") {
    val color = Color4f(1.0f, 0.8f, 0.6f)
    assert(color * (0.5f, 0.5f, 0.5f, 0.75f) == Color4f(0.5f, 0.4f, 0.3f, 0.75f))
  }

  test("Test color blending") {
    val a = Color4f(0.5f, 0.8f, 1.0f)
    val b = Color4f(0.5f, 0.25f, 1.0f, 0.75f)
    assert(a * b == Color4f(0.25f, 0.2f, 1.0f, 0.75f))
  }

  test("Test color multiplication with a scalar") {
    val color = Color4f(1.0f, 0.9f, 0.8f)
    assert(color * 0.5f == Color4f(0.5f, 0.45f, 0.4f, 0.5f))
  }

  test("Test color multiplication with a scalar commutativity") {
    val color = Color4f(1.0f, 0.9f, 0.8f)
    assert(0.5f * color == Color4f(0.5f, 0.45f, 0.4f, 0.5f))
  }

  test("Test color inverse") {
    val color = Color4f(0.3f, 0.3f, 0.3f)
    assert(color.invert == Color4f(0.7f, 0.7f, 0.7f))
  }

  test("Test color darker") {
    val color = Color4f(0.0f, 1.0f, 0.0f)
    assert(color.darker(0.2f) == Color4f(0.0f, 0.8f, 0.0f))
  }

  test("Test color lighter") {
    val color = Color4f(0.0f, 0.5f, 0.0f)
    assert(color.lighter(0.5f) == Color4f(0.5f, 0.75f, 0.5f))
  }
}
