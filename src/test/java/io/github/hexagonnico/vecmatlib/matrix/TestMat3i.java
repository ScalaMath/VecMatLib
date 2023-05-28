package io.github.hexagonnico.vecmatlib.matrix;

import io.github.hexagonnico.vecmatlib.vector.Vec3i;
import org.junit.Assert;
import org.junit.Test;

public class TestMat3i {

	@Test
	public void testPlus() {
		Mat3i a = new Mat3i(
				1, 2, 3,
				4, 5, 6,
				7, 8, 9
		);
		Mat3i b = new Mat3i(
				3, 6, 9,
				2, 4, 8,
				1, 5, 7
		);
		Assert.assertEquals(a.$plus(b), a.plus(b));
	}

	@Test
	public void testNegated() {
		Mat3i m = new Mat3i(
				1, 2, 3,
				4, 5, 6,
				7, 8, 9
		);
		Assert.assertEquals(m.unary_$minus(), m.negated());
	}

	@Test
	public void testMultiplyByScalar() {
		Mat3i m = new Mat3i(
				1, 2, 3,
				4, 5, 6,
				7, 8, 9
		);
		Assert.assertEquals(m.$times(2), m.multipliedBy(2));
	}

	@Test
	public void testMultiplyVector() {
		Mat3i m = new Mat3i(
				1, 2, 3,
				4, 5, 6,
				7, 8, 9
		);
		Vec3i v = new Vec3i(1, 2, 3);
		Assert.assertEquals(m.$times(v), m.multiply(v));
	}

	@Test
	public void testMultiplyVectorValues() {
		Mat3i m = new Mat3i(
				1, 2, 3,
				4, 5, 6,
				7, 8, 9
		);
		Assert.assertEquals(m.$times(1, 2, 3), m.multiply(1, 2, 3));
	}

	@Test
	public void testMultiplyMatrix() {
		Mat3i a = new Mat3i(
				1, 2, 3,
				4, 5, 6,
				7, 8, 9
		);
		Mat3i b = new Mat3i(
				3, 6, 9,
				2, 4, 8,
				1, 5, 7
		);
		Assert.assertEquals(a.$times(b), a.multiply(b));
	}
}
