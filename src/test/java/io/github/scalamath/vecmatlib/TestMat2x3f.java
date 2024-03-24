package io.github.scalamath.vecmatlib;

import org.junit.Assert;
import org.junit.Test;

public class TestMat2x3f {

    @Test
    public void testSumOfTwoMatrices() {
        var m1 = new Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f);
        var m2 = new Mat2x3f(3.0f, 4.0f, 1.0f, 2.0f, 6.0f, 5.0f);
        var res = new Mat2x3f(4.0f, 6.0f, 4.0f, 6.0f, 11.0f, 11.0f);
        Assert.assertEquals(res, m1.plus(m2));
    }

    @Test
    public void testSubtractionOfTwoMatrices() {
        var m1 = new Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f);
        var m2 = new Mat2x3f(3.0f, 4.0f, 1.0f, 2.0f, 6.0f, 5.0f);
        var res = new Mat2x3f(2.0f, 2.0f, -2.0f, -2.0f, 1.0f, -1.0f);
        Assert.assertEquals(res, m2.minus(m1));
    }

    @Test
    public void testNegatedMatrix() {
        var mat = new Mat2x3f(1.0f, 2.0f, -2.0f, -1.0f, 3.0f, -2.0f);
        var res = new Mat2x3f(-1.0f, -2.0f, 2.0f, 1.0f, -3.0f, 2.0f);
        Assert.assertEquals(res, mat.negated());
    }

    @Test
    public void testMatrixMultipliedByScalar() {
        var mat = new Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f);
        var res = new Mat2x3f(1.5f, 3.0f, 4.5f, 6.0f, 7.5f, 9.0f);
        Assert.assertEquals(res, mat.multipliedBy(1.5f));
    }

    @Test
    public void testMatrixDividedByScalar() {
        var mat = new Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f);
        var res = new Mat2x3f(0.5f, 1.0f, 1.5f, 2.0f, 2.5f, 3.0f);
        Assert.assertEquals(res, mat.dividedBy(2.0f));
    }

    @Test
    public void testMatrixVectorProduct() {
        var mat = new Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f);
        var vec = new Vec3f(2.0f, 3.0f, 4.0f);
        var res = new Vec2f(20.0f, 47.0f);
        Assert.assertEquals(res, mat.multiply(vec));
    }

    @Test
    public void testMatrixVectorProductWithValues() {
        var mat = new Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f);
        var res = new Vec2f(20.0f, 47.0f);
        Assert.assertEquals(res, mat.multiply(2.0f, 3.0f, 4.0f));
    }

    @Test
    public void testMatrixVectorProductHelper() {
        var mat = new Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f);
        var vec = new Vec2f(2.0f, 3.0f);
        var res = new Vec2f(20.0f, 47.0f);
        Assert.assertEquals(res, mat.multiply(vec, 4.0f));
    }

    @Test
    public void testMatrixProductWith3x3Matrix() {
        var m1 = new Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f);
        var m2 = new Mat3f(3.0f, 4.0f, 1.0f, 2.0f, 6.0f, 5.0f, -2.0f, 8.0f, -1.0f);
        var res = new Mat2x3f(1.0f, 40.0f, 8.0f, 10.0f, 94.0f, 23.0f);
        Assert.assertEquals(res, m1.multiply(m2));
    }

    @Test
    public void testMatrixEqualsApprox() {
        var m1 = new Mat2x3f(1.00000001f, 1.99999999f, 3.00000001f, 3.99999999f, 0.00000001f, -0.00000001f);
        var m2 = new Mat2x3f(1.0f, 2.0f, 3.0f, 4.0f, 0.0f, 0.0f);
        Assert.assertTrue(m1.equalsApprox(m2));
    }
}
