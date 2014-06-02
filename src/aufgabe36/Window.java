package aufgabe36;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Julian on 02.06.2014.
 */
public class Window extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int HALF_WIDTH = WIDTH / 2;
    private static final int HALF_HEIGHT = HEIGHT / 2;

    double a = -1;
    double b = 0.1;
    double c = 1;
    double d = -0.75;
    double e = 0.13;
    double f = 0.5;

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.DARK_GRAY);

        for(int x = -HALF_WIDTH;x < HALF_WIDTH; x++ ){
            for(int y = -HALF_HEIGHT;y < HALF_HEIGHT; y++){
                double v = a*x*x + b*x*y + c*y*y + d*x + e*y + f;
                if (v >= 0){
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
