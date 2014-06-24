package aufgabe48;

import aufgabe48.math.Mat4;
import aufgabe48.math.Vec4;
import javafx.scene.chart.PieChart;

import java.awt.*;

/**
 * Created by Julian on 24.06.2014.
 */
public class Camera {

    public final Vec4 position;
    public final double apertureInDegree;
    public final double zNear, zFar;
    public final Vec4 u;
    public final Vec4 n;
    public final Vec4 v;
    public final Mat4 worldToEye, eyeCoordsToNDC;
    public final double width,height;
    private final double[][] zBuffer;

    public Camera(Vec4 pos, double apertureInDegree, Vec4 lookat, double zNear, double zFar, double W, double H) {
        this.width = W; this.height = H;
        this.zBuffer = new double[(int)W][(int)H];
        for(int x = 0; x < (int)W;x++){
            for(int y = 0; y< (int)H;y++){
                zBuffer[x][y] = Double.POSITIVE_INFINITY;
            }
        }
        this.position = pos;
        this.zNear = zNear;
        this.zFar = zFar;
        this.apertureInDegree = apertureInDegree;
        this.n = (pos.subtract(lookat)).normalize();
        this.u = n.negate().cross(new Vec4(0, 0, 1, 1)).normalize();
        this.v = this.u.cross(n.negate()).normalize();

        Mat4 basisWechsel = new Mat4(
                this.u.x, this.u.y, this.u.z, 0,
                this.v.x, this.v.y, this.v.z, 0,
                this.n.x, this.n.y, this.n.z, 0,
                0, 0, 0, 1
        );

        Mat4 translate = Mat4.translation(-pos.x, -pos.y, -pos.z);
        this.worldToEye = translate.multiply(basisWechsel);

        // Left und Right berechnen
        double radians = (apertureInDegree/2) * Math.PI/180;
        double r = Math.tan(radians)*zNear;
        double l = -r;
        double width = r-l;
        double height = width * H / W;
        double t = height / 2;
        double b = -t;

        this.eyeCoordsToNDC = new Mat4(
                (2*zNear)/(r-l), 0, (r+l)/(r-l),0,
                0, (2*zNear)/(t-b), (t+b)/(t-b),0,
                0,0,(-zFar+zNear)/(zFar-zNear),(-2*zFar*zNear)/(zFar-zNear),
                0,0,-1,0
        );
    }

    public Vec4 toNDC(Vec4 v){
        Vec4 eye = this.worldToEye.multiply(v);
        Vec4 ndc = this.eyeCoordsToNDC.multiply(eye);
        System.out.println("world:" + v + ", eye:" + eye + ", ndc:" + ndc);
        return ndc;
    }

    public Pixel getPixel(Vec4 vectorNdc){
        Vec4 hom = vectorNdc.homogenize();
        int x = (int) Math.floor((hom.x+1)*this.width/2);
        int y = (int) Math.floor((hom.y+1)*this.height/2);
        //test zbuffer
        if (x>this.width || y>this.height) return new Pixel(-1,-1,false);
        if (x<0 || y<0) return new Pixel(-1,-1,false);
        if (this.zBuffer[x][y] < vectorNdc.z){
            return new Pixel(x,y,false);
        }else{
            this.zBuffer[x][y] = vectorNdc.z; // nicht wirklich ein zBuffer sondern ein wBuffer
            return new Pixel(x,y,true);
        }
    }

}
