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
}
