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
	
	public Square[][] get_square(){
		return square;
	}
	
	public static int get_TABLE_WIDHT() {
		return TABLE_WIDTH;
	}
	
	public static int get_TABLE_LENGTH() {
		return TABLE_LENGTH;
	}
	
	public void set_figures_on_table() {
		square[0][0].set_figure(new Rook(Color.WHITE, 0, 0));
		square[0][7].set_figure(new Rook(Color.WHITE, 0, 7));
		square[0][1].set_figure(new Knight(Color.WHITE, 0, 1));
		square[0][6].set_figure(new Knight(Color.WHITE, 0, 6));
		square[0][2].set_figure(new Bishop(Color.WHITE, 0, 2));
		square[0][5].set_figure(new Bishop(Color.WHITE, 0, 5));
		square[0][3].set_figure(new Queen(Color.WHITE, 0, 3));
		square[0][4].set_figure(new King(Color.WHITE, 0, 4));
		for ( int i = 0; i < Table.TABLE_LENGTH; i++) {
			square[1][i].set_figure(new Pawn(Color.WHITE, 1, i));
		}
		
		square[7][0].set_figure(new Rook(Color.BLACK, 7, 0));
		square[7][7].set_figure(new Rook(Color.BLACK, 7, 7));
		square[7][1].set_figure(new Knight(Color.BLACK, 7, 1));
		square[7][6].set_figure(new Knight(Color.BLACK, 7, 6));
		square[7][2].set_figure(new Bishop(Color.BLACK, 7, 2));
		square[7][5].set_figure(new Bishop(Color.BLACK, 7, 5));
		square[7][4].set_figure(new Queen(Color.BLACK, 7, 4));
		square[7][3].set_figure(new King(Color.BLACK, 7, 3));
		for ( int i = 0; i < Table.TABLE_LENGTH; i++) {
			square[6][i].set_figure(new Pawn(Color.BLACK, 1, i));
		}
	}
	
	private Square[][] square;
	private static int TABLE_WIDTH;
	private static int TABLE_LENGTH;
	
}
