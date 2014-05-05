package aufgabe25;

import java.awt.Color;

public class Colorful1 implements ColorScheme{

	public int calculateColor(float x) {
		
		if(x < 0.25){
			double xr = x*4;
			return new Color((int)Math.round(xr*255), 0, 0).getRGB();
		} else if (x >= 0.25 && x < 0.5) {
			double xg = (x-0.25) * 4;
			return new Color(255, (int)Math.round(xg*255), 0).getRGB();
		} else if (x >= 0.5 && x < 0.75 ){
			double xb = (x - 0.5) * 4;
			double xr = 1 - ( (x - 0.5) * 4 );
			return new Color((int) Math.round(xr * 255), 255, (int) Math.round(xb * 255)).getRGB();
		} else {
			double xg = (x - 0.75) * 4;
			return new Color(255, 255, (int)Math.round(xg * 255)).getRGB();
		}
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return "many Colors";
	}

}
