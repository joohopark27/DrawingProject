public class GradientRectangle extends Rectangle {
	private int color2;
	
	/**
	 * Constructs a GradientRectangle.
	 *
	 * @param color  the hexadecimal color of the top of the rectangle
	 * @param color2 the hexadecimal color of the bottom of the rectangle
	 * @param x      the x coordinate of the upper left corner
	 * @param y      the y coordinate of the upper left corner
	 * @param height the height
	 * @param width  the width
	 */
	public GradientRectangle(int color, int color2, int x, int y, int height, int width) {
		super(color, x, y, height, width);
		setColor2(color2);
	}
	
	@Override
	protected void drawPixel(int color, int row, int column, DrawingBoard drawingBoard) {
		final int newRed = (int) (redSlope() * (row - getY())) + getRed();
		final int newGreen = (int) (greenSlope() * (row - getY())) + getGreen();
		final int newBlue = (int) (blueSlope() * (row - getY())) + getBlue();
		
		final int newColor = newRed + newGreen * 0x000100 + newBlue * 0x010000;
		
		super.drawPixel(newColor, row, column, drawingBoard);
	}
	
	private double redSlope() {
		return (double) (getRed2() - getRed()) / getHeight();
	}
	
	private int getRed() {
		return getColor() % 0x000100;
	}
	
	private double greenSlope() {
		return (double) (getGreen2() - getGreen()) / getHeight();
	}
	
	private int getGreen() {
		return getColor() / 0x000100 % 0x000100;
	}
	
	private double blueSlope() {
		return (double) (getBlue2() - getBlue()) / getHeight();
	}
	
	private int getBlue() {
		return getColor() / 0x010000 % 0x000100;
	}
	
	private int getRed2() {
		return getColor2() % 0x000100;
	}
	
	private int getGreen2() {
		return getColor2() / 0x000100 % 0x000100;
	}
	
	private int getBlue2() {
		return getColor2() / 0x010000 % 0x000100;
	}
	
	/**
	 * Gets the bottom color.
	 *
	 * @return the bottom color
	 */
	public int getColor2() {
		return color2;
	}
	
	/**
	 * Sets the bottom color.
	 *
	 * @param color2 the bottom color
	 */
	public void setColor2(int color2) {
		this.color2 = color2;
	}
}