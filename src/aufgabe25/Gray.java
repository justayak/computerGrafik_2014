package aufgabe25;

import java.awt.Color;

public class Gray implements ColorScheme {

	public Color calculateColor(double x) {
		return new Color( Math.round(x*255), Math.round(x*255), Math.round(x*255));
	}

	public String getDescription() {
		
		return "Black And White";
	}

}
