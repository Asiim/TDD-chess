package figures;

import enums.Color;

public class Bishop extends Figure {

	public Bishop() {		
	}
	
	public Bishop(Color color) {
		super(color);
	}
	
	public Bishop(int position_x, int position_y) {
		super(position_x, position_y);
	}
	
	public Bishop(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
	}
	
}
