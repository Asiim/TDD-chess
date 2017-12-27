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
		try {
			if(!figure.get_color().equals(this.figure.get_color())) {
				this.figure = figure;
			}
		}
		catch(Exception e) {
			this.figure = figure;
		}
	}
	
	public Figure get_figure() {
		return figure;
	}
	
	@Override
	public boolean equals(Object obj) {
	    final Square other = (Square) obj;
	    if ((this.color == null) ? (other.color != null) : !this.color.equals(other.color)) {
	        return false;
	    }
	    return true;
	}
	
	private Color color;
	private Figure figure;	
}
