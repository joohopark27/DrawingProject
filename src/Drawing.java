//TODO Reassign accesses for all classes and methods

import java.util.ArrayList;
import java.util.Collection;

/*
TODO Change the wording of these JavaDocs
TODO Cut out unnecessary methods and double check that the ones necessary are there
*/
public class Drawing extends ArrayList<Drawable> {
	private String image;
	private DrawingBoard drawingBoard;
	
	/**
	 * Constructs an empty list with the specified initial capacity.
	 *
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
	 * Constructs an empty list with an initial capacity of ten.
	 */
	public Drawing(String image) {
		this.image = image;
		this.drawingBoard = new DrawingBoard(image);
	}
	
	/**
	 * Replaces the element at the specified position in this list with
	 * the specified element.
	 *
	 * @param index   index of the element to replace
	 * @param element element to be stored at the specified position
	 *
	 * @return the element previously at the specified position
	 *
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	@Override
	public Drawable set(int index, Drawable element) {
		Drawable output = super.set(index, element);
		refresh();
		return output;
	}
	
	/**
	 * Creates a new DrawingBoard, then draws the entire contents of this instance of Drawing onto it.
	 */
	private void refresh() {
		//TODO Make old DrawingBoard disappear when new one appears
		
		for (Drawable drawable : this) {
			drawable.drawOn(drawingBoard);
		}
		
		drawingBoard.setVisible(true);
	}
	
	/**
	 * Appends the specified element to the end of this list.
	 *
	 * @param drawable element to be appended to this list
	 *
	 * @return {@code true} (as specified by {@link Collection#add})
	 */
	@Override
	public boolean add(Drawable drawable) {
		boolean output = super.add(drawable);
		refresh();
		return output;
	}
	
	/**
	 * Inserts the specified element at the specified position in this
	 * list. Shifts the element currently at that position (if any) and
	 * any subsequent elements to the right (adds one to their indices).
	 *
	 * @param index   index at which the specified element is to be inserted
	 * @param element element to be inserted
	 *
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	@Override
	public void add(int index, Drawable element) {
		super.add(index, element);
		refresh();
	}
	
	/**
	 * Removes the element at the specified position in this list.
	 * Shifts any subsequent elements to the left (subtracts one from their
	 * indices).
	 *
	 * @param index the index of the element to be removed
	 *
	 * @return the element that was removed from the list
	 *
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	@Override
	public Drawable remove(int index) {
		Drawable output = super.remove(index);
		refresh();
		return output;
	}
	
	/**
	 * Removes the first occurrence of the specified element from this list,
	 * if it is present.  If the list does not contain the element, it is
	 * unchanged.  More formally, removes the element with the lowest index
	 * {@code i} such that
	 * {@code Objects.equals(o, get(i))}
	 * (if such an element exists).  Returns {@code true} if this list
	 * contained the specified element (or equivalently, if this list
	 * changed as a result of the call).
	 *
	 * @param o element to be removed from this list, if present
	 *
	 * @return {@code true} if this list contained the specified element
	 */
	@Override
	public boolean remove(Object o) {
		boolean output = super.remove(o);
		refresh();
		return output;
	}
	
	/**
	 * Removes all of the elements from this list.  The list will
	 * be empty after this call returns.
	 */
	@Override
	public void clear() {
		super.clear();
		refresh();
	}
	
	/**
	 * Appends all of the elements in the specified collection to the end of
	 * this list, in the order that they are returned by the
	 * specified collection's Iterator.  The behavior of this operation is
	 * undefined if the specified collection is modified while the operation
	 * is in progress.  (This implies that the behavior of this call is
	 * undefined if the specified collection is this list, and this
	 * list is nonempty.)
	 *
	 * @param c collection containing elements to be added to this list
	 *
	 * @return {@code true} if this list changed as a result of the call
	 *
	 * @throws NullPointerException if the specified collection is null
	 */
	@Override
	public boolean addAll(Collection<? extends Drawable> c) {
		boolean output = super.addAll(c);
		refresh();
		return output;
	}
	
	/**
	 * Inserts all of the elements in the specified collection into this
	 * list, starting at the specified position.  Shifts the element
	 * currently at that position (if any) and any subsequent elements to
	 * the right (increases their indices).  The new elements will appear
	 * in the list in the order that they are returned by the
	 * specified collection's iterator.
	 *
	 * @param index index at which to insert the first element from the
	 *              specified collection
	 * @param c     collection containing elements to be added to this list
	 *
	 * @return {@code true} if this list changed as a result of the call
	 *
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 * @throws NullPointerException      if the specified collection is null
	 */
	@Override
	public boolean addAll(int index, Collection<? extends Drawable> c) {
		boolean output = super.addAll(index, c);
		refresh();
		return output;
	}
	
	/**
	 * Removes from this list all of its elements that are contained in the
	 * specified collection.
	 *
	 * @param c collection containing elements to be removed from this list
	 *
	 * @return {@code true} if this list changed as a result of the call
	 *
	 * @throws ClassCastException   if the class of an element of this list
	 *                              is incompatible with the specified collection
	 *                              (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if this list contains a null element and the
	 *                              specified collection does not permit null elements
	 *                              (<a href="Collection.html#optional-restrictions">optional</a>),
	 *                              or if the specified collection is null
	 * @see Collection#contains(Object)
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		boolean output = super.removeAll(c);
		refresh();
		return output;
	}
}