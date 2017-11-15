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
		return false;
	}
}
