package vecmatlib.matrix;

import org.junit.Assert;
import org.junit.Test;
import vecmatlib.vector.Vec3d;

public class TestMat3d {

	@Test
	public void testPlus() {
		Mat3d a = new Mat3d(
				1.0, 2.0, 3.0,
				4.0, 5.0, 6.0,
				7.0, 8.0, 9.0
		);
		Mat3d b = new Mat3d(
				3.0, 6.0, 9.0,
				2.0, 4.0, 8.0,
				1.0, 5.0, 7.0
		);
		Assert.assertEquals(a.$plus(b), a.plus(b));
	}

	@Test
	public void testNegated() {
		Mat3d m = new Mat3d(
				1.0, 2.0, 3.0,
				4.0, 5.0, 6.0,
				7.0, 8.0, 9.0
		);
		Assert.assertEquals(m.unary_$minus(), m.negated());
	}

	@Test
	public void testMultiplyByScalar() {
		Mat3d m = new Mat3d(
				1.0, 2.0, 3.0,
				4.0, 5.0, 6.0,
				7.0, 8.0, 9.0
		);
		Assert.assertEquals(m.$times(1.5), m.multipliedBy(1.5));
	}

	@Test
	public void testMultiplyVector() {
		Mat3d m = new Mat3d(
				1.0, 2.0, 3.0,
				4.0, 5.0, 6.0,
				7.0, 8.0, 9.0
		);
		Vec3d v = new Vec3d(1.5, 2.5, 3.5);
		Assert.assertEquals(m.$times(v), m.multiply(v));
	}

	@Test
	public void testMultiplyVectorValues() {
		Mat3d m = new Mat3d(
				1.0, 2.0, 3.0,
				4.0, 5.0, 6.0,
				7.0, 8.0, 9.0
		);
		Assert.assertEquals(m.$times(1.5, 2.5, 3.5), m.multiply(1.5, 2.5, 3.5));
	}

	@Test
	public void testMultiplyMatrix() {
		Mat3d a = new Mat3d(
				1.0, 2.0, 3.0,
				4.0, 5.0, 6.0,
				7.0, 8.0, 9.0
		);
		Mat3d b = new Mat3d(
				3.0, 6.0, 9.0,
				2.0, 4.0, 8.0,
				1.0, 5.0, 7.0
		);
		Assert.assertEquals(a.$times(b), a.multiply(b));
	}
}
