/*
TODO Make RightTriangle class
TODO Make LineSegment class
TODO (Optional) Make Circle class
TODO (Optional) Make additional class

TODO Allow Shapes to have their attributes changed
*/

public abstract class Shape implements Drawable {
	private int color;
	private int x;
	private int y;
	
	public Shape(int color, int x, int y) {
		setColor(color);
		setX(x);
		setY(y);
	}
	
	@Override
	public boolean within(DrawingBoard drawingBoard) {
		if (x + getWidth() > drawingBoard.getWidth()) {
			return false;
		} else if (y + getHeight() > drawingBoard.getHeight()) {
			return false;
		} else {
			return true;
		}
	}
	
	public abstract int getWidth();
	public abstract int getHeight();
	
	public int getColor() {
		return color;
	}
	
	//TODO Make sure setColor is actually given a color as a parameter
	private void setColor(int color) {
		this.color = color;
	}
	
	public int getX() {
		return x;
	}
	
	private void setX(int x) {
		if (x < 0) {
			this.x = 0;
		} else {
			this.x = x;
		}
	}
	
	public int getY() {
		return y;
	}
	
	private void setY(int y) {
		if (y < 0) {
			this.y = 0;
		} else {
			this.y = y;
		}
	}
}