package io.github.scalamath.vecmatlib;

import org.junit.Assert;
import org.junit.Test;

public class TestMat2f {

    @Test
    public void testSumOfTwoMatrices() {
        var m1 = new Mat2f(1.0f, 2.0f, 3.0f, 4.0f);
        var m2 = new Mat2f(3.0f, 4.0f, 1.0f, 2.0f);
        var res = new Mat2f(4.0f, 6.0f, 4.0f, 6.0f);
        Assert.assertEquals(res, m1.plus(m2));
    }

    @Test
    public void testSubtractionOfTwoMatrices() {
        var m1 = new Mat2f(1.0f, 2.0f, 3.0f, 4.0f);
        var m2 = new Mat2f(3.0f, 4.0f, 1.0f, 2.0f);
        var res = new Mat2f(2.0f, 2.0f, -2.0f, -2.0f);
        Assert.assertEquals(res, m2.minus(m1));
    }

    @Test
    public void testNegatedMatrix() {
        var mat = new Mat2f(1.0f, 2.0f, -2.0f, -1.0f);
        var res = new Mat2f(-1.0f, -2.0f, 2.0f, 1.0f);
        Assert.assertEquals(res, mat.negated());
    }

    @Test
    public void testMatrixMultipliedByScalar() {
        var mat = new Mat2f(1.0f, 2.0f, 3.0f, 4.0f);
        var res = new Mat2f(1.5f, 3.0f, 4.5f, 6.0f);
        Assert.assertEquals(res, mat.multipliedBy(1.5f));
    }

    @Test
    public void testMatrixDividedByScalar() {
        var mat = new Mat2f(1.0f, 2.0f, 3.0f, 4.0f);
        var res = new Mat2f(0.5f, 1.0f, 1.5f, 2.0f);
        Assert.assertEquals(res, mat.dividedBy(2.0f));
    }

    @Test
    public void testMatrixVectorProduct() {
        var mat = new Mat2f(1.0f, 2.0f, 3.0f, 4.0f);
        var vec = new Vec2f(1.5f, 2.5f);
        var res = new Vec2f(6.5f, 14.5f);
        Assert.assertEquals(res, mat.multiply(vec));
    }

    @Test
    public void testMatrixVectorProductWithValues() {
        var mat = new Mat2f(1.0f, 2.0f, 3.0f, 4.0f);
        var res = new Vec2f(6.5f, 14.5f);
        Assert.assertEquals(res, mat.multiply(1.5f, 2.5f));
    }

    @Test
    public void testMatrixProductWith2x2Matrix() {
        var m1 = new Mat2f(1.0f, 2.0f, 3.0f, 4.0f);
        var m2 = new Mat2f(3.0f, 4.0f, 1.0f, 2.0f);
        var res = new Mat2f(5.0f, 8.0f, 13.0f, 20.0f);
        Assert.assertEquals(res, m1.multiply(m2));
    }

    @Test
    public void testMatrixProductWith2x3Matrix() {
        var m1 = new Mat2f(1.0f, 2.0f, 3.0f, 4.0f);
        var m2 = new Mat2x3f(3.0f, 4.0f, 1.0f, 2.0f, 6.0f, 5.0f);
        var res = new Mat2x3f(7.0f, 16.0f, 11.0f, 17.0f, 36.0f, 23.0f);
        Assert.assertEquals(res, m1.multiply(m2));
    }

    @Test
    public void testMatrixEqualsApprox() {
        var m1 = new Mat2f(1.00000001f, 1.99999999f, 3.00000001f, 3.99999999f);
        var m2 = new Mat2f(1.0f, 2.0f, 3.0f, 4.0f);
        Assert.assertTrue(m1.equalsApprox(m2));
    }
}
