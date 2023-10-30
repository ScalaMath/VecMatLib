package io.github.hexagonnico.vecmatlib.vector;

import org.junit.Assert;
import org.junit.Test;

public class TestVec2d {

    @Test
    public void testPlusValues() {
        Vec2d vector = new Vec2d(1.0, 2.0);
        Assert.assertEquals(vector.plus(2.0, 3.0), vector.$plus(2.0, 3.0));
    }

    @Test
    public void testPlusVector() {
        Vec2d a = new Vec2d(1.0, 1.5);
        Vec2d b = new Vec2d(1.5, 3.0);
        Assert.assertEquals(a.plus(b), a.$plus(b));
    }

    @Test
    public void testNegated() {
        Vec2d vector = new Vec2d(1.0, 2.0);
        Assert.assertEquals(vector.negated(), vector.unary_$minus());
    }

    @Test
    public void testMinusValues() {
        Vec2d vector = new Vec2d(1.0, 2.0);
        Assert.assertEquals(vector.minus(2.0, 3.0), vector.$minus(2.0, 3.0));
    }

    @Test
    public void testMinusVector() {
        Vec2d a = new Vec2d(1.0, 1.5);
        Vec2d b = new Vec2d(1.5, 3.0);
        Assert.assertEquals(a.minus(b), a.$minus(b));
    }

    @Test
    public void testMultiplyScalar() {
        Vec2d vector = new Vec2d(1.0, 2.0);
        Assert.assertEquals(vector.multipliedBy(1.5), vector.$times(1.5));
    }

    @Test
    public void testMultiplyValues() {
        Vec2d vector = new Vec2d(1.0, 2.0);
        Assert.assertEquals(vector.multiply(2.0, 3.0), vector.$times(2.0, 3.0));
    }

    @Test
    public void testMultiplyVector() {
        Vec2d a = new Vec2d(1.0, 1.5);
        Vec2d b = new Vec2d(1.5, 3.0);
        Assert.assertEquals(a.multiply(b), a.$times(b));
    }

    @Test
    public void testDivideScalar() {
        Vec2d vector = new Vec2d(1.0, 2.0);
        Assert.assertEquals(vector.dividedBy(1.5), vector.$div(1.5));
    }

    @Test
    public void testDivideVector() {
        Vec2d a = new Vec2d(1.0, 1.5);
        Vec2d b = new Vec2d(1.5, 3.0);
        Assert.assertEquals(a.divide(b), a.$div(b));
    }

    @Test
    public void testDivideValues() {
        Vec2d vector = new Vec2d(1.0, 1.5);
        Assert.assertEquals(vector.divide(1.5, 3.0), vector.$div(1.5, 3.0));
    }

    @Test
    public void testToArray() {
        Vec2d vector = new Vec2d(1.1, 2.2);
        double[] array = new double[] {1.1, 2.2};
        Assert.assertArrayEquals(array, vector.toArray(), 0.000001);
    }
}
