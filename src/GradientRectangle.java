public class GradientRectangle extends Rectangle {
	private int color2;
	
	/**
	 * Constructs a GradientRectangle.
	 *
	 * @param color1 the hexadecimal color of the top of the rectangle
	 * @param color2 the hexadecimal color of the bottom of the rectangle
	 * @param x      the x coordinate of the upper left corner
	 * @param y      the y coordinate of the upper left corner
	 * @param height the height
	 * @param width  the width
	 */
	public GradientRectangle(int color1, int color2, int x, int y, int height, int width) {
		super(color1, x, y, height, width);
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
	
	private double greenSlope() {
		return (double) (getGreen2() - getGreen()) / getHeight();
	}
	
	private int getGreen() {
		return getColor1() / 0x000100 % 0x000100;
	}
	
	/**
	 * Gets the top color.
	 *
	 * @return the top color
	 */
	public int getColor1() {
		return super.getColor();
	}
	
	/**
	 * Sets the top color.
	 *
	 * @param color1 the top color
	 */
	public void setColor1(int color1) {
		super.setColor(color1);
	}
	
	private double blueSlope() {
		return (double) (getBlue2() - getBlue()) / getHeight();
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
	
	private int getBlue() {
		return getColor1() / 0x010000 % 0x000100;
	}
	
	private int getRed() {
		return getColor1() % 0x000100;
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
	
	/**
	 * Gets the hexadecimal color of the entire rectangle only if it is the same color all the way through.
	 *
	 * @return the hexadecimal color if the color is the same all the way through, otherwise -1
	 */
	@Override
	public int getColor() {
		if (getColor1() == getColor2()) {
			return getColor1();
		} else {
			return -1;
		}
	}
	
	/**
	 * Sets the hexadecimal color of the entire rectangle.
	 *
	 * @param color the hexadecimal color
	 */
	@Override
	public void setColor(int color) {
		setColor1(color);
		setColor2(color);
	}
}