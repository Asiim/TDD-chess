package figures;

import java.io.Serializable;

import enums.Color;
import table.Table;

public abstract class Figure implements Serializable{

	public Figure() {
		firstMove = true;
	}
	
	public Figure(Color color, int position_x, int position_y) {
		this.color = color;
		this.position_x = position_x;
		this.position_y = position_y;
		firstMove = true;
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

	public void move(int destination_x, int destination_y, Table table) {
		table.get_square_at_position(position_x, position_y).set_figure(null);
		position_x = destination_x;
		position_y = destination_y;
		firstMove = false;
		table.get_square_at_position(position_x, position_y).set_figure(this);
	}
	
	public abstract Boolean can_move(int destination_x, int destination_y, Table table, King king);
	
	protected Boolean ally_on_destination(int destination_x, int destination_y, Table table) {
		try {
			return table.get_square_at_position(destination_x, destination_y).get_figure().get_color() == this.get_color();
		}catch(Exception e) {
			return false;
		}
	}
	
	protected Boolean king_left_open(int destination_x, int destination_y, Table table, King king) {
		Figure tmp = null;
		try {
			table.get_square_at_position(position_x, position_y).set_figure(null);
			if(table.get_square_at_position(destination_x, destination_y).get_figure() != null) {
				tmp = table.get_square_at_position(destination_x, destination_y).get_figure();
			}
			table.get_square_at_position(destination_x, destination_y).set_figure(this);
			if(table.square_occupied(king.get_position_x(), king.get_position_y(), color)) {
				table.get_square_at_position(position_x, position_y).set_figure(this);
				table.get_square_at_position(destination_x, destination_y).set_figure(tmp);
				return true;
			}
		}
		catch(Exception e) {
		}
		table.get_square_at_position(destination_x, destination_y).set_figure(tmp);
		table.get_square_at_position(position_x, position_y).set_figure(this);
		return false;
	}
	
	public Boolean is_first_move() {
		return firstMove;
	}
	
	protected Boolean firstMove;
	protected int position_x;
	protected int position_y;
	protected Color color;
}
