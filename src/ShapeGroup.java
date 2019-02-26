import java.util.ArrayList;
import java.util.Collection;

public class ShapeGroup extends ArrayList<Drawable> implements Drawable {
	/**
	 * Constructs an empty ShapeGroup with the specified initial capacity.
	 *
	 * @param initialCapacity the initial capacity of the ShapeGroup
	 *
	 * @throws IllegalArgumentException if the specified initial capacity is negative
	 */
	public ShapeGroup(int initialCapacity) {
		super(initialCapacity);
	}
	
	/**
	 * Constructs an empty ShapeGroup with an initial capacity of ten.
	 */
	public ShapeGroup() {
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
	 * Gets the x coordinate of the upper left corner. Returns 0 if this ShapeGroup is empty.
	 *
	 * @return the x coordinate of the upper left corner
	 */
	@Override
	public int getX() {
		int x;
		
		try {
			x = get(0).getX();
		} catch (IndexOutOfBoundsException exception) {
			x = 0;
		}
		
		for (Drawable drawable : this) {
			x = Integer.min(x, drawable.getX());
		}
		
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
		final int adjustment = x - getX();
		
		for (Drawable drawable : this) {
			drawable.setX(drawable.getX() + adjustment);
		}
	}
	
	/**
	 * Gets the y coordinate of the upper left corner. Returns 0 if this ShapeGroup is empty.
	 *
	 * @return the y coordinate of the upper left corner
	 */
	@Override
	public int getY() {
		int y;
		
		try {
			y = get(0).getY();
		} catch (IndexOutOfBoundsException exception) {
			y = 0;
		}
		
		for (Drawable drawable : this) {
			y = Integer.min(y, drawable.getY());
		}
		
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
		final int adjustment = y - getY();
		
		for (Drawable drawable : this) {
			drawable.setY(drawable.getY() + adjustment);
		}
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
