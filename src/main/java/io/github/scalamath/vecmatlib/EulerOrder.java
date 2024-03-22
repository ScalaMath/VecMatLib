package io.github.scalamath.vecmatlib;

/**
 * Enumeration used to specify a rotation order when converting rotations.
 *
 * @see Quatd#fromEuler(Vec3d, EulerOrder)
 * @see Quatd#euler(EulerOrder)
 */
public enum EulerOrder {
    /**
     * Specifies that the euler angles should be in the {@code XYZ} order.
     */
    XYZ {
        @Override
        public Vec3d toEulerAngles(Mat3d m) {
            return new Vec3d(Math.atan2(-m.m12(), m.m22()), Math.asin(m.m02()), Math.atan2(-m.m01(), m.m00()));
        }

        @Override
        public Quatd toQuaternion(double x, double y, double z) {
            return new Quatd(Math.cos(x / 2.0), Math.sin(x / 2.0), 0.0, 0.0)
                .multiply(Math.cos(y / 2.0), 0.0, Math.sin(y / 2.0), 0.0)
                .multiply(Math.cos(z / 2.0), 0.0, 0.0, Math.sin(z / 2.0));
        }
    },
    /**
     * Specifies that the euler angles should be in the {@code XZY} order.
     */
    XZY {
        @Override
        public Vec3d toEulerAngles(Mat3d m) {
            return new Vec3d(Math.atan2(m.m21(), m.m11()), Math.atan2(m.m02(), m.m00()), Math.asin(-m.m01()));
        }

        @Override
        public Quatd toQuaternion(double x, double y, double z) {
            return new Quatd(Math.cos(x / 2.0), Math.sin(x / 2.0), 0.0, 0.0)
                .multiply(Math.cos(z / 2.0), 0.0, 0.0, Math.sin(z / 2.0))
                .multiply(Math.cos(y / 2.0), 0.0, Math.sin(y / 2.0), 0.0);
        }
    },
    /**
     * Specifies that the euler angles should be in the {@code YXZ} order.
     */
    YXZ {
        @Override
        public Vec3d toEulerAngles(Mat3d m) {
            return new Vec3d(Math.asin(-m.m12()), Math.atan2(m.m02(), m.m22()), Math.atan2(m.m10(), m.m11()));
        }

        @Override
        public Quatd toQuaternion(double x, double y, double z) {
            return new Quatd(Math.cos(y / 2.0), 0.0, Math.sin(y / 2.0), 0.0)
                .multiply(Math.cos(x / 2.0), Math.sin(x / 2.0), 0.0, 0.0)
                .multiply(Math.cos(z / 2.0), 0.0, 0.0, Math.sin(z / 2.0));
        }
    },
    /**
     * Specifies that the euler angles should be in the {@code YZX} order.
     */
    YZX {
        @Override
        public Vec3d toEulerAngles(Mat3d m) {
            return new Vec3d(Math.atan2(-m.m12(), m.m11()), Math.atan2(-m.m20(), m.m00()), Math.asin(m.m10()));
        }

        @Override
        public Quatd toQuaternion(double x, double y, double z) {
            return new Quatd(Math.cos(y / 2.0), 0.0, Math.sin(y / 2.0), 0.0)
                .multiply(Math.cos(z / 2.0), 0.0, 0.0, Math.sin(z / 2.0))
                .multiply(Math.cos(x / 2.0), Math.sin(x / 2.0), 0.0, 0.0);
        }
    },
    /**
     * Specifies that the euler angles should be in the {@code XZY} order.
     */
    ZXY {
        @Override
        public Vec3d toEulerAngles(Mat3d m) {
            return new Vec3d(Math.asin(m.m21()), Math.atan2(-m.m20(), m.m22()), Math.atan2(-m.m01(), m.m11()));
        }

        @Override
        public Quatd toQuaternion(double x, double y, double z) {
            return new Quatd(Math.cos(z / 2.0), 0.0, 0.0, Math.sin(z / 2.0))
                .multiply(Math.cos(x / 2.0), Math.sin(x / 2.0), 0.0, 0.0)
                .multiply(Math.cos(y / 2.0), 0.0, Math.sin(y / 2.0), 0.0);
        }
    },
    /**
     * Specifies that the euler angles should be in the {@code ZYX} order.
     */
    ZYX {
        @Override
        public Vec3d toEulerAngles(Mat3d m) {
            return new Vec3d(Math.atan2(m.m21(), m.m22()), Math.asin(-m.m20()), Math.atan2(m.m10(), m.m00()));
        }

        @Override
        public Quatd toQuaternion(double x, double y, double z) {
            return new Quatd(Math.cos(z / 2.0), 0.0, 0.0, Math.sin(z / 2.0))
                .multiply(Math.cos(y / 2.0), 0.0, Math.sin(y / 2.0), 0.0)
                .multiply(Math.cos(x / 2.0), Math.sin(x / 2.0), 0.0, 0.0);
        }
    };

    /**
     * Converts the given rotation matrix to euler angles.
     * The given matrix must be a pure rotation matrix.
     *
     * @param m The rotation matrix.
     * @return A {@link Vec3d} representing the matrix's rotation in form of euler angles.
     */
    public abstract Vec3d toEulerAngles(Mat3d m);

    /**
     * Converts the given euler angles to a quaternion.
     *
     * @param x Angle on the x axis.
     * @param y Angle on the y axis.
     * @param z Angle on the z axis.
     * @return A quaternion constructed from the given euler angles.
     * @see Quatd#fromEuler(double, double, double, EulerOrder)
     */
    public abstract Quatd toQuaternion(double x, double y, double z);

    /**
     * Converts the given quaternion to euler angles.
     *
     * @param q The quaternion.
     * @return A {@link Vec3d} representing the quaternion's rotation in form of euler angles.
     * @see Quatd#euler(EulerOrder)
     */
    public Vec3d toEulerAngles(Quatd q) {
        return this.toEulerAngles(Mat3d.rotation(q));
    }

    /**
     * Converts the given rotation in euler angles to a quaternion.
     *
     * @param v A {@link Vec3d} representing the rotation in form of euler angles.
     * @return A quaternion constructed from the given euler angles.
     * @see Quatd#fromEuler(Vec3d, EulerOrder)
     */
    public Quatd toQuaternion(Vec3d v) {
        return this.toQuaternion(v.x(), v.y(), v.z());
    }
}
