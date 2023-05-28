package io.github.hexagonnico.vecmatlib.vector;

import org.junit.Assert;
import org.junit.Test;

public class TestVec2f {

	@Test
	public void testPlusValues() {
		Vec2f vector = new Vec2f(1.0f, 2.0f);
		Assert.assertEquals(vector.plus(2.0f, 3.0f), vector.$plus(2.0f, 3.0f));
	}

	@Test
	public void testPlusVector() {
		Vec2f a = new Vec2f(1.0f, 1.5f);
		Vec2f b = new Vec2f(1.5f, 3.0f);
		Assert.assertEquals(a.plus(b), a.$plus(b));
	}

	@Test
	public void testNegated() {
		Vec2f vector = new Vec2f(1.0f, 2.0f);
		Assert.assertEquals(vector.negated(), vector.unary_$minus());
	}

	@Test
	public void testMinusValues() {
		Vec2f vector = new Vec2f(1.0f, 2.0f);
		Assert.assertEquals(vector.minus(2.0f, 3.0f), vector.$minus(2.0f, 3.0f));
	}

	@Test
	public void testMinusVector() {
		Vec2f a = new Vec2f(1.0f, 1.5f);
		Vec2f b = new Vec2f(1.5f, 3.0f);
		Assert.assertEquals(a.minus(b), a.$minus(b));
	}

	@Test
	public void testMultiplyScalar() {
		Vec2f vector = new Vec2f(1.0f, 2.0f);
		Assert.assertEquals(vector.multipliedBy(1.5f), vector.$times(1.5f));
	}

	@Test
	public void testMultiplyValues() {
		Vec2f vector = new Vec2f(1.0f, 2.0f);
		Assert.assertEquals(vector.multiply(2.0f, 3.0f), vector.$times(2.0f, 3.0f));
	}

	@Test
	public void testMultiplyVector() {
		Vec2f a = new Vec2f(1.0f, 1.5f);
		Vec2f b = new Vec2f(1.5f, 3.0f);
		Assert.assertEquals(a.multiply(b), a.$times(b));
	}

	@Test
	public void testDivideScalar() {
		Vec2f vector = new Vec2f(1.0f, 2.0f);
		Assert.assertEquals(vector.dividedBy(1.5f), vector.$div(1.5f));
	}

	@Test
	public void testDivideVector() {
		Vec2f a = new Vec2f(1.0f, 1.5f);
		Vec2f b = new Vec2f(1.5f, 3.0f);
		Assert.assertEquals(a.divide(b), a.$div(b));
	}

	@Test
	public void testDivideValues() {
		Vec2f vector = new Vec2f(1.0f, 1.5f);
		Assert.assertEquals(vector.divide(1.5f, 3.0f), vector.$div(1.5f, 3.0f));
	}

	@Test
	public void testToArray() {
		Vec2f vector = new Vec2f(1.1f, 2.2f);
		float[] array = new float[] {1.1f, 2.2f};
		Assert.assertArrayEquals(array, vector.toArray(), 0.000001f);
	}
}
