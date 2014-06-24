package aufgabe48;

/**
 * Created by Julian on 24.06.2014.
 */
public class Pixel {
    public final int x;
    public final int y;
    public final boolean isVisible;
    public Pixel(int x, int y,boolean isVisible){
        this.x = x; this.y = y;this.isVisible = isVisible;
    }
    @Override
    public String toString(){
        return "{"+x+","+y+"}";
    }
}
