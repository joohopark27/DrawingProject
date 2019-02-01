public abstract class Polygon extends Shape {
	private int height;
	private int width;
	
	/**
	 * Constructs a Polygon.
	 *
	 * @param color  the hexadecimal color
	 * @param x      the x coordinate of the upper left corner
	 * @param y      the y coordinate of the upper left corner
	 * @param height the height
	 * @param width  the width
	 */
	public Polygon(int color, int x, int y, int height, int width) {
		super(color, x, y);
		setHeight(height);
		setWidth(width);
	}
	
	/**
	 * Determines if the Polygon will fall entirely within the DrawingBoard.
	 *
	 * @param drawingBoard the DrawingBoard to test against
	 *
	 * @return true if the Polygon falls entirely within the DrawingBoard, otherwise false
	 */
	@Override
	public boolean within(DrawingBoard drawingBoard) {
		return getX() + getWidth() <= drawingBoard.getWidth() && getY() + getHeight() <= drawingBoard.getHeight() && getX() >= 0 && getY() >= 0;
	}
	
	/**
	 * Gets the total horizontal width of the Polygon.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Gets the total vertical height of the Polygon.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Sets the height of the Polygon.
	 *
	 * @param height the height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Sets the width of the Polygon.
	 *
	 * @param width the width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
}