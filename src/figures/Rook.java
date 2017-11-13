package figures;

import enums.Color;
import table.Table;

public class Rook extends Figure{

	public Rook() {
	}
	
	public Rook(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
	}
	
	public Boolean canMove(int destination_x, int destination_y, Table table) {
		if(destination_x != position_x && destination_y != position_y) {
			return false;
		}
		if(table.get_square_at_position(4, 2).get_figure() != null) {
			return false;
		}
		return true;
	}
}
