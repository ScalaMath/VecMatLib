package io.github.hexagonnico.vecmatlib.matrix;

import io.github.hexagonnico.vecmatlib.vector.Vec3f;
import org.junit.Assert;
import org.junit.Test;

public class TestMat3f {

	@Test
	public void testPlus() {
		Mat3f a = new Mat3f(
				1.0f, 2.0f, 3.0f,
				4.0f, 5.0f, 6.0f,
				7.0f, 8.0f, 9.0f
		);
		Mat3f b = new Mat3f(
				3.0f, 6.0f, 9.0f,
				2.0f, 4.0f, 8.0f,
				1.0f, 5.0f, 7.0f
		);
		Assert.assertEquals(a.$plus(b), a.plus(b));
	}

	@Test
	public void testNegated() {
		Mat3f m = new Mat3f(
				1.0f, 2.0f, 3.0f,
				4.0f, 5.0f, 6.0f,
				7.0f, 8.0f, 9.0f
		);
		Assert.assertEquals(m.unary_$minus(), m.negated());
	}

	@Test
	public void testMultiplyByScalar() {
		Mat3f m = new Mat3f(
				1.0f, 2.0f, 3.0f,
				4.0f, 5.0f, 6.0f,
				7.0f, 8.0f, 9.0f
		);
		Assert.assertEquals(m.$times(1.5f), m.multipliedBy(1.5f));
	}

	@Test
	public void testMultiplyVector() {
		Mat3f m = new Mat3f(
				1.0f, 2.0f, 3.0f,
				4.0f, 5.0f, 6.0f,
				7.0f, 8.0f, 9.0f
		);
		Vec3f v = new Vec3f(1.5f, 2.5f, 3.5f);
		Assert.assertEquals(m.$times(v), m.multiply(v));
	}

	@Test
	public void testMultiplyVectorValues() {
		Mat3f m = new Mat3f(
				1.0f, 2.0f, 3.0f,
				4.0f, 5.0f, 6.0f,
				7.0f, 8.0f, 9.0f
		);
		Assert.assertEquals(m.$times(1.5f, 2.5f, 3.5f), m.multiply(1.5f, 2.5f, 3.5f));
	}

	@Test
	public void testMultiplyMatrix() {
		Mat3f a = new Mat3f(
				1.0f, 2.0f, 3.0f,
				4.0f, 5.0f, 6.0f,
				7.0f, 8.0f, 9.0f
		);
		Mat3f b = new Mat3f(
				3.0f, 6.0f, 9.0f,
				2.0f, 4.0f, 8.0f,
				1.0f, 5.0f, 7.0f
		);
		Assert.assertEquals(a.$times(b), a.multiply(b));
	}
}
