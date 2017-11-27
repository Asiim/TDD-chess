package figures;

import enums.Color;
import table.Table;

public class Rook extends Figure{

	public Rook() {
	}
	
	public Rook(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
	}
	
	public Boolean can_move(int destination_x, int destination_y, Table table) {
		return can_move(destination_x, destination_y, table, null);
	}
	
	public Boolean can_move(int destination_x, int destination_y, Table table, King king) {
		int x_sign = Integer.signum(destination_x - position_x);
		int y_sign = Integer.signum(destination_y - position_y);
		
		if(ally_on_destination(destination_x, destination_y, table)) {
			return false;
		}
		
		if(destination_x != position_x && destination_y == position_y && !king_left_open(destination_x, destination_y, table, king)) {
			for (int i = 1; i < Math.abs(destination_x - position_x); i++) {
				if(table.has_figure(position_x + i * x_sign, position_y)) {
					return false;
				}
			}
			return true;
		}
		
		if(destination_y != position_y && destination_x == position_x && !king_left_open(destination_x, destination_y, table, king)) {
			for (int i = 1; i < Math.abs(destination_y - position_y); i++) {
				if(table.has_figure(position_x, position_y + i * y_sign)) {
					return false;
				}
			}
			return true;
		}		
		return false;
	}

}
