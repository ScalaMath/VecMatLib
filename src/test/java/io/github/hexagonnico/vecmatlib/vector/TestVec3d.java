package io.github.hexagonnico.vecmatlib.vector;

import org.junit.Assert;
import org.junit.Test;

public class TestVec3d {

    @Test
    public void testPlusValues() {
        Vec3d vector = new Vec3d(1.0, 2.0, 3.0);
        Assert.assertEquals(vector.plus(2.0, 3.0, 4.0), vector.$plus(2.0, 3.0, 4.0));
    }

    @Test
    public void testPlusVector() {
        Vec3d a = new Vec3d(1.0, 1.5, 2.0);
        Vec3d b = new Vec3d(1.5, 3.0, 4.0);
        Assert.assertEquals(a.plus(b), a.$plus(b));
    }

    @Test
    public void testNegated() {
        Vec3d vector = new Vec3d(1.0, 2.0, 3.0);
        Assert.assertEquals(vector.negated(), vector.unary_$minus());
    }

    @Test
    public void testMinusValues() {
        Vec3d vector = new Vec3d(1.0, 2.0, 3.0);
        Assert.assertEquals(vector.minus(2.0, 3.0, 4.0), vector.$minus(2.0, 3.0, 4.0));
    }

    @Test
    public void testMinusVector() {
        Vec3d a = new Vec3d(1.0, 1.5, 2.0);
        Vec3d b = new Vec3d(1.5, 3.0, 4.0);
        Assert.assertEquals(a.minus(b), a.$minus(b));
    }

    @Test
    public void testMultiplyScalar() {
        Vec3d vector = new Vec3d(1.0, 2.0, 3.0);
        Assert.assertEquals(vector.multipliedBy(1.5), vector.$times(1.5));
    }

    @Test
    public void testMultiplyValues() {
        Vec3d vector = new Vec3d(1.0, 2.0, 3.0);
        Assert.assertEquals(vector.multiply(2.0, 3.0, 4.0), vector.$times(2.0, 3.0, 4.0));
    }

    @Test
    public void testMultiplyVector() {
        Vec3d a = new Vec3d(1.0, 1.5, 2.0);
        Vec3d b = new Vec3d(1.5, 3.0, 4.0);
        Assert.assertEquals(a.multiply(b), a.$times(b));
    }

    @Test
    public void testDivideScalar() {
        Vec3d vector = new Vec3d(1.0, 2.0, 3.0);
        Assert.assertEquals(vector.dividedBy(1.5), vector.$div(1.5));
    }

    @Test
    public void testDivideVector() {
        Vec3d a = new Vec3d(1.0, 1.5, 2.0);
        Vec3d b = new Vec3d(1.5, 3.0, 4.0);
        Assert.assertEquals(a.divide(b), a.$div(b));
    }

    @Test
    public void testDivideValues() {
        Vec3d vector = new Vec3d(1.0, 1.5, 2.0);
        Assert.assertEquals(vector.divide(1.5, 3.0, 4.0), vector.$div(1.5, 3.0, 4.0));
    }

    @Test
    public void testToArray() {
        Vec3d vector = new Vec3d(1.1, 2.2, 3.3);
        double[] array = new double[] {1.1, 2.2, 3.3};
        Assert.assertArrayEquals(array, vector.toArray(), 0.000001);
    }
}
