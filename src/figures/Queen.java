package figures;

import enums.Color;
import table.Table;

public class Queen extends Figure {

	public Queen() {
	}
	
	public Queen(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
	}
	
	public Boolean can_move(int destination_x, int destination_y, Table table) {
//		if(destination_x != position_x && destination_y != position_y) {
//			return false;
//		}
		if(destination_x > position_x) {
			for (int current_x = position_x + 1; current_x < destination_x; current_x++) {
				if(table.get_square_at_position(current_x, position_y).get_figure() != null) {
					return false;
				}
			}
		}
		else if (destination_x < position_x) {
			for (int current_x = position_x - 1; current_x > destination_x; current_x--) {
				if(table.get_square_at_position(current_x, position_y).get_figure() != null) {
					return false;
				}
			}
		}
		if(destination_y > position_y) {
			for (int current_y = position_y + 1; current_y < destination_y; current_y++) {
				if(table.get_square_at_position(position_x, current_y).get_figure() != null) {
					return false;
				}
			}
		}
		else if(destination_y < position_y) {
			for (int current_y = position_y - 1; current_y > destination_y; current_y--) {
				if(table.get_square_at_position(position_x, current_y).get_figure() != null) {
					return false;
				}
			}
		}
		try {
			if(table.get_square_at_position(destination_x, destination_y).get_figure().get_color() == this.get_color()) {
				return false;
			}
		}
		catch(Exception e){
			return true;
		}
		return true;
	}
}
