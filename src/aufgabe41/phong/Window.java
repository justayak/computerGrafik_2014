package aufgabe41.phong;

import aufgabe41.Vector3;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Julian on 10.06.2014.
 */
public class Window extends JPanel {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    public void paintComponent(Graphics g){


    }


    public static void main(String[] args){

        JFrame frame = new JFrame("phong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Window.WIDTH, Window.HEIGHT);
        Window panel = new Window();
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

}
