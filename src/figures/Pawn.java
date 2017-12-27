package figures;

import enums.Color;
import table.Table;

public class Pawn extends Figure{

	static {
		STARTING_ROW = 1;
	}
	
	public Pawn() {
		en_passat = false;
	}

	public Pawn(Color color, int position_x, int position_y) {
		super(color, position_x, position_y);
		en_passat = false;
		en_passat_y = 8;
	}
	
	public Boolean can_move(int destination_x, int destination_y, Table table) {
		return can_move(destination_x, destination_y, table, null);
	}
	
	public Boolean can_move(int destination_x, int destination_y, Table table, King king) {
		if(destination_y == position_y && table.get_square_at_position(destination_x, destination_y).get_figure() == null) {
			if(destination_x - position_x == 1 && !king_left_open(destination_x, destination_y, table, king)) {
				return true;
			}
			
			if(position_x == STARTING_ROW && destination_x - position_x == 2 && 
				!king_left_open(destination_x, destination_y, table, king) &&
				table.get_square_at_position(destination_x - 1, destination_y).get_figure() == null) {
				return true;
			}
		}
		
		if(diagonally_move(destination_x, destination_y) &&	enemy_on_destination(destination_x, destination_y, table) && 
				!king_left_open(destination_x, destination_y, table, king)) {
			return true;
		}
		if(en_passat && diagonally_move(destination_x, destination_y) && !king_left_open(destination_x, destination_y, table, king) &&
				table.get_length() - 1 - en_passat_y == destination_y) {
			return true;
		}
		return false;
	}
	
	private Boolean enemy_on_destination(int destination_x, int destination_y, Table table) {
		try {
			return table.get_square_at_position(destination_x, destination_y).get_figure().get_color() != this.get_color();
		}catch(Exception e) {
			return false;
		}
	}
	
	private Boolean diagonally_move(int destination_x, int destination_y) {
		return destination_x - position_x == 1 && Math.abs(destination_y - position_y) == 1;
	}

	public void move(int destination_x, int destination_y, Table table) {
		if(firstMove) {
			if(table.get_square_at_position(destination_x, destination_y + 1).get_figure() instanceof Pawn && 
					!table.get_square_at_position(destination_x, destination_y + 1).get_figure().get_color().equals(color)) {
			((Pawn) table.get_square_at_position(destination_x, destination_y + 1).get_figure()).enable_en_passat();
			((Pawn) table.get_square_at_position(destination_x, destination_y + 1).get_figure()).set_en_passat_y(destination_y);
			}
			if(table.get_square_at_position(destination_x, destination_y - 1).get_figure() instanceof Pawn && 
					!table.get_square_at_position(destination_x, destination_y - 1).get_figure().get_color().equals(color)) {
				((Pawn) table.get_square_at_position(destination_x, destination_y - 1).get_figure()).enable_en_passat();
				((Pawn) table.get_square_at_position(destination_x, destination_y - 1).get_figure()).set_en_passat_y(destination_y);
			}
		}
		super.move(destination_x, destination_y, table);
		if(en_passat) {
			table.get_square_at_position(destination_x - 1, destination_y).set_figure(null);
			disable_en_passat(this.color);
		}
	}
	
	public void enable_en_passat() {
		en_passat = true;
	}
	
	public Boolean en_passat_possible() {
		return en_passat;
	}
	
	public void disable_en_passat(Color color) {
		if(color.equals(this.color)) {
			en_passat = false;
		}
	}
	
	public void set_en_passat_y(int y) {
		en_passat_y = y;
	}
	
	private Boolean en_passat;
	private int en_passat_y;
	private static int STARTING_ROW;
}
