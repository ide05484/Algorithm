import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 수

		for (int tc = 1; tc <= T; tc++) {

			int A = sc.nextInt();
			int B = sc.nextInt(); // 두 수 주어짐

			System.out.println("Case #" + tc + ": " + A + " + " + B + " = " + (A + B));

		} // 테케마감
	}// main
}