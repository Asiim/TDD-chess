package figures;

import enums.Color;
import table.Table;

public class Knight extends Figure {

	public Knight() {
	}
	
	public Knight(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
	}
	
	public Boolean can_move(int destination_x, int destination_y, Table table) {
		return can_move(destination_x, destination_y, table, null);
	}
	
	public Boolean can_move(int destination_x, int destination_y, Table table, King king) {
		if ((Math.abs(destination_x - position_x) == 2 && Math.abs(destination_y - position_y) == 1 ||
			Math.abs(destination_x - position_x) == 1 && Math.abs(destination_y - position_y) == 2)  &&
			!king_left_open(table, king)) {
			try {
				if(table.get_square_at_position(destination_x, destination_y).get_figure().get_color() == this.get_color()) {
					return false;
				}
			}
			catch(Exception e){
			}
			return true;
		}
		return false;
	}
}
