package table;

import figures.Figure;

public class Square {
	
	public Square() {
		
	}
	
	public void set_color(Color color) {
		this.color = color;
	}
	
	public Color get_color() {
		return color;
	}
	
	public void set_figure(Figure figure) {
		this.figure = figure;
	}
	
	public Figure get_figure() {
		return figure;
	}
	
	private Color color;
	private Figure figure;
	
	
	public static enum Color{
		BLACK,
		WHITE
	}
	
}
