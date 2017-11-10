package figures;

import enums.Color;

public class Pawn extends Figure{

	public Pawn() {
	}
	
	public Pawn(Color color) {
		super(color);
	}
	
	public Pawn(int position_x, int position_y) {
		super(position_x, position_y);
	}

	public Pawn(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
	}
}
