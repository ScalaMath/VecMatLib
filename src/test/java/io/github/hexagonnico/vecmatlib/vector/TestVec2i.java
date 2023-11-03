package io.github.hexagonnico.vecmatlib.vector;

import org.junit.Assert;
import org.junit.Test;

public class TestVec2i {

    @Test
    public void testPlusValues() {
        Vec2i vector = new Vec2i(1, 2);
        Assert.assertEquals(vector.plus(2, 3), vector.$plus(2, 3));
    }

    @Test
    public void testPlusVector() {
        Vec2i a = new Vec2i(1, 5);
        Vec2i b = new Vec2i(5, 3);
        Assert.assertEquals(a.plus(b), a.$plus(b));
    }

    @Test
    public void testNegated() {
        Vec2i vector = new Vec2i(1, 2);
        Assert.assertEquals(vector.negated(), vector.unary_$minus());
    }

    @Test
    public void testMinusValues() {
        Vec2i vector = new Vec2i(1, 2);
        Assert.assertEquals(vector.minus(2, 3), vector.$minus(2, 3));
    }

    @Test
    public void testMinusVector() {
        Vec2i a = new Vec2i(1, 5);
        Vec2i b = new Vec2i(5, 3);
        Assert.assertEquals(a.minus(b), a.$minus(b));
    }

    @Test
    public void testMultiplyScalar() {
        Vec2i vector = new Vec2i(1, 2);
        Assert.assertEquals(vector.multipliedBy(2), vector.$times(2));
    }

    @Test
    public void testMultiplyValues() {
        Vec2i vector = new Vec2i(1, 2);
        Assert.assertEquals(vector.multiply(2, 3), vector.$times(2, 3));
    }

    @Test
    public void testMultiplyVector() {
        Vec2i a = new Vec2i(1, 5);
        Vec2i b = new Vec2i(5, 3);
        Assert.assertEquals(a.multiply(b), a.$times(b));
    }

    @Test
    public void testDivideScalar() {
        Vec2i vector = new Vec2i(1, 2);
        Assert.assertEquals(vector.dividedBy(2), vector.$div(2));
    }

    @Test
    public void testToArray() {
        Vec2i vector = new Vec2i(1, 2);
        int[] array = new int[] {1, 2};
        Assert.assertArrayEquals(array, vector.toArray());
    }
}
