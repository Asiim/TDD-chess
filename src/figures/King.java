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
		
		if(destination_x == position_x && this.is_first_move() && !table.square_occupied(position_x, position_y, color) 
				&& !table.square_occupied(destination_x, destination_y, color)) {
			if(table.get_square_at_position(0, 7).get_figure() instanceof Rook && table.get_square_at_position(0, 7).get_figure().is_first_move()
					 && destination_y - position_y == 2) {
				for(int i = 1; i < table.get_length() - position_y - 1; i++) {
					if(table.get_square_at_position(0, position_y + i).get_figure() != null) {
						return false;
					}
				}
				return true;
			}
			if(table.get_square_at_position(0, 0).get_figure() instanceof Rook && table.get_square_at_position(0, 0).get_figure().is_first_move()
					&& destination_y - position_y == -2) {
				for(int i = 1; i < position_y; i++) {
					if(table.get_square_at_position(0, position_y - i).get_figure() != null) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
}
