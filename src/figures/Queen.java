package figures;

import enums.Color;

public class Queen extends Figure {

	public Queen() {
	}
	
	public Queen(Color color) {
		super(color);
	}
	
	public Queen(int position_x, int position_y) {
		super(position_x, position_y);
	}
	
	public Queen(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
	}
}
