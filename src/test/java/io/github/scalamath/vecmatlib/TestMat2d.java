package io.github.scalamath.vecmatlib;

import org.junit.Assert;
import org.junit.Test;

public class TestMat2d {

    @Test
    public void testSumOfTwoMatrices() {
        var m1 = new Mat2d(1.0, 2.0, 3.0, 4.0);
        var m2 = new Mat2d(3.0, 4.0, 1.0, 2.0);
        var res = new Mat2d(4.0, 6.0, 4.0, 6.0);
        Assert.assertEquals(res, m1.plus(m2));
    }

    @Test
    public void testSubtractionOfTwoMatrices() {
        var m1 = new Mat2d(1.0, 2.0, 3.0, 4.0);
        var m2 = new Mat2d(3.0, 4.0, 1.0, 2.0);
        var res = new Mat2d(2.0, 2.0, -2.0, -2.0);
        Assert.assertEquals(res, m2.minus(m1));
    }

    @Test
    public void testNegatedMatrix() {
        var mat = new Mat2d(1.0, 2.0, -2.0, -1.0);
        var res = new Mat2d(-1.0, -2.0, 2.0, 1.0);
        Assert.assertEquals(res, mat.negated());
    }

    @Test
    public void testMatrixMultipliedByScalar() {
        var mat = new Mat2d(1.0, 2.0, 3.0, 4.0);
        var res = new Mat2d(1.5, 3.0, 4.5, 6.0);
        Assert.assertEquals(res, mat.multipliedBy(1.5));
    }

    @Test
    public void testMatrixDividedByScalar() {
        var mat = new Mat2d(1.0, 2.0, 3.0, 4.0);
        var res = new Mat2d(0.5, 1.0, 1.5, 2.0);
        Assert.assertEquals(res, mat.dividedBy(2.0));
    }

    @Test
    public void testMatrixVectorProduct() {
        var mat = new Mat2d(1.0, 2.0, 3.0, 4.0);
        var vec = new Vec2d(1.5, 2.5);
        var res = new Vec2d(6.5, 14.5);
        Assert.assertEquals(res, mat.multiply(vec));
    }

    @Test
    public void testMatrixVectorProductWithValues() {
        var mat = new Mat2d(1.0, 2.0, 3.0, 4.0);
        var res = new Vec2d(6.5, 14.5);
        Assert.assertEquals(res, mat.multiply(1.5, 2.5));
    }

    @Test
    public void testMatrixProductWith2x2Matrix() {
        var m1 = new Mat2d(1.0, 2.0, 3.0, 4.0);
        var m2 = new Mat2d(3.0, 4.0, 1.0, 2.0);
        var res = new Mat2d(5.0, 8.0, 13.0, 20.0);
        Assert.assertEquals(res, m1.multiply(m2));
    }

    @Test
    public void testMatrixProductWith2x3Matrix() {
        var m1 = new Mat2d(1.0, 2.0, 3.0, 4.0);
        var m2 = new Mat2x3d(3.0, 4.0, 1.0, 2.0, 6.0, 5.0);
        var res = new Mat2x3d(7.0, 16.0, 11.0, 17.0, 36.0, 23.0);
        Assert.assertEquals(res, m1.multiply(m2));
    }

    @Test
    public void testMatrixEqualsApprox() {
        var m1 = new Mat2d(1.00000001, 1.99999999, 3.00000001, 3.99999999);
        var m2 = new Mat2d(1.0, 2.0, 3.0, 4.0);
        Assert.assertTrue(m1.equalsApprox(m2));
    }
}
