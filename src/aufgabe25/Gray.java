package aufgabe25;

import java.awt.Color;

public class Gray implements ColorScheme {

	public int calculateColor(float x) {
		try{
		Color c = new Color( x, x,x);
		return c.getRGB();
		} catch(IllegalArgumentException ex){
			System.out.println("IllegalArgumentException: x=" + x);
			return 0xFFFFFF;
		}
	}

	public String getDescription() {
		
		return "Black And White";
	}

}
