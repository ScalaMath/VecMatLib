package io.github.hexagonnico.vecmatlib.matrix;

import io.github.hexagonnico.vecmatlib.vector.Vec2d;
import org.junit.Assert;
import org.junit.Test;

public class TestMat2d {

	@Test
	public void testPlus() {
		Mat2d a = new Mat2d(
				1.0, 2.0,
				3.0, 4.0
		);
		Mat2d b = new Mat2d(
				4.0, 5.0,
				3.0, 6.0
		);
		Assert.assertEquals(a.$plus(b), a.plus(b));
	}

	@Test
	public void testNegated() {
		Mat2d m = new Mat2d(
				1.0, 2.0,
				3.0, 4.0
		);
		Assert.assertEquals(m.unary_$minus(), m.negated());
	}

	@Test
	public void testMultiplyByScalar() {
		Mat2d m = new Mat2d(
				1.0, 2.0,
				3.0, 4.0
		);
		Assert.assertEquals(m.$times(1.5), m.multipliedBy(1.5));
	}

	@Test
	public void testMultiplyVector() {
		Mat2d m = new Mat2d(
				1.0, 2.0,
				3.0, 4.0
		);
		Vec2d v = new Vec2d(1.5, 2.5);
		Assert.assertEquals(m.$times(v), m.multiply(v));
	}

	@Test
	public void testMultiplyVectorValues() {
		Mat2d m = new Mat2d(
				1.0, 2.0,
				3.0, 4.0
		);
		Assert.assertEquals(m.$times(1.5, 2.5), m.multiply(1.5, 2.5));
	}

	@Test
	public void testMultiplyMatrix() {
		Mat2d a = new Mat2d(
				1.0, 2.0,
				3.0, 4.0
		);
		Mat2d b = new Mat2d(
				4.0, 5.0,
				3.0, 6.0
		);
		Assert.assertEquals(a.$times(b), a.multiply(b));
	}
}
