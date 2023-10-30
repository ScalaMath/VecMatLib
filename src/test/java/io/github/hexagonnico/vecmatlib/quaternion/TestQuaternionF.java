package io.github.hexagonnico.vecmatlib.quaternion;

import org.junit.Assert;
import org.junit.Test;

public class TestQuaternionF {

	@Test
	public void testPlusValues() {
		QuaternionF q = new QuaternionF(1.2f, 1.4f, -2.1f, 3.0f);
		assertEqualApprox(q.plus(0.3f, -1.5f, 1.1f, 0.0f), 1.5f, -0.1f, -1.0f, 3.0f);
	}

	@Test
	public void testPlusQuaternion() {
		QuaternionF q = new QuaternionF(1.2f, 1.4f, -2.1f, 3.0f);
		QuaternionF p = new QuaternionF(0.3f, -1.5f, 1.1f, 0.0f);
		assertEqualApprox(q.plus(p), 1.5f, -0.1f, -1.0f, 3.0f);
	}

	@Test
	public void testNegated() {
		QuaternionF q = new QuaternionF(1.2f, 1.4f, -2.1f, 3.0f);
		assertEqualApprox(q.negated(), -1.2f, -1.4f, 2.1f, -3.0f);
	}

	@Test
	public void testMinusValues() {
		QuaternionF q = new QuaternionF(1.2f, 1.4f, -2.1f, 3.0f);
		QuaternionF p = q.minus(0.3f, -1.5f, 1.1f, 0.0f);
		assertEqualApprox(p, 0.9f, 2.9f, -3.2f, 3.0f);
	}

	@Test
	public void testMinusQuaternion() {
		QuaternionF q = new QuaternionF(1.2f, 1.4f, -2.1f, 3.0f);
		QuaternionF p = new QuaternionF(0.3f, -1.5f, 1.1f, 0.0f);
		assertEqualApprox(q.minus(p), 0.9f, 2.9f, -3.2f, 3.0f);
	}

	@Test
	public void testMultiplyScalar() {
		QuaternionF q = new QuaternionF(1.2f, 1.4f, -2.1f, 3.0f);
		assertEqualApprox(q.multipliedBy(1.2f), 1.44f, 1.68f, -2.52f, 3.6f);
	}

	@Test
	public void testMultiplyFourValues() {
		QuaternionF q = new QuaternionF(1.2f, 1.4f, -2.1f, 3.0f);
		QuaternionF p = q.multiply(0.3f, -1.5f, 1.1f, 0.0f);
		assertEqualApprox(p, 4.77f, -4.68f, -3.81f, -0.71f);
	}

	@Test
	public void testMultiplyQuaternion() {
		QuaternionF q = new QuaternionF(1.2f, 1.4f, -2.1f, 3.0f);
		QuaternionF p = new QuaternionF(0.3f, -1.5f, 1.1f, 0.0f);
		assertEqualApprox(q.multiply(p), 4.77f, -4.68f, -3.81f, -0.71f);
	}

	@Test
	public void testDivideByScalar() {
		QuaternionF q = new QuaternionF(1.2f, 1.4f, -2.1f, 3.0f);
		assertEqualApprox(q.dividedBy(1.2f), 1.0f, 1.16666666667f, -1.75f, 2.5f);
	}

	@Test
	public void testDivideQuaternion() {
		QuaternionF q = new QuaternionF(1.2f, 1.4f, -2.1f, 3.0f);
		QuaternionF p = new QuaternionF(0.3f, -1.5f, 1.1f, 0.0f);
		assertEqualApprox(q.divide(p), -1.1408450704225355f, 1.5549295774647889f, 0.7183098591549296f, 0.7070422535211269f);
	}

	@Test
	public void testDivideFourValues() {
		QuaternionF q = new QuaternionF(1.2f, 1.4f, -2.1f, 3.0f);
		QuaternionF p = q.divide(0.3f, -1.5f, 1.1f, 0.0f);
		assertEqualApprox(p, -1.1408450704225355f, 1.5549295774647889f, 0.7183098591549296f, 0.7070422535211269f);
	}

	@Test
	public void testEqualsFourValues() {
		QuaternionF q = new QuaternionF(1.2f, 1.4f, -2.1f, 3.0f);
		Assert.assertTrue(q.equals(1.2f, 1.4f, -2.1f, 3.0f));
	}

	private static void assertEqualApprox(QuaternionF a, float w, float x, float y, float z) {
		Assert.assertTrue(Math.abs(a.w() - w) < 1e-6);
		Assert.assertTrue(Math.abs(a.x() - x) < 1e-6);
		Assert.assertTrue(Math.abs(a.y() - y) < 1e-6);
		Assert.assertTrue(Math.abs(a.z() - z) < 1e-6);
	}
}
