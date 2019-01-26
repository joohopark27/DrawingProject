import java.util.ArrayList;

public class ShapeGroup extends ArrayList<Drawable> implements Drawable {
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
	
	//TODO Implement the manipulation methods from Drawable
	
	@Override
	public int getX() {
		return 0;
	}
	
	@Override
	public void setX(int x) {
	
	}
	
	@Override
	public int getY() {
		return 0;
	}
	
	@Override
	public void setY(int y) {
	
	}
	
	/**
	 * Get's the color of this ShapeGroup, only if the color of every element in it is the same.
	 *
	 * @return the color of every element if they're the same, otherwise -1.
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
