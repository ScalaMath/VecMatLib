package vecmatlib.vector;

import org.junit.Assert;
import org.junit.Test;

public class TestVec4i {

	@Test
	public void testPlusValues() {
		Vec4i vector = new Vec4i(1, 2, 3, 4);
		Assert.assertEquals(vector.plus(2, 3, 4, 5), vector.$plus(2, 3, 4, 5));
	}

	@Test
	public void testPlusVector() {
		Vec4i a = new Vec4i(1, 5, 2, 7);
		Vec4i b = new Vec4i(5, 3, 4, 6);
		Assert.assertEquals(a.plus(b), a.$plus(b));
	}

	@Test
	public void testNegated() {
		Vec4i vector = new Vec4i(1, 2, 3, 4);
		Assert.assertEquals(vector.negated(), vector.unary_$minus());
	}

	@Test
	public void testMinusValues() {
		Vec4i vector = new Vec4i(1, 2, 3, 4);
		Assert.assertEquals(vector.minus(2, 3, 4, 5), vector.$minus(2, 3, 4, 5));
	}

	@Test
	public void testMinusVector() {
		Vec4i a = new Vec4i(1, 5, 2, 7);
		Vec4i b = new Vec4i(5, 3, 4, 6);
		Assert.assertEquals(a.minus(b), a.$minus(b));
	}

	@Test
	public void testMultiplyScalar() {
		Vec4i vector = new Vec4i(1, 2, 3, 4);
		Assert.assertEquals(vector.multipliedBy(2), vector.$times(2));
	}

	@Test
	public void testMultiplyValues() {
		Vec4i vector = new Vec4i(1, 2, 3, 4);
		Assert.assertEquals(vector.multiply(2, 3, 4, 5), vector.$times(2, 3, 4, 5));
	}

	@Test
	public void testMultiplyVector() {
		Vec4i a = new Vec4i(1, 5, 2, 7);
		Vec4i b = new Vec4i(5, 3, 4, 6);
		Assert.assertEquals(a.multiply(b), a.$times(b));
	}

	@Test
	public void testDivideScalar() {
		Vec4i vector = new Vec4i(1, 2, 3, 4);
		Assert.assertEquals(vector.dividedBy(2), vector.$div(2));
	}

	@Test
	public void testToArray() {
		Vec4i vector = new Vec4i(1, 2, 3, 4);
		int[] array = new int[] {1, 2, 3, 4};
		Assert.assertArrayEquals(array, vector.toArray());
	}
}
