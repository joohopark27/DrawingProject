public abstract class Shape implements Drawable {
	private int color;
	private int x;
	private int y;
	
	/**
	 * Constructs a Shape.
	 *
	 * @param color the hexadecimal color
	 * @param x     the x value
	 * @param y     the y value
	 */
	public Shape(int color, int x, int y) {
		setColor(color);
		setX(x);
		setY(y);
	}
	
	/**
	 * Gets the x coordinate.
	 *
	 * @return the x coordinate
	 */
	@Override
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the x coordinate.
	 *
	 * @param x the x coordinate
	 */
	@Override
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Gets the y coordinate.
	 *
	 * @return the y coordinate
	 */
	@Override
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y coordinate.
	 *
	 * @param y the y coordinate
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
	
	protected void drawPixel(int color, int row, int column, DrawingBoard drawingBoard) {
		if (row < drawingBoard.getHeight() && column < drawingBoard.getWidth() && row >= 0 && column >= 0) {
			drawingBoard.imgArray[row][column] = color;
		}
	}
}