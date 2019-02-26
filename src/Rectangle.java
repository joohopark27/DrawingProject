public class Rectangle extends Polygon {
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
		super(color, x, y, height, width);
	}
	
	/**
	 * Inserts the Rectangle into the imgArray of the specified DrawingBoard.
	 *
	 * @param drawingBoard the DrawingBoard to draw onto
	 */
	@Override
	public void drawOn(DrawingBoard drawingBoard) {
		for (int row = getY(); row < getY() + getHeight(); row++) {
			for (int column = getX(); column < getX() + getWidth(); column++) {
				drawPixel(row, column, drawingBoard);
			}
		}
	}
}