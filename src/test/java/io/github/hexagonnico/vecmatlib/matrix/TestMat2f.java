package io.github.hexagonnico.vecmatlib.matrix;

import io.github.hexagonnico.vecmatlib.vector.Vec2f;
import org.junit.Assert;
import org.junit.Test;

public class TestMat2f {

    @Test
    public void testPlus() {
        Mat2f a = new Mat2f(
                1.0f, 2.0f,
                3.0f, 4.0f
        );
        Mat2f b = new Mat2f(
                4.0f, 5.0f,
                3.0f, 6.0f
        );
        Assert.assertEquals(a.$plus(b), a.plus(b));
    }

    @Test
    public void testNegated() {
        Mat2f m = new Mat2f(
                1.0f, 2.0f,
                3.0f, 4.0f
        );
        Assert.assertEquals(m.unary_$minus(), m.negated());
    }

    @Test
    public void testMultiplyByScalar() {
        Mat2f m = new Mat2f(
                1.0f, 2.0f,
                3.0f, 4.0f
        );
        Assert.assertEquals(m.$times(1.5f), m.multipliedBy(1.5f));
    }

    @Test
    public void testMultiplyVector() {
        Mat2f m = new Mat2f(
                1.0f, 2.0f,
                3.0f, 4.0f
        );
        Vec2f v = new Vec2f(1.5f, 2.5f);
        Assert.assertEquals(m.$times(v), m.multiply(v));
    }

    @Test
    public void testMultiplyVectorValues() {
        Mat2f m = new Mat2f(
                1.0f, 2.0f,
                3.0f, 4.0f
        );
        Assert.assertEquals(m.$times(1.5f, 2.5f), m.multiply(1.5f, 2.5f));
    }

    @Test
    public void testMultiplyMatrix() {
        Mat2f a = new Mat2f(
                1.0f, 2.0f,
                3.0f, 4.0f
        );
        Mat2f b = new Mat2f(
                4.0f, 5.0f,
                3.0f, 6.0f
        );
        Assert.assertEquals(a.$times(b), a.multiply(b));
    }
}
