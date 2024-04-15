import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 포도주의양
		int[] wine = new int[N + 1]; // 와인양

		for (int n = 1; n <= N; n++) {
			wine[n] = Integer.parseInt(br.readLine());
		} // 입력완

		int[] dp = new int[N + 1];
		dp[1] = wine[1];
		
		if (N > 1) {
			dp[2] = wine[1] + wine[2];
		} //2잔

		for (int i = 3; i <= N; i++) {
			// 현재 잔을 마시는 경우
			int drink = wine[i] + dp[i - 2];
			// 현재 잔을 마시지 않는 경우
			int notDrink = dp[i - 1];
			// 두 잔 연속으로 마신 경우
			drink = Math.max(drink, wine[i] + wine[i - 1] + dp[i - 3]);
			// 더 큰 값으로 dp 갱신
			dp[i] = Math.max(drink, notDrink);
		}

		System.out.println(dp[N]);

	}
}