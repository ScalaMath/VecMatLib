package io.github.hexagonnico.vecmatlib.matrix;

import io.github.hexagonnico.vecmatlib.vector.Vec4f;
import org.junit.Assert;
import org.junit.Test;

public class TestMat4f {

	@Test
	public void testPlus() {
		Mat4f a = new Mat4f(
				0.0f, 1.0f, 2.0f, 3.0f,
				4.0f, 5.0f, 6.0f, 7.0f,
				8.0f, 9.0f, 0.0f, 1.0f,
				2.0f, 3.0f, 4.0f, 5.0f
		);
		Mat4f b = new Mat4f(
				0.0f, 2.0f, 4.0f, 8.0f,
				1.0f, 3.0f, 5.0f, 7.0f,
				6.0f, 9.0f, 0.0f, 5.0f,
				4.0f, 2.0f, 1.0f, 3.0f
		);
		Assert.assertEquals(a.$plus(b), a.plus(b));
	}

	@Test
	public void testNegated() {
		Mat4f m = new Mat4f(
				0.0f, 1.0f, 2.0f, 3.0f,
				4.0f, 5.0f, 6.0f, 7.0f,
				8.0f, 9.0f, 0.0f, 1.0f,
				2.0f, 3.0f, 4.0f, 5.0f
		);
		Assert.assertEquals(m.unary_$minus(), m.negated());
	}

	@Test
	public void testMultiplyByScalar() {
		Mat4f m = new Mat4f(
				0.0f, 1.0f, 2.0f, 3.0f,
				4.0f, 5.0f, 6.0f, 7.0f,
				8.0f, 9.0f, 0.0f, 1.0f,
				2.0f, 3.0f, 4.0f, 5.0f
		);
		Assert.assertEquals(m.$times(1.5f), m.multipliedBy(1.5f));
	}

	@Test
	public void testMultiplyVector() {
		Mat4f m = new Mat4f(
				0.0f, 1.0f, 2.0f, 3.0f,
				4.0f, 5.0f, 6.0f, 7.0f,
				8.0f, 9.0f, 0.0f, 1.0f,
				2.0f, 3.0f, 4.0f, 5.0f
		);
		Vec4f v = new Vec4f(1.5f, 2.5f, 3.5f, 4.5f);
		Assert.assertEquals(m.$times(v), m.multiply(v));
	}

	@Test
	public void testMultiplyVectorValues() {
		Mat4f m = new Mat4f(
				0.0f, 1.0f, 2.0f, 3.0f,
				4.0f, 5.0f, 6.0f, 7.0f,
				8.0f, 9.0f, 0.0f, 1.0f,
				2.0f, 3.0f, 4.0f, 5.0f
		);
		Assert.assertEquals(m.$times(1.5f, 2.5f, 3.5f, 4.5f), m.multiply(1.5f, 2.5f, 3.5f, 4.5f));
	}

	@Test
	public void testMultiplyMatrix() {
		Mat4f a = new Mat4f(
				0.0f, 1.0f, 2.0f, 3.0f,
				4.0f, 5.0f, 6.0f, 7.0f,
				8.0f, 9.0f, 0.0f, 1.0f,
				2.0f, 3.0f, 4.0f, 5.0f
		);
		Mat4f b = new Mat4f(
				0.0f, 2.0f, 4.0f, 8.0f,
				1.0f, 3.0f, 5.0f, 7.0f,
				6.0f, 9.0f, 0.0f, 5.0f,
				4.0f, 2.0f, 1.0f, 3.0f
		);
		Assert.assertEquals(a.$times(b), a.multiply(b));
	}
}
