package io.github.hexagonnico.vecmatlib.color;

import org.junit.Assert;
import org.junit.Test;

public class TestColor3f {

	@Test
	public void testSumValues() {
		Color3f c = new Color3f(0.1f, 0.2f, 0.3f);
		Assert.assertEquals(c.$plus(0.5f, 0.6f, 0.7f), c.add(0.5f, 0.6f, 0.7f));
	}

	@Test
	public void testSumColors() {
		Color3f c1 = new Color3f(0.1f, 0.2f, 0.3f);
		Color3f c2 = new Color3f(0.5f, 0.6f, 0.7f);
		Assert.assertEquals(c1.$plus(c2), c1.add(c2));
	}

	@Test
	public void testSubtractValues() {
		Color3f c = new Color3f(0.1f, 0.2f, 0.3f);
		Assert.assertEquals(c.$minus(0.5f, 0.6f, 0.7f), c.subtract(0.5f, 0.6f, 0.7f));
	}

	@Test
	public void testSubtractColors() {
		Color3f c1 = new Color3f(0.1f, 0.2f, 0.3f);
		Color3f c2 = new Color3f(0.5f, 0.6f, 0.7f);
		Assert.assertEquals(c1.$minus(c2), c1.subtract(c2));
	}

	@Test
	public void testMultiplyValues() {
		Color3f c = new Color3f(0.1f, 0.2f, 0.3f);
		Assert.assertEquals(c.$times(0.5f, 0.6f, 0.7f), c.blend(0.5f, 0.6f, 0.7f));
	}

	@Test
	public void testMultiplyColors() {
		Color3f c1 = new Color3f(0.1f, 0.2f, 0.3f);
		Color3f c2 = new Color3f(0.5f, 0.6f, 0.7f);
		Assert.assertEquals(c1.$times(c2), c1.blend(c2));
	}

	@Test
	public void testMultiplyScalar() {
		Color3f c = new Color3f(0.1f, 0.2f, 0.3f);
		Assert.assertEquals(c.$times(1.5f), c.multiply(1.5f));
	}
}
