public interface Drawable {
	/**
	 * Inserts the Drawable into the imgArray of the specified DrawingBoard.
	 *
	 * @param drawingBoard the DrawingBoard to draw onto
	 */
	void drawOn(DrawingBoard drawingBoard);
	
	/**
	 * Determines if the Drawable will fall entirely within the DrawingBoard.
	 *
	 * @param drawingBoard the DrawingBoard to test against
	 *
	 * @return true if the Drawable falls entirely within the DrawingBoard, otherwise false
	 */
	boolean within(DrawingBoard drawingBoard);
	
	/**
	 * Gets the x coordinate of the upper left corner.
	 *
	 * @return the x coordinate of the upper left corner
	 */
	int getX();
	
	/**
	 * Sets the x coordinate of the upper left corner.
	 *
	 * @param x the x coordinate of the upper left corner
	 */
	void setX(int x);
	
	/**
	 * Gets the y coordinate of the upper left corner.
	 *
	 * @return the y coordinate of the upper left corner
	 */
	int getY();
	
	/**
	 * Sets the y coordinate of the upper left corner.
	 *
	 * @param y the y coordinate of the upper left corner
	 */
	void setY(int y);
	
	/**
	 * Gets the hexadecimal color.
	 *
	 * @return the hexadecimal color
	 */
	int getColor();
	
	/**
	 * Sets the hexadecimal color.
	 *
	 * @param color the hexadecimal color
	 */
	void setColor(int color);
}