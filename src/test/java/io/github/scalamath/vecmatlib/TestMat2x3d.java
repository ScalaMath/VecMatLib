package io.github.scalamath.vecmatlib;

import org.junit.Assert;
import org.junit.Test;

public class TestMat2x3d {

    @Test
    public void testSumOfTwoMatrices() {
        var m1 = new Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        var m2 = new Mat2x3d(3.0, 4.0, 1.0, 2.0, 6.0, 5.0);
        var res = new Mat2x3d(4.0, 6.0, 4.0, 6.0, 11.0, 11.0);
        Assert.assertEquals(res, m1.plus(m2));
    }

    @Test
    public void testSubtractionOfTwoMatrices() {
        var m1 = new Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        var m2 = new Mat2x3d(3.0, 4.0, 1.0, 2.0, 6.0, 5.0);
        var res = new Mat2x3d(2.0, 2.0, -2.0, -2.0, 1.0, -1.0);
        Assert.assertEquals(res, m2.minus(m1));
    }

    @Test
    public void testNegatedMatrix() {
        var mat = new Mat2x3d(1.0, 2.0, -2.0, -1.0, 3.0, -2.0);
        var res = new Mat2x3d(-1.0, -2.0, 2.0, 1.0, -3.0, 2.0);
        Assert.assertEquals(res, mat.negated());
    }

    @Test
    public void testMatrixMultipliedByScalar() {
        var mat = new Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        var res = new Mat2x3d(1.5, 3.0, 4.5, 6.0, 7.5, 9.0);
        Assert.assertEquals(res, mat.multipliedBy(1.5));
    }

    @Test
    public void testMatrixDividedByScalar() {
        var mat = new Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        var res = new Mat2x3d(0.5, 1.0, 1.5, 2.0, 2.5, 3.0);
        Assert.assertEquals(res, mat.dividedBy(2.0));
    }

    @Test
    public void testMatrixVectorProduct() {
        var mat = new Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        var vec = new Vec3d(2.0, 3.0, 4.0);
        var res = new Vec2d(20.0, 47.0);
        Assert.assertEquals(res, mat.multiply(vec));
    }

    @Test
    public void testMatrixVectorProductWithValues() {
        var mat = new Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        var res = new Vec2d(20.0, 47.0);
        Assert.assertEquals(res, mat.multiply(2.0, 3.0, 4.0));
    }

    @Test
    public void testMatrixVectorProductHelper() {
        var mat = new Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        var vec = new Vec2d(2.0, 3.0);
        var res = new Vec2d(20.0, 47.0);
        Assert.assertEquals(res, mat.multiply(vec, 4.0));
    }

    @Test
    public void testMatrixProductWith3x3Matrix() {
        var m1 = new Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        var m2 = new Mat3d(3.0, 4.0, 1.0, 2.0, 6.0, 5.0, -2.0, 8.0, -1.0);
        var res = new Mat2x3d(1.0, 40.0, 8.0, 10.0, 94.0, 23.0);
        Assert.assertEquals(res, m1.multiply(m2));
    }

    @Test
    public void testMatrixProductWith2x3MatrixAndThreeValues() {
        var m1 = new Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        var m2 = new Mat2x3d(3.0, 4.0, 1.0, 2.0, 6.0, 5.0);
        var res = new Mat2x3d(1.0, 40.0, 8.0, 10.0, 94.0, 23.0);
        Assert.assertEquals(res, m1.multiply(m2, -2.0, 8.0, -1.0));
    }

    @Test
    public void testMatrixProductWith2x3MatrixAndVector() {
        var m1 = new Mat2x3d(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        var m2 = new Mat2x3d(3.0, 4.0, 1.0, 2.0, 6.0, 5.0);
        var v = new Vec3d(-2.0, 8.0, -1.0);
        var res = new Mat2x3d(1.0, 40.0, 8.0, 10.0, 94.0, 23.0);
        Assert.assertEquals(res, m1.multiply(m2, v));
    }

    @Test
    public void testMatrixEqualsApprox() {
        var m1 = new Mat2x3d(1.00000001, 1.99999999, 3.00000001, 3.99999999, 0.00000001, -0.00000001);
        var m2 = new Mat2x3d(1.0, 2.0, 3.0, 4.0, 0.0, 0.0);
        Assert.assertTrue(m1.equalsApprox(m2));
    }
}
