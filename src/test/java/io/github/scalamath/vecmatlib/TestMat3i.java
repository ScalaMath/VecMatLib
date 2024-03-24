package io.github.scalamath.vecmatlib;

import org.junit.Assert;
import org.junit.Test;

public class TestMat3i {

    @Test
    public void testSumOfTwoMatrices() {
        var m1 = new Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9);
        var m2 = new Mat3i(3, 4, 1, 2, 7, 5, 9, 6, 8);
        var res = new Mat3i(4, 6, 4, 6, 12, 11, 16, 14, 17);
        Assert.assertEquals(res, m1.plus(m2));
    }

    @Test
    public void testSubtractionOfTwoMatrices() {
        var m1 = new Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9);
        var m2 = new Mat3i(3, 4, 1, 2, 7, 5, 9, 6, 8);
        var res = new Mat3i(2, 2, -2, -2, 2, -1, 2, -2, -1);
        Assert.assertEquals(res, m2.minus(m1));
    }

    @Test
    public void testNegatedMatrix() {
        var mat = new Mat3i(1, 2, -2, -1, 3, -2, 0, -9, 4);
        var res = new Mat3i(-1, -2, 2, 1, -3, 2, 0, 9, -4);
        Assert.assertEquals(res, mat.negated());
    }

    @Test
    public void testMatrixMultipliedByScalar() {
        var mat = new Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9);
        var res = new Mat3i(2, 4, 6, 8, 10, 12, 14, 16, 18);
        Assert.assertEquals(res, mat.multipliedBy(2));
    }

    @Test
    public void testMatrixDividedByScalar() {
        var mat = new Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9);
        var res = new Mat3i(0, 1, 1, 2, 2, 3, 3, 4, 4);
        Assert.assertEquals(res, mat.dividedBy(2));
    }

    @Test
    public void testMatrixVectorProduct() {
        var mat = new Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9);
        var vec = new Vec3i(2, 3, 4);
        var res = new Vec3i(20, 47, 74);
        Assert.assertEquals(res, mat.multiply(vec));
    }

    @Test
    public void testMatrixVectorProductWithValues() {
        var mat = new Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9);
        var res = new Vec3i(20, 47, 74);
        Assert.assertEquals(res, mat.multiply(2, 3, 4));
    }

    @Test
    public void testMatrixVectorProductHelper() {
        var mat = new Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9);
        var vec = new Vec2i(2, 3);
        var res = new Vec3i(20, 47, 74);
        Assert.assertEquals(res, mat.multiply(vec, 4));
    }

    @Test
    public void testMatrixProductWith3x3Matrix() {
        var m1 = new Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9);
        var m2 = new Mat3i(3, 4, 1, 2, 7, 5, 9, 6, 8);
        var res = new Mat3i(34, 36, 35, 76, 87, 77, 118, 138, 119);
        Assert.assertEquals(res, m1.multiply(m2));
    }

    @Test
    public void testMatrixProductWith3x4Matrix() {
        var m1 = new Mat3i(1, 2, 3, 4, 5, 6, 7, 8, 9);
        var m2 = new Mat3x4i(3, 4, 1, 2, 7, 5, 9, 6, 8, 10, 11, 12);
        var res = new Mat3x4i(41, 44, 52, 50, 95, 101, 115, 110, 149, 158, 178, 170);
        Assert.assertEquals(res, m1.multiply(m2));
    }
}
