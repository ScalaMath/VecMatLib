package io.github.scalamath.vecmatlib;

import org.junit.Assert;
import org.junit.Test;

public class TestMat2x3i {

    @Test
    public void testSumOfTwoMatrices() {
        var m1 = new Mat2x3i(1, 2, 3, 4, 5, 6);
        var m2 = new Mat2x3i(3, 4, 1, 2, 6, 5);
        var res = new Mat2x3i(4, 6, 4, 6, 11, 11);
        Assert.assertEquals(res, m1.plus(m2));
    }

    @Test
    public void testSubtractionOfTwoMatrices() {
        var m1 = new Mat2x3i(1, 2, 3, 4, 5, 6);
        var m2 = new Mat2x3i(3, 4, 1, 2, 6, 5);
        var res = new Mat2x3i(2, 2, -2, -2, 1, -1);
        Assert.assertEquals(res, m2.minus(m1));
    }

    @Test
    public void testNegatedMatrix() {
        var mat = new Mat2x3i(1, 2, -2, -1, 3, -2);
        var res = new Mat2x3i(-1, -2, 2, 1, -3, 2);
        Assert.assertEquals(res, mat.negated());
    }

    @Test
    public void testMatrixMultipliedByScalar() {
        var mat = new Mat2x3i(1, 2, 3, 4, 5, 6);
        var res = new Mat2x3i(2, 4, 6, 8, 10, 12);
        Assert.assertEquals(res, mat.multipliedBy(2));
    }

    @Test
    public void testMatrixDividedByScalar() {
        var mat = new Mat2x3i(1, 2, 3, 4, 5, 6);
        var res = new Mat2x3i(0, 1, 1, 2, 2, 3);
        Assert.assertEquals(res, mat.dividedBy(2));
    }

    @Test
    public void testMatrixVectorProduct() {
        var mat = new Mat2x3i(1, 2, 3, 4, 5, 6);
        var vec = new Vec3i(2, 3, 4);
        var res = new Vec2i(20, 47);
        Assert.assertEquals(res, mat.multiply(vec));
    }

    @Test
    public void testMatrixVectorProductWithValues() {
        var mat = new Mat2x3i(1, 2, 3, 4, 5, 6);
        var res = new Vec2i(20, 47);
        Assert.assertEquals(res, mat.multiply(2, 3, 4));
    }

    @Test
    public void testMatrixVectorProductHelper() {
        var mat = new Mat2x3i(1, 2, 3, 4, 5, 6);
        var vec = new Vec2i(2, 3);
        var res = new Vec2i(20, 47);
        Assert.assertEquals(res, mat.multiply(vec, 4));
    }

    @Test
    public void testMatrixProductWith3x3Matrix() {
        var m1 = new Mat2x3i(1, 2, 3, 4, 5, 6);
        var m2 = new Mat3i(3, 4, 1, 2, 6, 5, -2, 8, -1);
        var res = new Mat2x3i(1, 40, 8, 10, 94, 23);
        Assert.assertEquals(res, m1.multiply(m2));
    }

    @Test
    public void testMatrixProductWith2x3MatrixAndThreeValues() {
        var m1 = new Mat2x3i(1, 2, 3, 4, 5, 6);
        var m2 = new Mat2x3i(3, 4, 1, 2, 6, 5);
        var res = new Mat2x3i(1, 40, 8, 10, 94, 23);
        Assert.assertEquals(res, m1.multiply(m2, -2, 8, -1));
    }

    @Test
    public void testMatrixProductWith2x3MatrixAndVector() {
        var m1 = new Mat2x3i(1, 2, 3, 4, 5, 6);
        var m2 = new Mat2x3i(3, 4, 1, 2, 6, 5);
        var v = new Vec3i(-2, 8, -1);
        var res = new Mat2x3i(1, 40, 8, 10, 94, 23);
        Assert.assertEquals(res, m1.multiply(m2, v));
    }
}
