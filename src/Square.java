public class Square extends Rectangle {
	/**
	 * Constructs a Square.
	 *
	 * @param color      the hexadecimal color
	 * @param x          the x coordinate of the upper left corner
	 * @param y          the y coordinate of the upper left corner
	 * @param sideLength the side length
	 */
	public Square(int color, int x, int y, int sideLength) {
		super(color, x, y, sideLength, sideLength);
	}
	
	/**
	 * Sets the side length. Both width and height.
	 *
	 * @param sideLength the sideLength
	 */
	@Override
	public void setHeight(int sideLength) {
		setSideLength(sideLength);
	}
	
	/**
	 * Sets the side length. Both width and height.
	 *
	 * @param sideLength the sideLength
	 */
	@Override
	public void setWidth(int sideLength) {
		setSideLength(sideLength);
	}
	
	/**
	 * Sets the side length.
	 *
	 * @param sideLength the side length
	 */
	public void setSideLength(int sideLength) {
		super.setWidth(sideLength);
		super.setHeight(sideLength);
	}
	
	/**
	 * Gets the side length.
	 *
	 * @return the side length
	 */
	public int getSideLength() {
		return getHeight();
	}
}
