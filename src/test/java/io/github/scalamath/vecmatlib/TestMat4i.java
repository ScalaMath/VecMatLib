package io.github.scalamath.vecmatlib;

import org.junit.Assert;
import org.junit.Test;

public class TestMat4i {

    @Test
    public void testSumOfTwoMatrices() {
        var m1 = new Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        var m2 = new Mat4i(3, 4, 1, 2, 7, 5, 9, 6, 8, 11, 14, 16, 15, 13, 12, 10);
        var res = new Mat4i(4, 6, 4, 6, 12, 11, 16, 14, 17, 21, 25, 28, 28, 27, 27, 26);
        Assert.assertEquals(res, m1.plus(m2));
    }

    @Test
    public void testSubtractionOfTwoMatrices() {
        var m1 = new Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        var m2 = new Mat4i(3, 4, 1, 2, 7, 5, 9, 6, 8, 11, 14, 16, 15, 13, 12, 10);
        var res = new Mat4i(2, 2, -2, -2, 2, -1, 2, -2, -1, 1, 3, 4, 2, -1, -3, -6);
        Assert.assertEquals(res, m2.minus(m1));
    }

    @Test
    public void testNegatedMatrix() {
        var mat = new Mat4i(1, 2, -2, -1, 3, -2, 0, -9, 4, 2, -5, -4, 7, 2, 8, 0);
        var res = new Mat4i(-1, -2, 2, 1, -3, 2, 0, 9, -4, -2, 5, 4, -7, -2, -8, 0);
        Assert.assertEquals(res, mat.negated());
    }

    @Test
    public void testMatrixMultipliedByScalar() {
        var mat = new Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        var res = new Mat4i(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32);
        Assert.assertEquals(res, mat.multipliedBy(2));
    }

    @Test
    public void testMatrixDividedByScalar() {
        var mat = new Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        var res = new Mat4i(0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8);
        Assert.assertEquals(res, mat.dividedBy(2));
    }

    @Test
    public void testMatrixVectorProduct() {
        var mat = new Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        var vec = new Vec4i(2, 3, 4, 5);
        var res = new Vec4i(40, 96, 152, 208);
        Assert.assertEquals(res, mat.multiply(vec));
    }

    @Test
    public void testMatrixVectorProductWithValues() {
        var mat = new Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        var res = new Vec4i(40, 96, 152, 208);
        Assert.assertEquals(res, mat.multiply(2, 3, 4, 5));
    }

    @Test
    public void testMatrixVectorProductHelper1() {
        var mat = new Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        var vec = new Vec3i(2, 3, 4);
        var res = new Vec4i(40, 96, 152, 208);
        Assert.assertEquals(res, mat.multiply(vec, 5));
    }

    @Test
    public void testMatrixVectorProductHelper2() {
        var mat = new Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        var vec = new Vec2i(2, 3);
        var res = new Vec4i(40, 96, 152, 208);
        Assert.assertEquals(res, mat.multiply(vec, 4, 5));
    }

    @Test
    public void testMatrixProductWith4x4Matrix() {
        var m1 = new Mat4i(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        var m2 = new Mat4i(3, 4, 1, 2, 7, 5, 9, 6, 8, 11, 14, 16, 15, 13, 12, 10);
        var res = new Mat4i(101, 99, 109, 102, 233, 231, 253, 238, 365, 363, 397, 374, 497, 495, 541, 510);
        Assert.assertEquals(res, m1.multiply(m2));
    }
}
