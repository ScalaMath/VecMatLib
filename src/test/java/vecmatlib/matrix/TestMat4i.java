package vecmatlib.matrix;

import org.junit.Assert;
import org.junit.Test;
import vecmatlib.vector.Vec4i;

public class TestMat4i {

	@Test
	public void testPlus() {
		Mat4i a = new Mat4i(
				0, 1, 2, 3,
				4, 5, 6, 7,
				8, 9, 0, 1,
				2, 3, 4, 5
		);
		Mat4i b = new Mat4i(
				0, 2, 4, 8,
				1, 3, 5, 7,
				6, 9, 0, 5,
				4, 2, 1, 3
		);
		Assert.assertEquals(a.$plus(b), a.plus(b));
	}

	@Test
	public void testNegated() {
		Mat4i m = new Mat4i(
				0, 1, 2, 3,
				4, 5, 6, 7,
				8, 9, 0, 1,
				2, 3, 4, 5
		);
		Assert.assertEquals(m.unary_$minus(), m.negated());
	}

	@Test
	public void testMultiplyByScalar() {
		Mat4i m = new Mat4i(
				0, 1, 2, 3,
				4, 5, 6, 7,
				8, 9, 0, 1,
				2, 3, 4, 5
		);
		Assert.assertEquals(m.$times(2), m.multipliedBy(2));
	}

	@Test
	public void testMultiplyVector() {
		Mat4i m = new Mat4i(
				0, 1, 2, 3,
				4, 5, 6, 7,
				8, 9, 0, 1,
				2, 3, 4, 5
		);
		Vec4i v = new Vec4i(1, 2, 3, 4);
		Assert.assertEquals(m.$times(v), m.multiply(v));
	}

	@Test
	public void testMultiplyVectorValues() {
		Mat4i m = new Mat4i(
				0, 1, 2, 3,
				4, 5, 6, 7,
				8, 9, 0, 1,
				2, 3, 4, 5
		);
		Assert.assertEquals(m.$times(1, 2, 3, 4), m.multiply(1, 2, 3, 4));
	}

	@Test
	public void testMultiplyMatrix() {
		Mat4i a = new Mat4i(
				0, 1, 2, 3,
				4, 5, 6, 7,
				8, 9, 0, 1,
				2, 3, 4, 5
		);
		Mat4i b = new Mat4i(
				0, 2, 4, 8,
				1, 3, 5, 7,
				6, 9, 0, 5,
				4, 2, 1, 3
		);
		Assert.assertEquals(a.$times(b), a.multiply(b));
	}
}
