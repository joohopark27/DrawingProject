//TODO Reassign accesses for all classes and methods
//TODO (At End) Fix all JavaDocs

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
	
	public void setImage(String image) {
		this.image = image;
		usesImage = true;
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
	
	//TODO Create constructors that accept length and width as parameters
	
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
	 * Constructs an empty list with the specified initial capacity.
	 *
	 * @param initialCapacity the initial capacity of the list
	 *
	 * @throws IllegalArgumentException if the specified initial capacity is negative
	 */
	public Drawing(int width, int height, int initialCapacity) {
		super(initialCapacity);
		setDimensions(width, height);
	}
	
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
	 * Constructs an empty list with an initial capacity of ten.
	 */
	public Drawing(int width, int height) {
		setDimensions(width, height);
	}
	
	/**
	 * Constructs a list containing the elements of the specified collection, in the order they are returned by the
	 * collection's iterator.
	 *
	 * @param c the collection whose elements are to be placed into this list
	 *
	 * @throws NullPointerException if the specified collection is null
	 */
	public Drawing(int width, int height, Collection<? extends Drawable> c) {
		super(c);
		setDimensions(width, height);
	}
	
	/**
	 * Updates the DrawingBoard based on the elements in this Drawing.
	 */
	public void refresh() {
		//TODO Make old DrawingBoard disappear when new one appears
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