public class Circle extends Square {
	/**
	 * Constructs a Circle.
	 *
	 * @param color  the hexadecimal color
	 * @param x      the x value of the center
	 * @param y      the y value of the center
	 * @param radius the diameter of the circle
	 */
	public Circle(int color, int x, int y, int radius) {
		super(color, x, y, radius * 2);
	}
	
	@Override
	protected void drawPixel(int row, int column, DrawingBoard drawingBoard) {
		if (getRadius() > Math.hypot(column - getCenterX(), row - getCenterY())) {
			super.drawPixel(row, column, drawingBoard);
		}
	}
	
	/**
	 * Gets the radius.
	 *
	 * @return the radius
	 */
	public int getRadius() {
		return getSideLength() / 2;
	}
	
	/**
	 * Sets the radius.
	 *
	 * @param radius the radius
	 */
	public void setRadius(int radius) {
		setSideLength(radius * 2);
	}
	
	private int getCenterX() {
		return getX() + getRadius();
	}
	
	private int getCenterY() {
		return getY() + getRadius();
	}
}