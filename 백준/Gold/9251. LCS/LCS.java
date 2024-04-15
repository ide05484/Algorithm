import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine(); // 문자열
		String str2 = br.readLine(); // 문자열

		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		for (int r = 1; r <= str1.length(); r++) { // 첫번째 문자를 돕니다
			for (int c = 1; c <= str2.length(); c++) { // 두번째 문자를 돕니다

				if (str1.charAt(r - 1) == str2.charAt(c - 1)) { // 같은게 있다면 넣어줘야해!!!
					if (r - 1 < 0) {
						dp[r][c] = 1;
						continue;
					} else { // 대각선으로의 전을 볼 수 있다면
						if (c - 1 < 0)
							continue; // 대각선 못보면 아웃

						dp[r][c] = dp[r - 1][c - 1] + 1;
					}
				} else { // 같은 게 없을 때는 비교해줘야하는데
					// str1문자열 포함이 낫냐 str2 문자열 포함이 낫냐의 싸움
					dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
				}
			}
		} // 문자 두개 다 돔

		System.out.println(dp[str1.length()][str2.length()]);
	}
}