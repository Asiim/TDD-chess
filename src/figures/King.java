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
		if(Math.abs(destination_x - position_x) == 1 || Math.abs(destination_y - position_y) == 1) {
			for(int i = 1; i < table.get_width() - destination_x; i++) {
				if(table.get_square_at_position(destination_x + i, destination_y).get_figure() instanceof Rook &&
						table.get_square_at_position(destination_x + i,  destination_y).get_figure().get_color() != color) {
					return false; 
				}
			}
			for(int i = 1; i < table.get_length() - destination_y; i++) {
				if(table.get_square_at_position(destination_x, destination_y + i).get_figure() instanceof Rook &&
						table.get_square_at_position(destination_x,  destination_y + i).get_figure().get_color() != color) {
					return false; 
				}
			}
			return true;
		}
		return false;
	}
}
