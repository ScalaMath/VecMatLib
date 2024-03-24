package io.github.scalamath

import org.scalatest.funsuite.AnyFunSuite

class ScalaMathSuite extends AnyFunSuite {

  test("Clamp int") {
    assert(clamp(5, 0, 10) == 5)
    assert(clamp(-1, 0, 10) == 0)
    assert(clamp(12, 0, 10) == 10)
  }

  test("Clamp float") {
    assert(clamp(0.5f, 0.0f, 1.0f) == 0.5f)
    assert(clamp(-1.0f, 0.0f, 1.0f) == 0.0f)
    assert(clamp(1.2f, 0.0f, 1.0f) == 1.0f)
  }

  test("Clamp double") {
    assert(clamp(0.5, 0.0, 1.0) == 0.5)
    assert(clamp(-1.0, 0.0, 1.0) == 0.0)
    assert(clamp(1.2, 0.0, 1.0) == 1.0)
  }

  test("Lerp float") {
    assert(lerp(1.0f, 2.0f, 0.5f) == 1.5f)
    assert(lerp(1.0f, 2.0f, 0.25f) == 1.25f)
    assert(lerp(1.0f, 2.0f, 0.75f) == 1.75f)
    assert(lerp(1.0f, 2.0f, 0.0f) == 1.0f)
    assert(lerp(1.0f, 2.0f, 1.0f) == 2.0f)
  }

  test("Lerp double") {
    assert(lerp(1.0, 2.0, 0.5) == 1.5)
    assert(lerp(1.0, 2.0, 0.25) == 1.25)
    assert(lerp(1.0, 2.0, 0.75) == 1.75)
    assert(lerp(1.0, 2.0, 0.0) == 1.0)
    assert(lerp(1.0, 2.0, 1.0) == 2.0)
  }

  test("Float equals approx") {
    assert(equalsApprox(1.0f, 1.0f))
    assert(equalsApprox(1.0f, 0.9999999f))
    assert(!equalsApprox(1.0f, 0.8999999f))
    assert(equalsApprox(Float.PositiveInfinity, Float.PositiveInfinity))
    assert(equalsApprox(Float.NegativeInfinity, Float.NegativeInfinity))
    assert(!equalsApprox(Float.PositiveInfinity, Float.NegativeInfinity))
    assert(!equalsApprox(Float.NaN, Float.NaN))
  }

  test("Double equals approx") {
    assert(equalsApprox(1.0, 1.0))
    assert(equalsApprox(1.0, 0.9999999))
    assert(!equalsApprox(1.0, 0.8999999))
    assert(equalsApprox(Double.PositiveInfinity, Double.PositiveInfinity))
    assert(equalsApprox(Double.NegativeInfinity, Double.NegativeInfinity))
    assert(!equalsApprox(Double.PositiveInfinity, Double.NegativeInfinity))
    assert(!equalsApprox(Double.NaN, Double.NaN))
  }

  test("Float equals approx operator") {
    assert(1.0f ~= 1.0f)
    assert(1.0f ~= 0.9999999f)
    assert(!(1.0f ~= 0.8999999f))
    assert(Float.PositiveInfinity ~= Float.PositiveInfinity)
    assert(Float.NegativeInfinity ~= Float.NegativeInfinity)
    assert(!(Float.PositiveInfinity ~= Float.NegativeInfinity))
    assert(!(Float.NaN ~= Float.NaN))
  }

  test("Double equals approx operator") {
    assert(1.0 ~= 1.0)
    assert(1.0 ~= 0.9999999)
    assert(!(1.0 ~= 0.8999999))
    assert(Double.PositiveInfinity ~= Double.PositiveInfinity)
    assert(Double.NegativeInfinity ~= Double.NegativeInfinity)
    assert(!(Double.PositiveInfinity ~= Double.NegativeInfinity))
    assert(!(Double.NaN ~= Double.NaN))
  }
}
