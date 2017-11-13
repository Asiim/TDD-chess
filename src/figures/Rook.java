package figures;

import enums.Color;

public class Rook extends Figure{

	public Rook() {
	}
	
	public Rook(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
	}
	
	public Boolean canMove(int destination_x, int destination_y) {
		if (destination_x == position_x && destination_y != position_y) {
			return true;
		}
		else if (destination_y == position_y && destination_x != position_x) {
			return true;
		}
		return false;
	}
}
