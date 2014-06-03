package aufgabe36;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Julian on 02.06.2014.
 */
public class Window extends JPanel {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int HALF_WIDTH = WIDTH / 2;
    private static final int HALF_HEIGHT = HEIGHT / 2;

    public static int a = 42;
    public static int b =8;
    public static int c = 15;
    public static int d = 23;
    public static int e = 17;
    public static int f = -4915;

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.RED);

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

    public static int CurrentValue = 1;


    // *******************************************

    public static void main(String[] args){
        JFrame frame = new JFrame("Elipse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        Window panel = new Window();
        frame.getContentPane().add(panel);

        MenuBar bar = new MenuBar();
        Menu up = new Menu("+");
        up.add("a");
        up.add("b");
        up.add("c");
        up.add("d");
        up.add("e");
        up.add("f");

        Menu down = new Menu("-");
        down.add("a");
        down.add("b");
        down.add("c");
        down.add("d");
        down.add("e");
        down.add("f");

        Menu set = new Menu("Value");

        final MenuItem value = new MenuItem();
        value.setLabel(""+CurrentValue);

        set.add("Add 1");
        set.add("Sub 1");
        set.add(value);

        set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Add 1")){
                        CurrentValue += 1;
                }else if (e.getActionCommand().equals("Sub 1")) {
                      CurrentValue -= 1;
                }
                value.setLabel(""+CurrentValue);
            }
        });

        ParamsActionListener adder = new ParamsActionListener(true,panel);
        ParamsActionListener subber = new ParamsActionListener(false,panel);

        up.addActionListener(adder);
        down.addActionListener(subber);

        bar.add(up);
        bar.add(down);
        bar.add(set);
        frame.setMenuBar(bar);

        frame.setVisible(true);
    }

    // *******************************************

    private static class ParamsActionListener implements ActionListener{

        private final boolean isAdd;
        private final Window instance;

        public ParamsActionListener(boolean isAdd, Window instance){
            this.isAdd = isAdd;
            this.instance = instance;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int value = Window.CurrentValue;
            if (e.getActionCommand().equals("a")) Window.a = this.isAdd ? Window.a + value: Window.a - value;
            else if (e.getActionCommand().equals("b")) Window.b = this.isAdd ? Window.b + value: Window.b - value;
            else if (e.getActionCommand().equals("c")) Window.c = this.isAdd ? Window.c + value: Window.c - value;
            else if (e.getActionCommand().equals("d")) Window.d = this.isAdd ? Window.d + value: Window.d - value;
            else if (e.getActionCommand().equals("e")) Window.e = this.isAdd ? Window.e + value: Window.e - value;
            else if (e.getActionCommand().equals("f")) Window.f = this.isAdd ? Window.f + value: Window.f - value;
            this.instance.repaint();
        }
    }

}
