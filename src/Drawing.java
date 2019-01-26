//TODO Reassign accesses for all classes and methods

import java.util.ArrayList;
import java.util.Collection;

public class Drawing extends ArrayList<Drawable> {
	private DrawingBoard drawingBoard;
	private final String image;
	
	/**
	 * Constructs an empty Drawing with the specified initial capacity and the supplied image.
	 *
	 * @param image           the filepath of the image to be used
	 * @param initialCapacity the initial capacity of the list
	 *
	 * @throws IllegalArgumentException if the specified initial capacity
	 *                                  is negative
	 */
	public Drawing(String image, int initialCapacity) {
		super(initialCapacity);
		this.image = image;
		this.drawingBoard = new DrawingBoard(image);
	}
	
	/**
	 * Constructs a Drawing containing the elements of the specified
	 * collection, in the order they are returned by the collection's
	 * iterator, and the supplied image.
	 *
	 * @param image the filepath of the image to be used
	 * @param c     the collection whose elements are to be placed into this Drawing
	 *
	 * @throws NullPointerException if the specified collection is null
	 */
	public Drawing(String image, Collection<? extends Drawable> c) {
		super(c);
		this.image = image;
		this.drawingBoard = new DrawingBoard(image);
	}
	
	/**
	 * Constructs an empty Drawing with an initial capacity of 10 Drawables and the supplied image.
	 * @param image the filepath of the image to be used
	 */
	public Drawing(String image) {
		this.image = image;
		this.drawingBoard = new DrawingBoard(image);
	}
	
	//TODO Create constructors that accept length and width as parameters
	
	/**
	 * Updates the DrawingBoard based on the elements in this Drawing.
	 */
	public void refresh() {
		//TODO Make old DrawingBoard disappear when new one appears
		drawingBoard = new DrawingBoard(image);
		
		for (Drawable drawable : this) {
			drawable.drawOn(drawingBoard);
		}
		
		drawingBoard.setVisible(true);
	}
}