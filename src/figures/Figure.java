package figures;

import com.sun.prism.paint.Color;

public class Figure {

	public Figure() {
		
	}
	
	public Figure(Color color) {
		this.color = color;
	}
	
	protected Color get_color() {
		return color;
	}
	
	private Color color;
}
