import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Drawing drawing = new Drawing("src/Will.jpg");
		
		drawing.add(new Rectangle(0x00ff00, 100, 100, 200, 300));
	}
}