package figures;

import enums.Color;

public class Knight extends Figure {

	public Knight() {
	}
	
	public Knight(Color color) {
		super(color);
	}
	
	public Knight(int position_x, int position_y) {
		super(position_x, position_y);
	}
	
	public Knight(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
	}
}
