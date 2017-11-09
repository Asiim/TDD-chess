package table;

import figures.Pawn;
import figures.Rock;

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
	
	public void set_rock(Rock rock) {
		this.rock = rock;
	}
	
	private Color color;
	private Pawn pawn;
	Rock rock;
	
	
	public static enum Color{
		BLACK,
		WHITE
	}
	
}
