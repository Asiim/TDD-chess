package figures;

import enums.Color;
import table.Table;

public abstract class Figure {

	public Figure() {
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
	
	protected Boolean ally_on_destination(int destination_x, int destination_y, Table table) {
		try {
			return table.get_square_at_position(destination_x, destination_y).get_figure().get_color() == this.get_color();
		}catch(Exception e) {
			return false;
		}
	}

	public void move(int destination_x, int destination_y) {
		position_x = destination_x;
		position_y = destination_y;
	}
	
	public abstract Boolean can_move(int destination_x, int destination_y, Table table);
	
	protected int position_x;
	protected int position_y;
	protected Color color;
}
