package figures;

import enums.Color;
import table.Table;

public class Pawn extends Figure{

	public Pawn() {
	}

	public Pawn(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
	}
	
	public Boolean can_move(int destination_x, int destination_y, Table table) {		
		if(destination_x - position_x == 1) {
			if(table.get_square_at_position(destination_x, destination_y).get_figure() == null) {
				return true;
			}
		}
		if(position_x == 1 && destination_x - position_x == 2) {
			return true;
		}
		return false;
	}
}
