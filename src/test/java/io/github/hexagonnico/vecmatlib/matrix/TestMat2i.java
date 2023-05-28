package io.github.hexagonnico.vecmatlib.matrix;

import io.github.hexagonnico.vecmatlib.vector.Vec2i;
import org.junit.Assert;
import org.junit.Test;

public class TestMat2i {

	@Test
	public void testPlus() {
		Mat2i a = new Mat2i(
				1, 2,
				3, 4
		);
		Mat2i b = new Mat2i(
				4, 5,
				3, 6
		);
		Assert.assertEquals(a.$plus(b), a.plus(b));
	}

	@Test
	public void testNegated() {
		Mat2i m = new Mat2i(
				1, 2,
				3, 4
		);
		Assert.assertEquals(m.unary_$minus(), m.negated());
	}

	@Test
	public void testMultiplyByScalar() {
		Mat2i m = new Mat2i(
				1, 2,
				3, 4
		);
		Assert.assertEquals(m.$times(2), m.multipliedBy(2));
	}

	@Test
	public void testMultiplyVector() {
		Mat2i m = new Mat2i(
				1, 2,
				3, 4
		);
		Vec2i v = new Vec2i(2, 3);
		Assert.assertEquals(m.$times(v), m.multiply(v));
	}

	@Test
	public void testMultiplyVectorValues() {
		Mat2i m = new Mat2i(
				1, 2,
				3, 4
		);
		Assert.assertEquals(m.$times(2, 3), m.multiply(2, 3));
	}

	@Test
	public void testMultiplyMatrix() {
		Mat2i a = new Mat2i(
				1, 2,
				3, 4
		);
		Mat2i b = new Mat2i(
				4, 5,
				3, 6
		);
		Assert.assertEquals(a.$times(b), a.multiply(b));
	}
}
