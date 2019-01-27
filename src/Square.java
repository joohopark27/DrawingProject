public class Square extends Rectangle {
	public Square(int color, int x, int y, int sideLength) {
		super(color, x, y, sideLength, sideLength);
	}
	
	@Override
	public void setHeight(int height) {
		super.setHeight(height);
		super.setWidth(height);
	}
	
	@Override
	public void setWidth(int width) {
		setHeight(width);
	}
}
