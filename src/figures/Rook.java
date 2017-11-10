package figures;

import enums.Color;

public class Rook extends Figure{

	public Rook() {
	}
	
	public Rook(Color color) {
		super(color);
	}
	
	public Rook(int position_x, int position_y) {
		super(position_x, position_y);
	}
	
	public Rook(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
	}
}
