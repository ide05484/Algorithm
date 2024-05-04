import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 주어지는 숫자 (2xn 타일링)

		long[] dp = new long[N + 1]; // N+1번째 경우의 수 구하기

		dp[1] = 1;

		for (int n = 2; n < N + 1; n++) {
			if (n == 2) {
				dp[n] = 3;
				continue;
			}

			if (n % 2 == 0) {
				// 지금이 짝수일때
				dp[n] = (dp[n - 1] * 2 + 1)%10007;
			} else {
				// 지금이 홀수일때
				dp[n] = (dp[n - 1] * 2 - 1)%10007;
			}
		}//경우의수 다구하기
		System.out.println(dp[N]);
	}
}