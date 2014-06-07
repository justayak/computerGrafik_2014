package aufgabe36;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Julian on 02.06.2014.
 */
public class Window extends JPanel {

    private static final int WIDTH =                400;
    private static final int HEIGHT =               400;
    private static final int HALF_WIDTH =           WIDTH / 2;
    private static final int HALF_HEIGHT =          HEIGHT / 2;

    /*public static int a =                           42;
    public static int b =                           8;
    public static int c =                           15;
    public static int d =                           23;
    public static int e =                           17;18
    public static int f =                           -4915;*/

    public static int a =                           8;
    public static int b =                           24;
    public static int c =                           18;
    public static int d =                           5;
    public static int e =                           7;
    public static int f =                           16;

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.RED);

        // Der eigentliche Code
        for(int x = -HALF_WIDTH;x < HALF_WIDTH; x++ ){
            for(int y = -HALF_HEIGHT;y < HALF_HEIGHT; y++){
                int v = a*x*x + b*x*y + c*y*y + d*x + e*y + f;
                if (v  <= 0){
                    g.fillRect(x+HALF_WIDTH,y+HALF_HEIGHT,1,1);
                }
            }
        }

    }

    // *************************************************************
    // Ab hier nur noch GUI-Krams. Also bitte ignorieren
    // *************************************************************

    public static int CurrentValue = 100;
    public static MenuItem showA;
    public static MenuItem showB;
    public static MenuItem showC;
    public static MenuItem showD;
    public static MenuItem showE;
    public static MenuItem showF;

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

        showA = new MenuItem();showA.setLabel("a: " + Window.a);set.add(showA);
        showB = new MenuItem();showB.setLabel("b: " + Window.b);set.add(showB);
        showC = new MenuItem();showC.setLabel("c: " + Window.c);set.add(showC);
        showD = new MenuItem();showD.setLabel("d: " + Window.d);set.add(showD);
        showE = new MenuItem();showE.setLabel("e: " + Window.e);set.add(showE);
        showF = new MenuItem();showF.setLabel("f: " + Window.f);set.add(showF);

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
            showA.setLabel("a: " + Window.a);
            showB.setLabel("b: " + Window.b);
            showC.setLabel("c: " + Window.c);
            showD.setLabel("d: " + Window.d);
            showE.setLabel("e: " + Window.e);
            showF.setLabel("f: " + Window.f);
        }
    }

}
