package figures;

import enums.Color;
import table.Table;

public class Pawn extends Figure{

	static {
		STARTING_ROW = 1;
	}
	
	public Pawn() {
	}

	public Pawn(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
	}
	
	public Boolean can_move(int destination_x, int destination_y, Table table) {
		return can_move(destination_x, destination_y, table, null);
	}
	
	public Boolean can_move(int destination_x, int destination_y, Table table, King king) {
		if(destination_y == position_y && table.get_square_at_position(destination_x, destination_y).get_figure() == null) {
			if(destination_x - position_x == 1 && !king_left_open(destination_x, destination_y, table, king)) {
				return true;
			}
			
			if(position_x == STARTING_ROW && destination_x - position_x == 2 && 
				!king_left_open(destination_x, destination_y, table, king) &&
				table.get_square_at_position(destination_x - 1, destination_y).get_figure() == null) {
				return true;
			}
		}
		
		if(diagonally_move(destination_x, destination_y) &&	enemy_on_destination(destination_x, destination_y, table) && 
				!king_left_open(destination_x, destination_y, table, king)) {
			return true;
		}
		return false;
	}
	
	private Boolean enemy_on_destination(int destination_x, int destination_y, Table table) {
		try {
			return table.get_square_at_position(destination_x, destination_y).get_figure().get_color() != this.get_color();
		}catch(Exception e) {
			return false;
		}
	}
	
	private Boolean diagonally_move(int destination_x, int destination_y) {
		return destination_x - position_x == 1 && Math.abs(destination_y - position_y) == 1;
	}
	
	private static int STARTING_ROW;
}
