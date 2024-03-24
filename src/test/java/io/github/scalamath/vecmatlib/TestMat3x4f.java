package io.github.scalamath.vecmatlib;

import org.junit.Assert;
import org.junit.Test;

public class TestMat3x4f {

    @Test
    public void testSumOfTwoMatrices() {
        var m1 = new Mat3x4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f);
        var m2 = new Mat3x4f(3.0f, 4.0f, 1.0f, 2.0f, 7.0f, 5.0f, 9.0f, 6.0f, 8.0f, 11.0f, 12.0f, 10.0f);
        var res = new Mat3x4f(4.0f, 6.0f, 4.0f, 6.0f, 12.0f, 11.0f, 16.0f, 14.0f, 17.0f, 21.0f, 23.0f, 22.0f);
        Assert.assertEquals(res, m1.plus(m2));
    }

    @Test
    public void testSubtractionOfTwoMatrices() {
        var m1 = new Mat3x4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f);
        var m2 = new Mat3x4f(3.0f, 4.0f, 1.0f, 2.0f, 7.0f, 5.0f, 9.0f, 6.0f, 8.0f, 11.0f, 12.0f, 10.0f);
        var res = new Mat3x4f(2.0f, 2.0f, -2.0f, -2.0f, 2.0f, -1.0f, 2.0f, -2.0f, -1.0f, 1.0f, 1.0f, -2.0f);
        Assert.assertEquals(res, m2.minus(m1));
    }

    @Test
    public void testNegatedMatrix() {
        var mat = new Mat3x4f(1.0f, 2.0f, -2.0f, -1.0f, 3.0f, -2.0f, 0.0f, -9.0f, 4.0f, 2.0f, 0.0f, -5.0f);
        var res = new Mat3x4f(-1.0f, -2.0f, 2.0f, 1.0f, -3.0f, 2.0f, 0.0f, 9.0f, -4.0f, -2.0f, 0.0f, 5.0f);
        Assert.assertEquals(res, mat.negated());
    }

    @Test
    public void testMatrixMultipliedByScalar() {
        var mat = new Mat3x4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f);
        var res = new Mat3x4f(1.5f, 3.0f, 4.5f, 6.0f, 7.5f, 9.0f, 10.5f, 12.0f, 13.5f, 15.0f, 16.5f, 18.0f);
        Assert.assertEquals(res, mat.multipliedBy(1.5f));
    }

    @Test
    public void testMatrixDividedByScalar() {
        var mat = new Mat3x4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f);
        var res = new Mat3x4f(0.5f, 1.0f, 1.5f, 2.0f, 2.5f, 3.0f, 3.5f, 4.0f, 4.5f, 5.0f, 5.5f, 6.0f);
        Assert.assertEquals(res, mat.dividedBy(2.0f));
    }

    @Test
    public void testMatrixVectorProduct() {
        var mat = new Mat3x4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f);
        var vec = new Vec4f(1.5f, 2.5f, 3.5f, 4.5f);
        var res = new Vec3f(35.0f, 83.0f, 131.0f);
        Assert.assertEquals(res, mat.multiply(vec));
    }

    @Test
    public void testMatrixVectorProductWithValues() {
        var mat = new Mat3x4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f);
        var res = new Vec3f(35.0f, 83.0f, 131.0f);
        Assert.assertEquals(res, mat.multiply(1.5f, 2.5f, 3.5f, 4.5f));
    }

    @Test
    public void testMatrixVectorProductHelper1() {
        var mat = new Mat3x4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f);
        var vec = new Vec3f(1.5f, 2.5f, 3.5f);
        var res = new Vec3f(35.0f, 83.0f, 131.0f);
        Assert.assertEquals(res, mat.multiply(vec, 4.5f));
    }

    @Test
    public void testMatrixVectorProductHelper2() {
        var mat = new Mat3x4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f);
        var vec = new Vec2f(1.5f, 2.5f);
        var res = new Vec3f(35.0f, 83.0f, 131.0f);
        Assert.assertEquals(res, mat.multiply(vec, 3.5f, 4.5f));
    }

    @Test
    public void testMatrixProductWith4x4Matrix() {
        var m1 = new Mat3x4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f);
        var m2 = new Mat4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f);
        var res = new Mat3x4f(90.0f, 100.0f, 110.0f, 120.0f, 202.0f, 228.0f, 254.0f, 280.0f, 314.0f, 356.0f, 398.0f, 440.0f);
        Assert.assertEquals(res, m1.multiply(m2));
    }

    @Test
    public void testMatrixEqualsApprox() {
        var m1 = new Mat3x4f(1.00000001f, 1.99999999f, 3.00000001f, 3.99999999f, 5.00000001f, 5.99999999f, 7.00000001f, 7.99999999f, 9.00000001f, 2.00000001f, 1.99999999f, 3.00000001f);
        var m2 = new Mat3x4f(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 2.0f, 2.0f, 3.0f);
        Assert.assertTrue(m1.equalsApprox(m2));
    }
}
