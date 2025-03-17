import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int MOD = 1000000000;

		// N자리 숫자
		long[][] dp = new long[N + 1][10];

		// 1의자리수
		for (int c = 1; c <= 9; c++) {
			dp[1][c] = 1; // 1개만 올 수 있음
		}

		for (int r = 2; r <= N; r++) {
			for (int c = 0; c <= 9; c++) {
				// 두번째 자리부터는 0~9까지 다 올 수 있음.
				if (c == 0) {
					dp[r][c] = dp[r - 1][1] % MOD; // 1에서만 올 수 있음..
				} else if (c == 9) {
					dp[r][c] = dp[r - 1][8] % MOD;
				} else {
					dp[r][c] = (dp[r - 1][c - 1] + dp[r - 1][c + 1]) % MOD;
				}
			}
		}

		long result = 0;

		for (int c = 0; c <= 9; c++) {
			result = (result + dp[N][c]) % MOD;
		}

		System.out.println(result);
	}
}