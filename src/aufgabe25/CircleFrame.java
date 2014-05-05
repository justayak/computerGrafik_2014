package aufgabe25;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CircleFrame extends JFrame{
	
	public CircleFrame(){
		super("Kreise");
		BorderLayout layout = new BorderLayout(5, 5);
		setLayout(layout);
		GraphikPanel gPanel = new GraphikPanel(new ParamModel());
		
		add(gPanel, BorderLayout.CENTER);
		setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				new CircleFrame();
			}
			
		});
		
	}

}
