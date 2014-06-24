package aufgabe48;

import aufgabe48.math.Mat4;
import aufgabe48.math.Vec4;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Julian on 22.06.2014.
 */
public class Window extends JPanel {

    static final int WIDTH = 600;
    static final int HEIGHT = 400;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);

        // --- paint start

        Scene s = new Scene(WIDTH,HEIGHT);
        s.render(g);


        // --- paint end


    }

    private static void createAndShowGUI(){
        JFrame frame = new JFrame("Aufgabe 48");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.getContentPane().add(new Window());
        frame.setVisible(true);
    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
