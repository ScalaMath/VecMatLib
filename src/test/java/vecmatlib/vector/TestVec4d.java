package vecmatlib.vector;

import org.junit.Assert;
import org.junit.Test;

public class TestVec4d {

	@Test
	public void testPlusValues() {
		Vec4d vector = new Vec4d(1.0, 2.0, 3.0, 4.0);
		Assert.assertEquals(vector.plus(2.0, 3.0, 4.0, 5.0), vector.$plus(2.0, 3.0, 4.0, 5.0));
	}

	@Test
	public void testPlusVector() {
		Vec4d a = new Vec4d(1.0, 1.5, 2.0, 2.5);
		Vec4d b = new Vec4d(1.5, 3.0, 4.0, 6.0);
		Assert.assertEquals(a.plus(b), a.$plus(b));
	}

	@Test
	public void testNegated() {
		Vec4d vector = new Vec4d(1.0, 2.0, 3.0, 4.0);
		Assert.assertEquals(vector.negated(), vector.unary_$minus());
	}

	@Test
	public void testMinusValues() {
		Vec4d vector = new Vec4d(1.0, 2.0, 3.0, 4.0);
		Assert.assertEquals(vector.minus(2.0, 3.0, 4.0, 5.0), vector.$minus(2.0, 3.0, 4.0, 5.0));
	}

	@Test
	public void testMinusVector() {
		Vec4d a = new Vec4d(1.0, 1.5, 2.0, 2.5);
		Vec4d b = new Vec4d(1.5, 3.0, 4.0, 6.0);
		Assert.assertEquals(a.minus(b), a.$minus(b));
	}

	@Test
	public void testMultiplyScalar() {
		Vec4d vector = new Vec4d(1.0, 2.0, 3.0, 4.0);
		Assert.assertEquals(vector.multipliedBy(1.5), vector.$times(1.5));
	}

	@Test
	public void testMultiplyValues() {
		Vec4d vector = new Vec4d(1.0, 2.0, 3.0, 4.0);
		Assert.assertEquals(vector.multiply(2.0, 3.0, 4.0, 5.0), vector.$times(2.0, 3.0, 4.0, 5.0));
	}

	@Test
	public void testMultiplyVector() {
		Vec4d a = new Vec4d(1.0, 1.5, 2.0, 2.5);
		Vec4d b = new Vec4d(1.5, 3.0, 4.0, 6.0);
		Assert.assertEquals(a.multiply(b), a.$times(b));
	}

	@Test
	public void testDivideScalar() {
		Vec4d vector = new Vec4d(1.0, 2.0, 3.0, 4.0);
		Assert.assertEquals(vector.dividedBy(1.5), vector.$div(1.5));
	}
}
