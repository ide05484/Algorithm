import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트개수

		long[] P = new long[101]; // 최대는 100
		P[1] = P[2] = P[3] = 1;
		P[4] = 2;

		for (int n = 5; n <= 100; n++) {
			P[n] = P[n - 1] + P[n - 5];
		}

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 몇번째 값 구하나요
			System.out.println(P[N]);
		} // 테케마감
	}// main마감
}