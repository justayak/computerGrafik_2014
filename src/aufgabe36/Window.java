package aufgabe36;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Julian on 02.06.2014.
 */
public class Window extends JPanel {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final int HALF_WIDTH = WIDTH / 2;
    private static final int HALF_HEIGHT = HEIGHT / 2;

    int a =     42;
    int b =     8;
    int c =     15;
    int d =     23;
    int e =     17;
    int f =     -4915;

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.DARK_GRAY);

        double aQ = 250;
        double bQ = 200;
        double xM = -20;
        double yM = -20;

        for(int x = -HALF_WIDTH;x < HALF_WIDTH; x++ ){
            for(int y = -HALF_HEIGHT;y < HALF_HEIGHT; y++){

                int v = a*x*x + b*x*y + c*y*y + d*x + e*y + f;
                //double v = Math.ceil((Math.pow(x-xM,2) / (a*a)) + (Math.pow(y-yM,2)/(b*b)));

                //double v = (a*Math.pow(x,2)) + (b*x*y) + (c*Math.pow(y,2)) + (d*x) + (e*y) + f;

                // http://www.alpertron.com.ar/METHODS.HTM
                // http://en.wikipedia.org/wiki/Diophantine_equation

                if (v  <= 0){
                    g.fillRect(x+HALF_WIDTH,y+HALF_HEIGHT,1,1);
                }
            }
        }

    }


    // *******************************************

    public static void main(String[] args){
        JFrame frame = new JFrame("Elipse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        JPanel panel = new Window();
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    // *******************************************
}
