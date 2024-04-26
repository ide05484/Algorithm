import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 집의 개수

		int[][] home = new int[N + 1][3];

		for (int n = 1; n <= N; n++) {
			home[n][0] = sc.nextInt();
			home[n][1] = sc.nextInt();
			home[n][2] = sc.nextInt();
			// 각 색깔에 맞는 비용 받기
		}

		int[][] dp = new int[N + 1][3]; // 이전 집까지의 최소 비용을 저장하기 위한 DP 배열

		// 초기값 설정
		dp[1][0] = home[1][0];
		dp[1][1] = home[1][1];
		dp[1][2] = home[1][2];

		for (int n = 2; n <= N; n++) {
			dp[n][0] = Math.min(dp[n - 1][1], dp[n - 1][2]) + home[n][0];
			dp[n][1] = Math.min(dp[n - 1][0], dp[n - 1][2]) + home[n][1];
			dp[n][2] = Math.min(dp[n - 1][0], dp[n - 1][1]) + home[n][2];
		}

		// 마지막 집까지의 최소 비용 중 가장 작은 값 선택
		int minCost = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));

		System.out.println(minCost);

	}
}
