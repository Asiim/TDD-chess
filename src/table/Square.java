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
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (!Square.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    final Square other = (Square) obj;
	    if ((this.color == null) ? (other.color != null) : !this.color.equals(other.color)) {
	        return false;
	    }
	    if ((this.figure == null) ? (other.figure != null) : !this.figure.equals(other.figure)) {
	        return false;
	    }
	    return true;
	}
	
	private Color color;
	private Figure figure;
	
}
