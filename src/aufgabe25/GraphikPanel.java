package aufgabe25;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GraphikPanel extends JPanel {
	private ParamModel pm;
	
	public GraphikPanel(ParamModel pm){
		this.pm = pm;
		setPreferredSize(new Dimension(1920, 1080));
	}
	
	public void paint(Graphics g){
		BufferedImage image = new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_RGB);
		ColorScheme cs = pm.getColorScheme();
		int rSquare = pm.getRSquare();
		
		for(int x = 0; x < image.getWidth(); x++){
			for(int y = 0; y < image.getHeight(); y++){
				int value = ((x*x) + (y*y)) % rSquare;
				float c = (float) value / (float) rSquare;
				int rgb = cs.calculateColor(c);
				image.setRGB(x, y, rgb);
			}
		}
		g.drawImage(image, 0, 0, null);
		
	}
	
	

}
