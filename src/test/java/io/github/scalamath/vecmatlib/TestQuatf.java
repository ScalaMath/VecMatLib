package io.github.scalamath.vecmatlib;

import org.junit.Assert;
import org.junit.Test;

public class TestQuatf {

    private static void assertEqualsApprox(Quatf expected, Quatf actual) {
        Assert.assertEquals(expected.w(), actual.w(), 1e-6f);
        Assert.assertEquals(expected.x(), actual.x(), 1e-6f);
        Assert.assertEquals(expected.y(), actual.y(), 1e-6f);
        Assert.assertEquals(expected.z(), actual.z(), 1e-6f);
    }
    
    @Test
    public void testSumWithFourValues() {
        var q = new Quatf(1.2f, 1.4f, -2.1f, 3.0f);
        var res = new Quatf(1.5f, -0.1f, -1.0f, 3.0f);
        assertEqualsApprox(res, q.plus(0.3f, -1.5f, 1.1f, 0.0f));
    }
    
    @Test
    public void testSumOfTwoQuaternions() {
        var q1 = new Quatf(1.2f, 1.4f, -2.1f, 3.0f);
        var q2 = new Quatf(0.3f, -1.5f, 1.1f, 0.0f);
        var res = new Quatf(1.5f, -0.1f, -1.0f, 3.0f);
        assertEqualsApprox(res, q1.plus(q2));
    }
    
    @Test
    public void testSubtractionWithFourValues() {
        var q = new Quatf(1.2f, 1.4f, -2.1f, 3.0f);
        var res = new Quatf(0.9f, 2.9f, -3.2f, 3.0f);
        assertEqualsApprox(res, q.minus(0.3f, -1.5f, 1.1f, 0.0f));
    }
    
    @Test
    public void testSubtractionOfTwoQuaternions() {
        var q1 = new Quatf(1.2f, 1.4f, -2.1f, 3.0f);
        var q2 = new Quatf(0.3f, -1.5f, 1.1f, 0.0f);
        var res = new Quatf(0.9f, 2.9f, -3.2f, 3.0f);
        assertEqualsApprox(res, q1.minus(q2));
    }
    
    @Test
    public void testNegated() {
        var q = new Quatf(1.2f, 1.4f, -2.1f, 3.0f);
        var p = new Quatf(-1.2f, -1.4f, 2.1f, -3.0f);
        Assert.assertEquals(p, q.negated());
    }
    
    @Test
    public void testMultipliedByScalar() {
        var q = new Quatf(1.2f, 1.4f, -2.1f, 3.0f);
        var res = new Quatf(1.44f, 1.68f, -2.52f, 3.6f);
        assertEqualsApprox(res, q.multipliedBy(1.2f));
    }
    
    @Test
    public void testDividedByScalar() {
        var q = new Quatf(1.2f, 1.4f, -2.1f, 3.0f);
        var res = new Quatf(0.6f, 0.7f, -1.05f, 1.5f);
        assertEqualsApprox(res, q.dividedBy(2.0f));
    }
    
    @Test
    public void testMultiplyWithFourValues() {
        var q = new Quatf(1.2f, 1.4f, -2.1f, 3.0f);
        var res = new Quatf(4.77f, -4.68f, -3.81f, -0.71f);
        assertEqualsApprox(res, q.multiply(0.3f, -1.5f, 1.1f, 0.0f));
    }
    
    @Test
    public void testMultiplyTwoQuaternions() {
        var q1 = new Quatf(1.2f, 1.4f, -2.1f, 3.0f);
        var q2 = new Quatf(0.3f, -1.5f, 1.1f, 0.0f);
        var res = new Quatf(4.77f, -4.68f, -3.81f, -0.71f);
        assertEqualsApprox(res, q1.multiply(q2));
    }
    
    @Test
    public void testDivideTwoQuaternions() {
        var q1 = new Quatf(1.0f, 1.0f, 1.0f, 1.0f);
        var q2 = new Quatf(1.0f, 0.0f, 1.0f, 0.0f);
        var res = new Quatf(1.0f, 1.0f, 0.0f, 0.0f);
        assertEqualsApprox(res, q1.divide(q2));
    }
    
    @Test
    public void testDivideWithFourValues() {
        var q = new Quatf(1.0f, 1.0f, 1.0f, 1.0f);
        var res = new Quatf(1.0f, 1.0f, 0.0f, 0.0f);
        assertEqualsApprox(res, q.divide(1.0f, 0.0f, 1.0f, 0.0f));
    }
    
    @Test
    public void testEqualsApprox() {
        var q1 = new Quatf(1.20000001f, 1.39999999f, -2.09999999f, 3.00000001f);
        var q2 = new Quatf(1.2f, 1.4f, -2.1f, 3.0f);
        Assert.assertTrue(q1.equalsApprox(q2));
    }
}
