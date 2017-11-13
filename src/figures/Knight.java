package figures;

import enums.Color;

public class Knight extends Figure {

	public Knight() {
	}
	
	public Knight(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
	}
	
	public Boolean can_move(int destination_x, int destination_y) {
		if (Math.abs(destination_x - position_x) == 2 && Math.abs(destination_y - position_y) == 1) {
			return true;
		}
//		if (destination_x ==  position_x + 2 && destination_y == position_y - 1) {
//			return true;
//		}
//		if (destination_x ==  position_x - 2 && destination_y == position_y + 1) {
//			return true;
//		}
//		if (destination_x ==  position_x - 2 && destination_y == position_y - 1) {
//			return true;
//		}
		return false;
	}
}
