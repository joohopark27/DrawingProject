import java.util.ArrayList;
import java.util.Collection;

public class ShapeGroup extends ArrayList<Drawable> implements Drawable {
	private int x;
	private int y;
	
	/**
	 * Constructs an empty ShapeGroup with the specified initial capacity.
	 *
	 * @param initialCapacity the initial capacity of the ShapeGroup
	 *
	 * @throws IllegalArgumentException if the specified initial capacity is negative
	 */
	public ShapeGroup(int initialCapacity) {
		super(initialCapacity);
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * Constructs an empty ShapeGroup with an initial capacity of ten.
	 */
	public ShapeGroup() {
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * Constructs a ShapeGroup containing the elements of the specified collection, in the order they are returned by
	 * the collection's iterator.
	 *
	 * @param c the collection whose elements are to be placed into this ShapeGroup
	 *
	 * @throws NullPointerException if the specified collection is null
	 */
	public ShapeGroup(Collection<? extends Drawable> c) {
		super(c);
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * Draws all of the elements in this ShapeGroup onto the specified DrawingBoard.
	 *
	 * @param drawingBoard the DrawingBoard to draw onto
	 */
	@Override
	public void drawOn(DrawingBoard drawingBoard) {
		for (Drawable drawable : this) {
			drawable.drawOn(drawingBoard);
		}
	}
	
	/**
	 * Determines if all of the elements in this ShapeGroup will fall entirely within the DrawingBoard.
	 *
	 * @param drawingBoard the DrawingBoard to test against
	 *
	 * @return true if all of the elements in this ShapeGroup fall entirely within the DrawingBoard, otherwise false
	 */
	@Override
	public boolean within(DrawingBoard drawingBoard) {
		for (Drawable drawable : this) {
			if (!drawable.within(drawingBoard)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Gets the x coordinate of the upper left corner. By default it's zero.
	 *
	 * @return the x coordinate of the upper left corner
	 */
	@Override
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the x coordinate of the upper left corner. Also moves all elements of this ShapeGroup by the amount the
	 * ShapeGroup itself has moved.
	 *
	 * @param x the x coordinate of the upper left corner
	 */
	@Override
	public void setX(int x) {
		int adjustment = x - this.x;
		
		for (Drawable drawable : this) {
			drawable.setX(drawable.getX() + adjustment);
		}
		
		this.x = x;
	}
	
	/**
	 * Gets the y coordinate of the upper left corner. By default it's zero.
	 *
	 * @return the y coordinate of the upper left corner
	 */
	@Override
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y coordinate of the upper left corner. Also moves all elements of this ShapeGroup by the amount the
	 * ShapeGroup itself has moved.
	 *
	 * @param y the y coordinate of the upper left corner
	 */
	@Override
	public void setY(int y) {
		int adjustment = y - this.y;
		
		for (Drawable drawable : this) {
			drawable.setY(drawable.getY() + adjustment);
		}
		
		this.y = y;
	}
	
	/**
	 * Gets the color of every element in this ShapeGroup, only if the color of every element is the same.
	 *
	 * @return the color of every element only if they're all the same, otherwise -1
	 */
	@Override
	public int getColor() {
		int firstColor = get(0).getColor();
		
		for (Drawable drawable : this) {
			if (drawable.getColor() != firstColor) {
				return -1;
			}
		}
		
		return firstColor;
	}
	
	/**
	 * Sets the color of ever element in this ShapeGroup.
	 *
	 * @param color the hexadecimal color
	 */
	@Override
	public void setColor(int color) {
		for (Drawable drawable : this) {
			drawable.setColor(color);
		}
	}
}
