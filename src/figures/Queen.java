package figures;

import enums.Color;
import table.Table;

public class Queen extends Figure {

	public Queen() {
	}
	
	public Queen(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
	}
	
	public Boolean can_move(int destination_x, int destination_y, Table table) {
		int x_sign = Integer.signum(destination_x - position_x);
		int y_sign = Integer.signum(destination_y - position_y);

		if(enemy_on_destination(destination_x, destination_y, table)) {
			return false;
		}

		if(destination_x != position_x) {
			for (int i = 1; i < Math.abs(destination_x - position_x); i++) {
				if(table.get_square_at_position(position_x + i * x_sign, position_y).get_figure() != null) {
					return false;
				}
			}
		}

		if(destination_y != position_y) {
			for (int i = 1; i < Math.abs(destination_y - position_y); i++) {
				if(table.get_square_at_position(position_x, position_y + i * y_sign).get_figure() != null) {
					return false;
				}
			}
		}
		return true;
	}
}
