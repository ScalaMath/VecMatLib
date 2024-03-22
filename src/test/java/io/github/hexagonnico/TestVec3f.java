package io.github.hexagonnico;

import io.github.hexagonnico.vecmatlib.vector.Vec3f;
import org.junit.Assert;
import org.junit.Test;

public class TestVec3f {

    @Test
    public void testSumOfTwoVectors() {
        var a = new Vec3f(1.0f, 2.0f, 3.0f);
        var b = new Vec3f(2.0f, 3.0f, 1.0f);
        var res = new Vec3f(3.0f, 5.0f, 4.0f);
        Assert.assertEquals(res, a.plus(b));
    }

    @Test
    public void testSumVectorValues() {
        var v1 = new Vec3f(1.0f, 2.0f, 3.0f);
        var v2 = v1.plus(2.0f, 3.0f, 1.0f);
        var res = new Vec3f(3.0f, 5.0f, 4.0f);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testSubtractionOfTwoVectors() {
        var a = new Vec3f(3.0f, 5.0f, 4.0f);
        var b = new Vec3f(2.0f, 3.0f, 1.0f);
        var res = new Vec3f(1.0f, 2.0f, 3.0f);
        Assert.assertEquals(res, a.minus(b));
    }

    @Test
    public void testSubtractionVectorValues() {
        var v1 = new Vec3f(3.0f, 5.0f, 4.0f);
        var v2 = v1.minus(2.0f, 3.0f, 1.0f);
        var res = new Vec3f(1.0f, 2.0f, 3.0f);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testNegated() {
        var vec = new Vec3f(1.1f, -2.2f, 3.3f);
        var res = new Vec3f(-1.1f, 2.2f, -3.3f);
        Assert.assertEquals(res, vec.negated());
    }

    @Test
    public void testComponentWiseVectorMultiplication() {
        var a = new Vec3f(2.0f, 3.0f, 4.0f);
        var b = new Vec3f(3.0f, 4.0f, 2.0f);
        var res = new Vec3f(6.0f, 12.0f, 8.0f);
        Assert.assertEquals(res, a.multiply(b));
    }

    @Test
    public void testComponentWiseValuesMultiplication() {
        var v1 = new Vec3f(2.0f, 3.0f, 4.0f);
        var v2 = v1.multiply(3.0f, 4.0f, 2.0f);
        var res = new Vec3f(6.0f, 12.0f, 8.0f);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testVectorScalarMultiplication() {
        var v1 = new Vec3f(1.0f, 2.0f, 3.0f);
        var v2 = v1.multipliedBy(1.5f);
        var res = new Vec3f(1.5f, 3.0f, 4.5f);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testComponentWiseVectorDivision() {
        var a = new Vec3f(6.0f, 12.0f, 8.0f);
        var b = new Vec3f(3.0f, 4.0f, 2.0f);
        var res = new Vec3f(2.0f, 3.0f, 4.0f);
        Assert.assertEquals(res, a.divide(b));
    }

    @Test
    public void testComponentWiseValuesDivision() {
        var v1 = new Vec3f(6.0f, 12.0f, 8.0f);
        var v2 = v1.divide(3.0f, 4.0f, 2.0f);
        var res = new Vec3f(2.0f, 3.0f, 4.0f);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testVectorScalarDivision() {
        var v1 = new Vec3f(1.0f, 2.0f, 3.0f);
        var v2 = v1.dividedBy(2.0f);
        var res = new Vec3f(0.5f, 1.0f, 1.5f);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testComponentWiseVectorMod() {
        var a = new Vec3f(1.0f, 3.0f, 8.0f);
        var b = new Vec3f(2.0f, 2.0f, 3.0f);
        var res = new Vec3f(1.0f, 1.0f, 2.0f);
        Assert.assertEquals(res, a.mod(b));
    }

    @Test
    public void testComponentWiseValuesMod() {
        var v1 = new Vec3f(1.0f, 3.0f, 8.0f);
        var v2 = v1.mod(2.0f, 2.0f, 3.0f);
        var res = new Vec3f(1.0f, 1.0f, 2.0f);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testVectorScalarMod() {
        var v1 = new Vec3f(1.0f, 3.0f, 8.0f);
        var v2 = v1.mod(3.0f);
        var res = new Vec3f(1.0f, 0.0f, 2.0f);
        Assert.assertEquals(res, v2);
    }

    @Test
    public void testVectorEqualsThreeValues() {
        var vec = new Vec3f(1.1f, 2.2f, 3.3f);
        Assert.assertTrue(vec.equals(1.1f, 2.2f, 3.3f));
    }

    @Test
    public void testVectorEqualsApproxTwoValues() {
        var vec = new Vec3f(1.0f, 2.0f, 3.0f);
        Assert.assertTrue(vec.equalsApprox(0.99999999f, 1.99999999f, 3.00000001f));
    }

    @Test
    public void testVectorEqualsApproxVector() {
        var v1 = new Vec3f(1.0f, 2.0f, 3.0f);
        var v2 = new Vec3f(0.99999999f, 1.99999999f, 3.00000001f);
        Assert.assertTrue(v1.equalsApprox(v2));
    }
}
