package io.github.hexagonnico.vecmatlib.quaternion

import org.scalatest.funsuite.AnyFunSuite

class QuaternionSuite extends AnyFunSuite {

  test("Test") {
    val q = Quaternion(4.0, 3.0, 0.0, -4.0)
    println(q)
  }
}
