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

  test("Int move toward") {
    assert(moveToward(1, 5, 2) == 3)
    assert(moveToward(1, 5, 6) == 5)
    assert(moveToward(5, 1, 2) == 3)
    assert(moveToward(5, 1, 6) == 1)
  }

  test("Long move toward") {
    assert(moveToward(1L, 5L, 2L) == 3L)
    assert(moveToward(1L, 5L, 6L) == 5L)
    assert(moveToward(5L, 1L, 2L) == 3L)
    assert(moveToward(5L, 1L, 6L) == 1L)
  }

  test("Float move toward") {
    assert(moveToward(1.0f, 2.0f, 0.6f) == 1.6f)
    assert(moveToward(1.0f, 2.0f, 3.0f) == 2.0f)
    assert(moveToward(2.0f, 1.0f, 0.6f) == 1.4f)
    assert(moveToward(2.0f, 1.0f, 3.0f) == 1.0f)
  }

  test("Double move toward") {
    assert(moveToward(1.0, 2.0, 0.6) == 1.6)
    assert(moveToward(1.0, 2.0, 3.0) == 2.0)
    assert(moveToward(2.0, 1.0, 0.6) == 1.4)
    assert(moveToward(2.0, 1.0, 3.0) == 1.0)
  }

  test("Map int range") {
    assert(map(5, 0, 10, 0, 100) == 50)
    assert(map(12, 0, 10, 0, 100) == 120)
    assert(map(-1, 0, 10, 0, 100) == -10)
  }

  test("Map long range") {
    assert(map(5L, 0L, 10L, 0L, 100L) == 50L)
    assert(map(12L, 0L, 10L, 0L, 100L) == 120L)
    assert(map(-1L, 0L, 10L, 0L, 100L) == -10L)
  }

  test("Map float range") {
    assert(map(5.0f, 0.0f, 10.0f, 0.0f, 1.0f) == 0.5f)
    assert(map(12.0f, 0.0f, 10.0f, 0.0f, 1.0f) == 1.2f)
    assert(map(-1.0f, 0.0f, 10.0f, 0.0f, 1.0f) == -0.1f)
  }

  test("Map double range") {
    assert(map(5.0, 0.0, 10.0, 0.0, 1.0) == 0.5)
    assert(map(12.0, 0.0, 10.0, 0.0, 1.0) == 1.2)
    assert(map(-1.0, 0.0, 10.0, 0.0, 1.0) == -0.1)
  }

  test("Smoothstep float") {
    assert(smoothstep(3.0f, 4.0f, 3.5f) == 0.5f)
    assert(smoothstep(3.0f, 4.0f, 2.0f) == 0.0f)
    assert(smoothstep(3.0f, 4.0f, 5.0f) == 1.0f)
  }

  test("Smoothstep double") {
    assert(smoothstep(3.0, 4.0, 3.5) == 0.5)
    assert(smoothstep(3.0, 4.0, 2.0) == 0.0)
    assert(smoothstep(3.0, 4.0, 5.0) == 1.0)
  }

  test("Float quadratic Bézier curve") {
    val (p0, p1, control, t) = (2.0f, 5.0f, 4.0f, 0.35f)
    val l1 = lerp(p0, control, t)
    val l2 = lerp(control, p1, t)
    val res = lerp(l1, l2, t)
    assert(bezierInterpolate(p0, p1, control, t) == res)
  }

  test("Double quadratic Bézier curve") {
    val (p0, p1, control, t) = (2.0, 5.0, 4.0, 0.35)
    val l1 = lerp(p0, control, t)
    val l2 = lerp(control, p1, t)
    val res = lerp(l1, l2, t)
    assert(bezierInterpolate(p0, p1, control, t) == res)
  }

  ignore("Float quadratic Bézier derivative") {
    // TODO: Quadratic Bézier derivative
  }

  ignore("Double quadratic Bézier derivative") {
    // TODO: Quadratic Bézier derivative
  }

  test("Float cubic Bézier curve") {
    val (p0, p3, p1, p2, t) = (1.0f, 5.0f, 2.0f, 4.0f, 0.35f)
    val m1 = lerp(p0, p1, t)
    val m2 = lerp(p1, p2, t)
    val m3 = lerp(p2, p3, t)
    val l1 = lerp(m1, m2, t)
    val l2 = lerp(m2, m3, t)
    val res = lerp(l1, l2, t)
    assert(bezierInterpolate(p0, p3, p1, p2, t) == res)
  }

  test("Double cubic Bézier curve") {
    val (p0, p3, p1, p2, t) = (1.0, 5.0, 2.0, 4.0, 0.35)
    val m1 = lerp(p0, p1, t)
    val m2 = lerp(p1, p2, t)
    val m3 = lerp(p2, p3, t)
    val l1 = lerp(m1, m2, t)
    val l2 = lerp(m2, m3, t)
    val res = lerp(l1, l2, t)
    assert(bezierInterpolate(p0, p3, p1, p2, t) == res)
  }

  ignore("Float cubic Bézier derivative") {
    // TODO: Cubic Bézier derivative
  }

  ignore("Double cubic Bézier derivative") {
    // TODO: Cubic Bézier derivative
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
