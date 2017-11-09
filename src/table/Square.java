package table;

public class Square {
	
	public Square() {
		
	}
	
	public void set_color(Color color) {
		this.color = color;
	}
	
	public Color get_color() {
		return color;
	}
	
	private Color color;

	public static enum Color{
		BLACK,
		WHITE
	}
	
}
