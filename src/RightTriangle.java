public class RightTriangle extends Polygon {
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
		super(color, x, y, height, width);
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
	 * Inserts the RightTriangle into the imgArray of the specified DrawingBoard.
	 *
	 * @param drawingBoard the DrawingBoard to draw onto
	 */
	@Override
	public void drawOn(DrawingBoard drawingBoard) {
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
	
	private void drawUR(DrawingBoard drawingBoard) {
		final double slope = (double) getWidth() / (double) getHeight();
		
		for (int row = getY(); row < getY() + getHeight(); row++) {
			for (int column = (int) (getX() + (row - getY()) * slope); column < getX() + getWidth(); column++) {
				drawPixel(getColor(), row, column, drawingBoard);
			}
		}
	}
	
	private void drawUL(DrawingBoard drawingBoard) {
		final double slope = (double) getWidth() / (double) getHeight();
		
		for (int row = getY(); row < getY() + getHeight(); row++) {
			for (int column = getX(); column < getX() + getWidth() - (row - getY()) * slope; column++) {
				drawPixel(getColor(), row, column, drawingBoard);
			}
		}
	}
	
	private void drawLR(DrawingBoard drawingBoard) {
		final double slope = (double) getWidth() / (double) getHeight();
		
		for (int row = getY(); row < getY() + getHeight(); row++) {
			for (int column = (int) (getX() + getWidth() - (row - getY()) * slope); column < getX() + getWidth(); column++) {
				drawPixel(getColor(), row, column, drawingBoard);
			}
		}
	}
	
	private void drawLL(DrawingBoard drawingBoard) {
		final double slope = (double) getWidth() / (double) getHeight();
		
		for (int row = getY(); row < getY() + getHeight(); row++) {
			for (int column = getX(); column < getX() + (row - getY()) * slope; column++) {
				drawPixel(getColor(), row, column, drawingBoard);
			}
		}
	}
}
