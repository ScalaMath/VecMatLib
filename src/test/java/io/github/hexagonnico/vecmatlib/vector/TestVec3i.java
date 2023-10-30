package io.github.hexagonnico.vecmatlib.vector;

import org.junit.Assert;
import org.junit.Test;

public class TestVec3i {

    @Test
    public void testPlusValues() {
        Vec3i vector = new Vec3i(1, 2, 3);
        Assert.assertEquals(vector.plus(2, 3, 4), vector.$plus(2, 3, 4));
    }

    @Test
    public void testPlusVector() {
        Vec3i a = new Vec3i(1, 5, 2);
        Vec3i b = new Vec3i(5, 3, 4);
        Assert.assertEquals(a.plus(b), a.$plus(b));
    }

    @Test
    public void testNegated() {
        Vec3i vector = new Vec3i(1, 2, 3);
        Assert.assertEquals(vector.negated(), vector.unary_$minus());
    }

    @Test
    public void testMinusValues() {
        Vec3i vector = new Vec3i(1, 2, 3);
        Assert.assertEquals(vector.minus(2, 3, 4), vector.$minus(2, 3, 4));
    }

    @Test
    public void testMinusVector() {
        Vec3i a = new Vec3i(1, 5, 2);
        Vec3i b = new Vec3i(5, 3, 4);
        Assert.assertEquals(a.minus(b), a.$minus(b));
    }

    @Test
    public void testMultiplyScalar() {
        Vec3i vector = new Vec3i(1, 2, 3);
        Assert.assertEquals(vector.multipliedBy(2), vector.$times(2));
    }

    @Test
    public void testMultiplyValues() {
        Vec3i vector = new Vec3i(1, 2, 3);
        Assert.assertEquals(vector.multiply(2, 3, 4), vector.$times(2, 3, 4));
    }

    @Test
    public void testMultiplyVector() {
        Vec3i a = new Vec3i(1, 5, 2);
        Vec3i b = new Vec3i(5, 3, 4);
        Assert.assertEquals(a.multiply(b), a.$times(b));
    }

    @Test
    public void testDivideScalar() {
        Vec3i vector = new Vec3i(1, 2, 3);
        Assert.assertEquals(vector.dividedBy(2), vector.$div(2));
    }

    @Test
    public void testToArray() {
        Vec3i vector = new Vec3i(1, 2, 3);
        int[] array = new int[] {1, 2, 3};
        Assert.assertArrayEquals(array, vector.toArray());
    }
}
