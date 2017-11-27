package figures;

import enums.Color;
import table.Table;

public class King extends Figure {

	public King() {
	}
	
	public King(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
	}	
	
	public Boolean can_move(int destination_x, int destination_y, Table table) {
		return can_move(destination_x, destination_y, table, this);
	}
	
	public Boolean can_move(int destination_x, int destination_y, Table table, King king) {
		if(ally_on_destination(destination_x, destination_y, table)) {
			return false;
		}
		if((Math.abs(destination_x - position_x) == 1 || Math.abs(destination_y - position_y) == 1) && 
				(Math.abs(destination_x - position_x) + Math.abs(destination_y - position_y) <= 2)) {
			table.get_square_at_position(position_x, position_y).set_figure(null);
			if(table.square_occupied(destination_x, destination_y, color)) {
				table.get_square_at_position(position_x, position_y).set_figure(this);
				return false;
			}
			table.get_square_at_position(position_x, position_y).set_figure(this);
			return true;
		}
		return false;
	}
}
