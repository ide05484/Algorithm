import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		if (B + C >= 60) {
			System.out.print(((A + ((B + C) / 60)) % 24));
			System.out.println(" " + (B + C) % 60);
		} else if (B + C < 60) {
			System.out.print((A % 24));
			System.out.println(" " + (B + C));
		}

	}
}
