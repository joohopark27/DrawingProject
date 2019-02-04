//Reviewed by Aymil 1/29/19

import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Drawing drawing = new Drawing("src/Will.jpg");
		
		//Test making ShapeGroups
		
		ShapeGroup innerGroup = new ShapeGroup(3);
		innerGroup.add(new Rectangle(0x0000ff, 100, 100, 50, 80));
		innerGroup.add(new GradientRectangle(0x00ff00, 0x924de7, 200, 150, 85, 60));
		innerGroup.add(new Circle(0xff0000, 350, 100, 75));
		
		ShapeGroup outerGroup = new ShapeGroup();
		outerGroup.add(new RightTriangle(0xffff00, 20, 340, 173, 125, "UL"));
		outerGroup.add(innerGroup);
		
		drawing.add(new Square(0xff00ff, 280, 320, 150));
		drawing.add(outerGroup);
		drawing.refresh();
		
		scan.nextLine();
		
		//Test moving ShapeGroups
		
		outerGroup.setX(120);
		drawing.refresh();
		
		scan.nextLine();
		
		innerGroup.setY(175);
		drawing.refresh();
		
		scan.nextLine();
		
		//Test ShapeGroup colors
		
		System.out.println(innerGroup.getColor());
		innerGroup.setColor(0xffffff);
		System.out.println(Integer.toHexString(innerGroup.getColor()));
		drawing.refresh();
		
		scan.nextLine();
		
		((ShapeGroup) drawing.get(1)).get(0).setX(0);
		drawing.refresh();
		
		scan.nextLine();
		
		//Test changing Drawing image and dimensions
		
		drawing.setImage("src/Pope.jpg");
		drawing.refresh();
		
		scan.nextLine();
		
		drawing.setDimensions(300, 300);
		drawing.refresh();
		
		scan.nextLine();
		
		drawing.setDimensions(800, 800);
		drawing.refresh();
		
		scan.nextLine();
		
		drawing.setDimensions(-500, -400);
		drawing.refresh();
		
		scan.nextLine();
		
		//Test moving ShapeGroups offscreen
		
		drawing.setImage("src/Will.jpg");
		drawing.get(0).setX(-400);
		drawing.refresh();
		
		scan.nextLine();
		
		drawing.get(1).setX(250);
		drawing.refresh();
		
		scan.nextLine();
		
		//Test resizing Rectangles
		
		drawing.clear();
		Rectangle rectangle = new Rectangle(0x00ffff, 200, 400, 50, 60);
		drawing.add(rectangle);
		drawing.refresh();
		
		scan.nextLine();
		
		rectangle.setWidth(150);
		drawing.refresh();
		
		scan.nextLine();
		
		rectangle.setWidth(500);
		drawing.refresh();
		
		scan.nextLine();
		
		rectangle.setWidth(150);
		drawing.refresh();
		
		scan.nextLine();
		
		rectangle.setHeight(500);
		drawing.refresh();
		
		scan.nextLine();
		
		rectangle.setHeight(50);
		drawing.refresh();
		
		scan.nextLine();
		
		rectangle.setHeight(-200);
		drawing.refresh();
		
		scan.nextLine();
		
		//Test resizing Squares
		
		Square square = new Square(0x2938f0, 400, 200, 50);
		drawing.clear();
		drawing.add(square);
		drawing.refresh();
		
		scan.nextLine();
		
		square.setHeight(100);
		drawing.refresh();
		
		scan.nextLine();
		
		square.setWidth(25);
		drawing.refresh();
		
		scan.nextLine();
		
		square.setSideLength(75);
		drawing.refresh();
		
		scan.nextLine();
		
		//Test RightTriangles
		
		drawing.clear();
		drawing.add(new RightTriangle(0xff0000, 300, 200, 160, 80, "LL"));
		drawing.add(new RightTriangle(0x00ff00, 100, 300, 87, 148, "UR"));
		drawing.add(new RightTriangle(0x0000ff, 350, 350, 190, 104, "LR"));
		drawing.add(new RightTriangle(0xffff00, 50, 50, 99, 183, "UL"));
		drawing.refresh();
		
		scan.nextLine();
		
		//Test moving RightTriangles offscreen
		
		drawing.get(1).setY(500);
		drawing.refresh();
		
		scan.nextLine();
		
		drawing.get(2).setY(-20);
		drawing.refresh();
		
		scan.nextLine();
		
		//Test LineSegments
		
		drawing.clear();
		drawing.add(new LineSegment(0xff0000, 20, 20, 200, 200));
		drawing.add(new LineSegment(0x00ff00, 40, 20, 300, 200));
		drawing.add(new LineSegment(0xffff00, 20, 40, 200, 300));
		drawing.refresh();
		
		scan.nextLine();
		
		drawing.clear();
		drawing.add(new LineSegment(0xff0000, 400, 50, 50, 400));
		drawing.add(new LineSegment(0x00ff00, 400, 70, 300, 400));
		drawing.add(new LineSegment(0xffff00, 380, 50, 50, 150));
		drawing.refresh();
		
		scan.nextLine();
		
		drawing.clear();
		drawing.add(new LineSegment(0xff0000, 50, 400, 400, 50));
		drawing.add(new LineSegment(0x00ff00, 50, 380, 200, 50));
		drawing.add(new LineSegment(0xffff00, 70, 400, 400, 200));
		drawing.refresh();
		
		scan.nextLine();
		
		drawing.clear();
		drawing.add(new LineSegment(0xff0000, 400, 400, 50, 50));
		drawing.add(new LineSegment(0x00ff00, 400, 380, 300, 50));
		drawing.add(new LineSegment(0xffff00, 380, 400, 50, 300));
		drawing.refresh();
		
		scan.nextLine();
		
		drawing.clear();
		drawing.add(new LineSegment(0xff0000, 50, 50, 50, 400));
		drawing.add(new LineSegment(0x00ff00, 50, 400, 400, 400));
		drawing.add(new LineSegment(0xffff00, 400, 400, 400, 50));
		drawing.add(new LineSegment(0xff00ff, 400, 50, 50, 50));
		drawing.refresh();
		
		scan.nextLine();
		
		//Test moving LineSegments
		
		drawing.clear();
		LineSegment line = new LineSegment(0xff0000, 20, 20, 200, 200);
		drawing.add(line);
		drawing.refresh();
		
		scan.nextLine();
		
		line.setX1(300);
		line.setX2(25);
		line.setY1(145);
		line.setY2(335);
		drawing.refresh();
		
		scan.nextLine();
		
		line.setX(10);
		line.setY(10);
		drawing.refresh();
		
		scan.nextLine();
		
		//Test Circles
		
		drawing.clear();
		drawing.add(new Circle(0xff0000, 250, 250, 50));
		drawing.add(new Circle(0x00ff00, -50, 300, 100));
		drawing.add(new Circle(0xff00ff, 450, 450, 125));
		drawing.add(new Circle(0xffff00, 300, 100, -50));
		drawing.refresh();
		
		scan.nextLine();
		
		//Test GradientRectangles
		
		drawing.clear();
		GradientRectangle gradient = new GradientRectangle(0xff0000, 0xffff00, 250, 250, 100, 100);
		drawing.add(gradient);
		drawing.add(new GradientRectangle(0x029837, 0xe1a22c, 150, 300, 145, 65));
		drawing.add(new GradientRectangle(0x000000, 0xffffff, 500, 400, 75, 200));
		drawing.refresh();
		
		scan.nextLine();
		
		//Test recoloring Gradient Rectangles
		
		gradient.setColor1(0x00ff00);
		drawing.refresh();
		
		scan.nextLine();
		
		gradient.setColor2(0x0000ff);
		drawing.refresh();
		
		scan.nextLine();
		
		gradient.setColor(0x00ffff);
		drawing.refresh();
	}
}