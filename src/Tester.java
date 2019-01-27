import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Drawing drawing = new Drawing("src/Will.jpg");
		
		ShapeGroup innerGroup = new ShapeGroup(3);
		innerGroup.add(new Rectangle(0x0000ff, 100, 100, 50, 80));
		innerGroup.add(new Rectangle(0x00ff00, 200, 150, 35, 60));
		innerGroup.add(new Rectangle(0xff0000, 400, 300, 75, 45));
		
		ShapeGroup outerGroup = new ShapeGroup(2);
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
	}
}