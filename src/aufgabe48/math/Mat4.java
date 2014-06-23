package aufgabe48.math;

/**
 * Created by Julian on 23.06.2014.
 */
public class Mat4 {
    public final double m00, m01, m02, m03;
    public final double m10, m11, m12, m13;
    public final double m20, m21, m22, m23;
    public final double m30, m31, m32, m33;

    public Mat4(double m00,double m01,double m02,double m03,
                double m10,double m11,double m12,double m13,
                double m20,double m21,double m22,double m23,
                double m30,double m31,double m32,double m33){
        this.m00 = m00; this.m01 = m01; this.m02 = m02; this.m03 = m03;
        this.m10 = m10; this.m11 = m11; this.m12 = m12; this.m13 = m13;
        this.m20 = m20; this.m21 = m21; this.m22 = m22; this.m23 = m23;
        this.m30 = m30; this.m31 = m31; this.m32 = m32; this.m33 = m33;
    }

    public static Mat4 identity(){
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

}
