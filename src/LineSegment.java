public class LineSegment extends Shape {
	private int x2;
	private int y2;
	
	/**
	 * Constructs a Line Segment.
	 *
	 * @param color the hexadecimal color
	 * @param x     the x value of the first point
	 * @param y     the y value of the first point
	 * @param x2    the x value of the second point
	 * @param y2    the y value of the second point
	 */
	public LineSegment(int color, int x, int y, int x2, int y2) {
		super(color, x, y);
		setX2(x2);
		setY2(y2);
	}
	
	/**
	 * Inserts the LineSegment into the imgArray of the specified DrawingBoard.
	 *
	 * @param drawingBoard the DrawingBoard to draw onto
	 */
	@Override
	public void drawOn(DrawingBoard drawingBoard) {
		if (Math.abs(slope()) > 1) {
			drawVertically(drawingBoard);
		} else {
			drawHorizontally(drawingBoard);
		}
	}
	
	/**
	 * Determines if the LineSegment will fall entirely within the DrawingBoard.
	 *
	 * @param drawingBoard the DrawingBoard to test against
	 *
	 * @return true if the LineSegment falls entirely within the DrawingBoard, otherwise false
	 */
	@Override
	public boolean within(DrawingBoard drawingBoard) {
		return rightX() <= drawingBoard.getWidth() &&
				bottomY() <= drawingBoard.getHeight() &&
				leftX() >= 0 &&
				topY() >= 0;
	}
	
	private int rightX() {
		return Integer.max(getX(), getX2());
	}
	
	private int bottomY() {
		return Integer.max(getY(), getY2());
	}
	
	private int leftX() {
		return Integer.min(getX(), getX2());
	}
	
	private int topY() {
		return Integer.min(getY(), getY2());
	}
	
	/**
	 * Gets the x coordinate of the second point.
	 *
	 * @return the x coordinate of the second point
	 */
	public int getX2() {
		return x2;
	}
	
	/**
	 * Sets the x coordinate of the second point.
	 *
	 * @param x2 the x coordinate of the second point
	 */
	public void setX2(int x2) {
		this.x2 = x2;
	}
	
	/**
	 * Gets the y coordinate of the second point.
	 *
	 * @return the y coordinate of the second point
	 */
	public int getY2() {
		return y2;
	}
	
	/**
	 * Sets the y coordinate of the second point.
	 *
	 * @param y2 the y coordinate of the second point
	 */
	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	private double slope() {
		double output = (double) (bottomY() - topY()) / (double) (rightX() - leftX());
		
		if (positiveSlope()) {
			return output;
		} else {
			return -output;
		}
	}
	
	private int xWithTopY() {
		if (topY() == getY()) {
			return getX();
		} else {
			return getX2();
		}
	}
	
	private int yWithLeftX() {
		if (leftX() == getX()) {
			return getY();
		} else {
			return getY2();
		}
	}
	
	private boolean positiveSlope() {
		return ((getX2() > getX()) == (getY2() > getY()));
	}
	
	private void drawVertically(DrawingBoard drawingBoard) {
		for (int row = topY(); row <= bottomY(); row++) {
			drawPixel(getColor(), row, columnValue(row), drawingBoard);
		}
	}
	
	private void drawHorizontally(DrawingBoard drawingBoard) {
		for (int column = leftX(); column <= rightX(); column++) {
			drawPixel(getColor(), rowValue(column), column, drawingBoard);
		}
	}
	
	private int rowValue(int column) {
		return (int) (yWithLeftX() + slope() * (column - leftX()));
	}
	
	private int columnValue(int row) {
		return (int) (xWithTopY() + (1 / slope()) * (row - topY()));
	}
}