import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테케 개수

		int[] dp = new int[11]; // 해당 수를 구할때까지의 작은 문제들 배열
		// N은 양수이며 11보다 작으니 최대 배열크기는 10+1

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		// 1 2 3 배열

		for (int n = 4; n <= 10; n++) {
			dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3];
			//1을 더하는 경우의수 + 2를 더하는 경우의 수 + 3을 더하는 경우의 수
		}

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 주어지는 정수
			System.out.println(dp[N]);
		} // 테케마감
	}
}