import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Drawing drawing = new Drawing("src/Will.jpg");
		
		ShapeGroup innerGroup = new ShapeGroup(3);
		innerGroup.add(new Rectangle(0x0000ff, 100, 100, 50, 80));
		innerGroup.add(new Rectangle(0x00ff00, 200, 150, 35, 60));
		innerGroup.add(new Rectangle(0xff0000, 400, 300, 75, 45));
		
		ShapeGroup outerGroup = new ShapeGroup();
		outerGroup.add(new Rectangle(0xffff00, 300, 200, 30, 55));
		outerGroup.add(innerGroup);
		
		drawing.add(new Square(0xff00ff, 450, 400, 20));
		drawing.add(outerGroup);
		drawing.refresh();
		
		scan.nextLine();
		
		outerGroup.setX(100);
		drawing.refresh();
		
		scan.nextLine();
		
		innerGroup.setY(150);
		drawing.refresh();
		
		scan.nextLine();
		
		System.out.println(innerGroup.getColor());
		innerGroup.setColor(0xffffff);
		System.out.println(innerGroup.getColor());
		drawing.refresh();
		
		scan.nextLine();
		
		((ShapeGroup) drawing.get(1)).get(0).setX(0);
		drawing.refresh();
		
		scan.nextLine();
		
		drawing.setImage("src/Pope.jpg");
		drawing.refresh();
		
		scan.nextLine();
		
		drawing.setDimensions(300, 300);
		drawing.refresh();
		
		scan.nextLine();
		
		drawing.setDimensions(800, 800);
		drawing.refresh();
		
		scan.nextLine();
		
		drawing.setImage("src/Will.jpg");
		drawing.refresh();
		
		scan.nextLine();
		
		drawing.get(0).setX(-400);
		drawing.refresh();
		
		scan.nextLine();
		
		drawing.get(1).setX(-400);
		drawing.refresh();
		
		scan.nextLine();
		
		drawing.setDimensions(-500, -400);
		drawing.refresh();
		
		scan.nextLine();
		
		Rectangle rectangle = new Rectangle(0x00ffff, 200, 400, 50, 60);
		drawing.clear();
		drawing.add(rectangle);
		drawing.setImage("src/Will.jpg");
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
	}
}