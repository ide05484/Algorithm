import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt(); // 분자
		int B = sc.nextInt(); // 분모

		int N = sc.nextInt(); // 몇번째 자리?

		while (N > 0) {
			A %= B;
			A *= 10;
			N--;
		}

		System.out.println(A / B);
	}
}