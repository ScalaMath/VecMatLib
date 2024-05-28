package io.github.scalamath.vecmatlib;

import org.junit.Assert;
import org.junit.Test;

public class TestQuatd {
    
    private static void assertEqualsApprox(Quatd expected, Quatd actual) {
        Assert.assertEquals(expected.w(), actual.w(), 1e-6);
        Assert.assertEquals(expected.x(), actual.x(), 1e-6);
        Assert.assertEquals(expected.y(), actual.y(), 1e-6);
        Assert.assertEquals(expected.z(), actual.z(), 1e-6);
    }

    @Test
    public void testSumWithFourValues() {
        var q = new Quatd(1.2, 1.4, -2.1, 3.0);
        var res = new Quatd(1.5, -0.1, -1.0, 3.0);
        assertEqualsApprox(res, q.plus(0.3, -1.5, 1.1, 0.0));
    }
    
    @Test
    public void testSumOfTwoQuaternions() {
        var q1 = new Quatd(1.2, 1.4, -2.1, 3.0);
        var q2 = new Quatd(0.3, -1.5, 1.1, 0.0);
        var res = new Quatd(1.5, -0.1, -1.0, 3.0);
        assertEqualsApprox(res, q1.plus(q2));
    }
    
    @Test
    public void testSubtractionWithFourValues() {
        var q = new Quatd(1.2, 1.4, -2.1, 3.0);
        var res = new Quatd(0.9, 2.9, -3.2, 3.0);
        assertEqualsApprox(res, q.minus(0.3, -1.5, 1.1, 0.0));
    }
    
    @Test
    public void testSubtractionOfTwoQuaternions() {
        var q1 = new Quatd(1.2, 1.4, -2.1, 3.0);
        var q2 = new Quatd(0.3, -1.5, 1.1, 0.0);
        var res = new Quatd(0.9, 2.9, -3.2, 3.0);
        assertEqualsApprox(res, q1.minus(q2));
    }
    
    @Test
    public void testNegated() {
        var q = new Quatd(1.2, 1.4, -2.1, 3.0);
        var p = new Quatd(-1.2, -1.4, 2.1, -3.0);
        Assert.assertEquals(p, q.negated());
    }
    
    @Test
    public void testMultipliedByScalar() {
        var q = new Quatd(1.2, 1.4, -2.1, 3.0);
        var res = new Quatd(1.44, 1.68, -2.52, 3.6);
        assertEqualsApprox(res, q.multipliedBy(1.2));
    }
    
    @Test
    public void testDividedByScalar() {
        var q = new Quatd(1.2, 1.4, -2.1, 3.0);
        var res = new Quatd(0.6, 0.7, -1.05, 1.5);
        assertEqualsApprox(res, q.dividedBy(2.0));
    }
    
    @Test
    public void testMultiplyWithFourValues() {
        var q = new Quatd(1.2, 1.4, -2.1, 3.0);
        var res = new Quatd(4.77, -4.68, -3.81, -0.71);
        assertEqualsApprox(res, q.multiply(0.3, -1.5, 1.1, 0.0));
    }
    
    @Test
    public void testMultiplyTwoQuaternions() {
        var q1 = new Quatd(1.2, 1.4, -2.1, 3.0);
        var q2 = new Quatd(0.3, -1.5, 1.1, 0.0);
        var res = new Quatd(4.77, -4.68, -3.81, -0.71);
        assertEqualsApprox(res, q1.multiply(q2));
    }
    
    @Test
    public void testDivideTwoQuaternions() {
        var q1 = new Quatd(1.0, 1.0, 1.0, 1.0);
        var q2 = new Quatd(1.0, 0.0, 1.0, 0.0);
        var res = new Quatd(1.0, 1.0, 0.0, 0.0);
        assertEqualsApprox(res, q1.divide(q2));
    }
    
    @Test
    public void testDivideWithFourValues() {
        var q = new Quatd(1.0, 1.0, 1.0, 1.0);
        var res = new Quatd(1.0, 1.0, 0.0, 0.0);
        assertEqualsApprox(res, q.divide(1.0, 0.0, 1.0, 0.0));
    }
    
    @Test
    public void testEqualsApprox() {
        var q1 = new Quatd(1.20000001, 1.39999999, -2.09999999, 3.00000001);
        var q2 = new Quatd(1.2, 1.4, -2.1, 3.0);
        Assert.assertTrue(q1.equalsApprox(q2));
    }
}
