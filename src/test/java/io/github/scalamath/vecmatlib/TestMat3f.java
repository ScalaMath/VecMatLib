package io.github.scalamath.vecmatlib;

import org.junit.Assert;
import org.junit.Test;

public class TestMat3f {

    @Test
    public void testSumOfTwoMatrices() {
        var m1 = new Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f);
        var m2 = new Mat3f(3.0f, 4.0f, 1.0f, 2.0f, 7.0f, 5.0f, 9.0f, 6.0f, 8.0f);
        var res = new Mat3f(4.0f, 6.0f, 4.0f, 6.0f, 12.0f, 11.0f, 16.0f, 14.0f, 17.0f);
        Assert.assertEquals(res, m1.plus(m2));
    }

    @Test
    public void testSubtractionOfTwoMatrices() {
        var m1 = new Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f);
        var m2 = new Mat3f(3.0f, 4.0f, 1.0f, 2.0f, 7.0f, 5.0f, 9.0f, 6.0f, 8.0f);
        var res = new Mat3f(2.0f, 2.0f, -2.0f, -2.0f, 2.0f, -1.0f, 2.0f, -2.0f, -1.0f);
        Assert.assertEquals(res, m2.minus(m1));
    }

    @Test
    public void testNegatedMatrix() {
        var mat = new Mat3f(1.0f, 2.0f, -2.0f, -1.0f, 3.0f, -2.0f, 0.0f, -9.0f, 4.0f);
        var res = new Mat3f(-1.0f, -2.0f, 2.0f, 1.0f, -3.0f, 2.0f, 0.0f, 9.0f, -4.0f);
        Assert.assertEquals(res, mat.negated());
    }

    @Test
    public void testMatrixMultipliedByScalar() {
        var mat = new Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f);
        var res = new Mat3f(1.5f, 3.0f, 4.5f, 6.0f, 7.5f, 9.0f, 10.5f, 12.0f, 13.5f);
        Assert.assertEquals(res, mat.multipliedBy(1.5f));
    }

    @Test
    public void testMatrixDividedByScalar() {
        var mat = new Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f);
        var res = new Mat3f(0.5f, 1.0f, 1.5f, 2.0f, 2.5f, 3.0f, 3.5f, 4.0f, 4.5f);
        Assert.assertEquals(res, mat.dividedBy(2.0f));
    }

    @Test
    public void testMatrixVectorProduct() {
        var mat = new Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f);
        var vec = new Vec3f(1.5f, 2.5f, 3.5f);
        var res = new Vec3f(17.0f, 39.5f, 62.0f);
        Assert.assertEquals(res, mat.multiply(vec));
    }

    @Test
    public void testMatrixVectorProductWithValues() {
        var mat = new Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f);
        var res = new Vec3f(17.0f, 39.5f, 62.0f);
        Assert.assertEquals(res, mat.multiply(1.5f, 2.5f, 3.5f));
    }

    @Test
    public void testMatrixVectorProductHelper() {
        var mat = new Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f);
        var vec = new Vec2f(1.5f, 2.5f);
        var res = new Vec3f(17.0f, 39.5f, 62.0f);
        Assert.assertEquals(res, mat.multiply(vec, 3.5f));
    }

    @Test
    public void testMatrixProductWith3x3Matrix() {
        var m1 = new Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f);
        var m2 = new Mat3f(3.0f, 4.0f, 1.0f, 2.0f, 7.0f, 5.0f, 9.0f, 6.0f, 8.0f);
        var res = new Mat3f(34.0f, 36.0f, 35.0f, 76.0f, 87.0f, 77.0f, 118.0f, 138.0f, 119.0f);
        Assert.assertEquals(res, m1.multiply(m2));
    }

    @Test
    public void testMatrixProductWith3x4Matrix() {
        var m1 = new Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f);
        var m2 = new Mat3x4f(3.0f, 4.0f, 1.0f, 2.0f, 7.0f, 5.0f, 9.0f, 6.0f, 8.0f, 10.0f, 11.0f, 12.0f);
        var res = new Mat3x4f(41.0f, 44.0f, 52.0f, 50.0f, 95.0f, 101.0f, 115.0f, 110.0f, 149.0f, 158.0f, 178.0f, 170.0f);
        Assert.assertEquals(res, m1.multiply(m2));
    }

    @Test
    public void testMatrixEqualsApprox() {
        var m1 = new Mat3f(1.00000001f, 1.99999999f, 3.00000001f, 3.99999999f, 5.00000001f, 5.99999999f, 7.00000001f, 7.99999999f, 9.00000001f);
        var m2 = new Mat3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f);
        Assert.assertTrue(m1.equalsApprox(m2));
    }
}
