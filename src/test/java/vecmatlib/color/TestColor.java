package vecmatlib.color;

import org.junit.Assert;
import org.junit.Test;

public class TestColor {

	@Test
	public void testSumValues() {
		Color c = new Color(0.1f, 0.2f, 0.3f, 0.5f);
		Assert.assertEquals(c.$plus(0.5f, 0.6f, 0.7f, 0.5f), c.add(0.5f, 0.6f, 0.7f, 0.5f));
	}

	@Test
	public void testSumColors() {
		Color c1 = new Color(0.1f, 0.2f, 0.3f, 0.5f);
		Color c2 = new Color(0.5f, 0.6f, 0.7f, 0.5f);
		Assert.assertEquals(c1.$plus(c2), c1.add(c2));
	}

	@Test
	public void testSubtractValues() {
		Color c = new Color(0.1f, 0.2f, 0.3f, 0.5f);
		Assert.assertEquals(c.$minus(0.5f, 0.6f, 0.7f, 0.5f), c.subtract(0.5f, 0.6f, 0.7f, 0.5f));
	}

	@Test
	public void testSubtractColors() {
		Color c1 = new Color(0.1f, 0.2f, 0.3f, 0.5f);
		Color c2 = new Color(0.5f, 0.6f, 0.7f, 0.5f);
		Assert.assertEquals(c1.$minus(c2), c1.subtract(c2));
	}

	@Test
	public void testMultiplyValues() {
		Color c = new Color(0.1f, 0.2f, 0.3f, 0.5f);
		Assert.assertEquals(c.$times(0.5f, 0.6f, 0.7f, 0.5f), c.blend(0.5f, 0.6f, 0.7f, 0.5f));
	}

	@Test
	public void testMultiplyColors() {
		Color c1 = new Color(0.1f, 0.2f, 0.3f, 0.5f);
		Color c2 = new Color(0.5f, 0.6f, 0.7f, 0.5f);
		Assert.assertEquals(c1.$times(c2), c1.blend(c2));
	}

	@Test
	public void testMultiplyScalar() {
		Color c = new Color(0.1f, 0.2f, 0.3f, 0.5f);
		Assert.assertEquals(c.$times(1.5f), c.multiply(1.5f));
	}
}
