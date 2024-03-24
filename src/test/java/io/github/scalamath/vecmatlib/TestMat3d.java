package io.github.scalamath.vecmatlib;

import org.junit.Assert;
import org.junit.Test;

public class TestMat3d {

    @Test
    public void testSumOfTwoMatrices() {
        var m1 = new Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        var m2 = new Mat3d(3.0, 4.0, 1.0, 2.0, 7.0, 5.0, 9.0, 6.0, 8.0);
        var res = new Mat3d(4.0, 6.0, 4.0, 6.0, 12.0, 11.0, 16.0, 14.0, 17.0);
        Assert.assertEquals(res, m1.plus(m2));
    }

    @Test
    public void testSubtractionOfTwoMatrices() {
        var m1 = new Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        var m2 = new Mat3d(3.0, 4.0, 1.0, 2.0, 7.0, 5.0, 9.0, 6.0, 8.0);
        var res = new Mat3d(2.0, 2.0, -2.0, -2.0, 2.0, -1.0, 2.0, -2.0, -1.0);
        Assert.assertEquals(res, m2.minus(m1));
    }

    @Test
    public void testNegatedMatrix() {
        var mat = new Mat3d(1.0, 2.0, -2.0, -1.0, 3.0, -2.0, 0.0, -9.0, 4.0);
        var res = new Mat3d(-1.0, -2.0, 2.0, 1.0, -3.0, 2.0, 0.0, 9.0, -4.0);
        Assert.assertEquals(res, mat.negated());
    }

    @Test
    public void testMatrixMultipliedByScalar() {
        var mat = new Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        var res = new Mat3d(1.5, 3.0, 4.5, 6.0, 7.5, 9.0, 10.5, 12.0, 13.5);
        Assert.assertEquals(res, mat.multipliedBy(1.5));
    }

    @Test
    public void testMatrixDividedByScalar() {
        var mat = new Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        var res = new Mat3d(0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5);
        Assert.assertEquals(res, mat.dividedBy(2.0));
    }

    @Test
    public void testMatrixVectorProduct() {
        var mat = new Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        var vec = new Vec3d(1.5, 2.5, 3.5);
        var res = new Vec3d(17.0, 39.5, 62.0);
        Assert.assertEquals(res, mat.multiply(vec));
    }

    @Test
    public void testMatrixVectorProductWithValues() {
        var mat = new Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        var res = new Vec3d(17.0, 39.5, 62.0);
        Assert.assertEquals(res, mat.multiply(1.5, 2.5, 3.5));
    }

    @Test
    public void testMatrixVectorProductHelper() {
        var mat = new Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        var vec = new Vec2d(1.5, 2.5);
        var res = new Vec3d(17.0, 39.5, 62.0);
        Assert.assertEquals(res, mat.multiply(vec, 3.5));
    }

    @Test
    public void testMatrixProductWith3x3Matrix() {
        var m1 = new Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        var m2 = new Mat3d(3.0, 4.0, 1.0, 2.0, 7.0, 5.0, 9.0, 6.0, 8.0);
        var res = new Mat3d(34.0, 36.0, 35.0, 76.0, 87.0, 77.0, 118.0, 138.0, 119.0);
        Assert.assertEquals(res, m1.multiply(m2));
    }

    @Test
    public void testMatrixProductWith3x4Matrix() {
        var m1 = new Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        var m2 = new Mat3x4d(3.0, 4.0, 1.0, 2.0, 7.0, 5.0, 9.0, 6.0, 8.0, 10.0, 11.0, 12.0);
        var res = new Mat3x4d(41.0, 44.0, 52.0, 50.0, 95.0, 101.0, 115.0, 110.0, 149.0, 158.0, 178.0, 170.0);
        Assert.assertEquals(res, m1.multiply(m2));
    }

    @Test
    public void testMatrixEqualsApprox() {
        var m1 = new Mat3d(1.00000001, 1.99999999, 3.00000001, 3.99999999, 5.00000001, 5.99999999, 7.00000001, 7.99999999, 9.00000001);
        var m2 = new Mat3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        Assert.assertTrue(m1.equalsApprox(m2));
    }
}
