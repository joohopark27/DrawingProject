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
	
	@Override
	public void drawOn(DrawingBoard drawingBoard) {
		for (Drawable drawable : this) {
			drawable.drawOn(drawingBoard);
		}
	}
	
	@Override
	public boolean within(DrawingBoard drawingBoard) {
		for (Drawable drawable : this) {
			if (!drawable.within(drawingBoard)) {
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public int getX() {
		return x;
	}
	
	@Override
	public void setX(int x) {
		int adjustment = x - this.x;
		
		for (Drawable drawable : this) {
			drawable.setX(drawable.getX() + adjustment);
		}
		
		this.x = x;
	}
	
	@Override
	public int getY() {
		return y;
	}
	
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
	 * @return the color of every element if they're the same, or -1.
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
	
	@Override
	public void setColor(int color) {
		for (Drawable drawable : this) {
			drawable.setColor(color);
		}
	}
}
