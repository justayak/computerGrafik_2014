package aufgabe48.math;

import java.util.IllegalFormatException;

/**
 * Created by Julian on 23.06.2014.
 */
public class Vec4 {
    public final double x;
    public final double y;
    public final double z;
    public final double w;
    public final boolean isPointAtInfinity;


    public Vec4(double x, double y, double z, double w, boolean homo){
        this.x = x; this.y = y; this.z = z; this.w = w; this.isPointAtInfinity = homo;
    }
    public Vec4(double x, double y, double z, double w){
        this(x,y,z,w,(w==0));
    }

    public Vec4 add(Vec4 v){
        double x = this.x + v.x;
        double y = this.y + v.y;
        double z = this.z + v.z;
        double w = this.w + v.w;
        if (w == 0) return new Vec4(x,y,z,w, true);
        return new Vec4((x/w),(y/w),(z/w),(w/w));
    }

    public Vec4 homogenize(){
        if (w == 0) throw new RuntimeException("nope, w=0");
        if (w == 1) return this;
        return new Vec4(x/w, y/w, z/w, z/z);
    }

    public Vec4 subtract(Vec4 v){
        /*double x = this.x - v.x;
        double y = this.y - v.y;
        double z = this.z - v.z;
        double w = this.w - v.w;
        if (w == 0) return new Vec4(x,y,z,w, true);
        return new Vec4((x/w),(y/w),(z/w),(w/w));*/
        Vec4 w = this.homogenize();
        v = v.homogenize();
        double x = w.x - v.x;
        double y = w.y - v.y;
        double z = w.z - v.z;
        return new Vec4(x,y,z,1);
    }

    public Vec4 multiply(double v){
        double x = v * this.x;
        double y = v * this.y;
        double z = v * this.z;
        double w = v * this.w;
        if (w == 0) return new Vec4(x,y,z,w, true);
        return new Vec4((x/w),(y/w),(z/w),(w/w));
    }

    public Vec4 multiply(Vec4 v){
        double x = v.x * this.x;
        double y = v.y * this.y;
        double z = v.z * this.z;
        double w = v.w * this.w;
        if (w == 0) return new Vec4(x,y,z,w, true);
        return new Vec4((x/w),(y/w),(z/w),(w/w));
    }

    public Vec4 cross(Vec4 v){
        if (w == 0 || v.w == 0) throw new IllegalArgumentException("geht nicht");
        Vec4 l = this;
        if (w != 1){
            l = new Vec4(x/w,y/w,z/w,w/w);
        }
        if (v.w != 1){
            v = new Vec4(v.x/v.w, v.y/v.w, v.z/v.w, v.w/v.w);
        }
        double x = l.y * v.z - l.z * v.y;
        double y = l.z * v.x - l.x * v.z;
        double z = l.x * v.y - l.y * v.x;
        return new Vec4(x,y,z,1);
    }

    public Vec4 divide(double w){
        return this.multiply((1/w));
    }

    public Vec4 divide(Vec4 v){
        double x = v.x / this.x;
        double y = v.y / this.y;
        double z = v.z / this.z;
        double w = v.w / this.w;
        if (w == 0) return new Vec4(x,y,z,w, true);
        return new Vec4((x/w),(y/w),(z/w),(w/w));
    }

    public double len() {return  Math.sqrt(this.sqLen());}
    public double sqLen(){return this.x * this.x + this.y * this.y + this.z * this.z;}

    public double dot(Vec4 v){
        return this.x * v.x + this.y * v.y + this.z * v.z + this.w * v.w;
    }

    public double angleRad(Vec4 v){
        double d = this.dot(v) / (this.len() * v.len());
        if (d < -1.0){
            d = -1.0;
        }else if (d > 1.0){
            d = 1.0;
        }
        return Math.acos(d);
    }

    public double angleDeg(Vec4 v){
        return Math.toDegrees(this.angleDeg(v));
    }

    public double distance(Vec4 v){
        if (this.w == 0 || v.w == 0) return Double.POSITIVE_INFINITY;
        if (v.w != 1) v = new Vec4(v.x/v.w, v.y/v.w, v.z/v.w, v.w/v.w);
        Vec4 u = this;
        if (u.w != 1) u = new Vec4(u.x/u.w,u.y/u.w,u.z/u.w, u.w/u.w);
        double x = v.x - u.x;
        double y = v.y - u.y;
        double z = v.z - u.z;
        return Math.sqrt(x*x + y*y + z*z);
    }

    public Vec4 negate(){
        return new Vec4(-x,-y,-z,w);
    }

    public Vec4 normalize(){
        double l = this.len();
        double x = this.x / l;
        double y = this.y / l;
        double z = this.z / l;
        return new Vec4(x,y,z,1);
    }

    @Override
    public String toString(){
        return "[" + x + "|" + y + "|" + z + "|" + w + "]";
    }
}
