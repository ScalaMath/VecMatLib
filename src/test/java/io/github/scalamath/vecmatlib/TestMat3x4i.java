package io.github.scalamath.vecmatlib;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestMat3x4i {

    @Test
    public void testSumOfTwoMatrices() {
        var m1 = new Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        var m2 = new Mat3x4i(3, 4, 1, 2, 7, 5, 9, 6, 8, 11, 12, 10);
        var res = new Mat3x4i(4, 6, 4, 6, 12, 11, 16, 14, 17, 21, 23, 22);
        Assert.assertEquals(res, m1.plus(m2));
    }

    @Test
    public void testSubtractionOfTwoMatrices() {
        var m1 = new Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        var m2 = new Mat3x4i(3, 4, 1, 2, 7, 5, 9, 6, 8, 11, 12, 10);
        var res = new Mat3x4i(2, 2, -2, -2, 2, -1, 2, -2, -1, 1, 1, -2);
        Assert.assertEquals(res, m2.minus(m1));
    }

    @Test
    public void testNegatedMatrix() {
        var mat = new Mat3x4i(1, 2, -2, -1, 3, -2, 0, -9, 4, 2, 0, -5);
        var res = new Mat3x4i(-1, -2, 2, 1, -3, 2, 0, 9, -4, -2, 0, 5);
        Assert.assertEquals(res, mat.negated());
    }

    @Test
    public void testMatrixMultipliedByScalar() {
        var mat = new Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        var res = new Mat3x4i(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24);
        Assert.assertEquals(res, mat.multipliedBy(2));
    }

    @Test
    public void testMatrixDividedByScalar() {
        var mat = new Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        var res = new Mat3x4i(0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6);
        Assert.assertEquals(res, mat.dividedBy(2));
    }

    @Test
    public void testMatrixVectorProduct() {
        var mat = new Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        var vec = new Vec4i(2, 3, 4, 5);
        var res = new Vec3i(40, 96, 152);
        Assert.assertEquals(res, mat.multiply(vec));
    }

    @Test
    public void testMatrixVectorProductWithValues() {
        var mat = new Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        var res = new Vec3i(40, 96, 152);
        Assert.assertEquals(res, mat.multiply(2, 3, 4, 5));
    }

    @Test
    public void testMatrixVectorProductHelper1() {
        var mat = new Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        var vec = new Vec3i(2, 3, 4);
        var res = new Vec3i(40, 96, 152);
        Assert.assertEquals(res, mat.multiply(vec, 5));
    }

    @Test
    public void testMatrixVectorProductHelper2() {
        var mat = new Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        var vec = new Vec2i(2, 3);
        var res = new Vec3i(40, 96, 152);
        Assert.assertEquals(res, mat.multiply(vec, 4, 5));
    }

    @Test
    public void testMatrixProductWith4x4Matrix() {
        var m1 = new Mat3x4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        var m2 = new Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        var res = new Mat3x4i(90, 100, 110, 120, 202, 228, 254, 280, 314, 356, 398, 440);
        Assert.assertEquals(res, m1.multiply(m2));
    }

    @Test
    @Ignore
    public void testMatrixProductWith3x4MatrixAndThreeValues() {
        // TODO
    }

    @Test
    @Ignore
    public void testMatrixProductWith3x4MatrixAndVector() {
        // TODO
    }
}
