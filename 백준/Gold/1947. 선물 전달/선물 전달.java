import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long[] dp = new long[N + 1];

		dp[1] = 0;

		if (N > 1) {

			dp[2] = 1;

			long mod = 1000000000;

			for (int i = 3; i <= N; i++) {
				dp[i] = ((dp[i - 2] + dp[i - 1]) % mod * ((i - 1) % mod)) % mod;
			}

		}

		System.out.println(dp[N]);

	}
}
