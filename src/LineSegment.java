public class LineSegment extends Shape {
	private int x2;
	private int y2;
	
	/**
	 * Constructs a Line Segment.
	 *
	 * @param color the hexadecimal color
	 * @param x1    the x value of the first point
	 * @param y1    the y value of the first point
	 * @param x2    the x value of the second point
	 * @param y2    the y value of the second point
	 */
	public LineSegment(int color, int x1, int y1, int x2, int y2) {
		super(color, x1, y1);
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
		return Integer.max(getX1(), getX2());
	}
	
	/**
	 * Gets the x coordinate of the first point.
	 *
	 * @return the x coordinate of the first point
	 */
	public int getX1() {
		return super.getX();
	}
	
	/**
	 * Sets the x coordinate of the first point.
	 *
	 * @param x1 the x coordinate of the first point
	 */
	public void setX1(int x1) {
		super.setX(x1);
	}
	
	private int leftX() {
		return Integer.min(getX1(), getX2());
	}
	
	/**
	 * Gets the x coordinate of the second point.
	 *
	 * @return the x coordinate of the second point
	 */
	public int getX2() {
		return x2;
	}
	
	private int topY() {
		return Integer.min(getY1(), getY2());
	}
	
	private int bottomY() {
		return Integer.max(getY1(), getY2());
	}
	
	/**
	 * Gets the leftmost x coordinate.
	 *
	 * @return the leftmost x coordinate
	 */
	@Override
	public int getX() {
		return leftX();
	}
	
	/**
	 * Gets the y coordinate of the first point.
	 *
	 * @return the y coordinate of the first point
	 */
	public int getY1() {
		return super.getY();
	}
	
	/**
	 * Sets the leftmost x coordinate.
	 *
	 * @param x the leftmost x coordinate
	 */
	@Override
	public void setX(int x) {
		final int difference = x - getX();
		
		setX1(getX1() + difference);
		setX2(getX2() + difference);
	}
	
	/**
	 * Sets the y coordinate of the first point.
	 *
	 * @param y1 the y coordinate of the first point
	 */
	public void setY1(int y1) {
		super.setY(y1);
	}
	
	/**
	 * Gets the y topmost coordinate.
	 *
	 * @return the y topmost coordinate
	 */
	@Override
	public int getY() {
		return topY();
	}
	
	private int xWithTopY() {
		if (topY() == getY1()) {
			return getX1();
		} else {
			return getX2();
		}
	}
	
	/**
	 * Sets the y topmost coordinate.
	 *
	 * @param y the y topmost coordinate
	 */
	@Override
	public void setY(int y) {
		final int difference = y - getY();
		
		setY1(getY1() + difference);
		setY2(getY2() + difference);
	}
	
	private int yWithLeftX() {
		if (leftX() == getX1()) {
			return getY1();
		} else {
			return getY2();
		}
	}
	
	private boolean positiveSlope() {
		return ((getX2() > getX1()) == (getY2() > getY1()));
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
	
	private void drawVertically(DrawingBoard drawingBoard) {
		for (int row = topY(); row < bottomY(); row++) {
			drawPixel(row, columnValue(row), drawingBoard);
		}
	}
	
	private void drawHorizontally(DrawingBoard drawingBoard) {
		for (int column = leftX(); column < rightX(); column++) {
			drawPixel(rowValue(column), column, drawingBoard);
		}
	}
	
	private int rowValue(int column) {
		return (int) (yWithLeftX() + slope() * (column - leftX()));
	}
	
	private int columnValue(int row) {
		return (int) (xWithTopY() + (1 / slope()) * (row - topY()));
	}
}