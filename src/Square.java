public class Square extends Rectangle {
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
	
	@Override
	public void setWidth(int sideLength) {
		setSideLength(sideLength);
	}
}
