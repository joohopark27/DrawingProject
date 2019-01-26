import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Drawing drawing = new Drawing("src/Will.jpg");
		
		Rectangle rect = new Rectangle(0x0000ff, 100, 100, 200, 300);
		
		drawing.add(rect);
		drawing.refresh();
		
		scan.nextLine();
		
		drawing.clear();
		drawing.add(new Rectangle(0x00ff00, 10, 10, 100, 150));
		drawing.refresh();
	}
}