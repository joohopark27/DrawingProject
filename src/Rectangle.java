public class Rectangle extends Shape {
	private int height;
	private int width;
	
	/**
	 * Constructs a Rectangle.
	 *
	 * @param color  the hexadecimal color
	 * @param x      the x coordinate of the upper left corner
	 * @param y      the y coordinate of the upper left corner
	 * @param height the height
	 * @param width  the width
	 */
	public Rectangle(int color, int x, int y, int height, int width) {
		super(color, x, y);
		setHeight(height);
		setWidth(width);
	}
	
	/**
	 * Inserts the Rectangle into the imgArray of the specified DrawingBoard.
	 *
	 * @param drawingBoard the DrawingBoard to draw onto
	 */
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
	
	/**
	 * Gets the total horizontal width of the Shape.
	 *
	 * @return the width
	 */
	@Override
	public int getWidth() {
		return width;
	}
	
	/**
	 * Gets the total vertical height of the Shape.
	 *
	 * @return the height
	 */
	@Override
	public int getHeight() {
		return height;
	}
	
	/**
	 * Sets the height of the Rectangle.
	 *
	 * @param height the height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Sets the width of the Rectangle.
	 *
	 * @param width the width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
}
