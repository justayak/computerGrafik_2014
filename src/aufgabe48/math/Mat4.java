package aufgabe48.math;

/**
 * Created by Julian on 23.06.2014.
 */
public class Mat4 {
    public final double m00, m01, m02, m03;
    public final double m10, m11, m12, m13;
    public final double m20, m21, m22, m23;
    public final double m30, m31, m32, m33;

    public Mat4(double m00, double m01, double m02, double m03,
                double m10, double m11, double m12, double m13,
                double m20, double m21, double m22, double m23,
                double m30, double m31, double m32, double m33) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m03 = m03;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m30 = m30;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
    }

    public static Mat4 rotationX(double deg) {
        double cos = Math.cos(deg);
        double sin = Math.sin(deg);
        return new Mat4(
                1, 0, 0, 0,
                0, cos, -sin, 0,
                0, sin, cos, 0,
                0, 0, 0, 1
        );
    }

    public static Mat4 rotationY(double deg) {
        double cos = Math.cos(deg);
        double sin = Math.sin(deg);
        return new Mat4(
                cos, 0, sin, 0,
                0, 1, 0, 0,
                -sin, 0, cos, 0,
                0, 0, 0, 1
        );
    }

    public static Mat4 rotationZ(double deg) {
        double cos = Math.cos(deg);
        double sin = Math.sin(deg);
        return new Mat4(
                cos, -sin, 0, 0,
                sin, cos, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
    }

    public static Mat4 translation(double x, double y, double z) {
        return new Mat4(
                1, 0, 0, x,
                0, 1, 0, y,
                0, 0, 1, z,
                0, 0, 0, 1
        );
    }

    public static Mat4 identity() {
        return new Mat4(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
    }

    public static Mat4 zero() {
        return new Mat4(
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0);
    }


    public Mat4 transpose() {
        double /*  no need  */ m01 = this.m10, m02 = this.m20, m03 = this.m30;
        double m10 = this.m01, /*  no need  */ m12 = this.m21, m13 = this.m31;
        double m20 = this.m02, m21 = this.m12, /*  no need  */ m23 = this.m32;
        double m30 = this.m03, m31 = this.m13, m32 = this.m23  /*  no need */;

        return new Mat4(
                this.m00, m01, m02, m03,
                m10, this.m11, m12, m13,
                m20, m21, this.m22, m23,
                m30, m31, m32, this.m33
        );
    }

    public Vec4 multiply(Vec4 v) {
        double x = m00 * v.x + m01 * v.y + m02 * v.z + m03 * v.w;
        double y = m10 * v.x + m11 * v.y + m12 * v.z + m13 * v.w;
        double z = m20 * v.x + m21 * v.y + m22 * v.z + m23 * v.w;
        double w = m30 * v.x + m31 * v.y + m32 * v.z + m33 * v.w;
        if (w == 0) {
            return new Vec4(x, y, z, w, true);
        }
        return new Vec4((x / w), (y / w), (z / w), (w / w));
    }

    public Mat4 multiply(Mat4 r) {
        Mat4 l = this;
        double m00 = l.m00 * r.m00 + l.m10 * r.m01 + l.m20 * r.m02 + l.m30 * r.m03;
        double m01 = l.m01 * r.m00 + l.m11 * r.m01 + l.m21 * r.m02 + l.m31 * r.m03;
        double m02 = l.m02 * r.m00 + l.m12 * r.m01 + l.m22 * r.m02 + l.m32 * r.m03;
        double m03 = l.m03 * r.m00 + l.m13 * r.m01 + l.m23 * r.m02 + l.m33 * r.m03;
        double m10 = l.m00 * r.m10 + l.m10 * r.m11 + l.m20 * r.m12 + l.m30 * r.m13;
        double m11 = l.m01 * r.m10 + l.m11 * r.m11 + l.m21 * r.m12 + l.m31 * r.m13;
        double m12 = l.m02 * r.m10 + l.m12 * r.m11 + l.m22 * r.m12 + l.m32 * r.m13;
        double m13 = l.m03 * r.m10 + l.m13 * r.m11 + l.m23 * r.m12 + l.m33 * r.m13;
        double m20 = l.m00 * r.m20 + l.m10 * r.m21 + l.m20 * r.m22 + l.m30 * r.m23;
        double m21 = l.m01 * r.m20 + l.m11 * r.m21 + l.m21 * r.m22 + l.m31 * r.m23;
        double m22 = l.m02 * r.m20 + l.m12 * r.m21 + l.m22 * r.m22 + l.m32 * r.m23;
        double m23 = l.m03 * r.m20 + l.m13 * r.m21 + l.m23 * r.m22 + l.m33 * r.m23;
        double m30 = l.m00 * r.m30 + l.m10 * r.m31 + l.m20 * r.m32 + l.m30 * r.m33;
        double m31 = l.m01 * r.m30 + l.m11 * r.m31 + l.m21 * r.m32 + l.m31 * r.m33;
        double m32 = l.m02 * r.m30 + l.m12 * r.m31 + l.m22 * r.m32 + l.m32 * r.m33;
        double m33 = l.m03 * r.m30 + l.m13 * r.m31 + l.m23 * r.m32 + l.m33 * r.m33;
        return new Mat4(
                m00, m01, m02, m03,
                m10, m11, m12, m13,
                m20, m21, m22, m23,
                m30, m31, m32, m33
        );
    }

    public Mat4 inv() {

        double determ = this.determinant();
        if (determ == 0) {
            throw new IllegalStateException("Error: determinant == 0");
        }
        double invDeterm = 1f / determ;
        Mat4 src = this;
        double t00 = determ3x3(src.m11, src.m12, src.m13, src.m21, src.m22, src.m23, src.m31, src.m32, src.m33) * invDeterm;
        double t01 = -determ3x3(src.m10, src.m12, src.m13, src.m20, src.m22, src.m23, src.m30, src.m32, src.m33) * invDeterm;
        double t02 = determ3x3(src.m10, src.m11, src.m13, src.m20, src.m21, src.m23, src.m30, src.m31, src.m33) * invDeterm;
        double t03 = -determ3x3(src.m10, src.m11, src.m12, src.m20, src.m21, src.m22, src.m30, src.m31, src.m32) * invDeterm;
        // second row
        double t10 = -determ3x3(src.m01, src.m02, src.m03, src.m21, src.m22, src.m23, src.m31, src.m32, src.m33) * invDeterm;
        double t11 = determ3x3(src.m00, src.m02, src.m03, src.m20, src.m22, src.m23, src.m30, src.m32, src.m33) * invDeterm;
        double t12 = -determ3x3(src.m00, src.m01, src.m03, src.m20, src.m21, src.m23, src.m30, src.m31, src.m33) * invDeterm;
        double t13 = determ3x3(src.m00, src.m01, src.m02, src.m20, src.m21, src.m22, src.m30, src.m31, src.m32) * invDeterm;
        // third row
        double t20 = determ3x3(src.m01, src.m02, src.m03, src.m11, src.m12, src.m13, src.m31, src.m32, src.m33) * invDeterm;
        double t21 = -determ3x3(src.m00, src.m02, src.m03, src.m10, src.m12, src.m13, src.m30, src.m32, src.m33) * invDeterm;
        double t22 = determ3x3(src.m00, src.m01, src.m03, src.m10, src.m11, src.m13, src.m30, src.m31, src.m33) * invDeterm;
        double t23 = -determ3x3(src.m00, src.m01, src.m02, src.m10, src.m11, src.m12, src.m30, src.m31, src.m32) * invDeterm;
        // fourth row
        double t30 = -determ3x3(src.m01, src.m02, src.m03, src.m11, src.m12, src.m13, src.m21, src.m22, src.m23) * invDeterm;
        double t31 = determ3x3(src.m00, src.m02, src.m03, src.m10, src.m12, src.m13, src.m20, src.m22, src.m23) * invDeterm;
        double t32 = -determ3x3(src.m00, src.m01, src.m03, src.m10, src.m11, src.m13, src.m20, src.m21, src.m23) * invDeterm;
        double t33 = determ3x3(src.m00, src.m01, src.m02, src.m10, src.m11, src.m12, src.m20, src.m21, src.m22) * invDeterm;

        return new Mat4(
                t00, t01, t02, t03,
                t10, t11, t12, t13,
                t20, t21, t22, t23,
                t30, t31, t32, t33
        );
    }

    public Mat4 negate() {
        return new Mat4(
                -m00, -m01, -m02, -m03,
                -m10, -m11, -m12, -m13,
                -m20, -m21, -m22, -m23,
                -m30, -m31, -m32, -m33
        );
    }

    public double determinant() {
        return m00
                * ((m11 * m22 * m33 + m12 * m23 * m31 + m13 * m21 * m32)
                - m13 * m22 * m31
                - m11 * m23 * m32
                - m12 * m21 * m33) - m01
                * ((m10 * m22 * m33 + m12 * m23 * m30 + m13 * m20 * m32)
                - m13 * m22 * m30
                - m10 * m23 * m32
                - m12 * m20 * m33) + m02
                * ((m10 * m21 * m33 + m11 * m23 * m30 + m13 * m20 * m31)
                - m13 * m21 * m30
                - m10 * m23 * m31
                - m11 * m20 * m33) - m03
                * ((m10 * m21 * m32 + m11 * m22 * m30 + m12 * m20 * m31)
                - m12 * m21 * m30
                - m10 * m22 * m31
                - m11 * m20 * m32);
    }

    private static double determ3x3(double t00, double t01, double t02,
                                    double t10, double t11, double t12,
                                    double t20, double t21, double t22) {
        return t00 * (t11 * t22 - t12 * t21)
                + t01 * (t12 * t20 - t10 * t22)
                + t02 * (t10 * t21 - t11 * t20);
    }

}
