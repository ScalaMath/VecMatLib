package io.github.hexagonnico.vecmatlib.vector;

import org.junit.Assert;
import org.junit.Test;

public class TestVec3f {

	@Test
	public void testPlusValues() {
		Vec3f vector = new Vec3f(1.0f, 2.0f, 3.0f);
		Assert.assertEquals(vector.plus(2.0f, 3.0f, 4.0f), vector.$plus(2.0f, 3.0f, 4.0f));
	}

	@Test
	public void testPlusVector() {
		Vec3f a = new Vec3f(1.0f, 1.5f, 2.0f);
		Vec3f b = new Vec3f(1.5f, 3.0f, 4.0f);
		Assert.assertEquals(a.plus(b), a.$plus(b));
	}

	@Test
	public void testNegated() {
		Vec3f vector = new Vec3f(1.0f, 2.0f, 3.0f);
		Assert.assertEquals(vector.negated(), vector.unary_$minus());
	}

	@Test
	public void testMinusValues() {
		Vec3f vector = new Vec3f(1.0f, 2.0f, 3.0f);
		Assert.assertEquals(vector.minus(2.0f, 3.0f, 4.0f), vector.$minus(2.0f, 3.0f, 4.0f));
	}

	@Test
	public void testMinusVector() {
		Vec3f a = new Vec3f(1.0f, 1.5f, 2.0f);
		Vec3f b = new Vec3f(1.5f, 3.0f, 4.0f);
		Assert.assertEquals(a.minus(b), a.$minus(b));
	}

	@Test
	public void testMultiplyScalar() {
		Vec3f vector = new Vec3f(1.0f, 2.0f, 3.0f);
		Assert.assertEquals(vector.multipliedBy(1.5f), vector.$times(1.5f));
	}

	@Test
	public void testMultiplyValues() {
		Vec3f vector = new Vec3f(1.0f, 2.0f, 3.0f);
		Assert.assertEquals(vector.multiply(2.0f, 3.0f, 4.0f), vector.$times(2.0f, 3.0f, 4.0f));
	}

	@Test
	public void testMultiplyVector() {
		Vec3f a = new Vec3f(1.0f, 1.5f, 2.0f);
		Vec3f b = new Vec3f(1.5f, 3.0f, 4.0f);
		Assert.assertEquals(a.multiply(b), a.$times(b));
	}

	@Test
	public void testDivideScalar() {
		Vec3f vector = new Vec3f(1.0f, 2.0f, 3.0f);
		Assert.assertEquals(vector.dividedBy(1.5f), vector.$div(1.5f));
	}

	@Test
	public void testDivideVector() {
		Vec3f a = new Vec3f(1.0f, 1.5f, 2.0f);
		Vec3f b = new Vec3f(1.5f, 3.0f, 4.0f);
		Assert.assertEquals(a.divide(b), a.$div(b));
	}

	@Test
	public void testDivideValues() {
		Vec3f vector = new Vec3f(1.0f, 1.5f, 2.0f);
		Assert.assertEquals(vector.divide(1.5f, 3.0f, 4.0f), vector.$div(1.5f, 3.0f, 4.0f));
	}

	@Test
	public void testToArray() {
		Vec3f vector = new Vec3f(1.1f, 2.2f, 3.3f);
		float[] array = new float[] {1.1f, 2.2f, 3.3f};
		Assert.assertArrayEquals(array, vector.toArray(), 0.000001f);
	}
}
