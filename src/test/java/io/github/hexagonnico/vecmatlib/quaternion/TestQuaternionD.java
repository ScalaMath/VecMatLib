package io.github.hexagonnico.vecmatlib.quaternion;

import org.junit.Assert;
import org.junit.Test;

public class TestQuaternionD {

    @Test
    public void testPlusValues() {
        QuaternionD q = new QuaternionD(1.2, 1.4, -2.1, 3.0);
        assertEqualApprox(q.plus(0.3, -1.5, 1.1, 0.0), 1.5, -0.1, -1.0, 3.0);
    }

    @Test
    public void testPlusQuaternion() {
        QuaternionD q = new QuaternionD(1.2, 1.4, -2.1, 3.0);
        QuaternionD p = new QuaternionD(0.3, -1.5, 1.1, 0.0);
        assertEqualApprox(q.plus(p), 1.5, -0.1, -1.0, 3.0);
    }

    @Test
    public void testNegated() {
        QuaternionD q = new QuaternionD(1.2, 1.4, -2.1, 3.0);
        assertEqualApprox(q.negated(), -1.2, -1.4, 2.1, -3.0);
    }

    @Test
    public void testMinusValues() {
        QuaternionD q = new QuaternionD(1.2, 1.4, -2.1, 3.0);
        QuaternionD p = q.minus(0.3, -1.5, 1.1, 0.0);
        assertEqualApprox(p, 0.9, 2.9, -3.2, 3.0);
    }

    @Test
    public void testMinusQuaternion() {
        QuaternionD q = new QuaternionD(1.2, 1.4, -2.1, 3.0);
        QuaternionD p = new QuaternionD(0.3, -1.5, 1.1, 0.0);
        assertEqualApprox(q.minus(p), 0.9, 2.9, -3.2, 3.0);
    }

    @Test
    public void testMultiplyScalar() {
        QuaternionD q = new QuaternionD(1.2, 1.4, -2.1, 3.0);
        assertEqualApprox(q.multipliedBy(1.2), 1.44, 1.68, -2.52, 3.6);
    }

    @Test
    public void testMultiplyFourValues() {
        QuaternionD q = new QuaternionD(1.2, 1.4, -2.1, 3.0);
        QuaternionD p = q.multiply(0.3, -1.5, 1.1, 0.0);
        assertEqualApprox(p, 4.77, -4.68, -3.81, -0.71);
    }

    @Test
    public void testMultiplyQuaternion() {
        QuaternionD q = new QuaternionD(1.2, 1.4, -2.1, 3.0);
        QuaternionD p = new QuaternionD(0.3, -1.5, 1.1, 0.0);
        assertEqualApprox(q.multiply(p), 4.77, -4.68, -3.81, -0.71);
    }

    @Test
    public void testDivideByScalar() {
        QuaternionD q = new QuaternionD(1.5, 2.0, -2.5, 3.0);
        assertEqualApprox(q.dividedBy(2.0), 0.75, 1.0, -1.25, 1.5);
    }

    @Test
    public void testDivideQuaternion() {
        QuaternionD q = new QuaternionD(1.0, 1.0, 1.0, 1.0);
        QuaternionD p = new QuaternionD(1.0, 0.0, 1.0, 0.0);
        assertEqualApprox(q.divide(p), 1.0, 1.0, 0.0, 0.0);
    }

    @Test
    public void testDivideFourValues() {
        QuaternionD q = new QuaternionD(1.0, 1.0, 1.0, 1.0);
        QuaternionD p = q.divide(1.0, 0.0, 1.0, 0.0);
        assertEqualApprox(p, 1.0, 1.0, 0.0, 0.0);
    }

    @Test
    public void testEqualsFourValues() {
        QuaternionD q = new QuaternionD(1.2, 1.4, -2.1, 3.0);
        Assert.assertTrue(q.equals(1.2, 1.4, -2.1, 3.0));
    }

    private static void assertEqualApprox(QuaternionD a, double w, double x, double y, double z) {
        Assert.assertTrue(Math.abs(a.w() - w) < 1e-6);
        Assert.assertTrue(Math.abs(a.x() - x) < 1e-6);
        Assert.assertTrue(Math.abs(a.y() - y) < 1e-6);
        Assert.assertTrue(Math.abs(a.z() - z) < 1e-6);
    }
}
