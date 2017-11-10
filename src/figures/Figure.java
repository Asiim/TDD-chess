package figures;

import enums.Color;

public abstract class Figure {

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
