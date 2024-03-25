package io.github.scalamath.vecmatlib

import org.scalactic.Equality
import org.scalatest.funsuite.AnyFunSuite

class EulerOrderSuite extends AnyFunSuite {

  // https://www.andre-gaschler.com/rotationconverter/

  implicit val equalityQuatd: Equality[Quatd] = (a: Quatd, b: Any) => b match {
    case b: Quatd => a ~= b
    case _ => false
  }

  implicit val equalityVec3d: Equality[Vec3d] = (a: Vec3d, b: Any) => b match {
    case b: Vec3d => a ~= b
    case _ => false
  }

  test("Euler angles to quaternion in XYZ order") {
    val euler = Vec3d(Math.PI / 6.0, Math.PI / 4.0, Math.PI / 3.0)
    val quaternion = Quatd(0.7233174, 0.3919038, 0.2005621, 0.5319757)
    assert(quaternion === EulerOrder.XYZ.toQuaternion(euler))
  }

  test("Euler angles to quaternion in XZY order") {
    val euler = Vec3d(Math.PI / 6.0, Math.PI / 4.0, Math.PI / 3.0)
    val quaternion = Quatd(0.8223632, 0.02226, 0.2005621, 0.5319757)
    assert(quaternion === EulerOrder.XZY.toQuaternion(euler))
  }

  test("Euler angles to quaternion in YXZ order") {
    val euler = Vec3d(Math.PI / 6.0, Math.PI / 4.0, Math.PI / 3.0)
    val quaternion = Quatd(0.8223632, 0.3919038, 0.2005621, 0.3604234)
    assert(quaternion === EulerOrder.YXZ.toQuaternion(euler))
  }

  test("Euler angles to quaternion in YZX order") {
    val euler = Vec3d(Math.PI / 6.0, Math.PI / 4.0, Math.PI / 3.0)
    val quaternion = Quatd(0.7233174, 0.3919038, 0.4396797, 0.3604234)
    assert(quaternion === EulerOrder.YZX.toQuaternion(euler))
  }

  test("Euler angles to quaternion in ZXY order") {
    val euler = Vec3d(Math.PI / 6.0, Math.PI / 4.0, Math.PI / 3.0)
    val quaternion = Quatd(0.7233174, 0.02226, 0.4396797, 0.5319757)
    assert(quaternion === EulerOrder.ZXY.toQuaternion(euler))
  }

  test("Euler angles to quaternion in ZYX order") {
    val euler = Vec3d(Math.PI / 6.0, Math.PI / 4.0, Math.PI / 3.0)
    val quaternion = Quatd(0.8223632, 0.02226, 0.4396797, 0.3604234)
    assert(quaternion === EulerOrder.ZYX.toQuaternion(euler))
  }

  test("Quaternion to euler angles in XYZ order") {
    val quaternion = Quatd(0.7233174, 0.3919038, 0.2005621, 0.5319757)
    val euler = Vec3d(Math.PI / 6.0, Math.PI / 4.0, Math.PI / 3.0)
    assert(euler === EulerOrder.XYZ.toEulerAngles(quaternion))
  }

  test("Quaternion to euler angles in XZY order") {
    val quaternion = Quatd(0.8223632, 0.02226, 0.2005621, 0.5319757)
    val euler = Vec3d(Math.PI / 6.0, Math.PI / 4.0, Math.PI / 3.0)
    assert(euler === EulerOrder.XZY.toEulerAngles(quaternion))
  }

  test("Quaternion to euler angles in YXZ order") {
    val quaternion = Quatd(0.8223632, 0.3919038, 0.2005621, 0.3604234)
    val euler = Vec3d(Math.PI / 6.0, Math.PI / 4.0, Math.PI / 3.0)
    assert(euler === EulerOrder.YXZ.toEulerAngles(quaternion))
  }

  test("Quaternion to euler angles in YZX order") {
    val quaternion = Quatd(0.7233174, 0.3919038, 0.4396797, 0.3604234)
    val euler = Vec3d(Math.PI / 6.0, Math.PI / 4.0, Math.PI / 3.0)
    assert(euler === EulerOrder.YZX.toEulerAngles(quaternion))
  }

  test("Quaternion to euler angles in ZXY order") {
    val quaternion = Quatd(0.7233174, 0.02226, 0.4396797, 0.5319757)
    val euler = Vec3d(Math.PI / 6.0, Math.PI / 4.0, Math.PI / 3.0)
    assert(euler === EulerOrder.ZXY.toEulerAngles(quaternion))
  }

  test("Quaternion to euler angles in ZYX order") {
    val quaternion = Quatd(0.8223632, 0.02226, 0.4396797, 0.3604234)
    val euler = Vec3d(Math.PI / 6.0, Math.PI / 4.0, Math.PI / 3.0)
    assert(euler === EulerOrder.ZYX.toEulerAngles(quaternion))
  }
}
