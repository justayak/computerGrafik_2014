package aufgabe36;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Julian on 02.06.2014.
 */
public class Window extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);



    }


    // *******************************************

    public static void main(String[] args){
        JFrame frame = new JFrame("Elipse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        JPanel panel = new Window();
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    // *******************************************
}
