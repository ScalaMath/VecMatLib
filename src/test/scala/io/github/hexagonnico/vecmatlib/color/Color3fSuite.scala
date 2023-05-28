package io.github.hexagonnico.vecmatlib.color

import org.scalatest.funsuite.AnyFunSuite

class Color3fSuite extends AnyFunSuite {

  test("Test color plus three values") {
    val color = Color3f(1.0f, 0.5f, 0.1f)
    assert(color + (1.0f, 0.5f, 0.4f) == Color3f(2.0f, 1.0f, 0.5f))
  }

  test("Test color plus four values") {
    val color = Color3f(1.0f, 0.5f, 0.1f)
    assert(color + (1.0f, 0.5f, 0.4f, 1.0f) == Color4f(2.0f, 1.0f, 0.5f, 1.0f))
  }

  test("Test color sum") {
    val a = Color3f(0.1f, 0.2f, 0.3f)
    val b = Color3f(0.2f, 0.3f, 0.3f)
    assert(a + b == Color3f(0.3f, 0.5f, 0.6f))
  }

  test("Test color minus three values") {
    val color = Color3f(1.0f, 0.5f, 0.4f)
    assert(color - (0.5f, 0.2f, 0.1f) == Color3f(0.5f, 0.3f, 0.3f))
  }

  test("Test color minus four values") {
    val color = Color3f(1.0f, 0.5f, 0.4f)
    assert(color - (0.5f, 0.2f, 0.1f, 1.0f) == Color4f(0.5f, 0.3f, 0.3f, 0.0f))
  }

  test("Test color difference") {
    val a = Color3f(0.1f, 0.2f, 0.4f)
    val b = Color3f(0.2f, 0.4f, 0.8f)
    assert(b - a == Color3f(0.1f, 0.2f, 0.4f))
  }

  test("Test color multiplication with three values") {
    val color = Color3f(1.0f, 0.8f, 0.6f)
    assert(color * (0.5f, 0.5f, 0.5f) == Color3f(0.5f, 0.4f, 0.3f))
  }

  test("Test color multiplication with four values") {
    val color = Color3f(1.0f, 0.8f, 0.6f)
    assert(color * (0.5f, 0.5f, 0.5f, 0.75f) == Color4f(0.5f, 0.4f, 0.3f, 0.75f))
  }

  test("Test color blending") {
    val a = Color3f(0.5f, 0.8f, 1.0f)
    val b = Color3f(0.5f, 0.25f, 1.0f)
    assert(a * b == Color3f(0.25f, 0.2f, 1.0f))
  }

  test("Test color multiplication with a scalar") {
    val color = Color3f(1.0f, 0.9f, 0.8f)
    assert(color * 0.5f == Color3f(0.5f, 0.45f, 0.4f))
  }

  test("Test color inverse") {
    val color = Color3f(0.3f, 0.3f, 0.3f)
    assert(color.invert == Color3f(0.7f, 0.7f, 0.7f))
  }

  test("Test color darker") {
    val color = Color3f(0.0f, 1.0f, 0.0f)
    assert(color.darker(0.2f) == Color3f(0.0f, 0.8f, 0.0f))
  }

  test("Test color lighter") {
    val color = Color3f(0.0f, 0.5f, 0.0f)
    assert(color.lighter(0.5f) == Color3f(0.5f, 0.75f, 0.5f))
  }
}
