package io.github.scalamath.vecmatlib;

import org.junit.Assert;
import org.junit.Test;

public class TestVec4i {

    @Test
    public void testSumOfTwoVectors() {
        var a = new Vec4i(1, 2, 3, 3);
        var b = new Vec4i(2, 3, 1, -1);
        var res = new Vec4i(3, 5, 4, 2);
        Assert.assertEquals(res, a.plus(b));
    }

    @Test
    public void testSumVectorValues() {
        var v1 = new Vec4i(1, 2, 3, 3);
        var v2 = v1.plus(2, 3, 1, -1);
        var res = new Vec4i(3, 5, 4, 2);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testSubtractionOfTwoVectors() {
        var a = new Vec4i(3, 5, 4, 2);
        var b = new Vec4i(2, 3, 1, 4);
        var res = new Vec4i(1, 2, 3, -2);
        Assert.assertEquals(res, a.minus(b));
    }

    @Test
    public void testSubtractionVectorValues() {
        var v1 = new Vec4i(3, 5, 4, 2);
        var v2 = v1.minus(2, 3, 1, 4);
        var res = new Vec4i(1, 2, 3, -2);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testNegated() {
        var vec = new Vec4i(1, -2, 3, 0);
        var res = new Vec4i(-1, 2, -3, 0);
        Assert.assertEquals(res, vec.negated());
    }

    @Test
    public void testComponentWiseVectorMultiplication() {
        var a = new Vec4i(2, 3, 4, 1);
        var b = new Vec4i(3, 4, 2, 1);
        var res = new Vec4i(6, 12, 8, 1);
        Assert.assertEquals(res, a.multiply(b));
    }

    @Test
    public void testComponentWiseValuesMultiplication() {
        var v1 = new Vec4i(2, 3, 4, 1);
        var v2 = v1.multiply(3, 4, 2, 1);
        var res = new Vec4i(6, 12, 8, 1);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testVectorScalarMultiplication() {
        var v1 = new Vec4i(1, 2, 3, 4);
        var v2 = v1.multipliedBy(2);
        var res = new Vec4i(2, 4, 6, 8);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testComponentWiseVectorDivision() {
        var a = new Vec4i(6, 12, 8, 1);
        var b = new Vec4i(3, 4, 2, 2);
        var res = new Vec4i(2, 3, 4, 0);
        Assert.assertEquals(res, a.divide(b));
    }

    @Test
    public void testComponentWiseValuesDivision() {
        var v1 = new Vec4i(6, 12, 8, 1);
        var v2 = v1.divide(3, 4, 2, 2);
        var res = new Vec4i(2, 3, 4, 0);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testVectorScalarDivision() {
        var v1 = new Vec4i(1, 2, 3, 4);
        var v2 = v1.dividedBy(2);
        var res = new Vec4i(0, 1, 1, 2);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testComponentWiseVectorMod() {
        var a = new Vec4i(1, 3, 8, 8);
        var b = new Vec4i(2, 2, 3, 4);
        var res = new Vec4i(1, 1, 2, 0);
        Assert.assertEquals(res, a.mod(b));
    }

    @Test
    public void testComponentWiseValuesMod() {
        var v1 = new Vec4i(1, 3, 8, 8);
        var v2 = v1.mod(2, 2, 3, 4);
        var res = new Vec4i(1, 1, 2, 0);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testVectorScalarMod() {
        var v1 = new Vec4i(1, 3, 8, 9);
        var v2 = v1.mod(3);
        var res = new Vec4i(1, 0, 2, 0);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testVectorEqualsThreeValues() {
        var vec = new Vec4i(1, 2, 3, 4);
        Assert.assertTrue(vec.equals(1, 2, 3, 4));
    }
}
