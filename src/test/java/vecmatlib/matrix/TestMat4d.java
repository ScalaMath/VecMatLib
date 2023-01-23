package vecmatlib.matrix;

import org.junit.Assert;
import org.junit.Test;
import vecmatlib.vector.Vec4d;

public class TestMat4d {

	@Test
	public void testPlus() {
		Mat4d a = new Mat4d(
				0.0, 1.0, 2.0, 3.0,
				4.0, 5.0, 6.0, 7.0,
				8.0, 9.0, 0.0, 1.0,
				2.0, 3.0, 4.0, 5.0
		);
		Mat4d b = new Mat4d(
				0.0, 2.0, 4.0, 8.0,
				1.0, 3.0, 5.0, 7.0,
				6.0, 9.0, 0.0, 5.0,
				4.0, 2.0, 1.0, 3.0
		);
		Assert.assertEquals(a.$plus(b), a.plus(b));
	}

	@Test
	public void testNegated() {
		Mat4d m = new Mat4d(
				0.0, 1.0, 2.0, 3.0,
				4.0, 5.0, 6.0, 7.0,
				8.0, 9.0, 0.0, 1.0,
				2.0, 3.0, 4.0, 5.0
		);
		Assert.assertEquals(m.unary_$minus(), m.negated());
	}

	@Test
	public void testMultiplyByScalar() {
		Mat4d m = new Mat4d(
				0.0, 1.0, 2.0, 3.0,
				4.0, 5.0, 6.0, 7.0,
				8.0, 9.0, 0.0, 1.0,
				2.0, 3.0, 4.0, 5.0
		);
		Assert.assertEquals(m.$times(1.5), m.multipliedBy(1.5));
	}

	@Test
	public void testMultiplyVector() {
		Mat4d m = new Mat4d(
				0.0, 1.0, 2.0, 3.0,
				4.0, 5.0, 6.0, 7.0,
				8.0, 9.0, 0.0, 1.0,
				2.0, 3.0, 4.0, 5.0
		);
		Vec4d v = new Vec4d(1.5, 2.5, 3.5, 4.5);
		Assert.assertEquals(m.$times(v), m.multiply(v));
	}

	@Test
	public void testMultiplyVectorValues() {
		Mat4d m = new Mat4d(
				0.0, 1.0, 2.0, 3.0,
				4.0, 5.0, 6.0, 7.0,
				8.0, 9.0, 0.0, 1.0,
				2.0, 3.0, 4.0, 5.0
		);
		Assert.assertEquals(m.$times(1.5, 2.5, 3.5, 4.5), m.multiply(1.5, 2.5, 3.5, 4.5));
	}

	@Test
	public void testMultiplyMatrix() {
		Mat4d a = new Mat4d(
				0.0, 1.0, 2.0, 3.0,
				4.0, 5.0, 6.0, 7.0,
				8.0, 9.0, 0.0, 1.0,
				2.0, 3.0, 4.0, 5.0
		);
		Mat4d b = new Mat4d(
				0.0, 2.0, 4.0, 8.0,
				1.0, 3.0, 5.0, 7.0,
				6.0, 9.0, 0.0, 5.0,
				4.0, 2.0, 1.0, 3.0
		);
		Assert.assertEquals(a.$times(b), a.multiply(b));
	}
}
