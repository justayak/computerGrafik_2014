package aufgabe48;

import aufgabe48.math.Vec4;

import java.text.DecimalFormat;

/**
 * Created by Julian on 25.06.2014.
 */
public class Face {
    public final Vec4 TL,TR,BL,BR; // IN NDC!
    public final Vec4 center;
    public boolean isVisible = false;
    public Face(Vec4 tl, Vec4 tr, Vec4 bl, Vec4 br){
        this.TL = tl; this.TR = tr; this.BL = bl; this.BR = br;
        this.center = tl.add3(br.subtract(tl).multiply3(0.5));
    }

    @Override
    public String toString(){
        DecimalFormat f = new DecimalFormat("#0.000");
        return "[" + (TL) + "|" + (TR) + "|" + (BL) + "|" + (BR) + "] :: " + center;
    }
}
