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
		if(Math.abs(destination_y - position_y) == 1 && position_x == destination_x) {
			return true;
		}
		if(Math.abs(destination_x - position_x) == 1 && position_y == destination_y) {
			return true;
		}
		if(Math.abs(destination_x - position_x) == 1 && Math.abs(destination_y - position_y) == 1) {
			return true;
		}
		return false;
	}
}
