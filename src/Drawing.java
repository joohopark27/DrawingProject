//TODO (At End) Reassign accesses for all classes and methods

import java.util.ArrayList;
import java.util.Collection;

public class Drawing extends ArrayList<Drawable> {
	private DrawingBoard drawingBoard;
	private String image;
	private int width;
	private int height;
	private boolean usesImage;
	
	/**
	 * Constructs an empty Drawing with the specified initial capacity and the supplied image.
	 *
	 * @param image           the filepath of the image to be used
	 * @param initialCapacity the initial capacity of the list
	 *
	 * @throws NullPointerException     if the filepath is invalid
	 * @throws IllegalArgumentException if the specified initial capacity is negative
	 */
	public Drawing(String image, int initialCapacity) {
		super(initialCapacity);
		setImage(image);
	}
	
	/**
	 * Constructs a Drawing containing the elements of the specified collection, in the order they are returned by the
	 * collection's iterator, and the supplied image.
	 *
	 * @param image the filepath of the image to be used
	 * @param c     the collection whose elements are to be placed into this Drawing
	 *
	 * @throws NullPointerException if the filepath is invalid
	 * @throws NullPointerException if the specified collection is null
	 */
	public Drawing(String image, Collection<? extends Drawable> c) {
		super(c);
		setImage(image);
	}
	
	/**
	 * Constructs an empty Drawing with an initial capacity of 10 Drawables and the supplied image.
	 *
	 * @param image the filepath of the image to be used
	 *
	 * @throws NullPointerException if the filepath is invalid
	 */
	public Drawing(String image) {
		setImage(image);
	}
	
	/**
	 * Constructs a blank and empty Drawing with the specified initial capacity and specified dimensions.
	 *
	 * @param width           the width of the Drawing
	 * @param height          the height of the Drawing
	 * @param initialCapacity the initial capacity of the Drawing
	 *
	 * @throws IllegalArgumentException if the specified initial capacity is negative
	 */
	public Drawing(int width, int height, int initialCapacity) {
		super(initialCapacity);
		setDimensions(width, height);
	}
	
	/**
	 * Sets the dimensions of the Drawing. Removes the background image if there was one.
	 *
	 * @param width  the width of the Drawing
	 * @param height the height of the Drawing
	 */
	public void setDimensions(int width, int height) {
		if (height > 0) {
			this.height = height;
		} else {
			this.height = 1;
		}
		
		if (width > 0) {
			this.width = width;
		} else {
			this.width = 1;
		}
		
		usesImage = false;
	}
	
	/**
	 * Constructs a blank and empty Drawing with an initial capacity of ten and the specified dimensions.
	 *
	 * @param width  the width of the Drawing
	 * @param height the height of the Drawing
	 */
	public Drawing(int width, int height) {
		setDimensions(width, height);
	}
	
	/**
	 * Constructs a blank Drawing containing the elements of the specified collection, in the order they are returned by
	 * the collection's iterator.
	 *
	 * @param width  the width of the Drawing
	 * @param height the height of the Drawing
	 * @param c      the collection whose elements are to be placed into this list
	 *
	 * @throws NullPointerException if the specified collection is null
	 */
	public Drawing(int width, int height, Collection<? extends Drawable> c) {
		super(c);
		setDimensions(width, height);
	}
	
	/**
	 * Changes the background image of the Drawing. Adds one if there wasn't one already.
	 *
	 * @param image the filepath of the image to be used
	 *
	 * @throws NullPointerException if the filepath is invalid
	 */
	public void setImage(String image) {
		this.image = image;
		usesImage = true;
	}
	
	/**
	 * Renders the Drawing based on its current attributes.
	 */
	public void refresh() {
		//TODO (Ask Coupland) Make old DrawingBoard disappear when new one appears
		if (usesImage) {
			drawingBoard = new DrawingBoard(image);
		} else {
			drawingBoard = new DrawingBoard(width, height);
		}
		
		for (Drawable drawable : this) {
			drawable.drawOn(drawingBoard);
		}
		
		drawingBoard.setVisible(true);
	}
}