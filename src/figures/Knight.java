package figures;

import enums.Color;

public class Knight extends Figure {

	public Knight() {
	}
	
	public Knight(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
	}
	
	public Boolean can_move(int destination_x, int destination_y) {
		return true;
	}
}
