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
		drawing.show();
		
		scan.nextLine();
		
		//Test moving ShapeGroups
		
		outerGroup.setX(120);
		System.out.println(outerGroup.getX());
		drawing.show();
		
		scan.nextLine();
		
		outerGroup.setX(0);
		outerGroup.setY(0);
		System.out.println(outerGroup.getX());
		System.out.println(outerGroup.getY());
		drawing.show();
		
		scan.nextLine();
		
		innerGroup.setY(300);
		System.out.println(innerGroup.getY());
		drawing.show();
		
		scan.nextLine();
		
		System.out.println(outerGroup.getX());
		((ShapeGroup) drawing.get(1)).get(0).setX(200);
		System.out.println(outerGroup.getX());
		drawing.add(new Square(0xff0000, 80, 275, 20));
		drawing.show();
		
		scan.nextLine();
		
		//Test ShapeGroup colors
		
		System.out.println(innerGroup.getColor());
		innerGroup.setColor(0xffffff);
		System.out.println(Integer.toHexString(innerGroup.getColor()));
		drawing.show();
		
		scan.nextLine();
		
		//Test changing Drawing image and dimensions
		
		drawing.setImage("src/Pope.jpg");
		drawing.show();
		
		scan.nextLine();
		
		drawing.setDimensions(300, 300);
		drawing.show();
		
		scan.nextLine();
		
		drawing.setDimensions(800, 800);
		drawing.show();
		
		scan.nextLine();
		
		drawing.setDimensions(-500, -400);
		drawing.show();
		
		scan.nextLine();
		
		//Test moving ShapeGroups offscreen
		
		drawing.setImage("src/Will.jpg");
		drawing.get(0).setX(-400);
		drawing.show();
		
		scan.nextLine();
		
		drawing.get(1).setX(320);
		drawing.show();
		
		scan.nextLine();
		
		//Test resizing Rectangles
		
		drawing.clear();
		Rectangle rectangle = new Rectangle(0x00ffff, 200, 400, 50, 60);
		drawing.add(rectangle);
		drawing.show();
		
		scan.nextLine();
		
		rectangle.setWidth(150);
		drawing.show();
		
		scan.nextLine();
		
		rectangle.setWidth(500);
		drawing.show();
		
		scan.nextLine();
		
		rectangle.setWidth(150);
		drawing.show();
		
		scan.nextLine();
		
		rectangle.setHeight(500);
		drawing.show();
		
		scan.nextLine();
		
		rectangle.setHeight(50);
		drawing.show();
		
		scan.nextLine();
		
		rectangle.setHeight(-200);
		drawing.show();
		
		scan.nextLine();
		
		//Test resizing Squares
		
		Square square = new Square(0x2938f0, 400, 200, 50);
		drawing.clear();
		drawing.add(square);
		drawing.show();
		
		scan.nextLine();
		
		square.setHeight(100);
		drawing.show();
		
		scan.nextLine();
		
		square.setWidth(25);
		drawing.show();
		
		scan.nextLine();
		
		square.setSideLength(75);
		drawing.show();
		
		scan.nextLine();
		
		//Test RightTriangles
		
		drawing.clear();
		drawing.add(new RightTriangle(0xff0000, 300, 200, 160, 80, "LL"));
		drawing.add(new RightTriangle(0x00ff00, 100, 300, 87, 148, "UR"));
		drawing.add(new RightTriangle(0x0000ff, 350, 350, 190, 104, "LR"));
		drawing.add(new RightTriangle(0xffff00, 50, 50, 99, 183, "UL"));
		drawing.show();
		
		scan.nextLine();
		
		//Test moving RightTriangles offscreen
		
		drawing.get(1).setY(500);
		drawing.show();
		
		scan.nextLine();
		
		drawing.get(2).setY(-20);
		drawing.show();
		
		scan.nextLine();
		
		//Test LineSegments
		
		drawing.clear();
		drawing.add(new LineSegment(0xff0000, 20, 20, 200, 200));
		drawing.add(new LineSegment(0x00ff00, 40, 20, 300, 200));
		drawing.add(new LineSegment(0xffff00, 20, 40, 200, 300));
		drawing.show();
		
		scan.nextLine();
		
		drawing.clear();
		drawing.add(new LineSegment(0xff0000, 400, 50, 50, 400));
		drawing.add(new LineSegment(0x00ff00, 400, 70, 300, 400));
		drawing.add(new LineSegment(0xffff00, 380, 50, 50, 150));
		drawing.show();
		
		scan.nextLine();
		
		drawing.clear();
		drawing.add(new LineSegment(0xff0000, 50, 400, 400, 50));
		drawing.add(new LineSegment(0x00ff00, 50, 380, 200, 50));
		drawing.add(new LineSegment(0xffff00, 70, 400, 400, 200));
		drawing.show();
		
		scan.nextLine();
		
		drawing.clear();
		drawing.add(new LineSegment(0xff0000, 400, 400, 50, 50));
		drawing.add(new LineSegment(0x00ff00, 400, 380, 300, 50));
		drawing.add(new LineSegment(0xffff00, 380, 400, 50, 300));
		drawing.show();
		
		scan.nextLine();
		
		drawing.clear();
		drawing.add(new LineSegment(0xff0000, 50, 50, 50, 400));
		drawing.add(new LineSegment(0x00ff00, 50, 400, 400, 400));
		drawing.add(new LineSegment(0xffff00, 400, 400, 400, 50));
		drawing.add(new LineSegment(0xff00ff, 400, 50, 50, 50));
		drawing.show();
		
		scan.nextLine();
		
		//Test moving LineSegments
		
		drawing.clear();
		LineSegment line = new LineSegment(0xff0000, 20, 20, 200, 200);
		drawing.add(line);
		drawing.show();
		
		scan.nextLine();
		
		line.setX1(300);
		line.setX2(25);
		line.setY1(145);
		line.setY2(335);
		drawing.show();
		
		scan.nextLine();
		
		line.setX(10);
		line.setY(10);
		drawing.show();
		
		scan.nextLine();
		
		//Test Circles
		
		drawing.clear();
		drawing.add(new Circle(0xff0000, 250, 250, 50));
		drawing.add(new Circle(0x00ff00, -50, 300, 100));
		drawing.add(new Circle(0xff00ff, 450, 450, 125));
		drawing.add(new Circle(0xffff00, 300, 100, -50));
		drawing.show();
		
		scan.nextLine();
		
		//Test GradientRectangles
		
		drawing.clear();
		GradientRectangle gradient = new GradientRectangle(0xff0000, 0xffff00, 250, 250, 100, 100);
		drawing.add(gradient);
		drawing.add(new GradientRectangle(0x029837, 0xe1a22c, 150, 300, 145, 65));
		drawing.add(new GradientRectangle(0x000000, 0xffffff, 500, 400, 75, 200));
		drawing.show();
		
		scan.nextLine();
		
		//Test recoloring Gradient Rectangles
		
		gradient.setColor1(0x00ff00);
		System.out.println(gradient.getColor());
		drawing.show();
		
		scan.nextLine();
		
		gradient.setColor2(0x0000ff);
		System.out.println(gradient.getColor());
		drawing.show();
		
		scan.nextLine();
		
		gradient.setColor(0x00ffff);
		System.out.println(Integer.toHexString(gradient.getColor()));
		drawing.show();
		
		scan.nextLine();
		
		//Draw Recognizer
		
		final int RED = 0xbb0000;
		final int BLUE = 0x0099ff;
		
		drawing.clear();
		drawing.setDimensions(1000, 875);
		
		ShapeGroup top = new ShapeGroup(7);
		
		ShapeGroup head = new ShapeGroup(2);
		head.add(new RightTriangle(RED, 300, 100, 93, 200, "LR"));
		head.add(new RightTriangle(RED, 500, 100, 93, 200, "LL"));
		top.add(head);
		
		top.add(new LineSegment(RED, 95, 220, 905, 220));
		
		ShapeGroup shoulders = new ShapeGroup(2);
		shoulders.add(new Square(RED, 95, 245, 120));
		shoulders.add(new Square(RED, 785, 245, 120));
		top.add(shoulders);
		
		ShapeGroup chest = new ShapeGroup(3);
		chest.add(new RightTriangle(RED, 265, 245, 90, 60, "UR"));
		chest.add(new Rectangle(RED, 325, 245, 90, 350));
		chest.add(new RightTriangle(RED, 675, 245, 90, 60, "UL"));
		top.add(chest);
		
		top.add(new LineSegment(RED, 230, 305, 275, 305));
		top.add(new LineSegment(RED, 725, 305, 770, 305));
		
		top.add(new LineSegment(RED, 418, 356, 578, 356));
		
		drawing.add(top);
		
		ShapeGroup bottom = new ShapeGroup(4);
		
		ShapeGroup leftLeg = new ShapeGroup(3);
		leftLeg.add(new GradientRectangle(RED, BLUE, 95, 420, 300, 120));
		leftLeg.add(new Rectangle(BLUE, 95, 720, 50, 120));
		leftLeg.add(new RightTriangle(BLUE, 215, 720, 50, 95, "LL"));
		bottom.add(leftLeg);
		
		ShapeGroup rightLeg = new ShapeGroup(3);
		rightLeg.add(new GradientRectangle(RED, BLUE, 785, 420, 300, 120));
		rightLeg.add(new Rectangle(BLUE, 785, 720, 50, 120));
		rightLeg.add(new RightTriangle(BLUE, 690, 720, 50, 95, "LR"));
		bottom.add(rightLeg);
		
		bottom.add(new LineSegment(RED, 95, 392, 905, 392));
		
		bottom.add(new LineSegment(RED, 418, 425, 578, 425));
		
		drawing.add(bottom);
		
		drawing.show();
	}
}