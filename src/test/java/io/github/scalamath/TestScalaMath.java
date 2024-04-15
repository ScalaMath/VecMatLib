package io.github.scalamath;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestScalaMath {

    @Test
    public void testClampInt() {
        Assert.assertEquals(5, ScalaMath.clamp(5, 0, 10));
        Assert.assertEquals(0, ScalaMath.clamp(-1, 0, 10));
        Assert.assertEquals(10, ScalaMath.clamp(12, 0, 10));
    }

    @Test
    public void testClampFloat() {
        Assert.assertEquals(0.5f, ScalaMath.clamp(0.5f, 0.0f, 1.0f), 1e-12f);
        Assert.assertEquals(0.0f, ScalaMath.clamp(-1.0f, 0.0f, 1.0f), 1e-12f);
        Assert.assertEquals(1.0f, ScalaMath.clamp(1.2f, 0.0f, 1.0f), 1e-12f);
    }

    @Test
    public void testClampDouble() {
        Assert.assertEquals(0.5, ScalaMath.clamp(0.5, 0.0, 1.0), 1e-12);
        Assert.assertEquals(0.0, ScalaMath.clamp(-1.0, 0.0, 1.0), 1e-12);
        Assert.assertEquals(1.0, ScalaMath.clamp(1.2, 0.0, 1.0), 1e-12);
    }

    @Test
    public void testLerpFloat() {
        Assert.assertEquals(1.5f, ScalaMath.lerp(1.0f, 2.0f, 0.5f), 1e-12f);
        Assert.assertEquals(1.25f, ScalaMath.lerp(1.0f, 2.0f, 0.25f), 1e-12f);
        Assert.assertEquals(1.75f, ScalaMath.lerp(1.0f, 2.0f, 0.75f), 1e-12f);
        Assert.assertEquals(1.0f, ScalaMath.lerp(1.0f, 2.0f, 0.0f), 1e-12f);
        Assert.assertEquals(2.0f, ScalaMath.lerp(1.0f, 2.0f, 1.0f), 1e-12f);
    }

    @Test
    public void testLerpDouble() {
        Assert.assertEquals(1.5, ScalaMath.lerp(1.0, 2.0, 0.5), 1e-12);
        Assert.assertEquals(1.25, ScalaMath.lerp(1.0, 2.0, 0.25), 1e-12);
        Assert.assertEquals(1.75, ScalaMath.lerp(1.0, 2.0, 0.75), 1e-12);
        Assert.assertEquals(1.0, ScalaMath.lerp(1.0, 2.0, 0.0), 1e-12);
        Assert.assertEquals(2.0, ScalaMath.lerp(1.0, 2.0, 1.0), 1e-12);
    }

    @Test
    public void testIntMoveToward() {
        Assert.assertEquals(3, ScalaMath.moveToward(1, 5, 2));
        Assert.assertEquals(5, ScalaMath.moveToward(1, 5, 6));
        Assert.assertEquals(3, ScalaMath.moveToward(5, 1, 2));
        Assert.assertEquals(1, ScalaMath.moveToward(5, 1, 6));
    }

    @Test
    public void testLongMoveToward() {
        Assert.assertEquals(3L, ScalaMath.moveToward(1L, 5L, 2L));
        Assert.assertEquals(5L, ScalaMath.moveToward(1L, 5L, 6L));
        Assert.assertEquals(3L, ScalaMath.moveToward(5L, 1L, 2L));
        Assert.assertEquals(1L, ScalaMath.moveToward(5L, 1L, 6L));
    }

    @Test
    public void testFloatMoveToward() {
        Assert.assertEquals(1.6f, ScalaMath.moveToward(1.0f, 2.0f, 0.6f), 1e-12);
        Assert.assertEquals(2.0f, ScalaMath.moveToward(1.0f, 2.0f, 3.0f), 1e-12);
        Assert.assertEquals(1.4f, ScalaMath.moveToward(2.0f, 1.0f, 0.6f), 1e-12);
        Assert.assertEquals(1.0f, ScalaMath.moveToward(2.0f, 1.0f, 3.0f), 1e-12);
    }

    @Test
    public void testDoubleMoveToward() {
        Assert.assertEquals(1.6, ScalaMath.moveToward(1.0, 2.0, 0.6), 1e-12);
        Assert.assertEquals(2.0, ScalaMath.moveToward(1.0, 2.0, 3.0), 1e-12);
        Assert.assertEquals(1.4, ScalaMath.moveToward(2.0, 1.0, 0.6), 1e-12);
        Assert.assertEquals(1.0, ScalaMath.moveToward(2.0, 1.0, 3.0), 1e-12);
    }

    @Test
    public void testMapIntRange() {
        Assert.assertEquals(50, ScalaMath.map(5, 0, 10, 0, 100));
        Assert.assertEquals(120, ScalaMath.map(12, 0, 10, 0, 100));
        Assert.assertEquals(-10, ScalaMath.map(-1, 0, 10, 0, 100));
    }

    @Test
    public void testMapLongRange() {
        Assert.assertEquals(50L, ScalaMath.map(5L, 0L, 10L, 0L, 100L));
        Assert.assertEquals(120L, ScalaMath.map(12L, 0L, 10L, 0L, 100L));
        Assert.assertEquals(-10L, ScalaMath.map(-1L, 0L, 10L, 0L, 100L));
    }

    @Test
    public void testMapFloatRange() {
        Assert.assertEquals(0.5f, ScalaMath.map(5.0f, 0.0f, 10.0f, 0.0f, 1.0f), 1e-12);
        Assert.assertEquals(1.2f, ScalaMath.map(12.0f, 0.0f, 10.0f, 0.0f, 1.0f), 1e-12);
        Assert.assertEquals(-0.1f, ScalaMath.map(-1.0f, 0.0f, 10.0f, 0.0f, 1.0f), 1e-12);
    }

    @Test
    public void testMapDoubleRange() {
        Assert.assertEquals(0.5, ScalaMath.map(5.0, 0.0, 10.0, 0.0, 1.0), 1e-12);
        Assert.assertEquals(1.2, ScalaMath.map(12.0, 0.0, 10.0, 0.0, 1.0), 1e-12);
        Assert.assertEquals(-0.1, ScalaMath.map(-1.0, 0.0, 10.0, 0.0, 1.0), 1e-12);
    }

    @Test
    public void testSmoothstepFloat() {
        Assert.assertEquals(0.5f, ScalaMath.smoothstep(3.0f, 4.0f, 3.5f), 1e-12);
        Assert.assertEquals(0.0f, ScalaMath.smoothstep(3.0f, 4.0f, 2.0f), 1e-12);
        Assert.assertEquals(1.0f, ScalaMath.smoothstep(3.0f, 4.0f, 5.0f), 1e-12);
    }

    @Test
    public void testSmoothstepDouble() {
        Assert.assertEquals(0.5, ScalaMath.smoothstep(3.0, 4.0, 3.5), 1e-12);
        Assert.assertEquals(0.0, ScalaMath.smoothstep(3.0, 4.0, 2.0), 1e-12);
        Assert.assertEquals(1.0, ScalaMath.smoothstep(3.0, 4.0, 5.0), 1e-12);
    }

    @Test
    public void testFloatQuadraticBezierCurve() {
        float p0 = 2.0f, p1 = 5.0f, control = 4.0f, t = 0.35f;
        float l1 = ScalaMath.lerp(p0, control, t);
        float l2 = ScalaMath.lerp(control, p1, t);
        float res = ScalaMath.lerp(l1, l2, t);
        Assert.assertEquals(res, ScalaMath.bezierInterpolate(p0, p1, control, t), 1e-12f);
    }

    @Test
    public void testDoubleQuadraticBezierCurve() {
        double p0 = 2.0, p1 = 5.0, control = 4.0, t = 0.35;
        double l1 = ScalaMath.lerp(p0, control, t);
        double l2 = ScalaMath.lerp(control, p1, t);
        double res = ScalaMath.lerp(l1, l2, t);
        Assert.assertEquals(res, ScalaMath.bezierInterpolate(p0, p1, control, t), 1e-12);
    }

    @Test
    @Ignore
    public void testFloatQuadraticBezierDerivative() {
        // TODO
    }

    @Test
    @Ignore
    public void testDoubleQuadraticBezierDerivative() {
        // TODO
    }

    @Test
    public void testFloatCubicBezierCurve() {
        float p0 = 1.0f, p3 = 5.0f, p1 = 2.0f, p2 = 4.0f, t = 0.35f;
        float m1 = ScalaMath.lerp(p0, p1, t);
        float m2 = ScalaMath.lerp(p1, p2, t);
        float m3 = ScalaMath.lerp(p2, p3, t);
        float l1 = ScalaMath.lerp(m1, m2, t);
        float l2 = ScalaMath.lerp(m2, m3, t);
        float res = ScalaMath.lerp(l1, l2, t);
        Assert.assertEquals(res, ScalaMath.bezierInterpolate(p0, p3, p1, p2, t), 1e-12f);
    }

    @Test
    public void testDoubleCubicBezierCurve() {
        double p0 = 1.0, p3 = 5.0, p1 = 2.0, p2 = 4.0, t = 0.35;
        double m1 = ScalaMath.lerp(p0, p1, t);
        double m2 = ScalaMath.lerp(p1, p2, t);
        double m3 = ScalaMath.lerp(p2, p3, t);
        double l1 = ScalaMath.lerp(m1, m2, t);
        double l2 = ScalaMath.lerp(m2, m3, t);
        double res = ScalaMath.lerp(l1, l2, t);
        Assert.assertEquals(res, ScalaMath.bezierInterpolate(p0, p3, p1, p2, t), 1e-12);
    }

    @Test
    @Ignore
    public void testFloatCubicBezierDerivative() {
        // TODO
    }

    @Test
    @Ignore
    public void testDoubleCubicBezierDerivative() {
        // TODO
    }

    @Test
    public void testFloatEqualsApprox() {
        Assert.assertTrue(ScalaMath.equalsApprox(1.0f, 1.0f));
        Assert.assertTrue(ScalaMath.equalsApprox(1.0f, 0.9999999f));
        Assert.assertFalse(ScalaMath.equalsApprox(1.0f, 0.8999999f));
        Assert.assertTrue(ScalaMath.equalsApprox(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY));
        Assert.assertTrue(ScalaMath.equalsApprox(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY));
        Assert.assertFalse(ScalaMath.equalsApprox(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY));
        Assert.assertFalse(ScalaMath.equalsApprox(Float.NaN, Float.NaN));
    }

    @Test
    public void testDoubleEqualsApprox() {
        Assert.assertTrue(ScalaMath.equalsApprox(1.0, 1.0));
        Assert.assertTrue(ScalaMath.equalsApprox(1.0, 0.9999999));
        Assert.assertFalse(ScalaMath.equalsApprox(1.0, 0.8999999));
        Assert.assertTrue(ScalaMath.equalsApprox(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
        Assert.assertTrue(ScalaMath.equalsApprox(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY));
        Assert.assertFalse(ScalaMath.equalsApprox(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY));
        Assert.assertFalse(ScalaMath.equalsApprox(Double.NaN, Double.NaN));
    }
}
