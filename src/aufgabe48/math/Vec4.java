package aufgabe48.math;

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

    public Vec4 subtract(Vec4 v){
        double x = this.x - v.x;
        double y = this.y - v.y;
        double z = this.z - v.z;
        double w = this.w - v.w;
        if (w == 0) return new Vec4(x,y,z,w, true);
        return new Vec4((x/w),(y/w),(z/w),(w/w));
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

    public Vec4 divide(Vec4 v){
        double x = v.x / this.x;
        double y = v.y / this.y;
        double z = v.z / this.z;
        double w = v.w / this.w;
        if (w == 0) return new Vec4(x,y,z,w, true);
        return new Vec4((x/w),(y/w),(z/w),(w/w));
    }

    public double len() {return  Math.sqrt(this.sqLen());}
    public double sqLen(){return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;}

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

    @Override
    public String toString(){
        return "[" + x + "|" + y + "|" + z + "|" + w + "]";
    }
}
