/*
TODO Make LineSegment class
TODO (Optional) Make Circle class
TODO (Optional) Make additional class
*/

public abstract class Shape implements Drawable {
	private int color;
	private int x;
	private int y;
	
	/**
	 * Constructs a Shape.
	 *
	 * @param color the hexadecimal color
	 * @param x     the x value of the upper left corner
	 * @param y     the y value of the upper left corner
	 */
	public Shape(int color, int x, int y) {
		setColor(color);
		setX(x);
		setY(y);
	}
	
	/**
	 * Determines if the Shape will fall entirely within the DrawingBoard.
	 *
	 * @param drawingBoard the DrawingBoard to test against
	 *
	 * @return true if the Drawable falls entirely within the DrawingBoard, otherwise false
	 */
	@Override
	public boolean within(DrawingBoard drawingBoard) {
		return x + getWidth() <= drawingBoard.getWidth() && y + getHeight() <= drawingBoard.getHeight() && x >= 0 && y >= 0;
	}
	
	/**
	 * Gets the total horizontal width of the Shape.
	 *
	 * @return the width
	 */
	public abstract int getWidth();
	
	/**
	 * Gets the total vertical height of the Shape.
	 *
	 * @return the height
	 */
	public abstract int getHeight();
	
	/**
	 * Gets the x coordinate of the upper left corner.
	 *
	 * @return the x coordinate of the upper left corner
	 */
	@Override
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the x coordinate of the upper left corner.
	 *
	 * @param x the x coordinate of the upper left corner
	 */
	@Override
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Gets the y coordinate of the upper left corner.
	 *
	 * @return the y coordinate of the upper left corner
	 */
	@Override
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y coordinate of the upper left corner.
	 *
	 * @param y the y coordinate of the upper left corner
	 */
	@Override
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Gets the hexadecimal color.
	 *
	 * @return the hexadecimal color
	 */
	@Override
	public int getColor() {
		return color;
	}
	
	/**
	 * Sets the hexadecimal color.
	 *
	 * @param color the hexadecimal color
	 */
	@Override
	public void setColor(int color) {
		this.color = color;
	}
	
	protected void drawPixel(int row, int column, DrawingBoard drawingBoard) {
		if (row < drawingBoard.getHeight() && column < drawingBoard.getWidth() && row >= 0 && column >= 0) {
			drawingBoard.imgArray[row][column] = color;
		}
	}
}