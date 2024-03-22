package io.github.hexagonnico;

import io.github.hexagonnico.vecmatlib.vector.Vec4d;
import org.junit.Assert;
import org.junit.Test;

public class TestVec4d {

    @Test
    public void testSumOfTwoVectors() {
        var a = new Vec4d(1.0, 2.0, 3.0, 3.0);
        var b = new Vec4d(2.0, 3.0, 1.0, -1.0);
        var res = new Vec4d(3.0, 5.0, 4.0, 2.0);
        Assert.assertEquals(res, a.plus(b));
    }

    @Test
    public void testSumVectorValues() {
        var v1 = new Vec4d(1.0, 2.0, 3.0, 3.0);
        var v2 = v1.plus(2.0, 3.0, 1.0, -1.0);
        var res = new Vec4d(3.0, 5.0, 4.0, 2.0);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testSubtractionOfTwoVectors() {
        var a = new Vec4d(3.0, 5.0, 4.0, 2.0);
        var b = new Vec4d(2.0, 3.0, 1.0, 4.0);
        var res = new Vec4d(1.0, 2.0, 3.0, -2.0);
        Assert.assertEquals(res, a.minus(b));
    }

    @Test
    public void testSubtractionVectorValues() {
        var v1 = new Vec4d(3.0, 5.0, 4.0, 2.0);
        var v2 = v1.minus(2.0, 3.0, 1.0, 4.0);
        var res = new Vec4d(1.0, 2.0, 3.0, -2.0);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testNegated() {
        var vec = new Vec4d(1.1, -2.2, 3.3, 0.0);
        var res = new Vec4d(-1.1, 2.2, -3.3, 0.0);
        Assert.assertEquals(res, vec.negated());
    }

    @Test
    public void testComponentWiseVectorMultiplication() {
        var a = new Vec4d(2.0, 3.0, 4.0, 1.0);
        var b = new Vec4d(3.0, 4.0, 2.0, 1.0);
        var res = new Vec4d(6.0, 12.0, 8.0, 1.0);
        Assert.assertEquals(res, a.multiply(b));
    }

    @Test
    public void testComponentWiseValuesMultiplication() {
        var v1 = new Vec4d(2.0, 3.0, 4.0, 1.0);
        var v2 = v1.multiply(3.0, 4.0, 2.0, 1.0);
        var res = new Vec4d(6.0, 12.0, 8.0, 1.0);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testVectorScalarMultiplication() {
        var v1 = new Vec4d(1.0, 2.0, 3.0, 4.0);
        var v2 = v1.multipliedBy(1.5);
        var res = new Vec4d(1.5, 3.0, 4.5, 6.0);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testComponentWiseVectorDivision() {
        var a = new Vec4d(6.0, 12.0, 8.0, 1.0);
        var b = new Vec4d(3.0, 4.0, 2.0, 2.0);
        var res = new Vec4d(2.0, 3.0, 4.0, 0.5);
        Assert.assertEquals(res, a.divide(b));
    }

    @Test
    public void testComponentWiseValuesDivision() {
        var v1 = new Vec4d(6.0, 12.0, 8.0, 1.0);
        var v2 = v1.divide(3.0, 4.0, 2.0, 2.0);
        var res = new Vec4d(2.0, 3.0, 4.0, 0.5);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testVectorScalarDivision() {
        var v1 = new Vec4d(1.0, 2.0, 3.0, 4.0);
        var v2 = v1.dividedBy(2.0);
        var res = new Vec4d(0.5, 1.0, 1.5, 2.0);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testComponentWiseVectorMod() {
        var a = new Vec4d(1.0, 3.0, 8.0, 8.0);
        var b = new Vec4d(2.0, 2.0, 3.0, 4.0);
        var res = new Vec4d(1.0, 1.0, 2.0, 0.0);
        Assert.assertEquals(res, a.mod(b));
    }

    @Test
    public void testComponentWiseValuesMod() {
        var v1 = new Vec4d(1.0, 3.0, 8.0, 8.0);
        var v2 = v1.mod(2.0, 2.0, 3.0, 4.0);
        var res = new Vec4d(1.0, 1.0, 2.0, 0.0);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testVectorScalarMod() {
        var v1 = new Vec4d(1.0, 3.0, 8.0, 9.0);
        var v2 = v1.mod(3.0);
        var res = new Vec4d(1.0, 0.0, 2.0, 0.0);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testVectorEqualsThreeValues() {
        var vec = new Vec4d(1.1, 2.2, 3.3, 4.4);
        Assert.assertTrue(vec.equals(1.1, 2.2, 3.3, 4.4));
    }

    @Test
    public void testVectorEqualsApproxTwoValues() {
        var vec = new Vec4d(1.0, 2.0, 3.0, 4.0);
        Assert.assertTrue(vec.equalsApprox(0.99999999, 1.99999999, 3.00000001, 4.00000001));
    }

    @Test
    public void testVectorEqualsApproxVector() {
        var v1 = new Vec4d(1.0, 2.0, 3.0, 4.0);
        var v2 = new Vec4d(0.99999999, 1.99999999, 3.00000001, 4.00000001);
        Assert.assertTrue(v1.equalsApprox(v2));
    }
}
