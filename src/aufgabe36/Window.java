package aufgabe36;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Julian on 02.06.2014.
 */
public class Window extends JPanel {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    double a = 0.1;
    double b = -0.4;
    double c = 0.2;
    double d = 0.54;
    double e = 0.11;
    double f = 0.09;

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.DARK_GRAY);

        for(int x = 0;x < WIDTH; x++ ){
            for(int y = 0;y < HEIGHT; y++){
                double v = a*x*x + b*x*y + c*y*y + d*x + e*y + f;
                if (v <= 0){
                    g.fillRect(x,y,1,1);
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
