package table;

import enums.Color;
import figures.Figure;

public class Square {
	
	public Square() {
		
	}
	
	public Square(Color color) {
		this.color = color;
	}
	
	public void set_color(Color color) {
		this.color = color;
	}
	
	public Color get_color() {
		return color;
	}
	
	public void set_figure(Figure figure) {
		if (this.figure == null) {
			this.figure = figure;
		}
	}
	
	public Figure get_figure() {
		return figure;
	}
	
	private Color color;
	private Figure figure;
	
}
