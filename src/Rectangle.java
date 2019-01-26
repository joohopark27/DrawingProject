public class Rectangle extends Shape {
	private int height;
	private int width;
	
	public Rectangle(int color, int x, int y, int height, int width) {
		super(color, x, y);
		setHeight(height);
		setWidth(width);
	}
	
	@Override
	public void drawOn(DrawingBoard drawingBoard) {
		if (within(drawingBoard)) {
			for (int row = getY(); row < getY() + height; row++) {
				for (int column = getX(); column < getX() + width; column++) {
					drawingBoard.imgArray[row][column] = getColor();
				}
			}
		}
	}
	
	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public int getHeight() {
		return height;
	}
	
	private void setHeight(int height) {
		this.height = height;
	}
	
	private void setWidth(int width) {
		this.width = width;
	}
}
