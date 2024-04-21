import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 주어지는 경우 1 포함이다

		int[] dp = new int[N + 1]; // 거기까지 만듬

		if (N >= 2) {
			// 1이면 그냥 0출력

			for (int n = 2; n <= N; n++) {
				if (n % 2 == 0 && n % 3 == 0) {
					// 둘다 나누어 떨어질 때
					dp[n] = Math.min(dp[n / 2] + 1, dp[n / 3] + 1); // 2로 나누기 3으로 나누기
					dp[n] = Math.min(dp[n], dp[n - 1] + 1); // 1빼기
				} else if (n % 2 == 0 && n % 3 != 0) {
					// 2의 배수이지만 3의 배수는 아닐때
					dp[n] = Math.min(dp[n / 2] + 1, dp[n - 1] + 1);
				} else if (n % 2 != 0 && n % 3 == 0) {
					// 3의배수지만 2의배수는 아닐때
					dp[n] = Math.min(dp[n / 3] + 1, dp[n - 1] + 1);
				} else {
					//아무것도 아니라면
					dp[n] = dp[n-1]+1;
				}
			}
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}
}
