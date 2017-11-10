package figures;

import enums.Color;

public abstract class Figure {

	public Figure() {
	}
	
	public Figure(Color color) {
		this.color = color;
	}
	
	public Figure(int position_x, int position_y) {
		this.position_x = position_x;
		this.position_y = position_y;
	}
	
	public Figure(Color color, int position_x, int position_y) {
		this.color = color;
		this.position_x = position_x;
		this.position_y = position_y;
	}
	
	public Color get_color() {
		return color;
	}
	
	public int get_position_x() {
		return position_x;
	}

	public void set_position_x(int position_x) {
		this.position_x = position_x;
	}

	public int get_position_y() {
		return position_y;
	}

	public void set_position_y(int position_y) {
		this.position_y = position_y;
	}
	
	protected int position_x;
	protected int position_y;
	protected Color color;
}
