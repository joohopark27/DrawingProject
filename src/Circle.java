public class Circle extends Shape {
	private int radius;
	
	/**
	 * Constructs a Circle.
	 *
	 * @param color  the hexadecimal color
	 * @param x      the x value of the center
	 * @param y      the y value of the center
	 * @param radius the radius of the circle
	 */
	public Circle(int color, int x, int y, int radius) {
		super(color, x, y);
		setRadius(radius);
	}
	
	/**
	 * Inserts the Circle into the imgArray of the specified DrawingBoard.
	 *
	 * @param drawingBoard the DrawingBoard to draw onto
	 */
	@Override
	public void drawOn(DrawingBoard drawingBoard) {
		for (int row = getY() - getRadius(); row < getY() + getRadius(); row++) {
			for (int column = getX() - getRadius(); column < getX() + getRadius(); column++) {
				drawPixel(getColor(), row, column, drawingBoard);
			}
		}
	}
	
	/**
	 * Gets the radius.
	 *
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}
	
	/**
	 * Sets the radius. If a value of less than zero is given, it is rounded up to zero.
	 *
	 * @param radius the radius
	 */
	public void setRadius(int radius) {
		if (radius >= 0) {
			this.radius = radius;
		} else {
			this.radius = 0;
		}
	}
	
	@Override
	protected void drawPixel(int color, int row, int column, DrawingBoard drawingBoard) {
		if (getRadius() > Math.hypot(column - getX(), row - getY())) {
			super.drawPixel(getColor(), row, column, drawingBoard);
		}
	}
	
	/**
	 * Determines if the Circle will fall entirely within the DrawingBoard.
	 *
	 * @param drawingBoard the DrawingBoard to test against
	 *
	 * @return true if the Circle falls entirely within the DrawingBoard, otherwise false
	 */
	@Override
	public boolean within(DrawingBoard drawingBoard) {
		return getX() + getRadius() <= drawingBoard.getWidth() &&
				getY() + getRadius() <= drawingBoard.getHeight() &&
				getX() - getRadius() >= 0 &&
				getY() - getRadius() >= 0;
	}
}