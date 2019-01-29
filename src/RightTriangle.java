public class RightTriangle extends Shape {
	private int height;
	private int width;
	private String orientation;
	
	/**
	 * Constructs a RightTriangle. Orientation refers to the corner of the right angle. Input "UR", "UL", "LR", or "LL".
	 * Defaults to "LL" if an invalid orientation is given.
	 *
	 * @param color       the hexadecimal color
	 * @param x           the x coordinate of the upper left corner
	 * @param y           the y coordinate of the upper left corner
	 * @param height      the height
	 * @param width       the width
	 * @param orientation the corner of the right angle
	 */
	public RightTriangle(int color, int x, int y, int height, int width, String orientation) {
		super(color, x, y);
		setHeight(height);
		setWidth(width);
		setOrientation(orientation);
	}
	
	/**
	 * Gets the corner of the right angle in the form of a two letter string.
	 *
	 * @return the corner of the right angle
	 */
	public String getOrientation() {
		return orientation;
	}
	
	/**
	 * Sets the corner of the right angle. Input "UR", "UL", "LR", or "LL". Defaults to "LL" if an invalid orientation
	 * is given.
	 *
	 * @param orientation the corner of the right angle
	 */
	public void setOrientation(String orientation) {
		if (orientation.equals("UR") || orientation.equals("UL") || orientation.equals("LR") || orientation.equals("LL")) {
			this.orientation = orientation;
		} else {
			this.orientation = "LL";
		}
	}
	
	/**
	 * Gets the total horizontal width of the RightTriangle.
	 *
	 * @return the width
	 */
	@Override
	public int getWidth() {
		return width;
	}
	
	/**
	 * Sets the width of the Rectangle.
	 *
	 * @param width the width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Gets the total vertical height of the RightTriangle.
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
	 * Inserts the RightTriangle into the imgArray of the specified DrawingBoard.
	 *
	 * @param drawingBoard the DrawingBoard to draw onto
	 */
	@Override
	public void drawOn(DrawingBoard drawingBoard) {
		if (within(drawingBoard)) {
			switch (orientation) {
				case "UR":
					drawUR(drawingBoard);
					break;
				case "UL":
					drawUL(drawingBoard);
					break;
				case "LR":
					drawLR(drawingBoard);
					break;
				case "LL":
					drawLL(drawingBoard);
					break;
			}
		}
	}
	
	private void drawUR(DrawingBoard drawingBoard) {
		final double slope = ((double) width) / ((double) height);
		
		for (int row = getY(); row <= getY() + width; row++) {
			for (int column = (int) (getX() + (row - getY()) * slope); column <= getX() + width; column++) {
				drawingBoard.imgArray[row][column] = getColor();
			}
		}
	}
	
	private void drawUL(DrawingBoard drawingBoard) {
		final double slope = ((double) width) / ((double) height);
		
		for (int row = getY(); row <= getY() + width; row++) {
			for (int column = getX(); column <= getX() + width - (row - getY()) * slope; column++) {
				drawingBoard.imgArray[row][column] = getColor();
			}
		}
	}
	
	private void drawLR(DrawingBoard drawingBoard) {
		final double slope = ((double) width) / ((double) height);
		
		for (int row = getY(); row <= getY() + width; row++) {
			for (int column = (int) (getX() + width - (row - getY()) * slope); column <= getX() + width; column++) {
				drawingBoard.imgArray[row][column] = getColor();
			}
		}
	}
	
	private void drawLL(DrawingBoard drawingBoard) {
		final double slope = ((double) width) / ((double) height);
		
		for (int row = getY(); row <= getY() + width; row++) {
			for (int column = getX(); column <= getX() + (row - getY()) * slope; column++) {
				drawingBoard.imgArray[row][column] = getColor();
			}
		}
	}
}
