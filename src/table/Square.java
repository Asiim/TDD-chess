package table;

import figures.Pawn;

public class Square {
	
	public Square() {
		
	}
	
	public void set_color(Color color) {
		this.color = color;
	}
	
	public Color get_color() {
		return color;
	}
	
	public void set_pawn(Pawn pawn) {
		this.pawn = pawn;
	}
	
	public Pawn get_pawn() {
		return pawn;
	}
	
	private Color color;
	private Pawn pawn;
	
	public static enum Color{
		BLACK,
		WHITE
	}
	
}
