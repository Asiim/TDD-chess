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
		if(ally_on_destination(destination_x, destination_y, table)) {
			return false;
		}
		if((Math.abs(destination_x - position_x) == 1 || Math.abs(destination_y - position_y) == 1) && 
				(Math.abs(destination_x - position_x) + Math.abs(destination_y - position_y) <= 2)) {
			return true;
		}
		return false;
	}
}
