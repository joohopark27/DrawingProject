public interface Drawable {
	//TODO Add JavaDocs
	
	// Draws the object on DrawingBoard db
	void drawOn(DrawingBoard db);
	
	// Returns true if the object falls entirely within DrawingBoard db
	boolean within(DrawingBoard db);
	
	int getX();
	
	void setX(int x);
	
	int getY();
	
	void setY(int y);
	
	int getColor();
	
	void setColor(int color);
}