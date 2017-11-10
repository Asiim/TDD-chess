package figures;

import enums.Color;

public class King extends Figure {

	public King() {
	}
	
	public King(Color color) {
		super(color);
	}
	
	public King(int position_x, int position_y) {
		super(position_x, position_y);
	}
	
	public King(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
	}
}
