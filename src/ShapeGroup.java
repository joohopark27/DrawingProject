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
	
	@Override
	public int getColor() {
		return 0;
	}
	
	@Override
	public void setColor(int color) {
	
	}
}
