package table;

import enums.Color;
import figures.Bishop;
import figures.King;
import figures.Knight;
import figures.Pawn;
import figures.Queen;
import figures.Rook;

public class Table {
	
	static {
		TABLE_WIDTH = 8;
		TABLE_LENGTH = 8;
		WHITE_STARTING_ROW = 0;
		BLACK_STARTING_ROW = 7;
		ROOK_STARTING_COLUMN_1 = 0;
		KNIGHT_STARTING_COLUMN_1 = 1;
		BISHOP_STARTING_COLUMN_1 = 2;
		QUEEN_STARTING_COLUMN = 3;
		KING_STARTING_COLUMN = 4;
		BISHOP_STARTING_COLUMN_2 = 5;
		KNIGHT_STARTING_COLUMN_2 = 6;
		ROOK_STARTING_COLUMN_2 = 7;
	}
	
	public Table() {
		square = new Square[TABLE_WIDTH][TABLE_LENGTH];
		
		for (int i = 0; i < TABLE_WIDTH; i++) {
			for (int j = 0; j < TABLE_LENGTH; j++) {
				if ( (i + j) % 2 == 0) {
				square[i][j] = new Square(Color.BLACK);
				}
				else {
				square[i][j] = new Square(Color.WHITE);
				}
			}
		}
	}

	
	public Boolean is_empty(int x, int y) {
		if(square[x][y].get_figure() == null) {
			return true;
		}
		return false;
	}
	
	public Boolean has_figure(int x, int y) {
		return !(is_empty(x, y));
	}

	public void rotate() {
		Square tmp = new Square();
		for(int i = 0; i < (TABLE_WIDTH / 2) - 1; i++) {
			for(int j = 0; j < TABLE_LENGTH; j++) {
				tmp = this.square[i][j];
				this.square[i][j] = this.square[TABLE_WIDTH - i - 1][TABLE_LENGTH - j - 1];
				this.square[TABLE_WIDTH - i - 1][TABLE_LENGTH - j - 1] = tmp;
			}
		}
	}
	
	public Boolean square_occupied(int coordinate_x, int coordinate_y, Color color) {
		for(int i = 1; i < TABLE_WIDTH - coordinate_x; i++) {
			if(this.square[coordinate_x + i][coordinate_y].get_figure() instanceof Rook &&
					!(this.square[coordinate_x + i][coordinate_y].get_figure().get_color().equals(color))) {
				return true;
			}
			if(this.square[coordinate_x + i][coordinate_y].get_figure() != null) {
				break;
			}
		}
		for(int i = 1; i < coordinate_x; i++) {
			if(this.square[coordinate_x - i][coordinate_y].get_figure() instanceof Rook &&
					!(this.square[coordinate_x - i][coordinate_y].get_figure().get_color().equals(color))) {
				return true;
			}
			if(this.square[coordinate_x - i][coordinate_y].get_figure() != null) {
				break;
			}
		}
		for(int i = 1; i < TABLE_LENGTH - coordinate_y; i++) {
			if(this.square[coordinate_x][coordinate_y + i].get_figure() instanceof Rook &&
					!(this.square[coordinate_x][coordinate_y + i].get_figure().get_color().equals(color))) {
				return true;
			}
			if(this.square[coordinate_x][coordinate_y + i].get_figure() != null) {
				break;
			}
		}
		for(int i = 1; i < coordinate_y; i++) {
			if(this.square[coordinate_x][coordinate_y - i].get_figure() instanceof Rook &&
					!(this.square[coordinate_x][coordinate_y - i].get_figure().get_color().equals(color))) {
				return true;
			}
			if(this.square[coordinate_x][coordinate_y - i].get_figure() != null) {
				break;
			}
		}
		return false;
	}

	public void set_figures_on_table() {
		square[WHITE_STARTING_ROW][ROOK_STARTING_COLUMN_1].set_figure(new Rook(Color.WHITE, WHITE_STARTING_ROW, ROOK_STARTING_COLUMN_1));
		square[WHITE_STARTING_ROW][ROOK_STARTING_COLUMN_2].set_figure(new Rook(Color.WHITE, WHITE_STARTING_ROW, ROOK_STARTING_COLUMN_2));
		square[WHITE_STARTING_ROW][KNIGHT_STARTING_COLUMN_1].set_figure(new Knight(Color.WHITE, WHITE_STARTING_ROW, KNIGHT_STARTING_COLUMN_1));
		square[WHITE_STARTING_ROW][KNIGHT_STARTING_COLUMN_2].set_figure(new Knight(Color.WHITE, WHITE_STARTING_ROW, KNIGHT_STARTING_COLUMN_2));
		square[WHITE_STARTING_ROW][BISHOP_STARTING_COLUMN_1].set_figure(new Bishop(Color.WHITE, WHITE_STARTING_ROW, BISHOP_STARTING_COLUMN_1));
		square[WHITE_STARTING_ROW][BISHOP_STARTING_COLUMN_2].set_figure(new Bishop(Color.WHITE, WHITE_STARTING_ROW, BISHOP_STARTING_COLUMN_2));
		square[WHITE_STARTING_ROW][QUEEN_STARTING_COLUMN].set_figure(new Queen(Color.WHITE, WHITE_STARTING_ROW, QUEEN_STARTING_COLUMN));
		square[WHITE_STARTING_ROW][KING_STARTING_COLUMN].set_figure(new King(Color.WHITE, WHITE_STARTING_ROW, KING_STARTING_COLUMN));
		for ( int i = 0; i < Table.TABLE_LENGTH; i++) {
			square[WHITE_STARTING_ROW + 1][i].set_figure(new Pawn(Color.WHITE, WHITE_STARTING_ROW + 1, i));
		}
		
		square[BLACK_STARTING_ROW][ROOK_STARTING_COLUMN_1].set_figure(new Rook(Color.BLACK, BLACK_STARTING_ROW, ROOK_STARTING_COLUMN_1));
		square[BLACK_STARTING_ROW][ROOK_STARTING_COLUMN_2].set_figure(new Rook(Color.BLACK, BLACK_STARTING_ROW, ROOK_STARTING_COLUMN_2));
		square[BLACK_STARTING_ROW][KNIGHT_STARTING_COLUMN_1].set_figure(new Knight(Color.BLACK, BLACK_STARTING_ROW, KNIGHT_STARTING_COLUMN_1));
		square[BLACK_STARTING_ROW][KNIGHT_STARTING_COLUMN_2].set_figure(new Knight(Color.BLACK, BLACK_STARTING_ROW, KNIGHT_STARTING_COLUMN_2));
		square[BLACK_STARTING_ROW][BISHOP_STARTING_COLUMN_1].set_figure(new Bishop(Color.BLACK, BLACK_STARTING_ROW, BISHOP_STARTING_COLUMN_1));
		square[BLACK_STARTING_ROW][BISHOP_STARTING_COLUMN_2].set_figure(new Bishop(Color.BLACK, BLACK_STARTING_ROW, BISHOP_STARTING_COLUMN_2));
		square[BLACK_STARTING_ROW][QUEEN_STARTING_COLUMN].set_figure(new Queen(Color.BLACK, BLACK_STARTING_ROW, QUEEN_STARTING_COLUMN));
		square[BLACK_STARTING_ROW][KING_STARTING_COLUMN].set_figure(new King(Color.BLACK, BLACK_STARTING_ROW, KING_STARTING_COLUMN));
		for ( int i = 0; i < Table.TABLE_LENGTH; i++) {
			square[BLACK_STARTING_ROW - 1][i].set_figure(new Pawn(Color.BLACK, BLACK_STARTING_ROW - 1, i));
		}
	}

	public int get_width() {
		return TABLE_WIDTH;
	}
	
	public int get_length() {
		return TABLE_LENGTH;
	}
	
	public Square[][] get_square(){
		return square;
	}
	
	public Square get_square_at_position(int x, int y){
		return square[x][y];
	}
	
	private Square[][] square;
	private static int TABLE_WIDTH;
	private static int TABLE_LENGTH;
	private static int WHITE_STARTING_ROW;
	private static int BLACK_STARTING_ROW;
	private static int QUEEN_STARTING_COLUMN;
	private static int KING_STARTING_COLUMN;
	private static int BISHOP_STARTING_COLUMN_1;
	private static int KNIGHT_STARTING_COLUMN_1;
	private static int ROOK_STARTING_COLUMN_1;
	private static int BISHOP_STARTING_COLUMN_2;
	private static int KNIGHT_STARTING_COLUMN_2;
	private static int ROOK_STARTING_COLUMN_2;
	
}
