package io.github.scalamath.vecmatlib;

import org.junit.Assert;
import org.junit.Test;

public class TestMat2i {

    @Test
    public void testSumOfTwoMatrices() {
        var m1 = new Mat2i(1, 2, 3, 4);
        var m2 = new Mat2i(3, 4, 1, 2);
        var res = new Mat2i(4, 6, 4, 6);
        Assert.assertEquals(res, m1.plus(m2));
    }

    @Test
    public void testSubtractionOfTwoMatrices() {
        var m1 = new Mat2i(1, 2, 3, 4);
        var m2 = new Mat2i(3, 4, 1, 2);
        var res = new Mat2i(2, 2, -2, -2);
        Assert.assertEquals(res, m2.minus(m1));
    }

    @Test
    public void testNegatedMatrix() {
        var mat = new Mat2i(1, 2, -2, -1);
        var res = new Mat2i(-1, -2, 2, 1);
        Assert.assertEquals(res, mat.negated());
    }

    @Test
    public void testMatrixMultipliedByScalar() {
        var mat = new Mat2i(1, 2, 3, 4);
        var res = new Mat2i(2, 4, 6, 8);
        Assert.assertEquals(res, mat.multipliedBy(2));
    }

    @Test
    public void testMatrixDividedByScalar() {
        var mat = new Mat2i(1, 2, 3, 4);
        var res = new Mat2i(0, 1, 1, 2);
        Assert.assertEquals(res, mat.dividedBy(2));
    }

    @Test
    public void testMatrixVectorProduct() {
        var mat = new Mat2i(1, 2, 3, 4);
        var vec = new Vec2i(2, 3);
        var res = new Vec2i(8, 18);
        Assert.assertEquals(res, mat.multiply(vec));
    }

    @Test
    public void testMatrixVectorProductWithValues() {
        var mat = new Mat2i(1, 2, 3, 4);
        var res = new Vec2i(8, 18);
        Assert.assertEquals(res, mat.multiply(2, 3));
    }

    @Test
    public void testMatrixProductWith2x2Matrix() {
        var m1 = new Mat2i(1, 2, 3, 4);
        var m2 = new Mat2i(3, 4, 1, 2);
        var res = new Mat2i(5, 8, 13, 20);
        Assert.assertEquals(res, m1.multiply(m2));
    }

    @Test
    public void testMatrixProductWith2x3Matrix() {
        var m1 = new Mat2i(1, 2, 3, 4);
        var m2 = new Mat2x3i(3, 4, 1, 2, 6, 5);
        var res = new Mat2x3i(7, 16, 11, 17, 36, 23);
        Assert.assertEquals(res, m1.multiply(m2));
    }
}
