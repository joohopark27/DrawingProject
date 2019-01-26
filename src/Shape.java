/*
TODO Make RightTriangle class
TODO Make LineSegment class
TODO (Optional) Make Circle class
TODO (Optional) Make additional class
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
		} else return y + getHeight() <= drawingBoard.getHeight();
	}
	
	public abstract int getWidth();
	
	public abstract int getHeight();
	
	@Override
	public int getX() {
		return x;
	}
	
	@Override
	public void setX(int x) {
		if (x < 0) {
			this.x = 0;
		} else {
			this.x = x;
		}
	}
	
	@Override
	public int getY() {
		return y;
	}
	
	@Override
	public void setY(int y) {
		if (y < 0) {
			this.y = 0;
		} else {
			this.y = y;
		}
	}
	
	@Override
	public int getColor() {
		return color;
	}
	
	@Override
	public void setColor(int color) {
		this.color = color;
	}
}